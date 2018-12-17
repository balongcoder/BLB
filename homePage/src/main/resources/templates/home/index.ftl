<!DOCTYPE html>
<html lang="zh">
    <head>
        <meta charset="utf-8" />
		<title>BLB</title>
        <link rel="stylesheet" href="./css/plugins/markdown/css/style.css" />
        <link rel="stylesheet" href="./css/plugins/markdown/css/editormd.css" />
        <link rel="stylesheet" href="./css/plugins/bootstrap/css/bootstrap.css" />
        
        <script src="./js/jquery-3.3.1.js"></script>
        <script src="./js/plugins/markdown/js/editormd.js"></script>
        <script src="./js/plugins/bootstrap/js/bootstrap.js"></script>
        <style>
            #submit_button{
                display:block;
                margin-left: 42%;
                margin-top: 2em;
                margin-bottom: 2em;
            }
            .input{
                display: block;
                margin-left: 20%;
            }
        </style>
    </head>
    <body>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">iOS</a></li>
			<li><a href="#">SVN</a></li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					Java
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="#">jmeter</a></li>
					<li><a href="#">EJB</a></li>
					<li><a href="#">Jasper Report</a></li>
					<li class="divider"></li>
					<li><a href="#">分离的链接</a></li>
					<li class="divider"></li>
					<li><a href="#">另一个分离的链接</a></li>
				</ul>
			</li>
		</ul>
        <form role="form">
        	<div class="form-group">
   				<div class="col-sm-10">
	   				<input type="text" class="form-control " id="title" name="title" placeholder="请输入标题"/>
   				</div>
   				<div class="col-sm-2">
	   				<input type="button" class="form-control btn btn-primary" id="release" name="release" value="发布文章" placeholder="发布文章"/>
   				</div>
   			</div>
   			<div class="form-group">
	            <div id="my-editormd" class="col-sm-10" style="margin-top: 15px;">
	                 <textarea id="my-editormd-markdown-doc" name="my-editormd-markdown-doc" style="display:none;"></textarea>
	                <!-- 注意：name属性的值-->
	                <textarea id="my-editormd-html-code" name="my-editormd-html-code" style="display:none;"></textarea>
	            </div>
		    </div>
        </form>
    </body>
</html>