uni_login_type_key = "loginType";
uni_login_username_key = "username";
uni_login_uid_key = "uid";
uni_login_nick_key = "Pnick";
uni_login_qqnick_key = "Qnick";
uni_login_puser_key = "Puser";
uni_login_ptusertype_key = "ptusertype";
uni_login_phonebinded = "phonebinded";
uni_login_lastLoginDate = "lastLoginDate";
uni_login_lastLoginAppGame = "lastLoginAppGame";
uni_login_lastLoginTime = "lastLoginTimeStamp";
uni_login_type_qq = "qq";
uni_login_layout_horizontal = "horizontal";
uni_login_layout_vertical = "vertical";
	
var unionLoginProps = {};
function getCookieValue(propKey, defaultValue){
	uniCookie = JK.Passport.get();
	if(!uniCookie)
		return defaultValue;
	return uniCookie[propKey] || defaultValue;
}

UniLogin = {};

UniLogin.getUid = function(){
	return getCookieValue(uni_login_uid_key);
}

UniLogin.getUname = function(){
	return getCookieValue(uni_login_username_key);
}

UniLogin.getUserType = function(){
	return getCookieValue(uni_login_ptusertype_key);
}

UniLogin.getQnick = function(){
	return getCookieValue(uni_login_qqnick_key);
}

UniLogin.getNick = function(){
	if (!UniLogin.getUid()) return null;
	var nick = getCookieValue(uni_login_nick_key);
	if (!nick) {
		return null;
	} else {
		if (nick.replace(/[^x00-xFF]/g,'**').length < 2) {
			return null;
		} else {
			return nick;
		}
	}
}

fetchNickTryCount = 0;
UniLogin.fetchNick = function(callback){
	setTimeout(function(){
		if (!UniLogin.getUid()) return;
		var nick = getCookieValue(uni_login_nick_key);
		if (!nick) {
			fetchNickTryCount++;
			if (fetchNickTryCount > 10) {
				callback(null);
				return;
			}
			UniLogin.fetchNick(callback);
		} else {
			if (nick.replace(/[^x00-xFF]/g,'**').length < 2) {
				UniLogin.showPopupEditNick(true);
				return;
			} else {
				callback(nick);
			}
		}
	}, 200);
}

UniLogin.getPhoneBinded = function(){
	return getCookieValue(uni_login_phonebinded);
}

UniLogin.getDisplayNameText = function(){
	var displayName = getCookieValue(uni_login_nick_key);
	if(displayName && displayName.replace(/[^x00-xFF]/g,'**').length < 2)
		displayName = null;
	if(!displayName)
		displayName = getCookieValue(uni_login_qqnick_key);
	if(!displayName)
		displayName = getCookieValue(uni_login_puser_key);
	if(!displayName)
		displayName = getCookieValue(uni_login_username_key);
	return displayName;
}

UniLogin.getDisplayName = function(){
	return '<a href="http://u.4399.com/user/info"  target="_blank">' + UniLogin.getDisplayNameText() + '</a>'
}

//会在各个登录，注册，qq登录的postHandler中调用
UniLogin.defaultPostLogin = function(isReg){
	executeLoginAction(false, isReg);
}

UniLogin.defaultPostEditNick = function(){
	var nick = UniLogin.getNick();
	
	if (unionLoginProps.__editNickCallback)
		unionLoginProps.__editNickCallback(nick);
}

UniLogin.logout = function(){
	pauthTryNumbers = 0;
	JK.Passport.logout();
	UniLogin.defaultPostLogin();
}

initIFrameState = false;
UniLogin.initIFrameReady = function(divId){
	initIFrameState = true;
	if (unionLoginProps.__postPageLoadCallback) {
		unionLoginProps.__postPageLoadCallback(divId);
	}
}


__initIframe = {};
__initIframeSrc = "";
reloadUcenterIFrameOnNeed = function(){
	if(unionLoginProps.__crossDomainUrl || initIFrameState)
		return;
	__initIframe.src = __initIframeSrc;
}

UniLogin.defaultShowOffline = function(showDiv){
	var loginHTML = "<input id=\"login_autoLogin\" type=\"checkbox\" name=\"autoLogin\" checked=\"checked\"><label  id=\"login_autoLogin_tip\">自动登录</label>";
	loginHTML += "<a id='login_4399user' href=\"javascript:UniLogin.showPopupLogin('','',true)\" target=\"_self\">4399帐号登录</a>";
	loginHTML += getExternalLoginHtml(unionLoginProps.__externalLogin);
	loginHTML += '<a id="login_toregister" href="javascript:UniLogin.showPopupReg(true)" title="马上注册" target="_self">注册</a>';
	showDiv.innerHTML = loginHTML;
}

UniLogin.defaultShowLogin = function(displayName, showDiv){
	var loginHTML = "欢迎您，" + displayName + "\n";
	loginHTML += '<a href="http://u.4399.com/user/info"  target="_blank">设置</a>\n';
	loginHTML += '<a href="javascript:UniLogin.logout()" target="_self">退出</a>';
	phonebinded = getCookieValue(uni_login_phonebinded);
	if(phonebinded == '0')
		loginHTML += '<a href="http://web.4399.com/user/bind_phone.php" target="_blank">免费绑定手机</a>';
	showDiv.innerHTML = loginHTML;
}

