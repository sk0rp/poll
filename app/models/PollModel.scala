package models

class PollModel {
	var id: Int =_
	var title: String =_
	var questions: List[Question] =_
}

object PollModel {
 
	def apply(id: Int = 0, title: String = "", questions: List[Question] = List()) = {
		val poll = new PollModel
		poll.id = id
		poll.title = title
		poll.questions = questions.filter(q => !(q.text.isEmpty || q.answers.isEmpty))
		poll
	}
	
	def unapply(poll : PollModel) = Some(poll.id, poll.title, poll.questions)
 
}