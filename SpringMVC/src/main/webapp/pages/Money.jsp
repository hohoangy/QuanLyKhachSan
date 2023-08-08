<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HOTEL QUY NHƠN</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/Home.css">
</head>
<body>
	<div class="container">
        <div class="navigation">
            <ul>
                <li>
                    <a href="#">
                        <i class="fa-solid fa-circle-exclamation"></i>
                        <span class="icon"><ion-icon name="logo-github"></ion-icon></span>
                        <span class="titlee">ATHENA HOTEL</span>
                    </a>
                </li>
                <li>
                    <a href="Home.jsp" class="title2 active">
                        <span class="icon"><ion-icon name="home-outline"></ion-icon></span>
                        <span class="title">TRANG CHÍNH</span>
                    </a>
                </li>
                <li>
                    <a href="Room.jsp" class="title2">
                        <span class="icon"><ion-icon name="repeat-outline"></ion-icon></span>
                        <span class="title">THUÊ - TRẢ PHÒNG</span>
                    </a>
                </li>
                <li>
                    <a href="Order.jsp" class="title2">
                        <span class="icon"><ion-icon name="calendar-number-outline"></ion-icon></span>
                        <span class="title">ĐẶT PHÒNG</span>
                    </a>
                </li>
                <li>
                    <a href="Customer.jsp" class="title2">
                        <span class="icon"><ion-icon name="accessibility-outline"></ion-icon></span>
                        <span class="title">QUẢN LÍ KHÁCH HÀNG</span>
                    </a>
                </li>
                <li>
                    <a href="RoomManage.jsp" class="title2">
                        <span class="icon"><ion-icon name="bed-outline"></ion-icon></span>
                        <span class="title">QUẢN LÍ PHÒNG</span>
                    </a>
                </li>
                <li>
                    <a href="System.jsp" class="title2">
                        <span class="icon"><ion-icon name="settings-outline"></ion-icon></span>
                        <span class="title">QUẢN LÍ HỆ THỐNG</span>
                    </a>
                </li>
                <li>
                    <a href="Account.jsp" class="title2">
                        <span class="icon"><ion-icon name="person-circle-outline"></ion-icon></span>
                        <span class="title">TÀI KHOẢN</span>
                    </a>
                </li>
                <li>
                    <a href="Login.jsp">
                        <span class="icon"><ion-icon name="log-out-outline"></ion-icon></span>
                        <span class="title">ĐĂNG XUẤT</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
	<div class="main">
        <div class="topbar">
            <div class="toggle">
                <ion-icon name="menu-outline"></ion-icon>
            </div>
            <div class="search">
                <h3>CÁCH TÍNH TIỀN</h3>
            </div>
            <div class="used">
                <label for="">Chào: </label>
                <span class="welcome">${userName}</span>
            </div>
        </div>
        <div class="topfour">
            <div class="tab-pane active">
                <div class="cardBox">
                    <!-- <div class="search">
                        <label>
                            <input type="text" placeholder="Search here">
                            <ion-icon name="search-outline"></ion-icon>
                        </label>
                    </div> -->
                    <div class="">
                        <a href="../html/System.html" style="font-size: 30px;">
                            <ion-icon name="arrow-back-outline"></ion-icon>
                        </a>
                    </div>
                    <div class="searchh">
                        <button id="btn2">Thêm mới</button>
                    </div>
                </div>
                <div class="details">
                    <div class="recentOrder">
                        <div class="cardHeader">
                            <h2>CÁCH TÍNH TIỀN THEO PHÒNG</h2>
                            <a href="#" class="btn">View All</a>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                    <td>Tên cách tính</td>
                                    <td>Giá qua đêm</td>
                                    <td>Giá ngày</td>
                                    <td>Phụ thu qua giờ </td>
                                    <td>Chỉnh sửa</td> 
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Phòng đơn</td>
                                    <td>1750000đ</td>
                                    <td>275000đ</td>
                                    <td>10000 đ/giờ</td>
                                    <td><button class="room-icon js-edit"><ion-icon class="edit-icon" name="construct-outline"></ion-icon></button></td>                                
                                </tr>
                                <tr>
                                    <td>Phòng đôi</td>
                                    <td>1750000đ</td>
                                    <td>275000đ</td>
                                    <td>10000 đ/giờ</td>
                                    <td><button class="room-icon js-edit"><ion-icon class="edit-icon" name="construct-outline"></ion-icon></button></td>                       
                                </tr>
                                <tr>
                                    <td>Phòng VIP</td>
                                    <td>2750000đ</td>
                                    <td>375000đ</td>
                                    <td>20000 đ/giờ</td>
                                    <td><button class="room-icon js-edit"><ion-icon class="edit-icon" name="construct-outline"></ion-icon></button></td>     
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="recentCustomerss" id="recentCustomerss">
                        <div class="cardHeader">
                            <h2>Thêm mới</h2>
                            <button class="snip1457">Lưu</button>
                        </div>
                        <div class="page">
                            <div class="field field_v1">
                              <label for="first-name" class="ha-screen-reader">Tên cách tính</label>
                              <input id="first-name" class="field__input" placeholder="vd: Phòng đôi hoặc đơn">
                              <span class="field__label-wrap" aria-hidden="true">
                                <span class="field__label">Tên cách tính</span>
                              </span>
                            </div>
                            <div class="field field_v2">
                              <label for="last-name" class="ha-screen-reader">Giá qua đêm</label>
                              <input id="last-name"  class="field__input" placeholder="17500000đ">
                              <span class="field__label-wrap" aria-hidden="true">
                                <span class="field__label">Giá qua đêm</span>
                              </span>
                            </div>    
                            <div class="field field_v3">
                              <label for="email" class="ha-screen-reader">Giá ngày</label>
                              <input id="email" class="field__input" placeholder="275000đ">
                              <span class="field__label-wrap" aria-hidden="true">
                                <span class="field__label">Giá ngày</span>
                              </span>
                            </div>
                            <div class="field field_v3">
                                <label for="email" class="ha-screen-reader">Phụ thu qua giờ</label>
                                <input id="email" class="field__input" placeholder="10000 đ/giờ">
                                <span class="field__label-wrap" aria-hidden="true">
                                  <span class="field__label">Phụ thu qua giờ</span>
                                </span>
                              </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="edit-modal js-modal">
        <div class="modal-container">
            <div class="modal-close js-modal-close"><ion-icon name="close-outline"></ion-icon></div>
            <header class="modal-header">CHỈNH SỬA</header>
            <div class="modal-body">
                <label for="name" class="modal-label">
                    <ion-icon name="text-outline" class="modal-icon"></ion-icon>
                    Tên cách tính
                </label>
                <input id="name" type="text" class="modal-input" placeholder="Tên cách tính">

                <label for="type" class="modal-label">
                    <ion-icon name="bed-outline" class="modal-icon"></ion-icon>
                    Giá qua đêm
                </label>
                <input id="type" type="text" class="modal-input" placeholder="Giá qua đêm">

                <label for="status" class="modal-label">
                    <ion-icon name="checkmark-done-circle-outline" class="modal-icon"></ion-icon>
                    Giá ngày
                </label>
                <input id="status" type="text" class="modal-input" placeholder="Giá ngày">

                <label for="type" class="modal-label">
                    <ion-icon name="bed-outline" class="modal-icon"></ion-icon>
                    Phụ thu qua giờ
                </label>
                <input id="type" type="text" class="modal-input" placeholder=" Phụ thu qua giờ">

                <button class="btn-edit">
                    Done
                </button>
            </div>
        </div>
    </div>

    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

    <script>
        //Menu
        let toggle = document.querySelector('.toggle');
        let navigation = document.querySelector('.navigation');
        let main = document.querySelector('.main');

        toggle.onclick = function(){
            navigation.classList.toggle('active')
            main.classList.toggle('active')
        }
         //onclick thêm mới
        document.getElementById("btn2").onclick = function () {
                document.getElementById("recentCustomerss").style.display = 'block';
            };
    </script>
    <script>
        const editBtns = document.querySelectorAll('.js-edit')
        const modal = document.querySelector('.js-modal')
        const modalClose = document.querySelector('.js-modal-close')
        
        function showedit(){
            modal.classList.add('open')
        }

        function hideShowedit(){
            modal.classList.remove('open')
        }
        for(const editBtn of editBtns){
            editBtn.addEventListener('click', showedit)
        }
        modalClose.addEventListener('click', hideShowedit)

    </script>
</body>
</html>