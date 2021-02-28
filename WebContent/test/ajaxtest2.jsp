<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
	function idCheck() {
		$.ajax("http://localhost:8080/blog/ajax").done(function(data){
			alert(data)
		});
	}
</script>

<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<button onclick="idCheck();">아이디 있니?</button>
	<div id="box"></div>
</body>
</html>