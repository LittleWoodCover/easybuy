getPage("1");
function getPage(pageindex) {
	$.post(ctx+"/categoryServlet?opr=loadfenye","currPageNo="+pageindex,function(data){
		// 加载页面
		var $show=$("#m_right");
		var $showarea=$("#m_m>table");
		$showarea.html("");
		$show.html("");
		if(data.newslist==null){
			$showarea.html("<h3>闂備浇顫夐崕鍏笺仈閹间焦鍋ら柟杈鹃檮閺咁剟鎮橀悙鎻掆挃婵﹪绠栭弻锟犲醇濠垫劖效婵犮垼顫夐敃銏犵暦濮樿泛绠ユい鏃傛櫕閵堟煡姊虹粙璺ㄧ婵炲懏娲熷缁樼節閸ャ劉鎷绘繛鏉戝悑閻熝呭閿燂拷h3>");		
		}else{
			var $newslist=$(data.newslist);
			$showarea.append("<tr><td width=\"50\" >"+"选择"+"</td><td width=\"200\">"+"分类名称"+"</td><td width=\"200\">"+"分类级别"+"</td><td width=\"200\">"+"父类级别"+"</td><td width=\"200\">"+"操作"+"</td></tr>"
			);		
			$newslist.each(function() {	
				var name=null;
				if(this.type==1){
					name="一级分类";
				}else if(this.type==2){
					name="二级分类";
				}else{
					name="三级分类";
				}
				$showarea.append("<tr><td>" +"<input type=\"radio\" name=\"radio\"/>"
						+"</td><td>" +this.name
						+"</td><td>" +name
						+"</td><td>" +this.parentName
						+"</td><td><a href=\"../categoryServlet?opr=delete" +"&id="+this.id+
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