/**
 * Created by ChenQF on 2018/1/20.
 */

var com = {};

com.layerOpen = function (options) {
    var defaults = {
        id: "default" + Math.random(),
        title: '操作',
        type: 2,
        skin: 'demo-class',
        width: "auto",
        height: "auto",
        content: '',
        closeBtn: 0,
        shade: 0.3,
        maxmin: true,
        btn: ['确认', '取消'],
        btnclass: ['btn btn-primary', 'btn btn-danger'],
        yes: null,
        shadeClose: true
    };
    options = $.extend(defaults, options);


    top.layer.open({
        id: options.id,
        type: options.type,
        scrollbar: false,
        skin: options.skin,
        shade: options.shade,
        shadeClose: options.shadeClose,
        maxmin: options.maxmin,
        title: options.title,
        fix: false,
        area: [options.width, options.height],
        content: options.content,
        btn: options.btn,
        btnclass: options.btnclass,
        yes: function (index, layero) {

            if (options.yes && $.isFunction(options.yes)) {
                var iframebody = layui.layer.getChildFrame('body', index);
                var iframeWin = layero.find('iframe')[0].contentWindow;
                options.yes(iframebody, iframeWin, index);
            }
        },
        cancel: function (index, layero) {
            if ($.isFunction(options.cancel)) {
                options.cancel(index, layero);
            }
            return true;
        },
        success: function (layero, index) {
            if (options.success && $.isFunction(options.success)) {
                var iframebody = layui.layer.getChildFrame('body', index);
                var iframeWin = layero.find('iframe')[0].contentWindow;
                options.success(iframebody, iframeWin, index);
            }
        }
    });
};


com.getUserInfo = function () {
    $.ajax({
        type: 'get',
        url: '/user/getUserInfo',
        async: true,
        dataType: 'json',
        success: function (data) {
            if (data.code == -1) return;
            $('#username').text(data.data.name);
            $('#userimg').attr("src", data.data.img);

        },
        error: function () {

        }
    })
};

(function ($) {
    $.fn.formSerialize = function (formdata, callback) {
        var $form = $(this);
        if (formdata) {
            for (var key in formdata) {
                var $field = $form.find("[name=" + key + "]");
                if ($field.length === 0) {
                    continue;
                }
                var value = $.trim(formdata[key]);
                var type = $field.attr('type');
                if ($field.hasClass('select2')) {
                    type = "select2";
                }
                switch (type) {
                    case "checkbox":
                        value === "true" ? $field.attr("checked", 'checked') : $field.removeAttr("checked");
                        break;
                    case "select2":
                        if (!$field[0].multiple) {
                            $field.select2().val(value).trigger("change");
                        } else {
                            var values = value.split(',');
                            $field.select2().val(values).trigger("change");
                        }
                        break;
                    case "radio":
                        $field.each(function (index, $item) {
                            if ($item.value === value) {
                                $item.checked = true;
                            }
                        });
                        break;
                    default:
                        $field.val(value);
                        break;
                }
            }
            // 特殊的表单字段可以在回调函数中手动赋值。
            if (callback && $.isFunction(callback)) {
                callback(formdate);
            }
            return false;
        }
        var postdata = {};
        $form.find('input,select,textarea').each(function (r) {
            var $this = $(this);
            var name = $this.attr('name');
            var type = $this.attr('type');
            switch (type) {
                case "checkbox":
                    postdata[name] = $this.is

                    (":checked");
                    break;
                default:
                    var value = $this.val() === "" ? "" : $this.val();
                    postdata[name] = value;
                    break;
            }
        });
        return postdata;
    };
})(jQuery);


/**
 * 获取URL指定参数值。
 * @param {String} name 参数name值
 * @returns 获取URL指定参数值。
 */
com.getQueryString = function (name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r !== null) return unescape(r[2]);
    return null;
};

/**
 * 格式化字符串
 * 用法:
 .formatString("{0}-{1}","a","b");
 */
com.formatString = function () {
    for (var i = 1; i < arguments.length; i++) {
        var exp = new RegExp('\\{' + (i - 1) + '\\}', 'gm');
        arguments[0] = arguments[0].replace(exp, arguments[i]);
    }
    return arguments[0];
};

