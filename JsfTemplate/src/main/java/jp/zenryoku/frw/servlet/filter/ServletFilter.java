package jp.zenryoku.frw.servlet.filter;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import jp.zenryoku.frw.annotation.FilterAnnoIF;
import jp.zenryoku.frw.annotation.FilterAnnotation;
import jp.zenryoku.frw.exceptions.ServletFilterException;
import jp.zenryoku.frw.util.AnnotationUtil;

/**
 * <ul>
 * <li>このフレームワークの基本になるFilterクラス</li>
 * <li>"/filters/フィルター名.xml"を読み込み</li>
 * <li>クラスをロードして、フィルター処理を行う、登録されたクラスをリストで保持、実行される</li>
 * </ul>
 * @author ZenryokuService
 */
public class ServletFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("*** Filter.destroy *** ");
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("*** Filter.doFilter(upper) *** ");
		try {
			List<FilterAnnoIF> anoList = AnnotationUtil.searchFilterAnnotation();
			for(FilterAnnoIF ano : anoList) {
				ano.exeFilter(req);
			}
			chain.doFilter(req, res);
			System.out.println("*** Filter.doFilter(lower) *** ");
		} catch(Exception e) {
			if(e instanceof ServletFilterException) {
				System.out.println("ServletFilterException" + e.getMessage());
			}
			System.out.println("*** Message:" + e.getMessage() + " ***");
			e.printStackTrace();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("*** Filter.init *** ");
	}
}
