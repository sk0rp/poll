package controllers

import play.api._
import play.api.mvc._

object Poll extends Controller {
	def index(pid: Long, qid: Int): Action[AnyContent] = Action {
		val poll = Map(
			"title" -> "What Element Are You?",
			"questions" -> Array(
				Map("question" -> "How would you describe yourself (pick the words that MOST describes you)?",
					"answers" -> Array(
						"Responsible, leader-type",
						"Intellectual, funny",
						"Secretive, spiritual",
						"Kind-hearted, creative"
					)
				),
				Map("question" -> "Something you would enjoy would be...",
					"answers" -> Array(
						"Working on your latest project",
						"Doing something Artsy or musical",
						"Researching something you enjoy",
						"Doing a quiet, private activity"
					)
				),
				Map("question" -> "If you could pick an animal, which would you pick?",
					"answers" -> Array(
						"Dog or a Cat: much loved, no worries and fun loving!",
						"A dolphin or some kind of sea creature: loves the water, happy, smart",
						"Bald Eagle, or a Horse: adventurous, wild, free",
						"A Tiger or Falcon: left alone, brooding, deadly"
					)
				)
			)
		)
		
		val pollTitle = poll("title").asInstanceOf[String]
		val questions = poll("questions").asInstanceOf[Array[Map[String, Any]]]
		
		if (qid > questions.size - 1) {
			Redirect(routes.Poll.thankyou(pid))
			
		} else {
			val question = questions(qid)("question").asInstanceOf[String]
			val answers = poll("questions").asInstanceOf[Array[Map[String, Any]]](qid)("answers").asInstanceOf[Array[String]]

			Ok(views.html.poll.index(poll, pid, qid, pollTitle, questions, question, answers))
		}
	}
	
	def thankyou(pid: Long) = Action {
		Ok(views.html.poll.thankyou(pid))
	}

}
