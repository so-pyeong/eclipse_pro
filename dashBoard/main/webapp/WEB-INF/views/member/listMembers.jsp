<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-10-14
  Time: 오후 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>회원 목록</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
    />
</head>
<body>
<div class="container text-center">
    <div class="row justify-content-sm-center" style="margin: 30px; width: 800px">
        <div class="col-9 text-start text-primary">
            <ul>
                <li><h3>회원 목록</h3></li>
            </ul>
        </div>
        <table class="table">
            <thead>
            <tr class="table-info">
                <th scope="col">아이디</th>
                <th scope="col">비밀번호</th>
                <th scope="col">이름</th>
                <th scope="col">이메일</th>
                <th scope="col">가입일</th>
                <th scope="col">수정</th>
                <th scope="col">삭제</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="member" items="${membersList}">
                <tr>
                    <td>${member.id}</td>
                    <td>${member.pwd}</td>
                    <td>${member.name}</td>
                    <td>${member.email}</td>
                    <td>${member.joinDate}</td>
                    <td><a href="${contextPath}/member/editMember.do?id=${member.id}">수정하기</a></td>
                    <td><a href="${contextPath}/member/removeMember.do?id=${member.id}">삭제하기</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"
></script>
</html>
