$(function () {
    function getMsg(selector, atr) {
        return $(selector).attr(atr);
    }
    $("form[name='addAuthor']").validate({
        rules: {
            lastNameAuthor: {
                required: true,
                minlength: 2,
                maxlength: 25
            },
            firstNameAuthor: {
                required: true,
                minlength: 2,
                maxlength: 25
            }
        },
        messages: {
            lastNameAuthor: {
                required: getMsg('#lastNameAuthor', 'data-msg-lastName-required'),
                minlength: getMsg('#lastNameAuthor', 'data-msg-lastName-minlength'),
                maxlength: getMsg('#lastNameAuthor', 'data-msg-lastName-maxlength')
            },
            firstNameAuthor: {
                required: getMsg('#firstNameAuthor', 'data-msg-firstName-required'),
                minlength: getMsg('#firstNameAuthor', 'data-msg-firstName-minlength'),
                maxlength: getMsg('#firstNameAuthor', 'data-msg-firstName-maxlength')
            }
        },
        submitHandler: function (form) {
            form.submit();
        }
    });
    $("form[name='addPublisher']").validate({
        rules: {
            namePublisher:{
                required: true,
                minlength: 2,
                maxlength: 25
            }
        },
        messages: {
            namePublisher: {
                required: getMsg('#namePublisher', 'data-msg-namePublisher-required'),
                minlength: getMsg('#namePublisher', 'data-msg-namePublisher-minlength'),
                maxlength: getMsg('#namePublisher', 'data-msg-namePublisher-maxlength')
            }
        },
        submitHandler: function (form) {
            form.submit();
        }
    });
});
