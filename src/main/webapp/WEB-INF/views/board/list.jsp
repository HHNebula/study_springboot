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
    <title>Board List</title>
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
            <%-- 위 내용을 이렇게 --%>
            <c:forEach items="${boardList}" var="board" varStatus="status">
            <%-- 0 ~ 5 까지 boardList 가 value 로 출력 --%>
                <div>
                    ${board.title} : ${status.count}, ${status.index}, ${status.first}, ${status.last}
                    <%-- first == true / last == true --%>
                </div>
            </c:forEach>
        </div>

        <%-- 게시글 목록 = BoardList --%>
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
                    <td scope=>1</td>
                    <td><a href="/board/view?title=또 북한발 해킹?... daum아닌 daurn에서 메일 오면 주의">또 북한발 해킹?... "daum"아닌 "daurn"에서 메일 오면 주의</a></td>
                    <td>Tom</td>
                    <td>2022-01-05</td>
                </tr>
                <tr>
                    <td scope=>2</td>
                    <td><a href="/board/view?title=네이버 기술로 혁신, 2024년 흑자 만들겠다">네이버 기술로 혁신, 2024년 흑자 만들겠다</a></td>
                    <td>Hardy</td>
                    <td>2022-01-06</td>
                </tr>
                <tr>
                    <td scope=>3</td>
                    <td><a href="/board/view?title=韓 원자력 UAE 수출 6개월 빨라진다">韓 원자력 UAE 수출 6개월 빨라진다</a></td>
                    <td>Jasco</td>
                    <td>2022-01-06</td>
                </tr>
            </tbody>
        </table>

        <%-- 게시글 등록하기 버튼 --%>
        <div class="my-3 text-center">
            <a href="/board/form" class="btn btn-primary">Create</a>
        </div>

    </div> 

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>

</html>