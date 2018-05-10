$(function () {
    function getMsg(selector, atr) {
        return $(selector).attr(atr);
    }
    $("form[name='addPersonForm']").validate({
        rules: {
            lastName: {
                required: true,
                minlength: 2,
                maxlength: 25,
                pattern: /[A-Za-z]/
            },
            firstName: {
                required: true,
                minlength: 2,
                maxlength: 25
            },
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
            lastName: {
                required: getMsg('#lastName', 'data-msg-lastName-required'),
                minlength: getMsg('#lastName', 'data-msg-lastName-minlength'),
                maxlength: getMsg('#lastName', 'data-msg-lastName-maxlength'),
                pattern: getMsg('#lastName', 'data-msg-lastName-pattern')
            },
            firstName: {
                required: getMsg('#firstName', 'data-msg-firstName-required'),
                minlength: getMsg('#firstName', 'data-msg-firstName-minlength'),
                maxlength: getMsg('#firstName', 'data-msg-firstName-maxlength')
            },
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
    $("form[name='editPersonForm']").validate({
        rules: {
            lastName: {
                required: true,
                minlength: 2,
                maxlength: 25
            },
            firstName: {
                required: true,
                minlength: 2,
                maxlength: 25
            },
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
            lastName: {
                required: getMsg('#lastName', 'data-msg-lastName-required'),
                minlength: getMsg('#lastName', 'data-msg-lastName-minlength'),
                maxlength: getMsg('#lastName', 'data-msg-lastName-maxlength')
            },
            firstName: {
                required: getMsg('#firstName', 'data-msg-firstName-required'),
                minlength: getMsg('#firstName', 'data-msg-firstName-minlength'),
                maxlength: getMsg('#firstName', 'data-msg-firstName-maxlength')
            },
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
