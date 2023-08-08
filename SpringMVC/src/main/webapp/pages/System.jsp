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
</head>
<body>
    <jsp:include page="MenuBar.jsp"/>

    <div class="main">
        <div class="topbar">
            <div class="toggle">
                <ion-icon name="menu-outline"></ion-icon>
            </div>
            <div class="search">
                <h3>QUẢN LÍ HỆ THỐNG</h3>
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
                <div class="cardBoxxx">
                    <div class="carddd remove">
                        <a href="<%= request.getContextPath() %>/Account" class="hethong">
                            <div class="iconBxxx">
                                <ion-icon name="home-outline"></ion-icon>
                                <hr>
                            </div>
                            <div>
                                <div class="numbersss">Tài khoản</div>
                                <!-- <div class="cardNameee">Sales</div> -->
                            </div>
                        </a>
                    </div>
                    <div class="carddd remove">
                        <a href="<%= request.getContextPath() %>/Employee" class="hethong">
                            <div class="iconBxxx">
                                <ion-icon name="file-tray-outline"></ion-icon>
                                <hr>
                            </div>
                            <div>
                                <div class="numbersss">Nhân viên</div>
                                <!-- <div class="cardNameee">Comment</div> -->
                            </div>
                        </a>
                    </div>
                    <div class="carddd">
                        <a href="<%= request.getContextPath() %>/System/Service" class="hethong">
                            <div class="iconBxxx">
                                <ion-icon name="bookmark-outline"></ion-icon>
                                <hr>
                            </div>
                            <div>
                                <div class="numbersss">Dịch vụ</div>
                                <!-- <div class="cardNameee">Earning</div> -->
                            </div>
                        </a>
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
        
        let chucVu = document.querySelector('#chucVu').value
        let divRemove = document.querySelectorAll('.remove')

        if (chucVu == 1) {
        	for (let div of divRemove) {
        		
        		div.remove()
        	}
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