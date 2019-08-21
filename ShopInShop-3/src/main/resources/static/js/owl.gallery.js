/*
 * owl-gallery.js
 * 
 * author Karo Kuo<tark810145@gmail.com>
 * Copyright (c) 2016
 * Licensed under the MIT license.
 */

(function($){

    $.fn.galleryShow = function() {
        var that = this;
        var mainImg = '';
        var tnClick = 0;
        var tnListWidth = 0;

        /*----------build------------*/
        $('body').append('<div id="owl-gallery"></div>')
        $('#owl-gallery').append('<div class="gallery-mask"><</div>');
        $('#owl-gallery').append('<div class="gallery-container"><a class="close"><i class="fa fa-times-circle-o fa-2x"></i></a></div>');
        $('#owl-gallery').append('<div class="gallery-thumbnail active"><a class="arrow left"><i class="fa fa-chevron-left fa-2x"></i></a><a class="arrow right"><i class="fa fa-chevron-right fa-2x"></i></a></div>');
        $('.gallery-thumbnail').append('<div class="thumbnail-container"><div class="thumbnail-container-list"></div></div>');
        
        that.parent().children().each(function(i) {
            var fa = 100;
            var img = $(this).find('div img');
            var imgWidth = fa * img.width() / img.height();
            var style =  '" style="left: ' + ((fa - imgWidth) / 2) + 'px;"';    //for center image
            if (this === that[0]) {
                $('.thumbnail-container-list').append('<a class="active"><img src="' + img.attr('src') + style + ' /></a>');
                tnClick = i;
            }
            else
               $('.thumbnail-container-list').append('<a><img src="' + img.attr('src') + style + ' /></a>');
            
            img.src = $(this).find('div img').attr('src');
            tnListWidth += $('.thumbnail-container-list a:eq(0)').outerWidth(true);
            mainImg += '<div class="item"><a><img src="'+ $(this).find('div img').attr('src') + '" /></a></div>';
        });
        $('.thumbnail-container-list').css('width', tnListWidth);
        /*----------build end------------*/
        
        /*----------Event binding------------*/
        $('.thumbnail-container a').each(function(i) {
            $(this).on('click', function() {
                $("#gallery-slider").trigger('owl.goTo', i);
                $('.thumbnail-container a').removeClass();
                $(this).addClass('active');
            });
        });

        $('.gallery-thumbnail a.left').on('click', function() {
            $("#gallery-slider").trigger('owl.prev');
        });

        $('.gallery-thumbnail a.right').on('click', function() {
            $("#gallery-slider").trigger('owl.next');
        });

        $('.gallery-mask').on('click', function() {
            galleryDestroy();
        });
        $('.gallery-container .close').on('click', function() {
            galleryDestroy();
        });
        /*----------Event binding end------------*/

        /*----------Owl-slider------------*/
        var text = '<div id="gallery-slider" class="owl-carousel owl-theme">' + mainImg + '</div>';
        $('.gallery-container').append(text);
        $('#gallery-slider').owlCarousel({
            slideSpeed: 300,
            paginationSpeed : 400,
            singleItem:true,
            lazyLoad:true,
            touchDrag:true,
            rewindSpeed: 500,
            autoPlay:false,
            stopOnHover: true,
            pagination: false,
            afterAction: owlAfterAction
        });
        $("#gallery-slider").trigger('owl.goTo', tnClick);
        $("#owl-gallery").css('visibility', 'visible').css('opacity', 1);
        setTimeout(function() {
           $('.gallery-thumbnail').removeClass('active'); 
        }, 2000);
        /*----------Owl-slider end------------*/
        
        function galleryDestroy() {
            $("#owl-gallery").css('visibility', 'hidden').css('opacity', 0);
            setTimeout(function() { 
                $('#owl-gallery').remove(); 
            }, 1000);
        }
                        
        function owlAfterAction() {
            $('.thumbnail-container-list a').removeClass();
            $($('.thumbnail-container-list a')[this.owl.currentItem]).addClass('active');
            var wWidth = $('.thumbnail-container').width();
            var itemLeft = $($('.thumbnail-container-list a')[this.owl.currentItem]).position().left;
            var itemWidth = $($('.thumbnail-container-list a')[this.owl.currentItem]).outerWidth(true);
            $('.thumbnail-container-list').css('left', (wWidth/2) - itemLeft - (itemWidth/2));

        }
    }

})(jQuery);