var perviewComponent = {
		template:'' + 
		'<article>' +
	      '<header class="aticle-header">' +
	          '<h1 class="aticle-title">' +
	                '<a class="aticle-title-link" :href="article.url">' +
	                  '{{article.title}}' +
	                '</a>' +
	          '</h1>' +
	        '<div class="post-meta">' +
	          '<span class="post-time">' +
	            '<span class="post-meta-item-icon">' +
	              '<i class="fa fa-calendar-o"></i>' +
	            '</span>' +
	            '<span class="post-meta-item-text">发表于</span>' +
	            '<time>{{article.postTime}}</time>' +
	          '</span>' +
	          '<span>' +
	            '&nbsp; | &nbsp;' +
	            '<span class="post-meta-item-text">' +
	              '作者 &nbsp;' +
	            '</span>{{article.author}}&nbsp;</span>' +
	            '<span>' +
	              '&nbsp; | &nbsp;' +
	              '<span class="post-meta-item-icon">' +
	                '<i class="fa fa-folder-o"></i>' +
	              '</span>' +
	              '<span class="post-meta-item-text">分类于</span>' +
	                '<span>' +
	                  '<a :href="article.typeUrl">' +
	                    '<span style="font-weight:bolder;">{{article.typeName}}</span>' +
	                  '</a>' +
	                '</span>' +
	            '</span>' +
	              '<span class="post-comments-count">' +
	                '&nbsp; | &nbsp;阅读人数&nbsp;' +
	                  '<span class="post-comments-count ds-thread-count" >{{article.readCount}}</span>' +
	              '</span>' +
	        '</div>' +
	      '</header>' +
	    '<div class="post-body" itemprop="articleBody">' +
	          '{{article.summary}}' +
	          '<div class="post-more-link text-center">' +
	            '<a class="btn" :href="article.url" rel="contents">' +
	              '阅读全文 »' +
	            '</a>' +
	          '</div>' +
	    '<p></p></div>' +
	    '<div>' +
	    '</div>' +
	    '<div>' +
	    '</div>' +
	    '<footer class="post-footer">' +
	        '<div class="post-eof"></div>' +
	    '</footer>' +
	  '</article>',
	  props: {
		article: {
		  type: Object,
		  required: true
	  	}
	  }
}

