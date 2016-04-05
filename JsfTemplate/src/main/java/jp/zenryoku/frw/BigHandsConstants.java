package jp.zenryoku.frw;

/**
 * このプレームワークで使用する、定数クラス<br>
 * 各種プロパティは列挙型を使用する
 * 
 * @author ZenryokuService
 */
public class BigHandsConstants {
	//// LoginStatus判別で使用する ////
	/** ログイン状態を示す */
	public static final Integer LOGIN_STATUS_LOGGED_IN = 0;
	/** ログインしていない状態を示す */
	public static final Integer LOGIN_STATUS_NO_LOGIN = 1;
	

	//// Checkerで使用する定数 ////
	/** ドット */
	public static final String DOT = ".";

	//// PropertyUtilで使用する ////
	/** プロパティファイルのルートディレクトリ */
	public static final String ROOT_DIR = "META-INF/";
	/** XMLの拡張子 */
	public static final String XML = "xml";
	/** PROPERTYファイルの拡張子 */
	public static final String PROPS = "properties";
	/** Filterクラスのパッケージ */
	public static final String FILTERS = "jp.zenryoku.frw.servlet.filter";

	//// MenuMSTの値を判定する ////
	/** リンク用のメニュー */
	public static final int LINK_MENU = 0;
	/** 親メニュー（子メニューを持つメニュー） */
	public static final int PARENT_MENU = 1;
	/** 子メニュー(親メニューのIDを保持している) */
	public static final int CHILD_MENU = 9;
	/** 子画面を起動するメニュー */
	public static final int CHILD_WIN_MENU = 2;
	/** 画面を切り替えるメニュー */
	public static final int AJAX_WIN_MENU = 3;
}
