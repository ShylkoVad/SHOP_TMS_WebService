FROM openjdk:20
ARG JAR_FILE
COPY target/SHOP_TMS_WebService-0.0.1-SNAPSHOT.jar /SHOP_TMS_WebService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/SHOP_TMS_WebService-0.0.1-SNAPSHOT.jar","-web -webAllowOthers -tcp -tcpAllowOthers -browser"]

