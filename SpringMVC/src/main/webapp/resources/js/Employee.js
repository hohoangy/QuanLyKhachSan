// context path
var ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

// khoi tao danh sach dich vu
getAllEmployee()
//even Edit
$(document).on("click", ".btnEdit", function(){
	
	let maNV = $(this).closest("tr").attr("id")
	
	getEmployee(maNV)
})
// event Delete
$(document).on("click", ".btnDelete", function() {

	let maNV = $(this).closest("tr").attr("id")

	removeEmployee(maNV)
	getAllEmployee(response.employeeList)
})

// ham lay tat ca khach hang
function getAllEmployee(){
	$.ajax({
        url: `Employee/getAllEmployee`,
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
		var gt;
		var tt;
		if (value.gioiTinh == true) {gt="Nam"} else {gt="Nữ"}
		tbody += ` <tr id="${value.maNV}">
                        <td>${value.maNV}</td>
                        <td>${value.tenNV}</td>
            
                        <td>${gt}</td>
                        <td>${value.sdt}</td>
                        <td>${value.chucVu}</td>
                        <td>${value.luong}</td>
                       `
		if (value.tinhTrang == true) {
			tt = "Đang"
		tbody += ` 
                        <td><span class="status delivered">${tt}</span></td>
                        <td>
                            <button class="room-icon js-edit btnEdit">
                            	<ion-icon class="edit-icon" name="construct-outline"></ion-icon>
                            </button>                      
                        </td>
                    </tr>`}
        else
        {
			tt ="Nghỉ"
			tbody += ` 
                        <td><span class="status return">${tt}</span></td>
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
// Add employee
$(document).on("click", "#btnSave", function(e){
	let maNV = $('#maNVAdd').val()
	let tenNV = $('#tenNV').val()
	let ngaySinh1 = $('#ngaySinh').val()
	let gioiTinh = $('#gioiTinh').val()
	let sdt = $('#sdt').val()
	let chucVu = $('#chucVuAdd').val()
	let luong1 = $('#luong').val()
	let matKhau= "11111"
	console.log(maNV + "" + tenNV)
	var ngaySinh= new Date(ngaySinh1).toLocaleDateString();
	var luong = new Number(luong1);
    if (maNV != '') {
			$.ajax({
            url: 'Employee/Add',
            type: 'POST',
            dataType: 'json',
            data: {
				maNV: maNV,
                tenNV: tenNV,
                ngaySinh: ngaySinh,
                gioiTinh: gioiTinh,
                sdt: sdt,
                matKhau: matKhau,
                chucVu: chucVu,
                luong: luong
            }
	        }).done(function(response) {        
       	getAllEmployee(response.employeeList)
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
        url: `Employee/Search`,
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
        url: `Employee/GetEmployee`,
        type: 'GET',
        dataType: 'json',
        data: {
			maNV: maNV
		}
    }).done(function(response) {
		$('#maNVup').val(response.maNV)
       	$('#tenNVup').val(response.tenNV)
       	$('#ngaySinhup').val(response.ngaySinh)
      // 	$('#gioiTinhup').val(response.gioiTinh)
       	$('#sdtup').val(response.sdt)
    	$('#chucVuup').val(response.chucVu)
       	$('#luongup').val(response.luong)
       	
       	$('.edit-modal').addClass('open')
    })
}

// event Edit
$(document).on("click", "#btnUpdate", function(e){
	let maNV = $('#maNVup').val()
	let tenNV = $('#tenNVup').val()
	console.log(tenNV)
	let ngaySinh = $('#ngaySinhup').val()
	let gioiTinh = $('#gioiTinhup').val()
	let sdt = $('#sdtup').val()
	let chucVu = $('#chucVuup').val()
	let luong = $('#luongup').val()
	
    if (maNV != '') {
			$.ajax({
            url: 'Employee/Edit',
            type: 'POST',
            dataType: 'json',
            data: {
				maNV: maNV,
				tenNV: tenNV,
				ngaySinh: ngaySinh,
				gioiTinh: gioiTinh,
                sdt: sdt,
                chucVu: chucVu,
                luong: luong
            }
	        }).done(function(response) {        
       	getAllEmployee(response.employeeList)
       	$('.edit-modal').removeClass('open')
    })
}
})

/*// ham chinh sua khach hang
function editEmployee(maKH, tenKH, sdt, cmnd,quocTich){
	
	$.ajax({
        url: `Employee/Edit`,
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
}*/

// event ViewAll
$(document).on("click", "#btnViewAll", function() {

	getAllEmployee()
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



