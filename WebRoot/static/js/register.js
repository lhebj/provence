function register_show(){
	if($("#mask").length > 0){
		return true;
	}
	var content = $("#register-tmpl").html();
	$("body").append(content);
	mask_init();
}
//关闭注册框
function close_register(){
	$("#mask").remove();
	$(".mask-level").remove();
}
//初始化注册框
function mask_init(){
	var $mask = $("#mask");
	$(".close", $mask).on("click", close_register);
	$(".register", $mask).on("click", ajax_register);
	$("[name='username']", $mask).on("blur", check_user);
	$("[name='email']", $mask).on("blur", check_email);
	form_date_select();
}
//形成时间下列列表
function form_date_select(){
	var year_option = "";
	var begin_year = new Date().getFullYear();
	end_year = begin_year - 90;
	for(var i = begin_year; i > end_year; i--){
		year_option += "<option value='"+i+"'>"+i+"</option>";
	}
	$(".year-select").html(year_option);
	
	var month_option = "";
	var month = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
	for(var i in month){
		var j = month[i];
		if( j < 10){
			j = "0" + j;
		}
		month_option += "<option value='"+j+"'>"+month[i]+"</option>";
	}
	$(".month-select").html(month_option);
	
	var day_option = "";
	for(var i = 1; i <= 30; i++){
		var j = i;
		if( j < 10){
			j = "0" + j;
		}
		day_option += "<option value='"+j+"'>"+i+"</option>";
	}
	$(".day-select").html(day_option);
}

//注册
function ajax_register(){
	var username = $("[name='username']").val(),
	sex = $("[name='sex']:checked").val(),
	email = $("[name='email']").val(),
	dateBirthday = $("[name='dateBirthday']").val(),
	mobile = $("[name='mobile']").val(),
	address = $("[name='address']").val(),
	zipcode = $("[name='zipcode']").val(),
	city= $("[name='city']").val();
	country= $("[name='country']").val();
	var year = $("[name='year']").val(),
		month = $("[name='month']").val(),
		day = $("[name='day']").val();
	dateBirthday = year + "-" + month + "-" + day;
	var data = {
				username : username,
				sex : sex,
				email : email,
				dateBirthday : dateBirthday,
				mobile: mobile,
				address : address,
				zipcode : zipcode,
				city : city,
				country : country
				};
	if(username.replace('/^\s|\s$/g', '') == ''){
		alert("用户名不能为空");
	}
	if(email.replace('/^\s|\s$/g', '') == ''){
		alert("邮箱不能为空");
	}
	$.ajax({
		url : 'register.do',
		type : 'POST',
		dataType : 'json',
		data : data,
		success : function(data){
				if(data.success == false){
					alert(data.message);
				}else{
					close_register();
					alert("注册成功");
				}
			}
	});
}

function check_user(){
	var username = $("[name='username']").val();
	$.ajax({
		url      :    'userCheck.do?action=username',
		type     :   'GET',
		datatype :   'json',
		data     :   'username='+username,
		success  :   function(data){
			data = $.parseJSON(data);
				if(data.success == true){
					$(".user-success-message").show();
					$(".user-error-message").hide();
				}else{
					$(".user-error-message").show();
					$(".user-success-message").hide();
					
				}
			}
	});
}

function check_email(){
	var email = $("[name='email']").val();
	$.ajax({
		url      :    'userCheck.do?action=email',
		type     :   'GET',
		datatype :   'json',
		data     :   'email='+email,
		success  :   function(data){
			data = $.parseJSON(data);
				if(data.success == true){
					$(".email-success-message").show();
					$(".email-error-message").hide();
				}else{
					$(".email-error-message").show();
					$(".email-success-message").hide();
					
				}
			}
	});
}