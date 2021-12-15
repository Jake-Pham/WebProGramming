<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<!-- /. NAV SIDE  -->
<div class="page-content-wrapper">
	<div class="page-content">
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
				<h2>Chỉnh sửa User</h2>
				<h5>Nơi bạn có thể chỉnh sửa thông tin User</h5>
			</div>
		</div>
		<!-- /. ROW  -->
		<hr />
		<div class="row">
			<div class="col-md-12">
				<!-- Form Elements -->
				<div class="panel panel-default">
					<div class="panel-heading">Chỉnh sửa User</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<h3>User:</h3>
								<c:url value="/admin/user/edit" var="edit"></c:url>
								<form role="form" action="${edit}" method="post"
									enctype="multipart/form-data">
									<input name="id" value="${userinf.uid }" hidden="">
									<div class="form-group">
										<label for="firstname" class="col-lg-4 control-label">First
											Name </label>
										<div class="col-lg-8">
											<input type="text" class="form-control"
												value="${userinf.fname }" name="fname" readonly/>
										</div>
									</div>
									<div class="form-group">
										<label for="lastname" class="col-lg-4 control-label">Last
											Name </label>
										<div class="col-lg-8">
											<input type="text" class="form-control"
												value="${userinf.lname }" name="lname" readonly />
										</div>
									</div>
									<div class="form-group">
										<label for="email" class="col-lg-4 control-label">Email

										</label>
										<div class="col-lg-8">
											<input type="text" class="form-control"
												value="${userinf.email }" name="email" readonly/>
										</div>
									</div>
									<div class="form-group">
										<label for="pass" class="col-lg-4 control-label">Password
										</label>
										<div class="col-lg-8">
											<input type="text" class="form-control"
												value="${userinf.pass }" name="pass" readonly/>
										</div>
									</div>
									<div class="form-group">
										<label for="address" class="col-lg-4 control-label">Address
										</label>
										<div class="col-lg-8">
											<input type="text" class="form-control"
												value="${userinf.adrs }" name="adrs" readonly/>
										</div>
									</div>
									<div class="form-group">
										<label for="admin" class="col-lg-4 control-label">IsAdmin
										</label>
										<div class="col-lg-8">
											<input type="text" class="form-control"
												value="${userinf.isAdmin }" name="isadmin" readonly/>
										</div>
									</div>
									<div class="form-group">
										<label for="seller" class="col-lg-4 control-label">IsSeller
										</label>
										<div class="col-lg-8">
											<input type="text" class="form-control"
												value="${userinf.isSell }" name="isseller" />
										</div>
									</div>
									<button type="submit" class="btn btn-default">Edit</button>
									<button type="reset" class="btn btn-primary">Reset</button>
								</form>


							</div>
						</div>
					</div>
				</div>
				<!-- End Form Elements -->
			</div>
		</div>
		<!-- /. ROW  -->
		<div class="row">
			<div class="col-md-12"></div>
		</div>
		<!-- /. ROW  -->
	</div>
	<!-- /. PAGE INNER  -->
</div>
<!-- /. PAGE WRAPPER  -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
	$('input:radio[name="postage"]').change(function() {
		if ($(this).is(':checked') && $(this).val() == 'Yes') {
			$("#anh").removeAttr("hidden")
			$("#inputicon").attr("type", "text")
			$("#inputicon").attr("name", "imagelink")
		}
		if ($(this).is(':checked') && $(this).val() == 'No') {
			$("#anh").removeAttr("hidden")

			$("#inputicon").attr("type", "file")
			$("#inputicon").attr("name", "icons")
		}

	});
</script>