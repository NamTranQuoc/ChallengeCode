<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>ACE in Action</title>
    <link rel="stylesheet" href="main.css">
</head>
<body>
<form id="compile-form">
    <div id="exercise">

    </div>
    <div class="content">
        <div class="content__top">
            <div id="editor"></div>
        </div>
        <div class="content__middle">
            <div>
              <input type="submit" name="compile" id="btn-compile" value="RUN">
            </div>
            <div>
              <select name="language", id="language">
                <option value="C#">C#</option>
                <option value="Java">Java</option>
              </select>
            </div>
        </div>
        <div class="content__bottom">
            <textarea name="result" id="result" readonly></textarea>
            <div id="loader" style="display: none"></div>
        </div>
    </div>
</form>

<script src="js/ace.js" type="text/javascript" charset="utf-8"></script>
<script src="js/ext-language_tools.js"></script>
<script src="js/jquery.js"></script>
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
  $(document).ready(function() {
    $('#btn-compile').click(function(e) {
      e.preventDefault();

      $.ajax({
        method:"POST",
        url:"/compile",
        data: {
          code: editor.getValue(),
          language: $('#language').val()
        },
        beforeSend: function (){
          $("#loader").show();
        },
        complete: function (){
          $("#loader").hide();
        },
        success: function (data) {
          $('#result').val(data.toString())
        }
      })
    });
  });
</script>
</body>
</html>