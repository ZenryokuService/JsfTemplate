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
		factory.close();
	}
	/**
	 * EntityManagerの起動後にトランザクションを閉じるなど<br/>
	 * 後処理を行う
	 */
	protected void finish() {
		entMng.getTransaction().commit();
		entMng.close();
		
	}
	/**
	 * Entityの定義するテーブルデータをすべて取得する.
	 * 
	 * @param ent EntityIFを実装したエンティティ
	 * @return select * Entityの定義するテーブルの結果
	 */
	@SuppressWarnings("unchecked")
	public List<EntityIF> exeFindAll(EntityIF ent) throws Exception{
		List<EntityIF> result = null;
		try {
			setUp();
			Query que = entMng.createNamedQuery(ent.findAll());
			result = que.getResultList();
			finish();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BigHandsCodingRuleException(e);
		}
		return result;
	}
}
