<%-- 
    Document   : donhang
    Created on : Oct 10, 2022, 3:57:08 PM
    Author     : Admin
--%>

<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container1">
    <h1 class="text-center">Chi tiết đơn hàng</h1>
    <ul>
    <c:forEach var="d" items="${donhang}">
        <div class="row-md-4">
            <div class="card h-100" style="margin: 10px 30px 0 0">
                <div class="card-body">
                    <div class="card-title">
                        <h1>${d.idBaiviet.idUser.name}</h1><i>${d.idBaiviet.ngaytao}</i>
                    </div>
                    <p class="card-text">${d.idBaiviet.noidung}</p>
                    <p class="card-text">Tình trạng đơn hàng: <b>${d.tinhtrang}</b></p>
                    <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
                    <p class="card-text">Shipper nhận đơn: <b>${d.idUser.name}</b></p>  
                    </sec:authorize>
                    <img src="${d.idBaiviet.anh}" width="200px" height="200px" alt="alt"/>
                    <c:if test="${currentUser.userRole eq 'ROLE_SHIPPER'}">
                        <c:if test="${d.tinhtrang eq 'Đang giao'}">
                        <div><a class="btn btn-dark" href="<c:url value="/updatedh/${d.id}"/>">Hoàn tất</a></div>
                        </c:if>
                    </c:if>
                </div>

            </div>
        </div>
    </c:forEach>
    </ul>
</div>