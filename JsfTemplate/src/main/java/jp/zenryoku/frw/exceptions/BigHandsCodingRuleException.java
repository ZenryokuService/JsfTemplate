package jp.zenryoku.frw.exceptions;

import java.io.Serializable;

/**
 * BigHandsフレームワークの仕様に合わない実装、設定を行っている時にthrowされる
 */
@SuppressWarnings("serial")
public class BigHandsCodingRuleException extends Exception implements Serializable{
	public BigHandsCodingRuleException(Exception e) {
		super(e);
	}
}
