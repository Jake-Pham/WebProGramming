<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- BEGIN TOP BAR -->
<div class="pre-header">
	<div class="container">
		<div class="row">
			<!-- BEGIN TOP BAR LEFT PART -->
			<div class="col-md-6 col-sm-6 additional-shop-info"></div>
			<!-- END TOP BAR LEFT PART -->
			<!-- BEGIN TOP BAR MENU -->
			<div class="col-md-6 col-sm-6 additional-nav">
				<ul class="list-unstyled list-inline pull-right">
					<c:if test="${sessionScope.acc != null}">
						<li class="nav-item"><a class="nav-link" href="/KDA/profile/edit?uid=${sessionScope.acc.uid }">Xin
								chào ${acc.fname}</a></li>
						<li class="nav-item"><a class="nav-link" href="logout">Đăng
								xuất</a></li>
					</c:if>
					<c:if test="${sessionScope.acc == null}">
						<li class="nav-item"><a class="nav-link" href="login">Đăng
								nhập</a></li>
					</c:if>
				</ul>
			</div>
			<!-- END TOP BAR MENU -->
		</div>
	</div>
</div>
<!-- END TOP BAR -->

<!-- BEGIN HEADER -->
<div class="header">
	<div class="container">
		<a class="site-logo" href="home"><img
			src="<c:url value="/templates/assets/frontend/layout/img/logos/kda.png"/>"
			width="150" height="50" alt="KDA Store"></a> <a
			href="javascript:void(0);" class="mobi-toggler"><i
			class="fa fa-bars"></i></a>

		<!-- BEGIN CART -->
		<div class="top-cart-block">
			<div class="top-cart-info">
				<c:if test="${sessionScope.acc != null}">
					<a href="javascript:void(0);" class="top-cart-info-count"> <c:set
							var="count" value="${0}" /> <c:forEach
							items="${sessionScope.cart}" var="map">
							<c:set var="count" value="${count + map.value.quantity}" />
						</c:forEach> ${count} items
					</a>
				</c:if>
				<c:if test="${sessionScope.acc == null}">
					<a href="javascript:void(0);" class="top-cart-info-count">0
						items </a>
				</c:if>
			</div>
			<i class="fa fa-shopping-cart"></i>

			<div class="top-cart-content-wrapper">
				<div class="top-cart-content">
					<ul class="scroller" style="height: 250px;">
						<c:if test="${sessionScope.acc != null}">
							<c:forEach items="${sessionScope.cart}" var="map">
								<li><a
									href="productdetail?pid=${map.value.product.id}&cid=${map.value.product.categoryID}"><img
										src="${map.value.product.image}" alt="Rolex Classic Watch"
										width="37" height="34"></a> <span class="cart-content-count">x
										${map.value.quantity}</span> <strong><a
										href="productdetail?pid=${map.value.product.id}&cid=${map.value.product.categoryID}">${map.value.product.name}</a></strong>
									<em>${map.value.product.price}</em> <a
									href="${pageContext.request.contextPath}/cart-remove?pid=${map.value.product.id}"
									class="del-goods">&nbsp;</a></li>
							</c:forEach>
						</c:if>
					</ul>
					<c:if test="${sessionScope.acc != null}">
						<div class="text-right">
							<a href="cart" class="btn btn-default">View Cart</a> <a
								href="checkout" class="btn btn-primary">Checkout</a>
						</div>
					</c:if>
					<c:if test="${sessionScope.acc == null}">
						<div class="text-right">
							<a href="login" class="btn btn-default">View Cart</a> <a
								href="login" class="btn btn-primary">Checkout</a>
						</div>
					</c:if>
				</div>
			</div>
		</div>
		<!--END CART -->

		<!-- BEGIN NAVIGATION -->
		<div class="header-navigation">
			<ul>
				<li class="nav-item active"><a class="nav-link" href="/KDA/home">Trang
						chủ</a></li>
				<li class="nav-item"><a class="nav-link" href="/KDA/product?cid=0">Sản
						phẩm</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" id="navbarDropdown" role="button"
					href="" data-toggle="dropdown" data-target="#" aria-haspopup="true"
					aria-expanded="false">Danh mục</a>
					<ul class="dropdown-menu" aria-labelledby="navbarScrollingDropDown">
						<c:forEach items="${listAllcategory}" var="o">
							<li><a class="dropdown-item ${tagactive==o.cate_id ? "
								active":""}" href="/KDA/product?cid=${o.cate_id}">${o.cname}</a>
						</c:forEach>
					</ul></li>
				<c:if test="${sessionScope.acc.isAdmin == 1}">
					<li><a href="/KDA/admin/home" target="_blank">Admin theme</a></li>
				</c:if>
				<c:if
					test="${sessionScope.acc.isAdmin == 0 && sessionScope.acc.isSell == 1}">
					<li><a href="/KDA/seller/home" target="_blank">Seller
							theme</a></li>
				</c:if>


				<!-- BEGIN TOP SEARCH -->
				<li class="menu-search"><span class="sep"></span> <i
					class="fa fa-search search-btn"></i>
					<div class="search-box">
						<form action="search">
							<div class="input-group">
								<input type="text" name="txt" value="${txtS}"
									placeholder="Search" class="form-control"> <span
									class="input-group-btn">
									<button class="btn btn-primary" type="submit">Search</button>
								</span>
							</div>
						</form>
					</div></li>
				<!-- END TOP SEARCH -->
			</ul>
		</div>
		<!-- END NAVIGATION -->
	</div>
</div>
<!-- Header END -->
