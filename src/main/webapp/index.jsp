<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Challenge</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="main.css">
</head>
<body onload="load()">
<form id="compile-form">
    <div id="exercise">
        <div id="select__part">
            <select id="part">
                <!--<option value="1">Bài 1</option>
                <option value="2">Bài 2</option>-->
                <tbody id="__part"></tbody>
            </select>
        </div>
        <div id="div__desc">
            <textarea name="result" id="desc" readonly style="resize: none;"></textarea>
        </div>
        <div id="div__in__out">
            <table style="width: 100%">
                <tr>
                    <th>Input</th>
                    <th>Output</th>
                </tr>
                <tr>
                    <!--<td>Input</td>
                    <td>Output</td>-->
                    <tbody id="in-out"></tbody>
                </tr>
            </table>
        </div>
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
              <select name="language" id="language" onchange="changeLanguage()">
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
<script src="js/ext-language_tools.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="js/mode-csharp.js" type="text/javascript" charset="utf-8"></script>
<script src="js/mode-javascript.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
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
<script type="text/javascript" charset="utf-8">
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
<script type="text/javascript" charset="utf-8">
    function changeLanguage() {
      if ($('#language').val() === 'Java') {
        editor.session.setMode("ace/mode/javascript");
      }
      else {
        editor.session.setMode("ace/mode/csharp");
      }
    }
</script>
<script type="text/javascript" charset="utf-8">
    function load() {
      $.ajax({
        method:"POST",
        url:"/load",
        success: function (data) {
          $('#__part').append(data.toString());
          alert(data.toString())
        }
      })
    }
</script>
</body>
</html>