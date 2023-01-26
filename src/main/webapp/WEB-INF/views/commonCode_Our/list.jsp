<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" />

<div class="container">
    <%-- form 1 --%>
    <form action="/commoncodeour/deleteMulti" method="post">
        <%-- Just Link --%>
        <a href="/commoncodeour/form" class="btn btn-info">form</a>
        <a href="/commoncodeour/formMulti" class="btn btn-info">formMulti</a>
        <%-- form 1 submit --%>
        <button class="btn btn-info" type="submit">Delete Multi</button>
        <table class="table table-striped table-hover table-bordered">
            <thead>
                <tr class="text-center">
                    <th><input type="checkbox" id="selectall"></th>
                    <th>코드 ID</th>
                    <th>코드명</th>
                    <th>부모 코드 ID</th>
                    <th>부모 코드 ID</th>
                </tr>
            </thead>
            <tbody> 
                <c:forEach items="${resultMap}" var="resultData" varStatus="loop">
                    <tr>
                        <td class="text-center">
                            <input type="checkbox" class="checkbox" name="COMMON_CODE_ID" value="${resultData.COMMON_CODE_ID}" />
                        </td>
                        <td>
                            <form action="/commoncodeour/edit/${resultData.COMMON_CODE_ID}" method="get">
                                <button class="btn btn-link viewPopup" type="submit">${resultData.COMMON_CODE_ID}</button>
                            </form>
                        </td>
                        <td>${resultData.NAME}</td>
                        <td class="text-center">
                            <div class="btn-group">
                                <button class="btn btn-outline-info" name="PARENT_COMMON_CODE_ID">
                                    ${resultData.PARENT_COMMON_CODE_ID}
                                </button>
                            </div>
                        </td>
                        <td>
                            <form action="/commoncodeour/delete/${resultData.COMMON_CODE_ID}" method="post">
                                <button class="btn btn-link viewPopup">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </form>
</div>
<!-- /.table-responsive -->
