getAllOrder()

// ham lay tat ca khach hang
function getAllOrder(){
	$.ajax({
        url: `Order/getAllOrder`,
        type: 'GET',
        dataType: 'json',
        data: {}
    }).done(function(response) {
       	renderAllOrder(response)
    })
}


// ham render html tat ca khach hang
function renderAllOrder(list){
	let tbody = ''
	var v;	
   	$.each(list, function( key, value ) {
		tbody += `  <tr id="${value.cmnd}"> 
                        <td>"${value.maKH}"</td>
                        <td>"${value.maPhong}"</td>
                        <td>"${value.maNV}"</td>
                        <td>"${value.ngayDen}"</td>
                        <td>"${value.ngayDi}"</td>
                        <td>"${value.tienCoc}"</td>
                        <td>"${value.trangThai}"</td>
                        <td><button id="btn2" class="info-view">Đặt phòng</button></td>  
                    </tr>`
	})
	
	$('#tbody').empty()
	$('#tbody').append(tbody)
}