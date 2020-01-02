package org.dao.imp;
 
 import java.util.List;
 import org.dao.ShopingorderDao;
 import org.dao.imp.ShopingorderDaoImp;
 import org.model.Shopingorder;
 import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
 
 public class ShopingorderDaoImp extends HibernateDaoSupport implements ShopingorderDao {
   public List<Shopingorder> findAllShopingorder() {
     List<Shopingorder> list = getHibernateTemplate().find("from org.model.Shopingorder");
     return list;
   }
   public Shopingorder findShopingorderById(int shopingorderId) {
     List<Shopingorder> list = getHibernateTemplate().find("from org.model.Shopingorder where ShopingOrderID=?", Integer.valueOf(shopingorderId));
     Shopingorder shopingorder = list.get(0);
     return shopingorder;
   }
   public List<Shopingorder> findShopingorderByUserId(int userId) {
     List<Shopingorder> list = getHibernateTemplate().find("from org.model.Shopingorder where UserId=?", Integer.valueOf(userId));
     return list;
   }
   
   public void addShopingorder(Shopingorder shopingorder) { getHibernateTemplate().save(shopingorder); }
 
   
   public void deleteShopingorder(Shopingorder shopingorder) { getHibernateTemplate().delete(shopingorder); }
 }


