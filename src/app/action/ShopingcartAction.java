package app.action;

import java.io.IOException;

public interface ShopingcartAction {
  void findAllShopingcart() throws IOException;
  
  void findShopingcartById() throws IOException;
  
  String addShopingcart() throws IOException;
  
  String deleteShopingcart() throws IOException;
  
  void findAllShopingcartByUserId() throws IOException;
  
  String jiesuanShopingcart() throws IOException;
}


