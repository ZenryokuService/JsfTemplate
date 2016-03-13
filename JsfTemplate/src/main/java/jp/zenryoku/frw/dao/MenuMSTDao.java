package jp.zenryoku.frw.dao;

import java.sql.SQLException;
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
public class MenuMSTDao extends BigHandsDao<MenuMST> {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 2111640869520096709L;

	/**
	 * SQL作成のメソッド、実行処理はスーパークラスで行う。
	 */
	@Override
	public List<MenuMST> execute(MenuMST ent) throws SQLException, Exception {
		return executeQuery(ent, MenuMST.FIND_ALL);
	}


}
