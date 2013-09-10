package models

class Question {
	var text: String =_
	var answers: List[String] =_
}

object Question {
	def apply(text: String, answers: List[String]) = {
		val question = new Question
		question.text = text
		question.answers = answers.filter(!_.isEmpty)
		question
	}
	
	def unapply(question : Question) = Some(question.text, question.answers)
}
