// context path
var ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

$( document ).ready(function() {
	getRoomEmpty()
})

$(document).on("click",".exit-view", function(e){
	$('#recentPays').hide()
})

$(document).on("click",".exit-room", function(e){
	$('#recentHotels').hide()
})

$(document).on("click",".exit-info", function(e){
	$('#recentCustomerss').hide()
})

$(document).on("click", ".tab-item-third", function(e){

	let maPhong = $(this).closest(".tab-item-2").attr("id")

	$.ajax({
        url: `Rent/GetRentedInfoByRoomID`,
        type: 'GET',
        dataType: 'json',
        data: {
			maPhong: maPhong
		}
    }).done(function(response) {
       	renderCustomer(response.customer)
       	
       	$('#recentPays').show()
		$('#recentCustomerss').hide()
		$('#recentHotels').hide()
    })
	
})

$("#tab-1").click(function(){
	getRoomEmpty()
})

$("#tab-2").click(function(){
	getRentedRoom()
})

// event view room
$(document).on("click", ".tab-item-second", function() {
	let maPhong = $(this).closest(".tab-item").attr("id")
	
	getRoom(maPhong)
	
	$('#recentCustomerss').hide()
	$('#recentPays').hide()
	$('#recentHotels').show()
})

// event check out
$(document).on("click", "#btn4", function(e){
	$('.bill-modal').addClass('open')
	
	let maPhong = $(this).closest(".tab-item-2").attr("id")
	let maKH = $(this).closest("tr").attr("id")
	$('#maKHPost').val(maKH)
	$('#maPhongPost').val(maPhong)
	
	$.ajax({
        url: `Rent/GetInfoCheckOut`,
        type: 'GET',
        dataType: 'json',
        data: {
			maKH: maKH,
			maPhong: maPhong
		}
    }).done(function(response) {
       	renderModalBill(response)
    })
	
	// ngăn event hiện thông tin khách hàng   
	e.stopPropagation()
})

$(document).on("click", "#btnXacNhan", function() {
	
	let maPhong = $('#maPhongPost').val()
	let maKH = $('#maKHPost').val()
	let thanhTien = $('#tongTien').text();
	console.log(thanhTien)
	
	$.ajax({
        url: 'Rent/CheckOut',
        type: 'POST',
        dataType: 'json',
        data: {
			maPhong: maPhong,
			maKH: maKH,
			trangThai: 1,
			thanhTien: thanhTien,
			ngayThanhToan: new Date()
		}
    }).done(function(response) {        
       	if(response != 0) {
			getRentedRoom()
			
			$('.bill-modal').removeClass('open')
		} else {
			console.log("failed")
		}
    })
})

// event cancel rent room
$(document).on("click", "#btn3", function(){

	$('#notify').removeClass('hide')
	$('#notify').addClass('active')
	
	let maPhong = $(this).closest('.tab-item-2').attr('id')
	$('#idDelete').val(maPhong)
	
	// ngăn event hiện thông tin khách hàng   
	 e.stopPropagation()
	
})

$(document).on('click', '.yes', function (){

	let maPhong = $('#idDelete').val()
	
	$.ajax({
        url: 'Rent/CancelRenting',
        type: 'POST',
        dataType: 'json',
        data: {
			maPhong: maPhong
		}
	    }).done(function(response) {        
	       	if(response != 0) {
		
				getRentedRoom()
				
				$('#notify').addClass('hide')
				$('#notify').removeClass('active')	
			} else {
				console.log("failed")
			}
	    })
})


$(document).on('click', '.no', function (){

	$('#notify').addClass('hide')
	$('#notify').removeClass('active')	
})

// event search
$('#txtSearch').keypress(function(e) {
	var key = e.which;
	let searchVal = $('#txtSearch').val()

	if(key == 13 && !searchVal == "")  // the enter key code
	{
		$.ajax({
        url: 'Rent/Search',
        type: 'GET',
        dataType: 'json',
        data: {
			tenPhong: searchVal
		}
	    }).done(function(response) {        
	       	renderEmptyRoom(response.emptyRoomList)
	       	renderRentedRoom(response.rentedRoomList)
	    })
	}
})

$(document).on("click", ".btn-thue", function(e){
	$('#recentCustomerss').show()
	$('#recentPays').hide()
	$('#recentHotels').hide()
	
	let maPhong = $(this).closest(".tab-item").attr("id")
	let tenPhong = $(this).closest(".tab-item").find('.tenPhong').text()
	
	$('#maPhongPost').val(maPhong)
	$('#phongThue').val(tenPhong)
})

