package jp.zenryoku.frw.exceptions;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 * ExceptionHandlerクラス<br>
 * Exceptionハンドルに使用するクラスを返却する<br>
 * web.xml参照
 * @author ZenryokuService
 */
public class BigHandsExceptionHandlerFactory extends ExceptionHandlerFactory{

	/** parent Factory */
	private ExceptionHandlerFactory parent;

	/**
	 * コンストラクタ
	 */
	public BigHandsExceptionHandlerFactory(ExceptionHandlerFactory parent) {
		this.parent = parent;
	}
	
	@Override
	public ExceptionHandler getExceptionHandler() {
		return new BigHandsExceptionHandler(parent.getExceptionHandler());
	}

}
