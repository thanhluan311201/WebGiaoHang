<%-- 
    Document   : shipperInfo_ct
    Created on : Sep 4, 2022, 5:24:55 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container1">
    <h1 class="text-center">Thông tin Shipper</h1>
    <div class="row">
            <div class="col-lg-3" style="border-right: 1px solid rgba(0,0,0,.125)">
                <h1 class="card-title">${user.name}</h1>
                <img src="${user.image}" width="200px" height="200px" alt="alt"/>
                <p class="card-text">Số điện thoại: <b>${user.sdt}</b></p>
            </div>
            <div class="col-lg-9" style="border: 0px">
                <h2 class="text-center">Đánh giá cộng đồng</h2>
                <form>
                    <div class="card-footer form-group">
                        <textarea class="form-control" id="danhgiaId" placeholder="Nhập đánh giá..."></textarea>
                        <input type="button" onclick="addDanhgia(${user.id})"
                                               value="Thêm bình luận" class="btn btn-dark" style="margin-top: 10px"/>
                    </div>
                </form>
                <div id="danhgiaArea">
                    <c:forEach items="${user.danhgiaSet}" var="u">
                        <div class="row">
                                <div class="row-lg" style="padding: 20px 0 0 50px">
                                <p>${u.noidung}</p>
                                </div>
                        </div>     
                    </c:forEach>
                </div>
            </div>
    </div>
</div>
<style>
    .row{
        padding: 5px;
        margin: 10px 0 0 0;
        border: 1px solid rgba(0,0,0,.125);
        border-radius: .25rem;
    }
</style>