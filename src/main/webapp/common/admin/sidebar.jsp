<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- BEGIN CONTAINER -->
<div class="container">
	<div class="page-container">
		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar-wrapper">
			<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
			<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
			<div class="page-sidebar navbar-collapse collapse">
				<!-- BEGIN SIDEBAR MENU -->
				<!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
				<!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
				<!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
				<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
				<!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
				<!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
				<ul class="page-sidebar-menu page-sidebar-menu-hover-submenu "
					data-keep-expanded="false" data-auto-scroll="true"
					data-slide-speed="200">
					<li class="start active "><a href="/KDA/admin/home"> <i
							class="icon-home"></i> <span class="title">Dashboard</span> <span
							class="selected"></span>
					</a></li>
					<li><a href="javascript:;"> <i class="fa fa-sitemap"></i> <span
							class="title">Quản Lý Danh Mục</span> <span class="arrow "></span>
					</a>
						<ul class="sub-menu">
							<li><a href="/KDA/admin/category/add"> <i
									class="fa fa-plus"></i> Thêm Danh Mục
							</a></li>
							<li><a href="/KDA/admin/category/list"> <i
									class="fa fa-file-o"></i> Danh Sách Danh Mục
							</a></li>
						</ul></li>
					<li><a href="javascript:;"> <i class="fa fa-barcode"></i> <span
							class="title">Quản Lý Sản Phẩm</span> <span class="arrow "></span>
					</a>
						<ul class="sub-menu">
							<li><a href="/KDA/admin/product/add"> <i class="fa fa-plus"></i>
									Thêm Sản Phẩm
							</a></li>
							<li><a href="/KDA/admin/product/list"> <i
									class="fa fa-file-o"></i> Danh Sách Sản Phẩm
							</a></li>
							<li>
							<a href="/KDA/admin/product/my-product?${sessionScope.acc.uid }"> <i
									class="fa fa-file-o"></i> My Product
							</a></li>
						</ul></li>
					<li><a href="javascript:;"> <i class="fa fa-group"></i> <span
							class="title">Quản Lý Tải Khoản</span> <span class="arrow "></span>
					</a>
						<ul class="sub-menu">
							<li><a href="/KDA/admin/user/list"> <i
									class=""></i> Danh Sách Tài Khoản
							</a></li>
						</ul></li>
				</ul>
				<!-- END SIDEBAR MENU -->
			</div>
		</div>