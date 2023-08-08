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
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/selectbox.css">
    <script src="../js/Home.js"></script>
     <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
    <script src="<%= request.getContextPath() %>/resources/js/Home.js"></script>
    <script src="<%= request.getContextPath() %>/resources/js/Employee.js"></script>
</head>
<body>
	<jsp:include page="MenuBar.jsp"/>
	<div class="main">
        <div class="topbar">
            <div class="toggle">
                <ion-icon name="menu-outline"></ion-icon>
            </div>
            <div class="search">
                <h2>QUẢN LÍ NHÂN VIÊN</h2>
            </div>
            <!-- <div class="search">
                <label>
                    <input type="text" placeholder="Search here">
                    <ion-icon name="search-outline"></ion-icon>
                </label>
            </div> -->
            <div class="used">
                <label for="">Chào: </label>
                <span class="welcome">${userName}</span>
            </div>
        </div>
       <div class="topfour">
	        <div class="tab-pane active">
	                <div class="cardBox">
	                    <div class="search">
	                        <label>
	                            <input type="text" name="txtSearch" id="txtSearch" placeholder="Tìm kiếm nhân viên">
	                            <ion-icon name="search-outline"></ion-icon>
	                        </label>
	                    </div>
	                    <div class="search">
	                        <button id="btn2" class="info-view-info">Thêm mới</button>
	                    </div>
	                    <div>
                    	<span class="errorMessage" id="errorMessage">${error}</span>
                    	</div>
	                </div>
            <div class="details">
                <div class="recentOrder">
                    <div class="cardHeader">
                        <h2></h2>
                        <a href="#" id="btnViewAll" class="btn">View All</a>
                    </div>
                    <table>
                        <thead>
                            <tr>
                                <td>ID</td>
                                <td>Họ tên</td>
                                <td>Giới tính</td>
                                <td>SĐT</td>
                                <td>Chức vụ</td>
                                <td>Lương</td>
                                <td></td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody id="tbody">
                          
                              
                        </tbody>
                    </table>
                </div>
                <div class="recentCustomerss" id="recentCustomerss">
                    <div class="cardHeader">
                        <h2>Thêm mới</h2>
                        <button class="snip1457" id="btnSave">Lưu</button>
                    </div>
              		<div class="page">
                            <div class="field field_v1">
                                <label for="first-name" class="ha-screen-reader">Mã NV</label>
                                <input id="maNVAdd" name="maNV" class="field__input" placeholder="vd: NV5">
                                <span class="field__label-wrap" aria-hidden="true">
                                  <span class="field__label">Mã NV</span>
                                </span>
                              </div>
                            <div class="field field_v1">
                              <label for="first-name" class="ha-screen-reader">Tên NV</label>
                              <input id="tenNV" name="tenNV" class="field__input" placeholder="vd: Dũng">
                              <span class="field__label-wrap" aria-hidden="true">
                                <span class="field__label">Tên NV</span>
                              </span>
                            </div>
                            <div class="datemember">
                                <div class="field field_v2">
                                   <label for="first-name" class="ha-screen-reader">Ngày sinh</label>
                                   <label for="start" class="date">Ngày sinh:</label>
                                    <input class="ngaysinh" type="date" id="ngaySinh" name="ngaySinh"  value=""
                                 min="1700-01-01" max="2022-12-31">
     
                                </div>
                            </div>
                            <div class="field field_v1">
                                <div class="wrapper">
	                                <select id="gioiTinh" name="gioiTinh" class="wrap">
	                                	<option value="true">Nam</option>
	                                	<option value="false">Nữ</option>
	                                </select>
                               	</div>
                                    
                            </div>
                          
                        
                            	
                            <div class="field field_v1">
                                    <label for="first-name" class="ha-screen-reader">Số điện thoại</label>
                                    <input id="sdt" name="sdt" class="field__input" placeholder="vd: 03xxx556">
                                    <span class="field__label-wrap" aria-hidden="true">
                                      <span class="field__label">Số điện thoại</span>
                                    </span>
                            </div>
                     
                            <div class="field field_v1">
                              <label for="first-name" class="ha-screen-reader">Lương</label>
                              <input id="luong" name="luong" class="field__input" placeholder="vd: 5000000">
                              <span class="field__label-wrap" aria-hidden="true">
                                <span class="field__label">Lương</span>
                              </span>
                            </div>
                            <div class="wrapper">
                                <select id="chucVuAdd" name="chucVu" class="wrap">
                                    <option value="Buồng phòng">Buồng phòng</option>
                                    <option value="Quản lý">Quản lý</option>
                                    <option value="Bảo vệ">Bảo vệ</option>
                                    <option value="Lễ tân">Lễ tân</option>
                                    <option value="Tạp vụ">Tạp vụ</option>
                                </select>
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
                    Mã NV
                </label>
                <input id="maNVup" name="maNVup" type="text" class="modal-input" placeholder="Mã NV" readonly>

                <label for="name" class="modal-label">
                    <ion-icon name="text-outline" class="modal-icon"></ion-icon>
                    Tên nhân viên
                </label>
                <input id="tenNVup" name="tenNVup" type="text" class="modal-input" placeholder="Tên nhân viên">
                
                <label for="name" class="modal-label">
                    <ion-icon name="call-outline"></ion-icon>
                    Số điện thoại
                </label>
                <input id="sdtup" name="sdtup" type="text" class="modal-input" placeholder="Số điện thoại">
                
                <label for="name" class="modal-label">
                    <ion-icon name="apps-outline"></ion-icon>
                    Chức vụ
                </label>
                 <div class="wrapper">
                <select id="chucVuup" name="chucVuup" class="wrap">
                                    <option value="Buồng phòng">Buồng phòng</option>
                                    <option value="Quản lý">Quản lý</option>
                                    <option value="Bảo vệ">Bảo vệ</option>
                                    <option value="Lễ tân">Lễ tân</option>
                                    <option value="Tạp vụ">Tạp vụ</option>
                                </select>
                </div>
                <label for="name" class="modal-label">
                   <ion-icon name="cash-outline"></ion-icon>
                    Lương
                </label>
                <input id="luongup" name="luongup" type="text" class="modal-input" placeholder="Lương">
                <button name="btnUpdate" id="btnUpdate" class="btn-edit">
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