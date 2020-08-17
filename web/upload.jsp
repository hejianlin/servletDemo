<%--
  Created by IntelliJ IDEA.
  User: POI-TECH
  Date: 2020/8/15
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h1>Upload File</h1>
    <%--这里的action对应sevlet的url，这里的upload对应着sevlet的 /upload --%>
    <form action="upload" method="post" enctype="multipart/form-data">
      File : <input type="file" name="file"/>
      <input type="submit" value="上传"/>
    </form>
  </body>
</html>
