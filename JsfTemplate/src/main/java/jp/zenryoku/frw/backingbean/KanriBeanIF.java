package jp.zenryoku.frw.backingbean;

import java.io.Serializable;
/**
 * 管理ビーンに実装するインターフェース<br/>
 * 1.init():初期化メソッド
 * @author yogotakumi
 */
public interface KanriBeanIF extends Serializable {
	/** 初期化メソッド */
	public void init();
}
