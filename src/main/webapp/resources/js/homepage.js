$(document).ready(
		function() {
			$("#postQuestion").hide();
			$.ajax({
				url : "getTopicsList.htm",
				data : {
					get_param : 'value'
				},
				dataType : 'json',
				success : function(data) {
					$.each(data.results, function(index, element) {
						// alert(element.topicName);
						$('#Trial').append(
								$('<li><a href="/topicQuestion.htm&topic='
										+ element.topicName + '">'
										+ element.topicName + '</a>', {
									text : element.topicName
								}));
					});
				}
			});

			$.ajax({
				url : "getTopQuestionsList.htm",
				questiondata : {
					get_param : 'value'
				},
				dataType : 'json',
				success : function(questiondata) {
					count = 1;
					$.each(questiondata.results, function(index, element) {

						// $('.container',

						$.each(element.questionTopics, function(index,
								subelement) {

							text: subelement.topicname
							$('#Topics').append($('<div>', {
								text : subelement.topicname
							}, '</div>'))
						}),

						/*
						 * $('#Topics').append($('<p>', { text:
						 * element.questionTopics },'</p>')),
						 */
						$('#questionId').append($('<li>', {
							text : element.questionId
						}, '</li>')), $('#questionTitle').append($('<li>', {
							text : element.questionTitle
						}, '</li>')), $('#questionDesc').append($('<li>', {
							text : element.questionDesc
						}, '</li>')), $('#postedBy').append($('<li>', {
							text : element.postedBy
						}, '</li>').appendTo(".container").before("<br/>")), $(
								'#AnswerList').append($('<li>', {
							text : element.Answerdetails
						}, '</li>'))

						// ).appendTo(".container").before("<br/>");
					});
					count++;
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

			/*			*//** Answer Btn * */
			/*
			 * $(document).on("click", ".commentBtn", function() {
			 * alert("Comment Click"); var sublings = "Ohhho "; //var dsbutton =
			 * $(this); var sublings = ('li.quid').siblings(); alert(sublings);
			 * var contents = ('ul').contents(); alert(contents); var questId =
			 * ('ul.qId').text(); var questionVal =
			 * $row.children('ul.qId').text(); alert(questId);
			 * alert(questionVal); //var parentTr =$(this).parent().parent();
			 * alert(questId); jQuery.ajax({ type: "POST", dataType: "html",
			 * url: "postAnswer.htm", data: "questionId="+questId, success:
			 * function(msg){ }, error: function(XMLHttpRequest, textStatus,
			 * errorThrown) { alert("error deleting trophy"); } }); });
			 */

		});
