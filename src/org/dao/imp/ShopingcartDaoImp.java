package org.dao.imp;
 import java.util.List;

import org.dao.ShopingcartDao;
 import org.dao.ShopingorderDao;
 import org.dao.ShopingorderitemDao;
 import org.dao.imp.ShopingcartDaoImp;
 import org.model.Device;
 import org.model.Shopingcart;
 import org.model.Shopingorder;
 import org.model.Shopingorderitem;
 import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
 
 public class ShopingcartDaoImp extends HibernateDaoSupport implements ShopingcartDao {
   private ShopingorderDao shopingorderDao;
   
   public List<Shopingcart> findAllShopingcart() {
     List<Shopingcart> list = getHibernateTemplate().find("from org.model.Shopingcart");
     return list;
   } private ShopingorderitemDao shopingorderitemDao;
   public Shopingcart findShopingcartById(int ShopingcartId) {
     List<Shopingcart> list = getHibernateTemplate().find("from org.model.Shopingcart where ShopingcartID=?", Integer.valueOf(ShopingcartId));
     Shopingcart shopingcart = list.get(0);
     return shopingcart;
   }
   
   public void addShopingcart(Shopingcart Shopingcart) { getHibernateTemplate().save(Shopingcart); }
 
   
   public void deleteShopingcart(Shopingcart Shopingcart) { getHibernateTemplate().delete(Shopingcart); }
   
   public List<Shopingcart> findAllShopingcartByUserId(int userId) {
     List<Shopingcart> list = getHibernateTemplate().find("from org.model.Shopingcart where UserID=?", Integer.valueOf(userId));
     return list;
   }
 

   
   public void setShopingorderDao(ShopingorderDao shopingorderDao) { this.shopingorderDao = shopingorderDao; }

   public void setShopingorderitemDao(ShopingorderitemDao shopingorderitemDao) { this.shopingorderitemDao = shopingorderitemDao; }
 

   
   public void jiesuanShopingcart(Shopingorder so, List<Shopingcart> shopingcartList) {
     this.shopingorderDao.addShopingorder(so);
     
     for (Shopingcart sc : shopingcartList) {
       Shopingorderitem soi = new Shopingorderitem();
       
       soi.setShopingorder(so);
       Device dev = sc.getDevice();
       soi.setDevice(dev);
       int buyNum = sc.getBuyNum().intValue();
       soi.setBuyNum(Integer.valueOf(buyNum));
       this.shopingorderitemDao.addShopingorderitem(soi);
     } 
     
     for (Shopingcart sc : shopingcartList)
       deleteShopingcart(sc); 
   }
 }


