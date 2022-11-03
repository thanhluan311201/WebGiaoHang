<%-- 
    Document   : ShipperInfo
    Created on : Aug 31, 2022, 2:57:24 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container1">
    <h1 class="text-center">DANH SÁCH SHIPPER</h1>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
    <a href="<c:url value="/admin/shipperRegister" />" class="btn btn-dark" style="margin: 20px 0 10px 1265px">Thêm shipper</a>
    </sec:authorize>
    <div class="row gx-4 gx-lg-5" style="margin: 10px 0 0 0">
        <c:forEach var="u" items="${User}">
        <div class="col-md-3 mb-5">
            <div class="card h-100">
                <div class="card-body">
                    <h2 class="card-title">${u.name}</h2>
                    <img src="${u.image}" width="200px" height="200px" alt="alt"/>
                </div>
                    <div class="card-footer"><a class="btn btn-dark btn-sm" href="<c:url value="/shipperInfo/${u.id}"/>">Chi tiết</a></div>
            </div>
        </div>
        </c:forEach>     
    </div>
</div> 
