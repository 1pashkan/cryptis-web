$(document).ready(function() {
// center
    centerJumbo();
//    normalizeScreensHeight();

// vk
//    VK.init({apiId: 3863818, onlyWidgets: true});
//    VK.Widgets.Like("vk_like", {type: "mini", height: 24});

// my-navi
    $("#my-carousel").on("slide.bs.carousel", function (e) {
        console.log(213);
        $(".btn-sm:not(.my-navi)").each(function () {
            $(this).removeClass("active")
        });
        var index = $(e.relatedTarget).index();
        $(".btn-sm:not(.my-navi):nth-child("+(2+index)+")").addClass("active");
    });
    $("#my-carousel").carousel("cycle");
});

function centerJumbo() {
    $(window).resize(function(){
        $('.my-content').css({
            position:'absolute',
            left: ($(window).width() - $('.my-content').outerWidth())/2,
            top: ($(window).height() - $('.my-content').outerHeight())/2,
            width: $('.header').width()
        });

    });
    $(window).resize();
    setTimeout("$(window).resize()", 1);
    setTimeout("$(window).resize()", 5);
    setTimeout("$(window).resize()", 10);
}

function normalizeScreensHeight() {
    $(window).resize(function(){
        var max = 0;
        $('.my-item').each(function() {
            if ($(this).height() > max) {
                max = $(this).height();
            }
        })
        $('.my-item').css("min-height", function() { return max+'px'; });
    });
    $(window).resize();
    setTimeout("$(window).resize()", 1);
}

function subscribe() {
    $.ajax({
        url: '/actions/subscribe',
        data: {
            email: $('#subscribe-email').val()
        },
        dataType: 'json'
    }).done(function(data) {
        if (data.success) {
            showSuccess();
        } else {
            showFail();
        }
    }).fail(showFail);

    function showFail() {
        $('.alert').removeClass('alert-success');
        $('.alert').addClass('alert-info');
        $('.alert').text('Этот email уже зарегистрирован');
        $('.alert').fadeIn('slow', function() {
            setTimeout("$('.alert').fadeOut('slow');", 1500);
        });
    }

    function showSuccess() {
        $('.alert').removeClass('alert-info');
        $('.alert').addClass('alert-success');
        $('.alert').text('Спасибо за подписку! Email зарегистрирован');
        $('.alert').fadeIn('slow', function() {
            setTimeout("$('.alert').fadeOut('slow');", 1500);
        });
    }
}
