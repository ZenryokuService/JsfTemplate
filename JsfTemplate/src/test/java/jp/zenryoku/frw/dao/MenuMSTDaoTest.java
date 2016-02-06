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
	/**
	 * 引数の値を確認するためのメソッド。
	 * @param o 内容を確認するたオブエジェクト
	 */
	private void chkValues(Object o) {
		// 値の取得確認
		assertNotNull(o);
		// Listの場合
		if (o instanceof List) {
			List list = (List) o;
			// 0件取得チェック
			assertNotSame(0, list.size());
			for (Object obj : list) {
				System.out.println("ListValue:" + obj);
			}
		} else {
			System.out.println("ObjectValue:" + o);
		}
	}
	/**
	 * CASE:1. データの取得を確認する
	 */
	public void testMenuMST() {
		List<Class<? extends EntityIF>> list = null;
		try {
			list  = dao.exeFindAll(menu);
			assertNotNull(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * CASE:2. role_idを指定しての取得(MenuMST.getAllRole)
	 */
	public void testMenuMST2() {
		List<Class<? extends EntityIF>> list = null;
		try {
			list  = dao.getAllRole();
			assertNotNull(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
