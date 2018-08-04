<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <title>Form</title>
    <meta charset="utf-8"/>
</head>

<body>
<form action="/project/upload" method="post" enctype="multipart/form-data">

    <input type="file" name="image"><br/>
    <input type="submit" value="Download File"><br/>
</form>
</body>
</html>