UniLogin.setUnionLoginProps = function(customLoginPro) {
	unionLoginProps.__postOnlineStat = customLoginPro.postOnlineStat || true; 
	unionLoginProps.__divId = customLoginPro.divId; 
	unionLoginProps.__appId = customLoginPro.appId; 
	unionLoginProps.__cid = customLoginPro.cid ? customLoginPro.cid : ""; 
	unionLoginProps.__aid = customLoginPro.aid ? customLoginPro.aid : ""; 
	unionLoginProps.__ref = customLoginPro.ref ? encodeURIComponent(customLoginPro.ref) : ""; 
	unionLoginProps.__gameId = customLoginPro.gameId?customLoginPro.gameId:""; 
	unionLoginProps.__layout = customLoginPro.layout; 
	unionLoginProps.__layoutSelfAdapting = customLoginPro.layoutSelfAdapting?customLoginPro.layoutSelfAdapting:"true"; 
	unionLoginProps.__hide_bg = customLoginPro.hide_bg || false; 
	unionLoginProps.__displayMode = customLoginPro.displayMode;
	unionLoginProps.__loginIframeId = customLoginPro.loginIframeId?customLoginPro.loginIframeId:"embed_login_frame";
//	unionLoginProps.__externalLogin = "qq"; 
	unionLoginProps.__externalLogin = customLoginPro.externalLogin?customLoginPro.externalLogin:""; 
	unionLoginProps.__postLoginHandler = customLoginPro.postLoginHandler?customLoginPro.postLoginHandler:"default"; 
	unionLoginProps.__redirectUrl = customLoginPro.redirectUrl?encodeURIComponent(customLoginPro.redirectUrl):""; 
	unionLoginProps.__prePopupShowFunction = customLoginPro.prePopupShowFunction?customLoginPro.prePopupShowFunction:null; 
	unionLoginProps.__postPopupShowFunction = customLoginPro.postPopupShowFunction?customLoginPro.postPopupShowFunction:null; 
	unionLoginProps.__loginCallback = customLoginPro.loginCallback?customLoginPro.loginCallback:null; 
	unionLoginProps.__errorCallback = customLoginPro.errorCallback?customLoginPro.errorCallback:null; 
	unionLoginProps.__regCallback = customLoginPro.regCallback?customLoginPro.regCallback:null; 
	unionLoginProps.__logoutCallback = customLoginPro.logoutCallback?customLoginPro.logoutCallback:null; 
	unionLoginProps.__editNickCallback = customLoginPro.editNickCallback?customLoginPro.editNickCallback:null;
	unionLoginProps.__switchTabCallback = customLoginPro.switchTabCallback?customLoginPro.switchTabCallback:null; 
	unionLoginProps.__postPageLoadCallback = customLoginPro.postPageLoadCallback?customLoginPro.postPageLoadCallback:null; 
	unionLoginProps.__onlineInit = customLoginPro.onlineInit?customLoginPro.onlineInit:null; 
	unionLoginProps.__offlineInit = customLoginPro.offlineInit?customLoginPro.offlineInit:null; 
	unionLoginProps.__css = customLoginPro.css?encodeURIComponent(customLoginPro.css):"";
	unionLoginProps.__prohibitPopupLogin = customLoginPro.prohibitPopupLogin?customLoginPro.prohibitPopupLogin:"";
	unionLoginProps.__regMode = customLoginPro.regMode?customLoginPro.regMode:"reg_normal";
	unionLoginProps.__regIdcard = customLoginPro.regIdcard?customLoginPro.regIdcard:"false";
	unionLoginProps.__noEmail = customLoginPro.noEmail?customLoginPro.noEmail:"false";
	unionLoginProps.__defaultAutoLogin = customLoginPro.defaultAutoLogin?customLoginPro.defaultAutoLogin:"false";
	unionLoginProps.__flashDisplayMode = customLoginPro.flashDisplayMode?customLoginPro.flashDisplayMode:"normal";
	unionLoginProps.__checkOnlineStateEveryTime = customLoginPro.checkOnlineStateEveryTime || false;
	unionLoginProps.__checkOnlineStateInteval = customLoginPro.checkOnlineStateInteval || 3600;
	unionLoginProps.__includeFcmInfo = customLoginPro.includeFcmInfo || false;
	unionLoginProps.__autoComplete = customLoginPro.autoComplete || true;
	unionLoginProps.__writeIframeElementDirect = customLoginPro.writeIframeElementDirect || false;
	dd = document.domain.split('.');
	unionLoginProps.__selfDomain = dd[dd.length - 2] + '.' + dd[dd.length - 1];
	unionLoginProps.__loginDomain = customLoginPro.loginDomain || unionLoginProps.__selfDomain;
	unionLoginProps.__crossDomainUrl = customLoginPro.crossDomainUrl || '';
	unionLoginProps.__regFrameOffset = typeof(customLoginPro.regFrameOffset) == 'undefined' ? 50 : customLoginPro.regFrameOffset;
	unionLoginProps.getPopupUcenterTop = customLoginPro.getPopupUcenterTop || unionLoginProps.getPopupUcenterTop;
	unionLoginProps.loginStateInPage = customLoginPro.loginStateInPage || unionLoginProps.loginStateInPage;
	executeLoginAction(true);
	unionLoginProps.__writeIframeElementDirect = false;
}



//页面初始化时调用
//返回false时，表明还没有取到onlineStat的返回结果
//返回true时，表明可以继续往下处理了
pauthTryNumbers = 0;
initUserState = false; //加载页面初始化时读到的用户状态
function postOnlineStatIfNeed(thisAppGame){
	if (!unionLoginProps.__postOnlineStat)
		return true;
	
	if(pauthTryNumbers == 0){
		if(getCookieValue(uni_login_uid_key))
			initUserState = true;
	}
	if(JK.Cookie.all4399CookieCompatible(thisAppGame))
		return true;
	if(pauthTryNumbers == 0){
		onlineStat(thisAppGame);
	}
	if(pauthTryNumbers >= 20){
		//JK.Passport.logout(); //onlineStat失败直接logout合适吗？
		return true;
	}
	pauthTryNumbers++;
		
	setTimeout("executeLoginAction(true);",100);
	return false;
}

