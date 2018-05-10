$(function () {
    function getMsg(selector, atr) {
        return $(selector).attr(atr);
    }
    $("form[name='addBookForm']").validate({
        rules: {
            nameBook: {
                required: true,
                minlength: 1,
                maxlength: 40
            },
            amount: {
                required: true,
                number: true,
                min: 1
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
                number: getMsg('#amount', 'data-msg-amount-number'),
                min: getMsg('#amount', 'data-msg-amount-min')
            }
        },
        submitHandler: function (form) {
            form.submit();
        }
    });
    $("form[name='editBookForm']").validate({
        rules: {
            nameBook: {
                required: true,
                minlength: 1,
                maxlength: 40
            },
            amount: {
                required: true,
                number: true,
                min: 1
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
                number: getMsg('#amount', 'data-msg-amount-number'),
                min: getMsg('#amount', 'data-msg-amount-min')
            }
        },
        submitHandler: function (form) {
            form.submit();
        }
    });
});
