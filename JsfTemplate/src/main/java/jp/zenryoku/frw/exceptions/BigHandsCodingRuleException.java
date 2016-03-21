package jp.zenryoku.frw.exceptions;

import java.io.Serializable;

/**
 * BigHandsフレームワークの仕様に合わない実装、設定を行っている時にthrowされる
 */
@SuppressWarnings("serial")
public class BigHandsCodingRuleException extends Exception implements Serializable{
	/**
	 * Exceptionを引き渡すコンストラクタ
	 * @param e 引き継ぐException
	 */
	public BigHandsCodingRuleException(Exception e) {
		super(e);
	}
	/**
	 * エラーメッセージを設定する
	 * @param st エラーメッセージ
	 */
	public BigHandsCodingRuleException(String st) {
		super(st);
	}
}
