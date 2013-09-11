package models

class PollModel {
	var id: Int =_
	var title: String =_
	var description: String =_
	var questions: List[Question] =_
}

object PollModel {
 
	def apply(id: Int = 0, title: String = "", description: String = "", questions: List[Question] = List()) = {
		val poll = new PollModel
		poll.id = id
		poll.title = title
		poll.description = description
		poll.questions = questions.filter(q => !(q.text.isEmpty || q.answers.isEmpty))
		poll
	}
	
	def unapply(poll : PollModel) = Some(poll.id, poll.title, poll.description, poll.questions)
 
}