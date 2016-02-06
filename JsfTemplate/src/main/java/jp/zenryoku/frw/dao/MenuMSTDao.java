package jp.zenryoku.frw.dao;

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
@NamedQueries({
		@NamedQuery(name="MenuMST.findAll", query="select * from MenuMST m")
})
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
	public List<Class<? extends EntityIF>> getAllRole() throws Exception {
		return exeNamedQuery(MenuMST.GET_ALL_ROLE);
	}
}
