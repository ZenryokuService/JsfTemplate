package jp.zenryoku.frw.entity;

import java.io.Serializable;
import javax.persistence.*;

import jp.zenryoku.frw.DaoIF;
import jp.zenryoku.frw.EntityIF;


/**
 * The persistent class for the "MenuMST" database table.<br/>
 * 
 */
@Entity
@Table(name="\"MenuMST\"")
@NamedQuery(name="MenuMST.findAll", query="SELECT m FROM MenuMST m")
public class MenuMST implements EntityIF {
	private static final long serialVersionUID = 1L;

	/**
	 * MenuMSTのサロゲートキー
	 */
	@Id
	@Column(name="\"menu_mst_id:\"")
	private Integer menuMstId_;
	/**
	 * メニューに対する説明
	 */
	private String discription;
	/**
	 * 画面ID
	 */
	@Column(name="gamen_id")
	private Integer gamenId;

	@Column(name="menu_name")
	private String menuName;

	@Column(name="menu_type")
	private Integer menuType;

	@Column(name="menu_value")
	private String menuValue;

	private Integer number;
	/**
	 * コンストラクタ<br/>
	 */
	public MenuMST() {
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
	public Integer getMenuMstId_() {
		return menuMstId_;
	}

	/**
	 * @param menuMstId_ the menuMstId_ to set
	 */
	public void setMenuMstId_(Integer menuMstId_) {
		this.menuMstId_ = menuMstId_;
	}

	/**
	 * @return the discription
	 */
	public String getDiscription() {
		return discription;
	}

	/**
	 * @param discription the discription to set
	 */
	public void setDiscription(String discription) {
		this.discription = discription;
	}

	/**
	 * @return the gamenId
	 */
	public Integer getGamenId() {
		return gamenId;
	}

	/**
	 * @param gamenId the gamenId to set
	 */
	public void setGamenId(Integer gamenId) {
		this.gamenId = gamenId;
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

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}