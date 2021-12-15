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
					<li class="start active "><a href="admin"> <i
							class="icon-home"></i> <span class="title">Dashboard</span> <span
							class="selected"></span>
					</a></li>
					<li><a href="/KDA/seller/category/list"> <i class="icon-basket"></i> <span
							class="title">Danh Sách Danh Mục</span> <span class="arrow "></span>
					</a>
					<li><a href="javascript:;"> <i class="icon-rocket"></i> <span
							class="title">Quản Lý Sản Phẩm</span> <span class="arrow "></span>
					</a>
						<ul class="sub-menu">
							<li><a href="/KDA/seller/product/add"> <i
									class="icon-basket"></i> Thêm Sản Phẩm
							</a></li>							
							<li><a href="/KDA/seller/product/my-product?1"> <i
									class="icon-basket"></i> Sản Phẩm Của Tôi
							</a></li>
						</ul></li>
					<li><a href="/KDA/profile/edit?uid=${sessionScope.acc.uid }"> <i class="icon-diamond"></i> <span
							class="title">Thông Tin Tài Khoản</span> <span class="arrow "></span>
					</a>
					</li>
					<%-- <li class="last "><a href="ecommerce_orders.html"> <i
							class="icon-pointer"></i> <span class="title">Quản Lý Đơn
								Hàng</span> <span class="arrow "></span>
					</a></li>--%>
				</ul>
				<!-- END SIDEBAR MENU -->
			</div>
		</div>