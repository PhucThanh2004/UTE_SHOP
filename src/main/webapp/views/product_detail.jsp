<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url value="/assets/user" var="URL"></c:url>
<!-- Hero Section Begin -->
<section class="hero hero-normal">
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="hero__categories">
					<div class="hero__categories__all">
						<i class="fa fa-bars"></i> <span>Danh mục</span>
					</div>
					<ul>
						<c:forEach var="category" items="${categories}">
							<li><a
								href="${pageContext.request.contextPath}/category?id=${category.id}">${category.name}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="col-lg-9">
				<div class="hero__search">
					<div class="hero__search__form">
						<form action="#">
							<div class="hero__search__categories">
								All Categories <span class="arrow_carrot-down"></span>
							</div>
							<input type="text" placeholder="What do yo u need?">
							<button type="submit" class="site-btn">SEARCH</button>
						</form>
					</div>
					<div class="hero__search__phone">
						<div class="hero__search__phone__icon">
							<i class="fa fa-phone"></i>
						</div>
						<div class="hero__search__phone__text">
							<h5>+65 11.188.888</h5>
							<span>support 24/7 time</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Hero Section End -->

<!-- Breadcrumb Section Begin -->
<%--<section class="breadcrumb-section set-bg" data-setbg="${URL}/img/breadcrumb.jpg">--%>
<%--    <div class="container">--%>
<%--        <div class="row">--%>
<%--            <div class="col-lg-12 text-center">--%>
<%--                <div class="breadcrumb__text">--%>
<%--                    <h2>Vegetable’s Package</h2>--%>
<%--                    <div class="breadcrumb__option">--%>
<%--                        <a href="./index.html">Home</a>--%>
<%--                        <a href="./index.html">Vegetables</a>--%>
<%--                        <span>Vegetable’s Package</span>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>
<!-- Breadcrumb Section End -->

<!-- Product Details Section Begin -->
<section class="product-details spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="product__details__pic">
					<div class="product__details__pic__item">

						<img class="product__details__pic__item--large"
							src="${pageContext.request.contextPath}/image?fname=${product.images[0]}"
							alt="">
					</div>
					<div class="product__details__pic__slider owl-carousel">
						<c:forEach var="image" items="${product.images}">
							<img
								data-imgbigurl="${pageContext.request.contextPath}/image?fname=${image}"
								src="${pageContext.request.contextPath}/image?fname=${image}"
								alt="">
						</c:forEach>
						<%--                        <img data-imgbigurl="img/product/details/product-details-3.jpg"--%>
						<%--                             src="img/product/details/thumb-2.jpg" alt="">--%>
						<%--                        <img data-imgbigurl="img/product/details/product-details-5.jpg"--%>
						<%--                             src="img/product/details/thumb-3.jpg" alt="">--%>
						<%--                        <img data-imgbigurl="img/product/details/product-details-4.jpg"--%>
						<%--                             src="img/product/details/thumb-4.jpg" alt="">--%>
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="product__details__text">
					<h3>${product.name}</h3>
					<div class="product__details__rating">
						<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> <i class="fa fa-star"></i> <i
							class="fa fa-star-half-o"></i> <span>(18 reviews)</span>
					</div>
					<div class="product__details__price">${product.price}</div>
					<form action="${pageContext.request.contextPath}/cart/add"
						method="post">
						<input type="hidden" name="productId" value="${product.id}">
						<div class="product__details__quantity">
							<div class="quantity">
								<div class="pro-qty">
									<input name="quantity" type="text" value="1">
								</div>
							</div>
						</div>
						<button type="submit" class="primary-btn">ADD TO CARD</button>
					</form>
					<a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>
					<ul>
						<li><b>Availability</b> <span>${product.stockQuantity}</span></li>
						<li><b>Shipping</b> <span>01 day shipping. <samp>Free
									pickup today</samp></span></li>
						<li><b>Weight</b> <span>0.5 kg</span></li>
						<li><b>Share on</b>
							<div class="share">
								<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
									class="fa fa-twitter"></i></a> <a href="#"><i
									class="fa fa-instagram"></i></a> <a href="#"><i
									class="fa fa-pinterest"></i></a>
							</div></li>
					</ul>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="product__details__tab">
					<ul class="nav nav-tabs" role="tablist">
						<li class="nav-item"><a class="nav-link active"
							data-toggle="tab" href="#tabs-1" role="tab" aria-selected="true">Description</a>
						</li>
						<li class="nav-item"><a class="nav-link" data-toggle="tab"
							href="#tabs-2" role="tab" aria-selected="false">Information</a></li>
						<li class="nav-item"><a class="nav-link" data-toggle="tab"
							href="#tabs-3" role="tab" aria-selected="false">Reviews <span></span></a>
						</li>
					</ul>
					<div class="tab-content">
						<!-- Tab 1: Thông tin sản phẩm -->
						<div class="tab-pane fade show active" id="tabs-1" role="tabpanel">
							<div class="product__details__tab__desc">
								<h6>Thông tin sản phẩm</h6>
								<p>${product.description}</p>
							</div>
						</div>

						<!-- Tab 2: Products Information -->
						<div class="tab-pane fade" id="tabs-2" role="tabpanel">
							<div class="product__details__tab__desc">
								<h6>Products Information</h6>
								<p>Vestibulum ac diam sit amet quam vehicula elementum sed
									sit amet dui. Pellentesque in ipsum id orci porta dapibus.
									Proin</p>
							</div>
						</div>

						<!-- Tab 3: Đánh giá sản phẩm -->
						<div class="tab-pane fade" id="tabs-3" role="tabpanel">
							<div class="product__details__tab__desc">
								<c:forEach var="review" items="${reviews}">
									<div class="review-box">
										<div class="review-header">
											<h5 class="author-name">${review.authorName}
												<span class="review-date">(${review.createdAt})</span>
											</h5>
										</div>
										<div class="review-content">
											<p>${review.content}</p>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	</div>
</section>
<!-- Product Details Section End -->
