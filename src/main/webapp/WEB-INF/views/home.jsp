<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<style>
    <%@include file="../styles/home_style.css"%>
</style>

<head>
	<title>Home</title>
</head>
<body>
<header><a href="/">HR Application</a>
    <select onchange="location = this.value;">
        <option><spring:message code="select.language"/></option>
        <option value="${pageContext.request.contextPath}?lang=ru">Ru</option>
        <option value="${pageContext.request.contextPath}?lang=en">En</option>
    </select>
</header>
<div class="main-block">
<div class="menu">
    <a class="menu-point" href="ViewUserForm">show Users Base</a>
    <a class="menu-point" href="ViewVacancyForm">show Vacancy Base</a>
    <a class="menu-point" href="ViewCandidateForm">show Candidates Base</a>
    <a class="menu-point" href="ViewSkillForm">show Skills Base</a>
    <a class="menu-point" href="InterviewView">show Interview Base</a>
    <a class="menu-point" href="ViewFeedbackForm">show Feedback Base</a>



</div>
</div>
<footer> by Team-3</footer>
</body>


</html>
