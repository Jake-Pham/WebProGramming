<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="main">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href="index.html">Home</a></li>
			<li><a href="#">Pages</a></li>
			<li class="active">Edit Profile</li>
		</ul>
		<!-- BEGIN SIDEBAR & CONTENT -->
		<div class="row margin-bottom-40">
			<!-- BEGIN SIDEBAR -->
			<div class="sidebar col-md-3 col-sm-3"></div>
			<!-- END SIDEBAR -->

			<!-- BEGIN CONTENT -->
			<div class="col-md-9 col-sm-9">
				<h1>Your Profile</h1>
				<div class="content-form-page">
					<div class="row">
						<div class="col-md-7 col-sm-7">
							<form class="form-horizontal" role="form" action="${edit }"
								method="post" enctype="multipart/form-data">
								<fieldset>
									<legend>Your personal details</legend>
									<input name="id" value="${userinf.uid }" hidden="">
									<div class="form-group">
										<label for="firstname" class="col-lg-4 control-label">First
											Name </label>
										<div class="col-lg-8">
											<input type="text" class="form-control"
												value="${userinf.fname }" name="fname" />
										</div>
									</div>
									<div class="form-group">
										<label for="lastname" class="col-lg-4 control-label">Last
											Name </label>
										<div class="col-lg-8">
											<input type="text" class="form-control"
												value="${userinf.lname }" name="lname" />
										</div>
									</div>
									<div class="form-group">
										<label for="email" class="col-lg-4 control-label">Email

										</label>
										<div class="col-lg-8">
											<input type="text" class="form-control"
												value="${userinf.email }" name="email" readonly />
										</div>
									</div>
									<div class="form-group">
										<label for="pass" class="col-lg-4 control-label">Password
										</label>
										<div class="col-lg-8">
											<input type="password" class="form-control"
												value="${userinf.pass }" name="pass" />
										</div>
									</div>
									<div class="form-group">
										<label for="address" class="col-lg-4 control-label">Address
										</label>
										<div class="col-lg-8">
											<input type="text" class="form-control"
												value="${userinf.adrs }" name="adrs" />
										</div>
									</div>
									<input hidden="" value="${sessionScope.acc.isAdmin }"
										name="isadmin" /> <input hidden=""
										value="${sessionScope.acc.isSell }" name="isseller" />
								</fieldset>

								<div class="row">
									<div
										class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
										<button type="submit" class="btn btn-primary">Edit</button>
										<a href="/KDA/home">
											<button type="button" class="btn btn-default">Cancel</button>
										</a>
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