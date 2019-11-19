# Video Course

## Build

Right-click project name, select (Run As) -> (Maven build) -> (Goal=jar:jar)

## Run
1. Make sure MySQL server is up and runing
2. Make sure there is lesson schema created on MySQL database
3. Make sure the root username and password are correct in application.properties file
4. Run VideoCourseApplication.java as Java Application 
5. This application need valid user login, and the password is encrypted.
>to get encrypted password, debug unit test: ClassUserTest.java
encrypt("password") = $2a$10$Gm70oNYAp1XCl0tZPt7SVeWRL8c0POKRKS6VXdRHouhK8ARopoFxi
6. Check the application start correctly
> [call login service](http://localhost:8000/login)
Login as existing user: jwang@gmail.com/password (Make sure this user is stored in the lesson/class_user table in MySQL database.
[Test service /hello](http://localhost:8000/hello)
7. Postman
![Postman Get user](getUser.png)