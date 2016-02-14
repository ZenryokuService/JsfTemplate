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
	 * テストのセットアップ<br/>
	 */
	@Before
	public void setUpCLass() {		
		System.out.println("*** setUp ***");
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
	@Test
	public void test01() {
		System.out.println("test1");
		EntityManager em = Persistence.createEntityManagerFactory("BigHandsNonJta").createEntityManager();
		em.getTransaction().begin();
		Query q = em.createNativeQuery("select 1 from dual");
		Integer i = q.getFirstResult();
		assertNotNull(i);
		em.close();
		
		
	}
//	/**
//	 * CASE:1. データの取得を確認する
//	 */
//	public void testMenuMST() {
//		List<MenuMST> list = new ArrayList<MenuMST>();
//		
//		try {
//			assertNotNull(menu);
//			List<EntityIF> entList  = dao.exeFindAll(menu);
//			assertNotNull(entList);
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
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
