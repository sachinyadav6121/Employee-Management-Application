<%@ page isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
   <c:when test="${!empty empsData }">  
     <table border="1" bgcolor="cyan" align="center">
         <tr>
            <th> empno</th><th> ename </th> <th> job </th> <th> salary </th> <th> deptno </th> <th> operations </th>
         </tr>
        <c:forEach var="emp" items="${empsData }">
           <tr>
             <td>${emp.empNo} </td>
             <td>${emp.ename} </td>
              <td>${emp.job} </td>
             <td>${emp.sal} </td>
              <td>${emp.deptno} </td>
              <td><a href="emp_edit?no=${emp.empNo}"><img src="resources/images/edit.png" width="30" height="30"></a>
                    <a href="emp_delete?no=${emp.empNo}" onclick="return confirm ('Do you want to delete')" ><img src="resources/images/delete.jpg" width="30" height="30" ></a>
                </td>
              
           </tr>
        </c:forEach>
      </table>
   
   </c:when>
   <c:otherwise>
          <h1 style="color:red;text-align:center">No records are found </h1>
   </c:otherwise>


</c:choose>
<br><br>
   <center> <h3 style="color:green;text-align:center">${resultMsg}</h3></a> </center>
   
<br><br>
 <center> <a href="./">home<img src="resources/images/home.jpg" width="40" heigth="50"> </a> </center>
  <br><br>
  
 <center> <a href="emp_add">Add/Register Employee<img src="resources/images/add.jpg" width="40" heigth="50"> </a> </center>
  <br><br>
 
  
 
