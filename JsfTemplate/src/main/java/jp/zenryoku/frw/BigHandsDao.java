package jp.zenryoku.frw;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import jp.zenryoku.frw.exceptions.BigHandsCodingRuleException;
import jp.zenryoku.frw.interceptor.LogAnno;

/**
 * BigHands用DAO.
 * DBアクセス時に使用するスーパーDAOクラス<br>
 * EntityManagerの管理、EntityManagerFactoryの管理を行う<br>
 * 
 * @author ZenryokuService
 */
@LogAnno
@Named
@SuppressWarnings("serial")
@Stateless
public abstract class BigHandsDao<T extends EntityIF> implements Serializable {
	/**
	 * 全てのDAOクラスで使用するEntityManager
	 */
	protected EntityManager em;
	/**
	 * EntityManagerFactory<br>
	 * このクラスで管理する
	 */
	private EntityManagerFactory factory;
	/**
	 * コンストラクタ<br>
	 * 1.EntityManagerの取得を行う<br>
	 */
	public BigHandsDao() {
		if(factory == null) {
			System.out.println("*** Create EntityManagerFactory ***");
			// EntityManager作成
			createEntityManager();
		}
	}
	@PreDestroy
	public void destroy() {
		System.out.println("*** PreDestroy ***");
		factory.close();
	}
	/**
	 * EntityManagerを生成<br>
	 * 単体テストモードと通常起動モードを指定できる<br>
	 * @return EntityManager エンティティマネージャ
	 */
	private void createEntityManager() {
		System.out.println("*** BigHandsDao.createEntityManager ***");
		factory = Persistence.createEntityManagerFactory("BigHandsJTA");
		em = factory.createEntityManager();
	}

	/**
	 * トランザクションの開始などSQL実行<br>
	 */
	@SuppressWarnings("unchecked")
	protected List<T> executeQuery(T ent, String namedQuery) throws SQLException, Exception {
		System.out.println("*** BigHandsDao.executeQuery ***");
		// エラーフラグ
		boolean errFlg = false;
		List<T> res = null;
		// トランザクション開始
		em.getTransaction().begin();
		// 子クラスで実行するメソッド
		try {
			Query q = em.createNamedQuery(namedQuery, ent.getClass());
			res = q.getResultList();
			em.close();
		} catch(Exception e) {
			errFlg = true;
			if(e instanceof SQLException) {
				// TODO-[Implement ExceptionHandle]
				System.out.println("*** in SQLException at executeQuery() ***"); 
				e.printStackTrace();
			} else if(e instanceof Exception) {
				// TODO-[Implement ExceptionHandle]
				System.out.println("*** in Exception at executeQuery() ***"); 
				e.printStackTrace();
			} else {
				e.printStackTrace();
			}
		} finally {
			// エラーフラグTrue時はロールバック
			if(errFlg) {
				em.getTransaction().rollback();
			}
		}
		if(res == null || res.size() <= 0) {
			throw new BigHandsCodingRuleException("MenuMSTが取得できませんでした");
		}
		return res;
	}
	/**
	 * こクラスで実装する、DBアクセス処理メソッド
	 */
	public abstract List<T> execute(T ent) throws Exception;
}
