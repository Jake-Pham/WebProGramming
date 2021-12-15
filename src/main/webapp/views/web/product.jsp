<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="main">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href="home">Home</a></li>
			<li class="active">Sản phẩm</li>
		</ul>
		<!-- BEGIN SIDEBAR & CONTENT -->
		<div class="row margin-bottom-40">
			<!-- BEGIN SIDEBAR -->
			<div class="sidebar col-md-3 col-sm-5">
				<ul class="list-group margin-bottom-25 sidebar-menu">
					<c:forEach items="${listAllcategory}" var="o">
						<li class="list-group-item clearfix ${tagactive==o.cate_id ? "active":""}"><a
							href="product?cid=${o.cate_id}"><img src="${o.icons}" width="35"
								height="35"><i class="fa fa-angle"></i> ${o.cname}</a></li>
					</c:forEach>
				</ul>

				<div class="sidebar-products clearfix">
					<h2>Best sellers</h2>
					<c:forEach items="${listTop3Product}" var="o">
						<div class="item">
							<a href="shop-item.html"><img src="${o.image}"
								alt="${o.name}"></a>
							<h3>
								<a href="productdetail?pid=${o.id}&cid=${o.categoryID}">${o.name}</a>
							</h3>
							<div class="price">${o.price}</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<!-- END SIDEBAR -->
			<!-- BEGIN CONTENT -->
			<div class="col-md-9 col-sm-7">
				<div class="row list-view-sorting clearfix">
					<div class="col-md-2 col-sm-2 list-view">
						<a href="#"><i class="fa fa-th-large"></i></a> <a href="#"><i
							class="fa fa-th-list"></i></a>
					</div>
				</div>
				<!-- BEGIN PRODUCT LIST -->
				<div class="row product-list">
					<!-- PRODUCT ITEM START -->
					<c:forEach items="${listAllProduct}" var="o">
						<div class="col-md-4 col-sm-6 col-xs-12">
							<div class="product-item">
								<div class="pi-img-wrapper">
									<img src="${o.image}" class="img-responsive" alt="${o.name}">
									<div>
										<a href="${o.image}" class="btn btn-default fancybox-button">Zoom</a>
									</div>
								</div>
								<h3>
									<a href="productdetail?pid=${o.id}&cid=${o.categoryID}">${o.name}</a>
								</h3>
								<div class="pi-price">${o.price}</div>
								<c:if test="${sessionScope.acc != null}">
								<a href="<c:url value="/cart-add?pid=${o.id}&quantity=1"/>" class="btn btn-default add2cart">Add to cart</a>
								</c:if>
								<c:if test="${sessionScope.acc == null}">
								<a href="login" class="btn btn-default add2cart">Add to cart</a>
								</c:if>
							</div>
						</div>
					</c:forEach>
					<!-- PRODUCT ITEM END -->
				</div>
				<!-- END PRODUCT LIST -->
				<!-- BEGIN PAGINATOR -->
				<div class="row">
					<div class="col-md-8 col-sm-8">
						<ul class="pagination pull-right">
							<c:if test="${tag>1}">
								<li class="page-item"><a class="page-link"
									href="product?cid=${cid}&index=${tag-1}">&laquo;</a></li>
							</c:if>
							<c:forEach begin="1" end="${endP}" var="i">
								<li class="page-item ${tag==i ? "active":""}"><a
									class="page-link" href="product?cid=${cid}&index=${i}">${i}</a></li>
							</c:forEach>
							<c:if test="${tag<endP}">
								<li class="page-item"><a class="page-link"
									href="product?cid=${cid}&index=${tag+1}">&raquo;</a></li>
							</c:if>
						</ul>
					</div>
				</div>
				<!-- END PAGINATOR -->
			</div>
			<!-- END CONTENT -->
		</div>
		<!-- END SIDEBAR & CONTENT -->
	</div>
</div>



