package org.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable{

	private Integer userId;
	  private Set shopingorders = new HashSet(0); private String userName; private String userPassword;
	  private Set shopingcarts = new HashSet(0);
	  
	  public User() {}
	  
	  public User(String userName, String userPassword, Set shopingorders, Set shopingcarts) {
	    this.userName = userName;
	    this.userPassword = userPassword;
	    this.shopingorders = shopingorders;
	    this.shopingcarts = shopingcarts;
	  }
	  
	  public Integer getUserId() { return this.userId; }

	  
	  public void setUserId(Integer userId) { this.userId = userId; }

	  
	  public String getUserName() { return this.userName; }

	  
	  public void setUserName(String userName) { this.userName = userName; }

	  
	  public String getUserPassword() { return this.userPassword; }

	  
	  public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

	  
	  public Set getShopingorders() { return this.shopingorders; }

	  
	  public void setShopingorders(Set shopingorders) { this.shopingorders = shopingorders; }

	  
	  public Set getShopingcarts() { return this.shopingcarts; }

	  
	  public void setShopingcarts(Set shopingcarts) { this.shopingcarts = shopingcarts; }
}
