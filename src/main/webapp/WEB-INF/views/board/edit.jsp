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
    <title>Board Edit</title>
</head>

<body>
    <div class="container">
        <div class="fs-3">
            Board Edit
        </div>
        <form action="/board/form" method="post">
            <div class="form-floating my-3">
                <input type="text" class="form-control" placeholder="Title" id="title" name="title" value="${boardBean.title}">
                <label for="title">Title</label>
            </div>
            <div class="form-floating my-3">
                <textarea class="form-control" placeholder="Leave a comment here" id="content"
                    style="height: 20vw;">${boardBean.content}</textarea>
                <label for="content">Content</label>
            </div>
            <div class="form-floating my-3">
                <input type="text" class="form-control" placeholder="Writer" id="writer" name="writer" value="${boardBean.userName}">
                <label for="writer">Writer</label>
            </div>
            <div class="form-floating my-3">
                <input type="date" class="form-control" placeholder="Date" id="date" name="date" value="${boardBean.date}">
                <label for="date">Date</label>
            </div>
            <div class="my-3">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>

</html>