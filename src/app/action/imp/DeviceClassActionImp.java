package app.action.imp;
/*    */ 
/*    */ import app.action.DeviceClassAction;
/*    */ import app.action.imp.DeviceClassActionImp;
/*    */ import com.alibaba.fastjson.JSONArray;
/*    */ import com.alibaba.fastjson.JSONObject;
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.apache.struts2.interceptor.ServletRequestAware;
/*    */ import org.apache.struts2.interceptor.ServletResponseAware;
/*    */ import org.dao.DeviceClassDao;
/*    */ import org.model.Deviceclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DeviceClassActionImp
/*    */   extends ActionSupport
/*    */   implements DeviceClassAction, ServletRequestAware, ServletResponseAware
/*    */ {
/*    */   private HttpServletRequest request;
/*    */   private HttpServletResponse response;
/*    */   private DeviceClassDao deviceClassDao;
/*    */   
/* 29 */   public void setServletResponse(HttpServletResponse res) { this.response = res; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 34 */   public void setServletRequest(HttpServletRequest req) { this.request = req; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 40 */   public void setDeviceClassDao(DeviceClassDao deviceClassDao) { this.deviceClassDao = deviceClassDao; }
/*    */ 
/*    */   
/*    */   public void makeJson(List<Deviceclass> list) throws IOException {
/* 44 */     this.response.setHeader("Content-Type", "text/html;charset=utf-8");
/* 45 */     PrintWriter out = this.response.getWriter();
/*    */     
/* 47 */     JSONArray jsonArray = new JSONArray();
/* 48 */     for (Deviceclass dc : list) {
/* 49 */       JSONObject jsonObj = new JSONObject();
/* 50 */       jsonObj.put("DeviceClassID", dc.getDeviceClassId());
/* 51 */       jsonObj.put("DeviceClassName", dc.getDeviceClassName());
/* 52 */       jsonArray.add(jsonObj);
/*    */     } 
/* 54 */     System.out.println(jsonArray.toString());
/* 55 */     JSONObject root = new JSONObject();
/* 56 */     root.put("result", jsonArray);
/* 57 */     out.write(root.toString());
/* 58 */     out.flush();
/* 59 */     out.close();
/*    */   }
/*    */ 
/*    */   
/*    */   public void findAllDeviceClass() throws IOException {
/* 64 */     List<Deviceclass> list = this.deviceClassDao.findAllDeviceClass();
/* 65 */     makeJson(list);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void findDeviceClass() throws IOException {
/* 72 */     String id = this.request.getParameter("deviceClassId");
/* 73 */     Deviceclass dc = this.deviceClassDao.findDeviceClass((new Integer(id)).intValue());
/* 74 */     List<Deviceclass> list = new ArrayList<Deviceclass>();
/* 75 */     list.add(dc);
/*    */     
/* 77 */     makeJson(list);
/*    */   }
/*    */ }


/* Location:              E:\JavaWeb big\DeviceManage.war!\WEB-INF\classes\app\action\imp\DeviceClassActionImp.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.2
 */