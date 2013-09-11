package models

class Question {
	var text: String =_
	var multiple: Boolean =_
	var answers: List[String] =_
}

object Question {
	def apply(text: String, multiple: Boolean = false, answers: List[String]) = {
		val question = new Question
		question.text = text
		question.multiple = multiple
		question.answers = answers.filter(!_.isEmpty)
		question
	}
	
	def unapply(question : Question) = Some(question.text, question.multiple, question.answers)
}
