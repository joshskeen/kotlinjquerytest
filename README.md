## Jquery + Kotlin JS -> getting them to work together

1. `curl https://raw.githubusercontent.com/DefinitelyTyped/DefinitelyTyped/master/types/jquery/index.d.ts > jquery.d.ts`
2. install the typescript-to-kotlin converter: `npm -g install ts2kt` ( https://github.com/Kotlin/ts2kt )
3. convert jquery.d.ts to jquery.kt by running `ts2kt -d headers jquery.d.ts`
4. create a new kotlin project and target jslibs for the runtime
5. within the src directory, create 2 packages: `jslibs` and `jsheaders`
6. download jquery.js from https://jquery.com/download/ and place it in `jslibs`
7. move the jquery.kt header file you generated (should be in the headers dir where you ran ts2kt) to `jsheaders`
6. create a new html file within the kotlin project. the project should have an index.html file at the top level that includes the following:
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>kotlinjquerytest</title>
</head>
<body>

<script type="text/javascript" src="out/production/{name of project}/lib/kotlin.jslibs"></script>
<script type="text/javascript" src="out/production/{name_of_project}/jslibs/jquery-3.2.1.min.jslibs"></script>
<script type="text/javascript" src="out/production/{name_of_project}/{name_of_project}.jslibs"></script>
<div id="app" style="width:200px; height: 200px;border:1px solid red;"></div>

</body>
</html>
```
make sure to change name_of_project to... the name of the project you chose

7. create a kotlin file within source called Main.kt with the following:
```
fun jQuery(x: String) = jQuery(x, null as JQuery?)

fun main(args: Array<String>) {
    jQuery {
        Main.doApp()
    }
}

object Main {
    fun doApp() {
        val jQuery1 = jQuery("#app")
        jQuery1[0]?.innerHTML = "<p>hey!</p>"
    }
}

```
8. double click the index.html file
9. at the top right, select a browser icon to open the file
10. congrats!