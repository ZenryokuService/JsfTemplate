package jp.zenryoku.frw.servlet.filter;

import java.lang.annotation.Annotation;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import jp.zenryoku.frw.annotation.FilterAnnoIF;
import jp.zenryoku.frw.annotation.FilterAnnotation;

/**
 * リクエストをハンドルする<br>
 * ServletFilterから呼び出され、下記の情報を取得する<br>
 * 1. リクエスト元<br>
 * 2. アクセスしたデバイス<br>
 * 3. アクセスした時間<br>
 * 4. ブラウザなどのその他ヘッダー情報<br>
 * @author ZenryokuService
 */
@FilterAnnotation(name="RequestHandlerFilter")
@SuppressWarnings("serial")
public class RequestHandlerFilter implements FilterAnnoIF{
	/**
	 * コンストラクタ
	 */
	public RequestHandlerFilter() throws ClassNotFoundException{
		System.out.println("*** RequestHandlerFIlter.Constractor ***");
	}

	@Override
	public void exeFilter(ServletRequest req) {
		System.out.println("*** RequestHandlerFIlter.exeFilter() ***");
		writeRequest(req);
	}

	/**
	 * 下記の情報を取得、判定する<br>
	 * 1. 同期・非同期どちらの通信か判別する<br>
	 * 2. アクセスしてきた国を判定する<br>
	 * 3. リクエストのメッセージボディで使用される文字エンコードを取得する<br>
	 * 4. 同様にMIME_TYPEを取得<br>
	 * 5. リクエストのプロトコル、バージョン名<br>
	 * 
	 * @param req
	 */
	private void writeRequest(ServletRequest req) {
		System.out.println("*** ServletRequest ***");
		System.out.println("isSecure:" + req.isSecure());
		System.out.println("isAsync:" + req.isAsyncStarted());
		System.out.println("Schema:" + req.getScheme());
		System.out.println("remoteHost:" + req.getRemoteHost());
		System.out.println("remoteAddr" + req.getRemoteAddr());
		System.out.println("Encording:" + req.getCharacterEncoding());
		System.out.println("Protocol:" + req.getProtocol());

		Map<String, String[]> map = req.getParameterMap();
		Set<String> keys = map.keySet();
		System.out.println("***ParameterMap***");
		for(String key : keys) {
			Object o = map.get(key);
			if(o != null) {
				System.out.println("key:" + key + " *** value:" + o.toString());
			} else {
				System.out.println("key:" + key + "value: 値なし");
			}
		}
		System.out.println("***Attributes***");
		Enumeration<String> en = req.getAttributeNames();
		while(en.hasMoreElements()) {
			String st = en.nextElement();
			System.out.println("AttrName:" + st + " AttrVal:" + req.getAttribute(st));
		}
		System.out.println("*** HttpServletRequest ***");
		HttpServletRequest http = (HttpServletRequest) req;
		Enumeration<String> num = http.getHeaderNames();
		while(num.hasMoreElements()) {
			String n = num.nextElement();
			System.out.println("HaderEnumeration:" + n);
		}
		System.out.println("URI" + http.getRequestURI());
		System.out.println("URL" + http.getRequestURL());
		System.out.println("QueryString:" + http.getQueryString());
	}
}
