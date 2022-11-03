<%-- 
    Document   : admin-left
    Created on : Oct 15, 2022, 3:00:16 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar">
    <div class="container-fluid" style="margin: 20px">
        <ul class="navbar-nav">
          <li class="nav-item">
              <a class="nav-link" href="<c:url value="/admin/donhang_stats"/>">Thống kê đơn hàng theo shipper</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<c:url value="/admin/baiviet_stats"/>">Thống kê bài viết theo user</a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="<c:url value="/"/>">Thoát</a>
          </li>
        </ul>
    </div>
</nav>
          <style>
              a.nav-link:hover{
                  color: green;
                }
          </style>
