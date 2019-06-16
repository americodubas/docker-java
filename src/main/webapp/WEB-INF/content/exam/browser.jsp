<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <title>Exam Browser</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>
        <s:form action="browser" theme="simple">
            <input type="hidden" name="id" id="id"/>

            <div class="container">
                <h1>Exam Browser</h1>
                <hr>
                <s:textfield name="search" />
                <input type="button" value="Search" onclick="submit();" class="btn btn-sm btn-light"/>
                <input type="button" value="Insert" onclick="insertExam();" class="btn btn-sm btn-primary"/>
                <hr>
            </div>

            <div class="container">

                <table class="table table-bordered table-striped">

                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Actions</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${examList}" var="exam">

                            <tr>
                                <td><c:out value="${exam.id}"/></td>
                                <td><c:out value="${exam.name}"/></td>
                                <td><c:out value="${exam.description}"/></td>
                                <td>
                                    <input type="button" value="update" onclick="updateExam(${exam.id});" class="btn btn-sm btn-secondary"/>
                                    <input type="button" value="delete" onclick="deleteExam(${exam.id});" class="btn btn-sm btn-danger"/>
                                </td>
                            </tr>

                        </c:forEach>
                    </tbody>

                </table

            </div>
        </s:form>
    </body>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    <script>

        var insertExam = function() {
            document.getElementById("id").value = 0;
            document.forms[0].action = "update";
            document.forms[0].submit();
        }

        var updateExam = function(id) {
            document.getElementById("id").value = id;
            document.forms[0].action = "update";
            document.forms[0].submit();
        };

        var deleteExam = function(id) {
            document.getElementById("id").value = id;
            document.forms[0].action = "delete";
            document.forms[0].submit();
        };

    </script>
</html>
