package jp.zenryoku.frw.exceptions;

import java.io.Serializable;

/**
 * ServletFilterでの処理中に起きたException
 * @author ZenryokuService
 */
public class ServletFilterException extends Exception implements Serializable{

	/**
	 * UID
	 */
	private static final long serialVersionUID = -1826727299125244683L;

	/**
	 * デフォルトコンストラクタ
	 */
	public ServletFilterException() {
		super();
	}
	/**
	 * メッセージ登録、コンストラクタ
	 */
	public ServletFilterException(String mes) {
		super(mes);
	}
}
