/** 目录组件 **/
/** 主页菜单 * */
Vue.component('main_menu_comp', {
    template: '<div id="main_menu_title">' +
	     '<p>' +
	     	'<span style="vertical-align:middle;">' +
	     		'<img v-if="menu.showLogo" v-bind:src="menu.logoPath" class="menu_logo_img"></img>' + 
	     		'<font size="12" color="#87CEFA" style="width: auto;">'+
	     		'{{menu.title}}</font>' +
	     	'</span>' +
	     '</p>' +
		  '<div align="center">' +
		   '<ul class="bs-glyphicons-list">' +
		     '<li v-for="(item, index) in menu.items" :key="index">' +
		       '<a :id="item.id" :href="item.href"><span :class="item.class_style"></span><span> {{item.text}}</span></a>' +
		     '</li>' +
		   '</ul>' +
		  '</div>' +
		  '<div class="back-to-top" onclick="window.scroll(0,0);">' +
			'<i class="fa fa-arrow-up"></i>' +
		  '</div>' +
	  '</div>',
    props: ['menu']
})

/**构建主页菜单**/
function initMainMenu(){
	var scripts = document.getElementsByTagName("script"),
	mainMenuScript = scripts[scripts.length - 1];
	var menuUrl = mainMenuScript.getAttribute("menuUrl");
	if($('#main_menu').length == 0){
		return null;
	}
	var mainmenuTemp = new Vue({
	    el : '#main_menu',
	    data : {
	      menu : {
	        title : "",
	        showLogo : false,
	        logoPath : "",
	        items : []
	      }
	    },
	    mounted:function(){
	      //需要执行的方法可以在mounted中进行触发，其获取的数据可以赋到data中后，可以放在前面进行渲染
	      // 在模板渲染成html前调用
	    },
	    created:function(){
	    	// 在模板渲染成html后调用，通常是初始化页面完成后，再对html的dom节点进行一些需要的操作。
	    },
	    methods:{
	    	getData:function(){
		      //需要执行的方法可以在mounted中进行触发，其获取的数据可以赋到data中后，可以放在前面进行渲染
		    	// 在模板渲染成html前调用
		    	console.log("mounted 调用");
		    	var _self = this;
		    	
		    	this.$http.get(menuUrl).then(function(response){
	                //var json=data.body;
		    		console.info(response.body);
		    		_self.$set(this.menu, 'items', response.body.items);
		    		_self.menu.title= response.body.title;
		    		//_self.data = response.body;
	            },function(response){
	                console.info("出错了");
	                console.info(response);
	            });
		    	console.log("mounted 调用后");
		    }
	    }
	  });
	
	$.ajax({
		async:false,
		url:menuUrl,
		success:function(data){
			mainmenuTemp.menu.title = data.menu.title;
			mainmenuTemp.menu.showLogo = data.menu.showLogo;
			mainmenuTemp.menu.logoPath = data.menu.logoPath;
			var items = data.menu.items;
			for(var i = 0; i < items.length; i++){
				mainmenuTemp.$set(mainmenuTemp.menu.items, i, items[i]);
			}
		},
		error: function(response){
			console.log("出错");
		}
	});
	
	//首先获取导航栏距离浏览器顶部的高度
	var top = $('header').offset().top;
	//开始监控滚动栏scroll
	$(document).scroll(function(){
		//获取当前滚动栏scroll的高度并赋值
		var scrTop = $(window).scrollTop();
		//开始判断如果导航栏距离顶部的高度等于当前滚动栏的高度则开启悬浮
		if(scrTop > top){
			$('header').css({'position':'fixed','top':'0','width':'100%'});
		}else{//否则清空悬浮
			$('header').css({'position':'','top':''});
		}
		
		if(scrTop > 0){
			$('.back-to-top').addClass('back-to-top-on');
		} else {
			$('.back-to-top').removeClass('back-to-top-on');
		}
	})
	return mainmenuTemp;
}
var main_menu = initMainMenu();

/**网页页脚**/
Vue.component('main_footer_comp', {
    template: '<div class="container">' +
        '<div class="footer_bottom">' +
	    '<span>Copyright &copy; 2019.Company name All rights <a href="/index" target="_blank" title="书博">BLB</a>' +
	      '- Collect from <a href="/index"' +
	      'title="书博" target="_blank">BLB</a></span>' +
	  '</div>' +
	'</div>',
})

function initFooter(){
	if($('#main_footer').length == 0){
		return null;
	}
	return new Vue({
		el:'#main_footer'
	});
}

var mainFooter = initFooter();

/** 右下角固定栏 **/

