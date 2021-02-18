(function (){

    var indexSlider = function(){
        
        $('#flexcontainer .flexslider .slides > li').css('height', $(window).height());	
        $(window).resize(function(){
            $('#flexcontainer .flexslider .slides > li').css('height', $(window).height());	
        });

        $(window).load(function () {
            $('.flexslider').flexslider();
        });

    };

    $(function(){
        indexSlider();

    });

}());