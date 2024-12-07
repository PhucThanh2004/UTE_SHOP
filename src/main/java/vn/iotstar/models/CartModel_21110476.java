package vn.iotstar.models;

import java.io.Serializable;

public class CartModel_21110476 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userID;
	private int productID;
	private int amount;
	public CartModel_21110476() {
		super();
	}
	public CartModel_21110476(int userID, int productID, int amount) {
		super();
		this.userID = userID;
		this.productID = productID;
		this.amount = amount;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "CartModel_21110476 [userID=" + userID + ", productID=" + productID + ", amount=" + amount + "]";
	}
	
	

}
