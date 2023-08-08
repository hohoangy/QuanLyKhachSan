<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOGIN</title>
    <!-- <link rel="stylesheet" href="css/Login.css"> -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/style.css">
    
    <script type="text/javascript" src=""></script>
</head>
<body>
    <!-- <div class="preloader">
      <div></div>
      <div>Loading Content!</div>
    </div> -->
    <header>
      <input type="checkbox" id="toggle-check">
      <nav>
          <div class="container">
              <h1>Hotel</h1>

          

              <div class="toggle">
                  <label for="toggle-check" class="toggle-btn"><span></span></i></label>
              </div>
          </div>
      </nav>
    </header>
    <div class="main">
        <form action="Login" method="post" class="form" id="form-1">
          <h3 class="heading">ĐĂNG NHẬP</h3>
          <p class="desc"></p>
      
          <div class="spacer"></div>
        
          <div class="form-group">
            <label for="taiKhoan" class="form-label">Tài khoản</label>
            <input id="taiKhoan" name="taiKhoan" type="text" value="${taiKhoan }" placeholder="Nhập mã nhân viên" class="form-control" required>
            <span class="form-message"></span>
          </div>
      
          <div class="form-group">
            <label for="matKhau" class="form-label">Mật khẩu</label>
            <input id="matKhau" name="matKhau" type="password" value="${matKhau }" placeholder="Nhập mật khẩu" class="form-control" required>
            <span class="form-message"></span>
          </div>
          <div class="checkbox">
            <input type="checkbox" value="true" id="rememberMe" name="rememberMe"> Nhớ mật khẩu
          </div>
      		<p class="errorMessage">${message }</p>
          <button class="form-submit" id="dangnhap" onclick="lsRememberMe()">Đăng nhập</button>
       </form>
      </div>
      <footer>
        <div class="container">
            <p>&copy;All Rights Reserved by ATHENA HOTEL</p>
        </div>
      </footer>
    
</body>
</html>