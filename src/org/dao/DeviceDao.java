package org.dao;

import java.util.List;
import org.model.Device;

public interface DeviceDao {
  List<Device> findAllDevice();
  
  List<Device> findDeviceByDeviceClassId(int paramInt);
  
  Device findDeviceById(int paramInt);
  
  List<Device> findDeviceByName(String paramString);
  
  List<Device> findDeviceByPrice(String paramString1, String paramString2);
  
  List<Device> findDeviceByFuzzy(String paramString1, String paramString2, String paramString3, String paramString4);
  
  void updateDeviceById(int paramInt, String paramString1, String paramString2);
}


