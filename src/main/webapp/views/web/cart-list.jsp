<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="main">
	<div class="container">
		<!-- BEGIN SIDEBAR & CONTENT -->
		<div class="row margin-bottom-40">
			<!-- BEGIN CONTENT -->
			<div class="col-md-12 col-sm-12">
				<h1>Shopping cart</h1>
				<div class="goods-page">
					<div class="goods-data clearfix">
						<div class="table-wrapper-responsive">
							<table summary="Shopping cart">
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
										<td><a
											href="<c:url value="/cart-minus?pid=${map.value.product.id}&quantity=1"/>">
												<button type="button" class="btn btn-sm btn-danger"
													data-type="minus" data-field="">
													<i class="fa fa-minus"></i>
												</button>
										</a>${map.value.quantity}<a
											href="<c:url value="/cart-add?pid=${map.value.product.id}&quantity=1"/>"><button
													type="button" class="btn btn-sm btn-success"
													data-type="plus" data-field="">
													<i class="fa fa-plus"></i>
												</button></a></td>
										<td class="text-right shop-red">
											${map.value.product.price * map.value.quantity }</</td>

										<td class="del-goods-col"><a class="del-goods"
											href="${pageContext.request.contextPath}/cart-remove?pid=${map.value.product.id}">&nbsp;</a>
										</td>
									</tr>
								</c:forEach>
							</table>
						</div>

						<div class="shopping-total">
							<ul>
								<li><em>Total</em> <strong class="price"><span><c:set
												var="total" value="${0}" /> <c:forEach
												items="${sessionScope.cart}" var="map">
												<c:set var="total"
													value="${total + map.value.quantity * map.value.product.price}" />
											</c:forEach></span>${total }</strong></li>
	
							</ul>
						</div>
					</div>
					<a href="product?cid=0"><button class="btn btn-default" type="submit">
							Continue shopping <i class="fa fa-shopping-cart"></i>
						</button></a>
					<a href="/KDA/checkout"><button class="btn btn-primary" type="submit">
						Checkout <i class="fa fa-check"></i>
					</button></a>
				</div>
			</div>
			<!-- END CONTENT -->
		</div>
		<!-- END SIDEBAR & CONTENT -->


	</div>
</div>
