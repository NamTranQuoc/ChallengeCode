<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset='utf-8'>
  <meta http-equiv='X-UA-Compatible' content='IE=edge'>
  <title>Compile</title>
  <meta name='viewport' content='width=device-width, initial-scale=1'>
  <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
  <script src='main.js'></script>
</head>
<body>
  <form action="compile" method="POST">
    <div class="content">
      <div class="content__top">
        <textarea name="code" id="code"><c:out value='${RequestClass.getContent()}'/></textarea>
      </div>
      <div class="content__middle">
        <span id="btn__compiler">
          <input type="submit" name="compile" id="compile" value="compiler">
        </span>
        <span id="select__language">
          <select name="language">
            <option value="C#">C#</option>
            <option value="Java">Java</option>
          </select>
        </span>
      </div>
      <div class="content__bottom">
        <textarea name="result" id="result"><c:out value='${result}'/></textarea>
      </div>
    </div>
  </form>
</body>
</html>
