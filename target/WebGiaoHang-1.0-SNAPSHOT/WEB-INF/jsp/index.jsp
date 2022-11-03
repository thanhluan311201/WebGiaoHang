<%-- 
    Document   : index
    Created on : Aug 24, 2022, 11:52:36 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container1">
    <h1>Chào mừng đến với Website giao hàng</h1>
    <!-- Carousel -->
    <div id="demo" class="carousel slide" data-bs-ride="carousel">

      <!-- Indicators/dots -->
      <div class="carousel-indicators">
        <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
      </div>

      <!-- The slideshow/carousel -->
      <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="<c:url value="/image/shipper-1.jpg"/>" alt="Anh" class="d-block w-100">
        </div>
        <div class="carousel-item">
          <img src="<c:url value="/image/gh2.jpg"/>" alt="Anh" class="d-block w-100">
        </div>
        <div class="carousel-item">
          <img src="<c:url value="/image/gh3.jpg"/>" alt="Anh" class="d-block w-100">
        </div>
      </div>

      <!-- Left and right controls/icons -->
      <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
        <span class="carousel-control-prev-icon"></span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
        <span class="carousel-control-next-icon"></span>
      </button>
    </div>
</div>
        <style>
            img{
                width: 200px;
                height: 500px;
            }
        </style>