package controllers

import play.api._
import play.api.mvc._
import models._


object Poll extends Controller {
	def index(pid: Long, qid: Int) = Action {
		val poll = PollModel(1, "What Element Are You?", Array(
			Question("How would you describe yourself (pick the words that MOST describes you)?",
				Array(
					"Responsible, leader-type",
					"Intellectual, funny",
					"Secretive, spiritual",
					"Kind-hearted, creative"
				)
			),
			Question("Something you would enjoy would be...",
				Array(
					"Working on your latest project",
					"Doing something Artsy or musical",
					"Researching something you enjoy",
					"Doing a quiet, private activity"
				)
			),
			Question("If you could pick an animal, which would you pick?",
				Array(
					"Dog or a Cat: much loved, no worries and fun loving!",
					"A dolphin or some kind of sea creature: loves the water, happy, smart",
					"Bald Eagle, or a Horse: adventurous, wild, free",
					"A Tiger or Falcon: left alone, brooding, deadly"
				)
			)
		))
		
		if (qid > poll.questions.size - 1) {
			Redirect(routes.Poll.thankyou(pid))
		} else {
			Ok(views.html.poll.index(poll, pid, qid))
		}
	}
	
	def thankyou(pid: Long) = Action {
		Ok(views.html.poll.thankyou(pid))
	}

}