function executeLoginAction(isInit, isPostReg){
	thisAppGame = unionLoginProps.__appId + "." + unionLoginProps.__gameId;
		
	if(isInit){
		if(!postOnlineStatIfNeed(thisAppGame))
			return;
	}
	var div = null;
	if(unionLoginProps.__divId)
		div = document.getElementById(unionLoginProps.__divId);
	
	var uid = getCookieValue(uni_login_uid_key);
	//页面初始化时如果有自定义的根据用户登录状态的定制，应该定义loginStateInPage来报告页面认为的登录状态
	if(isInit){
		loginState = unionLoginProps.loginStateInPage();
		if(loginState && !uid || !loginState && uid){
			window.location.href = window.location.href;
			return;
		}
	}
	
	if(uid){
		displayName = UniLogin.getDisplayName();
		var showDiv = null;
		if(div){
			div.innerHTML = "<div class='login_horizon unilogin_box'> </div>";
			var showDiv = div.children[0];
		}
		
		if(isPostReg && unionLoginProps.__regCallback){
			unionLoginProps.__regCallback(displayName, showDiv);
			return;
		}
		
		if(isInit && unionLoginProps.__onlineInit)
			unionLoginProps.__onlineInit(displayName, showDiv);
		else if(unionLoginProps.__loginCallback)
			unionLoginProps.__loginCallback(displayName, showDiv);
		else if(showDiv)
			UniLogin.defaultShowLogin(displayName, showDiv);
	}else{
		if(pauthTryNumbers > 0){
			return;
		}
		if(unionLoginProps.__loginDomain == unionLoginProps.__selfDomain)
			document.domain = unionLoginProps.__loginDomain;
		else
			document.domain = unionLoginProps.__selfDomain;
		var showDiv = null;
		if(div && unionLoginProps.__displayMode == "popup"){
			div.innerHTML = "<div class='login_horizon unilogin_box'> </div>";
			var showDiv = div.children[0];
		}
		
		
		gotoShowEmbedFrame = false;
		if(isInit){
			if(unionLoginProps.__offlineInit){
				unionLoginProps.__offlineInit(showDiv);
				gotoShowEmbedFrame = true;
			}
		}else{
			if(unionLoginProps.__logoutCallback){
				unionLoginProps.__logoutCallback(showDiv);
				gotoShowEmbedFrame = true;
			}else if(unionLoginProps.__postLoginHandler == 'refreshParent'){
				window.location.href = window.location.href;
				return;
			}
		}
		
		if(!gotoShowEmbedFrame){
			if(unionLoginProps.__displayMode == "popup" && showDiv){
				UniLogin.defaultShowOffline(showDiv);
				return;
			}
		}
		
		
		if(unionLoginProps.__displayMode == "embed"){
			UniLogin.showEmbedLogin();
		}
	}
}


UniLogin.showEmbedLogin = function(username){
	var iframeCssClass = 'login_embed_iframe';
	if(unionLoginProps.__layout == uni_login_layout_horizontal)
		iframeCssClass = 'login_embed_iframe_hor';
	var uname = getCookieValue(uni_login_username_key, "")
	if(username)
		uname = username;
	var iframeSrc = "http://ptlogin." + unionLoginProps.__loginDomain + "/ptlogin/loginFrame.do?postLoginHandler=" + unionLoginProps.__postLoginHandler + "&redirectUrl=" + unionLoginProps.__redirectUrl + 
	"&css=" + unionLoginProps.__css + "&appId=" + unionLoginProps.__appId + "&gameId=" + unionLoginProps.__gameId + "&layout=" + unionLoginProps.__layout + "&displayMode=" + unionLoginProps.__displayMode + 
	"&layoutSelfAdapting=" + unionLoginProps.__layoutSelfAdapting + "&externalLogin=" + unionLoginProps.__externalLogin + "&username=" + encodeURIComponent(uname) +
	"&mainDivId=embed_login_div&autoLogin=" + unionLoginProps.__defaultAutoLogin + "&includeFcmInfo=" + unionLoginProps.__includeFcmInfo;
	
	if (unionLoginProps.__writeIframeElementDirect) {
		document.write('<iframe id="' + unionLoginProps.__loginIframeId + '" name="embed_login_frame" frameborder="0" scrolling="no" allowtransparency="true" class="'
				+ iframeCssClass + '" onLoad="UniLogin.setIframeHeight(\'' + unionLoginProps.__loginIframeId + '\')" src="' + iframeSrc + '" ></iframe>');
		return;
	}
	div = document.getElementById(unionLoginProps.__divId ? unionLoginProps.__divId : "login_div");
	div.innerHTML = '<iframe id="' + unionLoginProps.__loginIframeId + '" name="embed_login_frame" frameborder="0" scrolling="no" allowtransparency="true" class="' + iframeCssClass + '" onLoad="UniLogin.setIframeHeight(\'' + unionLoginProps.__loginIframeId + '\')" src="" ></iframe>';
	var iframe = div.children[0];
	__initIframe = iframe;
	__initIframeSrc = iframeSrc + "&reload=true";
	iframe.src = "";
	iframe.src = iframeSrc;
	setTimeout("reloadUcenterIFrameOnNeed();", 3000)
}


UniLogin.setCrossDomainIframeHeight = function(iframeId, height){
	var frm = document.getElementById(iframeId);
	if(!frm)
		return;
	if(frm){
		frm.height = height;
	}
}

UniLogin.setIframeHeight = function(iframeId){
	if(unionLoginProps.__loginDomain != unionLoginProps.__selfDomain)
		return;
	var frm = document.getElementById(iframeId);
	if(!frm)
		return;
	var subWeb = document.frames ? document.frames[iframeId].document : frm.contentDocument;
	if(frm && subWeb){
		if(unionLoginProps.__loginDomain == unionLoginProps.__selfDomain) {	
			try {
				frm.height = subWeb.body.offsetHeight;
			} catch (e) {
			}
		}
	}
}

function resetSelector() {
	if (currentTab == "popup_edit_nick") {
		var selfObj = document.getElementById('editNickSelector');
		// 操作标签
		var gb_search = document.getElementById("login_tag").getElementsByTagName("li");
		var gb_searchlength = gb_search.length;
		for(i=0; i<gb_searchlength; i++){
			gb_search[i].style.display = "";
		}
		selfObj.parentNode.style.display = "none";
		// 操作内容
		document.getElementById('login_tagnum3').style.display = "none";
	}
}

