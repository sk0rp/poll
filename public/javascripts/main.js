$(document).ready(function(){
    var i = $('#questions input.questionInput').length;
	
	var addAnswer = function() {
		var count = $(this).parent().parent().find('.questionCount').val();
		$('<input type="text" name="poll.question[' + count + '].answer[]" style="display: block" />').fadeIn('slow').appendTo($(this).parent().parent().find('.answers'));
	}
    $('.addAnswer').click(addAnswer);
	
	var addQuestion = function() {
        var divQuestion = $('<div class="question" />');
		divQuestion.append($('<input type="text" name="poll.question[' + i + '].question" class="questionInput" />'));
		divQuestion.append($('<input type="hidden" name="questionCount" value="' + i + '" class="questionCount" />'));
		var divAnswersCont = $('<div class="answersCont" />');
		var divField = $('<div class="field">');
		divField.append($('<input type="checkbox" name="poll.question[' + i + '].multiple" id="poll.question[' + i + '].multiple" class="checkbox" />'));
		divField.append($('<label for="poll.question[' + i + '].multiple" class="label_checkbox">Allow Multiple Answer Selection</label>'));
		var divAnswers = $('<div class="answers" />');
		divAnswers.append($('<input type="text" name="poll.question[' + i + '].answer[]" />'));
		divAnswersCont.append(divField);
		divAnswersCont.append(divAnswers);
		divQuestion.append(divAnswersCont);
		var divQuestionsButtons = $('<div class="questionsButtons" />');
		var buttonAddAnswer = $('<input type="button" value="New Answer" class="button addAnswer" />').click(addAnswer);
		var buttonAddQuestion = $('<input type="button" value="Add New Question Bellow" class="button addQuestion" />').click(addQuestion);
		divQuestionsButtons.append(buttonAddAnswer);
		divQuestionsButtons.append(buttonAddQuestion);
		divQuestion.append(divQuestionsButtons);
		($(this).parent().parent()).after(divQuestion.fadeIn('slow'));
        i++;
    }
	$('.addQuestion').click(addQuestion);

	var delQuestion = function() {
		$(this).parent().parent().remove();
	}
    $('.delQuestion').click(delQuestion);
 
});