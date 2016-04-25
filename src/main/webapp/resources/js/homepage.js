$(document).ready(function() {
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
});