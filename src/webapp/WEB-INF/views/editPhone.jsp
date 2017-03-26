
<%@include file="/WEB-INF/views/template/header.jsp" %>

<body>
<form:form action="${pageContext.request.contextPath}/main/editPhone/${phone.owner.id}" method="post" commandName="phone">


    <div class="table-responsive col-md-6  col-md-offset-3">
        <table class="table table-bordered table-highlight">
            <form:hidden path="owner.id" value="${phone.owner.id}"/>
            <form:hidden path="id" value="${phone.id}"/>

            <tr>
                <th colspan="2"><p class="text-center" style="margin:0px">Информация о телефоне владельца: ${phone.owner.surname} ${phone.owner.name} ${phone.owner.middlename} </p></th>
            </tr>

            <tr>
                <th>Номер:</th>
                <td>
                    <div class="col-md-6">
                        <form:input path="number" id="number" class="form-control" value="${phone.number}"/>
                        <sf:errors path="number" cssStyle="color:#ff0000;"/>
                    </div>
                </td>
            </tr>

            <tr>
                <th colspan="2"><input type="submit" value="Сохранить номер" class="btn btn-default center-block">
                    <p class="text-center" style="margin:0px"><a href="#" onclick="goBack();return false">Вернуться к
                        данным о человеке</a></p></th>

            </tr>
        </table>
    </div>
</form:form>
</body>
<%@include file="/WEB-INF/views/template/footer.jsp" %>
