# BookShop

Cài maven

Vào BookShop\src\main\resources\application.properties, 
sửa lại đường dẫn tùy theo máy tại spring.datasource.url=jdbc:h2:file:<đường dẫn>/BookShop/src/main/resources/h2Database/database

bật cmd lên, cd vào project BookShop rồi gõ mvn spring-boot:run

chờ tải xong hết, để check được chưa thì vào mạng hoặc dùng postman gõ đường dẫn localhost:8080/api/books

###############################################################################

Kích vào dấu edit nhìn cho rõ, không hiểu sao nó đưa lên 1 dòng nhìn loạn vl

Khi gặp bug hoặc lỗi dữ liệu thì vào lại file BookShop\src\main\resources\application.properties
sửa thuộc tính của spring.jpa.hibernate.ddl-auto
-   create-drop là tạo dữ liệu xong rồi xóa (lần chạy sau sẽ không có dữ liệu trước đó) (dùng khi gặp bug dữ liệu nhằm reset lại toàn bộ dữ liệu, bình thường ít dùng)
-   create là tạo dữ liệu (lần chạy sau vẫn còn)
-   update là cập nhật (nếu lần chạy sau có dữ liệu bị thay đổi sẽ cập nhật lại) (nên dùng)

Không rõ api thì vào BookShop/src/main/java/com/example/api/ có phân thành các class đối tượng, đầu mỗi hàm thực thi sẽ có url 

Dùng postman để thấy cấu trúc json đầu ra, cấu trúc json đầu vào được miêu tả ở dưới tại input 

###############################################################################


User:
Lấy tất cả user
GET: /api/users
input:
output: Array Json [] 

Lấy user theo id
GET: /api/users/{id}
input: String id vd: /api/users/user_5a25c4fd45
output: Object Json {}

Đăng kí user
POST: /api/user
input: Object Json {}
vd: {
    "username": "hung",
    "password": "hung123",
    "name": "Hung",
    "image":"",
    "phone": "1234567890",
    "address": "da nang",
}
output:

Đăng nhập user
POST: /api/user/username={username}&&password={password}
input:
output: Object Json {}
vd: {
    "username": "hung",
    "password": "hung123",
    "name": "Hung",
    "image":"",
    "phone": "1234567890",
    "address": "da nang",
}

Cập nhật user
PUT: /api/user
input: Object Json {} (như trên nhưng thêm thuộc tính id vd: "id": "user_5a25c4fd45",
output:

Xóa user 
DELETE: /api/user/{id}
input: String id
output:






Book:
Tương tự các chức năng user:
Xem tất cả: GET: /api/books
Xem theo id: GET: /api/books/{id}
Thêm sách: POST: /api/book
input: Object Json {}
vd: {
    "name": "sach giao khoa",
    "image": "",
    "author": "an",
    "description": "day la mo ta",
    "price": 10000,
    "categoryIds":["category_d86ad10984" , "category_f097313a35"]           // id thể loại lấy trong database categories, có 10 thể loại, 1 sách nhiều thể loại
}
output:

Cập nhật sách: PUT: /api/book
tương tự POST nhưng thêm id vd "id": "book_29a8492a57"

Xóa sách: DELETE: /api/book/{id}






Cart (1 cartItem):
Xem tất cả cartItem: GET: /api/carts
Xem cartItem theo id: GET: /api/carts/{id}      // id của cart
Xem cartItem theo id của người dùng (dùng cái này để lấy tất cả sản phẩm trong giỏ của user theo userId): /api/carts/userId={id}        // id của user
Thêm hàng vào giỏ : POST: /api/cart
input: Object Json {}
vd: {
   "userId": "user_5a25c4fd45",
   "bookId": "book_29a8492a57",
   "quantity": 1
}
output:

Cập nhật số lượng: PUT: /api/cart
tương tự POST nhưng thêm id vd "id": "cart_7e0272b8de"
hoặc: chỉ cần id và quantity
{
   "id": "cart_7e0272b8de",
   "quantity": 2
}

Xóa hàng khỏi giỏ: DELETE: /api/carts/{id}








































