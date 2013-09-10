$(document).ready(function(){
    var i = $('#questions input.questionInput').length;
	
	var addAnswer = function() {
		var count = $(this).parent().parent().find('.questionCount').val();
		$('<input type="text" name="poll.question[' + count + '].answer[]" style="display: block" />').fadeIn('slow').appendTo($(this).parent().parent().find('.answers'));
	}
    $('.addAnswer').click(addAnswer);
	
	$('.addQuestion').click(function() {
        var divQuestion = $('<div class="question" />');
		divQuestion.append($('<input type="text" name="poll.question[' + i + '].question" class="questionInput" />'));
		divQuestion.append($('<input type="hidden" name="questionCount" value="' + i + '" class="questionCount" />'));
		var spanQuestionsButtons = $('<span class="questionsButtons" />');
		var buttonAddAnswer = $('<input type="button" value="Add more answers" class="button addAnswer" />').click(addAnswer);
		var buttonDelQuestion = $('<input type="button" value="Delete question" class="button delQuestion" />').click(delQuestion);
		spanQuestionsButtons.append(buttonAddAnswer);
		spanQuestionsButtons.append(buttonDelQuestion);
		divQuestion.append(spanQuestionsButtons);
		var divAnswers = $('<div class="answers" />');
		divAnswers.append($('<input type="text" name="poll.question[' + i + '].answer[]" />'));		
		divQuestion.append(divAnswers);
		divQuestion.fadeIn('slow').appendTo('#questions');
        i++;
    });

	var delQuestion = function() {
		$(this).parent().parent().remove();
	}
    $('.delQuestion').click(delQuestion);
 
});