function hideUselessSelector(sContent,reversed){
	var selfObj = document.getElementById(reversed);
	// 操作标签
	var gb_search = document.getElementById("login_tag").getElementsByTagName("li");
	var gb_searchlength = gb_search.length;
	for(i=0; i<gb_searchlength; i++){
		gb_search[i].style.display = "none";
	}
	selfObj.parentNode.className = "selectTag";
	selfObj.parentNode.style.display = "block";
	// 操作内容
	for(i=0; i<4; i++){
		j=document.getElementById("login_tagnum"+i)
		if(j)
			j.style.display = "none";
	}
	document.getElementById(sContent).style.display = "block";
}

function selectSearchLoginDiv(sContent,selector){
	var selfObj = document.getElementById(selector);
	// 操作标签
	var gb_search = document.getElementById("login_tag").getElementsByTagName("li");
	var gb_searchlength = gb_search.length;
	for(i=0; i<gb_searchlength; i++){
		gb_search[i].className = "";
	}
	selfObj.parentNode.className = "selectTag";
	// 操作内容
	for(i=0; i<3; i++){
		j=document.getElementById("login_tagnum"+i);
		if(j)
			j.style.display = "none";
	}
	document.getElementById(sContent).style.display = "block";
}

var currentTab = "";

constructRegNormalParams = function(crossDomainIFrame, regMode){
	return "regMode=" + regMode + "&postLoginHandler=" + unionLoginProps.__postLoginHandler + "&redirectUrl=" + unionLoginProps.__redirectUrl
		+ "&displayMode=" + unionLoginProps.__displayMode + "&css=" + unionLoginProps.__css + "&appId=" + unionLoginProps.__appId 
		+ "&gameId=" + unionLoginProps.__gameId + "&noEmail=" + unionLoginProps.__noEmail + "&regIdcard=" 
		+ unionLoginProps.__regIdcard + crossDomainIFrame + "&autoLogin=" + unionLoginProps.__defaultAutoLogin
		+ "&cid=" + unionLoginProps.__cid + "&aid=" + unionLoginProps.__aid + "&ref=" + unionLoginProps.__ref;
}	

UniLogin.genRegFrameSrc = function(regMode) {
	var crossDomainIFrame = '';
	if(unionLoginProps.__loginDomain != unionLoginProps.__selfDomain)
		crossDomainIFrame = "&crossDomainIFrame=popup_reg_frame&crossDomainUrl=" + unionLoginProps.__crossDomainUrl;
	return "http://ptlogin." + unionLoginProps.__loginDomain + "/ptlogin/regFrame.do?" + constructRegNormalParams(crossDomainIFrame, regMode) 
		+ "&mainDivId=popup_reg_div&includeFcmInfo=" + unionLoginProps.__includeFcmInfo + "&externalLogin=" + unionLoginProps.__externalLogin;
}

UniLogin.showPopupEmailReg = function(reinit) {
	if(!unionLoginProps.__selfDomain)
		return;
	resetSelector();
	initPopupUcenter(reinit, "loginDiv");
	selectSearchLoginDiv('login_tagnum2', 'emailRegSelector');
	var iframe = document.getElementById("popup_email_reg_frame");
	if(!iframe){
		var iframeSrc = UniLogin.genRegFrameSrc("reg_email");
		iframeSrc = iframeSrc + "&v=" + new Date().getTime();
		var container = document.getElementById("emailRegContainDiv");
		container.innerHTML = '			<iframe id="popup_email_reg_frame" name="popup_email_reg_frame" frameborder="0" scrolling="no" height="294" onload="UniLogin.setIframeHeight(\'popup_email_reg_frame\')" src=""> </iframe>';
		iframe = document.getElementById("popup_email_reg_frame");
		iframe.src = iframeSrc;
		__initIframe = iframe;
		__initIframeSrc = iframeSrc + "&reload=true";
		setTimeout("reloadUcenterIFrameOnNeed();", 3000)
	}
	currentTab = "popup_reg";
	if (unionLoginProps.__switchTabCallback) {
		try {
			unionLoginProps.__switchTabCallback("popup_reg");
		} catch (e) {
		}
	}
}
	
UniLogin.showPopupReg = function(reinit){
	if(!unionLoginProps.__selfDomain)
		return;
	resetSelector();
	initPopupUcenter(reinit, "loginDiv");
	selectSearchLoginDiv('login_tagnum1', 'regSelector');
	var iframe = document.getElementById("popup_reg_frame");
	if(!iframe){
		var iframeSrc = UniLogin.genRegFrameSrc("reg_normal");
		iframeSrc = iframeSrc + "&v=" + new Date().getTime();
		var container = document.getElementById("regContainDiv");
		container.innerHTML = '			<iframe id="popup_reg_frame" name="popup_reg_frame" frameborder="0" scrolling="no" height="272" onload="UniLogin.setIframeHeight(\'popup_reg_frame\')" src=""> </iframe>';
		iframe = document.getElementById("popup_reg_frame");
		iframe.src = iframeSrc;
		__initIframe = iframe;
		__initIframeSrc = iframeSrc + "&reload=true";
		setTimeout("reloadUcenterIFrameOnNeed();", 3000)
	}
	currentTab = "popup_reg";
	if (unionLoginProps.__switchTabCallback) {
		try {
			unionLoginProps.__switchTabCallback("popup_reg");
		} catch (e) {
		}
	}
}

