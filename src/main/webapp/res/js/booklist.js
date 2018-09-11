$(".remove-btn").click(function() {
	var parent = $(this).parents("tr");
	var id = parent.attr("data-id");
	var name = parent.find("td").eq(0).html();
	$.ajax({
		url : "delete_book_list_item",
		cache : false,
		method : 'post',
		type : "json",
		data : {
			id : id
		},
		async : false,
		success : function(result) {
			if (result.status == 'ok') {
				parent.remove();
			} else {
				alert("移除失败");
			}
		}
	});

});