<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현 언어에서 사용되는 데이터</title>
</head>
<body>
  <h2>
    \${(10==10) && (20==20)} : ${(10==10)&&(20==20)}<br>
    \${(10==10) and (20!=20)} : ${(10==10) and (20!=20)}<br><br>
    
    \${(10==10) || (20!=30)} : ${(10==10)||(20!=30)}<br>
    </h2>
</body>
</html>