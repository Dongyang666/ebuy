<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
 <head>
  <meta charset="utf-8">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>全球e购客服</title>
    <%@ include file="/common/pre/header.jsp" %>
    <%@ include file="/common/pre/searchBar.jsp" %>
    
  <style type="text/css">
          *{margin: 0;padding:0;}
		  
		  body{background:url("images/bg.jpg"); background-size:cover;}
          .chat{width: 800px; height:560px ;  margin:90px auto; font-size:15px;   }
          .chat .c-top{height:60px;background: #666;font-size:20px;color:#fff;line-height:90px;padding-left:10px;    -moz-border-radius: 0px 0px 20px 25px;    
    -webkit-border-radius: 10px 10px 0px 0px; 
    border-radius:15px 15px 0px 0px;}
          .chat .c-con{ height:400px;background:#ececec; overflow:auto;}
          .chat .c-message{height:80px; background:#d4d4d4;-moz-border-radius: 0px 0px 20px 25px;     
    -webkit-border-radius: 0px 0px 20px 25px;
    border-radius:0px 0px 15px 15px;}
		  .chat .c-con .c-left img {vertical-align: middle;border-radius:25px;}
		  .chat .c-con .c-left {padding:12px; }		
		  .chat .c-con .c-right { padding:12px;text-align:right;}
		  .chat .c-con .c-right img { vertical-align: middle;border-radius:25px;}
          .chat .c-message
		  .c-box{ height:60px;width:629px;background:#e8e8e8;padding:10px; font-size:20px;outline:none;float:left;overflow:auto;    -moz-border-radius: 0px 0px 20px 25px;     
    -webkit-border-radius: 0px 0px 20px 25px;
    border-radius:0px 0px 0px 15px;}
		  .c-send{width:151px;height:80px;float:right;font-size:15px;outline:none;border:none;cursor:pointer; -moz-border-radius: 0px 0px 20px 25px;     
    -webkit-border-radius: 0px 0px 20px 25px;
    border-radius:0px 0px 15px 0px;}
		  .chat .c-message .c-send:hover{background:#317ef3;}
			
		  ::-webkit-scrollbar{width:5px;height:6px;background:#ccc;}
          ::-webkit-scrollbar-button{background-color:#e5e5e5;}
		  ::-webkit-scrollbar-track{background:#999;}
		  :-:webkit-scrollbar-track-piece{background:#ccc;}
		  ::-webkit-scrollbar-thumb{background:#666;}
		  ::-webkit-scrollbar-corner{background:#82AFF;}
		  ::-webkit-scrollbar-resizer{background:#f0be;}
		  scorllbar{-moz-appearance:none  !important;background:rgb(0,255,0)  !important;}
		  scorllbarbutton{-moz-appearance:none  !important;background-color:rgb(0,0,255)  !important;}
          scorllbarbutton:hover{-moz-appearance:none  !important;background-color:rgb(255,0,0)  !important;}
  </style> 
 </head>
 <body>
  <div class="chat">
     <div class="c-top"><font>全球e购网客服</font></div>
     <hr/>
	 <div class="c-con" id="c-con"></div>
	 <div class="c-message">
	 <div class="c-box" contenteditable="true"></div>
	 <div class="c-btn"><input type="button" value="发送" class="c-send" id="c-send"/></div>
	 </div>
  </div>
  
  <script type="text/javascript" src="statics/js/jquery-1.10.2.min.js"></script>
  <script type="text/javascript">
  jQuery(function(){ 
	  
			  $(".c-send").click(function(){
			    	var value=$(".c-box").text();
			    	$(".c-con").append("<div class='c-right'> "+value+" <img src='statics/logo.png' alt='头像' width='50px'  heigth='50px'></div>");
			    	$(".c-box").html("");
			    	
			    	$.ajax({
			    		type:"post",//请求类型
			    		url:"data.jsp",
			    		data:{info:value},
			    		success:function(data)
			    		{
			    			var json=JSON.parse(data);
			    			$(".c-con").append("<div class='c-left'><img src='statics/0.png' alt='客服头像' width='50px' heigth='50px'><span> "+json.text+"<span></div>");
			    			
			    		}
			    	});
			   });
			   
	 });
  </script>
  <%@ include file="/common/pre/footer.jsp" %>
 </body>
</html>