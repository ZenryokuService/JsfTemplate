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

	@Override
	public ExceptionHandler getExceptionHandler() {
		System.out.println("*** BigHandsExceptionHandler ***");
		return null;
	}

}
