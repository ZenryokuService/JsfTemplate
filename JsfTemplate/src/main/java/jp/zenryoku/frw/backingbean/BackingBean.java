package jp.zenryoku.frw.backingbean;

import java.io.Serializable;

import javax.persistence.EntityManager;

import jp.zenryoku.frw.BigHandsDao;
/**
 * 管理ビーンに実装するインターフェース.
 * 1.init():初期化メソッド<br>
 * 2.dao   :全てのバッキングビーンで使用するDAOクラス<br>
 * 
 * @author ZenryokuService
 */
public abstract class BackingBean implements Serializable {
	/**
	 * スーパーDAOクラス
	 */
	protected BigHandsDao dao;
	/**
	 *  子クラスで実装する、初期化メソッド
	 */
	public abstract void init() throws Exception;
}
