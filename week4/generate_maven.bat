curl.exe "https://start.spring.io/starter.zip?type=maven-project&dependencies=cloud-eureka-server,devtools&groupId=com.cognizant&artifactId=eureka-discovery-server&name=eureka-discovery-server" -o eureka.zip
tar -xf eureka.zip -C eureka-discovery-server

curl.exe "https://start.spring.io/starter.zip?type=maven-project&dependencies=web,cloud-eureka,devtools&groupId=com.cognizant&artifactId=account&name=account" -o account2.zip
tar -xf account2.zip -C account

curl.exe "https://start.spring.io/starter.zip?type=maven-project&dependencies=web,cloud-eureka,devtools&groupId=com.cognizant&artifactId=loan&name=loan" -o loan.zip
tar -xf loan.zip -C loan

curl.exe "https://start.spring.io/starter.zip?type=maven-project&dependencies=web,cloud-eureka,devtools&groupId=com.cognizant&artifactId=greet-service&name=greet-service" -o greet.zip
tar -xf greet.zip -C greet-service

curl.exe "https://start.spring.io/starter.zip?type=maven-project&dependencies=cloud-gateway,cloud-eureka,actuator,devtools&groupId=com.cognizant&artifactId=api-gateway&name=api-gateway" -o gateway.zip
tar -xf gateway.zip -C api-gateway
