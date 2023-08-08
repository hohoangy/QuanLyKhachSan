<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HOTEL QUY NHƠN</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/Home.css">
    
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
    <script src="<%= request.getContextPath() %>/resources/js/Home.js"></script>
    <script src="<%= request.getContextPath() %>/resources/js/Customer.js"></script>
</head>
<body>
    <jsp:include page="MenuBar.jsp"/>

    <div class="main">
        <div class="topbar">
            <div class="toggle">
                <ion-icon name="menu-outline"></ion-icon>
            </div>
            <div class="search">
                <h3>QUẢN LÍ KHÁCH HÀNG</h3>
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
	                            <input type="text" name="txtSearch" id="txtSearch" placeholder="Tìm kiếm khách hàng">
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
	                                <td>Số điện thoại</td>
	                                <td>CMND/CCCD</td>
	                                <td>Quốc tịch</td>
	                                <td></td>
	                                <td></td>
	                            </tr>
	                        </thead>
	                        <tbody id="tbody">
	                        
	                       </tbody>
	                    </table>
	                </div>
	                <div class="recentCustomerss" id="recentCustomerss">
	             <!--     <form action="insertCustomer" method="post"> -->
                       <div class="cardHeader">
	                        <h2>Thêm mới</h2>
	                        <button class="snip1457" id="btnSave">Lưu</button>
	                    </div>
	                    <div class="page">
	                        <div class="field field_v1">
	                          <label for="first-name" class="ha-screen-reader">Họ và tên khách hàng</label>
	                          <input name="tenKH" id="tenKH" class="field__input" placeholder="vd: Thái Bá Tường">
	                          <span class="field__label-wrap" aria-hidden="true">
	                            <span class="field__label">Họ và tên khách hàng</span>
	                          </span>
	                        </div>
	                        <div class="field field_v2">
	                          <label for="last-name" class="ha-screen-reader">Số điện thoại</label>
	                          <input name="sdt" id="sdt"  class="field__input" placeholder="034xxxxxxx">
	                          <span class="field__label-wrap" aria-hidden="true">
	                            <span class="field__label">Số điện thoại</span>
	                          </span>
	                        </div>
	                        <div class="field field_v2">
	                            <label for="last-name" class="ha-screen-reader">CMND</label>
	                            <input name="cmnd" id="cmnd"   class="field__input" placeholder="xxxxxxxx">
	                            <span class="field__label-wrap" aria-hidden="true">
	                              <span class="field__label">CMND/CCCD</span>
	                            </span>
	                          </div>    
	                        <div class="field field_v3">
	                          <label for="queQuan" class="ha-screen-reader">Quốc tịch</label>
	                          <input name="quocTich" id="quocTich"  class="field__input" placeholder="Việt Nam">
	                          <span class="field__label-wrap" aria-hidden="true">
	                            <span class="field__label">Quốc tịch</span>
	                          </span>
	                        </div>
	                    </div>
	                  <!--  </form> -->
	                </div>
	            </div>
	        </div>
	     </div>
    </div>
    <div class="edit-modal js-modal">
        <div class="modal-container">
            <div class="modal-close js-modal-close"><ion-icon name="close-outline"></ion-icon></div>
            <header class="modal-header">CHỈNH SỬA</header>
            <div class="modal-body" id="updateCustomer">
                <label for="name" class="modal-label">
                    <ion-icon name="text-outline" class="modal-icon"></ion-icon>
                    Mã khách hàng
                  </label>
             
              <input id="maKHup" name="maKHup" type="text" class="modal-input" value="${customer.maKH}" readonly>

                <label for="name" class="modal-label">
                    <ion-icon name="text-outline" class="modal-icon"></ion-icon>
                    Tên khách hàng
                </label>
                <input id="tenKHup" name="tenKHup" type="text" class="modal-input" value="${customer.tenKH}">

                 <label for="name" class="modal-label">
                    <ion-icon name="text-outline" class="modal-icon"></ion-icon>
                    Số điện thoại
                </label>
                <input id="sdtup" name="sdtup" type="text" class="modal-input" value="${customer.sdt}">
                
                <label for="name" class="modal-label">
                    <ion-icon name="cash-outline"></ion-icon>
                    CMND/CCDD
                </label>
                <input id="cmndup" name="cmndup" type="text" class="modal-input" value="${customer.cmnd}" readonly>
                
                <label for="name" class="modal-label">
                    <ion-icon name="cash-outline"></ion-icon>
                    Quốc tịch
                </label>
                <input id="quocTichup" name="quocTichup" type="text" class="modal-input" value="${customer.quocTich}">
                
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
        // const $ = document.querySelector.bind(document)
        // const $$ = document.querySelectorAll.bind(document)
        // const title = $$('.title2')
        // const panes = $$('.tab-pane')
        // title.forEach((tab, index)=>{
        //     const pane = panes[index]
        //     tab.onclick = function(){
        //         $('.title2.active').classList.remove('active')
        //         $('.tab-pane.active').classList.remove('active')
        //         this.classList.add('active')
        //         pane.classList.add('active')

        //     }
        // })
    </script>
    <script>
        const editBtns = document.querySelectorAll('.js-edit')
        const modal = document.querySelector('.js-modal')
        const modalClose = document.querySelector('.js-modal-close')
        var element = "22";//document.getElementById('biencmnd')
        
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
    <script>
    	
    </script>
</body>
</html>