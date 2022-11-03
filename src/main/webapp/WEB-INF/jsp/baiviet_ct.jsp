<%-- 
    Document   : daugia_ct
    Created on : Sep 3, 2022, 4:53:12 PM
    Author     : Admin
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container1">
    <h1 class="text-center">Chi tiết bài viết</h1>
        <div class="row-md-4">
                        <div class="card h-100" style="margin: 10px 30px 0 0">
                            <div class="card-body">
                                <h1 class="card-title">${baiviet.idUser.name}</h1>
                                <i>${baiviet.ngaytao}</i>
                                <p class="card-text">${baiviet.noidung}</p>
                                <img src="${baiviet.anh}" width="200px" height="200px" alt="alt"/>
                                <div><input type="button" onclick="addDonhang(${baiviet.id})"
                                           value="Nhận đơn" class="btn btn-dark" style="margin-top: 10px"/></div>
                            </div>
                            <form>
                                <div class="card-footer form-group">
                                    <textarea class="form-control" id="binhluanId" placeholder="Nhập bình luận đấu giá..."></textarea>
                                    <input type="button" onclick="addBinhluan(${baiviet.id})"
                                           value="Thêm bình luận" class="btn btn-dark" style="margin-top: 10px"/>
                                </div>
                            </form>
                            <div class="binhluanArea">
                                <c:forEach items="${baiviet.binhluanSet}" var="b">
                                    <div class="row-lg"  style="border-bottom: 1px solid rgba(0,0,0,.125)">
                                        <div class="row">
                                            <div class="col-1">
                                                <img class="rounded-circle img-fluid" style="margin: 10px 0 0 20px; width: 70px; height: 70px" src="<c:url value="${b.idUser.image}" />"/>
                                            </div>
                                            <div class="col-sm-9 my-date">
                                                <h1>${b.idUser.name}</h1>
                                                <i>${b.thoigian}</i>
                                            </div>
                                        </div>
                                            <div class="row-lg" style="padding: 20px 0 0 130px">
                                            <p>${b.noidung}</p>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
        </div>
</div>
<style>

    .card-text{
        padding-top: 20px
    }
</style>
<script>
    window.onload = function(){
        let dates = document.querySelectorAll(".my-date > i");
        for (let i = 0; i < dates.length; i++){
            let d = dates[i];
            d.innerText = moment(d.innerText).fromNow();
        }
    };
    
</script>
