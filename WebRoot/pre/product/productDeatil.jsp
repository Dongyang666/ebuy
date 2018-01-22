<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <%@ include file="/common/pre/header.jsp" %>
    <script type="text/javascript" src="${ctx}/statics/js/common/n_nav.js"></script>
    <script src="${ctx}/statics/js/cart/cart.js"></script>
    <title>全球e购</title>
    <script type="text/javascript">
    function check_red(){
  		 	 document.getElementById("red").setAttribute("class", "checked");
  		 	document.getElementById("white").setAttribute("class", "unchecked");
  		 	document.getElementById("black").setAttribute("class", "unchecked");
  		 	

    }

    function check_white(){
		 	 document.getElementById("white").setAttribute("class", "checked");
		 	document.getElementById("red").setAttribute("class", "unchecked");
	  		 	document.getElementById("black").setAttribute("class", "unchecked");
		 	

}

    function check_black(){
		 	 document.getElementById("black").setAttribute("class", "checked");
		 	document.getElementById("white").setAttribute("class", "unchecked");
  		 	document.getElementById("red").setAttribute("class", "unchecked");
		 	

}

    </script>
</head>
<body>
<!--Begin Header Begin-->
<div id="searchBar">
    <%@ include file="/common/pre/searchBar.jsp" %>
</div>
<!--Begin Header Begin-->
<!--End Header End-->
<!--Begin Menu Begin-->
<div class="menu_bg">
    <div class="menu">
        <!--Begin 商品分类详情 Begin-->
        <%@ include file="/common/pre/categoryBar.jsp" %>
        <!--End 商品分类详情 End-->
    </div>
</div>
<!--End Menu End-->
<div class="i_bg">
    <div class="postion">
    </div>
    <div class="content">
        <div id="tsShopContainer">
            <div id="tsImgS">
                <a href="${ctx}/files/${product.fileName}" title="Images" class="MagicZoom" id="MagicZoom">
                    <img src="${ctx}/files/${product.fileName}" width="390" height="390"/>
                </a>
            </div>
        </div>
        <div class="pro_des">
            <div class="des_name">
                <input type="hidden" value="${product.id}"  name="entityId" class="n_ipt"/>
                <p>${product.name}</p>
              	  e购自营！假一赔十！！！！！！
            </div>
            <div class="des_price">
                本店价格：<b>￥${product.price}</b><br/>
            </div>
           <div class="des_price">
                库存：<b>${product.stock}</b><br/>
            </div>
           
            <div class="des_choice">
                <span class="fl">类型选择：</span>
                <ul>
                    <li  id="red" onclick="check_red()" >线上
                        <div class="ch_img"></div>
                    </li>
                    <li id="white" onclick="check_white()" >线下
                        <div class="ch_img"></div>
                    </li>
                    <li id="black" onclick="check_black()" >到店
                        <div class="ch_img"></div>
                    </li>
                </ul>
            </div>
            <br>
            <br>
            <div class="des_join">
                <div class="j_nums">
                    <input type="text"   value="1"  name="quantity" class="n_ipt"/>
                    <input type="button" value="" onclick="addUpdate(jq(this));" class="n_btn_1"/>
                    <input type="button" value="" onclick="jianUpdate(jq(this));" class="n_btn_2"/>
                    <input type="hidden" name="productStock" value="${product.stock}">
                </div>
                <span class="fl">
                     <img src="${ctx}/statics/images/j_car.png" onclick="addCart();"/>
                </span>
            </div>
        </div>
    </div>
    <div class="content mar_20">
        <div id="favoriteList">
        </div>
        <div class="l_list">
            <div class="des_border">
                <div class="des_tit">
                    <ul>
                        <li class="current"><a href="#p_attribute">商品属性</a></li>
                        <li><a href="#p_details">商品详情</a></li>
                    </ul>
                </div>
                <div class="des_con" id="p_attribute">
                    <table border="0" align="center" style="width:100%; font-family:'宋体'; margin:10px auto;"
                           cellspacing="0" cellpadding="0">
                        <tr>
                            <td>商品名称：${product.name}</td>
                            <td>商品价格：${product.price}</td>
                            <td>品牌：${product.name}</td>
                            <td>上架时间：2015-09-06 09:19:09 </td>
                        </tr>
                        
                    </table>
                </div>
            </div>
            <div class="des_border" id="p_details">
                <div class="des_t">商品详情</div>
                <div class="des_con">
                    <table border="0" align="center" style="width:745px; font-size:14px; font-family:'宋体';" cellspacing="0" cellpadding="0">
                        <tr>
                            <td>
                                ${product.description}
                            </td>
                        </tr>
                    </table>
                    <p align="center">
                        <img src="${ctx}/files/${product.fileName}" width="185" height="155">
                    </p>
                </div>
            </div>
        </div>
    </div>
    <script>
        favoriteList();
    </script>
    <!--End 弹出层-收藏成功 End-->
    <%@ include file="/common/pre/footer.jsp" %>
    <!--Begin 弹出层-加入购物车 Begin-->
</div>
</body>
</html>