UniLogin.showPopupLogin = function(username, password, reinit){
	if(!unionLoginProps.__selfDomain)
		return;
	resetSelector();
	var uname = getCookieValue(uni_login_username_key, "")
	if(username)
		uname = username;
		
	initPopupUcenter(reinit, "loginDiv");
	selectSearchLoginDiv('login_tagnum0', 'loginSelector');
	var iframe = document.getElementById("popup_login_frame");
	if(!iframe){
		var iframeSrc = "http://ptlogin." + unionLoginProps.__loginDomain + "/ptlogin/loginFrame.do?postLoginHandler=" + unionLoginProps.__postLoginHandler + "&redirectUrl=" + unionLoginProps.__redirectUrl + "&displayMode=" + unionLoginProps.__displayMode + 
			"&css=" + unionLoginProps.__css + "&appId=" + unionLoginProps.__appId + "&gameId=" + unionLoginProps.__gameId + "&username=" + encodeURIComponent(uname) + "&externalLogin=" + unionLoginProps.__externalLogin + "&password=" + (password?password:'') +
			"&mainDivId=popup_login_div&autoLogin=" + unionLoginProps.__defaultAutoLogin + "&includeFcmInfo=" + unionLoginProps.__includeFcmInfo;
		iframeSrc = iframeSrc + "&v=" + new Date().getTime();
		var container = document.getElementById("loginContainDiv");
		container.innerHTML = '			<iframe id="popup_login_frame" name="popup_login_frame" frameborder="0" scrolling="no" height="240" onload="UniLogin.setIframeHeight(\'popup_login_frame\')" src=""> </iframe>';
		iframe = document.getElementById("popup_login_frame");
		iframe.src = iframeSrc;
		reOpened = true;
		__initIframe = iframe;
		__initIframeSrc = iframeSrc + "&reload=true";
		setTimeout("reloadUcenterIFrameOnNeed();", 3000)
	}
	currentTab = "popup_login";
	if (unionLoginProps.__switchTabCallback) {
		try {
			unionLoginProps.__switchTabCallback("popup_login");
		} catch (e) {
		}
	}
}

UniLogin.showPopupEditNick = function(reinit){
	if(!unionLoginProps.__selfDomain)
		return;
	if(unionLoginProps.__loginDomain == unionLoginProps.__selfDomain)
		document.domain = unionLoginProps.__loginDomain;
	else
		document.domain = unionLoginProps.__selfDomain;
	
	currentTab = "popup_edit_nick";
	initPopupUcenter(reinit, "loginDiv");
	hideUselessSelector('login_tagnum3', 'editNickSelector');
	var iframe = document.getElementById("popup_edit_nick_frame");
	if(!iframe){
		var iframeSrc = "http://ptlogin." + unionLoginProps.__loginDomain + "/ptlogin/editNickFrame.do?postLoginHandler=" + unionLoginProps.__postLoginHandler
			+ "&displayMode=" + unionLoginProps.__displayMode + "&appId=" + unionLoginProps.__appId + "&gameId=" + unionLoginProps.__gameId + "&css=" + unionLoginProps.__css
			+ "&redirectUrl=" + unionLoginProps.__redirectUrl + "&mainDivId=" + unionLoginProps.__mainDivId + "&includeFcmInfo=" + unionLoginProps.__includeFcmInfo;
		var container = document.getElementById("editNickContainDiv");
		container.innerHTML = '			<iframe id="popup_edit_nick_frame" name="popup_edit_nick_frame" frameborder="0" scrolling="no" height="255" src=""> </iframe>';
		iframe = document.getElementById("popup_edit_nick_frame");
		iframe.src = iframeSrc;
		__initIframe = iframe;
		__initIframeSrc = iframeSrc + "&reload=true";
		setTimeout("reloadUcenterIFrameOnNeed();", 3000)
	}
}

UniLogin.showLoginError = function(errInfo){
	initPopupUcenter(false, "loginErr");
	var errorBoxDiv = document.getElementById("loginErr");
	errorBoxDiv.style.top = unionLoginProps.getPopupUcenterTop() + "px";
	var errdiv = document.getElementById("errInfoDiv");
	errdiv.innerHTML = errInfo;
}

function closePopupErrDiv(){
	var errDiv = document.getElementById("loginBg");
	if(!errDiv)
		return;
	if(unionLoginProps.__postPopupShowFunction)
		unionLoginProps.__postPopupShowFunction();
	document.getElementById("loginBg").style.display="none";
	document.getElementById("loginErr").style.display="none";
	
	__unhideSWFDiv();
}


function onlineStat(thisAppGame){
	var statAppGame = thisAppGame;
	if(thisAppGame.charAt(thisAppGame.length - 1) == '.')
		statAppGame = thisAppGame.substring(0, thisAppGame.length - 1);
	
	var stat_iframe = document.getElementById("unilogin_stat_iframe");
	
	if(!stat_iframe){
		setTimeout(function(){
			var divs = document.createElement("div");
			divs.id = "unilogin_stat_div";
			document.body.insertBefore(divs, document.body.childNodes[0]);
			divs.style.display = 'none';
			divs.innerHTML = '<iframe id="unilogin_stat_iframe" name="unilogin_stat_iframe" src="" ></iframe>';
			stat_iframe = document.getElementById("unilogin_stat_iframe");
			stat_iframe.src = 'http://ptlogin.' + unionLoginProps.__loginDomain + '/ptlogin/onlineStat.do?appGame=' + statAppGame;
			onlineStatPosted = true;
		}, 10);
	} else {
		stat_iframe.src = 'http://ptlogin.' + unionLoginProps.__loginDomain + '/ptlogin/onlineStat.do?appGame=' + statAppGame;
		onlineStatPosted = true;
	}
}


