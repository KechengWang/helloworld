package org.dao;

import java.util.List;
import org.model.Shopingorderitem;

public interface ShopingorderitemDao {
  List<Shopingorderitem> findAllShopingorderitem();
  
  Shopingorderitem findShopingorderitemById(int paramInt);
  
  List<Shopingorderitem> findShopingorderitemListByShopingorderId(int paramInt);
  
  void addShopingorderitem(Shopingorderitem paramShopingorderitem);
  
  void deleteShopingorderitem(Shopingorderitem paramShopingorderitem);
}

