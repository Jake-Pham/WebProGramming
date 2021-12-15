<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- BEGIN CONTENT -->
<div class="page-content-wrapper">
	<div class="page-content">
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
				<!-- BEGIN EXAMPLE TABLE PORTLET-->
				<div class="portlet box blue">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-edit"></i>Danh Sách Sản Phẩm Seller
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse"> </a> <a
								href="#portlet-config" data-toggle="modal" class="config"> </a>
							<a href="javascript:;" class="reload"> </a> <a
								href="javascript:;" class="remove"> </a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar"></div>
						<table class="table table-striped table-hover table-bordered"
							id="sample_editable_1">
							<thead>
								<tr>
									<th>STT</th>
									<th>Tên Sản Phẩm</th>
									<th>Ảnh Đại Diện</th>
									<th>Mô Tả</th>
									<th>Giá</th>
									<th>Số Lượng</th>
									<th>Seller ID</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${myproduct }" var="p" varStatus="STT">
									<tr class="odd gradex">
										<td>${STT.index+1 }</td>
										<td>${p.name }</td>
										<td><img src='${p.image }' height="100" width="100" /></td>
										<td>${p.description }</td>
										<td>${p.price }</td>
										<td>${p.amount }</td>
										<td>${p.sellerID }</td>
										<td><a
											href="<c:url value='/seller/product/edit?pid=${p.id }'/>"
											class="center">Sửa</a> <a
											href="<c:url value='/seller/product/delete?pid=${p.id }'/>"
											class="center">Xóa</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										<span class="sr-only">Previous</span>
								</a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										<span class="sr-only">Next</span>
								</a></li>
							</ul>
						</nav>
					</div>
				</div>
				<!-- END EXAMPLE TABLE PORTLET-->
			</div>
		</div>

		<!-- END PAGE CONTENT -->