function initPopupUcenter(reinit, toshowDivId){
	var bgdiv = document.getElementById("loginBg");
	if(reinit && bgdiv){
		document.body.removeChild(document.getElementById("uniLoginAppendDiv"));
		bgdiv = null;
	}
	if(!bgdiv){
		var divs = document.createElement("div");
		divs.id = "uniLoginAppendDiv";
		document.body.appendChild(divs);
		var html = '<div id="loginBg"></div>';
		html += '<div id="loginDiv" class="loginDiv">';
		html += '<ul id="login_tag" class="login_hd">           ';
		if(!unionLoginProps.__prohibitPopupLogin){
			html += '	<li class="">    ';
			html += '		<a id="loginSelector" onfocus="this.blur()" onclick="UniLogin.showPopupLogin()" href="javascript:void(0)" target="_self">登录</a>      ';
			html += '	</li>                                                                                                                   ';
		}
		html += '	<li class="">                                                                                                           ';
		html += '		<a id="regSelector" onfocus="this.blur()" onclick="UniLogin.showPopupReg()" href="javascript:void(0)" target="_self">快速注册</a>      ';
		html += '	</li>                                                                                                                   ';
		html += '	<li class="">                                                                                                           ';
		html += '		<a id="emailRegSelector" onfocus="this.blur()" onclick="UniLogin.showPopupEmailReg()" href="javascript:void(0)" target="_self">邮箱注册</a>      ';
		html += '	</li>                                                                                                                   ';
		html += '	<li class="" style="display:none;">                                                                                                           ';
		html += '		<a id="editNickSelector" onfocus="this.blur()" onclick="UniLogin.showPopupEditNick()" href="javascript:void(0)" target="_self">设置昵称</a>  ';
		html += '	</li>                                                                                                                   ';
		html += '</ul>                                                                                                                    ';
		html += '	<span onclick="closePopupLoginDiv();" class="login_close">关闭</span>';
		html += '<div id="login_tagnum">                                                                                                  ';
		if(!unionLoginProps.__prohibitPopupLogin){
			html += '	<!-- 登陆 -->                                                                                                           ';
			html += '	<div style="display: block;" class="login_tagnum login_fillet selectSearch" id="login_tagnum0">                         ';
			html += '		<div class="login_new" id="loginContainDiv">                                                                        ';
			html += '		</div>                                                                                                                ';
			html += '	</div>                                                                                                                  ';
		}
		html += '	                                                                                                                        ';
		html += '	<!-- 注册 -->                                                                                                           ';
		html += '	<div style="display: none;" class="login_tagnum login_fillet" id="login_tagnum1">                                       ';
		html += '		<div class="login_new" id="regContainDiv">                                                                        ';
		html += '		</div>                                                                                                                ';
		html += '	</div>                                                                                                                  ';
		html += '	                                                                                                                        ';
		html += '	<!-- 邮箱注册 -->                                                                                                           ';
		html += '	<div style="display: none;" class="login_tagnum login_fillet" id="login_tagnum2">                                       ';
		html += '		<div class="login_new" id="emailRegContainDiv">                                                                        ';
		html += '		</div>                                                                                                                ';
		html += '	</div>                                                                                                                  ';
		html += '	                                                                                                                        ';
		html += '	<!-- 设置昵称 -->                                                                                                       ';
		html += '	<div style="display: none;" class="login_tagnum login_fillet" id="login_tagnum3">';
		html += '		<div class="login_new" id="editNickContainDiv">                                                            		 ';
		html += '		</div>                                                                                                                ';
		html += '	</div>';
		html += '</div>';
		html += '<div class="login_fd"></div>';
		html += '</div>';
		
		html += '<div id="loginErr" class="login_comfirm loginErrox">';
		html += '		<div class="login_error">';
		html += '			<strong id="errInfoDiv"></strong>';
		html += '			<p>如果忘记密码，点击<a id="login_forgetPasswd" href="http://u.4399.com/do/password/forget" title="忘记密码" target="_blank">忘记密码</a></p>';
		html += '		</div>';
	
		html += '		<div class="unilogin_box">';
		html += '			<input type="submit" value="" class="login_okx" onclick="javascript:closePopupErrDiv();"/>';
		html += '		</div>';
		html += '</div>';
		divs.innerHTML = html;
	}
	
	if(unionLoginProps.__prePopupShowFunction)
		unionLoginProps.__prePopupShowFunction();
	var bg = document.getElementById("loginBg");
	bg.style.width = "100%";
	var de = document.documentElement;
    var db = document.body;
    bg.style.height = Math.max(de.offsetHeight, de.scrollHeight, db.offsetHeight, db.scrollHeight) + "px";
	bg.style.display=unionLoginProps.__hide_bg?"none":"block";
	
	var divs = document.getElementById("uniLoginAppendDiv");
	if(divs && divs.style.display == 'none')
		divs.style.display = 'block'; 
	
	document.getElementById(toshowDivId).style.display = "block";
	if(reinit) {
		document.getElementById(toshowDivId).style.top = unionLoginProps.getPopupUcenterTop() + "px";
	}
	
	__hideSWFDiv();
}

unionLoginProps.loginStateInPage = function(){
	return initUserState;
}

unionLoginProps.getPopupUcenterTop = function(){
    var top = Math.max(document.documentElement.scrollTop, document.body.scrollTop);
    return top + 100;
}

var isAutoRegSuccess = false;
function confirmAutoRegInfo() {
	var msg = "请你一定要记住你所注册的４３９９帐号和密码并保管好，方便你下次在４３９９能正常登录游戏，你确定记住了吗？";
	if (autoRegInfoMsg)
		msg = autoRegInfoMsg + '，' + msg;
	
	var cnf = confirm(msg);
	if(cnf){
		isAutoRegSuccess = false;
		currentTab = null;
	}
	return cnf;
}

var reOpened = false;

function closePopupLoginDiv(reason) {
	if (isAutoRegSuccess
			&& !confirmAutoRegInfo())
		return;
	var bg = document.getElementById("loginBg");
	if(!bg)
		return;
	reOpened = false;
	if(unionLoginProps.__postPopupShowFunction)
		unionLoginProps.__postPopupShowFunction(reason);
	if(reOpened){
		reOpened = false; 
		return;
	}
	document.getElementById("loginBg").style.display="none";
	document.getElementById('loginDiv').style.display="none";
	
	var divs = document.getElementById("uniLoginAppendDiv");
	if(!divs)
		return;
	document.getElementById('uniLoginAppendDiv').style.display="none";
	
	__unhideSWFDiv();
}

