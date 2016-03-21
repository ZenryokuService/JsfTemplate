package jp.zenryoku.frw.exceptions;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * エラーハンドル用管理ビーン
 * @author ZenryokuService
 */
@Named
@RequestScoped
public class ExceptionBean {
	/** メッセージ取得用のプレフィックス */
	private static final String PREF = "javax.servlet.error.";
	/** エラー時のステータスコード取得用の文字列 */
	private static final String STATUS_CODE = PREF + "status_code";
	/** エラー時のメッセージ取得用の文字列 */
	private static final String MESSAGE = PREF + "message";
	/** エラー時のエクセプションタイプ取得用の文字列 */
	private static final String EXCEPTION_TYPE = "exception_type";
	/** エラー時のエクセプション取得用の文字列 */
	private static final String EXCEPTION = "exception";
	/** エラー時のリクエストURI取得用の文字列 */
	private static final String REQUEST_URI = "request_uri";

	/**
	 * ステータスコードを取得する。
	 * @return String ステータスコード
	 */
	public String getStatusCd() {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(STATUS_CODE).toString();
	}
	/**
	 *エラーメッセージを取得する。
	 *@return String エラーメッセージ
	 */
	public String getMessage() {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(MESSAGE).toString();
	}
	/**
	 * エクエスプションタイプの取得。
	 * @return String エクセプションタイプ
	 */
	public String getExceptionType() {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(EXCEPTION_TYPE).toString();
	}
	/**
	 * エクセプションを取得。
	 * @return Exception エクセプションクラス
	 */
	public Exception getException() {
		return (Exception) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(EXCEPTION);
	}
	/**
	 * リクエストされたURIを取得する。
	 * @return String URI
	 */
	public String getUri() {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(REQUEST_URI).toString();
	}
}
