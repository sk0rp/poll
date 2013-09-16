package controllers

import play.api._
import play.api.mvc._
import models._
import play.api.data._
import play.api.data.Forms._


object Poll extends Controller {
	def index(pid: Int, qid: Int) = Action {
		val poll = PollModel(1, "What Element Are You?", "Description", List(
			Question("How would you describe yourself (pick the words that MOST describes you)?",
				false,
				List(
					"Responsible, leader-type",
					"Intellectual, funny",
					"Secretive, spiritual",
					"Kind-hearted, creative"
				)
			),
			Question("Something you would enjoy would be...",
				false,
				List(
					"Working on your latest project",
					"Doing something Artsy or musical",
					"Researching something you enjoy",
					"Doing a quiet, private activity"
				)
			),
			Question("If you could pick an animal, which would you pick?",
				false,
				List(
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
	
	def thankyou(pid: Int) = Action {
		Ok(views.html.poll.thankyou(pid))
	}
	
	
	val editPollForm = Form(
		"poll" ->
			mapping(
				"id" -> number,
				"title" -> text,
				"description" -> text,
				"question" -> list[Question](
					mapping(
						"question" -> text,
						"multiple" -> boolean,
						"answer" -> list(text)
					)(Question.apply)(Question.unapply)
				)
			)(PollModel.apply)(PollModel.unapply)
	)
	
	def pollnew = Action {
		val poll = PollModel()
		Ok(views.html.poll.polledit(poll, editPollForm, false))
	}
	
	def polledit(pid: Int) = Action {
		val poll = PollModel(1, "What Element Are You?", "Description", List(
			Question("How would you describe yourself (pick the words that MOST describes you)?",
				false,
				List(
					"Responsible, leader-type",
					"Intellectual, funny",
					"Secretive, spiritual",
					"Kind-hearted, creative"
				)
			),
			Question("Something you would enjoy would be...",
				false,
				List(
					"Working on your latest project",
					"Doing something Artsy or musical",
					"Researching something you enjoy",
					"Doing a quiet, private activity"
				)
			),
			Question("If you could pick an animal, which would you pick?",
				false,
				List(
					"Dog or a Cat: much loved, no worries and fun loving!",
					"A dolphin or some kind of sea creature: loves the water, happy, smart",
					"Bald Eagle, or a Horse: adventurous, wild, free",
					"A Tiger or Falcon: left alone, brooding, deadly"
				)
			)
		))
	
		Ok(views.html.poll.polledit(poll, editPollForm, false))
	}
	
	
	def polleditpost(pid: Int) = Action { implicit request =>
		val poll = PollModel(1, "What Element Are You?", "Description", List(
			Question("How would you describe yourself (pick the words that MOST describes you)?",
				false,
				List(
					"Responsible, leader-type",
					"Intellectual, funny",
					"Secretive, spiritual",
					"Kind-hearted, creative"
				)
			),
			Question("Something you would enjoy would be...",
				false,
				List(
					"Working on your latest project",
					"Doing something Artsy or musical",
					"Researching something you enjoy",
					"Doing a quiet, private activity"
				)
			),
			Question("If you could pick an animal, which would you pick?",
				false,
				List(
					"Dog or a Cat: much loved, no worries and fun loving!",
					"A dolphin or some kind of sea creature: loves the water, happy, smart",
					"Bald Eagle, or a Horse: adventurous, wild, free",
					"A Tiger or Falcon: left alone, brooding, deadly"
				)
			)
		))
		
		editPollForm.bindFromRequest.fold(
			errors => Ok(views.html.poll.polledit(poll, errors, true)),
			poll => Ok(views.html.poll.polledit(poll, editPollForm, true))
		)
		
	}
	
	def pollstat(pid: Int) = Action {
		val poll = PollModel(1, "What Element Are You?", "Description", List(
			Question("How would you describe yourself (pick the words that MOST describes you)?",
				false,
				List(
					"Responsible, leader-type",
					"Intellectual, funny",
					"Secretive, spiritual",
					"Kind-hearted, creative"
				)
			),
			Question("Something you would enjoy would be...",
				false,
				List(
					"Working on your latest project",
					"Doing something Artsy or musical",
					"Researching something you enjoy",
					"Doing a quiet, private activity"
				)
			),
			Question("If you could pick an animal, which would you pick?",
				false,
				List(
					"Dog or a Cat: much loved, no worries and fun loving!",
					"A dolphin or some kind of sea creature: loves the water, happy, smart",
					"Bald Eagle, or a Horse: adventurous, wild, free",
					"A Tiger or Falcon: left alone, brooding, deadly"
				)
			)
		))
	
		val stat = List(List(7, 3, 2, 10), List(8, 8, 0, 6), List(7, 2, 8, 5))
		
		Ok(views.html.poll.pollstat(poll, stat))
	}

}
