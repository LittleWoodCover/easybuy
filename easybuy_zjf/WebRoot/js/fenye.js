
getPage("1");
function getPage(pageindex) {
	$.post(ctx+"/newsServlet?opr=loadfenye","currPageNo="+pageindex,function(data){
		//加载页面内容
		var $show=$("#m_right");
		var $showarea=$("#m_m>table");
		$showarea.html("");
		$show.html("");
		if(data.newslist==null){
			$showarea.html("<h3>鎶辨瓑锛屾病鏈夋壘鍒扮浉鍏虫柊闂伙紒</h3>");		
		}else{
			var $newslist=$(data.newslist);
			$showarea.append("<tr><td width=\"400\" class=\"mm\">"+"文章标题"
					+"</td><td width=\"400\" class=\"mm\">"+"创建时间"
					+"</td></tr>"
			);
			$newslist.each(function() {	
				$showarea.append("<tr><td width=\"400\" class=\"mm\"><a href=\"../newsServlet?opr=content&id="+this.id
						+"\">"+this.title
						+"</a></td><td width=\"400\" class=\"mm\">"+this.createTime
						+"</td></tr>"
				);	
					     							
			});	
			
		}
		//设置连接
		var $showpage=$("<p align=\"right\">当前页面:["+data.currPageNo
			+"/"+data.totalPageCount
			+"]&nbsp;</p>"
		);
		$show.append($showpage);
		if(data.currPageNo>1){
			var $first=$("<a href=\"javascript:void();\">首页</a>").click(function() {
				getPage("1");
			});
			var $prev=$("<a href=\"javascript:void();\">上一页</a>").click(function() {
				getPage((data.currPageNo-1));
			});
			$showpage.append($first).append("&nbsp;").append($prev);
		}
		if(data.currPageNo<data.totalPageCount){
			var $next=$("<a href=\"javascript:void();\">下一页</a>").click(function() {
				getPage((data.currPageNo+1));
			});
			var $last=$("<a href=\"javascript:void();\">末页</a>").click(function() {
				getPage(data.totalPageCount);
			});
			$showpage.append($next).append("&nbsp;").append($last);
		}
		
	},"json");
}



