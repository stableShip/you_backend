/*
* worker:web designer
* Author: lin jie
*/
	$(document).ready(function(){
		//开服分页
		$("#game_servertbody tr:gt(4)").hide();
		$(".game_server_page a").click(function(){
			$(this).addClass("action");
			$(this).siblings().removeClass("action");
			var _a = 5;//定义每页显示的个数
			var _num = $(this).index();
			var _sum = _num+1;
			$("#game_servertbody tr").hide()
			for(i=_num*_a;i<_sum*_a;i++)
			{
				$("#game_servertbody tr:eq("+i+")").show();
			}
		});
		//用户信息显示
		var _timeOout;
		$(".p_t_welcome a").hover(function(){
				clearTimeout(_timeOout);
				$(this).parent().addClass("p_t_active");
				if($(".p_t_welcome").outerWidth()+$(".p_t_uiexit").outerWidth()>$(".p_t_uiblock").outerWidth()){
					$(".p_t_uiblock").css("right","auto");
				}
				$(".p_t_uiblock").show();
			},function(){
				var _this = $(this)
				_timeOout = setTimeout(function(){
						$(".p_t_uiblock").hide();
						_this.parent().removeClass("p_t_active");
					},500);
			
			})
		$(".p_t_uiblock").live("mouseover",function(){
				clearTimeout(_timeOout);
				$(this).siblings("div.p_t_welcome").addClass("p_t_active");
				$(this).show();
			})
		$(".p_t_uiblock").live("mouseout",function(){
				var _this = $(this);
				_timeOout = setTimeout(function(){
					_this.siblings("div.p_t_welcome").removeClass("p_t_active");
					_this.hide();
				},500);
				
			});
		//游戏列表上下却换
		$(".recd_game_hidden").hover(function(){
					$(this).find("div.recd_game_info").stop().animate({"margin-top":-$(".recd_game_hidden").height()+"px"},300);
			},function(){
				$(this).find("div.recd_game_info").stop().animate({"margin-top":"0"},300);
			});
		$(".game_ul_conhidden").hover(function(){
					$(this).find("div.game_ul_contop").stop().animate({"margin-top":-$(".game_ul_conhidden").height()+"px"},300);
			},function(){
				$(this).find("div.game_ul_contop").stop().animate({"margin-top":"0"},300);
			});
			
		//弹出层
		function showCeng(aclass){
			$("."+aclass).click(function(){
				//加载游戏包数据
				var id = $(this).attr('id');
				$.getJSON('/game/download/info?id='+id+'&jsoncallback=?',
					function(result){
						if(result && result.list){
							var html = generate_download_list(result);//构造页面
							$("#download_pop").append(html);
						}
					}				
				);
				$("#downceng").show();//显示页面
				$(".downcengcon").css({"top":($(window).height()/3+$(document).scrollTop())+"px"});
				$(".downcengbg").css({"opacity":"0.8","height":$(document).height()+"px","width":$(document).width()+"px"});
			});
			$("#dc_close").live('click',function(){
				$("#download_pop").html('');
				$("#downceng").hide();
			});
		}
		showCeng("game_a_down");
		showCeng("game_ul_down");
		//支付中心
		$('.banktable td').click(function(){
				$(this).find('input').attr('checked',true);
			})
			$('.pay_em').click(function(){
				$(this).find('input').attr('checked',true);
				$(this).find('input').trigger("change");
			})
		$(".banktable tr:gt(2)").hide();
		$(".v5_setbank").click(function(){
			$(".banktable tr:gt(2)").toggle();
			if($(".v5_setbank").html()=="选择其他银行")
			{
				$(this).html("隐藏部分银行");
				$(this).addClass("v5_setbankaction");
			}
			else{
				$(this).html("选择其他银行");
				$(this).removeClass("v5_setbankaction");
			}
		});
	
		//生成下载连接地址
		function generate_download_list(result){
			var html = [];
			var data = result.list;
			html.push('<h3 class="dc_title"><a href="javascript:;" class="dc_close" id="dc_close">关闭</a><img src="'+result.logo+'" title="" alt="" height="32" width="32" />'+result.name+'</h3>');
			html.push('<div class="dc_infocon">');
			html.push('<ul class="dc_infoul">');
			for(var i in data){
				html.push('<li>');
				html.push('<div class="dc_infoul_left">');
				if(data[i].pack_type == 1){
					html.push('<p><strong>'+data[i].name+'</strong>（不含数据包，手机安装后再从手机下载数据包）</p>');
				}else{
					html.push('<p><strong>'+data[i].name+'</strong>（包含数据包，手机安装后无需再下载）</p>');
				}
				html.push('<p>大小：<em>'+data[i].size+'</em></p>');
				html.push('</div>');
				html.push('<div class="dc_infoul_right">');
				html.push('<a href="/game/download/game?id='+result.id+'&game_soft_id='+data[i].game_soft_id+'">直接下载</a>');
				html.push('</div>');
				html.push('</li>');
			}
			html.push('</ul></div>');
			return html.join('');
		}
		
		//领取礼包
		$(".game_gift_aclick").click(function(){
			if($(this).next("div.game_gift_useinfo").css("display")=="none"){
				$(".game_gift_aclick").removeClass("action");
				$(".game_gift_useinfo").slideUp();
			}
			$(this).next("div.game_gift_useinfo").slideToggle(function(){
				if($(this).prev("a.game_gift_aclick").attr("class")=="game_gift_aclick")
				{
					$(this).prev("a.game_gift_aclick").addClass("action");
				}
				else{
					$(this).prev("a.game_gift_aclick").removeClass("action");
				}
			});
		});
		
		$("#gift_all").click(function(){
			$(this).addClass("action");
			$("#log_all").removeClass("action");
			$("#log_list").hide();
			$("#gift_list").show();
			$(".game_gift").css("height","auto");
			footset(["game_gift"]);
		})
		
		$("#log_all").click(function(){
			$(this).addClass("action");
			$("#gift_all").removeClass("action");
			$("#gift_list").hide();
			$("#log_list").show();
			$(".game_gift").css("height","auto");
			footset(["game_gift"]);
		})
		
		$(".game_gift_libtn_a a").click(function(){
			var gift_id = $(this).attr("id");
			var _this = $(this);
			var _jihuoma = $("#jihuoma_"+gift_id);
			var post_data = {gift_id: gift_id};
			$.post("/gift/home/get", post_data, function(data){
			     if(data.status == 1) {
			    	 var html = "";
			    	 html += "<tr>";
			    	 html += "<td>"+data.log.gift_name+"</td>";
			    	 html += "<td>"+data.log.gift_code+"</td>";
			    	 html += "<td>"+data.log.time+"</td>";
			    	 html += "</tr>";
			    	 $("#log_list_tbody").prepend(html);
			    	 $("#none_content").hide();
			    	 _jihuoma.text(data.msg);
			    	 _this.parent().parent().next("div.game_gift_jihuoma").show();
			    	 _this.after("<span>已领取</span>").remove();
			     } else if(data.status == 2) {
			    	 _this.parent().parent().next("div.game_gift_jihuoma").show();
			    	 _this.after("<span>领取</span>").remove();
			     } else if(data.status == -1) {
			    	 _this.parent().parent().next("div.game_gift_jihuoma").show();
			    	 _this.after("<span>领取</span>").remove();
				 }else {
			    	 alert(data.msg);
				 }
			 }, "json");
		});
		
		//底部贴近底部页面
		footset(["pay_righ_con","list_con","help_right_con","game_con","game_gift"]);
		function footset(objArr){
			if($("body").height()<$(window).height()){
				var _hei = $(window).height()-$(".pub_toper").height()-$(".toper").height()-$(".footer").height()-40;
				for(_kv = 0;_kv<objArr.length;_kv++){
					$("."+objArr[_kv]).css("height",_hei+"px");
				}
			}
			else{
				return false;
			}
			
		}
		$(window).resize(function(){
					footset(["pay_righ_con","list_con","help_right_con","game_con","game_gift"]);
			});
});

	;(function($){
		$.fn.IMGtabs = function(option){
					//首页切换图
					var _pubNum =0;
					var _stop;
					var _img = new Image();
					_img.arr = [];
					var _arr = new Array();
					var _sreenWidth = screen.width;
					$("#banner_imgcon").append($("#banner_imgcon").html());
					$("#banner_imgcon").css("width",($("#banner_imgcon li").length*_sreenWidth)+"px");
					$("#banner_imgcon li").css({"width":_sreenWidth+"px","float":"left"});
					for(_k =0;_k<$("#banner_imgcon li").length;_k++){
						var _imgUrl = $("#banner_imgcon li:eq("+_k+")").find("a").find("img").attr("src");
						_arr.push($("#banner_imgcon li:eq("+_k+")").find("a").find("img").attr("value"));
						$("#banner_imgcon li:eq("+_k+")").find("a").css({"margin-left":-(_sreenWidth-$(document).width())/2+"px"});
					}
					loading();
					function loading(){
						_img.src=_arr[_pubNum];
						var _number = 0;
						var _stopnum = 0;
						for(_imgnums = 0;_imgnums<_img.arr.length;_imgnums++){
							if(_img.src==_img.arr[_imgnums]){
									_number++;		
							}
							else{
								continue;
							}
						}
						if(_number==0){
							if(navigator.appVersion.indexOf("MSIE 6")>0)
							{
								var _id = Math.ceil(Math.random()*99);
								_img.src = _img.src + "?"+_id;
							}
							$(_img).load(function(){
								if(_stopnum==0){
									_stopnum++;
									clearInterval(_stop);
									var _nums = 0;
									if($("#banner_imgcon li").length/2>_pubNum){
										_nums = Math.abs($("#banner_imgcon li").length/2+_pubNum);
									}
									else{
											_nums = Math.abs($("#banner_imgcon li").length/2-_pubNum);
									}
									$("#banner_imgcon li:eq("+_pubNum+")").find("a").css("background","url("+_img.src+") no-repeat center center");
									$("#banner_imgcon li:eq("+_nums+")").find("a").css("background","url("+_img.src+") no-repeat center center");
									$("#banner_imgcon li:eq("+_pubNum+")").find("a").find("img").remove();
									//$("#banner_imgcon li:eq("+_pubNum+")").find("a").find("img").css("margin-top","0");
									$("#banner_imgcon li:eq("+_nums+")").find("a").find("img").remove();
									//$("#banner_imgcon li:eq("+_nums+")").find("a").find("img").css("margin-top","0");
									_stop = setInterval(_show,7000);
									_img.arr.push(_img.src);
								}
								else{
									return false;
								}
							})
							return false;
						}
						else{
							_stopnum++;
							clearInterval(_stop);
							_stop = setInterval(_show,7000);
							return false;
						}
					};
					
					var _show = function(){
						_pubNum++;
						if(_pubNum>$("#banner_imgcon li").length-1)
						{
							_pubNum=Math.floor($("#banner_imgcon li").length/2)-1;
							$("#banner_imgcon").css("left",-(_sreenWidth*_pubNum)+"px");
							_pubNum++;
						}
						$("#banner_imgcon").stop().animate({"left":-(_sreenWidth*_pubNum)+"px"},500);
						loading();
					};
					
					$(".banbtn_next").click(function(){
						clearInterval(_stop);
						if(!$("#banner_imgcon").is(":animated")){
							_pubNum++;
							if(_pubNum>$("#banner_imgcon li").length-1){
								_pubNum=Math.floor($("#banner_imgcon li").length/2)-1;
								$("#banner_imgcon").css("left",-(_sreenWidth*_pubNum)+"px");
								_pubNum++;
							}
							
							$("#banner_imgcon").stop().animate({"left":-(_sreenWidth*_pubNum)+"px"},500);
							loading();
						}
					});
					$(".banbtn_prev").click(function(){
						clearInterval(_stop);
						if(!$("#banner_imgcon").is(":animated")){
							_pubNum--;
							if(_pubNum<0)
							{
								_pubNum=Math.floor($("#banner_imgcon li").length/2);
								$("#banner_imgcon").css("left",-(_sreenWidth*_pubNum)+"px");
								_pubNum--;
							}
							$("#banner_imgcon").stop().animate({"left":-(_sreenWidth*_pubNum)+"px"},500);
							loading();
						}
					});
					
						//变化窗口
					$(window).resize(function(){
							for(_z =0;_z<$("#banner_imgcon li").length;_z++){
								$("#banner_imgcon li:eq("+_z+")").find("a").css("margin-left",-(_sreenWidth-$(document).width())/2+"px");
							}
						});
		}
	})(jQuery);