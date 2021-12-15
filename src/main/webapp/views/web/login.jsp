<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="main">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href="home">Home</a></li>
			<li class="active">Login</li>
		</ul>
		<!-- BEGIN SIDEBAR & CONTENT -->
		<div class="row margin-bottom-40">
			<!-- BEGIN SIDEBAR -->
			<div class="sidebar col-md-3 col-sm-3"></div>
			<!-- END SIDEBAR -->

			<!-- BEGIN CONTENT -->
			<div class="col-md-9 col-sm-9">
				<h1>Login</h1>
				<div class="content-form-page">
					<div class="row">
						<div class="col-md-7 col-sm-7">
							<form class="form-horizontal form-without-legend" role="form" action="login" method="post">
								<div class="form-group">
									<p class="text-danger">${mess}</p>
									<label for="email" class="col-lg-4 control-label">Email
										<span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input name="email" value="${email}" type="text"
											class="form-control" id="email">
									</div>
								</div>
								<div class="form-group">
									<label for="password" class="col-lg-4 control-label">Password
										<span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input name="pass" value="${password}" type="password"
											class="form-control" id="password">
									</div>
								</div>
								<div class="row">
									<div class="col-lg-8 col-md-offset-4 padding-left-0">
										<a href="/KDA/register">Đăng kí</a>
									</div>
								</div>
								<div class="row">
									<div
										class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
										<button type="submit" class="btn btn-primary">Login</button>
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