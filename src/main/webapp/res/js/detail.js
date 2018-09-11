$("#addToBookList").click(function() {
	var name = $("#bookName").html();
	var code = $("#code").html();
	$.ajax({
		url : "add_to_book_list_item",
		cache : false,
		method : 'post',
		type : "json",
		data : {
			code : code,
			name : name,
			spmSource:spmSource,
			isBack:isBack
		},
		async : false,
		success : function(result) {
			if (result.status == 'ok') {
				$("#addToBookList").html("已经添加到我的书单");
				$("#addToBookList").addClass("disabled");
			} else {
				alert(result.msg);
			}
		}
	});
});