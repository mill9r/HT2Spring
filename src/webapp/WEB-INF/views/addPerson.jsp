<%@include file="/WEB-INF/views/template/header.jsp" %>

<body>
<form:form action="${pageContext.request.contextPath}/main/addPerson" method="POST" commandName="person">


    <div class="table-responsive col-md-6  col-md-offset-3">
        <table class="table table-bordered table-highlight">

            <tr>
                <th colspan="2"><p class="text-center" style="margin:0px">Информация о человеке</p></th>
            </tr>

            <tr>
                <th><label for="surname">Фамилия: </label></th>
                <td>
                    <div class="col-md-6">
                        <form:input path="surname" id="surname" class="form-control"/>
                        <form:errors path="surname" cssStyle="color:#ff0000;"/>
                    </div>
                </td>
            </tr>

            <tr>
                <th>Имя:</th>
                <td>
                    <div class="col-md-6">
                        <form:input path="name" id="name" class="form-control"/>
                        <form:errors path="name" cssStyle="color:#ff0000;"/>
                    </div>
                </td>

            </tr>

            <tr>
                <th>Отчество:</th>

                <td>
                    <div class="col-md-6">
                        <form:input path="middlename" id="middlename" class="form-control"/>
                        <form:errors path="middlename" cssStyle="color:#ff0000;"/>
                    </div>
                </td>
            </tr>

            <tr>
                <th colspan="2"><input type="submit" value="Добавить" class="btn btn-default center-block">
                    <p class="text-center" style="margin:0px"><a href="<spring:url value="/"/>">Вернуться к
                        списку</a></p></th>

            </tr>
        </table>
    </div>
</form:form>

</body>
<%@include file="/WEB-INF/views/template/footer.jsp" %>

