<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker3.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker3.standalone.css"
          rel="stylesheet">
    <style>
        .container-fluid {
            background: #f7f7f7;
            padding: 20px 30px;
        }

        .page-title {
            padding-bottom: 9px;
            margin: 10px 0 45px;
        }
    </style>
</head>
<body class="container-fluid">
<div class="row">
    <div class="col-12">
        <h4 class="border-bottom page-title">员工管理</h4>
        <h6 class="border-bottom page-title">添加员工</h6>
        <form action="${basePath}/employee/add" method="post">
            <div class="form-group form-row">
                <label for="dept.id" class="col-1 col-form-label">部门号</label>
                <div class="col-4">
                    <select class="form-control" id="deptId" name="dept.id">
                        <option value="">请选择...</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                    </select>
                </div>
                <label for="job.id" class="col-1 col-form-label">工作号</label>
                <div class="col-4">
                    <select class="form-control" id="jobId" name="job.id">
                        <option value="">请选择...</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                </div>
            </div>
            <div class="form-group form-row">
                <label for="name" class="col-1 col-form-label">姓名</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="name" name="name">
                </div>
                <label for="cardId" class="col-1 col-form-label">身份证号</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="cardId" name="cardId">
                </div>
            </div>
            <div class="form-group form-row">
                <label for="address" class="col-1 col-form-label">地址</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="address" name="address">
                </div>
                <label for="postcode" class="col-1 col-form-label">邮编</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="postcode" name="postcode">
                </div>
            </div>
            <div class="form-group form-row">
                <label for="tel" class="col-1 col-form-label">电话</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="tel" name="tel">
                </div>
                <label for="phone" class="col-1 col-form-label">手机</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="phone" name="phone">
                </div>
            </div>
            <div class="form-group form-row">
                <label for="qqNum" class="col-1 col-form-label">QQ</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="qqNum" name="qqNum">
                </div>
                <label for="email" class="col-1 col-form-label">邮箱</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="email" name="email">
                </div>
            </div>
            <div class="form-group form-row">
                <label for="sex" class="col-1 col-form-label">性别</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="sex" name="sex">
                </div>
                <label for="party" class="col-1 col-form-label">政治面貌</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="party" name="party">
                </div>
            </div>
            <div class="form-group form-row">
                <label for="birthday" class="col-1 col-form-label">出生日期</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="birthday" name="birthday">
                </div>
                <label for="race" class="col-1 col-form-label">民族</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="race" name="race">
                </div>
            </div>
            <div class="form-group form-row">
                <label for="education" class="col-1 col-form-label">文凭</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="education" name="education">
                </div>
                <label for="speciality" class="col-1 col-form-label">专业</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="speciality" name="speciality">
                </div>
            </div>
            <div class="form-group form-row">
                <label for="hobby" class="col-1 col-form-label">爱好</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="hobby" name="hobby">
                </div>
                <label for="remark" class="col-1 col-form-label">备注</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="remark" name="remark">
                </div>
            </div>
            <div class="form-group form-row">
                <div class="col-10 text-right">
                    <button type="submit" class="btn btn-success mb-2">保存</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-datepicker/1.8.0/locales/bootstrap-datepicker.zh-CN.min.js"></script>

<script>
    $(function () {
        $('#birthday').datepicker({
            language: "zh-CN",    //语言选择中文
            format: "yyyy-mm-dd",    //格式化日期
            autoclose: 1       //选择完日期后，弹出框自动关闭
            // timepicker: true,     //关闭时间选项
            // yearEnd: 2050,        //设置最大年份
            // todayButton: false,    //关闭选择今天按钮
            // startView: 3,         //打开弹出框时，显示到什么格式,3代表月
            // minView: 3          //能选择到的最小日期格式
        });
    })


</script>
</html>