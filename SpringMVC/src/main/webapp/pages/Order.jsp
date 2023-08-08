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
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/selectbox.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/Room.css">
    <script src="../js/Home.js"></script>
     
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
    <script src="<%= request.getContextPath() %>/resources/js/Home.js"></script>
    <script src="<%= request.getContextPath() %>/resources/js/Order.js"></script>
</head>
<body>
    <jsp:include page="MenuBar.jsp"/>

    <div class="main">
        <div class="topbar">
            <div class="toggle">
                <ion-icon name="menu-outline"></ion-icon>
            </div>
            <div class="search">
                <h2>ĐẶT PHÒNG</h2>
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
                            <input type="text" placeholder="Tìm kiếm mã phòng">
                            <ion-icon name="search-outline"></ion-icon>
                        </label>
                    </div>
                    <div class="search">
                        <button style="border:none;" class="info-view-info">Tìm kiếm</button>
                    </div>
                </div>
                <div class="details">
                    <div class="recentOrder">
                        <div class="cardHeader">
                            <h2></h2>
                            <a href="#" class="btn">View All</a>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                    <td>Mã KH</td>
                                    <td>Mã phòng</td>
                                    <td>Mã NV</td>
                                    <td>Ngày đến</td>
                                    <td>Ngày đi</td>
                                    <td>Tiền cọc</td>
                                    <td>Trạng thái</td>
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody id="tbody">
                                <tr> 
                                    <td>KH01</td>
                                    <td>P101</td>
                                    <td>NV101</td>
                                    <td>23/10/2022</td>
                                    <td>27/10/2022</td>
                                    <td>300000đ</td>
                                    <td>Chưa biết</td>
                                    <td><button id="btn2" class="info-view">Đặt phòng</button></td>  
                                </tr>
                                <tr> 
                                    <td>KH02</td>
                                    <td>P102</td>
                                    <td>NV102</td>
                                    <td>23/10/2022</td>
                                    <td>27/10/2022</td>
                                    <td>150000đ</td>
                                    <td>Chưa biết</td>
                                    <td><button id="btn2" class="info-view">Đặt phòng</button></td>
                                </tr>
                                <tr>
                                    <td>KH03</td>
                                    <td>P103</td>
                                    <td>NV103</td>
                                    <td>23/10/2022</td>
                                    <td>27/10/2022</td>
                                    <td>300000đ</td>
                                    <td>Chưa biết</td>
                                    <td><button id="btn2" class="info-view">Đặt phòng</button></td>
                                </tr>
                                <tr>
                                    <td>KH04</td>
                                    <td>P104</td>
                                    <td>NV104</td>
                                    <td>23/10/2022</td>
                                    <td>27/10/2022</td>
                                    <td>150000đ</td>
                                    <td>Chưa biết</td>
                                    <td><button id="btn2" class="info-view">Đặt phòng</button></td>
                                </tr>
                               
                            </tbody>
                        </table>
                    </div>
                    <div class="recentCustomerss" id="recentCustomerss">
                        <div class="cardHeader">
                            <h2>Đặt phòng</h2>
                            <button class="snip1457">Lưu</button>
                        </div>
                        <div class="page">
                            <div class="field field_v1">
                                <label for="first-name" class="ha-screen-reader">Mã khách hàng</label>
                                <input id="maKH" class="field__input" placeholder="vd: KH01">
                                <span class="field__label-wrap" aria-hidden="true">
                                  <span class="field__label">Mã khách hàng</span>
                                </span>
                            </div>
                            <div class="datemember">
                                <p style="padding: 10px;">Phòng đặt : P101</p>
                              	 <input id="maPhong" class="field__input" placeholder="vd: KH01">
                            </div>
                            <div class="field field_v1">
                                <label for="first-name" class="ha-screen-reader">Mã nhân viên</label>
                                <input id="maNV" class="field__input" placeholder="vd: NV01">
                                <span class="field__label-wrap" aria-hidden="true">
                                  <span class="field__label">Mã nhân viên</span>
                                </span>
                            </div>
                            <div class="datemember">
                                <div class="field field_v3" style="margin-left: 10px">
                                    <label for="start"  style="margin-right: -10px;">Ngày đến:</label>
                                    <input class="date" type="date" id="ngayDen" name="trip-start"
                                         value="2022-07-22"
                                         min="2022-01-01" max="2022-12-31">
                                </div>
                                <div class="field field_v3" style="margin-left: 50px;">
                                    <label for="start"  style="margin-right: 7px;">Ngày đi:</label>
                                    <input class="date" type="date" id="ngayDi" name="trip-start"
                                         value="2022-07-22"
                                         min="2022-01-01" max="2022-12-31">
                                </div>
                            </div>
                            <div class="field field_v1">
                                <label for="first-name" class="ha-screen-reader">Tiền đặt trước</label>
                                <input id="tienCoc" class="field__input" placeholder="vd: 150000">
                                <span class="field__label-wrap" aria-hidden="true">
                                  <span class="field__label">Tiền đặt trước</span>
                                </span>
                            </div>
                            <div class="field field_v1">
                                <label for="first-name" class="ha-screen-reader">Ngày thực hiện</label>
                                <input id="ngayThucHien" class="field__input" placeholder="vd: 24/10/2022">
                                <span class="field__label-wrap" aria-hidden="true">
                                  <span class="field__label">Ngày thực hiện</span>
                                </span>
                            </div>
                           
                        </div>
                        <button class="exit-info" id="exit-info" style="border:none;margin-left: 20px;">Thoát</button>
                    </div>
                </div>
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
        const infoBtns = document.querySelectorAll('.info-view')
        const modal = document.querySelector('.recentCustomerss')
        const modalClose = document.querySelector('.exit-info')
        function showinfo(){
            modal.classList.add('open-info')
        }

        function hideinfo(){
            modal.classList.remove('open-info')
        }
        for(const infoBtn of infoBtns){
            infoBtn.addEventListener('click', showinfo)
        }
        modalClose.addEventListener('click', hideinfo)
    </script>
</body>
</html>