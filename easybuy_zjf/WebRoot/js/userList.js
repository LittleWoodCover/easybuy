getPage("1");
function getPage(pageindex) {
	$.post(ctx+"/userServlet?opr=loadfenye","currPageNo="+pageindex,function(data){
		// 加载页面
		var $show=$("#m_right");
		var $showarea=$("#m_m>table");
		$showarea.html("");
		$show.html("");
		if(data.newslist==null){
			$showarea.html("<h3>闁规儼椴搁悺鎴︽晬鐏炲墽姊鹃柡鍫濐槹婢规﹢宕氶幍顔界ゲ闁稿繗娅曢弻濠囨⒒娴兼瑧纾�/h3>");		
		}else{
			var $newslist=$(data.newslist);
			$showarea.append("<tr><td width=\"200\" >"+"用户名称"+"</td><td width=\"200\">"+"真实姓名"+"</td><td width=\"100\">"+"性别"+"</td><td width=\"100\">"+"类型"+"</td><td width=\"200\" colspan=\"2\">"+"操作"+"</td></tr>"
			);			
			$newslist.each(function() {	
				var Sex=null;
				var Type=null;
				if(this.sex==1){
					Sex="男";
				}else{
					Sex="女";
				}
				if(this.type==1){
					Type="管理员";
				}else{
					Type="用户";
				}
				$showarea.append("<tr><td>" +this.loginName
						+"</td><td>" +this.userName
						+"</td><td>" +Sex
						+"</td><td>" +Type
						+"</td><td><a href=\"uerUpdate.jsp?loginName="+this.loginName
								+"&userName="+this.userName
								+"&identityCode="+this.identityCode
								+"&email="+this.email
								+"&mobile="+this.mobile
								+"&type="+this.type
								+"&id="+this.id
								+"\">修改</a></td><td><a href=\"../userServlet?opr=delete" +"&id="+this.id+
										"\">删除</a></tr>"
								
				);	
				     						
			});				
		}
		
		//设置连接
		var $showpage=$("<p align=\"right\">当前页数:["+data.currPageNo
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