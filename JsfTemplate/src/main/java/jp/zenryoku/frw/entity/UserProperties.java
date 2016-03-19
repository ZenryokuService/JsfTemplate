package jp.zenryoku.frw.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * ユーザーの各種プロパティを保持<br>
 * DBよりユーザーのプロパティを取得、保持する
 * 
 * @author ZenryokuServive
 */
@Entity(name="UserProperty")
@SuppressWarnings("serial")
public class UserProperties implements Serializable {
	/** UserId */
	@Id
	private int userId;
}
