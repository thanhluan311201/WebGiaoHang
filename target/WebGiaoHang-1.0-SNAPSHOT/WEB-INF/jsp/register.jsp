<%-- 
    Document   : register
    Created on : Aug 28, 2022, 5:43:24 PM
    Author     : Admin
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container1">
        <c:if test="${errMsg != null}">
            <div class="alert alert-danger">
                ${errMsg}
            </div>
        </c:if>
        <c:url value="/register" var="action"/>
        <div class="container">
            <h1 class="text-center ">Đăng Ký</h1>
            <form:form method="post" action="${action}" modelAttribute="user" 
                       enctype="multipart/form-data">
                <div class="form-group">
                    <label for="name">Họ và tên</label>
                    <form:input type="text" id="name" path="name" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="sdt">Số điện thoại</label>
                    <form:input type="text" id="sdt" path="sdt" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="username">Username</label>
                    <form:input type="text" id="username" path="username" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <form:input type="password" id="password" path="password" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="confirm-password">Confirm Password</label>
                    <form:input type="password" id="confirm-password" path="confirmPassword" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="anh">Ảnh</label>
                    <form:input type="file" id="anh" path="file" class="form-control"/>
                </div>
                <div class="form-group" style="margin-top: 20px">
                    <input type="submit" value="Đăng ký" class="btn btn-dark" style="width: 100%"/>
                </div>
            </form:form>
        </div>
</div>
