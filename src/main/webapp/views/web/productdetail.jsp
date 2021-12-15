<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="main">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href="home">Home</a></li>
			<c:forEach items="${listAllcategory}" var="o">
				<c:choose>
					<c:when test="${product.categoryID==o.cate_id}">
						<li><a href="product?cid=${o.cate_id}">${o.cname}</a></li>
					</c:when>
				</c:choose>
			</c:forEach>
			<li class="active">${product.name }</li>
		</ul>
		<!-- BEGIN SIDEBAR & CONTENT -->
		<div class="row margin-bottom-40">
			<!-- BEGIN SIDEBAR -->
			<div class="sidebar col-md-3 col-sm-5">
				<ul class="list-group margin-bottom-25 sidebar-menu">
					<c:forEach items="${listAllcategory}" var="o">
						<li class="list-group-item clearfix ${tagactive==o.cate_id ? "active":""}"><a
							href="product?cid=${o.cate_id}"><img src="${o.icons}"
								width="35" height="35"><i class="fa fa-angle"></i>
								${o.cname}</a></li>
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
				<div class="product-page">
					<div class="row">
						<div class="col-md-6 col-sm-6">
							<div class="product-main-image">
								<img src="${product.image}" alt="Cool green dress with red bell"
									class="img-responsive" data-BigImgsrc="${product.image}">
							</div>
						</div>
						<div class="col-md-6 col-sm-6">
							<h1>${product.name}</h1>
							<div class="price-availability-block clearfix">
								<div class="price">
									<strong>${product.price}</strong>
								</div>
								<div class="availability">
									Đã bán: <strong>${product.amount}</strong>
								</div>
							</div>
							<div class="description">
								<p>${product.description}</p>
							</div>
							<c:if test="${sessionScope.acc != null}">
								<form method="get" action="cart-add">
									<div class="product-page-cart">
										<div class="product-quantity">
											<input name="pid" value="${product.id}" id="product-quantity"
												type="hidden" readonly> <input name="quantity"
												value="1" id="product-quantity" type="text" readonly
												class="form-control input-sm">
										</div>
										<button class="btn btn-primary" type="submit">Add to
											cart</button>
									</div>
								</form>
							</c:if>
							<c:if test="${sessionScope.acc == null}">
								<form method="get" action="login">
									<div class="product-page-cart">
										<div class="product-quantity">
											<input name="pid" value="${product.id}" id="product-quantity"
												type="hidden" readonly> <input name="quantity"
												value="1" id="product-quantity" type="text" readonly
												class="form-control input-sm">
										</div>
										<button class="btn btn-primary" type="submit">Add to
											cart</button>
									</div>
								</form>
							</c:if>
							<div class="review">
								<a href="#">7 reviews</a>
							</div>
							<ul class="social-icons">
								<li><a class="facebook" data-original-title="facebook"
									href="#"></a></li>
								<li><a class="twitter" data-original-title="twitter"
									href="#"></a></li>
								<li><a class="googleplus" data-original-title="googleplus"
									href="#"></a></li>
								<li><a class="evernote" data-original-title="evernote"
									href="#"></a></li>
								<li><a class="tumblr" data-original-title="tumblr" href="#"></a></li>
							</ul>
						</div>
						<div class="product-page-content">
							<ul id="myTab" class="nav nav-tabs">
								<li class="active"><a href="#Reviews" data-toggle="tab">Reviews
								</a></li>
							</ul>
							<div id="myTabContent" class="tab-content">

								<div class="tab-pane fade in active" id="Reviews">
									<!--<p>There are no reviews for this product.</p>-->
									<c:forEach items="${listcomment}" var="o">
										<div class="review-item clearfix">
											<div class="review-item-submitted">
												<strong>${o.fname }</strong>
												<div class="rateit" data-rateit-value="5"
													data-rateit-ispreset="true" data-rateit-readonly="true"></div>
											</div>
											<div class="review-item-content">
												<p>${o.content }</p>
											</div>
										</div>
									</c:forEach>

									<!-- BEGIN FORM-->
									<form role="form" action="${add}" method="post"
										enctype="multipart/form-data">
										<h2>Write a review</h2>
										<div class="form-group">
											<input name="uid" value="${sessionScope.acc.uid}" hidden="" />
										</div>
										<div class="form-group">
											<input name="pid" value="${product.id }" hidden="" />
										</div>
										<div class="form-group">
											<label for="review">Review <span class="require">*</span></label>
											<textarea class="form-control" rows="8" name="review"></textarea>
										</div>

										<div class="padding-top-20">
											<button href="/KDA/productdetailtmp?pid=${o.id}&cid=${o.categoryID}"  type="submit" class="btn btn-primary">Send</button>
										</div>
									</form>
									<!-- END FORM-->
								</div>
							</div>
						</div>


						<div class="sticker sticker-sale"></div>
					</div>
				</div>
			</div>
			<!-- END CONTENT -->
		</div>
		<!-- END SIDEBAR & CONTENT -->
		<!-- BEGIN SIMILAR PRODUCTS -->
		<div class="row margin-bottom-40">
			<div class="col-md-12 col-sm-12">
				<h2>Most popular products</h2>
				<div class="owl-carousel owl-carousel4">
					<c:forEach items="${listProductByCID}" var="o">
						<div>
							<div class="product-item">
								<div class="pi-img-wrapper">
									<img src="${o.image}" class="img-responsive"
										alt="Berry Lace Dress">
									<div>
										<a href="${o.image}" class="btn btn-default fancybox-button">Zoom</a>
									</div>
								</div>
								<h3>
									<a href="productdetail?pid=${o.id}&cid=${o.categoryID}">${o.name}</a>
								</h3>
								<div class="pi-price">${o.price}</div>
								<c:if test="${sessionScope.acc != null}">
									<a href="<c:url value="/cart-add?pid=${o.id}&quantity=1"/>"
										class="btn btn-default add2cart">Add to cart</a>
								</c:if>
								<c:if test="${sessionScope.acc == null}">
									<a href="login" class="btn btn-default add2cart">Add to
										cart</a>
								</c:if>
								<div class="sticker sticker-new"></div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<!-- END SIMILAR PRODUCTS -->
	</div>
</div>
