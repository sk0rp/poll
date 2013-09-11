$(document).ready(function(){
	var getQuestionId = function(oDiv) {
		return parseInt(oDiv.find('.questionCount').val(), 10);
	};

	
	var incrementId = function(oDiv) {
		var newId = getQuestionId(oDiv) + 1;
		
		oDiv.find('input:text').each(function() {
			$(this).prop('name', $(this).prop('name').replace(/([\d])+/, newId));
		});
		oDiv.find('.questionCount').val(newId);
	};
	
	var addAnswer = function() {
		var count = $(this).parent().parent().find('.questionCount').val();
		$('<input type="text" name="poll.question[' + count + '].answer[]" style="display: block" />').fadeIn('slow').appendTo($(this).parent().parent().find('.answers'));
	};
    $('.addAnswer').click(addAnswer);
	
	var addQuestion = function() {
		var prev = $(this).parent().parent();
		var id = getQuestionId(prev) + 1;
		prev.nextAll().each(function() {
			incrementId($(this));
		});
        var divQuestion = $('<div class="question" />');
		divQuestion.append($('<input type="text" name="poll.question[' + id + '].question" class="questionInput" />'));
		divQuestion.append($('<input type="hidden" name="questionCount" value="' + id + '" class="questionCount" />'));
		var divAnswersCont = $('<div class="answersCont" />');
		var divField = $('<div class="field">');
		divField.append($('<input type="checkbox" name="poll.question[' + id + '].multiple" id="poll.question[' + id + '].multiple" class="checkbox" />'));
		divField.append($('<label for="poll.question[' + id + '].multiple" class="label_checkbox">Allow Multiple Answer Selection</label>'));
		var divAnswers = $('<div class="answers" />');
		divAnswers.append($('<input type="text" name="poll.question[' + id + '].answer[]" />'));
		divAnswersCont.append(divField);
		divAnswersCont.append(divAnswers);
		divQuestion.append(divAnswersCont);
		var divQuestionsButtons = $('<div class="questionsButtons" />');
		var buttonAddAnswer = $('<input type="button" value="New Answer" class="button addAnswer" />').click(addAnswer);
		var buttonAddQuestion = $('<input type="button" value="Add New Question Bellow" class="button addQuestion" />').click(addQuestion);
		divQuestionsButtons.append(buttonAddAnswer);
		divQuestionsButtons.append(buttonAddQuestion);
		divQuestion.append(divQuestionsButtons);
		(prev).after(divQuestion.fadeIn('slow'));
		
    };
	$('.addQuestion').click(addQuestion);

	var delQuestion = function() {
		$(this).parent().parent().remove();
	};
    $('.delQuestion').click(delQuestion);
 
});