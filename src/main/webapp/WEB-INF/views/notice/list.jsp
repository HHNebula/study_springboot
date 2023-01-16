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
    <title>Notice List</title>
</head>

<body>
    <div class="container">
        <%-- Title --%>
        <div class="fs-3 my-3" id="pageTitle">
            Notice List
        </div>

        <%-- List --%>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th scope="col">번호</th>
                    <th scope="col" class="col-9" scope=>제목</th>
                    <th scope="col">작성자</th>
                    <th scope="col">작성일</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${noticeList}" var="notice" varStatus="status">
                    <tr>
                        <td scope="row">${notice.getuId()}</td>
                        <td><a href="/notice/view/${notice.getuId()}">${notice.getTitle()}</a></td>
                        <td>${notice.getWriter()}</td>
                        <td>${notice.getDate()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <%-- 게시글 등록하기 버튼 --%>
        <div class="my-3 text-center">
            <a href="/notice/form" class="btn btn-primary">등록하기</a>
        </div>

    </div> 

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>

</html>