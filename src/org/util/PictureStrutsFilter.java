package org.util;


/*    */ import java.io.IOException;
/*    */ import javax.servlet.FilterChain;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
/*    */ import org.util.PictureStrutsFilter;
/*    */ 
/*    */ public class PictureStrutsFilter extends StrutsPrepareAndExecuteFilter {
/*    */   public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
/* 13 */     HttpServletRequest request = (HttpServletRequest)req;
/* 14 */     String url = request.getRequestURI();
/* 15 */     System.out.println(url);
/* 16 */     if (url.contains("/jsp/controller.jsp")) {
/* 17 */       chain.doFilter(req, res);
/*    */     } else {
/* 19 */       super.doFilter(req, res, chain);
/*    */     } 
/*    */   }
/*    */ }
