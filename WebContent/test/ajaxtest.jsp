<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
	function test1() {
		
		var xhttp = new XMLHttpRequest();
		
		//아래 함수는 통신이 끝나면 콜백
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				//document.getElementById("demo").innerHTML = this.responseText;
				if(this.responseText === 'ok'){
					var data = this.responseText;
					
					var box = document.querySelector("#box");
					box.innerHTML = data + " ::::: XMLHttpRequest Test 성공";
				}else{
					alert("통신실패");
				}
			}
		};
		
		xhttp.open("GET", "http://localhost:8080/blog/ajax", true);
		xhttp.send();
	}
	
	function test2() {
		$.ajax("http://localhost:8080/blog/ajax").done(function(data){
			var box = document.querySelector("#box");
			box.innerHTML = data + " ::::: ajax Test 성공";
		});
	}
	
	function test3() {
		fetch("http://localhost:8080/blog/ajax").then(function(data){
			return data.text();
		}).then(function(data){
			var box = document.querySelector("#box");
			box.innerHTML = data + " ::::: fetch Test 성공";
		});
	}
</script>

<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<button onclick="test1();">XMLHttpRequest Test</button> <br>
	<button onclick="test2();">ajax Test</button> <br>
	<button onclick="test3();">fetch Test</button>
	<div id="box"></div>
</body>
</html>