var __domainArray = document.domain.split('.');

var __documentContext = {
	oriTitle : document.title,
	divId : null,
	domain : __domainArray[__domainArray.length - 2] + '.' + __domainArray[__domainArray.length - 1],
	flashDisplayMode : "normal",
	crossDomainMode : false,
	referrer : null
};

delete __domainArray;

var __user = {
	uid : null,
	nick : null,
	username : null,
	phoneBinded : null,
	displayNameText : null
};

var __security = {
	crossDomainSig : null,
	timestamp : null,
	fcm : null
};

var __unionLoginProps = {};

UniLogin = {};

//==============================
// Cross-Domain Messaging Functions
//==============================

function recvMsg(_msg) {
	__user.uid = _msg.uid;
	__user.phoneBinded =  _msg.phoneBinded;
	__user.nick = decodeURIComponent(_msg.nick);
	__user.username = decodeURIComponent(_msg.username);
	__user.displayNameText = decodeURIComponent(_msg.displayNameText);
	
	__security.crossDomainSig = _msg.crossDomainSig;
	__security.timestamp = _msg.timestamp;
	__security.fcm = _msg.fcm;
	
	if (_msg.method == "loginCallback") {
		try {
			__unionLoginProps.loginCallback && __unionLoginProps.loginCallback(__user.username);
		} catch (e)	 {
		}
		closeProxyFrame();
	} else if (_msg.method == "onlineInit") {
		try {
			if (__unionLoginProps.onlineInit)
				__unionLoginProps.onlineInit();
			else if (__unionLoginProps.loginCallback)
				__unionLoginProps.loginCallback();
		} catch (e)	 {
		}
		closeProxyFrame();
	} else if (_msg.method == "offlineInit") {
		closeProxyFrame();
		try {
			if (__unionLoginProps.offlineInit)
				__unionLoginProps.offlineInit();
		} catch (e)	 {
		}
	} else if (_msg.method == "regCallback") {
		try {
			__unionLoginProps.regCallback && __unionLoginProps.regCallback(__user.username);
		} catch (e)	 {
		}
		closeProxyFrame();
	} else if (_msg.method == "resizeCallback") {
		var e = document.getElementById("iframeWrapper");
		if (e) {
			e.style.height = parseInt(_msg.height) + "px";
		}
	} else if (_msg.method == "postPopupShowFunction") {
		if (_msg.reason == 'error') {
			return;
		}
		try {
			__unionLoginProps.postPopupShowFunction && __unionLoginProps.postPopupShowFunction();
		} catch (e) {
		}
		closeProxyFrame();
	} else if (_msg.method == "logoutCallback") {
		resetData();
		closeProxyFrame();
	}
	
}

function listening() {
	if ("" != top.location.hash && "#" != top.location.hash) {
		var arg = parseParams();
		
		try {
			recvMsg(arg);
		} catch (e) {
		}
		
		top.location.replace("#");
		top.document.title = __documentContext.oriTitle;
	}
	
	setTimeout(function() {
		listening();
	}, 100);
}

function resetData() {
	__user.uid = null;
	__user.nick = null;
	__user.username = null;
	__user.phoneBinded = null;
	__user.displayNameText = null;
	
	__security.crossDomainSig = null;
	__security.timestamp = null;
	__security.fcm = null;
	
	__unionLoginProps.logoutCallback && __unionLoginProps.logoutCallback();
}

//==============================
// Internal Functions
//==============================

function openProxyFrame(method) {
	if (method == "init") {
		display = "none";
		method = null;
	} else if (method == "logout") {
		display = "none";
	}else {
		__hideSWFDiv();
		display = "block";
	}
	
	var e = document.getElementById("iframeWrapper");
	if (e) {
		document.body.removeChild(e);
	}
	e = buildIframe();
	if (__documentContext.divId && document.getElementById(__documentContext.divId)) {
		document.getElementById(__documentContext.divId).appendChild(e);
	} else {
		document.body.appendChild(e);
	}
	e.style.display = display;
	e.src = buildRequestUrl(method);
	
	var g = document.getElementById("iframeWrapperBg");
	if (!g) {
		g = buildBg();
		document.body.appendChild(g);
	}
	g.style.display = display;
}

function closeProxyFrame() {
	__unhideSWFDiv();
	
	var e = document.getElementById("iframeWrapper");
	if (e)
		e.style.display = "none";
	
	var g = document.getElementById("iframeWrapperBg");
	if (g)
		g.style.display = "none";
}

