<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title><c:choose><c:when test="${empty user.id}">사용자 등록</c:when><c:otherwise>사용자 수정</c:otherwise></c:choose></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <div class="container">
        <h1>
            <c:choose>
                <c:when test="${empty user.id}">사용자 등록</c:when>
                <c:otherwise>사용자 수정</c:otherwise>
            </c:choose>
        </h1>

        <%-- 등록/수정 공통 폼: action과 hidden id로 구분 --%>
        <c:set var="formAction"
               value="${empty user.id ? '/user/register' : '/user/update'}"/>

        <form action="${pageContext.request.contextPath}${formAction}" method="post">
            <c:if test="${not empty user.id}">
                <input type="hidden" name="id" value="${user.id}">
            </c:if>

            <table>
                <tr>
                    <th>이름</th>
                    <td><input type="text" name="name" value="${user.name}" required></td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td><input type="email" name="email" value="${user.email}" required></td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td><input type="password" name="password" required></td>
                </tr>
            </table>
            <br>
            <button type="submit">
                <c:choose>
                    <c:when test="${empty user.id}">등록</c:when>
                    <c:otherwise>수정</c:otherwise>
                </c:choose>
            </button>
            <a href="${pageContext.request.contextPath}/user/list">목록으로</a>
        </form>
    </div>
</body>
</html>
