/**
 * jQuery 动画返回顶部
 * author manHua Mr
 */
$(function(){
    $.fn.animateToTop = function(options){
        var defaults = {
            showHeight: 150,
            speed: 1000
        };
        var options = $.extend(defaults, options);
        $("body").prepend("<div id='totop'><a>返回</a></div>");
        var $toTop = $(this);
        var $top = $("#totop");
        var $ta = $("#totop a");
        $toTop.scroll(function(){
            var scrolltop = $(this).scrollTop();
            if (scrolltop >= options.showHeight) {
                $top.fadeIn(100);
            }
            else {
                $top.fadeOut(100);
            }
        });
        $ta.hover(function(){
            $(this).addClass("cur");
        }, function(){
            $(this).removeClass("cur");
        });
        $top.click(function(){
            $("html,body").animate({
                scrollTop: 0
            }, options.speed);
        });
    }
});
