package models

case class Question(val text: String = "", val multiple: Boolean = false, val answers: List[String] = List())
