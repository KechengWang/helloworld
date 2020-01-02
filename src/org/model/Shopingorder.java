package org.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Shopingorder implements Serializable {

	private Integer shopingOrderId;
	  private User user;
	  private String receiver;
	  private Set shopingorderitems = new HashSet(0); private String receiveAddress; private String createtime; private String moneyAmount;
	  
	  public Shopingorder() {}
	  
	  public Shopingorder(User user, String receiver, String receiveAddress, String createtime, String moneyAmount, Set shopingorderitems) {
	    this.user = user;
	    this.receiver = receiver;
	    this.receiveAddress = receiveAddress;
	    this.createtime = createtime;
	    this.moneyAmount = moneyAmount;
	    this.shopingorderitems = shopingorderitems;
	  }
	  
	  public Integer getShopingOrderId() { return this.shopingOrderId; }

	  
	  public void setShopingOrderId(Integer shopingOrderId) { this.shopingOrderId = shopingOrderId; }

	  
	  public User getUser() { return this.user; }

	  
	  public void setUser(User user) { this.user = user; }

	  
	  public String getReceiver() { return this.receiver; }

	  
	  public void setReceiver(String receiver) { this.receiver = receiver; }

	  
	  public String getReceiveAddress() { return this.receiveAddress; }

	  
	  public void setReceiveAddress(String receiveAddress) { this.receiveAddress = receiveAddress; }

	  
	  public String getCreatetime() { return this.createtime; }

	  
	  public void setCreatetime(String createtime) { this.createtime = createtime; }

	  
	  public String getMoneyAmount() { return this.moneyAmount; }

	  
	  public void setMoneyAmount(String moneyAmount) { this.moneyAmount = moneyAmount; }

	  
	  public Set getShopingorderitems() { return this.shopingorderitems; }

	  
	  public void setShopingorderitems(Set shopingorderitems) { this.shopingorderitems = shopingorderitems; }
}
