package jp.zenryoku.frw.backingbean;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

import jp.zenryoku.frw.dao.MenuMSTDao;
import jp.zenryoku.frw.entity.MenuMST;
import jp.zenryoku.frw.session.SessionBean;

/**
 * ヘッダー部分の管理ビーン<br>
 * init():ログインユーザー名と、共通ヘッダメニューを表示する。
 * @author ZenryokuService
 */
@Named
public class HeaderCtl extends BackingBean {

	/**
	 * UID
	 */
	private static final long serialVersionUID = -7470050477779119598L;

	/** SessionBean */
	private SessionBean session;
	/** MenuMST */
	private List<MenuMST> menuList;

	/** MenuMSTDao */
	@Inject
	private MenuMSTDao dao;

	/** MenuBar */
	private MenuModel menuModel;

	/**
	 * ヘッダの初期表示処理を行う。
	 * ・現在のログイン状況を判別<br>
	 * ・ユーザーの権限により表示するメニューを決定、表示する<br>
	 */
	@Override
	public void init() throws Exception {
		// MenuMST検索
		selectMenuMST();
		// メニューの作成
		createMenuModel();
	}

	/**
	 * DBアクセス及び、MenuModelの作成を行う<br>
	 * 1.ユーザーの権限を検証、ログインしていないときは"AllUser"権限を指定<br>
	 * 2.各権限に対応するメニューを取得、MenuModelに設定する<br>
	 */
	private void createMenuModel() {
		menuModel = new DefaultMenuModel();
		
	}

	/**
	 * MenuMSTを取得する。
	 */
	private void selectMenuMST() throws Exception {
		if(menuList == null) {
			MenuMST menu = new MenuMST();
			menuList = dao.execute(menu);
		}
	}

	/**
	 * @return the menuModel
	 */
	public MenuModel getMenuModel() {
		return menuModel;
	}

	/**
	 * @param menuModel the menuModel to set
	 */
	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

	/**
	 * @return the session
	 */
	public SessionBean getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(SessionBean session) {
		this.session = session;
	}

	/**
	 * @return the menuList
	 */
	public List<MenuMST> getMenuList() {
		return menuList;
	}

	/**
	 * @param menuList the menuList to set
	 */
	public void setMenuList(List<MenuMST> menuList) {
		this.menuList = menuList;
	}

	/**
	 * @return the dao
	 */
	public MenuMSTDao getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(MenuMSTDao dao) {
		this.dao = dao;
	}
	
}
