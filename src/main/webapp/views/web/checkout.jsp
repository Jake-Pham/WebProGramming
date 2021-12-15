<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="main">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href="index.html">Home</a></li>
			<li><a href="">Store</a></li>
			<li class="active">Checkout</li>
		</ul>
		<!-- BEGIN SIDEBAR & CONTENT -->
		<div class="row margin-bottom-40">
			<!-- BEGIN CONTENT -->
			<div class="col-md-12 col-sm-12">
				<h1>Checkout</h1>
				<!-- BEGIN CHECKOUT PAGE -->
				<div class="panel-group checkout-page accordion scrollable"
					id="checkout-page">

					<!-- BEGIN CHECKOUT -->
					<div id="shipping-address" class="panel panel-default">
						<form action="confirm" method="post">
							<!-- BEGIN SHIPPING ADDRESS -->
							<div id="shipping-address" class="panel panel-default">
								<div class="panel-heading">
									<h2 class="panel-title">
										<a data-toggle="collapse" data-parent="#checkout-page"
											href="#shipping-address-content" class="accordion-toggle">
											Delivery Details </a>
									</h2>
								</div>
								<div id="shipping-address-content"
									class="panel-collapse collapse in">
									<div class="panel-body row">
										<div class="col-md-6 col-sm-6">
											<div class="form-group">
												<label for="firstname-dd">First Name <span
													class="require">*</span></label> <input type="text"
													value="${sessionScope.acc.fname}" name="fname"
													class="form-control">
											</div>
											<div class="form-group">
												<label for="lastname-dd">Last Name <span
													class="require">*</span></label> <input type="text"
													value="${sessionScope.acc.lname}" name="lname"
													class="form-control">
											</div>
											<div class="form-group">
												<label for="email-dd">E-Mail <span class="require">*</span></label>
												<input type="text" value="${sessionScope.acc.email}"
													name="email" class="form-control">
											</div>
										</div>
										<div class="col-md-6 col-sm-6">
											<div class="form-group">
												<label for="telephone-dd">Telephone <span
													class="require">*</span></label> <input type="text" name="phone"
													class="form-control">
											</div>
											<div class="form-group">
												<label for="address1-dd">Address <span
													class="require">*</span></label><input type="text"
													value="${sessionScope.acc.adrs}" name="adrs"
													class="form-control">
											</div>
											<div class="form-group">
												<label>City <span class="require">*</span></label> <select
													class="form-control input-sm" name="selectcity">
													<c:forEach items="${listAllCity}" var="o">
														<option value="${o.id}">${o.city}</option>
													</c:forEach>
												</select>
											</div>
										</div>

									</div>
								</div>
								<div id="confirm-content" class="panel-collapse collapse in">
									<div class="panel-body row">
										<div class="col-md-12 clearfix">
											<div class="table-wrapper-responsive">
												<table>
													<tr>
														<th class="goods-page-image">Image</th>
														<th class="goods-page-description">Product Name</th>
														<th class="goods-page-ref-no">Unit Price</th>
														<th class="goods-page-quantity">Quantity</th>
														<th class="goods-page-total" colspan="2">Total</th>
													</tr>
													<c:forEach items="${sessionScope.cart}" var="map">
														<tr>
															<c:url value="${map.value.product.image}" var="imgUrl"></c:url>
															<td><img class="img-responsive" width="60px"
																height="60px" src="${imgUrl}" /></td>
															<td><a
																href="productdetail?pid=${map.value.product.id}&cid=${map.value.product.categoryID}">${map.value.product.name }</a></td>
															<td>${map.value.product.price }</td>
															<td>${map.value.quantity}</td>
															<td class="text-right shop-red">
																${map.value.product.price * map.value.quantity }</</td>
														</tr>
													</c:forEach>
												</table>
											</div>
											<div class="clearfix"></div>
											<button class="btn btn-primary pull-right" type="submit"
												id="button-confirm">Continute</button>
											<a href="cart"><button type="button"
													class="btn btn-default pull-right margin-right-20">Cancel</button></a>
										</div>
									</div>
								</div>
							</div>
							<!-- END SHIPPING ADDRESS -->

							<!-- BEGIN CONFIRM -->

							<!-- END CONFIRM -->
						</form>
					</div>
					<!-- END CHECKOUT PAGE -->
				</div>
				<!-- END CONTENT -->
			</div>
			<!-- END SIDEBAR & CONTENT -->
		</div>
	</div>
</div>