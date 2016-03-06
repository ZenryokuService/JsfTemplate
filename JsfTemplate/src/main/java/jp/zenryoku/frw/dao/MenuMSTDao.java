package jp.zenryoku.frw.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import jp.zenryoku.frw.BigHandsDao;
import jp.zenryoku.frw.EntityIF;
import jp.zenryoku.frw.entity.MenuMST;

/**
 * MenuMSTのデータを取得するためのDAOクラス<br>
 * MenuMSTクラスとセットにして仕様する
 * 
 * @author ZenryokuService
 */
@Stateless
public class MenuMSTDao extends BigHandsDao {
	/**
	 * コンストラクタ
	 */
	public MenuMSTDao() {
		super();
	}
	/**
	 * コンストラクタ:単体テスト用
	 * 
	 * @param fa　エンティティマネージャをプロパティ指定して取得する
	 */
	public MenuMSTDao(EntityManagerFactory fa) {
		super(fa);
	}
	/**
	 * 権限レベルが９以上( < 9)データを取得する<br>
	 * 
	 * @param cls　エンティティクラス
	 * @return 検索の結果
	 * @throws Exception JPQL実行中の想定外エラー
	 */
	public <T> List<T> getAllRole(T cls) throws Exception {
		List<T> res = exeNamedQuery(MenuMST.GET_ALL_ROLE, cls);
//		list.add
		return res;
	}
	/**
	 * 取得したメニューをソートして<br>
	 * ユーザー権限,に対応するメニューを取得する
	 */
	public List<MenuMST> selectMenu(MenuMST ent) {
		
		return null;
	}
	public List<EntityIF> exeQuery(EntityIF ent){
		return null;
	}
}
