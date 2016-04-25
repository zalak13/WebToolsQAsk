$(document).ready(function() {
	$("#postQuestion").hide();
		$.ajax({
            url : "getTopicsList.htm",
            data: { get_param: 'value' }, 
            dataType: 'json',
            success : function(data) {
            	$.each(data.results, function(index, element) {
            		//alert(element.topicName);
                    $('#Trial').append($('<li><a href="/topicQuestion.htm&topic='+element.topicName+'">'+element.topicName+'</a>', {
                        text: element.topicName
                    }));
                });
            }
        });
		
		
		$.ajax({
            url : "getTopQuestionsList.htm",
            questiondata: { get_param: 'value' }, 
            dataType: 'json',
            success : function(questiondata) {
            		alert(questiondata);
            		alert(questiondata.results);
            	$.each(questiondata.results, function(index, element) {
            		alert(element.questionTitle);
            		 $('#Topics').append($( {
                         text: element.questionTitle
                     }));
                    $('#questionDesc').append($('<li>', {
                        text: element.questionDesc
                    },'</li>'));
                    $('#postedBy').append($('<li>', {
                        text: element.postedBy
                    },'</li>'));
                    $('#AnswerList').append($('<li>', {
                        text: element.Answerdetails
                    },'</li>'));
                });
            }
        });
		
		$("#questionLink").click(function() {
			$("#topQuestions").hide();
			$("#postQuestion").show();
		    
		});
		
		$("#topQuestionsLink").click(function() {
			$("#topQuestions").show();
			$("#postQuestion").hide();
		    
		});
});

