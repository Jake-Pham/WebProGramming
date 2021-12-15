<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<!-- /. NAV SIDE  -->
<div class="page-content-wrapper">
	<div class="page-content">
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
				<h2>Chỉnh sửa danh mục</h2>
				<h5>Nơi bạn có thể chỉnh sửa thông tin danh mục</h5>
			</div>
		</div>
		<!-- /. ROW  -->
		<hr />
		<div class="row">
			<div class="col-md-12">
				<!-- Form Elements -->
				<div class="panel panel-default">
					<div class="panel-heading">Chỉnh sửa danh mục</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<h3>Danh mục:</h3>
								<c:url value="/admin/product/edit" var="edit"></c:url>
								<form role="form" action="${edit}" method="post"
									enctype="multipart/form-data">
									<input name="id" value="${product.id }" hidden="">
									<div class="form-group">
										<label>Tên sản phẩm:</label> <input type="text"
											class="form-control" value="${product.name }" name="name" />
									</div>
									<div class="form-group">
										<label>Mô tả:</label> <input type="text" class="form-control"
											value="${product.description }" name="description" />
									</div>
									<div class="form-group">
										<label>Giá:</label> <input type="text" class="form-control"
											value="${product.price }" name="price" />
									</div>

									<input type="radio" id="postageyes" name="postage" value="Yes" />
									Chèn link ảnh <br /> <input type="radio" id="postageno"
										name="postage" value="No" /> Tải ảnh <br />

									<c:set var="string1" value="${product.image}" />
									<c:choose>
										<c:when test="${string2 =='cate'}">
											<c:url value="/image?fname=${product.image}" var="imgUrl"></c:url>
										</c:when>
										<c:otherwise>
											<c:url value="${product.image}" var="imgUrl"></c:url>
										</c:otherwise>
									</c:choose>

									<img src=${product.image } class="img-responsive" width="100px"
										alt=""> <br />
									<div class="form-group" id="anh" hidden="hidden">
										<label>Ảnh đại diện</label> <input id="inputicon" type="file"
											name="icon" value="${product.image }" />
									</div>
									<div class="form-group">
										<label>Danh Mục: </label> <select name="cateid"
											class="form-select">
											<c:forEach items="${cateList }" var="o">
												<option value="${o.cate_id }">${o.cname }</option>
											</c:forEach>
										</select>
									</div>
									<input name="sid" value="${sessionScope.acc.uid}" hidden="" />
									<div class="form-group">
										<label>Số lượng:</label> <input type="text"
											class="form-control" value="${product.amount }" name="amount" />
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