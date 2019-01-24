/**网页页脚**/
Vue.component('sideBar', 
	{
    	template: '<div class="sidebar" style="width: 320px;">目录</div>',
	}
);

new Vue({
	el:'#main_footer'
});

/**网页页脚**/
Vue.component('catalog', 
	{
    	template : '<ol>' +
				'<a :href="href">' +
				'<span>{{name}}' +
				'</span>' +
				'</a>' +
				'<li v-for="(item,index) in children" :key="index">'+
					'<a :href="item.href">' +
					'<span>{{item.name}}' +
					'</span>' +
					'</a>' +
					'<ol>' +
					'<catalog v-if="item.children && item.children.length" :children="item.children" :name="item.name" :href="item.href">' +
					'</catalog>' +
					'' +
					'' +
					'</ol>' +
				'</li>' +
			'</ol>',
    	data : function(){
    		return {};
    	},
    	computed : {
    		hasChild : function(){
    			return 
    		}
    	},
    	props: {
    		children: Array,
    		name : String,
    		href : String
    	},
	}
);

var catalog = new Vue({
	el:'#catalog',
	data : {
		items : {
			href : "666",
			name : "1",
			children : [
				{
					href : "666",
					name : "2",
					children : [
						{
							href : "666",
							name : "3",
							children : [
							]
						},
						{
							href : "666",
							name : "4",
							children : [
							]
						}
					]
				},
				{
					href : "666",
					name : "5",
					children : [
					]
				}
			]
		}
	}
});