function getExternalLoginHtml(externalLogin){
	if(externalLogin)
		return "<a id='login_qqlogin' href='#' onclick='javascript:UniLogin.toQzoneLogin(document.getElementById(\"login_autoLogin\").checked)' title=\"QQ号登录\" class=\"QQ\" target=\"_self\">QQ号登录</a>"
			+ "<a id='login_weibologin' href='#' onclick='javascript:UniLogin.toWeiboLogin(document.getElementById(\"login_autoLogin\").checked)' title=\"新浪微博登录\" class=\"weibo\" target=\"_self\">新浪微博登录</a>"
			+ "<a id='login_taobaologin' href='#' onclick='javascript:UniLogin.toTaobaoLogin(document.getElementById(\"login_autoLogin\").checked)' title=\"淘宝登录\" class=\"taobao\" target=\"_self\">淘宝登录</a>";
	return "";
}

function encodeExtLoginState(autoLogin){
	return encodeURIComponent("postLoginHandler=" + unionLoginProps.__postLoginHandler + "&redirectUrl=" + unionLoginProps.__redirectUrl + 
		"&appId=" + unionLoginProps.__appId + "&gameId=" + unionLoginProps.__gameId + "&cid=" + unionLoginProps.__cid
		+ "&aid=" + unionLoginProps.__aid + "&ref=" + unionLoginProps.__ref + "&autoLogin=false");
}

UniLogin.toRebindExt = function(type){
	document.domain = "4399.com";
	s = "width=523,height=" + (type == "taobao" ? 500 : 320)  + ",top=200,left=200,menubar=0,scrollbars=1,resizable=1,status=1,titlebar=0,toolbar=0,location=1";
	window.open("http://extlogin.4399.com/" + type + "/rebind.do", type, s);
}

UniLogin.toTaobaoLogin = function(autoLogin){
	window.open("http://extlogin.4399.com/taobao/redirectToAuthorize.do?params=" + encodeExtLoginState(autoLogin),
		"TaobaoLogin", "width=523,height=500,top=200,left=200,menubar=0,scrollbars=1,resizable=1,status=1,titlebar=0,toolbar=0,location=1");
}

UniLogin.toWeiboLogin = function(autoLogin){
	window.open("http://extlogin.4399.com/weibo/redirectToAuthorize.do?params=" + encodeExtLoginState(autoLogin),
		"WeiboLogin", "width=523,height=320,top=200,left=200,menubar=0,scrollbars=1,resizable=1,status=1,titlebar=0,toolbar=0,location=1");
}

UniLogin.toQzoneLogin = function(autoLogin){
	window.open("http://extlogin.4399.com/qzone/redirectToAuthorize.do?params=" + encodeExtLoginState(autoLogin),
		"TencentLogin", "width=523,height=320,top=200,left=200,menubar=0,scrollbars=1,resizable=1,status=1,titlebar=0,toolbar=0,location=1");
}


var onlineStatPosted = false;
var preOnlineStatUauth;

String.prototype.trim=function(){
	return this.replace(/(^\s+|\s+$)/g, '');
}

var JK = {};
JK.Cookie = (function(){
	var CK = {};
	CK.getAll = function(){
		var cookies = document.cookie;
		if(!cookies)
			return {};
		var data = cookies.split(";");
		var arr = {}, dat;
		for(i = 0; i < data.length; i++){
			dat = data[i].split('=');
			dat[0] = dat[0].trim();
			if(dat[0] != 'Pauth' && dat[0] != 'Uauth' && dat[0] != 'Puser' && dat[0] != 'ck_accname'
				&& dat[0] != 'Pnick' && dat[0] != 'Qnick' && dat[0] != 'ptusertype')
				continue;
			dat[1] = (dat[1] || '').trim();
			if(dat[0] == 'Pauth'){
				if(dat[1].length > 64)
					arr[dat[0]] = decodeURIComponent(decodeURIComponent(dat[1]));
			}
			else if(dat[0] == 'Uauth'){
				if(dat[1].length > 64)
					arr[dat[0]] = decodeURIComponent(dat[1]);
			}else if(dat[0] == 'Puser' || dat[0] == 'ck_accname' || dat[0] == 'Pnick' || dat[0] == 'Qnick'
				|| dat[0] == 'ptusertype')
				arr[dat[0]] = decodeURIComponent(dat[1]);
		}
		return arr;
	};
	
	//所有cookie已经得到更新，处于一致状态。
	//如果所有cookie都不存在，或者需要检查刷新的cookie返回了结果
	CK.all4399CookieCompatible = function(thisAppGame){
		var cookies = document.cookie;
		if(!cookies)
			return true;
		pauth_exists = false;
		uauth_exists = false;
		puser_exists = false;
		postOnlineStatUauth = null;
		var data = cookies.split(";");
		for(i = 0; i < data.length; i++){
			dat = data[i].split('=');
			dat[0] = dat[0].trim();
			if(dat[0] == 'Pauth'){
				if(dat[1] && dat[1].length > 64)
					pauth_exists = true;
			}else if(dat[0] == 'Uauth'){
				uauth_exists = true;
				if(!onlineStatPosted)
					preOnlineStatUauth = dat[1];//页面刷新初始化第一次读到的
				else
					postOnlineStatUauth = dat[1];//每隔100毫秒读到的
			}
			else if(dat[0] == 'Puser')
				puser_exists = true;
		}
		
		//都不存在，合法.可能初始化时就离线状态，或者提交onlineStat被强制下线
		if(!pauth_exists && !uauth_exists)
			return true;
		
		if(!pauth_exists){
			JK.Cookie.remove('Uauth', '/', '.' + unionLoginProps.__loginDomain);
			JK.Cookie.remove('ck_accname', '/', '.' + unionLoginProps.__loginDomain);
			return true;
		}
		
		//每次加载都需要检查和刷新cookie
		if(unionLoginProps.__checkOnlineStateEveryTime){
			if(!onlineStatPosted)//还没有提交onlineStat
				return false;
			if(preOnlineStatUauth != postOnlineStatUauth)//到了这里，如果onlineStat返回了，只会是之前没有，现在有，或之前有现在是新的，都会不一样
				return true;
			return false;
		}
		
		//否则只要有一个不存在，不合法
		if(!pauth_exists || !uauth_exists || !puser_exists)
			return false;
		
		phonebinded = getCookieValue(uni_login_phonebinded);
		if(phonebinded != '0' && phonebinded != '2')
			return false;
		
		//都存在，看时间和已访问渠道
		today = new Date();
		todayDate = '' + today.getFullYear() + (today.getMonth() + 1) + today.getDate();
		lastLoginDate = getCookieValue(uni_login_lastLoginDate);
		lastLoginTime = getCookieValue(uni_login_lastLoginTime);
		if(!lastLoginTime)
			lastLoginTime = 0;
		nowms = (today.getTime() - lastLoginTime) / 1000;
		shouldPostOnlineStat= true;
		//如果日期一致，时间还没过检查间隔，需要检查渠道是否已经被记录
		if(lastLoginDate == todayDate && nowms < unionLoginProps.__checkOnlineStateInteval){
			lastLoginAppGame = getCookieValue(uni_login_lastLoginAppGame);
			var appGames = lastLoginAppGame.split('#');
			for(i = 0; i < appGames.length; i++){
				if(appGames[i] == thisAppGame){
					shouldPostOnlineStat = false;
					break;
				}
			}
		}
		
		return !shouldPostOnlineStat;
	};
	
	CK.get = function(name){
		var cookies = CK.getAll();
		return cookies[name] || null;
	};
	CK.set = function(name, value, expire, path, domain, secure){
		var val = name + '=' + escape(value);
		if(expire){
			var date = new Date;
			if(expire < 30 * 86400){
				expire = date.getTime() + expire * 1000;
				date.setTime(expire);
			}
			val += ';expires=' + date.toGMTString();
		}
		if(path){
			val += ';path=' + path;
		}
		if(domain){
			val += ';domain=' + domain;
		}
		if(secure){
			val += ';secure';
		}
		document.cookie = val;
	}
	CK.remove = function(name, path, domain){
		CK.set(name, '', -1, path, domain);
	};
	return CK;
})();

