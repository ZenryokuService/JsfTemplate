package jp.zenryoku.frw.util;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;

import jp.zenryoku.frw.BigHandsConstants;
import jp.zenryoku.frw.annotation.FilterAnnoIF;
import jp.zenryoku.frw.annotation.FilterAnnotation;
import jp.zenryoku.frw.exceptions.ServletFilterException;

/**
 * 自前のアノテーション用ユーティリティクラス
 * @author ZenryokuService
 */
public class AnnotationUtil {
	/**
	 * FilterAnnotaionをつけているクラスを取得する<br>
	 * package:jp.zenryoku.frw.servlet.filterより取得する
	 * 
	 * @return Set<Class<?>> FilterAnnotationをつけているクラス
	 */
	public static List<FilterAnnoIF> searchFilterAnnotation() throws ServletFilterException, Exception {
		Reflections ref = new Reflections(BigHandsConstants.FILTERS);

		List<FilterAnnoIF> res = new ArrayList<FilterAnnoIF>();
		Set<Class<?>> anos = ref.getTypesAnnotatedWith(FilterAnnotation.class);
		FilterAnnoIF ano = null;
		for(Class<?> a : anos) {
			try {
				ano = (FilterAnnoIF) a.newInstance();
			} catch(IllegalAccessException ie) {
				ie.printStackTrace();
			} catch(InstantiationException insE) {
				insE.printStackTrace();
			}
			if(ano != null) {
				res.add(ano);
			} else {
				throw new ServletFilterException("FilterAnnoIF取得に失敗");
			}
			System.out.println("AnnoName" + a.toString());
		}

		return res;
	}
}
