package jp.zenryoku.frw.annotation;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * FilterAnnotationアノテーションで実装される<br>
 * ServletContextに登録されていないため特殊な実装を行う<br>
 * 
 * @author ZenryokuService
 */
public interface FilterAnnoIF extends Serializable {
	/**
	 * ServletFilerから呼び出される<br>
	 * 各FilterAnnotationクラスで実行されるメソッド
	 */
	public void exeFilter(ServletRequest req);
}
