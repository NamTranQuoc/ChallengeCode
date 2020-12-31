<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>ACE in Action</title>
    <link rel="stylesheet" href="main.css">
</head>
<body>
<form id="compile-form">
    <div class="content">
        <div class="content__top">
            <div id="editor"></div>
        </div>
        <div class="content__middle">
            <span id="btn__compiler">
              <input type="submit" name="compile" id="compile" value="RUN">
            </span>
                <span id="select__language">
              <select name="language">
                <option value="C#">C#</option>
                <option value="Java">Java</option>
              </select>
            </span>
        </div>
        <div class="content__bottom">
            <textarea name="result" id="result" readonly><c:out value='${result}'/></textarea>
        </div>
    </div>
</form>

<script src="js/ace.js" type="text/javascript" charset="utf-8"></script>
<script src="js/ext-language_tools.js"></script>
<script>
    ace.require("ace/ext/language_tools");
    var editor = ace.edit("editor");
    editor.session.setMode("ace/mode/csharp");

    editor.setTheme("ace/theme/twilight");
    editor.setOptions({
      enableBasicAutocompletion: true,
      enableSnippets: true,
      enableLiveAutocompletion: true
    });
</script>
<script>
  $('#compile-form').submit(function (e) {
    $ajax()
  });
</script>
</body>
</html>