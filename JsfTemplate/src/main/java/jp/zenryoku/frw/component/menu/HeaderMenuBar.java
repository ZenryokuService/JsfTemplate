package jp.zenryoku.frw.component.menu;

import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

/**
 * このフレームワークで使用する、基本のヘッダメニューモデル<br>
 * 
 * @author ZenryokuService
 */
public class HeaderMenuBar {
	/** 表示するMenuModel */
	private MenuModel menu;

	/**
	 * ヘッダメニューモデルの作成を行います<br>
	 */
	public HeaderMenuBar() {
		// MenuModel実装クラス
		menu = new DefaultMenuModel();
	}
}
