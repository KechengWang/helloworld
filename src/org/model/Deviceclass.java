package org.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.model.Deviceclass;

public class Deviceclass implements Serializable {
  private Integer deviceClassId;
  private Set devices = new HashSet(0); private String deviceClassName;
  public Deviceclass() {}
  
  public Deviceclass(String deviceClassName, Set devices) {
    this.deviceClassName = deviceClassName;
    this.devices = devices;
  }
  
  public Integer getDeviceClassId() { return this.deviceClassId; }

  
  public void setDeviceClassId(Integer deviceClassId) { this.deviceClassId = deviceClassId; }

  
  public String getDeviceClassName() { return this.deviceClassName; }

  
  public void setDeviceClassName(String deviceClassName) { this.deviceClassName = deviceClassName; }

  
  public Set getDevices() { return this.devices; }

  
  public void setDevices(Set devices) { this.devices = devices; }
}
