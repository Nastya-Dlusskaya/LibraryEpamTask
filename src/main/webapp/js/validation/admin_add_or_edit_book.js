$(function () {
    function getMsg(selector, atr) {
        return $(selector).attr(atr);
    }
    $("form[name='addPersonForm']").validate({
        rules: {
            nameBook: {
                required: true,
                minlength: 1,
                maxlength: 40
            },
            amount: {
                required: true,
                number: true
            }
        },
        messages: {
            nameBook: {
                required: getMsg('#nameBook', 'data-msg-nameBook-required'),
                minlength: getMsg('#nameBook', 'data-msg-nameBook-minlength'),
                maxlength: getMsg('#nameBook', 'data-msg-nameBook-maxlength')
            },
            amount: {
                required: getMsg('#amount', 'data-msg-amount-required'),
                number: getMsg('#amount', 'data-msg-amount-number')
            }
        },
        submitHandler: function (form) {
            form.submit();
        }
    });
    $("form[name='editPersonForm']").validate({
        rules: {
            nameBook: {
                required: true,
                minlength: 1,
                maxlength: 40
            },
            amount: {
                required: true,
                number: true
            }
        },
        messages: {
            nameBook: {
                required: getMsg('#nameBook', 'data-msg-nameBook-required'),
                minlength: getMsg('#nameBook', 'data-msg-nameBook-minlength'),
                maxlength: getMsg('#nameBook', 'data-msg-nameBook-maxlength')
            },
            amount: {
                required: getMsg('#amount', 'data-msg-amount-required'),
                number: getMsg('#amount', 'data-msg-amount-number')
            }
        },
        submitHandler: function (form) {
            form.submit();
        }
    });
});