JK.Passport = (function(){
	var PP = {};
	PP.get = function(){
		var ptusertype = JK.Cookie.get('ptusertype');
		var qnick = JK.Cookie.get('Qnick');
		
		var username = JK.Cookie.get('ck_accname');
		if(!username)
			username = JK.Cookie.get('Puser');
		dat = JK.Cookie.get('Pauth');
		if(!dat){
			if(username)
				return {'username' : username,
					'ptusertype' : ptusertype,
					'Qnick' : qnick};
			else
				return null;
		}
		var user = dat.split("|");
		var uid = parseInt(user[0]);
		if(uid > 0){
			var loginType = '';
			var nick = JK.Cookie.get('Pnick');
			var lastLoginDate = '';
			var lastLoginAppGame = '';
			var lastLoginTimeStamp = '';
			var uauthSig = '';
			var uauth = JK.Cookie.get('Uauth');
			if(uauth){
				uinfo = uauth.split("|");
				loginType = uinfo[0];
//				if(uinfo.length >= 2 && !nick)
//					nick = uinfo[1];
				if(uinfo.length >= 6){
					lastLoginDate = uinfo[uinfo.length - 4];
					lastLoginAppGame = uinfo[uinfo.length - 3];
					lastLoginTimeStamp = uinfo[uinfo.length - 2];
					uauthSig = uinfo[uinfo.length - 1];
				}
			}
			username = user[1].trim();
			if(username){
				var phonebinded = '1';
				if(user.length == 7 && (user[6] == '0' || user[6] == '2')){
					phonebinded = user[6];
				} 

				return {
					'uid' : uid,
					'username' : username,
					'loginType' : loginType,
					'Pnick' : nick,
					'Qnick' : qnick,
					'ptusertype' : ptusertype,
					'lastLoginDate' : lastLoginDate,
					'lastLoginAppGame' : lastLoginAppGame,
					'lastLoginTimeStamp' : lastLoginTimeStamp,
					'uauthSig' : uauthSig,
					'phonebinded' : phonebinded
				};
			}
		}
		return null;
	};
	PP.logout = function(){
		JK.Cookie.remove('user_4399', '/', '.' + unionLoginProps.__loginDomain);
		JK.Cookie.remove('Pauth', '/', '.' + unionLoginProps.__loginDomain);
		JK.Cookie.remove('Xauth', '/', '.' + unionLoginProps.__loginDomain);
		JK.Cookie.remove('Uauth', '/', '.' + unionLoginProps.__loginDomain);
		JK.Cookie.remove('ck_accname', '/', '.' + unionLoginProps.__loginDomain);
	};
	return PP;
})();

function __hideSWFDiv() {
	if (unionLoginProps.__flashDisplayMode == "hide") {
		var div = document.getElementById("pusher");
		if (div) {
			div.style.display = "block";
			div.style.height="2000px";
		}
	}
}

function __unhideSWFDiv() {
	if (unionLoginProps.__flashDisplayMode == "hide") {
		var div = document.getElementById("pusher");
		if (div) {
			div.style.height="0px";
			div.style.display = "none";
		}
	}
} 

function rewriteUsernameAndPassword(username, password) {
	var subWeb = document.getElementById(unionLoginProps.__loginIframeId);
	if (subWeb) {
		var usernameEle = subWeb.contentDocument.getElementById('username');
		if (usernameEle) {
			usernameEle.value = username;
		}
		var passwordEle = subWeb.contentDocument.getElementById('password');
		if (passwordEle) {
			passwordEle.value = password;
		}
	}
}
