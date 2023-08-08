// context path
var ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

getAllServiceUsed()

$(document).on('click', '#btnViewAll', function() {
	getAllServiceUsed()
})

$(document).on('click', '.modal-close', function() {
	$('.using-service-modal').removeClass('open')
})

// button Sử dụng
$(document).on("click", "#btn2", function() {
	//$('.recentSelect').show()
	$('.recentCustomerss').hide()
	
	$.ajax({
        url: `${ctx}/Service/GetAllService`,
        type: 'GET',
        dataType: 'json',
        data: {
			
		}
    }).done(function(response) {
    	
    	let select = ''
    	
    	$.each(response, function(key, value) {
    		select += `<option value="${value.maDV}" class="wraptext">${value.tenDV}</option>`
    	})
    			
		$('#selDichVu').append(select)
	})
	
	$.ajax({
        url: `${ctx}/Rent/GetRentedInfo`,
        type: 'GET',
        dataType: 'json',
        data: {
			
		}
    }).done(function(response) {
    	
    	let select = ''
    	
    	$.each(response, function(key, value) {
    		select += `<option value="${value.room.maPhong}" class="wraptext">${value.room.tenPhong}</option>`
    	})
    			
		$('#selPhong').append(select)
		
		document.getElementById("txtUsingTime").valueAsDate = new Date();
		
		$('.using-service-modal').addClass('open')
	})
})

// event chọn khách hàng sử dụng dịch vụ
$(document).on("click", "#btnUse", function() {
	
	let quantity = $('#txtQuantity').val()
	let roomID = $('#selPhong').val()
	let usingDate = $('#txtUsingTime').val()
	let maDV = $('#selDichVu').val()

	if(quantity > 0) {
		$.ajax({
	        url: `${ctx}/ServiceUsing/Use`,
	        type: 'POST',
	        dataType: 'json',
	        data: {
	        	maPhong: roomID,
				ngaySD: usingDate,
				soLuong: quantity,
				maDV: maDV
			}
		}).done(function(response) {
			
			if (response != 0) {
				getAllServiceUsed()
			} else {
				console.log("failed")
			}
		
			$('.using-service-modal').removeClass('open')
	    }).fail(function(response){
			console.log(maDV)
	    })
	} else {
		console.log("Failed")
	}
})

$(document).on('click', '.btnCancel', function() {
	
	let maDV = $(this).closest("tr").attr("id")
	let maKH = $(this).closest("tr").find("td").attr("id")
	let maPhong = $(this).closest("tr").find("input").attr("id")
	
	$('#idPhong').val(maPhong)
	$('#idKH').val(maKH)
	$('#idDV').val(maDV)
	
	$('#notify').removeClass('hide')
	$('#notify').addClass('active')
})

$(document).on('click', '.yes', function (){

	let maDV = $('#idDV').val()
	let maKH = $('#idKH').val()
	let maPhong = $('#idPhong').val()

	$.ajax({
	    url: `${ctx}/ServiceUsing/Cancel`,
	    type: 'POST',
	    dataType: 'json',
	    data: {
			maKH: maKH,
			maDV: maDV,
			maPhong: maPhong
		}
	}).done(function(response) {
		if(response != 0) {
			getAllServiceUsed()
			
			$('#notify').addClass('hide')
			$('#notify').removeClass('active')
		} else {
			console.log('Failed')
		}
	})

})

$(document).on('click', '.no', function (){

	$('#notify').addClass('hide')
	$('#notify').removeClass('active')
})

$(document).on('keypress', '#txtSearch', function(e) {
	var key = e.which;
	let searchVal = $('#txtSearch').val()

	if(key == 13 && !searchVal == "")  // the enter key code
	{
		$.ajax({
	        url: `${ctx}/ServiceUsing/Search`,
	        type: 'GET',
	        dataType: 'json',
	        data: {
				searchValue: searchVal
			}
		}).done(function(response) {    
			renderAllService(response)
	    })
	}
})

// ham lay tat ca dich vu da su dung
function getAllServiceUsed(){
	$.ajax({
        url: `${ctx}/ServiceUsing/GetAllServiceUsed`,
        type: 'GET',
        dataType: 'json',
        data: {}
    }).done(function(response) {
       	renderAllService(response)
    })
}

// ham render html tat ca dich vu da su dung
function renderAllService(list){
	let tbody = ''
	       	
   	$.each(list, function( key, value ) {

		tbody += `<tr id="${value.service.maDV}">
                  	<td id="${value.customer.maKH}">${value.customer.maKH}</td>
                    <td>${value.customer.tenKH}</td>
                    <td>${value.room.tenPhong}</td>
                    <td>${value.service.tenDV}</td>
                    <td>${value.soLuong}</td>
                    <td class="${value.trangThai == 1 ? "status-yes\">Đã thanh toán" : "status-false\">Chưa thanh toán"}</td>
                    <td><button class="room-icon btnCancel"><ion-icon class="delete-icon" name="trash-outline"></ion-icon></button></td>
                	<input type="hidden" id="${value.room.maPhong}">
                </tr>`
	})
	
	$('#tbody').empty()
	$('#tbody').append(tbody)
}