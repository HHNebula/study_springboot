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
    <title>Notice View</title>
</head>

<body>
    <div class="container">
        <div class="fs-3 my-3">
            Notice View
        </div>
        <div class="fs-3 my-3">
            ${noticeBean.getTitle()}
        </div>
        <div class="fs-6 my-3">
            <span>${noticeBean.getWriter()}</span>
            <span>|</span>
            <span>${noticeBean.getDate()}</span>
        </div>
        <div class="fs-6 my-3">
            ${noticeBean.getContent()}
        </div>
        <div class="my-3 text-center d-flex justify-content-center">
            <a href="/notice/list" class="btn btn-primary mx-3">목록으로</a>
            <form action="/notice/edit/${noticeBean.getuId()}" method="post" class="mx-3">
                <button class="btn btn-primary">수정하기</button>
            </form>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>

</html>