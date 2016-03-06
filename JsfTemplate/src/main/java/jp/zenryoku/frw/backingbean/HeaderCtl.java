package jp.zenryoku.frw.backingbean;

import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

import jp.zenryoku.frw.entity.MenuMST;

/**
 * ヘッダー部分の管理ビーン<br>
 * init():ログインユーザー名と、共通ヘッダメニューを表示する。
 * @author ZenryokuService
 */
public class HeaderCtl implements BackingBeanIF {

	/** MenuMST */
	private MenuMST menu;
	/**
	 * UID
	 */
	private static final long serialVersionUID = -7470050477779119598L;

	/** MenuBar */
	private MenuModel menuModel;

	/**
	 * ヘッダの初期表示処理を行う。
	 * ・現在のログイン状況を判別<br>
	 * ・ユーザーの権限により表示するメニューを決定、表示する<br>
	 */
	@Override
	public void init() {
		// MenuModelのインスタンスがない場合インスタンスを生成
		if(menuModel == null) {
			menuModel = new DefaultMenuModel();
		}
		
		
	}

	/**
	 * DBアクセス及び、MenuModelの作成を行う<br>
	 * 1.ユーザーの権限を検証、ログインしていないときは"AllUser"権限を指定<br>
	 * 2.各権限に対応するメニューを取得、MenuModelに設定する<br>
	 */
	private void createMenuModel() {
		
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
