package controllers

import play.api._
import play.api.mvc._
import models._

object Application extends Controller {

	val polls = List(
		PollModel(1, "What Element Are You?", "Description", List(
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
		)),
		PollModel(2, "What Element Are You?", "Description", List(
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
		)),
		PollModel(3, "What Element Are You?", "Description", List(
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
	)
	
	def index = Action {
		
		Ok(views.html.index(polls))
	}
	
	def admin = Action {
		Ok(views.html.admin(polls))
	}
  
}