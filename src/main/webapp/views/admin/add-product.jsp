<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- BEGIN CONTENT -->
<div class="page-content-wrapper">
	<div class="page-content">
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
				<c:url value="/admin/product/add" var="add">
				</c:url>
				<form role="form" action="${add}" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<label>Tên Sản Phẩm:</label> <input class="form-control"
							placeholder="please enter product Name" name="name" />
					</div>
					<div class="form-group">
						<label>Mô Tả:</label> <input class="form-control"
							placeholder="please enter product description" name="description" />
					</div>
					<div class="form-group">
						<label>Giá:</label> <input class="form-control"
							placeholder="please enter product price" name="price" />
					</div>
					<input type="radio" id="postageyes" name="postage" value="Yes" />
					Chèn link ảnh <input type="radio" id="postageno" name="postage"
						value="No" /> Tải ảnh <br />

					<div class="form-group" id="anh" hidden="hidden">
						<label>Ảnh đại diện</label> <input id="inputicon" type="file"
							name="icons" />
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
						<label>Số Lượng:</label> <input class="form-control"
							placeholder="please enter product amount" name="amount" />
					</div>
					<br />
					<button type="submit" class="btn btn-primary">Thêm</button>
					<button type="reset" class="btn btn-default">Hủy</button>
				</form>
			</div>
		</div>

		<!-- END PAGE CONTENT -->
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