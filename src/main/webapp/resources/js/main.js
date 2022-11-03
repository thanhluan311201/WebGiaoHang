/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


/* global fetch, moment */

function addBinhluan(idBaiviet){
    fetch("/WebGiaoHang/api/add-comment", {
        method: 'post',
        body:  JSON.stringify({
            "noidung": document.getElementById("binhluanId").value,
            "idBaiviet": idBaiviet
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res){
        
        return res.json();
    }).then(function(data){
        let area = document.getElementsByClassName("binhluanArea");
        
            area.innerHTML = `
                <div class="row">
                    <div class="row" >
                        <div class="col-1">
                            <img class="rounded-circle img-fluid" style="margin: 10px 0 0 20px; width: 70px; height: 70px" src="<c:url value="${data.idUser.image}" />"/>
                        </div>
                        <div class="col-sm-9 my-date">
                            <h1>${data.idUser.name}</h1>
                            <i>${moment(data.thoigian).fromNow()}</i>
                        </div>
                    </div>
                        <div class="row-lg" style="padding: 20px 0 0 130px">
                        <p>${data.noidung}</p>
                    </div>
                </div>
            ` + area.innerHTML;

    }).then(window.location='/WebGiaoHang/');

}

function addDanhgia(idUser){
    fetch("/WebGiaoHang/api/add-danhgia", {
        method: 'post',
        body:  JSON.stringify({
            "noidung": document.getElementById("danhgiaId").value,
            "idUser": idUser
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res){

        return res.json();
    }).then(function(data){
        let area = document.getElementById("danhgiaArea");
        
            area.innerHTML = `
                <div class="row">
                    <div class="row" >
                        <div class="row-lg" style="padding: 20px 0 0 130px">
                            <p>${data.noidung}</p>
                        </div>
                    </div>
                </div>     
            ` + area.innerHTML;

    }).then(window.location='/WebGiaoHang/shipperInfo');

}

function addDonhang(idBaiviet){
    fetch("/WebGiaoHang/api/add-donhang", {
        method: 'post',
        body:  JSON.stringify({
            "idBaiviet": idBaiviet
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res){
        
        return res.json();
    }).then(window.location='/WebGiaoHang/');
    
}
