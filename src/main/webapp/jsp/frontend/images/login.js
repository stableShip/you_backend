if(typeof SSJJ == 'undefined'){
	var SSJJ = {};	
}
SSJJ.user = {
	'config':{'didId':'','appId':'','gameId':'','layout':'','displayMode':'','postLoginHandler':'','redirectUrl':'','css':'','checkOnlineStateEveryTime':'','loginDomain':''},
	'setLogin':function(){
		if(typeof UniLogin != 'undefined'){			
			UniLogin.setUnionLoginProps(this.config);
			UniLogin.logout();
		}
	},
	'popReg':function(){
		return UniLogin.showPopupReg(true);
	},	
	'init':function(config){
		for(var i in config){
			this.config[i]=config[i];
		}
		this.setLogin();
	}
};