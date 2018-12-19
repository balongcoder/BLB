<!DOCTYPE html>
<html lang="zh">
    <head>
        <meta charset="utf-8" />
        <title>写博客</title>
        <link rel="stylesheet" href="${basePath}/css/plugins/markdown/css/style.css" />
        <link rel="stylesheet" href="${basePath}/css/plugins/markdown/css/editormd.css" />
        <link rel="stylesheet" href="${basePath}/css/plugins/bootstrap/css/bootstrap.css" />
        
        <script src="${basePath}/js/jquery-3.3.1.js"></script>
        <script src="${basePath}/js/plugins/markdown/js/editormd.js"></script>
        <script src="${basePath}/js/plugins/bootstrap/js/bootstrap.js"></script>
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
        <form role="form">
        	<div class="form-group">
        	<input type="text" id="blogArticleRid" name="blogArticleRid" value="${blogArticleRid}" hidden/>
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
    <script type="text/javascript">
         <!--为了让editor.md编辑器完整的显示出来-->
         var testEditor;

		$(function() {
			testEditor = editormd("my-editormd", {
				width: "100%",
				height: 600,
				path : '${basePath}/js/plugins/markdown/lib/',
				theme : "eclipse",
				previewTheme : "eclipse",
				editorTheme : "eclipse", 
/* 				theme : "dark",
				previewTheme : "dark",
				editorTheme : "pastel-on-dark",  */
				/* 主题 "default", "3024-day", "3024-night",
        "ambiance", "ambiance-mobile",
        "base16-dark", "base16-light", "blackboard",
        "cobalt",
        "eclipse", "elegant", "erlang-dark",
        "lesser-dark",
        "mbo", "mdn-like", "midnight", "monokai",
        "neat", "neo", "night",
        "paraiso-dark", "paraiso-light", "pastel-on-dark",
        "rubyblue",
        "solarized",
        "the-matrix", "tomorrow-night-eighties", "twilight",
        "vibrant-ink",
        "xq-dark", "xq-light" */
				codeFold : true,
				//syncScrolling : false,
				saveHTMLToTextarea : true,    // 保存 HTML 到 Textarea
				searchReplace : true,
				//watch : false,                // 关闭实时预览
				htmlDecode : "style,script,iframe|on*",            // 开启 HTML 标签解析，为了安全性，默认不开启    
				//toolbar  : false,             //关闭工具栏
				//previewCodeHighlight : false, // 关闭预览 HTML 的代码块高亮，默认开启
				emoji : true,
				taskList : true,
				tocm            : true,         // Using [TOCM]
				tex : true,                   // 开启科学公式TeX语言支持，默认关闭
				flowChart : true,             // 开启流程图支持，默认关闭
				sequenceDiagram : true,       // 开启时序/序列图支持，默认关闭,
				//dialogLockScreen : false,   // 设置弹出层对话框不锁屏，全局通用，默认为true
				//dialogShowMask : false,     // 设置弹出层对话框显示透明遮罩层，全局通用，默认为true
				//dialogDraggable : false,    // 设置弹出层对话框不可拖动，全局通用，默认为true
				//dialogMaskOpacity : 0.4,    // 设置透明遮罩层的透明度，全局通用，默认值为0.1
				//dialogMaskBgColor : "#000", // 设置透明遮罩层的背景颜色，全局通用，默认为#fff
				imageUpload : true,
				imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
				imageUploadURL : "${basePath}/writeController/upload/editormdPic?blogArticleRid=" + $("#blogArticleRid").val(),//注意你后端的上传图片服务地址
				onload : function() {
				},
				onSave : function() {
					$.ajax({
		                   type: "post",
		                   url: "${basePath}/writeController/saveBlog",
		                   data: {
		                       md_content: testEditor.getMarkdown(),
		                       ht_content: testEditor.getHTML(),
		                       title:$('#title').val(),
		                       rid:$("#blogArticleRid").val()
		
		                   },
		                   contentType: "application/x-www-form-urlencoded; charset=utf-8",
		                   dataType: "json",
		                   success: function (data)
		                   {
							alert(data.message);
		                   },
		                   error:function () {
							alert("BB君有点儿慌了");
		                   }
		               });
				}
			});
		
		});
     </script>
</html>