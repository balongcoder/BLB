<!DOCTYPE html>
<html lang="zh">
    <head>
        <meta charset="utf-8" />
        <title>博客一览</title>
        <title>写博客</title>
        <link rel="stylesheet" href="${basePath}/css/plugins/markdown/css/style.css" />
        <link rel="stylesheet" href="${basePath}/css/plugins/markdown/css/editormd.css" />
        <link rel="stylesheet" href="${basePath}/css/plugins/bootstrap/css/bootstrap.css" />
        <link rel="stylesheet" href="${basePath}/css/plugins/bootstrap/css/bootstrap-treeview.css" />
        
        <script src="${basePath}/js/jquery-3.3.1.js"></script>
        <script src="${basePath}/js/plugins/markdown/js/editormd.js"></script>
        <script src="${basePath}/js/plugins/bootstrap/js/bootstrap.js"></script>
        <script src="${basePath}/js/plugins/bootstrap/js/bootstrap-treeview.js"></script>
    </head>
    <body>
      <div class="row">
	      <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
          <div id="articleTree">
          </div>
        </div>
	      <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
	        <div id="articleContent" class="col-xs-10 col-sm-10 col-md-10 col-lg-10 editormd-html-textarea" style="text-align: left;">
	                   内容
	        </div>
		      <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">目录</div>
	      </div>      
      </div>
    </body>
    <script type="text/javascript">
      function getTree(){
    	  var tree = {
		    	color: 'red',
		      backColor: '#FFFFFF',
		      state: {
            expanded: true,
          },
    	  };
    	  tree.data = [
              {
                  text: '第一章',
                  //icon: 'glyphicon',
                  //selectedIcon: 'glyphicon',
                  
                  href: '#01',
                  selectable: true,
                  tags: ['available'],
                  state: {
                      selected: true
                    },
                  nodes: [
                  {
                    text: '第一章第一节',
                   },
                   {
                     text: '第一章第二节',
                   }
                   ]
                  },
                  {
                    text: '第二章'
                  }
                ];
	    	return tree;
    	}
    	$('#articleTree').treeview(getTree());
    	
    	function getContent(){
    		$.ajax({
    			async : false,
          cache:false,
                type : 'POST',  
                url : '${basePath}/getArticle',
                data:{
                },
                
					success : function(data) {
						$("#articleContent").html(data.content);
					},
					error: function(){
						alert("BB君很慌");
					}
					});
				}

				getContent();
		</script>
</html>