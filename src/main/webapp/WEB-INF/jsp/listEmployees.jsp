<html>
<body>
<h1> Employee Names </h1>
<!-- request is an already available object within jsp. this contatins whatever information was fed
from the controller.
model.addAttribute() can here be accessed using request.getAttribute() 
out is again an already available object which is the output stream for response object.

system.out.println writes to console output.
out.println (specifically in jsp scenario) writes to response output steam.
-->
<%@ page import="java.util.List" %>
 <% 
 for(String empName: (List<String>)request.getAttribute("employees")){
 //System.out.println(empName);
 out.println("<h3>"+empName+"</h3> <br/>");
 }
 %>
</body>
</html>