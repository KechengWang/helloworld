package app.action.imp;
/*     */ 
/*     */ import app.action.ShopingorderitemAction;
/*     */ import app.action.imp.ShopingorderitemActionImp;
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
/*     */ import org.dao.ShopingorderDao;
/*     */ import org.dao.ShopingorderitemDao;
/*     */ import org.model.Device;
/*     */ import org.model.Shopingorder;
/*     */ import org.model.Shopingorderitem;
/*     */ 
/*     */ 
/*     */ public class ShopingorderitemActionImp
/*     */   extends ActionSupport
/*     */   implements ServletRequestAware, ServletResponseAware, ShopingorderitemAction
/*     */ {
/*     */   private HttpServletRequest request;
/*     */   private HttpServletResponse response;
/*     */   private ShopingorderitemDao shopingorderitemDao;
/*     */   private DeviceDao deviceDao;
/*     */   private ShopingorderDao shopingorderDao;
/*     */   
/*  34 */   public void setServletResponse(HttpServletResponse res) { this.response = res; }
/*     */ 
/*     */ 
/*     */   
/*  38 */   public void setServletRequest(HttpServletRequest req) { this.request = req; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   public void setShopingorderitemDao(ShopingorderitemDao shopingorderitemDao) { this.shopingorderitemDao = shopingorderitemDao; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   public void setDeviceDao(DeviceDao deviceDao) { this.deviceDao = deviceDao; }
/*     */ 
/*     */   
/*     */   public void makeJson(List<Shopingorderitem> list) throws IOException {
/*  52 */     this.response.setHeader("Content-Type", "text/html;charset=utf-8");
/*  53 */     PrintWriter out = this.response.getWriter();
/*     */     
/*  55 */     JSONArray jsonArray = new JSONArray();
/*  56 */     for (Shopingorderitem soi : list) {
/*  57 */       JSONObject jsonObj = new JSONObject();
/*  58 */       jsonObj.put("ShopingOrderItemID", soi.getShopingOrderItemId());
/*  59 */       jsonObj.put("ShopingOrderID", soi.getShopingorder().getShopingOrderId());
/*     */ 
/*     */       
/*  62 */       Integer deviceId = soi.getDevice().getDeviceId();
/*  63 */       Device dev = this.deviceDao.findDeviceById((new Integer(deviceId.intValue())).intValue());
/*  64 */       JSONObject jsonObjdev = new JSONObject();
/*  65 */       jsonObjdev.put("DeviceID", dev.getDeviceId());
/*  66 */       jsonObjdev.put("DeviceClassId", dev.getDeviceclass()
/*  67 */           .getDeviceClassId());
/*  68 */       jsonObjdev.put("DeviceName", dev.getDeviceName());
/*  69 */       jsonObjdev.put("DevicePrice", dev.getDevicePrice());
/*  70 */       jsonObj.put("Device", jsonObjdev);
/*     */       
/*  72 */       jsonObj.put("BuyNum", soi.getBuyNum());
/*  73 */       jsonArray.add(jsonObj);
/*     */     } 
/*  75 */     System.out.println(jsonArray.toString());
/*  76 */     JSONObject root = new JSONObject();
/*  77 */     root.put("result", jsonArray);
/*  78 */     out.write(root.toString());
/*  79 */     out.flush();
/*  80 */     out.close();
/*     */   }
/*     */ 
/*     */   
/*     */   public void findAllShopingorderitem() throws IOException {
/*  85 */     List<Shopingorderitem> list = this.shopingorderitemDao.findAllShopingorderitem();
/*  86 */     makeJson(list);
/*     */   }
/*     */   
/*     */   public void findShopingorderitemById() throws IOException {
/*  90 */     String id = this.request.getParameter("shopingorderitemId");
/*  91 */     Shopingorderitem shopingorderitem = this.shopingorderitemDao.findShopingorderitemById((new Integer(id)).intValue());
/*  92 */     List<Shopingorderitem> list = new ArrayList<Shopingorderitem>();
/*  93 */     list.add(shopingorderitem);
/*  94 */     makeJson(list);
/*     */   }
/*     */   
/*     */   public void findShopingorderitemListByShopingorderId() throws IOException {
/*  98 */     String id = this.request.getParameter("shopingorderId");
/*  99 */     List<Shopingorderitem> list = this.shopingorderitemDao.findShopingorderitemListByShopingorderId((new Integer(id)).intValue());
/* 100 */     makeJson(list);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 105 */   public void setShopingorderDao(ShopingorderDao shopingorderDao) { this.shopingorderDao = shopingorderDao; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String addShopingorderitem() throws IOException {
/* 111 */     String shopingOrderID = this.request.getParameter("shopingOrderID");
/* 112 */     String deviceID = this.request.getParameter("deviceID");
/* 113 */     String buyNum = this.request.getParameter("buyNum");
/*     */     
/* 115 */     Shopingorderitem soi = new Shopingorderitem();
/*     */     
/* 117 */     Shopingorder so = this.shopingorderDao.findShopingorderById((new Integer(shopingOrderID)).intValue());
/* 118 */     soi.setShopingorder(so);
/* 119 */     Device dev = this.deviceDao.findDeviceById((new Integer(deviceID)).intValue());
/* 120 */     soi.setDevice(dev);
/* 121 */     soi.setBuyNum(new Integer(buyNum));
/* 122 */     this.shopingorderitemDao.addShopingorderitem(soi);
/* 123 */     return "success";
/*     */   }
/*     */   
/*     */   public String deleteShopingorderitem() throws IOException {
/* 127 */     String id = this.request.getParameter("deleteShopingorderitemID");
/* 128 */     Shopingorderitem soi = this.shopingorderitemDao.findShopingorderitemById((new Integer(id)).intValue());
/* 129 */     this.shopingorderitemDao.deleteShopingorderitem(soi);
/*     */     
/* 131 */     return "success";
/*     */   }
/*     */ }


/* Location:              E:\JavaWeb big\DeviceManage.war!\WEB-INF\classes\app\action\imp\ShopingorderitemActionImp.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.2
 */