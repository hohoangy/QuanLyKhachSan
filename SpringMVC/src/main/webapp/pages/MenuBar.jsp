<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<div class="container">
        <div class="navigation">
            <ul>
                <li>
                    <a href="<%= request.getContextPath() %>/Home">
                        <i class="fa-solid fa-circle-exclamation"></i>
                        <span class="icon"><ion-icon name="logo-github"></ion-icon></span>
                        <span class="titlee">ATHENA HOTEL</span>
                    </a>
                </li>
                <li>
                    <a href="<%= request.getContextPath() %>/Home" class="title2 active">
                        <span class="icon"><ion-icon name="home-outline"></ion-icon></span>
                        <span class="title">TRANG CHÍNH</span>
                    </a>
                </li>
                <li>
                    <a href="<%= request.getContextPath() %>/Rent" class="title2">
                        <span class="icon"><ion-icon name="repeat-outline"></ion-icon></ion-icon></span>
                        <span class="title">THUÊ - TRẢ PHÒNG</span>
                    </a>
                </li>
               
                <li>
                    <a href="<%= request.getContextPath() %>/Customer" class="title2">
                        <span class="icon"><ion-icon name="man-outline"></ion-icon></span>
                        <span class="title">QUẢN LÍ KHÁCH HÀNG</span>
                    </a>
                </li>
                <li>
                    <a href="<%= request.getContextPath() %>/Room" class="title2">
                        <span class="icon"><ion-icon name="bed-outline"></ion-icon></span>
                        <span class="title">QUẢN LÍ PHÒNG</span>
                    </a>
                </li>
                 <li>
                    <a href="<%= request.getContextPath() %>/System" class="title2">
                        <span class="icon"><ion-icon name="settings-outline"></ion-icon></span>
                        <span class="title">QUẢN LÍ HỆ THỐNG</span>
                    </a>
                </li>
                <!--  <li>
                    <a href="./pages/Account.jsp" class="title2">
                        <span class="icon"><ion-icon name="person-circle-outline"></ion-icon></ion-icon></span>
                        <span class="title">TÀI KHOẢN</span>
                    </a>
                </li>-->
                <li>
                    <a href="<%= request.getContextPath() %>/Logout">
                        <span class="icon"><ion-icon name="log-out-outline"></ion-icon></span>
                        <span class="title">ĐĂNG XUẤT</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <input type="hidden" id="chucVu" value="${chucVu eq 'Admin' ? 0 : 1 }">
	<input type="hidden" id="maNV" value="${maNV }">