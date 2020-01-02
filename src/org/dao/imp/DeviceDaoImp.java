package org.dao.imp;
 import java.util.ArrayList;
 import java.util.List;
 import org.dao.DeviceDao;
 import org.dao.imp.DeviceDaoImp;
 import org.model.Device;
 import org.model.Deviceclass;
 import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
 
 public class DeviceDaoImp extends HibernateDaoSupport implements DeviceDao {
   public List<Device> findAllDevice() {
     List<Device> list = getHibernateTemplate().find("from org.model.Device");
     return list;
   }
   public List<Device> findDeviceByDeviceClassId(int deviceClassId) {
     List<Device> list = getHibernateTemplate().find("from org.model.Device where deviceClassId=?", Integer.valueOf(deviceClassId));
     return list;
   }
   public Device findDeviceById(int deviceId) {
     List<Device> list = getHibernateTemplate().find("from org.model.Device where deviceId=?", Integer.valueOf(deviceId));
     Device dev = list.get(0);
     return dev;
   }
   public List<Device> findDeviceByName(String deviceName) {
     List<Device> list = getHibernateTemplate().find("from org.model.Device where deviceName like '%" + deviceName + "%'");
 
 
 
     
     return list;
   }
   public List<Device> findDeviceByPrice(String low, String high) {
     String[] params = { low, high };
     List<Device> list = getHibernateTemplate().find("from org.model.Device where DevicePrice between ? and ?", (Object[])params);
     return list;
   }
 
 
 
 
 
 
   
   public List<Device> findDeviceByFuzzy(String deviceClassName, String deviceName, String low, String high) {
     String hql = "from Device where deviceName like '%" + deviceName + 
       "%' and devicePrice between " + low + " and " + high;
     List<Device> preList = getHibernateTemplate().find(hql);
     
     List<Device> finalList = new ArrayList<Device>();
     for (Device d : preList) {
       
       String hql1 = "from Deviceclass where deviceClassId=" + d.getDeviceclass().getDeviceClassId() + 
         " and deviceClassName like '%" + deviceClassName + "%'";
       List<Deviceclass> dclist = getHibernateTemplate().find(hql1);
       d.setDeviceclass(dclist.get(0));
       
       if (dclist != null) {
         finalList.add(d);
       }
     } 
     return finalList;
   }
 
   
   public void updateDeviceById(int deviceId, String deviceName, String devicePrice) {
     Device dev = findDeviceById(deviceId);
     dev.setDeviceName(deviceName);
     dev.setDevicePrice(devicePrice);
     getHibernateTemplate().update(dev);
   }
 }


