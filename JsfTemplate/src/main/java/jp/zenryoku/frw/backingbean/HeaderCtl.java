package jp.zenryoku.frw.backingbean;

import java.util.List;

import javax.inject.Inject;

import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

import jp.zenryoku.frw.dao.MenuMSTDao;
import jp.zenryoku.frw.entity.MenuMST;

/**
 * ヘッダー部分の管理ビーン<br>
 * init():ログインユーザー名と、共通ヘッダメニューを表示する。
 * @author ZenryokuService
 */
public class HeaderCtl extends BackingBean {

	/**
	 * UID
	 */
	private static final long serialVersionUID = -7470050477779119598L;

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
}
