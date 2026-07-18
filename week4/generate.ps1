Invoke-WebRequest -Uri "https://start.spring.io/starter.zip?type=maven-project&language=java&bootVersion=3.3.4&baseDir=eureka-discovery-server&groupId=com.cognizant&artifactId=eureka-discovery-server&name=eureka-discovery-server&packageName=com.example.eurekaserver&packaging=jar&javaVersion=17&dependencies=cloud-eureka-server,devtools" -OutFile "eureka.zip"
Expand-Archive -Path eureka.zip -DestinationPath . -Force

Invoke-WebRequest -Uri "https://start.spring.io/starter.zip?type=maven-project&language=java&bootVersion=3.3.4&baseDir=account&groupId=com.cognizant&artifactId=account&name=account&packageName=com.cognizant.account&packaging=jar&javaVersion=17&dependencies=web,cloud-eureka,devtools" -OutFile "account.zip"
Expand-Archive -Path account.zip -DestinationPath . -Force

Invoke-WebRequest -Uri "https://start.spring.io/starter.zip?type=maven-project&language=java&bootVersion=3.3.4&baseDir=loan&groupId=com.cognizant&artifactId=loan&name=loan&packageName=com.cognizant.loan&packaging=jar&javaVersion=17&dependencies=web,cloud-eureka,devtools" -OutFile "loan.zip"
Expand-Archive -Path loan.zip -DestinationPath . -Force

Invoke-WebRequest -Uri "https://start.spring.io/starter.zip?type=maven-project&language=java&bootVersion=3.3.4&baseDir=greet-service&groupId=com.cognizant&artifactId=greet-service&name=greet-service&packageName=com.cts.greet&packaging=jar&javaVersion=17&dependencies=web,cloud-eureka,devtools" -OutFile "greet.zip"
Expand-Archive -Path greet.zip -DestinationPath . -Force

Invoke-WebRequest -Uri "https://start.spring.io/starter.zip?type=maven-project&language=java&bootVersion=3.3.4&baseDir=api-gateway&groupId=com.cognizant&artifactId=api-gateway&name=api-gateway&packageName=com.cts.gateway&packaging=jar&javaVersion=17&dependencies=cloud-gateway,cloud-eureka,actuator,devtools" -OutFile "gateway.zip"
Expand-Archive -Path gateway.zip -DestinationPath . -Force

Remove-Item *.zip
