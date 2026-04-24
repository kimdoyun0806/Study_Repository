<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>사용자 목록</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <div class="container">
        <h1>사용자 목록</h1>
        <a href="${pageContext.request.contextPath}/user/form">신규 등록</a>
        <hr>

        <c:choose>
            <c:when test="${empty userList}">
                <p>등록된 사용자가 없습니다.</p>
            </c:when>
            <c:otherwise>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>이름</th>
                            <th>이메일</th>
                            <th>관리</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${userList}">
                            <tr>
                                <td>${user.id}</td>
                                <td>${user.name}</td>
                                <td>${user.email}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/user/edit?id=${user.id}">수정</a>
                                    &nbsp;|&nbsp;
                                    <a href="${pageContext.request.contextPath}/user/delete?id=${user.id}"
                                       onclick="return confirm('삭제하시겠습니까?')">삭제</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>

        <br>
        <a href="${pageContext.request.contextPath}/">홈으로</a>
    </div>
</body>
</html>
