<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>

   <body>
      <h2>Product Information</h2>
      <form:form method = "POST" action = "/productList" modelAttribute="productForm">
         <table>
            <tr>
               <td><form:label path = "title">title</form:label></td>
               <td><form:input path = "title" /></td>
            </tr>
            <tr>
               <td><form:label path = "cost">cost</form:label></td>
               <td><form:input path = "cost" /></td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>
      </form:form>
   </body>

</html>