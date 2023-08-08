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
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/Service.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/selectbox.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/notify.css">
    
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
    <script src="<%= request.getContextPath() %>/resources/js/ServiceUsing.js"></script>
</head>
<body>
    <jsp:include page="MenuBar.jsp"/>
    
	<div class="main">
        <div class="topbar">
            <div class="toggle">
                <ion-icon name="menu-outline"></ion-icon>
            </div>
            <div class="search">
                <h3>DỊCH VỤ ĐÃ SỬ DỤNG</h3>
            </div>
            <div class="used">
                <label for="">Chào: </label>
                <span class="welcome">${userName}</span>
            </div>
        </div>
        <div class="topfour">
            <div class="tab-pane active">
                <div class="cardBoxss">
                    <div class="close">
                        <a href="<%=request.getContextPath() %>/System/Service">
                            <ion-icon name="arrow-back-outline"></ion-icon>
                        </a>
                    </div>
                    <div class="box_seach">
                        <label>
                            <input type="text" placeholder="Tìm theo tên khách hàng">
                            <ion-icon name="search-outline"></ion-icon>
                        </label>
                    </div>
                    <div class="box_add">
                        <button id="btn2" class="add">Sử dụng</button>
                    </div>
                </div>
                <div class="details">
                    <div class="recentOrder">
                        <div class="cardHeader">
                            <h2>DANH SÁCH DỊCH VỤ ĐÃ SỬ DỤNG</h2>
                            <button class="btn" id="btnViewAll">View All</button>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                	<td>Mã KH</td>
                                    <td>Tên khách hàng</td>
                                    <td>Tên phòng</td>
                                    <td>Tên dịch vụ</td>
                                    <td>Số lượng</td>
                                    <td>Trạng thái</td>
                                </tr>
                            </thead>
                            <tbody id="tbody">
                                
                            </tbody>
                        </table>
                    </div>
                    <div class="recentCustomerss" id="recentCustomerss">
                        <div class="cardHeader">
                            <h2>Thông tin chi tiết</h2>
                            <button class="snip1457">Lưu</button>
                        </div>
                        <div class="page">
                            <div class="field field_v1">
                              <label for="id-kh" class="ha-screen-reader">Mã khách hàng</label>
                              <input id="id-kh" class="field__input" placeholder="vd: KH01">
                              <span class="field__label-wrap" aria-hidden="true">
                                <span class="field__label">Mã khách hàng</span>
                              </span>
                            </div>
                            <div class="field field_v2">
                              <label for="last-name" class="ha-screen-reader">Tên khách hàng</label>
                              <input id="last-name"  class="field__input" placeholder="Tường">
                              <span class="field__label-wrap" aria-hidden="true">
                                <span class="field__label">Tên khách hàng</span>
                              </span>
                            </div>    
                            <div class="field field_v3">
                              <label for="service-name" class="ha-screen-reader">Tên dịch vụ</label>
                              <input id="service-name" class="field__input" placeholder="Bar">
                              <span class="field__label-wrap" aria-hidden="true">
                                <span class="field__label">Tên dịch vụ</span>
                              </span>
                            </div>
                            <div class="wrapper">
                                <select name="Trangthai" id="Trangthai" class="wrap">
                                    <option value="Yes" class="wraptext">Đã thanh toán</option>
                                    <option value="No" class="wraptext">Chưa thanh toán</option>
                                 </select>
                            </div>
                            <button id="exit-customer" class="exit-customer">Thoát</button>
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
                <label for="txtTenDVEdit" class="modal-label">
                    <ion-icon name="qr-code-outline" class="modal-icon"></ion-icon>
                    Tên dịch vụ
                </label>
                <input id="txtTenDVEdit" type="text" class="modal-input">
                <label for="txtQuantityEdit" class="modal-label">
                    <ion-icon name="cash-outline" class="modal-icon"></ion-icon>
                    Số lượng
                </label>				
				<input id="txtQuantityEdit" type="text" class="modal-input">
                <button class="btn-edit">
                    Done
                </button>
            </div>
        </div>
    </div>
    
    <div class="using-service-modal js-modal">
        <div class="modal-container">
            <div class="modal-close js-modal-close"><ion-icon name="close-outline"></ion-icon></div>
            <header class="modal-header">SỬ DỤNG DỊCH VỤ</header>
            <div class="modal-body">
                <label for="selPhong" class="modal-label">
                    <ion-icon name="person-outline" class="modal-icon"></ion-icon>
                    Phòng
                </label>
                <div class="wrapper">
                    <select name="Trangthai" id="selPhong" class="wrap" style="margin-bottom: 25px;">
                        
                     </select>
                </div>
                
                <label for="selDichVu" class="modal-label">
                    <ion-icon name="person-outline" class="modal-icon"></ion-icon>
                    Dịch vụ
                </label>
                <div class="wrapper">
                    <select name="dichvu" id="selDichVu" class="wrap" style="margin-bottom: 25px;">
                        
                     </select>
                </div>
                
                <label for="txtQuantity" class="modal-label">
                    <ion-icon name="qr-code-outline" class="modal-icon"></ion-icon>
                    Số lượng
                </label>
                <input id="txtQuantity" type="number" class="modal-input" value="1" min="1">
                <label for="txtUsingTime" class="modal-label">
                    <ion-icon name="cash-outline" class="modal-icon"></ion-icon>
                    Ngày sử dụng
                </label>
				<input id="txtUsingTime" type="date" class="modal-input">
				<input type="hidden" id="txtMaKH">
                <button class="btn-edit" id="btnUse">
                    Use
                </button>
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
    <input type="hidden" id="idPhong">
    <input type="hidden" id="idKH">
    <input type="hidden" id="idDV">

    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

 	<script>
	    const useBtn = document.querySelector('.add')
		const choose = document.querySelector('.recentCustomerss')
		const chooseClose = document.querySelector('.exit-customer')
		
		useBtn.addEventListener('click', showCustomer)
	    
	    function showCustomer(){
			choose.classList.add('openCus')
	    }
	
	    function hideCustomer(){
	    	choose.classList.remove('openCus')
	    }
	    
	    chooseClose.addEventListener('click', hideCustomer)
    </script>
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
        /* document.getElementById("btn2").onclick = function () {
                document.getElementById("recentCustomerss").style.display = 'block';
            }; */
            
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