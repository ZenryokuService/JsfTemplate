package jp.zenryoku.frw.checker;

import java.io.Serializable;

import jp.zenryoku.frw.BigHandsConstants;
import jp.zenryoku.frw.util.StringUtil;

/**
 * 文字列に関して、各種チェック処理を行う<br>
 * 
 * @author ZenryokuService
 */
@SuppressWarnings("serial")
public class StringChecker implements Serializable {
	/**
	 * XMLファイルであることをチェックする。<br>
	 * ベース名でないとfalseを返却する
	 * 
	 * @param fileName ファイルの名前(拡張子を含む)
	 * @return true:*.xmlである false:*.xml以外
	 */
	public static boolean isXmlFile(String fileName) {
		boolean b = false;
		if (StringChecker.hasFileExtention(fileName) == false) {
			return false;
		}
		String ext = StringUtil.getFileExtention(fileName);
		if(BigHandsConstants.XML.equals(ext)) {
			b = true;
		}
		return b;
	}
	/**
	 * fileNameにパスが含まれていないことをチェックする。
	 * 1.fileNameに"/"が含まれていないことをチェック<br>
	 * 
	 * @param fileName チェックするファイル名
	 * @return true:ファイル名のみ false:パスが含まれている
	 */
	public static boolean isBaseName(String fileName) {
		// "/"が副られるならTrue
		boolean b = fileName.contains("/");
		return b == false;
	}
	/**
	 * fileNameが"."の含むことをチェック<br>
	 * @param str 検証ボジレツ
	 * @return true:形式が合っている false:形式が違う
	 */
	public static boolean hasFileExtention(String str) {
		int i = str.lastIndexOf(BigHandsConstants.DOT);
		//System.out.println(str.substring(i));
		return  i >  0;
	}
}
