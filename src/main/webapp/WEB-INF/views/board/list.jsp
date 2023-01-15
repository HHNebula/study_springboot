<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <title>Document</title>
</head>

<body>
    <div class="container">
        <%-- Title --%>
        <div class="fs-3 my-3">
            Board List
        </div>
        <%-- Pulling Attribute --%>
        <div>
            <h3>Pulling Attributes</h3>
            <%-- Request Attribute 꺼내기 --%>
            <% String firstWithRequest = (String)request.getAttribute("firstString"); %>
            <%-- 위에서 꺼낸 firstWithRequest Attribute 출력 --%>
            <div>With Request.getAttribute : <%= firstWithRequest %></div>
            <%-- Spring 방식으로 꺼내기 --%>
            <div>With Get Value on Spring : ${firstString}, ${boardList}</div>
        </div>
        <%-- JSTL if --%>
        <div>
            <h3>jstl if</h3>
            <c:if test="${firstString eq 'firstValue'}"> 
                <div>Matching : String eq 'firstValue'</div>
            </c:if>
            <c:set var="firstString" value="good" />
            <c:if test="${firstString ne 'firstValue'}"> 
                <div>Matching : String eq 'good'</div>
            </c:if>
            <c:set var="num_first" value="5" />
            <c:if test="${num_first gt 5}">
                <div>greater than 5</div>
            </c:if>
        </div>
        <%-- JSTL switch --%>
        <div>
            <h3>jstl switch</h3>
            <c:choose>
                <c:when test="${num_first eq 3}">
                num_first 3이다
                </c:when>
                <c:when test="${num_first eq 5}">
                    num_first 5이다
                </c:when>
                <c:otherwise>
                    num_first 5보다 크다
                </c:otherwise>
            </c:choose>
        </div>
        <%-- JSTL for --%>
        <div>
            <%-- for문 --%>
            <%-- for(int i =0 ; i < boardList.size() ; i++)  { --%>
            <%-- BoardBean value = boardList.get(i); --%>
            <%-- } --%>

            <%-- for(BoardBean board: boardList)  { --%>
            <%-- board.getTitle() --%>
            <%-- } --%>
            <%-- 위에것들을 간편하게 --%>
            <c:forEach items="${boardList}" var="board" varStatus="status">
            <%-- 0부터 5까지  boardList가 value로 튀어나옴 --%>
                <div>
                    ${board.title} : ${status.count}, ${status.index}, ${status.first}, ${status.last}
                    <%-- first는 첫번째냐? 맞으면 true last도 마지막이냐? 맞으면 true --%>
                </div>
            </c:forEach>
        </div>

        <table class="table table-hover">
            <thead>
                <tr>
                    <th scope=>#</th>
                    <th class="col-9" scope=>Title</th>
                    <th scope="col">Writer</th>
                    <th scope="col">Date</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td scope="row">1</td>
                    <td>This is Title</td>
                    <td>Tom</td>
                    <td>2022-01-05</td>
                </tr>
                <tr>
                    <td scope="row">2</td>
                    <td>This is Title</td>
                    <td>Hardy</td>
                    <td>2022-01-06</td>
                </tr>
            </tbody>
        </table>
        <div class="my-3 text-center">
            <a href="/board/form" class="btn btn-primary">Create</a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>

</html>