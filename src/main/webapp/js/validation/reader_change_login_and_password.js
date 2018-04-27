$(function () {
    function getMsg(selector, atr) {
        return $(selector).attr(atr);
    }
    $("form[name='changeLoginAndPassword']").validate({
        rules: {
            login: {
                required: true,
                minlength: 6,
                maxlength: 10
            },
            password: {
                required: true,
                minlength: 6,
                maxlength: 10
            }
        },
        messages: {
            login: {
                required: getMsg('#login', 'data-msg-login-required'),
                minlength: getMsg('#login', 'data-msg-login-minlength'),
                maxlength: getMsg('#login', 'data-msg-login-maxlength')
            },
            password: {
                required: getMsg('#password', 'data-msg-password-required'),
                minlength: getMsg('#password', 'data-msg-password-minlength'),
                maxlength: getMsg('#password', 'data-msg-password-maxlength')
            }
        },
        submitHandler: function (form) {
            form.submit();
        }
    });
});
