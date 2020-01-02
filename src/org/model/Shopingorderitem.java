package org.model;

import java.io.Serializable;

public class Shopingorderitem implements Serializable{

	private Integer shopingOrderItemId;
	  private Shopingorder shopingorder;
	  
	  public Shopingorderitem(Shopingorder shopingorder, Device device) {
	    this.shopingorder = shopingorder;
	    this.device = device;
	  } private Device device; private Integer buyNum;
	  public Shopingorderitem() {}
	  public Shopingorderitem(Shopingorder shopingorder, Device device, Integer buyNum) {
	    this.shopingorder = shopingorder;
	    this.device = device;
	    this.buyNum = buyNum;
	  }
	  
	  public Integer getShopingOrderItemId() { return this.shopingOrderItemId; }

	  
	  public void setShopingOrderItemId(Integer shopingOrderItemId) { this.shopingOrderItemId = shopingOrderItemId; }

	  
	  public Shopingorder getShopingorder() { return this.shopingorder; }

	  
	  public void setShopingorder(Shopingorder shopingorder) { this.shopingorder = shopingorder; }

	  
	  public Device getDevice() { return this.device; }

	  
	  public void setDevice(Device device) { this.device = device; }

	  
	  public Integer getBuyNum() { return this.buyNum; }

	  
	  public void setBuyNum(Integer buyNum) { this.buyNum = buyNum; }
}
