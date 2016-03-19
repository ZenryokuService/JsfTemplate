package jp.zenryoku.frw.util;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import jp.zenryoku.frw.annotation.FilterAnnoIF;
import jp.zenryoku.frw.annotation.FilterAnnotation;
import jp.zenryoku.frw.servlet.filter.ServletFilter;

/**
 * AnnotationUtilのテストクラス
 * 
 * @author ZenryokuService
 */
@RunWith(JUnit4.class)
public class AnnotationUtilTest {
	@Test
	public void testGetAnnotation() throws Exception{
		List<FilterAnnoIF> clses = AnnotationUtil.searchFilterAnnotation();
		for(FilterAnnoIF ano : clses) {
			ano.exeFilter(null);
		}
	}
}
