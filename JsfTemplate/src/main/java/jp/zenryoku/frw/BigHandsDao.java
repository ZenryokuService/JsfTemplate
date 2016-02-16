package jp.zenryoku.frw;

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
 * 必要に応じ拡張して使用する<br>
 * 
 * @author ZenryokuService
 */
@RequestScoped
@Transactional
public abstract class BigHandsDao {
	/**
	 *  エンティティマネージャ
	 */
	@PersistenceContext(unitName="BigHandsJTA")
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
	 * コンストラクタ.
	 * @param emFactory 単体テスト用に手動で生成したもの
	 */
	public BigHandsDao(EntityManagerFactory emFactory) {
		try {
			factory = emFactory;
			entMng = emFactory.createEntityManager();
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
	 * EntityManagerの起動後にトランザクションを閉じるなど<br>
	 * 後処理を行う
	 */
	public void finish() {
		entMng.close();
		factory.close();
		entMng = null;
		factory = null;
	}
	/**
	 * 子クラスで仕様するためのメソッド<br>
	 * クエリ名を引数に対象のJPQLを実行する
	 * @param queryName クエリ名
	 * @return 取得結果
	 * @throws Exception 想定外のエラー
	 */
	protected <T> List<T> exeNamedQuery(String queryName, T cls) throws Exception {
		List<T> result = null;
		try {
			setUp();
			Query que = entMng.createNamedQuery(queryName, EntityIF.class);
			result = que.getResultList();
			entMng.getTransaction().commit();
			finish();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BigHandsCodingRuleException(e);
		}
//		try {
//			for (Class<? extends EntityIF> ent : result) {
//				EntityIF inter = (EntityIF) ent;
//				result.add(inter);
//			}
//		} catch (ClassCastException e) {
//			e.printStackTrace();
//		}
		return result;
	}
	/**
	 * Entityの定義するテーブルデータをすべて取得する<br>
	 * select * from Entity の定義するテーブルの結果を返却する。
	 * @param ent EntityIFを実装したエンティティ
	 * @return 検索結果
	 * @throws Exception JPAに関する想定外のエラー
	 */
	public List<EntityIF> exeFindAll(EntityIF ent) throws Exception{
		List<EntityIF> result = null;
		
		try {
			result = exeNamedQuery(ent.findAll(), ent);
			finish();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BigHandsCodingRuleException(e);
		}
		return result;
	}
	/**
	 * 子クラスで実装するメソッド<br>
	 * リスト内のEntityIFを対象クラスへキャスト、設定する、返却
	 * @param ent 対象データのEntity
	 * @return　検索結果List
	 */
//	public abstract List<EntityIF> exeQuery(EntityIF ent);
}
