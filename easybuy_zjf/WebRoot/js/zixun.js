$(function() {
	$.get(ctx+"/newsServlet","opr=list",function(data){
		var $data=$(data);
		var $zixun=$("#zixun");
		$data.each(function() {
			$zixun.append("<li><span>[公告]</span><a href=\"newsServlet?opr=content&id="+this.id
						+"\">"+this.title
					+"</a></li>");
		});		
	},"json");
})