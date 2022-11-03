<%-- 
    Document   : baiviet
    Created on : Sep 2, 2022, 3:21:37 PM
    Author     : Admin
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/baiviet" var="action"/>
        <div class="container1">
            <form:form method="post" action="${action}" modelAttribute="baiviet"
                       enctype="multipart/form-data">
                <div class="form-group">
                    <label for="noidung">Nội dung</label>
                    <form:input type="text-area" id="noidung" path="noidung" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="anh">Ảnh</label>
                    <form:input type="file" id="anh" path="file" class="form-control"/>
                </div>
                <div class="form-group">
                    <input type="submit" value="Thêm" class="btn btn-dark" style="width: 100%; margin-top: 20px"/>
                </div>
            </form:form>
        </div>
