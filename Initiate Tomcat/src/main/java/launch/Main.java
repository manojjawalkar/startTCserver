package main.java.launch;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;


public class Main {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
//		String webappDirLocation = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();

        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }
       

        tomcat.setPort(Integer.valueOf(webPort));
        Context ctx = tomcat.addContext("/", new File(".").getAbsolutePath());
        System.out.println(new File(".").getAbsolutePath());
//        Tomcat.addServlet(ctx, "hello",
//        		new HttpServlet(){
//        	protected void service(HttpServletRequest req, HttpServletResponse resp)
//                	throws ServletException, IOException {
////                	Writer w = resp.getWriter();
////                	w.write("Inside service method of hello servlet created inside code DYNAMICALLY");
////                	w.flush();
//        	}
//        });
        
//        ctx.addServletMapping("/*", "hello");
      //-----------------------------------------------------------------------------------------------------
     /*   String docBase = ".";
        String ctxPath = "/";
        Context ctx2 = tomcat.addWebapp(ctxPath, docBase);
     */
//        Tomcat.addServlet(ctx, "Metal", "main.java.launch.Metal");
//        ctx.addServletMapping("/Metal", "Metal");
     /*-----------------------------------------------------------------------------------------------------*/
        Tomcat.addServlet(ctx, "Vulnerable", "main.java.servlet.Vulnerable");
        ctx.addServletMapping("/Vulnerable", "Vulnerable");
        
     /*----------------------------------------------------------------------------------------------------*/
        Tomcat.addServlet(ctx, "CrossSiteScripting", "penetration.testing.CrossSiteScripting");
        ctx.addServletMapping("/CrossSiteScripting", "CrossSiteScripting");
      //-----------------------------------------------------------------------------------------------------  
        tomcat.getHost();
        
        System.out.println("Host: "+ tomcat.getHost());
         
        
//        tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
//        System.out.println("configuring app 90 with basedir: -- " + new File("./" + webappDirLocation).getAbsolutePath());
        System.out.println("starting server...");
//        System.out.println("configuring app with basedir: " + new File(webappDirLocation).getAbsolutePath());
        tomcat.start();
        System.out.println("started.");
        
//        URl = http://localhost:8080/CrossSiteScripting?user=%3Cscript%3Ealert%2855%29%3C/script%3E&passwd=admin
//        URl = http://localhost:8080/Vulnerable?n=Manoj&p=pasdwd
        
        String myUrl = "http://localhost:8080/CrossSiteScripting?user=shri&passwd=firstPassword";
        System.out.println("Initiating URL: "+ myUrl);
        URL url = new URL(myUrl); 
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        String httpMethod = con.getRequestMethod();
        while((inputLine=in.readLine()) != null){
        	response.append(inputLine);
        }
        in.close();
        System.out.println("\n----------------------\nHTTP Method : "+ httpMethod +"\nOutput: "+response.toString());
        
        tomcat.getServer().await();
    
	}

}
