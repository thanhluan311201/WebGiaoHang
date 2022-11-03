<%-- 
    Document   : header
    Created on : Aug 28, 2022, 1:14:44 PM
    Author     : HP 450-G1
--%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container px-5">
        <a class="navbar-brand" href="<c:url value="/"/>">Web giao hàng</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="<c:url value="/"/>">Trang chủ</a>
                </li>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_SHIPPER')">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/daugia"/>">Bài viết đơn hàng</a>
                </li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_SHIPPER')">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/donhangs/${currentUser.id}"/>">Đơn hàng của tôi</a>
                </li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/admin/donhang"/>">Đơn hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/admin/donhang_stats"/>">Thống kê</a>
                </li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_USER')">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/donhangu/${currentUser.id}"/>">Đơn hàng của tôi</a>
                </li>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/shipperInfo"/>">Thông tin shipper</a>
                </li>
                </sec:authorize>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/login" />">Đăng nhập</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/register" />">Đăng ký</a>
                    </li>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li class="nav-item">
                        <a class="nav-link text-danger" href="<c:url value="/user/${currentUser.id}" />">${currentUser.name}(${currentUser.userRole})</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/logout" />">Logout</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>

