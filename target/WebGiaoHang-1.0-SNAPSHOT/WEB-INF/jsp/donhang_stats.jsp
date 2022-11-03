<%-- 
    Document   : donhang_stats
    Created on : Oct 15, 2022, 3:04:59 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container1">
    <h2 class="text-center text-danger">Thống kê đơn hàng của shipper</h2>
    <div>
        <canvas id="myDonhangStatsChart"></canvas>
    </div>
    <table class="table">
        <tr>
            <th>Mã shipper</th>
            <th>Tên shipper</th>
            <th>Số lượng đơn</th>
        </tr>
        <c:forEach items="${donhangStats}" var="d">
        <tr>
            <td>${d[0]}</td>
            <td>${d[1]}</td>
            <td>${d[2]}</td>
        </tr>
        </c:forEach>
    </table>
</div>

<script>
    let userLabels=[], userInfo=[];
    
    <c:forEach items="${donhangStats}" var="d">
        userLabels.push('${d[1]}')
        userInfo.push(${d[2]})
    </c:forEach>
    
    window.onload = function(){
        donhangChart("myDonhangStatsChart", userLabels, userInfo)
    }
</script>