package app.action;

import java.io.IOException;

public interface ShopingorderitemAction {
  void findAllShopingorderitem() throws IOException;
  
  void findShopingorderitemById() throws IOException;
  
  void findShopingorderitemListByShopingorderId() throws IOException;
  
  String addShopingorderitem() throws IOException;
  
  String deleteShopingorderitem() throws IOException;
}

