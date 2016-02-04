package jp.zenryoku.frw.dao;

import java.util.List;

import jp.zenryoku.frw.EntityIF;
import jp.zenryoku.frw.entity.MenuMST;
import junit.framework.TestCase;

/**
 * MenuMSTDaoのテストクラス
 * 
 * @author ZenryokuService
 */
public class MenuMSTDaoTest extends TestCase {
	/** エンティティ */
	private MenuMST menu;
	/** テスト対象 */
	private MenuMSTDao dao;
	/**
	 * テストのセットアップ<br/>
	 */
	public void setUp() {
		menu = new MenuMST();
		dao = new MenuMSTDao();
	}
	public void testMenuMST() {
		List<Class<? extends EntityIF>> list = null;
		try {
			list  = dao.exeFindAll(menu);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
