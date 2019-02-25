Vue.component('login_register_model', {
	template: '' + 
		'<div class="modal fade login" id="loginModal">' +
			'<div class="modal-dialog login animated">' +
			    '<div class="modal-content">' +
			       '<div class="modal-header">' +
			          '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>' +
			          '<h4 class="modal-title">登录</h4>' +
			      '</div>' +
			      '<div class="modal-body">  ' +
			          '<div class="box">' +
			               '<div class="content">' +
			                  '<div class="error"></div>' +
			                  '<div class="form loginBox">' +
			                      '<form method="post" :action="modelloginurl" accept-charset="UTF-8">' +
			                      '<input id="returnUrl" type="text" name="returnUrl" :value="modelreturnurl" hidden="hidden">' +
			                      '<input id="user" class="form-control" type="text" placeholder="用户名称" name="user" @focus="clearError">' +
			                      '<input id="password" class="form-control" type="password" placeholder="用户密码" name="password" @focus="clearError">' +
			                      '<input class="btn btn-default btn-login" type="button" value="登录" @click="loginAjax">' +
			                      '</form>' +
			                  '</div>' +
			               '</div>' +
			          '</div>' +
					  '<div class="box">' +
				          '<div class="content registerBox" style="display:none;">' +
				          '<div class="error"></div>' +
				           '<div class="form">' +
				              '<form method="post" html="{:multipart=>true}" data-remote="true" :action="modelregisterurl" accept-charset="UTF-8">' +
				              '<input id="register_returnurl" type="text" name="register_returnurl" :value="modelreturnurl" hidden="hidden">' +
				              '<input id="register_user" class="form-control" type="text" placeholder="用户名称" name="register_user" @focus="clearError">' +
				              '<input id="register_password" class="form-control" type="password" placeholder="用户密码" name="register_password" @focus="clearError">' +
				              '<input id="register_password_confirmation" class="form-control" type="password" '+
				                 'placeholder="确认密码" name="register_password_confirmation" @focus="clearError">' +
				              '<input class="btn btn-default btn-register" type="button" value="注册" @click="registerAjax">' +
				              '</form>' +
				              '</div>' +
				          '</div>' +
				      '</div>' +
			      '</div>' +

			      '<div class="modal-footer">' +
			          '<div class="forgot login-footer">' +
			              '<span>前往 ' +
			                   '<a href="javascript:;" @click="showRegisterForm">注册</a>' +
			              '?</span>' +
			          '</div>' +
			          '<div class="forgot register-footer" style="display:none">' +
			               '<span>已经有账号?</span>' +
			               '<a href="javascript:;" @click="showLoginForm">登录</a>' +
			          '</div>' +
			      '</div>        ' +
			    '</div>' +
			'</div>' +
		'</div>',
		props: {
			modelloginurl: {
				type:String,
				required: true
			}, // 登录地址
			modelregisterurl: {
				type:String,
				required: true
			}, // 注册地址
			modelreturnurl:{
				type:String,
				required: false
			} // 返回地址
			
		},
		methods:{
			loginAjax:function(){
				var that = this;
				$.ajaxSettings.async = false;
				$.post(this.modelloginurl, function( data ) {
		            if(data.flag == 1){
		                window.location.replace(this.modelreturnurl);            
		            } else {
		            	that.shakeModal(data.message); 
		            }
		        });
				$.ajaxSettings.async = true;
			},
			registerAjax:function(){
				var that = this;
				$.ajaxSettings.async = false;
			    $.post(this.modelregisterurl, function( data ) {
		            if(data.flag == 1){
		                window.location.replace(this.modelreturnurl);            
		            } else {
		            	that.shakeModal(data.message); 
		            }
			    });
			    $.ajaxSettings.async = true;
			},
			shakeModal:function(msg){
			    $('#loginModal .modal-dialog').addClass('shake');
			    this.setError(msg);
	             $('input[type="password"]').val('');
	             setTimeout( function(){ 
	                $('#loginModal .modal-dialog').removeClass('shake'); 
	             }, 1000); 
			},
			setError:function(msg){
				$('#loginModal .error').addClass('alert alert-danger').html(msg);
			},
			showRegisterForm:function(){
				this.$emit('showregisterform');
			},
			showLoginForm:function(){
				this.$emit('showloginform');
			},
			clearError:function(){
				$('#loginModal .error').removeClass('alert alert-danger').html(''); 
			}
		}
})

function initLoginModel(){
	if($('#login_register').length == 0){
		return null;
	}
	var login_register_temp = new Vue({
		el:'#login_register',
		data:{
			loginurl: '3', // 登录地址
			registerurl: '2', // 注册地址
			returnurl:'1'// 返回地址
			
		},
		components:{
			//'login_register_model':login_register_model
		},
		methods:{
			openLoginModal:function(){
			    this.showLoginForm();
			    setTimeout(function(){
			        $('#loginModal').modal('show');    
			    }, 230);
			},
			openRegisterModal:function(){
				this.showRegisterForm();
			    setTimeout(function(){
			        $('#loginModal').modal('show');    
			    }, 230);
			},
			showRegisterForm: function(){
			    $('#loginModal .loginBox').fadeOut('fast',function(){
			        $('#loginModal .registerBox').fadeIn('fast');
			        $('#loginModal .login-footer').fadeOut('fast',function(){
			            $('.register-footer').fadeIn('fast');
			        });
			        $('#loginModal .modal-title').html('注册');
			    }); 
			    this.clearError();
			},
			showLoginForm:function(){
			    $('#loginModal .registerBox').fadeOut('fast',function(){
			        $('#loginModal .loginBox').fadeIn('fast');
			        $('#loginModal .register-footer').fadeOut('fast',function(){
			            $('#loginModal .login-footer').fadeIn('fast');    
			        });
			        
			        $('#loginModal .modal-title').html('登录');
			    });       
			    this.clearError();
			},
			clearError:function(){
				$('#loginModal .error').removeClass('alert alert-danger').html(''); 
			},
			
		}
	});
	
	return login_register_temp;
}
var login_register = initLoginModel();