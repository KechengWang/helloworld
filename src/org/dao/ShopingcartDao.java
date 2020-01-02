package org.dao;

import java.util.List;
import org.model.Shopingcart;
import org.model.Shopingorder;

public interface ShopingcartDao {
  List<Shopingcart> findAllShopingcart();
  
  Shopingcart findShopingcartById(int paramInt);
  
  void addShopingcart(Shopingcart paramShopingcart);
  
  void deleteShopingcart(Shopingcart paramShopingcart);
  
  List<Shopingcart> findAllShopingcartByUserId(int paramInt);
  
  void jiesuanShopingcart(Shopingorder paramShopingorder, List<Shopingcart> paramList);
}

