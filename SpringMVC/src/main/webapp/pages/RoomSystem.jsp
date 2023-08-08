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
	<jsp:include page="MenuBar.jsp"/>
	
	<div class="main">
        <div class="topbar">
            <div class="toggle">
                <ion-icon name="menu-outline"></ion-icon>
            </div>
            <div class="search">
                <h3>LOẠI PHÒNG</h3>
            </div>
            <div class="used">
                <label for="">Chào: </label>
                <span class="welcome">${userName}</span>
            </div>
        </div>
        <div class="topfour">
            <div class="tab-pane active">
                <div class="cardBox">
                    <div class="">
                        <a href="../html/System.html" style="font-size: 30px;">
                            <ion-icon name="arrow-back-outline"></ion-icon>
                        </a>
                    </div>
                    <!-- <div class="search">
                        <label>
                            <input type="text" placeholder="Search here">
                            <ion-icon name="search-outline"></ion-icon>
                        </label>
                    </div> -->
                    <div class="searchh">
                        <button id="btn2">Thêm mới</button>
                    </div>
                </div>
                <div class="details">
                    <div class="recentOrder">
                        <div class="cardHeader">
                            <h2>DANH SÁCH LOẠI PHÒNG</h2>
                            <a href="#" class="btn">View All</a>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                    <td>Tên loại phòng</td>
                                    <td>Mô tả</td>
                                    <td>Chỉnh sửa</td>
                                    <td>Xóa </td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Phòng đơn</td>
                                    <td>Phòng đơn</td>
                                    <td><button class="room-icon js-edit"><ion-icon class="edit-icon" name="construct-outline"></ion-icon></button></td>
                                    <td><button class="room-icon"><ion-icon class="delete-icon" name="trash-outline"></ion-icon></button></td>
                                </tr>
                                <tr>
                                    <td>Phòng đôi</td>
                                    <td>Phòng đôi</td>
                                    <td><button class="room-icon js-edit"><ion-icon class="edit-icon" name="construct-outline"></ion-icon></button></td>
                                    <td><button class="room-icon"><ion-icon class="delete-icon" name="trash-outline"></ion-icon></button></td>
                                </tr>
                                <tr>
                                    <td>Phòng VIP</td>
                                    <td>Phòng VIP</td>
                                    <td><button class="room-icon js-edit"><ion-icon class="edit-icon" name="construct-outline"></ion-icon></button></td>
                                    <td><button class="room-icon"><ion-icon class="delete-icon" name="trash-outline"></ion-icon></button></td>
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
                              <label for="first-name" class="ha-screen-reader">Tên phòng</label>
                              <input id="first-name" class="field__input" placeholder="vd: P.201">
                              <span class="field__label-wrap" aria-hidden="true">
                                <span class="field__label">Tên phòng</span>
                              </span>
                            </div>
                            <div class="field field_v2">
                              <label for="last-name" class="ha-screen-reader">Loại phòng</label>
                              <input id="last-name"  class="field__input" placeholder="Phòng đôi">
                              <span class="field__label-wrap" aria-hidden="true">
                                <span class="field__label">Loại phòng</span>
                              </span>
                            </div>    
                            <div class="field field_v3">
                              <label for="email" class="ha-screen-reader">Trạng thái</label>
                              <input id="email" class="field__input" placeholder="Đã thuê">
                              <span class="field__label-wrap" aria-hidden="true">
                                <span class="field__label">Trạng thái</span>
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
                    Tên phòng
                </label>
                <input id="name" type="text" class="modal-input" placeholder="Tên phòng">

                <label for="type" class="modal-label">
                    <ion-icon name="bed-outline" class="modal-icon"></ion-icon>
                    Loại phòng
                </label>
                <input id="type" type="text" class="modal-input" placeholder="Loại phòng">

                <label for="status" class="modal-label">
                    <ion-icon name="checkmark-done-circle-outline" class="modal-icon"></ion-icon>
                    Trạng thái
                </label>
                <input id="status" type="text" class="modal-input" placeholder="Trạng thái">

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