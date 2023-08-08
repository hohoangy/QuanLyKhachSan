<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HOTEL QUY NHƠN</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/Home.css">
   <!--  <script src="../js/Home.js"></script> -->
     <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
    <script src="<%= request.getContextPath() %>/resources/js/Home.js"></script>
    <script src="<%= request.getContextPath() %>/resources/js/Account.js"></script>
</head>
<body>
    <jsp:include page="MenuBar.jsp"/>

    <div class="main">
        <div class="topbar">
            <div class="toggle">
                <ion-icon name="menu-outline"></ion-icon>
            </div>
            <div class="search">
                <h3>QUẢN LÍ TÀI KHOẢN</h3>
            </div>
            <div class="used">
                <label for="">Chào: </label>
                <span class="welcome">${userName}</span>
            </div>
        </div>
        <div class="topfour">
            <div class="tab-pane active">
                <!-- <div class="cardBox">
                    <div class="search">
                        <label>
                            <input type="text" placeholder="Tìm kiếm phòng">
                            <ion-icon name="search-outline"></ion-icon>
                        </label>
                    </div>
                    <div class="search">
                        <button id="btn2">Thêm mới</button>
                    </div>
                </div> -->
                <div class="details">
                    <div class="recentOrder">
                        <div class="cardHeader">
                            <h2>TÀI KHOẢN</h2>
                            <a href="#" class="btn" id="btnViewAll">View all</a>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                    <td>ID</td>
                                    <td>Họ tên</td>
                                    <td>Chức vụ</td>
                                    <td>Chỉnh sửa</td>
                                </tr>
                            </thead>
                            <tbody id="tbody">
                                <tr>
                                    <td>01</td>
                                    <td>tuong001</td>
                                    <td>123415</td>
                                    <td>
                                    <button class="room-icon js-edit" title="Chỉnh sửa"><ion-icon class="edit-icon" name="construct-outline"></ion-icon></button>
                                    <button class="room-icon" title="Xóa"><ion-icon class="delete-icon" name="trash-outline"></ion-icon></button>
                                    </td>
                                </tr>
                                <tr>
                                    <td>02</td>
                                    <td>tuong002</td>
                                    <td>123123</td>
                                    <td>
                                    <button class="room-icon js-edit" title="Chỉnh sửa"><ion-icon class="edit-icon" name="construct-outline"></ion-icon></button>
                                    <button class="room-icon"><ion-icon class="delete-icon" name="trash-outline"></ion-icon></button>
                                    </td>
                                </tr>
                                <tr>
                                    <td>03</td>
                                    <td>tuongngu</td>
                                    <td>tuongngu</td>
                                    <td>
                                    <button class="room-icon js-edit"><ion-icon class="edit-icon" name="construct-outline"></ion-icon></button>
                                    <button class="room-icon"><ion-icon class="delete-icon" name="trash-outline"></ion-icon></button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="recentCustomerss" id="recentCustomerss">
                        <div class="cardHeader">
                            <h2>Đăng kí tài khoản</h2>
                            <button class="snip1457">Đăng kí</button>
                        </div>
                        <div class="page">
                            <div class="field field_v1">
                                <label for="first-name" class="ha-screen-reader">Mã phòng</label>
                                <input id="first-name" class="field__input" placeholder="vd: P.201">
                                <span class="field__label-wrap" aria-hidden="true">
                                  <span class="field__label">ID</span>
                                </span>
                              </div>
                            <div class="field field_v1">
                              <label for="first-name" class="ha-screen-reader">Tài khoản</label>
                              <input id="first-name" class="field__input" placeholder="vd: Phòng 201">
                              <span class="field__label-wrap" aria-hidden="true">
                                <span class="field__label">Mật khẩu hiện tại</span>
                              </span>
                            </div>
                            <div class="field field_v1">
                                <label for="first-name" class="ha-screen-reader">Mật khẩu</label>
                                <input id="first-name" class="field__input" placeholder="vd: 100000">
                                <span class="field__label-wrap" aria-hidden="true">
                                  <span class="field__label">Mật khẩu mới</span>
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
                    ID
                </label>
                <input id="maNVup" type="text" class="modal-input" placeholder="ID">

                <label for="name" class="modal-label">
                    <ion-icon name="text-outline" class="modal-icon"></ion-icon>
                   Mật khẩu hiện tại
                </label>
                <input id="matKhauht" type="text" class="modal-input" placeholder="Mật khẩu hiện tại">
               
                <label for="name" class="modal-label">
                    <ion-icon name="text-outline" class="modal-icon"></ion-icon>
                    Mật khẩu mới
                </label>
                <input id="matKhaumoi" type="text" class="modal-input" placeholder="Mật khẩu mới">
                <button id="btnDone" class="btn-edit">
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