$(document).on("click", '#btnRent', function(e) {

	let tenKH = $('#txtName').val()
	let sdt = $('#txtSDT').val()
	let cmnd = $('#txtCMND').val()
	let quocTich = $('#txtQuocTich').val()
	let vip = $('#txtVIP').val()
	let startDate = $('#start').val()
	let endDate = $('#end').val()
	let maNV = $('#maNV').val()
	let maPhong = $('#maPhongPost').val()
	
	$.ajax({
	    url: 'Rent/RentRoom',
	    type: 'POST',
	    dataType: 'json',
	    data: {
			tenKH: tenKH,
			sdt: sdt,
			cmnd: cmnd,
			quocTich: quocTich,
			vip: vip,
			ngayDen: new Date(startDate),
			ngayDi: new Date(endDate),
			maNV: maNV,
			maPhong: maPhong,
			vip: 0
		}
    }).done(function(response) {     
    	   getRentedRoom()
    	   getRoomEmpty()
		$('#recentCustomerss').hide()
    })
})

function renderCustomer(customer) {
	let html = `<div class="field field_v1">
	                <label for="txtName" class="ha-screen-reader">Họ và tên khách hàng</label>
	                <input name="tenKH" id="txtName" class="field__input" value="${customer.tenKH}" disabled>
	                <span class="field__label-wrap" aria-hidden="true">
	                  <span class="field__label">Họ và tên khách hàng</span>
	                </span>
	              </div>
	              <div class="field field_v2">
	                <label for="txtSDT" class="ha-screen-reader">Số điện thoại</label>
	                <input name="sdt" id="txtSDT"  class="field__input" value="${customer.sdt}" disabled>
	                <span class="field__label-wrap" aria-hidden="true">
	                  <span class="field__label">Số điện thoại</span>
	                </span>
	              </div>    
	              <div class="field field_v3">
	                <label for="txtCMND" class="ha-screen-reader">CMND</label>
	                <input name="cmnd" id="txtCMND" class="field__input" value="${customer.cmnd}" disabled>
	                <span class="field__label-wrap" aria-hidden="true">
	                  <span class="field__label">CMND</span>
	                </span>
	              </div>
	              <div class="field field_v3">
	                  <label for="txtQuocTich" class="ha-screen-reader">Quốc tịch</label>
	                  <input name="quocTich" id="txtQuocTich" class="field__input" value="${customer.quocTich}" disabled>
	                  <span class="field__label-wrap" aria-hidden="true">
	                    <span class="field__label">Quốc tịch</span>
	                  </span>
	              </div>`
	$('#customerInfo').empty()
	$('#customerInfo').append(html)
}

function renderModalBill(list) {

	let infoUsingService = ''
	let tongTienPhong = 0
	let tongTienDV = 0
	
	// các dịch vụ đã sử dụng
	let serviceUsing = list.serviceUsingRoom
	
	// phòng đã thuê
	let rentedRoom = list.rentedRoom
	
	// phòng đã thuê
	let reservationRoom = null
	
	// thông tin khách hàng
	let info = `<p class="name">Họ và tên khách hàng: <label class="label01">${rentedRoom.customer.tenKH}</label></p>
	            <p class="address" >Quê quán: <label class="label02">${rentedRoom.customer.quocTich}</label></p>
	            <p class="phone" >Số điện thoại: <label class="label03">${rentedRoom.customer.sdt}</label></p>`
	
	$('.information').empty()
	$('.information').append(info)
	
	let ngayDen = new Date(rentedRoom.ngayDen).toLocaleDateString()
	let ngayDi = new Date(rentedRoom.ngayDi).toLocaleDateString()
	
	// The number of milliseconds in one day
    const ONE_DAY = 1000 * 60 * 60 * 24
    
    // tính số ngày giữa 2 ngày
	let soNgaySub = Math.abs((new Date(rentedRoom.ngayDi) - new Date(rentedRoom.ngayDen)) / ONE_DAY)
	
	// tính số ngày ở
	let soNgayO = soNgaySub != 0 ? soNgaySub : 1
	
	// tiền phòng
	let thanhTien = soNgayO * rentedRoom.room.gia
	tongTienPhong = thanhTien
	
	// thông tin thuê phòng
	let infoRent = `<tr>
	                    <td>${rentedRoom.room.tenPhong}</td>
	                    <td>${soNgayO}</td>
	                    <td>${ngayDen}</td>
	                    <td>${ngayDi}</td>
	                    <td>${rentedRoom.room.gia}</td>
	                    <td>${thanhTien}</td>
	                </tr>
	                <tr>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td>Tổng tiền: </td>
	                    <td>${thanhTien}</td>`
	 
	 $('#tbodyRoom').empty()
	 $('#tbodyRoom').append(infoRent)

	// thông tin dịch vụ đã sử dụng
	$.each(serviceUsing, function(key, value) {                 
		 let thanhTienDV = value.service.giaDV * value.soLuong
		 tongTienDV += thanhTienDV
		 infoUsingService += `<tr>
	                            <td>${value.service.tenDV}</td>
	                            <td>${value.soLuong}</td>
	                            <td>${value.service.giaDV}</td>
	                            <td>${thanhTienDV}</td>
	                        </tr>`
	})
	
	infoUsingService += `<tr>
                            <td></td>
                            <td></td>
                            <td>Tổng tiền: </td>
                            <td>${tongTienDV}</td>
                        </tr>`
		 
	 $('#tbodyService').empty()
	 $('#tbodyService').append(infoUsingService)
	
	// tính tổng tiền và thanh toán
	let tongTien = tongTienPhong + tongTienDV
	let thanhToan = `<tr>
	                    <td></td>
	                    <td></td>
	                    <td>Tổng tiền: </td>
	                    <td id="tongTien">${tongTien}</td>
	                    <td></td>
	                </tr>
	                <tr>
	                    <td></td>
	                    <td></td>
	                    <td>Tổng thanh toán: </td>
	                    <td id="tongTien">${tongTien}</td>
	                    <td></td>
	                </tr>
	                <tr>
	                    <td></td>
	                    <td></td>
	                    <td>Khách trả: </td>
	                    <td>${reservationRoom == null ? tongTien : tongTien - reservationRoom.tienCoc}</td>
	                    <td></td>
	                </tr>`
	  $('#thanhToan').empty()
	  $('#thanhToan').append(thanhToan)
}

