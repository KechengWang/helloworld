package app.action.imp;
/*     */ 
/*     */ import app.action.ShopingcartAction;
/*     */ import app.action.imp.ShopingcartActionImp;
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.opensymphony.xwork2.ActionSupport;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.struts2.interceptor.ServletRequestAware;
/*     */ import org.apache.struts2.interceptor.ServletResponseAware;
/*     */ import org.dao.DeviceDao;
/*     */ import org.dao.ShopingcartDao;
/*     */ import org.dao.UserDao;
/*     */ import org.model.Device;
/*     */ import org.model.Shopingcart;
/*     */ import org.model.Shopingorder;
/*     */ import org.model.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ShopingcartActionImp
/*     */   extends ActionSupport
/*     */   implements ShopingcartAction, ServletRequestAware, ServletResponseAware
/*     */ {
/*     */   private HttpServletRequest request;
/*     */   private HttpServletResponse response;
/*     */   private ShopingcartDao shopingcartDao;
/*     */   private DeviceDao deviceDao;
/*     */   private UserDao userDao;
/*     */   
/*  36 */   public void setServletResponse(HttpServletResponse res) { this.response = res; }
/*     */ 
/*     */ 
/*     */   
/*  40 */   public void setServletRequest(HttpServletRequest req) { this.request = req; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  45 */   public void setShopingcartDao(ShopingcartDao shopingcartDao) { this.shopingcartDao = shopingcartDao; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  50 */   public void setDeviceDao(DeviceDao deviceDao) { this.deviceDao = deviceDao; }
/*     */ 
/*     */   
/*     */   public void makeJson(List<Shopingcart> list) throws IOException {
/*  54 */     this.response.setHeader("Content-Type", "text/html;charset=utf-8");
/*  55 */     PrintWriter out = this.response.getWriter();
/*     */     
/*  57 */     JSONArray jsonArray = new JSONArray();
/*  58 */     for (Shopingcart shopingcart : list) {
/*  59 */       JSONObject jsonObj = new JSONObject();
/*  60 */       jsonObj.put("ShopingcartID", shopingcart.getShopingcartId());
/*     */       
/*  62 */       Integer deviceId = shopingcart.getDevice().getDeviceId();
/*  63 */       Device dev = this.deviceDao.findDeviceById((new Integer(deviceId.intValue())).intValue());
/*  64 */       JSONObject jsonObjdev = new JSONObject();
/*  65 */       jsonObjdev.put("DeviceID", dev.getDeviceId());
/*  66 */       jsonObjdev.put("DeviceClassId", dev.getDeviceclass()
/*  67 */           .getDeviceClassId());
/*  68 */       jsonObjdev.put("DeviceName", dev.getDeviceName());
/*  69 */       jsonObjdev.put("DevicePrice", dev.getDevicePrice());
/*  70 */       jsonObj.put("Device", jsonObjdev);
/*     */       
/*  72 */       jsonObj.put("BuyNum", shopingcart.getBuyNum());
/*  73 */       jsonObj.put("UserID", shopingcart.getUser().getUserId());
/*  74 */       jsonArray.add(jsonObj);
/*     */     } 
/*  76 */     System.out.println(jsonArray.toString());
/*  77 */     JSONObject root = new JSONObject();
/*  78 */     root.put("result", jsonArray);
/*  79 */     out.write(root.toString());
/*  80 */     out.flush();
/*  81 */     out.close();
/*     */   }
/*     */ 
/*     */   
/*     */   public void findAllShopingcart() throws IOException {
/*  86 */     List<Shopingcart> list = this.shopingcartDao.findAllShopingcart();
/*  87 */     makeJson(list);
/*     */   }
/*     */   
/*     */   public void findShopingcartById() throws IOException {
/*  91 */     String id = this.request.getParameter("shopingcartId");
/*  92 */     Shopingcart shopingcart = this.shopingcartDao.findShopingcartById((new Integer(id)).intValue());
/*  93 */     List<Shopingcart> list = new ArrayList<Shopingcart>();
/*  94 */     list.add(shopingcart);
/*     */     
/*  96 */     makeJson(list);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 102 */   public void setUserDao(UserDao userDao) { this.userDao = userDao; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String addShopingcart() throws IOException {
/* 108 */     String deviceId = this.request.getParameter("addDeviceID");
/* 109 */     String buyNum = this.request.getParameter("addBuyNum");
/* 110 */     String userId = this.request.getParameter("addUserID");
/* 111 */     Shopingcart sc = new Shopingcart();
/*     */     
/* 113 */     Device dev = this.deviceDao.findDeviceById((new Integer(deviceId)).intValue());
/* 114 */     sc.setDevice(dev);
/* 115 */     sc.setBuyNum(new Integer(buyNum));
/* 116 */     User user = this.userDao.findUserById((new Integer(userId)).intValue());
/* 117 */     sc.setUser(user);
/*     */     
/* 119 */     this.shopingcartDao.addShopingcart(sc);
/* 120 */     return "success";
/*     */   }
/*     */   
/*     */   public String deleteShopingcart() throws IOException {
/* 124 */     String shopingcartId = this.request.getParameter("deleteShopingcartID");
/* 125 */     Shopingcart sc = this.shopingcartDao.findShopingcartById((new Integer(shopingcartId)).intValue());
/* 126 */     this.shopingcartDao.deleteShopingcart(sc);
/*     */     
/* 128 */     return "success";
/*     */   }
/*     */   
/*     */   public void findAllShopingcartByUserId() throws IOException {
/* 132 */     String id = this.request.getParameter("userId");
/* 133 */     List<Shopingcart> list = new ArrayList<Shopingcart>();
/* 134 */     list = this.shopingcartDao.findAllShopingcartByUserId((new Integer(id)).intValue());
/*     */     
/* 136 */     makeJson(list);
/*     */   }
/*     */ 
/*     */   
/*     */   public String jiesuanShopingcart() {
/* 141 */     Shopingorder so = new Shopingorder();
/* 142 */     String userId = this.request.getParameter("userId");
/* 143 */     User user = this.userDao.findUserById((new Integer(userId)).intValue());
/* 144 */     so.setUser(user);
/* 145 */     String receiver = this.request.getParameter("receiver");
/* 146 */     so.setReceiver(receiver);
/* 147 */     String receiveAddress = this.request.getParameter("receiveAddress");
/* 148 */     so.setReceiveAddress(receiveAddress);
/* 149 */     String createtime = this.request.getParameter("createtime");
/* 150 */     so.setCreatetime(createtime);
/* 151 */     String moneyAmount = this.request.getParameter("moneyAmount");
/* 152 */     so.setMoneyAmount(moneyAmount);
/*     */     
/* 154 */     List<Shopingcart> shopingcartList = new ArrayList<Shopingcart>();
/*     */ 
/*     */     
/* 157 */     String shopingcartIds = this.request.getParameter("shopingcartIds");
/* 158 */     String[] shopingcartIdList = shopingcartIds.split(","); byte b; int i; String[] arrayOfString;
/* 159 */     for (i = (arrayOfString = shopingcartIdList).length, b = 0; b < i; ) { String shopingcartId = arrayOfString[b];
/* 160 */       Shopingcart sc = this.shopingcartDao.findShopingcartById((new Integer(shopingcartId)).intValue());
/* 161 */       shopingcartList.add(sc); b++; }
/*     */     
/* 163 */     this.shopingcartDao.jiesuanShopingcart(so, shopingcartList);
/* 164 */     return "success";
/*     */   }
/*     */ }


/* Location:              E:\JavaWeb big\DeviceManage.war!\WEB-INF\classes\app\action\imp\ShopingcartActionImp.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.2
 */