package controllers

import play.api._
import play.api.mvc._
import models._
import play.api.data._
import play.api.data.Forms._


object Poll extends Controller {
	def index(pid: Int, qid: Int) = Action {
		PollModel.findById(pid).map { poll =>
			if (qid > poll.questions.size - 1) {
				Redirect(routes.Poll.thankyou(pid))
			} else {
				Ok(views.html.poll.index(poll, pid, qid))
			}
		}.getOrElse(NotFound)
	}
	
	def thankyou(pid: Int) = Action {
		Ok(views.html.poll.thankyou(pid))
	}
	
	
	val editPollForm = Form(
		"poll" ->
			mapping(
				"id" -> number,
				"title" -> text,
				"description" -> text,
				"questions" -> list[Question](
					mapping(
						"question" -> text,
						"multiple" -> boolean,
						"answers" -> list(text)
					)((question, multiple, answers) => {
						val answersFiltered = answers.filter(!_.isEmpty)
						Question(question, multiple, answersFiltered)
					})(Question.unapply)
				)
			)((id, title, description, questions) => {
				val questionFiltered = questions.filter(q => !(q.text.isEmpty || q.answers.isEmpty))
				PollModel(id, title, description, questionFiltered)
			})(PollModel.unapply)
	)
	
	def pollnew = Action {
		val poll = PollModel()
		Ok(views.html.poll.polledit(poll, editPollForm, false))
	}
	
	def polledit(pid: Int) = Action {
		PollModel.findById(pid).map { poll =>
			Ok(views.html.poll.polledit(poll, editPollForm, false))
		}.getOrElse(NotFound)
	}
	
	def polleditpost(pid: Int) = Action { implicit request =>
		PollModel.findById(pid).map { poll =>
			editPollForm.bindFromRequest.fold(
				errors => Ok(views.html.poll.polledit(poll, errors, true)),
				poll => Ok(views.html.poll.polledit(poll, editPollForm, true))
			)
		}.getOrElse(NotFound)
	}
	
	def pollstat(pid: Int) = Action {
		PollModel.findById(pid).map { poll =>
			val stat = List(List(7, 3, 2, 10), List(8, 8, 0, 6), List(7, 2, 8, 5))
			Ok(views.html.poll.pollstat(poll, stat))
		}.getOrElse(NotFound)
	}

}
