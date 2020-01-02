package app.action.imp;
/*     */ 
/*     */ import app.action.InformationAction;
/*     */ import app.action.imp.InformationActionImp;
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
/*     */ import org.dao.InformationDao;
/*     */ import org.model.Information;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InformationActionImp
/*     */   extends ActionSupport
/*     */   implements InformationAction, ServletRequestAware, ServletResponseAware
/*     */ {
/*     */   private HttpServletRequest request;
/*     */   private HttpServletResponse response;
/*     */   private InformationDao informationDao;
/*     */   
/*  29 */   public void setServletResponse(HttpServletResponse res) { this.response = res; }
/*     */ 
/*     */ 
/*     */   
/*  33 */   public void setServletRequest(HttpServletRequest req) { this.request = req; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   public void setInformationDao(InformationDao informationDao) { this.informationDao = informationDao; }
/*     */   
/*     */   public void makeJson(List<Information> list) throws IOException {
/*  41 */     this.response.setHeader("Content-Type", "text/html;charset=utf-8");
/*  42 */     PrintWriter out = this.response.getWriter();
/*     */     
/*  44 */     JSONArray jsonArray = new JSONArray();
/*  45 */     for (Information info : list) {
/*  46 */       JSONObject jsonObj = new JSONObject();
/*  47 */       jsonObj.put("InformationID", info.getInformationId());
/*  48 */       jsonObj.put("InformationContent", info.getInformationContent());
/*  49 */       jsonObj.put("InformationImage", info.getInformationImage());
/*  50 */       jsonObj.put("InformationCreateTime", info.getInformationCreateTime());
/*  51 */       jsonArray.add(jsonObj);
/*     */     } 
/*  53 */     System.out.println(jsonArray.toString());
/*  54 */     JSONObject root = new JSONObject();
/*  55 */     root.put("result", jsonArray);
/*  56 */     out.write(root.toString());
/*  57 */     out.flush();
/*  58 */     out.close();
/*     */   }
/*     */   
/*     */   public void findAllInformation() throws IOException {
/*  62 */     List<Information> list = this.informationDao.findAllInformation();
/*  63 */     makeJson(list);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findInformationById() throws IOException {
/*  68 */     String id = this.request.getParameter("infoId");
/*  69 */     Information info = this.informationDao.findInformationById((new Integer(id)).intValue());
/*  70 */     List<Information> list = new ArrayList<Information>();
/*  71 */     list.add(info);
/*     */     
/*  73 */     makeJson(list);
/*     */   }
/*     */ 
/*     */   
/*     */   public void showInformationByIdFromWebPortol() throws IOException {
/*  78 */     String infoId = this.request.getParameter("infoId");
/*  79 */     this.response.setHeader("Content-Type", "text/html;charset=utf-8");
/*  80 */     PrintWriter out = this.response.getWriter();
/*  81 */     Information information = this.informationDao.findInformationById((new Integer(infoId)).intValue());
/*  82 */     if (information != null) {
/*  83 */       String[] array = information.getInformationContent().split("<x>");
/*  84 */       String richtext = "<html><body><head><meta name='viewport' content='width=device-width, initial-scale=1.0, inimum-scale=0.5,maximum-scale=2.0,user-scalable=yes'/><style>img{max-width:100%;height:auto;}</style></head><div class='text' style='text- align:center;font-size:35px'><strong>" + 
/*     */ 
/*     */ 
/*     */         
/*  88 */         array[1] + 
/*  89 */         "</strong></div>" + 
/*  90 */         "<div class='text' style='text-align:center'>" + 
/*  91 */         "<img src=\"http://localhost:8080" + information.getInformationImage() + "\"/>" + 
/*  92 */         "</div>" + 
/*  93 */         "<div class='text' style='text-align:right'>" + 
/*  94 */         information.getInformationCreateTime() + 
/*  95 */         "</div>" + 
/*  96 */         "<div class='text' style='text-align:center;font-size:20px;font-style: italic;'><p><strong>" + 
/*  97 */         array[2] + "</strong></p></div>" + "<p>" + 
/*  98 */         array[3] + "</p></body></html>";
/*  99 */       out.write(richtext);
/* 100 */       out.flush();
/* 101 */       out.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void showInformationByIdFromAppPortol() throws IOException {
/* 109 */     String infoId = this.request.getParameter("infoId");
/* 110 */     this.response.setHeader("Content-Type", "text/html;charset=utf-8");
/* 111 */     PrintWriter out = this.response.getWriter();
/* 112 */     Information information = this.informationDao.findInformationById((new Integer(infoId)).intValue());
/* 113 */     if (information != null) {
/* 114 */       String[] array = information.getInformationContent().split("<x>");
/*     */       
/* 116 */       String str = array[3];
/* 117 */       array[3] = str.replace("http://localhost:8080", "");
/* 118 */       String richtext = "<html><body><head><meta name='viewport' content='width=device-width, initial-scale=1.0, inimum-scale=0.5,maximum-scale=2.0,user-scalable=yes'/><style>img{max-width:100%;height:auto;}</style></head><div class='text' style='text- align:center;font-size:35px'><strong>" + 
/*     */ 
/*     */ 
/*     */         
/* 122 */         array[1] + 
/* 123 */         "</strong></div>" + 
/* 124 */         "<div class='text' style='text-align:center'>" + 
/* 125 */         "<img src=\"" + information.getInformationImage() + "\"/>" + 
/* 126 */         "</div>" + 
/* 127 */         "<div class='text' style='text-align:right'>" + 
/* 128 */         information.getInformationCreateTime() + 
/* 129 */         "</div>" + 
/* 130 */         "<div class='text' style='text-align:center;font-size:20px;font-style: italic;'><p><strong>" + 
/* 131 */         array[2] + "</strong></p></div>" + "<p>" + 
/* 132 */         array[3] + "</p></body></html>";
/* 133 */       out.write(richtext);
/* 134 */       out.flush();
/* 135 */       out.close();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\JavaWeb big\DeviceManage.war!\WEB-INF\classes\app\action\imp\InformationActionImp.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.2
 */