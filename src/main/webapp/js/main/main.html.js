function init() {
    var params = $w.getUrlParams();
    $("#username").html(params.data);
    $x.ajax_post("/monster/job/getAllJobs.do", null, success);
}

function success(result) {
    var data = result.data;
    var str = "<tr><td>scheduler名称</td><td>job分组</td><td>job名称</td><td>trigger分组</td><td>trigger名称</td><td>job引用类</td><td>定时表达式</td><td>触发器状态</td><td>操作</td></tr>";
    $.each(data, function (i, j) {
        str += "<tr>";
        str += "<td>"+ j.schedName+"</td>"
            + "<td>"+ j.jobGroup+"</td>"
            + "<td>"+ j.jobName+"</td>"
            + "<td>"+ j.triggerGroup+"</td>"
            + "<td>"+ j.triggerName+"</td>"
            + "<td>"+ j.jobClassName+"</td>"
            + "<td>"+ j.cronExpression+"</td>"
            + "<td>"+ j.triggerState+"</td>"
            + "<td><input type='button' id='stop' value='stop' onclick='stopJob()' />&nbsp;<input type='button' id='excute' value='excute' onclick='excuteJob()' />&nbsp;<input type='button' id='edit' value='edit' onclick='editJob()' />&nbsp;<input type='button' id='delete' value='delete' onclick='deleteJob()' /></td>";
        str += "</tr>";
    });
    document.getElementById("tbody").innerHTML = str;
}

function addJob() {
    var params = {};
    params.jobName = $("#jobName").val();
    params.jobGroup = $("#jobGroup").val();
    params.triggerName = $("#triggerName").val();
    params.triggerGroup = $("#triggerGroup").val();
    params.cronExpression = $("#cronExpression").val();
    params.jobClassName = $("#jobClassName").val();

    $x.ajax_post("/monster/job/addJob.do", params, function(data){
    }, function(error) {
    });

}

function stopJob() {
    var params = {};
    params.jobName = "exampleJob";
    params.jobGroup = "DEFAULT";
    $x.ajax_post("/monster/job/stopJob.do", params, function(data){
    }, function(error) {
    });
}

function excuteJob() {
    var params = {};
    params.jobName = "exampleJob";
    params.jobGroup = "DEFAULT";
    $x.ajax_post("/monster/job/excuteJob.do", params, function(data){
    }, function(error) {
    });
}

function editJob() {
    var params = {};
    params.jobName = $("#jobName").val();
    params.jobGroup = $("#jobGroup").val();
    params.triggerName = $("#triggerName").val();
    params.triggerGroup = $("#triggerGroup").val();
    params.cronExpression = $("#cronExpression").val();
    params.jobClassName = $("#jobClassName").val();

    $x.ajax_post("/monster/job/editJob.do", params, function(data){
    }, function(error) {
    });
}

function deleteJob() {
    var params = {};
    params.jobName = "exampleJob";
    params.jobGroup = "DEFAULT";
    $x.ajax_post("/monster/job/deleteJob.do", params, function(data){
    }, function(error) {
    });
}