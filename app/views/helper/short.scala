package views.html.helper

object short {
	def apply(text: String, length: Int = 30, appendix: String = "...") = {
		if(text.size > length) {
			text.substring(0, length) + appendix
		} else {
			text
		}
	}
}