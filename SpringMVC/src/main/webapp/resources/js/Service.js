// context path
var ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

// khoi tao danh sach dich vu
getAllService()

// button thêm mới
$(document).on("click", "#btn2", function() {
	$('.recentCustomerss').show()
	$('.recentSelect').hide()
})

$(document).on("click", ".modal-close", function() {
	$('.using-service-modal').removeClass('open')
})

// button Thoát
$(document).on("click", "#exit-customer", function() {
	$('.recentSelect').hide()
})

// event get dịch vụ để edit
$(document).on("click", ".js-edit", function() {
	let maDV = $(this).closest("tr").attr("id")
	
	getService(maDV)
})

// button Close modal
$(document).on("click", ".js-modal-close", function() {
	$('.edit-modal').removeClass('open')
})

// event Edit
$(document).on("click", "#btnDone", function() {
	let maDV = $('#txtMaDV').val()
	let tenDV = $('#txtTenDV').val()
	let giaDV = $('#txtGiaDV').val() == '' ? 0 : $('#txtGiaDV').val()
	
	editService(maDV, tenDV, giaDV)
})

// Event Add
$(document).on("click", "#btnSave", function() {
	let maDV = $('#txtMaDVAdd').val()
	let tenDV = $('#txtTenDVAdd').val()
	let giaDV = $('#txtGiaDVAdd').val() == '' ? 0 : $('#txtGiaDVAdd').val()
	
	if (isUnique(maDV, tenDV, giaDV)) {
		addService(maDV, tenDV, giaDV)
	} else {
		console.log("Failed")
	}
})

// event Search
$(document).on('keypress', '#txtSearch', function(e) {
	var key = e.which;
	let searchVal = $('#txtSearch').val()

	if(key == 13 && !searchVal == "")  // the enter key code
	{
		search(searchVal)
	}
})

// event View All
$(document).on("click", "#btnViewAll", function() {

	getAllService()
})

// event Delete
$(document).on("click", ".btnDelete", function() {

	$('#notify').removeClass('hide')
	$('#notify').addClass('active')
	
	let maDV = $(this).closest("tr").attr("id")
	$('#idDelete').val(maDV)
})

$(document).on('click', '.yes', function (){

	let id = $('#idDelete').val()

	removeService(id)


})

$(document).on('click', '.no', function (){

	$('#notify').addClass('hide')
	$('#notify').removeClass('active')
})

// function search by searchVal String
function search(searchVal) {
	
	$.ajax({
        url: `${ctx}/Service/Search`,
        type: 'GET',
        dataType: 'json',
        data: {
			searchString: searchVal
		}
	    }).done(function(response) {        
	       	renderAllService(response)
	    })
}

// ham kiem tra maDV la duy nhat
function isUnique(maDV, tenDV, giaDV) {
	let isUnique = true
	$.ajax({
        url: `${ctx}/Service/CheckUnique`,
        type: 'GET',
        dataType: 'json',
        async: false,
        data: {
			maDV: maDV,
			tenDV: tenDV,
			giaDV: giaDV
		}
    }).done(function(response) {
		isUnique = response
    })

    return isUnique
}

// ham them dich vu
function addService(maDV, tenDV, giaDV) {
	
	$.ajax({
        url: `${ctx}/Service/Add`,
        type: 'POST',
        dataType: 'json',
        data: {
			maDV: maDV,
			tenDV: tenDV,
			giaDV: giaDV
		}
    }).done(function(response) {
		getAllService()
    })
}

// ham chinh sua dich vu
function editService(maDV, tenDV, giaDV){
	
	$.ajax({
        url: `${ctx}/Service/Edit`,
        type: 'POST',
        dataType: 'json',
        data: {
			maDV: maDV,
			tenDV: tenDV,
			giaDV: giaDV
		}
    }).done(function(response) {
		getAllService()
		
		$('.edit-modal').removeClass('open')
    })
}

// ham xoa dich vu
function removeService(maDV){
	
	$.ajax({
        url: `${ctx}/Service/Remove`,
        type: 'POST',
        dataType: 'json',
        data: {
			maDV: maDV
		}
    }).done(function(response) {
		getAllService()
		
		$('#notify').addClass('hide')
		$('#notify').removeClass('active')
    })
}

// ham lay dich vu theo ma
function getService(maDV){
	
	$.ajax({
        url: `${ctx}/Service/GetService`,
        type: 'GET',
        dataType: 'json',
        data: {
			maDV: maDV
		}
    }).done(function(response) {
		$('#txtMaDV').val(response.maDV)
       	$('#txtTenDV').val(response.tenDV)
       	$('#txtGiaDV').val(response.giaDV)
       	
       	$('.edit-modal').addClass('open')
    })
}

// ham lay tat ca dich vu
function getAllService(){
	$.ajax({
        url: `${ctx}/Service/GetAllService`,
        type: 'GET',
        dataType: 'json',
        data: {}
    }).done(function(response) {
       	renderAllService(response)
    })
}

// ham render html tat ca dich vu 
function renderAllService(list){
	let tbody = ''
	       	
   	$.each(list, function( key, value ) {

		tbody += `<tr id="${value.maDV}">
                    <td>${value.maDV}</td>
                    <td>${value.tenDV}</td>
                    <td>${value.giaDV} đ</td>
                    <td><button class="room-icon js-edit"><ion-icon class="edit-icon" name="construct-outline"></ion-icon></button></td>
                    <td><button class="btnDelete room-icon"><ion-icon class="delete-icon" name="trash-outline"></ion-icon></button></td>
                </tr>`
	})
	
	$('#tbody').empty()
	$('#tbody').append(tbody)
}