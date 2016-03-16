package jp.zenryoku.frw.session;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * ユーザーの各種プロパティを保持<br>
 * DBよりユーザーのプロパティを取得、保持する
 * 
 * @author ZenryokuServive
 */
@Entity(name="UserProperty")
@SuppressWarnings("serial")
public class UserProperties implements Serializable {

}
