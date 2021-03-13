// $(document).ready(function () {
// 	$('.pencil-icon').click( function() {
// 		if($(this).parents().siblings('input').is('[readonly]')){
// 			$(this).parents().siblings('input').prop('readonly', false);
// 		}
// 		else{
// 			$(this).parents().siblings('input').prop('readonly', true);
// 		}
// 	});

// });

function fasterPreview( uploader ) {
        if ( uploader.files && uploader.files[0] ){
              $('#profileImage').attr('src', 
                 window.URL.createObjectURL(uploader.files[0]) );
        }
}

$("#dp").change(function(){
        fasterPreview( this );
 });

