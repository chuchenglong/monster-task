$x = {};

$x.ajax_post = function(url, params, successCallback, failCallBack) {
    $.ajax({
        type: 'POST',
        url: url,
        data: params,
        dataType: "json",
        success: function(result) {
            return successCallback(result);
        },
        error : function(result) {
            return failCallBack(result);
        }

    });
}