package jp.zenryoku.frw.util;

import java.io.Serializable;

import jp.zenryoku.frw.BigHandsConstants;

/**
 * 文字列関連のユーティリティークラス1<br>
 * 
 * @author ZenryokuService
 */
@SuppressWarnings("serial")
public class StringUtil implements Serializable{
	/**
	 * ファイル名から拡張子部分を取得する1<br>
	 * 
	 * @param fileName ファイル名
	 * @return 拡張子"."を含まない
	 */
	public static String getFileExtention(String fileName) {
		String ext = null;
		if (fileName != null) {
			int index = fileName.indexOf(BigHandsConstants.DOT);
			ext = fileName.substring(index + 1);
		}
		return ext;
	}
}
