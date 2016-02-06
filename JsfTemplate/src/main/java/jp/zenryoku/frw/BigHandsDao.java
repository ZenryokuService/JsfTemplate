package jp.zenryoku.frw;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jp.zenryoku.frw.exceptions.BigHandsCodingRuleException;

/**
 * BigHands用DAO.
 * 必要に応じ拡張して使用する<br/>
 * 
 * @author ZenryokuService
 */
public abstract class BigHandsDao {
	/**
	 *  エンティティマネージャ
	 */
	protected EntityManager entMng;
	/**
	 * エンティティマネージャ・ファクトリー
	 */
	private EntityManagerFactory factory;
	/**
	 * コンストラクタ.
	 * EntityManager
	 */
	public BigHandsDao() {
		try {
			factory = Persistence.createEntityManagerFactory("BigHandsJTA");
			entMng = factory.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * EntityManagerを起動するための準備を行います。
	 */
	protected void setUp() {
		entMng.getTransaction().begin();
	}
	/**
	 * EntityManagerの起動後にトランザクションを閉じるなど<br/>
	 * 後処理を行う
	 */
	protected void finish() {
		entMng.getTransaction().commit();
		entMng.close();
		
	}
	protected List<Class<? extends EntityIF>> exeNamedQuery(String queryName) throws Exception {
		List<Class<? extends EntityIF>> result = null;
		try {
			setUp();
			Query que = entMng.createNamedQuery(queryName);
			result = que.getResultList();
			finish();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BigHandsCodingRuleException(e);
		}
		return result;
	}
	/**
	 * Entityの定義するテーブルデータをすべて取得する.
	 * 
	 * @param ent EntityIFを実装したエンティティ
	 * @return select * from Entity の定義するテーブルの結果
	 */
	@SuppressWarnings("unchecked")
	public <T> List<Class<? extends EntityIF>> exeFindAll(EntityIF ent) throws Exception{
		List<Class<? extends EntityIF>> result = null;
		try {
			result = exeNamedQuery(ent.findAll());
			finish();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BigHandsCodingRuleException(e);
		}
		return result;
	}
}
