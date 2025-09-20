```shell
docker run --name mysql-container \
    -e MYSQL_ROOT_PASSWORD=123456 \
    -e MYSQL_DATABASE=mydatabase \
    -e MYSQL_USER=myuser \
    -e MYSQL_PASSWORD=mypassword \
    -p 3306:3306 \
    -d mysql:8.0
```

Giải thích:
--name mysql-container: Tên container.
-e MYSQL_ROOT_PASSWORD=123456: Mật khẩu root của MySQL.
-e MYSQL_DATABASE=mydatabase: Tự động tạo database khi khởi động.
-e MYSQL_USER=myuser và -e MYSQL_PASSWORD=mypassword: Tạo một user mới với mật khẩu.
-p 3306:3306: Map cổng 3306 của container với máy local.
-d mysql:8.0: Chạy MySQL phiên bản 8 trong chế độ nền.