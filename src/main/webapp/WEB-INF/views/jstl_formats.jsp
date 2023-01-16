<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>jstl Formats</title>
</head>
<body>
    <div>jstl Formats</div>
    <div>형식 바꾸기</div>
    <div>
        <div>
            2023.01.16 10:18:50 --> 2023 1 16
        </div>
        <div>
            234124.12 --> 234,124.12
        </div>
    </div>
    <hr>
    <div>Number Formats</div>
    <%-- 넘버포멧에 사용할 변수와 값 선언 --%>
    <c:set var="num_first" value="1234567.89" />
    <c:set var="num_second" value="0.125" />
    <%-- 어떤 값이 들어갈 것인지 value --%>
    <%-- 어떤 형식으로 변경할 것인지 type --%>
    <div>1,000단위 구분 : <fmt:formatNumber value="${num_first}" type="number" /></div>
    <div>백분율 표시 1 : <fmt:formatNumber value="${num_first}" type="percent" /></div>
    <div>백분율 표시 2 : <fmt:formatNumber value="${num_second}" type="percent" /></div>
    <hr>
    <div>Date Formats</div>
    <c:set var="date_first" value="<%= new java.util.Date() %>" />
    <div>값 출력 : ${date_first}</div>
    <div>Time 출력 : <fmt:formatDate value="${date_first}" type="time" /></div>
    <div>Date 출력 : <fmt:formatDate value="${date_first}" type="date" /></div>
    <div>Both 출력 : <fmt:formatDate value="${date_first}" type="both" /></div>
    <hr>
    <div>Location Formats</div>
    <c:set var="num_thrid" value="1234567.89" />
    <c:set var="date_second" value="<%= new java.util.Date() %>" />
    <div>
        <div>로케이션 : 한국<fmt:setLocale value="ko-KR" scope="session" /> <%= response.getLocale() %></div>
        <div>통화 : <fmt:formatNumber value="${num_thrid}" type="currency" /></div>
        <div>날짜 : <fmt:formatDate value="${date_second}" type="both" /></div>
    </div>
    <div>
        <div>로케이션 : 일본<fmt:setLocale value="ja-JP" scope="session" /> <%= response.getLocale() %></div>
        <div>통화 : <fmt:formatNumber value="${num_thrid}" type="currency" /></div>
        <div>날짜 : <fmt:formatDate value="${date_second}" type="both" /></div>
    </div>
    <div>
        <div>로케이션 : 미국<fmt:setLocale value="en-US" scope="session" /> <%= response.getLocale() %></div>
        <div>통화 : <fmt:formatNumber value="${num_thrid}" type="currency" /></div>
        <div>날짜 : <fmt:formatDate value="${date_second}" type="both" /></div>
    </div>
</body>
</html>