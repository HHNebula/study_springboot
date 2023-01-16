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
    <title>Notice Form</title>
</head>

<body>
    <div class="container">
        <div class="fs-3 my-3">
            Notice Form
        </div>
        <form action="/notice/save" method="post">
            <div class="form-floating my-3">
                <input type="text" class="form-control" placeholder="uId" id="uId" name="uId">
                <label for="uId">번호</label>
            </div>
            <div class="form-floating my-3">
                <input type="text" class="form-control" placeholder="Title" id="title" name="title">
                <label for="title">제목</label>
            </div>
            <div class="form-floating my-3">
                <textarea class="form-control" placeholder="Leave a comment here" id="content" name="content"
                    style="height: 20vw;"></textarea>
                <label for="content">내용</label>
            </div>
            <div class="form-floating my-3">
                <input type="text" class="form-control" placeholder="Writer" id="writer" name="writer">
                <label for="writer">작성자</label>
            </div>
            <div class="form-floating my-3">
                <input type="date" class="form-control" placeholder="Date" id="date" name="date">
                <label for="date">작성일</label>
            </div>
            <div class="my-3">
                <button type="submit" class="btn btn-primary">등록하기</button>
            </div>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>

</html>