function parseParams() {
	var url = top.location.href;
	var args = {};
	
	var argsArray = url.substring(url.indexOf("#") + 1, url.length).split("&");
	for (var i = 0; i < argsArray.length; i++) {
		var kv = argsArray[i].split("=");
		args[kv[0]] = kv[1];
	}
	
	return args;
}

function buildRequestUrl(method) {
	var base = "http://ptlogin." + __documentContext.domain + "/ptlogin/proxyFrame.do";
	
	var args = [];
	for (var i in __unionLoginProps) {
		if (typeof __unionLoginProps[i] != "function")
			args.push(i + "=" + __unionLoginProps[i]);
	}
	if (method)
		args.push("method=" + method);
	args.push("referrer=" + encodeURIComponent(__documentContext.referrer));
	args.push("t=" + new Date().getTime());
	
	return base + "?" + args.join("&");
}

function buildIframe() {
	var e = document.createElement("iframe");
	e.id = "iframeWrapper";
	e.scrolling = "no";
	e.setAttribute("frameBorder", 0);
	
	return e;
}

function buildBg() {
	var g = document.createElement("div");
	g.id = "iframeWrapperBg";
	g.style.display = "none";
	
	return g;
}

//==============================
// UCenter Decorator Interfaces
//==============================

UniLogin.getUid = function() {
	return __user.uid;
}

UniLogin.getUname = function() {
	return __user.username;
}

UniLogin.getNick = function() {
	return __user.nick;
}

UniLogin.getPhoneBinded = function(){
	return __user.phoneBinded;
}

UniLogin.getDisplayName = function(){
	return '<a href="http://u.4399.com/user/info"  target="_blank">' + UniLogin.getDisplayNameText() + '</a>'
}

UniLogin.getDisplayNameText = function(){
	return __user.displayNameText;
}

UniLogin.getCrossDomainSig = function(){
	return __security.crossDomainSig;
}

UniLogin.getTimestamp = function(){
	return __security.timestamp;
}

UniLogin.getFcm = function(){
	return __security.fcm;
}

UniLogin.setUnionLoginProps = function(customLoginProp) {
	__documentContext.referrer = customLoginProp.referrer ? customLoginProp.referrer : null;
	delete customLoginProp.referrer;
	if (!__documentContext.referrer) {
		var url = document.location.href;
		if (url.indexOf("#") != -1) {
			url = url.substring(0, url.indexOf("#"));
		}
		
		__documentContext.referrer = url;
	}
	
	__documentContext.divId = customLoginProp.divId ? customLoginProp.divId : null;
	delete customLoginProp.divId;
	
	__documentContext.flashDisplayMode = customLoginProp.flashDisplayMode ? customLoginProp.flashDisplayMode : "normal";
	delete customLoginProp.flashDisplayMode;
	
	if (customLoginProp.crossDomainMode && customLoginProp.crossDomainMode == true) {
		__documentContext.domain = "4399.com";
		__documentContext.crossDomainMode = true;
	}
	delete customLoginProp.crossDomainMode;
	
	customLoginProp.includeFcmInfo = customLoginProp.includeFcmInfo || false;
	
	__unionLoginProps = customLoginProp;
	listening();
	
	openProxyFrame("init");
}

UniLogin.showPopupReg = function() {
	openProxyFrame("showPopupReg");
}

UniLogin.showPopupLogin = function() {
	openProxyFrame("showPopupLogin");
}

UniLogin.logout = function() {
	if (__documentContext.crossDomainMode == true) {
		openProxyFrame("logout");
	} else {
		JK.Cookie.remove('user_4399', '/', '.' + __documentContext.domain);
		JK.Cookie.remove('Pauth', '/', '.' + __documentContext.domain);
		JK.Cookie.remove('Xauth', '/', '.' + __documentContext.domain);
		JK.Cookie.remove('Pnick', '/', '.' + __documentContext.domain);
		JK.Cookie.remove('Uauth', '/', '.' + __documentContext.domain);
		JK.Cookie.remove('ck_accname', '/', '.' + __documentContext.domain);
		
		resetData();
	}
	
}

var JK = {};
JK.Cookie = (function(){
	var CK = {};
	
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

function __hideSWFDiv() {
	if (__documentContext.flashDisplayMode == "hide") {
		var div = document.getElementById("pusher");
		if (div) {
			div.style.display = "block";
			div.style.height="2000px";
		}
	}
}

function __unhideSWFDiv() {
	if (__documentContext.flashDisplayMode == "hide") {
		var div = document.getElementById("pusher");
		if (div) {
			div.style.height="0px";
			div.style.display = "none";
		}
	}
} 
