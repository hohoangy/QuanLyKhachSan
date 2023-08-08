eventLoad()

function eventLoad() {
	
	$.ajax({
        url: 'Room/GetAllRoomNoDeleted',
        type: 'GET',
        dataType: 'json',
        data: {
            
        }
    }).done(function(response) {
		if (response.length != 0) {
			$('#tbody').empty()

            let tbody = getTBody(response)
			
			$('#tbody').append(tbody)
		}
	})
}

// event Add
$(document).on('click', '#btnAdd', function (){
	errorMessage.style.display = 'block'
	$('#errorMessage').text(``)

	let maPhong = $('#maPhongAdd').val()
	let tenPhong = $('#tenPhongAdd').val()
	let loaiPhong = $('#loaiPhongAdd').val()
	loaiPhong = loaiPhong == "P0" ? "Phòng đơn" : "Phòng đôi"
	let gia = $('#giaAdd').val()
	
	gia = gia == "" ? 0 : gia
	
	if (maPhong != '') {
		$.ajax({
        url: 'Room/Add',
        type: 'POST',
        dataType: 'json',
        data: {
			maPhong: maPhong,
            tenPhong: tenPhong,
            loaiPhong: loaiPhong,
            gia: gia
        }
        }).done(function(response) {
			$('#tbody').empty()
            
           	let tbody = getTBody(response.roomList)	
			
			$('#tbody').append(tbody)

			let error = response.error;
			
			if (error) {
				$('#errorMessage').text(`Phòng ${maPhong} đã tồn tại`)
					if (errorMessage.innerHTML != "") {
			        	const hideError = setTimeout(function() {
							errorMessage.style.display = 'none'
							$('#errorMessage').text('')
						}, 3000)
			        }
			}
        });
	} else {
		//$('#errorMessage').text(`Vui lòng nhập mã phòng`)
	}
})

// eventDelete()
	  	
$(document).on('click', '.btnDelete', function (){

	$('#notify').removeClass('hide')
	$('#notify').addClass('active')
	
	let trid = $(this).closest('tr').attr('id')
	$('#idDelete').val(trid)
	
})

$(document).on('click', '.yes', function (){

	let id = $('#idDelete').val()

	$.ajax({
	        url: 'Room/Remove',
	        type: 'POST',
	        dataType: 'json',
	        data: {
	            maPhong: id, 
	        }
    }).done(function(response) {
		$('#tbody').empty()
        
       	let tbody = getTBody(response)
		
		$('#tbody').append(tbody)
		
		$('#notify').addClass('hide')
		$('#notify').removeClass('active')	
    });

})

$(document).on('click', '.no', function (){

	$('#notify').addClass('hide')
	$('#notify').removeClass('active')
})

// event get and set room for client	
$(document).on('click', '.btnEdit', function (){
	
	$('#maPhong').val('')
	$('#name').val('')
	$('#loaiPhong').val('')
	$('#gia').val('')
	
	let trid = $(this).closest('tr').attr('id')
	
	$.ajax({
        url: 'Room/GetRoom',
        type: 'GET',
        dataType: 'json',
        data: {
            maPhong: trid, 
        }
    }).done(function(response) {
		$('#maPhong').val(response.maPhong)
		$('#name').val(response.tenPhong)
		$('#loaiPhong').val(response.loaiPhong == "Phòng đơn" ? "P0" : "P1")
		$('#gia').val(response.gia)
		
		$('.edit-modal').addClass('open')
    })
})

// event Edit
$(document).on('click', '#btnDone', function (){
	let maPhong = $('#maPhong').val()
	let tenPhong = $('#name').val()
	let loaiPhong = $('#loaiPhong').val()
	loaiPhong = loaiPhong == "P0" ? "Phòng đơn" : "Phòng đôi"
	let gia = $('#gia').val()
	
	$.ajax({
        url: 'Room/Edit',
        type: 'POST',
        dataType: 'json',
        data: {
            maPhong: maPhong,
            tenPhong: tenPhong,
            loaiPhong: loaiPhong,
            gia: gia
        }
    }).done(function(response) {
		
		$('#tbody').empty()

        let tbody = getTBody(response)
		
		$('#tbody').append(tbody)
		
		$('.edit-modal').removeClass('open')
	})
})


//event Search
$(document).on('keypress', '#txtSearch', function(e) {
	var key = e.which;
	errorMessage.style.display = 'block'
	$('#errorMessage').text(``)
	let searchVal = $('#txtSearch').val()

	if(key == 13 && !searchVal == "")  // the enter key code
	{
		
		$.ajax({
            url: 'Room/Search',
            type: 'GET',
            dataType: 'json',
            data: {
                searchString: searchVal
            }
        }).done(function(response) {
			if (response.length != 0) {
				$('#tbody').empty()

	            let tbody = getTBody(response)
				
				$('#tbody').append(tbody)
				
				$('#errorMessage').text('')
				
				
			} else {
				$('#errorMessage').text(`Không tìm thấy phòng: ${searchVal}`)
				if (errorMessage.innerHTML != "") {
		        	const hideError = setTimeout(()=>errorMessage.style.display = 'none', 3000)
		        }
			}
		})
	}
})

$(document).on('click', '#btnViewAll', function (){
	$.ajax({
        url: 'Room/GetAllRoomNoDeleted',
        type: 'GET',
        dataType: 'json',
        data: {

        }
    }).done(function(response) {
		$('#tbody').empty()
        
       	let tbody = getTBody(response)
		$('#tbody').append(tbody)
		
    });
})

function getTBody(roomList) {
	let tbody = ``;
	console.log(roomList)
	
	$.each(roomList, function( key, value ) {
		tbody += `<tr id="${value.maPhong }">`
        tbody += `<td>${value.maPhong }</td>`
        tbody += `<td>${value.tenPhong }</td>`
        tbody += `<td>${value.loaiPhong }</td>`
        tbody += `<td>${value.gia }</td>`
        tbody += `<td><span class="status `
        let trangThai = `${value.trangThai}`
        if (trangThai == 0) {
			tbody += `delivered">Trống`
		} else if(trangThai == 1) {
			tbody += `return">Đang thuê`
		} else {
			tbody += `pending">Chưa dọn`
		}
            
        tbody += `</span></td>`
        tbody += `<td>
            	<button class="room-icon js-edit btnEdit">
            		<ion-icon class="edit-icon" name="construct-outline"></ion-icon>
            	</button>
            </td>`
        tbody += `<td><button class="room-icon btnDelete"><ion-icon class="delete-icon" name="trash-outline"></ion-icon></button></td>`
        tbody += `</tr>`
	});
	
	return tbody
}

$(document).on('click', '.js-edit', function (){
	$('.edit-modal').removeClass('open')
})

$(document).on('click', '.js-modal-close', function (){
	$('.edit-modal').removeClass('open')
})