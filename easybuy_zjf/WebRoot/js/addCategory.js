function fenleichoose(choose) {
	var $choose = $(choose).val();
	if ($choose == 1) {
		$("#categoryone").parent().parent().hide();
		$("#categorytwo").parent().parent().hide();
	} else if ($choose == 2) {
		$("#categoryone").parent().parent().show();
		$("#categorytwo").parent().parent().hide();
	} else {
		$("#categoryone").parent().parent().show();
		$("#categorytwo").parent().parent().show();
	}
}

function onefenleichoose(choose) {
	var $choose = $(choose).val();
	$("#categorytwo").html("");
	$.post("categoryServlet?opr=gettwolist", "parentId=" + $choose, function(
			data) {
		$("#categorytwo").append("<option selected=\"selected\">请选择</option>");
		$(data).each(
				function() {
					$("#categorytwo").append(
							"<option value=\"" + this.id + "\">" + this.name
									+ "</option>");
				});
	}, "json");
}