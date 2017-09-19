<!-- define something about window operation  -->
$w = {};

<!-- apply to pass single param, page only turn and not open -->
$w.url = function(url, param) {
    if (param != null) {
        var props = "" ;
        for (var p in param) {
            if ( typeof(param [ p ]) == " function " )
            {
                param [ p ]() ;
            } else {
                props += p + "='" + param [ p ] + "'&" ;
            }
        }
        if(url.substr(url.length, 1) == "?") {
            url +=  props.substr(0, props.length-1);
        } else {
            url += "?" + props.substr(0, props.length-1);
        }
    }
    window.location.href = url;
}

<!-- apply to pass object param, page open a new window, can callback father page, but just compatible IE -->
$w.openAndCallback =  function(url, param, width, height) {
    var template = "dialogWidth=" + width + "px;dialogHeight=" + height + "px";
    window.showModalDialog(url, param, template);
}

<!-- apply to pass object param, page open a new window, can not callback -->
$w.open =  function(url, title) {
    window.open(url, title);
}

<!-- apply to get one value which is the input key and return string -->
$w.getUrlParam = function (key) {
    var reg = new RegExp("(^|&)" + key + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
        return decodeURI(r[2]);
    return null;
}

<!-- apply to get url all params and return object -->
$w.getUrlParams = function () {
    var r = window.location.search.substr(1);
    var paramsArr = r.split("%27");
    var params = {};
    var temp = "";
    for (var i = 0; i < paramsArr.length; i++) {
        if (i%2==0) {
            temp = paramsArr[i].replace(new RegExp("(&|=)","g"), "");
        } else {
            params[temp] = paramsArr[i];
        }
    }
    return params;
}

<!-- apply to get open window param and return string-->
$w.getOpenParam = function() {

}


$w.loadIframe = function(id, url) {
    window.onload=function() {
        id.src= url;
    }
}



