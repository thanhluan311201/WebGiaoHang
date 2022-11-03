<%-- 
    Document   : daugia
    Created on : Aug 31, 2022, 3:57:39 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container1">
    <h1 class="text-center">Bài viết đơn hàng</h1>
    <div style="margin: 30px 0 0 30px">
        <ul class="pagination">

            <li class="page-item"><a class="page-link text-body" href="<c:url value="/daugia/" />?page=1">1</a></li>
            <li class="page-item"><a class="page-link text-body" href="<c:url value="/daugia/" />?page=2">2</a></li>
            <li class="page-item"><a class="page-link text-body" href="<c:url value="/daugia/" />?page=3">3</a></li>

        </ul>
    </div>
            
    <ul>
        <c:forEach var="b" items="${baiviet}">
            <div class="row-md-4">
                <div class="card h-100" style="margin: 10px 30px 0 0">
                    <div class="card-body">
                        <div class="card-title">
                            <h1>${b.idUser.name}</h1><i>${b.ngaytao}</i>
                        </div>
                            <p class="card-text">${b.noidung}</p>
                        <img src="${b.anh}" width="200px" height="200px" alt="alt"/>
                    </div>
                        <div class="card-footer"><a class="btn btn-dark btn-sm" href="<c:url value="/daugia/${b.id}" />">Chi tiết</a></div>
                </div>
            </div>
        </c:forEach>
    </ul>
            
</div>
<style>
    .card-text{
        padding-top: 20px
    }
    
</style>
