$(function(){
	$(".publish-button").on("click", function(){
				var name = $("[name='name']").val(),
				sex = $("[name='sex']").val(),
				city = $("[name='city']").val(),
				address = $("[name='address']").val(),
				phone = $("[name='phone']").val(),
				email = $("[name='email']").val(),
				message = $("[name='message']").val();
				name = name.replace(/^\s|\s$/g, '');
				email = email.replace(/^\s|\s$/g, '');
				message = message.replace(/^\s|\s$/g, '');
				if( name == '' ){
					alert("姓名/公司名称为必填项，不能为空");
					return false;
				}
				if( email == '' ){
					alert("Email为必填项，不能为空");
					return false;
				}
				if( message == ''){
					alert("留言为必填项，不能为空");
					return false;
				}
				$.ajax({
					type : "POST",
					url  : BASE_URL+"message.do",
					data : "name="+name+"&sex="+sex+"&city="+city+"&phone="+phone+"&address="
							+address+"&email="+email+"&message="+message,
					success:  function(data){
							alert("留言成功");
						}
				});
				
		});
});