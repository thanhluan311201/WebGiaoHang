<%-- 
    Document   : baiviet_stats
    Created on : Oct 15, 2022, 5:27:08 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div class="container1">
    <h2 class="text-center text-danger">Thống kê bài viết của người dùng</h2>
    <div>
        <canvas id="myBaivietStatsChart"></canvas>
    </div>
    <table class="table">
        <tr>
            <th>Mã người dùng</th>
            <th>Tên người dùng</th>
            <th>Số lượng bài viết</th>
        </tr>
        <c:forEach items="${baivietStats}" var="b">
        <tr>
            <td>${b[0]}</td>
            <td>${b[1]}</td>
            <td>${b[2]}</td>
        </tr>
        </c:forEach>
    </table>
</div>

<script>
    let userLabels=[], userInfo=[];
    
    <c:forEach items="${baivietStats}" var="b">
        userLabels.push('${b[1]}')
        userInfo.push(${b[2]})
    </c:forEach>
    
    window.onload = function(){
        donhangChart("myBaivietStatsChart", userLabels, userInfo)
    }
</script>
