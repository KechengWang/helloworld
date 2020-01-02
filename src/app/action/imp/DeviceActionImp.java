package app.action.imp;


/*     */ import app.action.DeviceAction;
/*     */ import app.action.imp.DeviceActionImp;
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
/*     */ import org.model.Device;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DeviceActionImp
/*     */   extends ActionSupport
/*     */   implements DeviceAction, ServletRequestAware, ServletResponseAware
/*     */ {
/*     */   private HttpServletRequest request;
/*     */   private HttpServletResponse response;
/*     */   private DeviceDao deviceDao;
/*     */   
/*  30 */   public void setServletResponse(HttpServletResponse res) { this.response = res; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  35 */   public void setServletRequest(HttpServletRequest req) { this.request = req; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   public void setDeviceDao(DeviceDao deviceDao) { this.deviceDao = deviceDao; }
/*     */ 
/*     */   
/*     */   public void makeJson(List<Device> list) throws IOException {
/*  45 */     this.response.setHeader("Content-Type", "text/html;charset=utf-8");
/*  46 */     PrintWriter out = this.response.getWriter();
/*     */     
/*  48 */     JSONArray jsonArray = new JSONArray();
/*  49 */     for (Device dev : list) {
/*  50 */       JSONObject jsonObj = new JSONObject();
/*  51 */       jsonObj.put("DeviceID", dev.getDeviceId());
/*     */       
/*  53 */       jsonObj.put("DeviceClassId", dev.getDeviceclass()
/*  54 */           .getDeviceClassId());
/*  55 */       jsonObj.put("DeviceName", dev.getDeviceName());
/*  56 */       jsonObj.put("DevicePrice", dev.getDevicePrice());
/*  57 */       jsonArray.add(jsonObj);
/*     */     } 
/*  59 */     System.out.println(jsonArray.toString());
/*  60 */     JSONObject root = new JSONObject();
/*  61 */     root.put("result", jsonArray);
/*  62 */     out.write(root.toString());
/*  63 */     out.flush();
/*  64 */     out.close();
/*     */   }
/*     */ 
/*     */   
/*     */   public void findAllDevice() throws IOException {
/*  69 */     List<Device> list = this.deviceDao.findAllDevice();
/*  70 */     makeJson(list);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void findDeviceByDeviceClassId() throws IOException {
/*  79 */     String deviceClassId = this.request.getParameter("deviceClassId");
/*  80 */     List<Device> list = this.deviceDao.findDeviceByDeviceClassId((new Integer(
/*  81 */           deviceClassId)).intValue());
/*  82 */     makeJson(list);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void findDeviceById() throws IOException {
/*  90 */     String deviceId = this.request.getParameter("deviceId");
/*  91 */     Device dev = this.deviceDao.findDeviceById((new Integer(deviceId)).intValue());
/*  92 */     List<Device> list = new ArrayList<Device>();
/*  93 */     list.add(dev);
/*  94 */     makeJson(list);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void findDeviceByName() throws IOException {
/* 101 */     String deviceName = this.request.getParameter("deviceName");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     deviceName = new String(deviceName.getBytes("ISO-8859-1"), "UTF-8");
/* 107 */     List<Device> list = this.deviceDao.findDeviceByName(deviceName);
/* 108 */     makeJson(list);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void findDeviceByPrice() throws IOException {
/* 115 */     String low = this.request.getParameter("low");
/* 116 */     String high = this.request.getParameter("high");
/* 117 */     List<Device> list = this.deviceDao.findDeviceByPrice(low, high);
/* 118 */     makeJson(list);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void findDeviceByFuzzy() throws IOException {
/* 125 */     String deviceClassName = this.request.getParameter("deviceClassName");
/* 126 */     String deviceName = this.request.getParameter("deviceName");
/* 127 */     String low = this.request.getParameter("low");
/* 128 */     String high = this.request.getParameter("high");
/*     */     
/* 130 */     deviceClassName = new String(deviceClassName.getBytes("ISO-8859-1"), 
/* 131 */         "UTF-8");
/* 132 */     deviceName = new String(deviceName.getBytes("ISO-8859-1"), "UTF-8");
/* 133 */     List<Device> list = this.deviceDao.findDeviceByFuzzy(deviceClassName, 
/* 134 */         deviceName, low, high);
/* 135 */     makeJson(list);
/*     */   }
/*     */   
/*     */   public void updateDeviceById() throws IOException {
/* 139 */     String deviceId = this.request.getParameter("deviceId");
/* 140 */     String deviceName = this.request.getParameter("deviceName");
/* 141 */     deviceName = new String(deviceName.getBytes("ISO-8859-1"), 
/* 142 */         "UTF-8");
/* 143 */     String devicePrice = this.request.getParameter("devicePrice");
/* 144 */     this.deviceDao.updateDeviceById((new Integer(deviceId)).intValue(), deviceName, devicePrice);
/*     */     
/* 146 */     Device dev = this.deviceDao.findDeviceById((new Integer(deviceId)).intValue());
/* 147 */     List<Device> list = new ArrayList<Device>();
/* 148 */     list.add(dev);
/* 149 */     makeJson(list);
/*     */   }
/*     */ }


/* Location:              E:\JavaWeb big\DeviceManage.war!\WEB-INF\classes\app\action\imp\DeviceActionImp.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.2
 */