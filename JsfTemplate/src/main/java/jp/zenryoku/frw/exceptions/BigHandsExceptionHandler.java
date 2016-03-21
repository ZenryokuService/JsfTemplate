package jp.zenryoku.frw.exceptions;

import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import javax.faces.FacesException;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import org.glassfish.api.logging.LogLevel;

public class BigHandsExceptionHandler extends ExceptionHandlerWrapper {
	/** ロガー */
	private static final Logger logger = Logger.getLogger(BigHandsExceptionHandler.class.getName());
	/** ExceptionHandlerWeapper */
	private ExceptionHandler wrap;

	/**
	 * コンストラクタ
	 * 
	 * @param handle
	 *            ラップされるException
	 */
	public BigHandsExceptionHandler(ExceptionHandler handle) {
		this.wrap = handle;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return this.wrap;
	}

	/**
	 * エクセプションハンドル
	 */
	public void handle() throws FacesException {
		System.out.println("BigHandsExceptionHandler");
		// ExceptionQueuedEvents
		final Iterator<ExceptionQueuedEvent> i = this.getUnhandledExceptionQueuedEvents().iterator();
		while (i.hasNext()) {
			ExceptionQueuedEvent event = i.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
			// get the exception from context
			Throwable t = context.getException();
			final FacesContext fc = FacesContext.getCurrentInstance();
			final ExternalContext externalContext = fc.getExternalContext();
			final Map<String, Object> requestMap = fc.getExternalContext().getRequestMap();
			final ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication()
					.getNavigationHandler();
			// here you do what ever you want with exception
			try {
				// log error ?
				logger.log(LogLevel.WARNING, "Severe Exception Occured");
				// log.log(Level.SEVERE, "Critical Exception!", t);
				// redirect error page
				requestMap.put("exceptionMessage", t.getMessage());
				nav.performNavigation("/error.xhtml");
				fc.renderResponse();
				// remove the comment below if you want to report the error in a
				// jsf error message
				// JsfUtil.addErrorMessage(t.getMessage());
			} finally {
				// remove it from queue
				i.remove();
			}
		}
		// parent hanle
		getWrapped().handle();
	}
}
