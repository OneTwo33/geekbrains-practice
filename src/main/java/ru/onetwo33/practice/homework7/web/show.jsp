<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Student</h1>
    <table >
        <tr>
            <td></td>
            <td>${student.id}</td>
        </tr>
        <tr>
            <td>Name : </td>
            <td>${student.name}</td>
        </tr>
        <tr>
            <td>Age :</td>
            <td>${student.age}</td>
        </tr>
    </table>