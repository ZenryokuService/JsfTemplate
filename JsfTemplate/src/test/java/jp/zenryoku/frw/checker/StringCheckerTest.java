package jp.zenryoku.frw.checker;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * StringCheckerクラスのテストを行う
 * 
 * @author ZenryokuService
 */
@RunWith(JUnit4.class)
public class StringCheckerTest {
	/**
	 * 1.テキストファイルの名前のみの場合
	 */
	@Test
	public void testIsBaseName1() {
		String str = "test.txt";
		assertEquals(true, StringChecker.isBaseName(str));
	}
	/**
	 * 2.パスを含むテキストファイルの名前の場合
	 */
	@Test
	public void testIsBaseName2() {
		String str = "resources/test.txt";
		assertEquals(false, StringChecker.isBaseName(str));
	}
	/**
	 * 3.パスを含むテキストファイル(拡張子なし)の名前の場合
	 */
	@Test
	public void testIsBaseName3() {
		String str = "resources/test";
		assertEquals(false, StringChecker.isBaseName(str));
	}
	/**
	 * 4.拡張子が有る場合のチェック
	 */
	@Test
	public void testHasFileExtention1() {
		String str = "resources/test.txt";
		assertEquals(true, StringChecker.hasFileExtention(str));
	}
	/**
	 * 5.拡張子がXMLの場合のチェック
	 */
	@Test
	public void testIsXmlFile1() {
		String str = "resources/test.xml";
		assertEquals(true, StringChecker.isXmlFile(str));
	}
	/**
	 * 6.拡張子がXMLでない場合のチェック
	 */
	@Test
	public void testIsXmlFile2() {
		String str = "resources/test.properties";
		assertEquals(false, StringChecker.isXmlFile(str));
	}
	/**
	 * 7.拡張子が無い場合のチェック
	 */
	@Test
	public void testHasFileExtention2() {
		String str = "resources/test";
		assertEquals(false, StringChecker.isXmlFile(str));
	}
	/**
	 * 8.完全パス(Windows)のXML場合のチェック
	 */
	@Test
	public void testHasFileExtention3() {
		String str = "C:¥resources¥test.xml";
		assertEquals(true, StringChecker.isXmlFile(str));
	}
	/**
	 * 9.完全パス(Windows)のtxtファイルの場合のチェック
	 */
	@Test
	public void testHasFileExtention4() {
		String str = "C:¥resources¥test.txt";
		assertEquals(false, StringChecker.isXmlFile(str));
	}
}
