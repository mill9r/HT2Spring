<%@include file="/WEB-INF/views/template/header.jsp" %>

<body>
<div class="container">
    <table class="table table-bordered table-highlight">


        <tr>
            <th colspan="6"><a href="<spring:url value="/main/addPerson"/> "><p class="text-center" style="margin:0px">
                Добавить запись</p></a></th>
        </tr>
        <tr>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Отчество</th>
            <th>Телефон(ы)</th>
            <th></th>
            <th></th>
        </tr>


        <c:forEach items="${people}" var="person">
            <tr>
                <td>${person.surname}</td>
                <td>${person.name}</td>
                <td>${person.middlename}</td>
                <td><c:forEach items="${person.phones}" var="phones">
                    ${phones.number}<br>
                </c:forEach></td>
                <td><a href="<spring:url value="/main/editPerson/${person.id}"/> ">Редактировать</a></td>
                <td><a href="<spring:url value="/main/deletePerson/${person.id}"/> ">Удалить</a></td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
<%@include file="/WEB-INF/views/template/footer.jsp" %>
