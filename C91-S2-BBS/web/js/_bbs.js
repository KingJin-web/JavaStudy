// axios.defaults.withCredentials = true;
axios.defaults.baseURL = "http://" + location.hostname + ":1113/bbs/"
var sid = getCookie("sid");
var hashid = location.hash.substring(1);

axios.interceptors.request.use(
	config=>{
		var i = config.url.indexOf("?");
		if(i==-1){
			config.url += ";jsessionid=" + sid;
		} else {
			config.url = config.url.substring(0,i) 
				+ ";jsessionid=" + sid 
				+ config.url.substring(0,i+1);
		}
		return config;
	},
	err => {
		return Promise.reject(err);
	}
);

/**
 * 页头公共模板
 */ 
Vue.component("bbshead",{
	data(){
		return {
			loginedUser : null,
			require : undefined
		}
	},
	props : ["require"],
	template : `
	<div>
		<DIV>
			<IMG src="image/logo.gif">
		</DIV>
		<!--      用户信息、登录、注册        -->
		<DIV class="h">
			<span v-if="loginedUser">
				欢迎 {{loginedUser.uname}}
				&nbsp;| &nbsp; <A href="#" @click="logout">退出</A> |
			</span>
			<span v-else>
				您尚未　<a href="_login.html">登录</a>
				&nbsp;| &nbsp; <A href="_reg.html">注册</A> |
			</span>
			
		</DIV>
	</div>
	`,
	created(){
		sid = getCookie("sid");
		axios.get("getLoginedUser").then( res => {
			// 获取登录的用户名, 服务器会返回 null 字符串值
			this.loginedUser = res.data;
			if( this.require != undefined && ! res.data) {
				alert("请先登录!");
				location.href = "_login.html";
			}
		});
	},
	methods : {
		logout(){
			axios.get("user/logout").then( res => {
				location.href = "index(演示).html";
			});
		}
	}
});

/**
 * 页头公共模板
 */ 
Vue.component("bbsfoot",{
	template : `
	<div class="gray" style="text-align: center;">
		<a href="http://www.hyycinfo.com" target="_blank">源辰信息</a>
	</div>
	`
});

Vue.component("page",{
	data() {
		return { data : {}};
	},
	props : ["data"],
	template : `
	<!--            翻 页          -->
	<DIV>
		<a v-if="data.pageNum>1" @click="$parent.load(data.pageNum-1)">上一页</a>
		<a v-else >已是首页</a>
		|
		<a v-if="data.pageNum<data.pages" @click="$parent.load(data.pageNum+1)">下一页</a>
		<a v-else >已是尾页</a>
	</DIV>
	`
});