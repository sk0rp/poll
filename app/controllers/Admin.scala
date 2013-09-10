package controllers

import play.api._

import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models._

object Admin extends Controller {

	val editPollForm = Form(
		"poll" ->
			mapping(
				"id" -> number,
				"title" -> text,
				"question" -> list[Question](
					mapping(
						"question" -> text,
						"answer" -> list(text)
					)(Question.apply)(Question.unapply)
				)
			)(PollModel.apply)(PollModel.unapply)
	)
	
	
	
	def polledit(pid: Int) = Action {
		val poll = PollModel(1, "What Element Are You?", List(
			Question("How would you describe yourself (pick the words that MOST describes you)?",
				List(
					"Responsible, leader-type",
					"Intellectual, funny",
					"Secretive, spiritual",
					"Kind-hearted, creative"
				)
			),
			Question("Something you would enjoy would be...",
				List(
					"Working on your latest project",
					"Doing something Artsy or musical",
					"Researching something you enjoy",
					"Doing a quiet, private activity"
				)
			),
			Question("If you could pick an animal, which would you pick?",
				List(
					"Dog or a Cat: much loved, no worries and fun loving!",
					"A dolphin or some kind of sea creature: loves the water, happy, smart",
					"Bald Eagle, or a Horse: adventurous, wild, free",
					"A Tiger or Falcon: left alone, brooding, deadly"
				)
			)
		))
	
		Ok(views.html.admin.polledit(poll, editPollForm, false))
	}
	
	
	def polleditpost(pid: Int) = Action { implicit request =>
		val poll = PollModel(1, "What Element Are You?", List(
			Question("How would you describe yourself (pick the words that MOST describes you)?",
				List(
					"Responsible, leader-type",
					"Intellectual, funny",
					"Secretive, spiritual",
					"Kind-hearted, creative"
				)
			),
			Question("Something you would enjoy would be...",
				List(
					"Working on your latest project",
					"Doing something Artsy or musical",
					"Researching something you enjoy",
					"Doing a quiet, private activity"
				)
			),
			Question("If you could pick an animal, which would you pick?",
				List(
					"Dog or a Cat: much loved, no worries and fun loving!",
					"A dolphin or some kind of sea creature: loves the water, happy, smart",
					"Bald Eagle, or a Horse: adventurous, wild, free",
					"A Tiger or Falcon: left alone, brooding, deadly"
				)
			)
		))
		
		editPollForm.bindFromRequest.fold(
			errors => Ok(views.html.admin.polledit(poll, errors, true)),
			poll => Ok(views.html.admin.polledit(poll, editPollForm, true))
		)
		
	}
}
