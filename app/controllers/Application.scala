package controllers

import play.api._
import play.api.mvc._
import models._

object Application extends Controller {

	def index = Action {
		val polls = PollModel.findAll;
		Ok(views.html.index(polls))
	}
	
	def admin = Action {
		val polls = PollModel.findAll;
		Ok(views.html.admin(polls))
	}
  
}