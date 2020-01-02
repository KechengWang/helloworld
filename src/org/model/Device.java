package org.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.model.Device;
import org.model.Deviceclass;

public class Device implements Serializable {
  private Integer deviceId;
  private Deviceclass deviceclass;
  private Set shopingorderitems = new HashSet(0); private String deviceName; private String devicePrice;
  private Set shopingcarts = new HashSet(0);
  
  public Device() {}
  
  public Device(Deviceclass deviceclass, String deviceName, String devicePrice, Set shopingorderitems, Set shopingcarts) {
    this.deviceclass = deviceclass;
    this.deviceName = deviceName;
    this.devicePrice = devicePrice;
    this.shopingorderitems = shopingorderitems;
    this.shopingcarts = shopingcarts;
  }
  
  public Integer getDeviceId() { return this.deviceId; }

  
  public void setDeviceId(Integer deviceId) { this.deviceId = deviceId; }

  
  public Deviceclass getDeviceclass() { return this.deviceclass; }

  
  public void setDeviceclass(Deviceclass deviceclass) { this.deviceclass = deviceclass; }

  
  public String getDeviceName() { return this.deviceName; }

  
  public void setDeviceName(String deviceName) { this.deviceName = deviceName; }

  
  public String getDevicePrice() { return this.devicePrice; }

  
  public void setDevicePrice(String devicePrice) { this.devicePrice = devicePrice; }

  
  public Set getShopingorderitems() { return this.shopingorderitems; }

  
  public void setShopingorderitems(Set shopingorderitems) { this.shopingorderitems = shopingorderitems; }

  
  public Set getShopingcarts() { return this.shopingcarts; }

  
  public void setShopingcarts(Set shopingcarts) { this.shopingcarts = shopingcarts; }
}
