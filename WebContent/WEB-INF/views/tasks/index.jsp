<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>なさねばならぬこと一覧</h2>
        <ul>
            <c:forEach var="task" items="${tasks}">
                <li>
                    <a href="${pageContext.request.contextPath}/show?id=${task.id}">
                        <c:out value="${task.id}" />
                    </a>
                    ：<c:out value="${task.content}" />
                </li>
            </c:forEach>
        </ul>

        <p><a href="${pageContext.request.contextPath}/new">なさねばならぬの投稿</a></p>

    </c:param>
</c:import>

<%--  &gt; は、greater thanをあらわす
<c:out value="${message.title}"></c:out> &gt; <c:out value="${message.content}" />
--%>