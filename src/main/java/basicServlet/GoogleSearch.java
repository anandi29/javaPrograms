package basicServlet;
import java.io.*;  

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;  
  
public class GoogleSearch extends HttpServlet{  
public void doGet(HttpServletRequest req,HttpServletResponse res)  
throws ServletException,IOException  


{  
res.setContentType("text/html");  
PrintWriter pw=res.getWriter();  
  
HttpServletResponse response = null;
response.sendRedirect("http://www.google.com");  
  
pw.close();  
}}  