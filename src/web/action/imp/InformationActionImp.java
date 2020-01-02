package web.action.imp;


/*     */ 
/*     */ import com.opensymphony.xwork2.ActionSupport;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.UUID;
/*     */ import org.apache.struts2.ServletActionContext;
/*     */ import org.dao.InformationDao;
/*     */ import org.model.Information;
/*     */ import web.action.InformationAction;
/*     */ import web.action.imp.InformationActionImp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InformationActionImp
/*     */   extends ActionSupport
/*     */   implements InformationAction
/*     */ {
/*     */   private String informationTitle;
/*     */   private String informationImageFileName;
/*     */   private File informationImage;
/*     */   private String informationBrief;
/*     */   private String informationMainBody;
/*     */   InformationDao informationDao;
/*     */   
/*  36 */   public String getInformationTitle() { return this.informationTitle; }
/*     */ 
/*     */ 
/*     */   
/*  40 */   public void setInformationTitle(String informationTitle) { this.informationTitle = informationTitle; }
/*     */ 
/*     */ 
/*     */   
/*  44 */   public String getInformationImageFileName() { return this.informationImageFileName; }
/*     */ 
/*     */ 
/*     */   
/*  48 */   public void setInformationImageFileName(String informationImageFileName) { this.informationImageFileName = informationImageFileName; }
/*     */ 
/*     */ 
/*     */   
/*  52 */   public File getInformationImage() { return this.informationImage; }
/*     */ 
/*     */ 
/*     */   
/*  56 */   public void setInformationImage(File informationImage) { this.informationImage = informationImage; }
/*     */ 
/*     */ 
/*     */   
/*  60 */   public String getInformationBrief() { return this.informationBrief; }
/*     */ 
/*     */ 
/*     */   
/*  64 */   public void setInformationBrief(String informationBrief) { this.informationBrief = informationBrief; }
/*     */ 
/*     */ 
/*     */   
/*  68 */   public String getInformationMainBody() { return this.informationMainBody; }
/*     */ 
/*     */ 
/*     */   
/*  72 */   public void setInformationMainBody(String informationMainBody) { this.informationMainBody = informationMainBody; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  78 */   public void setInformationDao(InformationDao informationDao) { this.informationDao = informationDao; }
/*     */ 
/*     */   
/*     */   public String addInformation() throws IOException {
/*  82 */     Information information = new Information();
/*     */     
/*  84 */     String informationContent = "<x>" + this.informationTitle + "</x>" + "<x>" + 
/*  85 */       this.informationBrief + "</x>" + "<x>" + this.informationMainBody + 
/*  86 */       "</x>";
/*  87 */     information.setInformationContent(informationContent);
/*  88 */     SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  89 */     information.setInformationCreateTime(dFormat.format(new Date()));
/*     */     
/*  91 */     if (this.informationImageFileName != null) {
/*     */       
/*  93 */       String realPath = ServletActionContext.getRequest().getRealPath("/image");
/*  94 */       String hz = this.informationImageFileName
/*  95 */         .substring(this.informationImageFileName.lastIndexOf("."));
/*     */       
/*  97 */       String newFileName = String.valueOf(UUID.randomUUID().toString()) + hz;
/*     */       
/*  99 */       OutputStream os = new FileOutputStream(new File(realPath, 
/* 100 */             newFileName));
/*     */       
/* 102 */       String titleImageFullName = "/DeviceManage/image/" + newFileName;
/*     */       
/* 104 */       information.setInformationImage(titleImageFullName);
/*     */       
/* 106 */       InputStream is = new FileInputStream(this.informationImage);
/*     */       
/* 108 */       byte[] flush = new byte[1024];
/* 109 */       int len = 0;
/* 110 */       while ((len = is.read(flush)) >= 0) {
/* 111 */         os.write(flush, 0, len);
/*     */       }
/* 113 */       is.close();
/* 114 */       os.close();
/*     */     } else {
/* 116 */       System.out.println("未上传文件");
/*     */     } 
/* 118 */     this.informationDao.addInformation(information);
/* 119 */     return "success";
/*     */   }
/*     */ }