var paginationComponent = {
	template:'' + 
	  '<nav class="pagination">' +
	    '<a :class="item1.tag_class" :href="item1.href" :style="item1.style"><i class="fa fa-angle-left"></i></a>' + // 1
	    '<a :class="item2.tag_class" :href="item2.href" :style="item2.style">{{item2.value}}</a>' + // 2
	    '<span :class="item3.tag_class" :style="item3.style">{{item3.value}}</span>' + // 3
	    '<a :class="item4.tag_class" :href="item4.href" :style="item4.style">{{item4.value}}</a>' + // 4
	    '<span class="item5.tag_class" :style="item5.style">{{item5.value}}</span>' + // 5
	    '<a :class="item6.tag_class" :href="item6.href" :style="item6.style">{{item6.value}}</a>' + // 6
	    '<span :class="item7.tag_class" :style="item7.style">{{item7.value}}</span>' + // 7
	    '<a :class="item8.tag_class" :href="item8.href" :style="item8.style">{{item6.value}}</a>' + // 8
	    '<a :class="item9.tag_class" :href="item9.href" :style="item9.style"><i class="fa fa-angle-right"></i></a>' + // 9
	  '</nav>',
	 props:{
		 pagecofig:{
			 type:Object,
			 required: true
		 }
	 },
	 computed:{
		 item1:function(){
			 var item_config = {style:"display:none;",value:"", href:this.pagecofig.page_perx + "/", tag_class:"extend prev"};
			 if(this.pagecofig.page_num > 1 && this.pagecofig.page_count > 1){
				 item_config.display = "display:inline;";
				 var prev = this.pagecofig.page_num - 1;
				 if(prev > 1){
					 item_config.href = this.pagecofig.page_perx + "/" + prev;
				 }
			 }
			 
			 return item_config;
		 },
		 item2:function(){
			 var item_config = {style:"display:none;",value:"", href:this.pagecofig.page_perx + "/", tag_class:"page-number"};
			 if(this.pagecofig.page_num > 3 && this.pagecofig.page_count > 3){
				 item_config.style = "display:inline;";
				 var prev = this.pagecofig.page_num - 1;
				 if(prev > 1){
					 item_config.href = this.pagecofig.page_perx + "/" + 1;
				 }
			 }
			 return item_config;
		 },
		 item3:function(){
			 var item_config = {style:"display:none;",value:"…"};
			 if(this.pagecofig.page_num > 3 && this.pagecofig.page_count > 5){
				 item_config.style = "display:inline;";
			 }
			 return item_config; //block
		 },
		 item4:function(){
			 var item_config = {style:"display:none;",value:"", href:this.pagecofig.page_perx + "/", tag_class:"page-number"};
			 
			 switch (this.pagecofig.page_num){
			 	case 1:
			 		break;
			 	case 2:
			 		item_config.value = "1";
			 		item_config.href = this.pagecofig.page_perx + "/1";
			 		item_config.style = "display:inline;";
			 		break;
			 	case 3:
			 		item_config.value = "2";
			 		item_config.href = this.pagecofig.page_perx + "/2";
			 		item_config.style = "display:inline;";
			 		break;
			 	default:
			 		item_config.value =  this.pagecofig.page_num -1 + "";
			 		item_config.href = this.pagecofig.page_perx + "/" + (this.pagecofig.page_num -1);
		 			item_config.style = "display:inline;";
			 }
			 return item_config;
		 },
		 item5:function(){
			 var item_config = {style:"display:inline;",value:this.pagecofig.page_num + "", tag_class:"page-number current"};
			 return item_config;
		 },
		 item6:function(){
			 var item_config = {style:"display:none;",value:"", href:this.pagecofig.page_perx + "/", tag_class:"page-number"};
			 if(this.pagecofig.page_count > this.pagecofig.page_num){
				 item_config.style = "display:inline;";
				 item_config.href = this.pagecofig.page_perx + "/" + (this.pagecofig.page_num + 1);
				 item_config.value = this.pagecofig.page_num + 1;
			 }
			 return item_config;
		 },
		 item7:function(){
			 var  item_config = {style:"display:none;",value:"…", tag_class:"space"};
			 if(this.pagecofig.page_count > this.pagecofig.page_num + 2){
				 item_config.style = "display:inline;";
			 }
			 return item_config;
		 },
		 item8:function(){
			 var item_config = {style:"display:none;",value:"", href:this.pagecofig.page_perx + "/", tag_class:"page-number"};
			 if(this.pagecofig.page_count = this.pagecofig.page_num + 2){
				 item_config.style = "display:inline;";
				 item_config.href = this.pagecofig.page_perx + "/" + (this.pagecofig.page_num + 2);
				 item_config.value = this.pagecofig.page_num + 2;
			 } else if(this.pagecofig.page_count > this.pagecofig.page_num + 2){
				 item_config.style = "display:inline;";
				 item_config.href = this.pagecofig.page_perx + "/" + this.pagecofig.page_count;
				 item_config.value = this.pagecofig.page_count;
			 }
			 return item_config;
		 },
		 item9:function(){
			 var item_config = {style:"display:none;",value:"", href:this.pagecofig.page_perx + "/"};
			 if(this.pagecofig.page_num < this.pagecofig.page_count){
				 item_config.style = "display:inline;";
				 var prev = this.pagecofig.page_num + 1;
				 item_config.href = this.pagecofig.page_perx + "/" + prev;
			 }
			 return item_config;
		 }
	 
	 }
}

function initArticleList(){
		if($('#articleList').length == 0){
		return null;
	}
	var articleList_temp = new Vue({
		el:'#articleList',
		data:{
			articles:[
				{
					url:"111",
					title:"试一试",
					postTime:"2019-01-02",
					author:"泡泡龙",
					typeUrl:"/aaa",
					typeName:"日常",
					readCount:2,
					summary:"页面加载较慢是用户经常会反馈的问题，也是前端非常关注的问题之一。但定位、排查解决这类问题就通常会花费非常多的时间，主要原因如下："
				},
				{
					url:"111",
					title:"试一试",
					postTime:"2019-01-02",
					author:"泡泡龙",
					typeUrl:"/aaa",
					typeName:"日常",
					readCount:2,
					summary:"页面加载较慢是用户经常会反馈的问题，也是前端非常关注的问题之一。但定位、排查解决这类问题就通常会花费非常多的时间，主要原因如下："
				},
				{
					url:"111",
					title:"试一试",
					postTime:"2019-01-02",
					author:"泡泡龙",
					typeUrl:"/aaa",
					typeName:"日常",
					readCount:2,
					summary:"页面加载较慢是用户经常会反馈的问题，也是前端非常关注的问题之一。但定位、排查解决这类问题就通常会花费非常多的时间，主要原因如下："
				}
			],
			article_page_cofig:{
				page_count: 10,
				page_num:1,
				page_perx:"/page"
			}
			
		},
		components:{
			'perview-component':perviewComponent,
			'pagination_component':paginationComponent
		},
		methods:{
			
		}
	});
	
	return articleList_temp;
}
var articleList = initArticleList();