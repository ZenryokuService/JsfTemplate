package jp.zenryoku.frw.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import jp.zenryoku.frw.EntityIF;


/**
 * The persistent class for the "MenuMST" database table.<br>
 * 
 */
@Entity
@Table(name="\"MenuMST\"")
@NamedQueries({
		@NamedQuery(name="MenuMST.findAll", query="select m from MenuMST m")
		,@NamedQuery(name="MenuMST.getAllRole", query="select m from MenuMST m where m.role = 9")
})
@SuppressWarnings("serial")
public class MenuMST implements EntityIF {
	/** findAllのクエリ名 */
	public static final String FIND_ALL = "MenuMST.findAll";
	/** getAllRoleのクエリ */
	public static final String GET_ALL_ROLE = "MenuMST.getAllRole";
	/**
	 * MenuMSTのサロゲートキー
	 */
	@Id
	@Column(name="\"menu_mst_id:\"")
	private Integer menuMstId;
	/**
	 * メニュー名
	 */
	@Column(name="menu_name")
	private String menuName;
	/**
	 * メニュータイプ
	 */
	@Column(name="menu_type")
	private Integer menuType;
	/**
	 * メニュー値
	 */
	@Column(name="menu_value")
	private String menuValue;
	/** 
	 * 表示順序 
	 */
	private Integer number;
	/**
	 * 権限ID(権限レベル)
	 */
	@Column(name="role_id")
	private Integer role;

	/**
	 * コンストラクタ<br>
	 */
	public MenuMST() {
	}
	/**
	 * @return the role
	 */
	public Integer getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Integer role) {
		this.role = role;
	}
	/**
	 * @param menuMstId the menuMstId to set
	 */
	public void setMenuMstId(Integer menuMstId) {
		this.menuMstId = menuMstId;
	}
	/**
	 * このエンティティで定義するNamedQueryのname属性の値を返却する
	 */
	@Override
	public String findAll() {
		return "MenuMST.findAll";
	}
	/**
	 * @return the menuMstId_
	 */
	public Integer getMenuMstId() {
		return menuMstId;
	}

	/**
	 * @param menuMstId the menuMstId to set
	 * 
	 */
	public void setMenuMstId_(Integer menuMstId) {
		this.menuMstId = menuMstId;
	}

	/**
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * @param menuName the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * @return the menuType
	 */
	public Integer getMenuType() {
		return menuType;
	}

	/**
	 * @param menuType the menuType to set
	 */
	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}

	/**
	 * @return the menuValue
	 */
	public String getMenuValue() {
		return menuValue;
	}

	/**
	 * @param menuValue the menuValue to set
	 */
	public void setMenuValue(String menuValue) {
		this.menuValue = menuValue;
	}

	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
}