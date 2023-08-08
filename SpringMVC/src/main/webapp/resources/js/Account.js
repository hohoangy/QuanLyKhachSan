// context path
var ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
let mk
// khoi tao danh sach dich vu
getAllEmployee()
//even Edit
$(document).on("click", ".btnEdit", function(){
	
	let maNV = $(this).closest("tr").attr("id")
	
	getEmployee(maNV)
})
//even Delete
$(document).on("click", ".btnDelete", function(){
	
	let maNV = $(this).closest("tr").attr("id")
	
	removeAccount(maNV)
})
//remove Acount
function removeAccount(maNV){
	
	$.ajax({
        url:  `Account/EditTrangThai`,
        type: 'POST',
        dataType: 'json',
        data: {
			maNV: maNV
		}
    }).done(function(response) {
		getAllEmployee()
    })
}

// ham lay tat ca khach hang
function getAllEmployee(){
	$.ajax({
        url: `Account/getAllEmployee`,
        type: 'GET',
        dataType: 'json',
        data: {}
    }).done(function(response) {
       	renderAllEmployee(response)
    })
}


// ham render html tat ca khach hang
function renderAllEmployee(list){
	let tbody = ''
	       	
   	$.each(list, function( key, value ) {
		tbody += ` <tr id="${value.maNV}">
                        <td>${value.maNV}</td>
                        <td>${value.tenNV}</td>
                        <td>${value.chucVu}</td>
	      			   <td>
		                    <button class="room-icon js-edit btnEdit"><ion-icon class="edit-icon" name="construct-outline"></ion-icon></button>
		                    <button class="room-icon btnDelete"><ion-icon class="delete-icon" name="trash-outline"></ion-icon></button>
	                    </td>
                    </tr>`
	})
	
	$('#tbody').empty()
	$('#tbody').append(tbody)
}

// event Search
$(document).on('keypress', '#txtSearch', function(e) {
	var key = e.which;
	let searchVal = $('#txtSearch').val()

	if(key == 13 && !searchVal == "")  // the enter key code
	{
		search(searchVal)
	}
})
// function search by searchVal String
function search(searchVal) {
	
	$.ajax({
        url: `Account/Search`,
        type: 'GET',
        dataType: 'json',
        data: {
			searchString: searchVal
		}
	    }).done(function(response) {        
			renderAllEmployee(response.employeeList)
				    })
}
// ham lay khach hang theo cmnd
function getEmployee(maNV){
	
	$.ajax({
        url: `Account/GetEmployee`,
        type: 'GET',
        dataType: 'json',
        data: {
			maNV: maNV
		}
    }).done(function(response){
		$('#maNVup').val(response.maNV)    
		mk = response.matKhau   	
       	$('.edit-modal').addClass('open')
    })
}

// event Edit
$(document).on("click", "#btnDone", function(e){
	let maNV = $('#maNVup').val()
	let matKhauht = $('#matKhauht').val()
	let matKhaumoi = $('#matKhaumoi').val()
	
    if (matKhauht == mk) {
			$.ajax({
            url: 'Account/EditPass',
            type: 'POST',
            dataType: 'json',
            data: {
				maNV: maNV,
				matKhau: matKhaumoi,
            }
	        }).done(function(response) {        
       	getAllEmployee(response.employeeList)
       	$('.edit-modal').removeClass('open')
    })
}
})



// event ViewAll
$(document).on("click", "#btnViewAll", function() {

	getAllEmployee()
})





