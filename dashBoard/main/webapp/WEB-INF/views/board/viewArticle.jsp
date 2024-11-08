<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>글보기 창</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"/>
</head>
<body>
<div class="container">
  <div class="row" style="margin: 30px; width: 800px">
    <div class="text-primary text-center">
      <h3>상세 글보기</h3>
    </div>
    <form name="frm_article" method="get" action="${contextPath}/board/modifyArticle.do">
      <input type="hidden" name="articleNO" value="${articleView.articleNO}">
      <div class="row align-items-center" style="padding: 10px; margin-bottom: 30px">
        <div class="col-auto">
          <label class="col-form-label">글번호</label>
        </div>
        <div class="col-auto">
          <input class="form-control" type="text" value="${articleView.articleNO}" disabled readonly/>
        </div>
        <div class="col-auto">
          <label class="col-form-label">작성일</label>
        </div>
        <div class="col-auto">
          <input class="form-control" type="text" value="${articleView.writeDate}" disabled readonly/>
        </div>
      </div>
      <div class="mb-3">
        <label class="form-label text-start">글제목</label>
        <input name="title" type="text" class="form-control" value="${articleView.title}" />
      </div>
      <div class="mb-3">
        <label class="form-label">내용</label>
        <textarea name="content" class="form-control" rows="10">${articleView.content}</textarea>
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-center">
        <button class="btn btn-success me-md-2" type="submit">수정하기</button>
        <a href="${contextPath}/board/removeArticle.do?articleNO=${articleView.articleNO}">
          <button class="btn btn-danger" type="button">삭제하기</button>
        </a>
        <a href="${contextPath}/board/listArticles.do">
          <button class="btn btn-secondary" type="button">목록보기</button>
        </a>
      </div>
    </form>
    <%-- 수정(ver3) --%>
    <!-- 댓글 기능 구현 -->
    <div class="container mt-2">
      <div class="h4 pb-2 ps-2 text-primary-emphasis border-bottom border-danger">
        Comment
      </div>

      <c:forEach var="comment" items="${commentList}">
        <!-- 댓글 리스트 -->
        <form method="get" action="${contextPath}/comment/modifyComment.do">
          <input type="hidden" name="commentNO" value="${comment.commentNO}" />
          <input type="hidden" name="parentNO" value="${parentNO}" />
          <div class="row bg-warning-subtle mx-1 mb-0 p-2 border border-black">
            <div class="col">
              <h6><b>댓글번호 : ${comment.commentNO}(작성일 : ${comment.writeDate})</b></h6>
            </div>
            <div class="col">
              <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button class="btn btn-outline-success me-md-2 btn-sm" type="submit">수정</button>
                <a href="${contextPath}/comment/removeCommnet.do?commentNO=${comment.commentNO}&parentNO=${parentNO}">
                  <button class="btn btn-outline-danger btn-sm" type="button">삭제</button>
                </a>
              </div>
            </div>
          </div>
          <div class="row mx-1 mt-0 mb-2">
            <textarea class="border-top-0" name="content" class="form-control" rows="3">${comment.content}</textarea>
          </div>
        </form>
        <hr />
      </c:forEach>
      <!-- 댓글 작성 기능 -->
      <form method="get" action="${contextPath}/comment/addComment.do">
        <input type="hidden" name="parentNO" value="${parentNO}" />
        <div class="row bg-secondary-subtle mx-1 mb-0 border border-black mt-2 p-2">
          <div class="col">
            <h6><b>댓글 작성 창</b></h6>
          </div>
          <div class="col">
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
              <button class="btn btn-outline-primary btn-sm" type="submit">댓글저장</button>
            </div>
          </div>
        </div>
        <div class="row mx-1 mt-0">
          <textarea class="border-top-0" name="content" class="form-control" rows="4"></textarea>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>
