var pageNumber = 1;

$(document).ready(function() {
	loadData();
	$("#loading").fadeOut();
});

$("#more").click(function() {
	loadData();
});

function loadData() {
	$.ajax({
		url : "search_library_list",
		cache : false,
		method : 'post',
		type : "json",
		data : {
			word : word,
			page : pageNumber
		},
		async : false,
		success : function(result) {
			if (result.status == 'ok') {
				if (result.data.hasNext) {
					pageNumber += 1;
					$("#more").css("display", "block");
				} else {
					$("#more").css("display", "none");
				}
				html = "";
				$.each(result.data.data, function(index, item) {
					html += "<div class=\"col-md-12 detail\"> <a href=\""
							+ item.url + "\" class=\"title\"><p>"
							+ item.bookName
							+ "</p><span class=\"enter\">&gt;</span></a></div>"
				});
				$("#result").append(html);
			} else {
				alert(result.msg);
			}
		}
	});
}