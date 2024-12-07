package vn.iotstar.models;

import java.io.Serializable;

public class CategoryModel_21110476 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int categoryID;
	private String categoryName;
	private String icon;
	public CategoryModel_21110476() {
		super();
	}
	public CategoryModel_21110476(int categoryID, String categoryName, String icon) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.icon = icon;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	@Override
	public String toString() {
		return "CategoryModel_21110476 [categoryID=" + categoryID + ", categoryName=" + categoryName + ", icon=" + icon
				+ "]";
	}
	
	

}
