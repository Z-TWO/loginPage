//账号
var $username = $("input[name=username]");
$username.blur(function(){
	if($username.val()!=""){
		$("#userP").text("");
		$("#userP").css("display","none");
		$("#userDiv").css("margin-bottom","20px");
	}
})
//密码
var $password = $("input[name=password]");
$password.blur(function(){
	if($password.val()!=""){
		$("#pswP").text("");
		$("#pswP").css("display","none");
		$("#pswDiv").css("margin-bottom","20px");
	}
})
//登录提交
var $submit = $("input[type=submit]");
var userflag = false;
var pswflage = false;
$submit.click(function(){
	var post = false;
	if($username.val().length<=0){
		$("#userP").text("请输入帐号");
		$("#userP").css("display","block");
		$("#userDiv").css("margin-bottom","30px");
	}else{
		userflag = true;
	}
	if($password.val().length<=0){
		$("#pswP").text("请输入密码");
		$("#pswP").css("display","block");
		$("#pswDiv").css("margin-bottom","30px");
	}else{
		pswflage = true;
	}
	if(userflag && pswflag){
		post = true;
	}
	return post;
});