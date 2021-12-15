<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="main">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href="index.html">Home</a></li>
			<li class="active">Create new account</li>
		</ul>
		<!-- BEGIN SIDEBAR & CONTENT -->
		<div class="row margin-bottom-40">
			<!-- BEGIN SIDEBAR -->
			<div class="sidebar col-md-3 col-sm-3">
				
			</div>
			<!-- END SIDEBAR -->

			<!-- BEGIN CONTENT -->
			<div class="col-md-9 col-sm-9">
				<h1>Create an account</h1>
				<div class="content-form-page">
					<div class="row">
						<div class="col-md-7 col-sm-7">
							<form class="form-horizontal" role="form" action="register" method="post" enctype="multipart/form-data">
								<fieldset>
									<legend>Your personal details</legend>
									<div class="form-group">
										<label for="firstname" class="col-lg-4 control-label">First
											Name <span class="require">*</span>
										</label>
										<div class="col-lg-8">
											<input name="fname" value="${fname}" type="text" class="form-control" id="firstname">
										</div>
									</div>
									<div class="form-group">
										<label for="lastname" class="col-lg-4 control-label">Last
											Name <span class="require">*</span>
										</label>
										<div class="col-lg-8">
											<input name="lname" value="${lname}" type="text" class="form-control" id="lastname">
										</div>
									</div>
									<div class="form-group">
										<label for="email" class="col-lg-4 control-label">Email
											<span class="require">*</span>
										</label>
										<div class="col-lg-8">
											<input name="email" value="${email}" type="text" class="form-control" id="email">
										</div>
									</div>
									<div class="form-group">
										<label for="address" class="col-lg-4 control-label">Address
											<span class="require">*</span>
										</label>
										<div class="col-lg-8">
											<input name="adrs" value="${adrs}" type="text" class="form-control" id="address">
										</div>
									</div>
								</fieldset>
								<fieldset>
									<legend>Your password</legend>
									<div class="form-group">
										<label for="password" class="col-lg-4 control-label">Password
											<span class="require">*</span>
										</label>
										<div class="col-lg-8">
											<input name="pass" value="${pass}" type="password" class="form-control" id="password">
										</div>
									</div>
									<div class="form-group">
										<label for="confirm-password" class="col-lg-4 control-label">Confirm
											password <span class="require">*</span>
										</label>
										<div class="col-lg-8">
											<input type="password" class="form-control" id="confirm-password">
										</div>
									</div>
								</fieldset>
								
								<div class="row">
									<div
										class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
										<button type="submit" class="btn btn-primary">Create
											an account</button>
										<button type="button" class="btn btn-default">Cancel</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- END CONTENT -->
		</div>
		<!-- END SIDEBAR & CONTENT -->
	</div>
</div>