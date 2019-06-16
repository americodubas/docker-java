<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <title>Exam Browser</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>
        <s:form action="save" theme="simple">
            <div class="container">

                <div class="form-group">
                    <h1>Exam:</h1>
                </div>
                <div class="form-group">
                    <label>ID</label>
                    <s:textfield name="exam.id" id="id" cssClass="form-control" readonly="true"/>
                </div>
                <div class="form-group">
                    <label for="name">Name</label>
                    <s:textfield name="exam.name" id="name" cssClass="form-control" maxlength="255" required="true"/>
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <s:textarea name="exam.description" id="description" cssClass="form-control"/>
                </div>

                <input type="submit" value="Save" class="btn btn-lg btn-success"/>
                <input type="button" value="Cancel" onclick="browserExam();" class="btn btn-lg btn-danger"/>

            </div>
        </s:form>
    </body>

    <script>

        var saveExam = function() {
            document.forms[0].action ="save";
            document.forms[0].submit();
        };

        var browserExam = function() {
            document.forms[0].action ="browser";
            document.forms[0].submit();
        };

    </script>

</html>
