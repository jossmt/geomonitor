gradle clean war
cd /usr/local/Tomcat/bin
sh shutdown.sh
cp ~/geomonitor/controller/build/libs/geomonitor.war /usr/local/Tomcat/webapps/
cd /usr/local/Tomcat/bin
sh startup.sh
