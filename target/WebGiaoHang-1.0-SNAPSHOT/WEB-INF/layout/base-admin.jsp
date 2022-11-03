<%-- 
    Document   : base-admin
    Created on : Oct 15, 2022, 1:29:37 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        
        <title>
            <tiles:insertAttribute name="title"/>
        </title>
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <link href="<c:url value="/css/css.css"/>" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
        <script src="<c:url value="/js/main.js"/>"></script>
        <script src="<c:url value="/js/stats.js"/>"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    </head>
    <body>
        
        <h1 class="text-center">TRANG THỐNG KÊ BÁO CÁO</h1>
        <div class="row container1" style="margin: 0px">
            <div class="col-lg-3 bg-light" style="border-radius: 50px">
                    <tiles:insertAttribute name="left"/>
                </div>
                <div class="col-lg-9">
                    <tiles:insertAttribute name="content"/>
                </div>
            </div>
            
            
            <tiles:insertAttribute name="footer"/>

    </body>
        
</html>