function getRoomEmpty(){
	$.ajax({
        url: 'Rent/GetEmptyRoom',
        type: 'GET',
        dataType: 'json',
        data: {}
    }).done(function(response) {        
       	renderEmptyRoom(response)
    })
}

function getRentedRoom(){
	$.ajax({
        url: 'Rent/GetRentedInfo',
        type: 'GET',
        dataType: 'json',
        data: {}
    }).done(function(response) {
       	renderRentedRoom(response)
    })
}

function getRoom(maPhong){
	$.ajax({
        url: `${ctx}/Room/GetRoom`,
        type: 'GET',
        dataType: 'json',
        data: {
			maPhong: maPhong
		}
    }).done(function(response) { 

       	let room = ''
       	room += `<div class="field field_v1">                         
	                <input id="first-name" class="field__input" disabled value="${response.tenPhong}">
	                <span class="field__label-wrap" aria-hidden="true">
	                  <span class="field__label">Tên phòng</span>
	                </span>
	              </div>
	              <div class="field field_v2">
	                <input id="last-name"  class="field__input" placeholder="Phòng đơn" disabled value="${response.loaiPhong}">
	                <span class="field__label-wrap" aria-hidden="true">
	                  <span class="field__label">Loại phòng</span>
	                </span>
	              </div>
	              <div class="field field_v2">
	                <input id="last-name"  class="field__input" placeholder="350000" disabled value="${response.gia}">
	                <span class="field__label-wrap" aria-hidden="true">
	                  <span class="field__label">Giá</span>
	                </span>
	              </div>`
       	
		$('#roomInfo').empty()
		$('#roomInfo').append(room)
    })
}

function renderEmptyRoom(list){
	emptyRoom = ''
	       	
   	$.each(list, function( key, value ) {

		emptyRoom += `<div class="tab-item" id="${value.maPhong}">                                                                            
                        <div class="tab-item-first">
                            <span class="tenPhong">${value.tenPhong}</span>
                            <button class="btn-thue">Thuê</button>
                        </div>
                        <div class="tab-item-second">
                                <ion-icon name="bed-outline"></ion-icon>
                                ${value.loaiPhong}
                        </div>
                        <div class="tab-item-second">
                            <ion-icon name="business-outline"></ion-icon>
                            Chưa sử dụng
                        </div>
                    </div>`
		})
	$('#emptyRoom').empty()
	$('#emptyRoom').append(emptyRoom)
}

function renderRentedRoom(list){
	rentedRoom = ''
       	
   	$.each(list, function( key, value ) {

		rentedRoom += `<div class="tab-item-2" id="${value.room.maPhong}">
                            <div class="tab-item-first">
                                ${value.room.tenPhong}
                            </div>
                            <div class="tab-item-third">
                                <table>
                                    <tbody>
                                        <tr">
                                            <td>${value.room.loaiPhong}</td>
                                            <td>${value.customer.tenKH}</td>
                                            <td><button id="btn3" class="info-view">Huỷ</button></td>
                                        </tr>
                                        <tr id="${value.customer.maKH}">
                                            <td>Ngày đến: ${new Date(value.ngayDen).toLocaleDateString()}</td>
                                            <td>Ngày đi: ${new Date(value.ngayDi).toLocaleDateString()}</td>
                                            <td><button id="btn4" class="info-view">Trả phòng</button></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>`
		})
	$('#rentedRoom').empty()
	$('#rentedRoom').append(rentedRoom)
}

