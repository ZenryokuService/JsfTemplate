package jp.zenryoku.bighands.gmap;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import jp.zenryoku.frw.backingbean.BackingBean;
import jp.zenryoku.frw.component.menu.HeaderMenuBar;
/**
 * GooleMap画面の管理ビーン<br>
 * @author ZenryokuService
 */
@Named("gmapBean")
@SuppressWarnings("serial")
public class GmapBean extends BackingBean {
	/** ヘッダメニュー　*/
	private HeaderMenuBar headMenu;

	/**
	 * 
	 */
	public GmapBean() {
	}
	/**
	 * 初期化メソッド
	 */
	@Override
	public void init() {
		//1.HeaderMenu作成
		
	}
}
