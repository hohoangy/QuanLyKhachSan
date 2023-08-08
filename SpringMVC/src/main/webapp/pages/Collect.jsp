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
</head>
<body>
    <jsp:include page="MenuBar.jsp"/>

    <div class="main">
        <div class="topbar">
            <div class="toggle">
                <ion-icon name="menu-outline"></ion-icon>
            </div>
            <div class="search">
                <h3>QUẢN LÍ THU CHI</h3>
            </div>
            <!-- <div class="search">
                <label>
                    <input type="text" placeholder="Search here">
                    <ion-icon name="search-outline"></ion-icon>
                </label>
            </div> -->
            <div class="user">
                <img src="anhbac.jpg">
            </div>
        </div>
        <div class="topfour">
            <!-- <div class="tab-pane active">
                <div class="cardBox">
                    <div class="card">
                        <div>
                            <div class="numbers">2,504</div>
                            <div class="cardName">View</div>
                        </div>
                        <div class="iconBx">
                            <ion-icon name="eye-outline"></ion-icon>
                        </div>
                    </div>
                    <div class="card">
                        <div>
                            <div class="numbers">180</div>
                            <div class="cardName">Sales</div>
                        </div>
                        <div class="iconBx">
                            <ion-icon name="cart-outline"></ion-icon>
                        </div>
                    </div>
                    <div class="card">
                        <div>
                            <div class="numbers">484</div>
                            <div class="cardName">Comments</div>
                        </div>
                        <div class="iconBx">
                            <ion-icon name="chatbubbles-outline"></ion-icon>
                        </div>
                    </div>
                    <div class="card">
                        <div>
                            <div class="numbers">$17,842</div>
                            <div class="cardName">Earning</div>
                        </div>
                        <div class="iconBx">
                            <ion-icon name="cash-outline"></ion-icon>
                        </div>
                    </div>
                </div>
            </div> -->
            <div class="search">
                <button>Thêm mới</button>
            </div>
            <div class="details">
                <div class="recentOrder">
                    <div class="cardHeader">
                        <h2>Bảng thu chi</h2>
                        <a href="#" class="btn">View All</a>
                    </div>
                    <table>
                        <thead>
                            <tr>
                                <td>Loại hình</td>
                                <td>Thời gian</td>
                                <td>Số tiền</td>
                                <td>Nội dung</td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Phòng đôi</td>
                                <td>180'</td>
                                <td>1200$</td>
                                <td><span class="status delivered">Yes</span></td>
                            </tr>
                            <tr>
                                <td>Phòng đơn</td>
                                <td>2 days</td>
                                <td>800$</td>
                                <td><span class="status pending">No</span></td>
                            </tr>
                            <tr>
                                <td>Phòng đôi</td>
                                <td>3 days</td>
                                <td>1200$</td>
                                <td><span class="status return">No</span></td>
                            </tr>
                            <tr>
                                <td>Phòng đơn</td>
                                <td>2 days</td>
                                <td>900$</td>
                                <td><span class="status inprogress">No</span></td>
                            </tr>
                            <tr>
                                <td>Phòng đôi</td>
                                <td>4 days</td>
                                <td>1500$</td>
                                <td><span class="status delivered">Yes</span></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="recentCustomers">
                    <div class="cardHeader">
                        <h2>Thêm mới</h2>
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
</body>
</html>