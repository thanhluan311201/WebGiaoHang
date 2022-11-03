<%-- 
    Document   : login
    Created on : Aug 28, 2022, 2:38:34 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container1">
    <h1 class="text-center">Đăng nhập</h1>
        <c:if test="${param.error != null}">
            <div class="alert alert-danger">
                Loi!!!
            </div>
        </c:if>
        <c:if test="${param.accessDenied != null}">
            <div class="alert alert-danger">
                Ban khong co quyen truy cap
            </div>
        </c:if>
        <c:url value="/login" var="action"/>
        <div class="container">
            <form method="post" action="${action}">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" class="form-control"/>
                </div>
                <div class="form-group" style="margin-top: 20px">
                    <input type="submit" value="Đăng nhập" class="btn btn-dark" style="width: 100%"/>
                </div>
            </form>
        </div>
</div>