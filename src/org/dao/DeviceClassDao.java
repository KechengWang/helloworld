package org.dao;

import java.util.List;
import org.model.Deviceclass;

public interface DeviceClassDao {
  List<Deviceclass> findAllDeviceClass();
  
  Deviceclass findDeviceClass(int paramInt);
}


