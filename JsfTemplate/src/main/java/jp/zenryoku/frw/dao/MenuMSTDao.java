package jp.zenryoku.frw.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import jp.zenryoku.frw.BigHandsDao;
import jp.zenryoku.frw.EntityIF;
import jp.zenryoku.frw.entity.MenuMST;

/**
 * MenuMSTのデータを取得するためのDAOクラス<br/>
 * MenuMSTクラスとセットにして仕様する
 * 
 * @author ZenryokuService
 */
public class MenuMSTDao extends BigHandsDao {
	/**
	 * コンストラクタ
	 */
	public MenuMSTDao() {
		super();
	}
	/**
	 * コンストラクタ:単体テスト用
	 */
	public MenuMSTDao(EntityManagerFactory fa) {
		super(fa);
	}
	/**
	 * 権限レベルが９以上( < 9)データを取得する<br/>
	 * 
	 * @return 検索結果
	 * @throws Exception 想定外のエラー
	 */
	public <T> List<T> getAllRole(T cls) throws Exception {
		List<T> res = exeNamedQuery(MenuMST.GET_ALL_ROLE, cls);
//		list.add
		return res;
	}
	/**
	 * 取得したメニューをソートして<br/>
	 * ユーザー権限,に対応するメニューを取得する
	 */
	@Override
	public List<EntityIF> exeQuery(EntityIF entList){
		return null;
	}
}
