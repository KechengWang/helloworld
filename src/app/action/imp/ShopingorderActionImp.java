package app.action.imp;
/*     */ import app.action.ShopingorderAction;
/*     */ import app.action.imp.ShopingorderActionImp;
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
/*     */ import org.dao.ShopingorderDao;
/*     */ import org.dao.UserDao;
/*     */ import org.model.Shopingorder;
/*     */ import org.model.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ShopingorderActionImp
/*     */   extends ActionSupport
/*     */   implements ServletRequestAware, ServletResponseAware, ShopingorderAction
/*     */ {
/*     */   private HttpServletRequest request;
/*     */   private HttpServletResponse response;
/*     */   private ShopingorderDao shopingorderDao;
/*     */   private UserDao userDao;
/*     */   
/*  33 */   public void setServletResponse(HttpServletResponse res) { this.response = res; }
/*     */ 
/*     */ 
/*     */   
/*  37 */   public void setServletRequest(HttpServletRequest req) { this.request = req; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  42 */   public void setShopingorderDao(ShopingorderDao shopingorderDao) { this.shopingorderDao = shopingorderDao; }
/*     */ 
/*     */   
/*     */   public void makeJson(List<Shopingorder> list) throws IOException {
/*  46 */     this.response.setHeader("Content-Type", "text/html;charset=utf-8");
/*  47 */     PrintWriter out = this.response.getWriter();
/*     */     
/*  49 */     JSONArray jsonArray = new JSONArray();
/*  50 */     for (Shopingorder shopingorder : list) {
/*  51 */       JSONObject jsonObj = new JSONObject();
/*  52 */       jsonObj.put("ShopingOrderID", new Integer(shopingorder.getShopingOrderId().toString()));
/*  53 */       jsonObj.put("UserId", shopingorder.getUser().getUserId());
/*  54 */       jsonObj.put("Receiver", shopingorder.getReceiver());
/*  55 */       jsonObj.put("ReceiveAddress", shopingorder.getReceiveAddress());
/*  56 */       jsonObj.put("Createtime", shopingorder.getCreatetime());
/*  57 */       jsonObj.put("MoneyAmount", shopingorder.getMoneyAmount());
/*  58 */       jsonArray.add(jsonObj);
/*     */     } 
/*  60 */     System.out.println(jsonArray.toString());
/*  61 */     JSONObject root = new JSONObject();
/*  62 */     root.put("result", jsonArray);
/*  63 */     out.write(root.toString());
/*  64 */     out.flush();
/*  65 */     out.close();
/*     */   }
/*     */ 
/*     */   
/*     */   public void findAllShopingorder() throws IOException {
/*  70 */     List<Shopingorder> list = this.shopingorderDao.findAllShopingorder();
/*  71 */     makeJson(list);
/*     */   }
/*     */   
/*     */   public void findShopingorderById() throws IOException {
/*  75 */     String id = this.request.getParameter("shopingorderId");
/*  76 */     Shopingorder shopingorder = this.shopingorderDao.findShopingorderById((new Integer(id)).intValue());
/*  77 */     List<Shopingorder> list = new ArrayList<Shopingorder>();
/*  78 */     list.add(shopingorder);
/*     */     
/*  80 */     makeJson(list);
/*     */   }
/*     */   
/*     */   public void findShopingorderByUserId() throws IOException {
/*  84 */     String id = this.request.getParameter("userId");
/*  85 */     List<Shopingorder> list = this.shopingorderDao.findShopingorderByUserId((new Integer(id)).intValue());
/*  86 */     makeJson(list);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  91 */   public void setUserDao(UserDao userDao) { this.userDao = userDao; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String addShopingorder() throws IOException {
/*  97 */     String userId = this.request.getParameter("userId");
/*  98 */     String receiver = this.request.getParameter("receiver");
/*  99 */     String receiveAddress = this.request.getParameter("receiveAddress");
/* 100 */     String createtime = this.request.getParameter("createtime");
/* 101 */     String moneyAmount = this.request.getParameter("moneyAmount");
/*     */     
/* 103 */     Shopingorder so = new Shopingorder();
/*     */     
/* 105 */     User user = this.userDao.findUserById((new Integer(userId)).intValue());
/* 106 */     so.setUser(user);
/* 107 */     so.setReceiver(receiver);
/* 108 */     so.setReceiveAddress(receiveAddress);
/* 109 */     so.setCreatetime(createtime);
/* 110 */     so.setMoneyAmount(moneyAmount);
/*     */     
/* 112 */     this.shopingorderDao.addShopingorder(so);
/* 113 */     return "success";
/*     */   }
/*     */   
/*     */   public String deleteShopingorder() throws IOException {
/* 117 */     String id = this.request.getParameter("deleteShopingorderID");
/* 118 */     Shopingorder so = this.shopingorderDao.findShopingorderById((new Integer(id)).intValue());
/* 119 */     this.shopingorderDao.deleteShopingorder(so);
/*     */     
/* 121 */     return "success";
/*     */   }
/*     */ }


/* Location:              E:\JavaWeb big\DeviceManage.war!\WEB-INF\classes\app\action\imp\ShopingorderActionImp.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.2
 */