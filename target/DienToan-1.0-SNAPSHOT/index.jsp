<!DOCTYPE html>
<html lang="en">
<head>
    <title>ACE in Action</title>
    <style type="text/css" media="screen">
      #editor {
        position: absolute;
        top: 0;
        right: 0;
        bottom: 0;
        left: 0;
      }
    </style>
</head>
<body>

<div id="editor"></div>

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
</body>
</html>