package org.dao.imp;


 import java.util.List;
 import org.dao.DeviceClassDao;
 import org.dao.imp.DeviceClassDaoImp;
 import org.model.Deviceclass;
 import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
 
 public class DeviceClassDaoImp extends HibernateDaoSupport implements DeviceClassDao {
   public List<Deviceclass> findAllDeviceClass() {
     List<Deviceclass> list = getHibernateTemplate().find("from org.model.Deviceclass");
     return list;
   }
   public Deviceclass findDeviceClass(int deviceClassId) {
     List<Deviceclass> list = getHibernateTemplate().find("from Deviceclass where deviceClassId = ?", Integer.valueOf(deviceClassId));
     Deviceclass dc = list.get(0);
     return dc;
   }
 }

