package jp.zenryoku.frw.util;

import java.io.IOException;

import javax.servlet.Filter;

/**
 * XMLファイル操作などでのユーティリティークラス<br>
 * 全てsetaticメソッドとし、インスタンス変数などを保持しない<br>
 * エラーはクラス内処理しないので必ずthrowsをつけて実装する
 * 
 * @author ZenryokuService
 */
public class XmlUtil {

	public static final String XML_FILE_DIR = "/filters/";

	/**
	 * 1.XMLファイル名(完全パス)を読み込む<br>
	 * 2.読み込んだXMLよりクラスをロードする<br>
	 * 3.取得したインスタンスを返却
	 * 
	 * @param xmlFile 読込むファイル名(完全パス)
	 * @param cls インスタンスを取得するクラス・オブジェクト
	 * @return
	 */
	public static Class<? extends Filter> getInstace(String xmlFile, Class<? extends Filter> cls) throws IOException{
		Class<? extends Filter> res = null;

		return res;
	}
	
	/**
	 * XMLファイルを読み込む
	 * 
	 * @param xmlFile XMLファイルの完全パス
	 * @throws IOException ファイル読み込み時のエラー
	 */
	public static void readXml(String xmlFile) throws IOException {
		
	}
}
