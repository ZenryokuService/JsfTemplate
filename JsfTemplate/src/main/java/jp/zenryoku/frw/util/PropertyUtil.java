package jp.zenryoku.frw.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

import jp.zenryoku.frw.BigHandsConstants;

/**
 * Property関連のUtilクラス
 * 
 * @author ZenryokuService
 */
@SuppressWarnings("serial")
public class PropertyUtil implements Serializable {
	
	/**
	 * persistence.xmlなどXMLファイルを読み込み<br>
	 * Propertiesクラスを返却する<br>
	 * ＜例＞<br>
	 * META-INF/fileNameのXMLファイルを読み込む
	 * 
	 * @param fileName 読み込む対象のファイル名
	 * @return Properties 読み込んだファイルのPropertiesクラス
	 * @throws IOException ファイル読み込みでのエラー
	 */
	public static Properties getPersistence(String fileName) throws IOException {
		Properties prop = new Properties();
//		InputStream inp = null;
//		
//		switch(fileName) {
//		case BigHandsConstants.XML:
////			inp = ClassLoader.getSystemResourceAsStream(BigHandsConstants.ROOT_DIR + fileName);
//			break;
//		case BigHandsConstants.PROPS:
////			inp = ClassLoader.getSystemResourceAsStream(BigHandsConstants.ROOT_DIR + fileName);
//		}
////		prop.loadFromXML(inp);
		return prop;
	}
}
