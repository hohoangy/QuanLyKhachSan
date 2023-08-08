<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SIGN UP</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/SignUp.css">
</head>
<body>
   <div class="main">

        <form action="" method="POST" class="form" id="form-1">
          <h3 class="heading">ĐĂNG KÍ TÀI KHOẢN</h3>
          <p class="desc"></p>
      
          <div class="spacer"></div>
      
          <div class="form-group">
            <label for="fullname" class="form-label">Tên nhân viên</label>
            <input id="fullname" name="fullname" type="text" placeholder="VD: Sallen" class="form-control" required>
            <span class="form-message"></span>
          </div>
          <div class="formg">
            <div class="form-group">
              <label for="email" class="form-label">Ngày sinh</label>
              <input class="datee" type="date" id="start" name="trip-start"
              value="2022-07-22"
              min="2001-01-01" max="2022-12-31" style="height: 35px; padding: 8px 12px;border: 1px solid #b3b3b3;">
              <span class="form-message"></span>
            </div>
            <div class="form-group" style="margin-left: 15px">
              <label for="email" class="form-label">Giới tính</label>
              <div class="radio">
                <input checked type="radio" id="age1" name="age" value="30" class="NamNu">
                <label for="age1" class="age">Nam</label><br>
                <input type="radio" id="age2" name="age" value="60" class="NamNu">
                <label for="age2" class="age">Nữ</label>
                <span class="form-message"></span>
            </div>
            </div>
          </div>
          <div class="form-group">
            <label for="email" class="form-label">Số điện thoại</label>
            <input id="email" name="email" type="text" placeholder="VD: 0348173164" class="form-control" required>
            <span class="form-message"></span>
          </div>
      
          <div class="form-group">
            <label for="password" class="form-label">Mật khẩu</label>
            <input id="password" name="password" type="password" placeholder="Nhập mật khẩu" class="form-control" required>
            <span class="form-message"></span>
          </div>
      
          <div class="form-group">
            <label for="password_confirmation" class="form-label">Nhập lại mật khẩu</label>
            <input id="password_confirmation" name="password_confirmation" placeholder="Nhập lại mật khẩu" type="password" class="form-control" required>
            <span class="form-message"></span>
          </div>
      
          <button class="form-submit">Đăng ký</button>
          <p class="message">Already registered?  <a href="./Login.jsp">Sign in</a></p>
        </form>
      
      </div>
    
</body>
</html>