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

