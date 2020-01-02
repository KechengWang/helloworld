package org.dao;

import java.util.List;
import org.model.Shopingorder;

public interface ShopingorderDao {
  List<Shopingorder> findAllShopingorder();
  
  Shopingorder findShopingorderById(int paramInt);
  
  List<Shopingorder> findShopingorderByUserId(int paramInt);
  
  void addShopingorder(Shopingorder paramShopingorder);
  
  void deleteShopingorder(Shopingorder paramShopingorder);
}

