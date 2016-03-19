package jp.zenryoku.frw.session;

import java.io.Serializable;

import javax.inject.Named;

import jp.zenryoku.frw.entity.UserProperties;

/**
 * BigHandsフレームワークでのセッションを管理する<br>
 * 
 * @author ZenryokuService
 */
@Named
@SuppressWarnings("serial")
public class SessionBean implements Serializable {
	/** UserName */
	private String userName;
	/** UserProperties */
	private UserProperties props;
	/** Loggin Flag */
	private boolean loginFlg;

	/**
	 * @return the loginFlg
	 */
	public boolean isLoginFlg() {
		return loginFlg;
	}
	/**
	 * @param loginFlg the loginFlg to set
	 */
	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the props
	 */
	public UserProperties getProps() {
		return props;
	}
	/**
	 * @param props the props to set
	 */
	public void setProps(UserProperties props) {
		this.props = props;
	}
	
}
