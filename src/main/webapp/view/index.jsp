<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <link rel="stylesheet" type="text/css" href="../css/tabs.css">
    <script src="../js/tabs.js"></script>
    <script>
        function openTab(evt, tabName) {
            var i, tabcontent, tablinks;
            tabcontent = document.getElementsByClassName("tabcontent");
            for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].style.display = "none";
            }
            tablinks = document.getElementsByClassName("tablinks");
            for (i = 0; i < tablinks.length; i++) {
                tablinks[i].className = tablinks[i].className.replace(" active", "");
            }
            document.getElementById(tabName).style.display = "block";
            evt.currentTarget.className += " active";
        }
    </script>
</head>
<body>
<form>
    <input type="submit" value="XML" name="command" formaction="../controller.do" formmethod="get">
    <input type="submit" value="CSV" name="command" formaction="../controller.do" formmethod="get">
</form>
<c:if test="${requestScope.get(\"taskList\")!=null}">
    Список задач:<br><br>
    <form>
        <table>
            <tr>
                <th>ID задачи</th>
                <th>Проект</th>
                <th>Задача</th>
                <th>Часы (план)</th>
                <th>Ресурсы, чел. (план)</th>
            </tr>

            <c:forEach var="TaskList" items="${requestScope.get(\"taskList\")}">
                <tr>
                    <td><input type="radio" name="taskId" value="${TaskList.getId()}"/>${TaskList.getId()}</td>
                    <td><c:out value="${TaskList.getProjectName()}"/></td>
                    <td><c:out value="${TaskList.getTaskName()}"/></td>
                    <td><c:out value="${TaskList.getLab()}"/></td>
                    <td><c:out value="${TaskList.getResource()}"/></td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" value="Просмотреть" name="command" formaction="../controller.do" formmethod="get"><br>
    </form>
    <br><br>
    <c:if test="${requestScope.get(\"reportList\")!=null}">
        <table>
            <tr>
                <th>Дата</th>
                <th>Затраченное время</th>
                <th>Необходимо часов</th>
                <th>Название проекта</th>
                <th>id задачи</th>
            </tr>

            <c:forEach var="ReportList" items="${requestScope.get(\"reportList\")}">
                <tr>
                    <td><c:out value="${ReportList.getDate()}"/></td>
                    <td><c:out value="${ReportList.getTime()}"/></td>
                    <td><c:out value="${ReportList.getLeftLabs()}"/></td>
                    <td><c:out value="${ReportList.getProjectName()}"/></td>
                    <td><c:out value="${ReportList.getTaskid()}"/></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <br><br><br>
    <div class="tab">
        <button class="tablinks" onclick="openTab(event, 'addTask')">Добавить задачу</button>
        <button class="tablinks" onclick="openTab(event, 'addReport')">Добавить отчёт</button>
        <button class="tablinks" onclick="openTab(event, 'searchReport')">Поиск отчёта</button>
    </div>

    <div id="addTask" class="tabcontent">
        <form>
            id:<br>
            <input type="number" name="taskIdAdd"><br>
            Название проекта:<br>
            <input type="text" name="projectNameAdd"><br>
            Название задачи:<br>
            <input type="text" name="taskNameAdd"><br>
            Необходимо часов:<br>
            <input type="number" name="labAdd"><br>
            Необходимо человек:<br>
            <input type="number" name="resourceAdd"><br>

            <input type="hidden" name="type" value="task">
            <input type="submit" value="Добавить" name="command" formaction="../controller.do" formmethod="get">
        </form>
    </div>

    <div id="addReport" class="tabcontent">
        <form>
            <div>
                Дата:<br>
                <input type="date" name="dateReportAdd"><br>
                Затраченное время:<br>
                <input type="number" name="time1ReportAdd" min="0" max="12">:<input type="number" name="time2ReportAdd"
                                                                                    min="0" max="59"><br>
                Осталось часов:<br>
                <input type="number" name="leftTimeReportAdd"><br>
                Название проекта:<br>
                <select name="projectNameReportAdd">
                    <c:forEach var="ProjectList" items="${requestScope.get(\"projectList\")}">
                        <option><c:out value="${ProjectList}"/></option>
                    </c:forEach>
                </select><br>
                ID задачи:<br>
                <select name="taskIdReportAdd">
                    <c:forEach var="TaskList" items="${requestScope.get(\"taskList\")}">
                        <option><c:out value="${TaskList.getId()}"/></option>
                    </c:forEach>
                </select><br>
                <input type="hidden" name="type" value="report">
                <input type="submit" value="Добавить" name="command" formaction="../controller.do" formmethod="get">
            </div>
        </form>
    </div>

    <div id="searchReport" class="tabcontent">
        <form>
        <select name="taskFieldSearch">
            <option>Nazvanie proekta</option>
            <option>ID zadachi</option>
            <option>Trudoemkost, fact</option>
            <option>Trudoemkost, ostatok</option>
        </select>
        <input type="text" name="taskQuerySearch">
        <input type="submit" value="Поиск" name="command" formaction="../controller.do" formmethod="get">
        </form>
        <br>
    </div>
</c:if>

<br><br><br>
<c:out value="${error}"></c:out>
<br><br><br>
</body>
</html>