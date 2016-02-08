package jp.zenryoku.frw.dao;

import java.util.ArrayList;
import java.util.List;

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
	 * 権限レベルが９以上( < 9)データを取得する<br/>
	 * 
	 * @return 検索結果
	 * @throws Exception 想定外のエラー
	 */
	public List<MenuMST> getAllRole() throws Exception {
		List<EntityIF> res = exeNamedQuery(MenuMST.GET_ALL_ROLE);
		return convertMenuMSTList(res);
	}
	/**
	 * 
	 * @param entList
	 * @return
	 */
	private List<MenuMST> convertMenuMSTList(List<EntityIF> entList) {
		ArrayList<MenuMST> result = new ArrayList<MenuMST>();
		for (EntityIF cls : entList) {
			result.add((MenuMST) cls);
		}
		return result;
	}
	/**
	 * 取得したメニューをソートして<br/>
	 * ユーザー権限,に対応するメニューを取得する
	 */
}
