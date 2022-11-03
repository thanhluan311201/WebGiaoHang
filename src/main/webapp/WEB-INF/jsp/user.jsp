<%-- 
    Document   : user
    Created on : Sep 2, 2022, 1:11:17 PM
    Author     : Admin
--%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container1">
    <h1 class="text-center">BÀI VIẾT CÁ NHÂN</h1>
    <sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
    <a href="<c:url value="/baiviet" />" class="btn btn-dark" style="margin: 20px 0 10px 1265px">Thêm bài viết</a>
    </sec:authorize>
    <c:if test="${currentUser.userRole eq 'ROLE_SHIPPER'}">
    <div class="row">
            <div class="col-lg-3" style="border-right: 1px solid rgba(0,0,0,.125)">
                <h1 class="card-title">${currentUser.name}</h1>
                <img src="${currentUser.image}" width="200px" height="200px" alt="alt"/>
                <p class="card-text">Số điện thoại: <b>${user.sdt}</b></p>
            </div>
            <div class="col-lg-9" style="border: 0px">
                <div>
                    <h2 class="text-center">Đánh giá cộng đồng</h2>
                    <c:forEach items="${user.danhgiaSet}" var="d">
                        <div class="row">
                            <div class="row-lg" style="padding: 20px 0 0 50px">
                                <p>${d.noidung}</p>
                            </div>
                        </div>     
                    </c:forEach>
                </div>
            </div>
    </div>
    </c:if>
    <ul>
        <c:forEach var="b" items="${baiviet}">
            <div class="row-md-4">
                <div class="card h-100" style="margin: 10px 30px 0 0">
                    <div class="card-body">
                        <div class="card-title">
                            <h1>${b.idUser.name}</h1><i>${b.ngaytao}</i>
                        </div>
                        <p class="card-text">${b.noidung}</p>
                        <p class="card-text">Tình trạng bài viết: <b>${b.tinhtrang}</b></p>
                        <img src="${b.anh}" width="200px" height="200px" alt="alt"/>
                    </div>
                        <div class="card-footer"><a class="btn btn-dark btn-sm" href="<c:url value="/daugia/${b.id}" />">Chi tiết</a></div>
                </div>
            </div>
        </c:forEach>
    </ul>
</div>
<style>
    .row{
        padding: 5px;
        margin: 10px 0 0 0;
        border: 1px solid rgba(0,0,0,.125);
        border-radius: .25rem;
    }
    .card-text{
        padding-top: 20px
    }
    
</style>