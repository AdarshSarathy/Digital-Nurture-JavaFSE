cd eureka-discovery-server
call .\mvnw.cmd clean package -DskipTests
cd ..

cd account
call .\mvnw.cmd clean package -DskipTests
cd ..

cd loan
call .\mvnw.cmd clean package -DskipTests
cd ..

cd greet-service
call .\mvnw.cmd clean package -DskipTests
cd ..

cd api-gateway
call .\mvnw.cmd clean package -DskipTests
cd ..
