<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/assets/user" var="URL"></c:url>
<c:url value="/" var="URL_PRIMARY"></c:url>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>UTE Shop</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="${URL}/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet" href="${URL}/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="${URL}/css/elegant-icons.css"
	type="text/css">
<link rel="stylesheet" href="${URL}/css/nice-select.css" type="text/css">
<link rel="stylesheet" href="${URL}/css/jquery-ui.min.css"
	type="text/css">
<link rel="stylesheet" href="${URL}/css/owl.carousel.min.css"
	type="text/css">
<link rel="stylesheet" href="${URL}/css/slicknav.min.css"
	type="text/css">
<link rel="stylesheet" href="${URL}/css/style.css" type="text/css">
</head>

<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Humberger Begin -->
	<div class="humberger__menu__overlay"></div>
	<div class="humberger__menu__wrapper">
		<div class="humberger__menu__logo">
			<a href="#"><img src="${URL}/img/logo.png" alt=""></a>
		</div>
		<div class="humberger__menu__cart">
			<ul>
				<li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
				<li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
			</ul>
			<div class="header__cart__price">
				item: <span>$150.00</span>
			</div>
		</div>
		<div class="humberger__menu__widget">
			<div class="header__top__right__language">
				<img src="${URL}/img/language.png" alt="">
				<div>English</div>
				<span class="arrow_carrot-down"></span>
				<ul>
					<li><a href="#">Spanis</a></li>
					<li><a href="#">English</a></li>
				</ul>
			</div>
			<!-- Thay đổi phần hiển thị Login/Logout và giữ lại Đăng ký shop -->
			<div class="header__top__right__auth">
				<c:choose>
					<c:when test="${not empty sessionScope.account}">
						<a href="${pageContext.request.contextPath}/logout"><i
							class="fa fa-user"></i> Logout</a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/login"><i
							class="fa fa-user"></i> Login</a>
					</c:otherwise>
				</c:choose>
				<a href="${URL_PRIMARY}register-shop" class="ml-2"><i
					class="fa fa-shopping-bag"></i> Đăng ký shop</a>
			</div>

		</div>
		<nav class="humberger__menu__nav mobile-menu">
			<ul>
				<li class="active"><a
					href="${pageContext.request.contextPath}/home">Home</a></li>
				<li><a href="${pageContext.request.contextPath}/home">Shop</a></li>
				<li><a href="${pageContext.request.contextPath}/home">Blog</a></li>
				<li><a href="${pageContext.request.contextPath}/orders">Đơn
						hàng của tôi</a></li>
			</ul>
		</nav>
		<div id="mobile-menu-wrap"></div>
		<div class="header__top__right__social">
			<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
				class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-linkedin"></i></a>
			<a href="#"><i class="fa fa-pinterest-p"></i></a>
		</div>
		<div class="humberger__menu__contact">
			<ul>
				<c:choose>
					<c:when test="${not empty sessionScope.account}">
						<li><i class="fa fa-envelope"></i>
							${sessionScope.account.email}</li>
					</c:when>
					<c:otherwise>
						<li><i class="fa fa-envelope"></i> hello@uteshop.com</li>
					</c:otherwise>
				</c:choose>


				<li>Miễn phí ship cho đơn hàng từ 150k</li>
			</ul>
		</div>
	</div>

	<!-- Humberger End -->

	<!-- Header Section Begin -->
	<header class="header">
		<div class="header__top">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 col-md-6">
						<div class="header__top__left">
							<ul>
								<c:choose>
									<c:when test="${not empty sessionScope.account}">
										<li><i class="fa fa-envelope"></i>
											<a href="${pageContext.request.contextPath}/account?email=${account.email}">${sessionScope.account.email}</a></li>
									</c:when>
									<c:otherwise>
										<li><i class="fa fa-envelope"></i> hello@uteshop.com</li>
									</c:otherwise>
								</c:choose>


								<li>Miễn phí ship cho đơn hàng từ 150k</li>
							</ul>
						</div>
					</div>
					<div class="col-lg-6 col-md-6">
						<div class="header__top__right d-flex justify-content-end">
							<div class="header__top__right__social">
								<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
									class="fa fa-twitter"></i></a> <a href="#"><i
									class="fa fa-linkedin"></i></a> <a href="#"><i
									class="fa fa-pinterest-p"></i></a>
							</div>
							<div class="header__top__right__language">
								<img src="img/language.png" alt="">
								<div>English</div>
								<span class="arrow_carrot-down"></span>
								<ul>
									<li><a href="#">Spanis</a></li>
									<li><a href="#">English</a></li>
								</ul>
							</div>
							<!-- Thay đổi phần hiển thị Login/Logout và giữ lại Đăng ký shop -->
							<div class="header__top__right__auth">
								<c:choose>
									<c:when test="${not empty sessionScope.account}">
										<a href="${pageContext.request.contextPath}/logout"><i
											class="fa fa-user"></i> Logout</a>
									</c:when>
									<c:otherwise>
										<a href="${pageContext.request.contextPath}/login"><i
											class="fa fa-user"></i> Login</a>
									</c:otherwise>
								</c:choose>
								<a href="${URL_PRIMARY}register-shop" class="ml-2"><iclass
										="fafa-shopping-bag">
									</i> Đăng ký shop</a>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="header__logo">
						<a href="${URL_PRIMARY}/home"><img src="${URL}/img/logo.png"
							alt=""></a>
					</div>
				</div>
				<div class="col-lg-6">
					<nav class="header__menu">
						<ul>
							<li class="active"><a
								href="${pageContext.request.contextPath}/home">Home</a></li>
							<li><a href="${pageContext.request.contextPath}/home">Shop</a></li>
							<li><a href="${pageContext.request.contextPath}/home">Blog</a></li>
							<li><a href="${pageContext.request.contextPath}/orders">Đơn
									hàng của tôi</a></li>
						</ul>
					</nav>
				</div>
				<div class="col-lg-3">
					<div class="header__cart">
						<ul>
							<li><a href="${URL_PRIMARY}cart/view"><i
									class="fa fa-shopping-bag"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="humberger__open">
				<i class="fa fa-bars"></i>
			</div>
		</div>
	</header>
	<!-- Header Section End -->