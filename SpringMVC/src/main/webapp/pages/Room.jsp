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
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/Room.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/Bill.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/notify.css">
    
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
</head>
<body>
    <jsp:include page="MenuBar.jsp"/>

    <div class="main">
        <div class="topbar">
            <div class="toggle">
                <ion-icon name="menu-outline"></ion-icon>
            </div>
            <div class="search">
                <h3>THUÊ - TRẢ PHÒNG</h3>
            </div>
            <<div class="used">
                <label for="">Chào: </label>
                <span class="welcome">${userName }</span>
            </div>
        </div>
        <div class="topfour">
            <div class="tab-pane active">
                <div class="cardBox">                   
                    <div class="search">
                        <label>
                            <input type="text" placeholder="Tìm theo tên phòng" id="txtSearch">
                            <ion-icon name="search-outline"></ion-icon>
                        </label>
                    </div>

	            </div>
                </div>
                <div class="details">
                    <div class="recentOrder" style="padding: 0">
                        <div class="wrapper">
                            <div class="tabs">
                              <div class="tab">
                                <input type="radio" name="css-tabs" id="tab-1" checked class="tab-switch">
                                <label for="tab-1" class="tab-label">
                                    <ion-icon name="storefront-outline" class="icon-"></ion-icon>
                                    Phòng chờ</label>
                                <div class="tab-content" id="emptyRoom">
                                    
                                </div>
                              </div>
                              <div class="tab">
                                <input type="radio" name="css-tabs" id="tab-2" class="tab-switch">
                                <label for="tab-2" class="tab-label">
                                    <ion-icon name="id-card-outline"></ion-icon>
                                    Phòng đang thuê</label>
                                <div class="tab-content" id="rentedRoom">
                                    <button class="pay-bill" id="pay-bill">Trả phòng</button>
                                </div>
                              </div>
                        </div>
                    </div>

                </div>
                <div class="recentCustomerss" id="recentCustomerss">
                    <div class="cardHeader">
                        <h2>Thuê phòng</h2>
                    </div>
                    <div class="page">
                    	<div class="field field_v1">
                          <label for="phongThue" class="ha-screen-reader">Phòng thuê</label>
                          <input name="" id="phongThue" class="field__input" disabled="disabled">
                          <span class="field__label-wrap" aria-hidden="true">
                            <span class="field__label">Thuê phòng</span>
                          </span>
                        </div>
                        <div class="field field_v1">
                          <label for="txtName" class="ha-screen-reader">Họ và tên khách hàng</label>
                          <input name="tenKH" id="txtName" class="field__input" placeholder="vd: Thái Bá Tường">
                          <span class="field__label-wrap" aria-hidden="true">
                            <span class="field__label">Họ và tên khách hàng</span>
                          </span>
                        </div>
                        <div class="field field_v2">
                          <label for="txtSDT" class="ha-screen-reader">Số điện thoại</label>
                          <input name="sdt" id="txtSDT"  class="field__input" placeholder="034xxxxxxx">
                          <span class="field__label-wrap" aria-hidden="true">
                            <span class="field__label">Số điện thoại</span>
                          </span>
                        </div>    
                        <div class="field field_v1">
                          <label for="txtCMND" class="ha-screen-reader">CMND</label>
                          <input name="cmnd" id="txtCMND" class="field__input" placeholder="056xxxxxxxxxx" required>
                          <span class="field__label-wrap" aria-hidden="true">
                            <span class="field__label">CMND</span>
                          </span>
                        </div>
                        <div class="field field_v1">
                            <label for="txtQuocTich" class="ha-screen-reader">Quốc tịch</label>
                            <input name="quocTich" id="txtQuocTich" class="field__input" placeholder="Việt Nam">
                            <span class="field__label-wrap" aria-hidden="true">
                              <span class="field__label">Quốc tịch</span>
                            </span>
                        </div>
                        <div class="field field_v1">
                            <label for="start" class="date">Start date:</label>
                            <input class="datee" type="date" id="start" name="ngayDen"
                                 value="2022-07-22"
                                 min="2000-01-01" max="2022-12-31">
                        </div>
                        <div class="field field_v1">
                            <label for="start" class="date">End date :</label>
                            <input class="datee" type="date" id="end" name="ngayDi"
                                 value="2022-07-22"
                                 min="2000-01-01" max="2022-12-31">
                        </div>                         
                    </div>
                    <button class="pay-info" id="btnRent">Thuê</button>
                    <button class="exit-info">Thoát</button>
                </div>
                <div class="recentPays" id="recentPays">
                    <div class="cardHeader">
                        <h2>Thông tin khách hàng</h2>
                    </div>
                    <div class="page-info" id="customerInfo">
                        <div class="field field_v1">
                            <label for="txtName" class="ha-screen-reader">Họ và tên khách hàng</label>
                            <input name="tenKH" id="txtName" class="field__input" placeholder="vd: Thái Bá Tường" disabled>
                            <span class="field__label-wrap" aria-hidden="true">
                              <span class="field__label">Họ và tên khách hàng</span>
                            </span>
                          </div>
                          <div class="field field_v2">
                            <label for="txtSDT" class="ha-screen-reader">Số điện thoại</label>
                            <input name="sdt" id="txtSDT"  class="field__input" placeholder="034xxxxxxx" disabled>
                            <span class="field__label-wrap" aria-hidden="true">
                              <span class="field__label">Số điện thoại</span>
                            </span>
                          </div>    
                          <div class="field field_v3">
                            <label for="txtCMND" class="ha-screen-reader">CMND</label>
                            <input name="cmnd" id="txtCMND" class="field__input" placeholder="056xxxxxxxxxxx" disabled>
                            <span class="field__label-wrap" aria-hidden="true">
                              <span class="field__label">CMND</span>
                            </span>
                          </div>
                          <div class="field field_v3">
                              <label for="txtQuocTich" class="ha-screen-reader">Quốc tịch</label>
                              <input name="quocTich" id="txtQuocTich" class="field__input" placeholder="Việt Nam" disabled>
                              <span class="field__label-wrap" aria-hidden="true">
                                <span class="field__label">Quốc tịch</span>
                              </span>
                          </div>
                                               
                    </div>
                    <button class="exit-view">Thoát</button>
                </div>
                <div class="recentHotels" id="recentHotels">
                    <div class="cardHeader">
                        <img src="https://media-cdn.tripadvisor.com/media/photo-s/25/04/93/1e/blossom-hotel-houston.jpg" alt="">
                    </div>
                    <div class="page-info" id="roomInfo">
                        
                    </div>
                    <button class="exit-room">Thoát</button>
                </div>
            </div>      
        </div>
    </div>
    
    <input type="hidden" id="maPhongPost">
    <input type="hidden" id="maKHPost">
    
    <div class="bill-modal js-modal">
        <div class="bill-container">
        	<div class="modal-close js-modal-close"><ion-icon name="close-outline"></ion-icon></div>
            <header class="modal-header">HÓA ĐƠN</header>
            <div class="modal-body">
                <div class="information">
                    <p class="name" >Họ và tên khách hàng: <label class="label01">Thái Bá Tường</label> </p>
                    <p class="address" >Quê quán: <label class="label02">Bình định</label></p>
                    <p class="phone" >Số điện thoại: <label class="label03">01234567</label></p>
                    <p class="bill" >Mã hóa đơn: 47 <label class="label04" >Ngày: 13/05/2001</label></p> 
                </div>
                <p class="tp" >---------------Tiền phòng--------------</p>
                <div class="middle2">
                    <table border="1" class="content-table">
                        <thead>
                            <tr>
                                <td>Phòng</td>
                                <td>Số ngày</td>
                                <td>Ngày nhận phòng</td>
                                <td>Ngày trả phòng</td>
                                <td>Giá phòng</td>
                                <td>Thành tiền</td>
                            </tr>
                        </thead>
                        <tbody id="tbodyRoom">
                            <tr>
                                <td>P101</td>
                                <td>1</td>
                                <td>13/05/2001</td>
                                <td>13/05/2001</td>
                                <td>250000</td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td>Tổng tiền: </td>
                                <td>250000</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <p class="tp" >---------------Tiền dịch vụ--------------</p>
                <div class="middle3">
                    <table border="1" class="content-table">
                        <thead>
                            <tr>
                                <td>Tên dịch vụ</td>
                                <td>Số lượng</td>
                                <td>Đơn giá</td>
                                <td>Thành tiền</td>
                            </tr>
                        </thead>
                        <tbody id="tbodyService">
                            
                        </tbody>
                    </table>
                </div>
                <p class="tp" >---------------Tổng thanh toán--------------</p>
                <div class="middle4">
                    <table class="content-table">
                        <tbody id="thanhToan">
                            <tr>
                                <td></td>
                                <td></td>
                                <td>Tổng tiền: </td>
                                <td>265000</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td>Trả trước: </td>
                                <td>0</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td>Tổng thanh toán: </td>
                                <td>265000</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td>Khách trả: </td>
                                <td>265000</td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="btn-wrapper">
                    <button class="btnxd" id="btnXacNhan">Xác nhận</button>
                    <button class="btnxd js-close" id="btnHuy">Hủy</button>
                </div>
            </div>
         </div>
     </div>
     
     <div class="model hide" id="notify">
        <div class="model__inner">
            <div class="model__header">
                <p>Thông báo</p>
            </div>
            <div class="model__body">
                <!-- <h2>Modal</h2> -->
                <p>Bạn có chắc chắn xóa không?</p>
            </div>
            <div class="model__footer">
                <button class="yes" title="Yes">Yes</button>
                <button class="no" title="No">No</button>
            </div>  
        </div>
    </div>
    <input type="hidden" id="idDelete">

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
	    const editBtns = document.querySelectorAll('.pay-bill')
	    const pay = document.querySelector('.js-modal')
	    const payClose = document.querySelector('.js-modal-close')
	    const exitclose = document.querySelector('.js-close')
	        
	    function showedit(){
	        pay.classList.add('open')
	    }
	
	    function hideShowedit(){
	        pay.classList.remove('open')
	    }
	    for(const editBtn of editBtns){
	        editBtn.addEventListener('click', showedit)
	    }
	    payClose.addEventListener('click', hideShowedit)
	    exitclose.addEventListener('click', hideShowedit)
    </script>
    <script src="<%= request.getContextPath() %>/resources/js/Rent.js"></script>
</body>
</html>