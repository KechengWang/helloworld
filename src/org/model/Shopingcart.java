package org.model;

import java.io.Serializable;

public class Shopingcart implements Serializable{

	private Integer shopingcartId;
	  private User user;
	  
	  public Shopingcart(User user, Device device, Integer buyNum) {
	    this.user = user;
	    this.device = device;
	    this.buyNum = buyNum;
	  } private Device device; private Integer buyNum;
	  public Shopingcart() {}
	  public Integer getShopingcartId() { return this.shopingcartId; }

	  
	  public void setShopingcartId(Integer shopingcartId) { this.shopingcartId = shopingcartId; }

	  
	  public User getUser() { return this.user; }

	  
	  public void setUser(User user) { this.user = user; }

	  
	  public Device getDevice() { return this.device; }

	  
	  public void setDevice(Device device) { this.device = device; }

	  
	  public Integer getBuyNum() { return this.buyNum; }

	  
	  public void setBuyNum(Integer buyNum) { this.buyNum = buyNum; }
}
