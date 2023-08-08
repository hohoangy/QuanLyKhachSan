// context path
var ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

// khoi tao danh sach dich vu
getAllCustomer()
//even Edit
$(document).on("click", ".btnEdit", function(){
	
	let cmnd = $(this).closest("tr").attr("id")
	
	getCustomer(cmnd)
})
// event Delete
$(document).on("click", ".btnDelete", function() {

	let cmnd = $(this).closest("tr").attr("id")

	removeCustomer(cmnd)
	getAllCustomer(response.customerList)
})

// ham lay tat ca khach hang
function getAllCustomer(){
	$.ajax({
        url: `Customer/getAllCustomer`,
        type: 'GET',
        dataType: 'json',
        data: {}
    }).done(function(response) {
       	renderAllCustomer(response)
    })
}


// ham render html tat ca khach hang
function renderAllCustomer(list){
	let tbody = ''
	var v;	
   	$.each(list, function( key, value ) {
		tbody += ` <tr id="${value.cmnd}">
                        <td>${value.maKH}</td>
                        <td>${value.tenKH}</td>
                        <td>${value.sdt}</td>
                        <td>${value.cmnd}</td>
                        <td>${value.quocTich}</td>
                       `
		if (value.vip == true)
		{
			v = "VIP"
			tbody += ` 
                        <td><span class="status delivered">${v}</span></td>
                        <td>
                            <button class="room-icon js-edit btnEdit">
                            	<ion-icon class="edit-icon" name="construct-outline"></ion-icon>
                            </button>
                          
                        </td>
                    </tr>`
		}
		else
		{
		tbody += ` 
                        <td></td>
                        <td>
                            <button class="room-icon js-edit btnEdit">
                            	<ion-icon class="edit-icon" name="construct-outline"></ion-icon>
                            </button>
                          
                        </td>
                    </tr>`
        }
	})
	
	$('#tbody').empty()
	$('#tbody').append(tbody)
}
// Add customer
$(document).on("click", "#btnSave", function(e){
	let tenKH = $('#tenKH').val()
	console.log(tenKH)
	let sdt = $('#sdt').val()
	let cmnd = $('#cmnd').val()
	let quocTich = $('#quocTich').val()
	
    if (cmnd != '') {
			$.ajax({
            url: 'Customer/Add',
            type: 'POST',
            dataType: 'json',
            data: {
				tenKH: tenKH,
                sdt: sdt,
                cmnd: cmnd,
                quocTich: quocTich
            }
	        }).done(function(response) {        
       	getAllCustomer(response.customerList)
    })
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
// function search by searchVal String
function search(searchVal) {
	
	$.ajax({
        url: `Customer/Search`,
        type: 'GET',
        dataType: 'json',
        data: {
			searchString: searchVal
		}
	    }).done(function(response) {        
			renderAllCustomer(response.customerList)
				    })
}
// ham lay khach hang theo cmnd
function getCustomer(cmnd){
	
	$.ajax({
        url: `Customer/GetCustomer`,
        type: 'GET',
        dataType: 'json',
        data: {
			cmnd: cmnd
		}
    }).done(function(response) {
		$('#maKHup').val(response.maKH)
       	$('#tenKHup').val(response.tenKH)
       	$('#sdtup').val(response.sdt)
       	$('#cmndup').val(response.cmnd)
       	$('#quocTichup').val(response.quocTich)
       	
       	$('.edit-modal').addClass('open')
    })
}

// event Edit
$(document).on("click", "#btnUpdate", function(e){
	let maKH = $('#maKHup').val()
	let tenKH = $('#tenKHup').val()
	console.log(tenKH)
	let sdt = $('#sdtup').val()
	let cmnd = $('#cmndup').val()
	let quocTich = $('#quocTichup').val()
	
    if (cmnd != '') {
			$.ajax({
            url: 'Customer/Edit',
            type: 'POST',
            dataType: 'json',
            data: {
				tenKH: tenKH,
                sdt: sdt,
                cmnd: cmnd,
                quocTich: quocTich
            }
	        }).done(function(response) {        
       	getAllCustomer(response.customerList)
       	$('.edit-modal').removeClass('open')
    })
}
})

// ham chinh sua khach hang
function editCustomer(maKH, tenKH, sdt, cmnd,quocTich){
	
	$.ajax({
        url: `Cusstomer/Edit`,
        type: 'POST',
        dataType: 'json',
        data: {
			maKH: maKH,
			tenKH: tenKH,
			sdt: sdt,
			cmnd: cmnd,
			quocTich: quocTich
		}
    }).done(function(response) {
		$('.edit-modal').removeClass('open')
		getAllCustomer()		
		
    })
}

// event ViewAll
$(document).on("click", "#btnViewAll", function() {

	getAllCustomer()
})

function getTBody(customerList) {
	let tbody = ``;
	
	$.each(customerList, function( key, value ) {
		tbody += `<tr id="${value.maKH }">`
        tbody += `<td>${value.maKH }</td>`
        tbody += `<td>${value.tenKH }</td>`
        tbody += `<td>${value.sdt }</td>`
        tbody += `<td>${value.cmnd }</td>`
         tbody += `<td>${value.quocTich }</td>`
        tbody += `<td><span class="status `
        let vip = `${value.vip}`
        if (trangThai == 0) {
			tbody += `delivered">No`
		} else if(trangThai == 1) {
			tbody += `return">Yes`
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



