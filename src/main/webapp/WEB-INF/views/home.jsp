<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Spring MVC - 홈</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Spring Framework 학습 프로젝트</h1>
        <p>${message}</p>

        <h2>학습 메뉴</h2>
        <ul>
            <li><a href="${pageContext.request.contextPath}/user/list">사용자 관리 (CRUD 예제)</a></li>
        </ul>

        <h2>기술 스택</h2>
        <table>
            <tr><th>분류</th><th>기술</th></tr>
            <tr><td>프레임워크</td><td>Spring MVC 5.3</td></tr>
            <tr><td>DB (선택 1)</td><td>PostgreSQL 42.x</td></tr>
            <tr><td>DB (선택 2)</td><td>Oracle (ojdbc8)</td></tr>
            <tr><td>뷰</td><td>JSP + JSTL</td></tr>
            <tr><td>DB 접근</td><td>Spring JdbcTemplate</td></tr>
            <tr><td>빌드</td><td>Maven</td></tr>
            <tr><td>WAS</td><td>Apache Tomcat</td></tr>
        </table>
    </div>
</body>
</html>
