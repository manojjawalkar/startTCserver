# startTCserver
This repository contains code that can start an embedded tomcat server, automatically deploy a web-application and run it.

1. src.main.java.launch.Main.java is the class that is used for starting the TC server. This class is also responsible for deploying a web application and running it.
2. src.penetration.testing.CrossSiteScripting is a servlet that is deployed and run inside the TC server.
3. The homePage.jsp file can be found in src.penetration.testing package as well as in WebContent/WEB-INF folder.
4. When I start the server manually, instead of java code starting it, it runs as expected. And the homePage.jsp file under WEB-INF gets execyted and not the one inside src.penetration.testing package.