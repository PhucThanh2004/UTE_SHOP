<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<c:url value="/assets/user" var="URL"></c:url>
<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg" data-setbg="${URL}/img/breadcrumb.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h2>Đăng nhập</h2>
                    <div class="breadcrumb__option">
                        <a href="/home">Trang chủ</a>
                        <span>Đăng nhập</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Login Section Begin -->
<section class="product-details spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <c:if test="${not empty errorMessage}">
                    <div class="alert alert-danger">
                            ${errorMessage}
                    </div>
                </c:if>

                <form action="${pageContext.request.contextPath}/login" method="POST">
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" required>
                    </div>

                    <div class="form-group">
                        <label for="password">Mật khẩu</label>
                        <input type="password" class="form-control" id="password" name="password" required>
                    </div>

                    <button type="submit" class="site-btn">Đăng nhập</button>
                </form>
            </div>
        </div>
    </div>
</section>
<!-- Login Section End -->
