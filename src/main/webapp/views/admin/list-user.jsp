<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!--Import jQuery before export.js-->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>


<!--Data Table-->
<script type="text/javascript"
	src=" https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src=" https://cdn.datatables.net/buttons/1.2.4/js/dataTables.buttons.min.js"></script>

<!--Export table buttons-->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
<script type="text/javascript"
	src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.24/build/pdfmake.min.js"></script>
<script type="text/javascript"
	src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.24/build/vfs_fonts.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.2.4/js/buttons.html5.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.2.1/js/buttons.print.min.js"></script>

<!--Export table button CSS-->

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/buttons/1.2.4/css/buttons.dataTables.min.css">
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
							<i class="fa fa-edit"></i>Danh Sách Khách Hàng
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
						<table id="tbl"
							class="table table-striped table-bordered table-condensed"
							style="width: 100%">
							<thead>
								<tr>
									<th>STT</th>
									<th>Tên</th>
									<th>Họ</th>
									<th>Email</th>
									<th>Mật Khẩu</th>
									<th>Address</th>
									<th>Seller</th>
									<th>Admin</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${userList }" var="user" varStatus="STT">
									<tr class="odd gradex">
										<td>${STT.index+1 }</td>
										<td>${user.fname }</td>
										<td>${user.lname }</td>
										<td>${user.email }</td>
										<td>${user.pass }</td>
										<td>${user.adrs }</td>
										<td>${user.isSell }</td>
										<td>${user.isAdmin }</td>
										<td><a
											href="<c:url value='/admin/user/edit?uid=${user.uid }'/>"
											class="center">Sửa</a> <a
											href="<c:url value='/admin/user/delete?uid=${user.uid }'/>"
											class="center">Xóa</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<nav aria-label="Page navigation example">							
						</nav>
					</div>
				</div>
				<!-- END EXAMPLE TABLE PORTLET-->
			</div>
		</div>
		<script>
			$('#tbl').DataTable({
				dom : 'Bfrtip',
				buttons : [ 'copy', 'csv', 'excel', 'pdf', 'print' ]
			});
		</script>
		<!-- END PAGE CONTENT -->