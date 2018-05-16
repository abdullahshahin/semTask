function ftechfromAPI(callback) {
    var fileName = getParameterByName("fileName", "");
    $.get( "api?fileName="+fileName, function( data ) {
        callback(data);
    });
}

function getChartData(jsonResponse, metricName) {
    var companies = Object.keys(jsonResponse);
    var metricsList = [];
    for(var company in companies) {
        metricsList.push({label: companies[company], y: jsonResponse[companies[company]][metricName], name: metricName});
    }
    return metricsList;
}

function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}

function adjust_textarea(h) {
    h.style.height = "20px";
    h.style.height = (h.scrollHeight)+"px";
}
