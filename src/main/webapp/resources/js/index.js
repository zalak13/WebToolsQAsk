$('.form').find('input, textarea').on('keyup blur focus', function (e) {
  
  var $this = $(this),
      label = $this.prev('label');

	  if (e.type === 'keyup') {
			if ($this.val() === '') {
          label.removeClass('active highlight');
        } else {
          label.addClass('active highlight');
        }
    } else if (e.type === 'blur') {
    	if( $this.val() === '' ) {
    		label.removeClass('active highlight'); 
			} else {
		    label.removeClass('highlight');   
			}   
    } else if (e.type === 'focus') {
      
      if( $this.val() === '' ) {
    		label.removeClass('highlight'); 
			} 
      else if( $this.val() !== '' ) {
		    label.addClass('highlight');
			}
    }

});

$('.tab a').on('click', function (e) {
  
  e.preventDefault();
  
  $(this).parent().addClass('active');
  $(this).parent().siblings().removeClass('active');
  
  target = $(this).attr('href');

  $('.tab-content > div').not(target).hide();
  
  $(target).fadeIn(600);
  
});


$(document).ready(function() {
    $("#emailaddress").blur(function() {
        $.ajax({
            url : "checkEmailAddress.htm?email=" + $("#emailaddress").val(),
            success : function(result) {
                $("#errorMsg").html(result);
                if (result != '') {
                	label.removeClass('active highlight');
                	label.removeClass('highlight');
                	$("#errorMsg").html("Email Address");
                } else {
                 	//$("#errorMsg").html("Email Address");
                	label.addClass('active highlight');
                }
            }
        });
    });
});