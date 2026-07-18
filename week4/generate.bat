mkdir eureka-discovery-server
curl.exe https://start.spring.io/starter.zip -d dependencies=cloud-eureka-server,devtools -d groupId=com.cognizant -d artifactId=eureka-discovery-server -d name=eureka-discovery-server -o eureka.zip
tar -xf eureka.zip -C eureka-discovery-server

mkdir account
curl.exe https://start.spring.io/starter.zip -d dependencies=web,cloud-eureka,devtools -d groupId=com.cognizant -d artifactId=account -d name=account -o account2.zip
tar -xf account2.zip -C account

mkdir loan
curl.exe https://start.spring.io/starter.zip -d dependencies=web,cloud-eureka,devtools -d groupId=com.cognizant -d artifactId=loan -d name=loan -o loan.zip
tar -xf loan.zip -C loan

mkdir greet-service
curl.exe https://start.spring.io/starter.zip -d dependencies=web,cloud-eureka,devtools -d groupId=com.cognizant -d artifactId=greet-service -d name=greet-service -o greet.zip
tar -xf greet.zip -C greet-service

mkdir api-gateway
curl.exe https://start.spring.io/starter.zip -d dependencies=cloud-gateway,cloud-eureka,actuator,devtools -d groupId=com.cognizant -d artifactId=api-gateway -d name=api-gateway -o gateway.zip
tar -xf gateway.zip -C api-gateway
