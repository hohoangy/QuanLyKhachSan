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
    <script src="https://code.highcharts.com/highcharts.src.js"></script>
</head>
<body>

	<jsp:include page="MenuBar.jsp"></jsp:include>

    <div class="main">
        <div class="topbar">
            <div class="toggle">
                <ion-icon name="menu-outline"></ion-icon>
            </div>
            <div class="search">
                <h3>THÔNG TIN HỆ THỐNG</h3>
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
                    <div class="card">
                        <div class="iconBx">
                            <ion-icon name="eye-outline"></ion-icon>
                        </div>
                        <div>
                            <div class="numbers">Thuê trong ngày</div>
                            <div class="cardName">${numOfRentedInDay } lượt</div>
                        </div>
                        
                    </div>
                    <div class="card">
                        <div class="iconBx">
                            <ion-icon name="cart-outline"></ion-icon>
                        </div>
                        <div>
                            <div class="numbers">Phòng chờ</div>
                            <div class="cardName">${numOfEmtyRoom } phòng</div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="iconBx">
                            <ion-icon name="chatbubbles-outline"></ion-icon>
                        </div>
                        <div>
                            <div class="numbers">Phòng đang thuê</div>
                            <div class="cardName">${numOfRentedRoom } phòng</div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="iconBx">
                            <ion-icon name="cash-outline"></ion-icon>
                        </div>
                        <div>
                            <div class="numbers">Phòng cần dọn</div>
                            <div class="cardName">${numOfRoomNeedClean } phòng</div>
                        </div> 
                    </div>
                </div>
                <div class="details">
                    <div class="recentOrder">
                        <div id="container" style="height: 400px; width: 950px"></div>
                        <script src="<%=request.getContextPath() %>/resources/js/Home.js"></script>
                    </div>
                    <div class="recentCustomers">
                        <div class="cardHeader">
                            <h2>Nhật ký hệ thống</h2>
                        </div>
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

        const $ = document.querySelector.bind(document)
        const $$ = document.querySelectorAll.bind(document)
        const title = $$('.title2')
        const panes = $$('.tab-pane')
        title.forEach((tab, index)=>{
            const pane = panes[index]
            tab.onclick = function(){
                $('.title2.active').classList.remove('active')
                $('.tab-pane.active').classList.remove('active')
                this.classList.add('active')
                pane.classList.add('active')

            }
        })
    </script>
</body>
</html>