getPage("1");
function getPage(pageindex) {
	$.post(ctx+"/productServlet?opr=loadfenye","currPageNo="+pageindex,function(data){
		// 加载页面
		var $show=$("#m_right");
		var $showarea=$("#m_m>table");
		$showarea.html("");
		$show.html("");
		if(data.newslist==null){
			$showarea.html("<h3>闂佽鍎兼ご鎼佹偤閹达附鏅悘鐐插⒔濮婇箖鏌￠崼婵愭Ч濠㈣锕㈠畷姘跺箥椤旂晫銈查梺绋跨箺濞呮洟寮绘繝鍥ㄢ拻濞村吋鐟х壕锟�h3>");		
		}else{
			var $newslist=$(data.newslist);
			$showarea.append("<tr><td width=\"200\" >"+"商品名称"+"</td><td width=\"200\">"+"商品图片"+"</td><td width=\"100\">"+"库存"+"</td><td width=\"100\">"+"价格"+"</td><td width=\"200\" colspan=\"2\">"+"操作"+"</td></tr>"
			);			
			$newslist.each(function() {	
			
				$showarea.append("<tr><td>" +this.name
						+"</td><td>" +this.fileName
						+"</td><td>" +this.stock
						+"</td><td>" +this.price
						+"</td><td><a href=\"productUpdate.jsp?loginNanameme="+this.name
								+"&categoryLevel1Id="+this.categoryLevel1Id
								+"&categoryLevel2Id="+this.categoryLevel2Id
								+"&categoryLevel3Id="+this.categoryLevel3Id
								+"&stock="+this.stock
								+"&price="+this.price
								+"&id="+this.id
								+"\">修改</a></td><td><a href=\"../productServlet?opr=delete" +"&id="+this.id+
										"\">删除</a></tr>"
								
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