# BookShop

Cài maven

Vào BookShop\src\main\resources\application.properties, 
sửa lại đường dẫn tùy theo máy tại spring.datasource.url=jdbc:h2:file:<đường dẫn>/BookShop/src/main/resources/h2Database/database

bật cmd lên, cd vào project BookShop rồi gõ mvn spring-boot:run

chờ tải xong hết, để check được chưa thì vào mạng hoặc dùng postman gõ đường dẫn localhost:8080/api/books
