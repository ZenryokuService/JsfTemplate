package jp.zenryoku.frw.backingbean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuGroup;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.model.menu.MenuItem;

import jp.zenryoku.frw.BigHandsConstants;
import jp.zenryoku.frw.dao.MenuMSTDao;
import jp.zenryoku.frw.entity.MenuMST;
import jp.zenryoku.frw.exceptions.BigHandsCodingRuleException;
import jp.zenryoku.frw.session.SessionBean;

/**
 * ヘッダー部分の管理ビーン<br>
 * init():ログインユーザー名と、共通ヘッダメニューを表示する。
 * 
 * @author ZenryokuService
 */
@Named
@RequestScoped
public class HeaderCtl extends BackingBean {

	/**
	 * UID
	 */
	private static final long serialVersionUID = -7470050477779119598L;

	/** StatusFlg */
	private Integer LOGIN_STATUS;

	/** SessionBean */
	private SessionBean session;

	/** Login Flag */
	private boolean loginFlg;

	/** MenuMST */
	private List<MenuMST> menuList;

	/** MenuMSTDao */
	@Inject
	private MenuMSTDao dao;

	/** MenuBar */
	private MenuModel menuModel;

	/**
	 * デフォルトコンストラクタ<br>
	 * 初期表示時にコンストラクタが起動する<br>
	 * ログインステータスをNO_LOGINに設定する。
	 */
	public HeaderCtl() {
		this.LOGIN_STATUS = BigHandsConstants.LOGIN_STATUS_NO_LOGIN;
	}

	/**
	 * ヘッダの初期表示処理を行う。 ・現在のログイン状況を判別<br>
	 * ・ユーザーの権限により表示するメニューを決定、表示する<br>
	 * ・ログインしていないときは権限レベル最低で取得する
	 */
	@Override
	public void init() throws Exception {
		// MenuMST検索
		selectMenuMST();
		// メニューの作成
		createMenuModel();
		// 各コンポーネントにIDを振る
		menuModel.generateUniqueIds();
	}

	/**
	 * DBアクセス及び、MenuModelの作成を行う<br>
	 * 0.前提として、メニュー情報は取得済みとする 1.ユーザーの権限を検証、ログインしていないときは"AllUser"権限を指定<br>
	 * 2.各権限に対応するメニューを取得、MenuModelに設定する<br>
	 */
	private void createMenuModel() throws Exception {
		System.out.println("*** createMenuModel ***");
		menuModel = new DefaultMenuModel();
		Map<Integer, DefaultMenuItem> itemMap = new HashMap<Integer, DefaultMenuItem>();
		// tmpMap for SubMenu, Map<menuId, MenuMST>
		Map<Integer, DefaultSubMenu> subMap = new HashMap<Integer, DefaultSubMenu>();
		putMaps(itemMap, subMap);
		// Set MenuModel
		
	}

	/**
	 * MenuMSTを取得する。<br>
	 * menuListがNullでない場合に取得を行う<br>
	 * ただログインフラグが立っているときは改めて検索を行う
	 */
	private void selectMenuMST() throws Exception {
		if (menuList == null && loginFlg == false) {
			MenuMST menu = new MenuMST();
			menuList = dao.execute(menu);
		} else if (menuList != null && loginFlg == true) {
			// TODO-[ログイン後にメニューを入れ替える処理の実装予定]
			throw new BigHandsCodingRuleException("未実装です、のちに実装予定:HeaderCtl.selectMenuMST()");
		} else {
			throw new BigHandsCodingRuleException("ログインフラグとメニューの整合性が取れていません:menuList == null / loginFlag == ture");
		}
	}

	/**
	 * メニュー情報よりメニューアイテムを作成する<br>
	 * 注意：ラムダ式は例外処理ができない
	 * 
	 * @param menu MenuMSTデータ
	 * @return 作成したメニューアイテム（リンクなどのアクションを起こすメニュー）
	 */
	private DefaultMenuItem createMenuItem(MenuMST menu) throws Exception {
		DefaultMenuItem item = new DefaultMenuItem(menu.getMenuName());
		// メニューの作成、サブメニューの登録
		switch (menu.getMenuType()) {
		// リンク用のメニュー
		case BigHandsConstants.LINK_MENU:
			item.setUrl(menu.getMenuValue());
			break;
		// 子画面起動のメニュー
		case BigHandsConstants.CHILD_WIN_MENU:
			item = new DefaultMenuItem(menu.getMenuName());
			break;
		// 画面を切り替えるメニュー
		case BigHandsConstants.AJAX_WIN_MENU:
			item = new DefaultMenuItem(menu.getMenuName());
			break;
		default:
			throw new BigHandsCodingRuleException("想定外のメニュータイプです:" + menu.getMenuType());
		}
		return item;
	}

	/**
	 * ListのMenuMSTを仕分けして、Mapに登録
	 * 
	 * @param menuMap MenuModelに登録する(MenuBarに表示)
	 * @param subMap サブメニューとして表示するメニューを登録する
	 */
	private void putMaps(Map<Integer, DefaultMenuItem> itemMap, Map<Integer, DefaultSubMenu> subMap) throws Exception {
		// マップの仕分けを行う
		for (MenuMST menu : menuList) {
			// 親メニュー
			if(menu.getMenuType() == BigHandsConstants.PARENT_MENU) {
				DefaultSubMenu subMenu = new DefaultSubMenu(menu.getMenuName());
				subMap.put(menu.getMenuMstId(), subMenu);
				continue;
			}
			// その他のメニュー
			DefaultMenuItem item = createMenuItem(menu);
			itemMap.put(menu.getMenuMstId(), item);
		}
		// 
	}

	/// Getter and Setters ////
	/**
	 * @return the menuModel
	 */
	public MenuModel getMenuModel() {
		return menuModel;
	}

	/**
	 * @param menuModel
	 *            the menuModel to set
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
	 * @param session
	 *            the session to set
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
	 * @param menuList
	 *            the menuList to set
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
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(MenuMSTDao dao) {
		this.dao = dao;
	}

	/**
	 * @return the loginFlg
	 */
	public boolean isLoginFlg() {
		return loginFlg;
	}

	/**
	 * @param loginFlg
	 *            the loginFlg to set
	 */
	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}

}
