<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="main">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href="home">Home</a></li>
			<li class="active">Search result</li>
		</ul>
		<!-- BEGIN SIDEBAR & CONTENT -->
		<div class="row margin-bottom-40">
			<!-- BEGIN SIDEBAR -->
			<div class="sidebar col-md-3 col-sm-5">
				<div class="sidebar-products clearfix">
					<h2>Bestsellers</h2>
					<c:forEach items="${listTop3Product}" var="o">
						<div class="item">
							<a href="shop-item.html"><img src="${o.image}"
								alt="Some Shoes in Animal with Cut Out"></a>
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
				<div class="content-search margin-bottom-20">
					<div class="row">
						<div class="col-md-6">
							<h1>
								Search result for <em>${txtS}</em>
							</h1>
						</div>
						<div class="col-md-6">
							<form action="#">
								<div class="input-group">
									<input type="text" name="txt" value="${txtS}"
										placeholder="Search again" class="form-control"> <span
										class="input-group-btn">
										<button class="btn btn-primary" type="submit">Search</button>
									</span>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="row list-view-sorting clearfix">
					<div class="col-md-2 col-sm-2 list-view">
						<a href="#"><i class="fa fa-th-large"></i></a> <a href="#"><i
							class="fa fa-th-list"></i></a>
					</div>
					<div class="col-md-10 col-sm-10">
						<div class="pull-right">
							<label class="control-label">Sort&nbsp;By:</label> <select
								class="form-control input-sm">
								<option value="#?sort=p.sort_order&amp;order=ASC"
									selected="selected">Default</option>
								<option value="#?sort=pd.name&amp;order=ASC">Name (A -
									Z)</option>
								<option value="#?sort=pd.name&amp;order=DESC">Name (Z -
									A)</option>
								<option value="#?sort=p.price&amp;order=ASC">Price (Low
									&gt; High)</option>
								<option value="#?sort=p.price&amp;order=DESC">Price
									(High &gt; Low)</option>
								<option value="#?sort=rating&amp;order=DESC">Rating
									(Highest)</option>
								<option value="#?sort=rating&amp;order=ASC">Rating
									(Lowest)</option>
								<option value="#?sort=p.model&amp;order=ASC">Model (A -
									Z)</option>
								<option value="#?sort=p.model&amp;order=DESC">Model (Z
									- A)</option>
							</select>
						</div>
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
								<a href="#" class="btn btn-default add2cart">Add to cart</a>
							</div>
						</div>
					</c:forEach>
					<!-- PRODUCT ITEM END -->
				</div>
				<!-- END PRODUCT LIST -->
				<!-- BEGIN PAGINATOR -->
				<div class="row">
					<div class="col-md-4 col-sm-4 items-info">Items 1 to 9 of 10
						total</div>
					<div class="col-md-8 col-sm-8">
						<ul class="pagination pull-right">
							<li><a href="#">&laquo;</a></li>
							<li><a href="#">1</a></li>
							<li><span>2</span></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">&raquo;</a></li>
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