package jp.zenryoku.frw.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "MenuMST" database table.<br/>
 * 
 */
@Entity
@Table(name="\"MenuMST\"")
@NamedQuery(name="MenuMST.findAll", query="SELECT m FROM MenuMST m")
public class MenuMST implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"menu_mst_id:\"")
	private Integer menuMstId_;

	private String discription;

	@Column(name="gamen_id")
	private Integer gamenId;

	@Column(name="menu_name")
	private String menuName;

	@Column(name="menu_type")
	private Integer menuType;

	@Column(name="menu_value")
	private String menuValue;

	private Integer number;

	public MenuMST() {
	}

	public Integer getMenuMstId_() {
		return this.menuMstId_;
	}

	public void setMenuMstId_(Integer menuMstId_) {
		this.menuMstId_ = menuMstId_;
	}

	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Integer getGamenId() {
		return this.gamenId;
	}

	public void setGamenId(Integer gamenId) {
		this.gamenId = gamenId;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Integer getMenuType() {
		return this.menuType;
	}

	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}

	public String getMenuValue() {
		return this.menuValue;
	}

	public void setMenuValue(String menuValue) {
		this.menuValue = menuValue;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}