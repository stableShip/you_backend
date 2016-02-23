<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>轻松游戏</title>
<link href="<%=request.getContextPath()%>/jsp/frontend/images/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/jsp/frontend/images/jquery-1.4.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsp/frontend/images/slider.js"></script>
<link type="text/css" href="<%=request.getContextPath()%>/jsp/frontend/images/css.css" rel="stylesheet" media="screen" />
<script type="text/javascript" src="<%=request.getContextPath()%>/jsp/frontend/images/jqueryWriter.js"></script>
<style type="text/css">
.allFont {
	font-family: 微软雅黑;
}
a_link {
	text-decoration: none;
}
</style>
</head>
<body class="allFont">

	<div class="top">
		<div class="top_l">
			<img src="<%=request.getContextPath()%>/jsp/frontend/images/logo.jpg" />
			<!-- <div class="allFont" style="color:#FC0; font-size:24px; "> <b>轻松游戏</b>
  </div>-->
		</div>
		<div class="top_r">
			<div class="nav">
				<ul class="allFont">
					<li><a class="a_link" href="#">首 页</a></li>
					<li><a href="#">商务合作</a></li>

				</ul>
			</div>
		</div>
	</div>

	<div class="clear"></div>
	<div class="Banner">
		<div class="videoList-container" id="pcList">
			<div id="slide-index" align="center">
				<img src="<%=request.getContextPath()%>/jsp/frontend/images/zx.jpg" border="0" />

				<div class="banner" id="banner">
					<div class="banner_img">
						<ul class="banner_imgcon" id="banner_imgcon"
							style="width: 13660px; left: -2732px;">
							<li style="width: 1700px; float: left;"><img
								src="<%=request.getContextPath()%>/jsp/frontend/images/xuanchuantu.jpg" border="0" /></li>
						</ul>
						<a href="javascript:;" class="banbtn_prev" title="上一张">上一张</a> <a
							href="javascript:;" class="banbtn_next" title="下一张">下一张</a>
					</div>

				</div>
			</div>
		</div>
	</div>
	<script>
		$(window).load(function() {
			$(this).IMGtabs();
		});
	</script>
	<div class="clear"></div>


	<div class="main">
		<div class="hotbox">
			<div class="hot_nav">
				<span><a href="#">更多&gt;&gt;</a></span>热门游戏
			</div>
			<div class="hot_m">
				<div class="recd_game_div" align="center">
					<ul class="recd_game_con">
						<li>
							<div class="recd_game_bor">
								<div class="recd_game_hidden">
									<div class="recd_game_info" style="margin-top: 0px;">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/1.jpg" border="0" class="gameimg">
										<div class="recd_game_data">
											<span class="recd_game_system"> <img
												src="<%=request.getContextPath()%>/jsp/frontend/images/android.jpg" border="0" title="" alt="">
											</span>屌丝三国
										</div>
									</div>
									<div class="recd_game_down">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/1.png" border="0"> <a
											href="javascript:;" class="game_a_down" id="2155">扫描下载</a>
									</div>
								</div>
							</div>
						</li>
						<li>
							<div class="recd_game_bor">
								<div class="recd_game_hidden">
									<div class="recd_game_info" style="margin-top: 0px;">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/2.jpg" border="0" class="gameimg">
										<div class="recd_game_data">
											<span class="recd_game_system"> <img
												src="<%=request.getContextPath()%>/jsp/frontend/images/android.jpg" border="0" title="" alt="">
											</span>捕鱼大战
										</div>
									</div>
									<div class="recd_game_down">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/2.png" border="0"> <a
											href="javascript:;" class="game_a_down" id="2135">扫描下载</a>
									</div>
								</div>
							</div>
						</li>
						<li>
							<div class="recd_game_bor">
								<div class="recd_game_hidden">
									<div class="recd_game_info" style="margin-top: 0px;">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/3.jpg" border="0" class="gameimg">
										<div class="recd_game_data">
											<span class="recd_game_system"> <img
												src="<%=request.getContextPath()%>/jsp/frontend/images/android.jpg" border="0" title="" alt="">
											</span>梦幻江湖
										</div>
									</div>
									<div class="recd_game_down">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/3.png" border="0"> <a
											href="javascript:;" class="game_a_down" id="2148">扫描下载</a>
									</div>
								</div>
							</div>
						</li>
						<li>
							<div class="recd_game_bor">
								<div class="recd_game_hidden">
									<div class="recd_game_info" style="margin-top: 0px;">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/4.jpg" border="0" class="gameimg">
										<div class="recd_game_data">
											<span class="recd_game_system"> <img
												src="<%=request.getContextPath()%>/jsp/frontend/images/android.jpg" border="0" title="" alt="">
											</span>笑傲西游
										</div>
									</div>
									<div class="recd_game_down">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/4.png" border="0"> <a
											href="javascript:;" class="game_a_down" id="2154">扫描下载</a>
									</div>
								</div>
							</div>
						</li>
						<li>
							<div class="recd_game_bor">
								<div class="recd_game_hidden">
									<div class="recd_game_info" style="margin-top: 0px;">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/5.jpg" border="0" class="gameimg">
										<div class="recd_game_data">
											<span class="recd_game_system"> <img
												src="<%=request.getContextPath()%>/jsp/frontend/images/android.jpg" border="0" title="" alt="">
											</span>屌丝江湖
										</div>
									</div>
									<div class="recd_game_down">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/5.png" border="0"> <a
											href="javascript:;" class="game_a_down" id="2147">扫描下载</a>
									</div>
								</div>
							</div>
						</li>

						<li>
							<div class="recd_game_bor">
								<div class="recd_game_hidden">
									<div class="recd_game_info" style="margin-top: 0px;">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/6.jpg" border="0" class="gameimg">
										<div class="recd_game_data">
											<span class="recd_game_system"> <img
												src="<%=request.getContextPath()%>/jsp/frontend/images/android.jpg" border="0" title="" alt="">
											</span>狂虐美人鱼
										</div>
									</div>
									<div class="recd_game_down">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/6.png" border="0"> <a
											href="javascript:;" class="game_a_down" id="2148">扫描下载</a>
									</div>
								</div>
							</div>
						</li>

						<li>
							<div class="recd_game_bor">
								<div class="recd_game_hidden">
									<div class="recd_game_info" style="margin-top: 0px;">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/7.jpg" border="0" class="gameimg">
										<div class="recd_game_data">
											<span class="recd_game_system"> <img
												src="<%=request.getContextPath()%>/jsp/frontend/images/android.jpg" border="0" title="" alt="">
											</span>梦幻封神
										</div>
									</div>
									<div class="recd_game_down">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/7.png" border="0"> <a
											href="javascript:;" class="game_a_down" id="2135">扫描下载</a>
									</div>
								</div>
							</div>
						</li>

						<li>
							<div class="recd_game_bor">
								<div class="recd_game_hidden">
									<div class="recd_game_info" style="margin-top: 0px;">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/8.jpg" border="0" class="gameimg">
										<div class="recd_game_data">
											<span class="recd_game_system"> <img
												src="<%=request.getContextPath()%>/jsp/frontend/images/android.jpg" border="0" title="" alt="">
											</span>仙侣情缘
										</div>
									</div>
									<div class="recd_game_down">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/8.png" border="0"> <a
											href="javascript:;" class="game_a_down" id="2135">扫描下载</a>
									</div>
								</div>
							</div>
						</li>

						<li>
							<div class="recd_game_bor">
								<div class="recd_game_hidden">
									<div class="recd_game_info" style="margin-top: 0px;">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/9.jpg" border="0" class="gameimg">
										<div class="recd_game_data">
											<span class="recd_game_system"> <img
												src="<%=request.getContextPath()%>/jsp/frontend/images/android.jpg" border="0" title="" alt="">
											</span>美女捕金花
										</div>
									</div>
									<div class="recd_game_down">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/9.png" border="0"> <a
											href="javascript:;" class="game_a_down" id="2135">扫描下载</a>
									</div>
								</div>
							</div>
						</li>

						<li>
							<div class="recd_game_bor">
								<div class="recd_game_hidden">
									<div class="recd_game_info" style="margin-top: 0px;">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/10.jpg" border="0" class="gameimg">
										<div class="recd_game_data">
											<span class="recd_game_system"> <img
												src="<%=request.getContextPath()%>/jsp/frontend/images/android.jpg" border="0" title="" alt="">
											</span>三国小伙伴
										</div>
									</div>
									<div class="recd_game_down">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/10.png" border="0"> <a
											href="javascript:;" class="game_a_down" id="2135">扫描下载</a>
									</div>
								</div>
							</div>
						</li>


						<li>
							<div class="recd_game_bor">
								<div class="recd_game_hidden">
									<div class="recd_game_info" style="margin-top: 0px;">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/11.jpg" border="0" class="gameimg">
										<div class="recd_game_data">
											<span class="recd_game_system"> <img
												src="<%=request.getContextPath()%>/jsp/frontend/images/android.jpg" border="0" title="" alt="">
											</span>口袋三国
										</div>
									</div>
									<div class="recd_game_down">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/11.png" border="0"> <a
											href="javascript:;" class="game_a_down" id="2148">扫描下载</a>
									</div>
								</div>
							</div>
						</li>

						<li>
							<div class="recd_game_bor">
								<div class="recd_game_hidden">
									<div class="recd_game_info" style="margin-top: 0px;">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/12.jpg" border="0" class="gameimg">
										<div class="recd_game_data">
											<span class="recd_game_system"> <img
												src="<%=request.getContextPath()%>/jsp/frontend/images/android.jpg" border="0" title="" alt="">
											</span>美女江湖
										</div>
									</div>
									<div class="recd_game_down">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/12.png" border="0"> <a
											href="javascript:;" class="game_a_down" id="2148">扫描下载</a>
									</div>
								</div>
							</div>
						</li>

						<li>
							<div class="recd_game_bor">
								<div class="recd_game_hidden">
									<div class="recd_game_info" style="margin-top: 0px;">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/13.jpg" border="0" class="gameimg">
										<div class="recd_game_data">
											<span class="recd_game_system"> <img
												src="<%=request.getContextPath()%>/jsp/frontend/images/android.jpg" border="0" title="" alt="">
											</span>暴走三国
										</div>
									</div>
									<div class="recd_game_down">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/13.png" border="0"> <a
											href="javascript:;" class="game_a_down" id="2148">扫描下载</a>
									</div>
								</div>
							</div>
						</li>

						<li>
							<div class="recd_game_bor">
								<div class="recd_game_hidden">
									<div class="recd_game_info" style="margin-top: 0px;">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/14.jpg" border="0" class="gameimg">
										<div class="recd_game_data">
											<span class="recd_game_system"> <img
												src="<%=request.getContextPath()%>/jsp/frontend/images/android.jpg" border="0" title="" alt="">
											</span>神界西游
										</div>
									</div>
									<div class="recd_game_down">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/14.png" border="0"> <a
											href="javascript:;" class="game_a_down" id="2148">扫描下载</a>
									</div>
								</div>
							</div>
						</li>

						<li>
							<div class="recd_game_bor">
								<div class="recd_game_hidden">
									<div class="recd_game_info" style="margin-top: 0px;">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/15.jpg" border="0" class="gameimg">
										<div class="recd_game_data">
											<span class="recd_game_system"> <img
												src="<%=request.getContextPath()%>/jsp/frontend/images/android.jpg" border="0" title="" alt="">
											</span>钓鱼岛战争
										</div>
									</div>
									<div class="recd_game_down">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/15.png" border="0"> <a
											href="javascript:;" class="game_a_down" id="2148">扫描下载</a>
									</div>
								</div>
							</div>
						</li>

						<li>
							<div class="recd_game_bor">
								<div class="recd_game_hidden">
									<div class="recd_game_info" style="margin-top: 0px;">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/16.jpg" border="0" class="gameimg">
										<div class="recd_game_data">
											<span class="recd_game_system"> <img
												src="<%=request.getContextPath()%>/jsp/frontend/images/android.jpg" border="0" title="" alt="">
											</span>笑傲江湖-东方不败外传
										</div>
									</div>
									<div class="recd_game_down">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/16.png" border="0"> <a
											href="javascript:;" class="game_a_down" id="2148">扫描下载</a>
									</div>
								</div>
							</div>
						</li>

						<li>
							<div class="recd_game_bor">
								<div class="recd_game_hidden">
									<div class="recd_game_info" style="margin-top: 0px;">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/17.jpg" border="0" class="gameimg">
										<div class="recd_game_data">
											<span class="recd_game_system"> <img
												src="./images/android.jpg" border="0" title="" alt="">
											</span>梦幻大白鲨
										</div>
									</div>
									<div class="recd_game_down">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/17.png" border="0"> <a
											href="javascript:;" class="game_a_down" id="2148">扫描下载</a>
									</div>
								</div>
							</div>
						</li>

						<li>
							<div class="recd_game_bor">
								<div class="recd_game_hidden">
									<div class="recd_game_info" style="margin-top: 0px;">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/18.jpg" border="0" class="gameimg">
										<div class="recd_game_data">
											<span class="recd_game_system"> <img
												src="<%=request.getContextPath()%>/jsp/frontend/images/android.jpg" border="0" title="" alt="">
											</span>小宝传奇
										</div>
									</div>
									<div class="recd_game_down">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/18.png" border="0"> <a
											href="javascript:;" class="game_a_down" id="2148">扫描下载</a>
									</div>
								</div>
							</div>
						</li>

						<li>
							<div class="recd_game_bor">
								<div class="recd_game_hidden">
									<div class="recd_game_info" style="margin-top: 0px;">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/19.jpg" border="0" class="gameimg">
										<div class="recd_game_data">
											<span class="recd_game_system"> <img
												src="<%=request.getContextPath()%>/jsp/frontend/images/android.jpg" border="0" title="" alt="">
											</span>卡牌三国
										</div>
									</div>
									<div class="recd_game_down">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/19.png" border="0"> <a
											href="javascript:;" class="game_a_down" id="2148">扫描下载</a>
									</div>
								</div>
							</div>
						</li>

						<li>
							<div class="recd_game_bor">
								<div class="recd_game_hidden">
									<div class="recd_game_info" style="margin-top: 0px;">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/20.jpg" border="0" class="gameimg">
										<div class="recd_game_data">
											<span class="recd_game_system"> <img
												src="<%=request.getContextPath()%>/jsp/frontend/images/android.jpg" border="0" title="" alt="">
											</span>新英雄东方不败
										</div>
									</div>
									<div class="recd_game_down">
										<img src="<%=request.getContextPath()%>/jsp/frontend/images/Icon/20.png" border="0"> <a
											href="javascript:;" class="game_a_down" id="2148">扫描下载</a>
									</div>
								</div>
							</div>
						</li>


					</ul>
				</div>




				<div class="clear"></div>
			</div>
			<div class="hot_b"></div>
		</div>
		<div class="clear"></div>
		<div class="guanz">
			<div class="cont_l">
				<div class="r_nav">
					<span><a>更多&gt;&gt;</a></span><font class="span2"><strong>商务合作</strong></font><img
						src="<%=request.getContextPath()%>/jsp/frontend/images/hezuo.png" height="33px";>
				</div>
				<div class="r_m">
					<div class="r_main">


						<div class="r_main_list">
							<h1 style="color: #F60; font-size: 14px;">产品引进:</h1>
							<p>轻松游戏致力打造国内Android、IOS手机网游一流平台，我们拥有成熟的推广渠道，希望与国内各大游戏研发商深度合作。
							</p>

							<div class="r_main_list_r">

								联系人：黎先生<br /> QQ：286614974 <br /> 邮箱：286614974@qq.com

							</div>
						</div>


						<div class="clear"></div>

						<div class="r_main_list">
							<div class="r_main_list_l">
								<h1 style="color: #F60; font-size: 14px;">推广合作:</h1>
								<p>欢迎各品牌网站代理及网络联盟洽谈广告推广合作。</p>
							</div>

							<div class="r_main_list_r">

								联系人：钟先生<br /> QQ：534765157<br /> QQ邮箱：534765157@qq.com
							</div>
						</div>
						<div class="clear"></div>


					</div>
				</div>
				<div class="r_b"></div>
			</div>

		</div>
		<div class="clear"></div>
		<div class="hotbox">
			<div class="hot_nav">合作伙伴</div>
			<div class="hot_m">

				<div class="hezuo_list">
					<div class="scroll-pic" id="scrollPic2">
						<div class="sp-box">
							<div class="sp-cont" style="width: 240px;">
								<a href="javascript:void(0)"><img src="<%=request.getContextPath()%>/jsp/frontend/images/logo_an.gif"></a>
								<a href="javascript:void(0)"><img
									src="<%=request.getContextPath()%>/jsp/frontend/images/logo_anzhi.gif"></a> <a
									href="javascript:void(0)"><img src="<%=request.getContextPath()%>/jsp/frontend/images/logo_yy.gif"></a>
								<a href="javascript:void(0)"><img src="<%=request.getContextPath()%>/jsp/frontend/images/logo_y.gif"></a>
								<a href="javascript:void(0)"><img
									src="<%=request.getContextPath()%>/jsp/frontend/images/logo_app.gif"></a> <a href="javascript:void(0)"><img
									src="<%=request.getContextPath()%>/jsp/frontend/images/logo_sz.gif"></a> <a href="javascript:void(0)"><img
									src="<%=request.getContextPath()%>/jsp/frontend/images/logo_nd.gif"></a> <a href="javascript:void(0)"><img
									src="<%=request.getContextPath()%>/jsp/frontend/images/logo_xm.gif"></a> <a href="javascript:void(0)"><img
									src="<%=request.getContextPath()%>/jsp/frontend/images/logo_ne.gif"></a> <a href="javascript:void(0)"><img
									src="<%=request.getContextPath()%>/jsp/frontend/images/logo_wan.gif"></a> <a href="javascript:void(0)"><img
									src="<%=request.getContextPath()%>/jsp/frontend/images/logo_le.gif"></a> <a href="javascript:void(0)"><img
									src="<%=request.getContextPath()%>/jsp/frontend/images/logo_91.gif"></a> <a href="javascript:void(0)"><img
									src="<%=request.getContextPath()%>/jsp/frontend/images/logo_an.gif"></a><a href="javascript:void(0)"><img
									src="<%=request.getContextPath()%>/jsp/frontend/images/logo_anzhi.gif"></a><a
									href="javascript:void(0)"><img src="<%=request.getContextPath()%>/jsp/frontend/images/logo_yy.gif"></a><a
									href="javascript:void(0)"><img src="<%=request.getContextPath()%>/jsp/frontend/images/logo_y.gif"></a><a
									href="javascript:void(0)"><img src="<%=request.getContextPath()%>/jsp/frontend/images/logo_app.gif"></a><a
									href="javascript:void(0)"><img src="<%=request.getContextPath()%>/jsp/frontend/images/logo_sz.gif"></a><a
									href="javascript:void(0)"><img src="<%=request.getContextPath()%>/jsp/frontend/images/logo_nd.gif"></a><a
									href="javascript:void(0)"><img src="<%=request.getContextPath()%>/jsp/frontend/images/logo_xm.gif"></a><a
									href="javascript:void(0)"><img src="<%=request.getContextPath()%>/jsp/frontend/images/logo_ne.gif"></a><a
									href="javascript:void(0)"><img src="<%=request.getContextPath()%>/jsp/frontend/images/logo_wan.gif"></a><a
									href="javascript:void(0)"><img src="<%=request.getContextPath()%>/jsp/frontend/images/logo_le.gif"></a><a
									href="javascript:void(0)"><img src="<%=request.getContextPath()%>/jsp/frontend/images/logo_91.gif"></a>
							</div>
						</div>
					</div>
				</div>

				<div class="clear"></div>
			</div>
			<div class="hot_b"></div>
		</div>
	</div>


	<div class="footer">
		<p>
			<a href="#">关于我们</a> | <a href="#">商务合作</a> | <a href="#">人才招聘</a> |
			<a href="#">联系我们</a>
		</p>
		<p>健康游戏忠告：抵制不良游戏 拒绝盗版游戏 注意自我保护 谨防受骗上当 适度游戏益脑 沉迷游戏伤身 合理安排时间 享受健康生活</p>
		<p style="padding-top: 6px;">
			粤ICP备13017875号 | <a href="#">粤网文[2013]0227-077号</a>
		</p>
	</div>
	<script type="text/javascript">
		$(function() {
			//add Video
			addVideo();

			indexSlides.ini();
			//latestNews.ini();
			//featurePopup.ini();
		});

		function addVideo() {
		}

		var indexSlides = {};

		indexSlides.timer = false;
		indexSlides.total = $('#slide-index .control a').length;
		indexSlides.current = -1;
		indexSlides.offScreenLeft = 2000;
		indexSlides.leaveScreenLeft = 4000;
		indexSlides.animating = false;

		indexSlides.obj = $('#slide-index .slide');

		indexSlides.style = [];
		indexSlides.style[0] = {
			text : {
				left : '30px',
				top : '46px'
			},
			button : {
				left : '33px',
				top : '265px'
			},
			direction : 'lr'
		};
		indexSlides.style[1] = {
			text : {
				left : '56px',
				top : '86px'
			},
			button : {
				left : '363px',
				top : '282px'
			},
			direction : 'lr'
		};
		indexSlides.style[2] = {
			text : {
				left : '30px',
				top : '81px'
			},
			button : {
				left : '30px',
				top : '244px'
			},
			direction : 'tb'
		};
		indexSlides.style[3] = {
			text : {
				left : '30px',
				top : '81px'
			},
			button : {
				left : '30px',
				top : '244px'
			},
			direction : 'tb'
		};
	</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/jsp/frontend/images/cn_005.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/jsp/frontend/images/scrollpic_jq.js"></script>
	<script type="text/javascript">
		$(".scroll-pic").scrollpic();
	</script>


</body>
</html>