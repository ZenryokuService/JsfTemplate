package jp.zenryoku.frw;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import jp.zenryoku.frw.exceptions.BigHandsCodingRuleException;

/**
 * BigHands用DAO.
 * DBアクセス時に使用するスーパーDAOクラス<br>
 * EntityManagerの管理、EntityManagerFactoryの管理を行う<br>
 * 
 * @author ZenryokuService
 */
@SuppressWarnings("serial")
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
		// EntityManager作成
		createEntityManager();
	}

	/**
	 * EntityManagerを生成<br>
	 * 単体テストモードと通常起動モードを指定できる<br>
	 * @return EntityManager エンティティマネージャ
	 */
	private void createEntityManager() {
		factory = Persistence.createEntityManagerFactory("BigHandsJTA");
		em = factory.createEntityManager();
	}

	/**
	 * トランザクションの開始などSQL実行<br>
	 */
	@SuppressWarnings("unchecked")
	protected List<T> executeQuery(T ent, String namedQuery) throws SQLException, Exception {
		// エラーフラグ
		boolean errFlg = false;
		List<T> res = null;
		// トランザクション開始
		em.getTransaction().begin();
		// 子クラスで実行するメソッド
		try {
			Query q = em.createNamedQuery(namedQuery, ent.getClass());
			res = q.getResultList();
		} catch(Exception e) {
			errFlg = true;
			if(e instanceof SQLException) {
				// TODO-[Implement ExceptionHandle]
			} else if(e instanceof Exception) {
				// TODO-[Implement ExceptionHandle]
			} else {
				e.printStackTrace();
			}
		} finally {
			// エラーフラグTrue時はロールバック
			if(errFlg) {
				em.getTransaction().rollback();
			}
			factory.close();
		}
		return res;
	}
	/**
	 * こクラスで実装する、DBアクセス処理メソッド
	 */
	public abstract List<T> execute(T ent) throws Exception;
}
