package jp.zenryoku.frw.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import static org.junit.Assert.*;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import jp.zenryoku.frw.EntityIF;
import jp.zenryoku.frw.entity.MenuMST;

/**
 * MenuMSTDaoのテストクラス
 * 
 * @author ZenryokuService
 */
@RunWith(JUnit4.class)
public class MenuMSTDaoTest {
	/** エンティティ */
	private MenuMST menu;
	/** テスト対象 */
	private MenuMSTDao dao;
	/** EntityManagerFactroy */
	private EntityManagerFactory factory;
	/** EntityManager */
	private EntityManager em;
	/**
	 * persistence.xmlを読み込む
	 * @return Context persistence.xmlを読み込んだクラス
	 */
	private Properties getEnv() {
		Properties p = new Properties();
		InputStream inp = ClassLoader.getSystemResourceAsStream("META-INF/persistence.xml");
		assertNotNull(inp);
		try {
			p.load(inp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}
	/**
	 * テストのセットアップ<br>
	 */
	@Before
	public void setUpCLass() {		
		System.out.println("*** setUp ***");
		em = Persistence.createEntityManagerFactory("BigHandsNonJta").createEntityManager();
		em.getTransaction().begin();
		if (menu == null) {
			menu = new MenuMST();
		}
		if (dao == null) {
			Properties prop = getEnv();
			factory = Persistence.createEntityManagerFactory("BigHandsNonJta", prop);
			dao = new MenuMSTDao(factory);
		}
	}
	@After
	public void tearDown() {
		dao.finish();
		System.out.println("*** finish ***");
	}
	/**
	 * 引数の値を確認するためのメソッド。
	 * @param o 内容を確認するたオブエジェクト
	 */
	private void chkValues(Object o) {
		// 値の取得確認
		assertNotNull(o);
		System.out.println("*** Object " + o.toString() + "***");
		// Listの場合
		if (o instanceof List) {
			List list = (List) o;
			// 0件取得チェック
			assertNotSame(0, list.size());
			for (Object obj : list) {
				if (obj instanceof MenuMST) {
					MenuMST menu = (MenuMST) obj;
					System.out.println("MenuName:" + menu.getMenuName());
				}
			}
		} else {
			System.out.println("ObjectValue:" + o);
		}
	}
	/**
	 * 接続、取得のテスト
	 */
	@Test
	public void test01() {
		System.out.println("*** test01 ***");
		MenuMST menu = new MenuMST();
		try {
			Query q = em.createNamedQuery(menu.findAll(), MenuMST.class);
			List<EntityIF> list = q.getResultList();
			em.clear();
			assertNotNull(list);
			chkValues(list);
		} catch(Exception e) {
			e.printStackTrace();
		}
		em.close();
	}
	/**
	 * CASE:1. データの取得を確認する
	 */
	public void testMenuMST() {
		System.out.println("*** Case1 ***");
		try {
			assertNotNull(menu);
			List<MenuMST> entList  = dao.getAllRole(menu);
			assertNotNull(entList);
			em.clear();
			chkValues(entList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	/**
//	 * CASE:2. role_idを指定しての取得(MenuMST.getAllRole)
//	 */
//	public void testMenuMST2() {
//		List<MenuMST> list = null;
//		try {
//			list  = dao.getAllRole(menu);
//			assertNotNull(list);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
