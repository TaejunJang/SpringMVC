<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../include/header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">

$(function(){

	$.ajax({
		type: "POST",
		url:"/board/ajax.do",
		data : {test:"test1"},
		success : function(data){
			console.log(data);
			
			$("#chkArea").append('<input type="checkbox" name="dragchk" class="dragchkClass"> 체크박스 1<br>')
			.append('<input type="checkbox" name="dragchk" class="dragchkClass"> 체크박스 3<br>')
			.append('<input type="checkbox" name="dragchk" class="dragchkClass"> 체크박스 4<br>')
			.append('<input type="checkbox" name="dragchk" class="dragchkClass"> 체크박스 5<br>')
			.append('<input type="checkbox" name="dragchk" class="dragchkClass"> 체크박스 6<br>')	
			
			dragchkSetting()
			console.log("2");
			
		}
	})
	
	console.log("3");
	
})

var dragchkstat = "off"; 

 function dragchkNOOP() {
	 console.log("클릭");
	return false; 
}
 
function dragchkOnMouseDown() { 
	console.log("마우스다운");
        if (this.checked) { 
                dragchkstat = "uncheck"; this.checked = false; 
        } else { 
                dragchkstat = "check"; this.checked = true; 
        } 
        return false; 
} 
function dragchkOnMouseOver() { 
	console.log("마우스 오버");
        switch (dragchkstat) { 
                case "off": 
                        break; 
                case "check": 
                        this.focus(); this.checked = true; break; 
                case "uncheck": 
                        this.focus(); this.checked = false; break; 
        } 
        return false; 
} 
function dragchkOnMouseUp() {
	console.log("마우스업");
	dragchkstat = "off"; return true; 
	
	} 

function dragchkSetting(){
	 var chkList =  $("input[name=dragchk]");
	for (i = 0; i < chkList.length; i++) { 
		chkList[i].onclick = dragchkNOOP;
		chkList[i].onmousedown = dragchkOnMouseDown; 
		chkList[i].onmouseover = dragchkOnMouseOver; 
        document.onmouseup = dragchkOnMouseUp; 
} 
	
}
/* $(document).on("mousedown",".dragchkClass",function(){
	dragchkSetting();
}) */



</script>
<body>
<form role="form" method="post">
	<div  class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">Title</label>
			<input type="text" name="title" class="form-control">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Content</label>
			<textarea rows="3" class="form-control" name="content"></textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label>
			<input type="text" class="form-control" name="writer">
		</div>
	</div>
	<div class="box-footer">
		<button type="submit" class="btn btn-primary">Submit</button>
	</div>
	<div id="chkArea"></div>
</form>
<%@include file="../include/footer.jsp" %>
</body>
</html>
