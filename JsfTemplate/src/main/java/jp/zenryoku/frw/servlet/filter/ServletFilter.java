package jp.zenryoku.frw.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * <ul>
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
		chain.doFilter(req, res);
		System.out.println("*** Filter.doFilter(lower) *** ");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("*** Filter.init *** ");
	}
	
}
