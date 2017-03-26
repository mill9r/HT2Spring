<%@include file="/WEB-INF/views/template/header.jsp" %>

<body>
<form:form action="${pageContext.request.contextPath}/main/editPerson/${person.id}" method="post"
           commandName="person" name="editForm" id="editForm">


    <div class="table-responsive col-md-6  col-md-offset-3">
        <table class="table table-bordered table-highlight">

            <tr>
                <th colspan="2"><p class="text-center" style="margin:0px">Информация о человеке</p></th>
            </tr>

            <tr>
                <th>Фамилия:</th>
                <td>
                    <div class="col-md-6">
                        <form:input name="surnameForm" path="surname" id="surname" class="form-control" value="${person.surname}"/>
                        <form:errors path="surname" commandName="person" cssStyle="color:#ff0000; "/>
                    </div>
                </td>
            </tr>

            <tr>
                <th>Имя:</th>
                <td>
                    <div class="col-md-6">
                        <form:input name="nameForm" path="name" id="name" class="form-control" value="${person.name}"/>
                        <form:errors path="name" commandName="person" cssStyle="color:#ff0000;"/>
                    </div>
                </td>

            </tr>

            <tr>
                <th>Отчество:</th>

                <td>
                    <div class="col-md-6">
                        <form:input name="middleNameForm" path="middlename" id="middlename" class="form-control"
                                    value="${person.middlename}"/>
                        <form:errors path="middlename" commandName="person" cssStyle="color:#ff0000;"/>
                    </div>
                </td>
            </tr>

            <tr>
                <th>Телефоны:</th>

                <td><c:choose>
                    <c:when test="${person.phones == null}">
                        <a href="#">Добавить</a>
                    </c:when>
                    <c:otherwise>
                        <table class="table-borderless">

                                <c:forEach items="${person.phones}" var="phones">
                                    <tr>
                                        <td>${phones.number}</td>
                                        <td class="col-md-3"><a
                                                href="<spring:url value="/main/editPhone/${phones.id}"/>">Редактировать</a>
                                        </td>
                                        <td><a href="<spring:url value="/main/deletePhone/${phones.id}"/>">Удалить</a>
                                        </td>

                                    </tr>
                                </c:forEach>

                        </table>
                        <a href="<spring:url value="/main/addPhone/${person.id}"/>">Добавить</a>
                    </c:otherwise>
                </c:choose>

                </td>
            </tr>

            <tr>
                <th colspan="2"><input type="submit" value="Сохранить" class="btn btn-default center-block">
                    <p class="text-center" style="margin:0px"><a href="<spring:url value="/"/>">Вернуться к
                        списку</a></p></th>

            </tr>
        </table>
    </div>
</form:form>
</body>
<%@include file="/WEB-INF/views/template/footer.jsp" %>

