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
    <title>Board View</title>
</head>

<body>
    <div class="container">
        ${boardBean}
        <div class="fs-3 my-3">
            Board View
        </div>
        <div class="fs-3 my-3">
            ${boardBean.title}
        </div>
        <div class="fs-6 my-3">
            <span>${boardBean.userName}</span>
            <span>|</span>
            <span>${boardBean.date}</span>
        </div>
        <div class="fs-6 my-3">
            ${boardBean.content}
        </div>
        <div class="my-3 text-center d-flex justify-content-center">
            <a href="/board/list" class="btn btn-primary mx-3">Go list</a>
            <form action="/board/edit" method="post" class="mx-3">
                <button class="btn btn-primary">Edit</button>
            </form>
        </div>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>

</html>