<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <%@ include file="/common/pre/header.jsp" %>
    <title>全球e购</title>
</head>
<body>
<!--Begin Header Begin-->
<%@ include file="/common/pre/searchBar.jsp" %>
<!--End Header End-->
<!--Begin Menu Begin-->
<div class="menu_bg">
    <div class="menu">
        <!--Begin 商品分类详情 Begin-->
        <div class="nav">
            <div class="nav_t">主题市场</div>
            <div class="leftNav">
                <ul>
                    <c:forEach items="${productCategoryVoList}" var="temp" >
                        <li>
                            <div class="fj">
                        <span class="n_img">
                            <img src="${ctx}/statics/images/${temp.productCategory.iconClass}"/></span>
                                <span class="fl">${temp.productCategory.name}</span>
                            </div>
                            <div class="zj">
                                <div class="zj_l">
                                    <c:forEach items="${temp.productCategoryVoList}" var="vo">
                                        <div class="zj_l_c">
                                            <h2>
                                             
                                                <a href="${ctx}/Product?action=queryProductList&category=${vo.productCategory.id}&level=2">${vo.productCategory.name}</a>
                                                
                                            </h2>
                                           
                                            <c:forEach items="${vo.productCategoryVoList}" var="vo2">
                                                <a href="${ctx}/Product?action=queryProductList&category=${vo2.productCategory.id}&level=3">${vo2.productCategory.name}</a> |
                                            </c:forEach>
                                            
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <ul class="menu_r">
            <c:forEach items="${productCategoryVoList}" var="temp">
                <li><a href="${ctx}/Product?action=queryProductList&level=1&category=${temp.productCategory.id}">${temp.productCategory.name}</a></li>
            </c:forEach>
        </ul>
        
        <!--End 商品分类详情 End-->
    </div>
</div>
<!--End Menu End-->
<div class="i_bg bg_color">
    <div class="i_ban_bg">
        <!--Begin Banner Begin-->
        <div class="banner">
            <div class="top_slide_wrap">
                <ul class="slide_box bxslider">
                    <li><img src="${ctx}/statics/images/ban1.jpg" width="740" height="401"/></li>
                    <li><img src="${ctx}/statics/images/ban2.jpg" width="740" height="401"/></li>
                    <li><img src="${ctx}/statics/images/ban3.jpg" width="740" height="401"/></li>
                </ul>
                <div class="op_btns clearfix">
                    <a href="#" class="op_btn op_prev"><span></span></a>
                    <a href="#" class="op_btn op_next"><span></span></a>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            var jq2 = jQuery.noConflict();
            (function () {
                $(".bxslider").bxSlider({
                    auto: true,
                    prevSelector: jq2(".top_slide_wrap .op_prev")[0], nextSelector: jq2(".top_slide_wrap .op_next")[0]
                });
            })();
        </script>
        <!--End Banner End-->
        <div class="inews">
            <div class="news_t">
                <span class="fr"><a href="${ctx}/admin/news?action=queryNewsList">更多 ></a></span>科技新闻
            </div>
            <ul>
                <c:forEach items="${news}" var="temp">
                    <li><span>[ 号外 ]</span>
                        <a href="${ctx}/admin/news?action=newsDeatil&id=${temp.id}">${temp.title}</a>
                    </li>
                </c:forEach>
            </ul>
            
            
        </div>
    </div>

    <!--Begin 进口 生鲜 Begin-->
    <c:forEach items="${productCategoryVoList}" var="temp" end="${fn:length(productCategoryVoList)}" varStatus="status">
        <div class="i_t mar_10">
            
            <span class="fl">${temp.productCategory.name}</span>
        </div>
        <div class="content">
            <div class="fresh_left"><br>
                <center><font size="4" color="#fff"  >热门搜索</font><hr/></center>
                <div class="fresh_txt">	
                    <div class="fresh_txt_c">
                        <c:forEach items="${temp.productCategoryVoList}" var="vo" varStatus="count">
                            <a href="${ctx}/Product?action=queryProductList&category=${vo.productCategory.id}&level=2"><font size="3" color="#fff">${vo.productCategory.name}</font></a></br>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="fresh_mid">
                <ul>
                    <c:forEach items="${temp.productList}" var="productVo">
                        <li>
                            <div class="name"><a href="#">${productVo.name}</a></div>
                            <div class="price">
                                <font>￥<span>${productVo.price}</span></font> &nbsp;
                            </div>
                            <div class="img">
                                <a href="${ctx}/Product?action=queryProductDeatil&id=${productVo.id}">
                                    <img src="${ctx}/files/${productVo.fileName}" width="185"  height="155"/>
                                </a>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="fresh_right">
               <div class="fre_ban">
                    <div id="imgPlay1">
                        <ul class="imgs" id="actor1">
                            <li><a href="#"><img src="${ctx}/statics/images/fre_r1.jpg" width="260" height="440"/></a></li>
                            <li><a href="#"><img src="${ctx}/statics/images/fre_r2.jpg" width="260" height="440"/></a></li>
                            <li><a href="#"><img src="${ctx}/statics/images/fre_r3.jpg" width="260" height="440"/></a></li>
                        </ul>
                        <div class="prevf">上一张</div>
                        <div class="nextf">下一张</div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
    <%@ include file="/common/pre/footer.jsp" %>
</div>
</body>
</html>
