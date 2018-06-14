<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
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
        <h6 class="border-bottom page-title">员工信息（*可修改）</h6>
        <form action="${basePath}/employee/update" method="post">
            <div class="form-group form-row">
                <label for="id" class="col-1 col-form-label">用工ID</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="id" name="id" value="${employee.id}">
                </div>
                <label for="deptId" class="col-1 col-form-label">部门ID</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="deptId" name="deptId" value="${employee.dept.id}">
                </div>
            </div>
            <div class="form-group form-row">
                <label for="jobId" class="col-1 col-form-label">工作号</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="jobId" name="jobId" value="${employee.job.id}">
                </div>
                <label for="name" class="col-1 col-form-label">姓名</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="name" name="name" value="${employee.name}">
                </div>
            </div>
            <div class="form-group form-row">
                <label for="address" class="col-1 col-form-label">地址</label>
                <div class="col-4">
                    <input type="text" class="form-control"  id="address" name="address" value="${employee.address}">
                </div>
                <label for="postcode" class="col-1 col-form-label">邮编</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="postcode" name="postcode" value="${employee.postcode}">
                </div>
            </div>
            <div class="form-group form-row">
                <label for="tel" class="col-1 col-form-label">电话</label>
                <div class="col-4">
                    <input type="text" class="form-control"  id="tel" name="tel" value="${employee.tel}">
                </div>
                <label for="phone" class="col-1 col-form-label">手机</label>
                <div class="col-4">
                    <input type="text" class="form-control" id="phone" name="phone" value="${employee.phone}">
                </div>
            </div>
            <div class="form-group form-row">
                <label for="qqNum" class="col-1 col-form-label">QQ</label>
                <div class="col-4">
                    <input type="text" class="form-control"  id="qqNum" name="qqNum" value="${employee.qqNum}">
                </div>
                <label for="email" class="col-1 col-form-label">Email</label>
                <div class="col-4">
                    <input type="text" class="form-control"  id="email" name="email" value="${employee.email}">
                </div>
            </div>
            <div class="form-group form-row">
                <label for="sex" class="col-1 col-form-label">性别</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="sex" name="sex" value="${employee.sex}">
                </div>
                <label for="party" class="col-1 col-form-label">政治面貌</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="party" name="party" value="${employee.party}">
                </div>
            </div>
            <div class="form-group form-row">
                <label for="birthday" class="col-1 col-form-label">出生日期</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="birthday" name="birthday" value="${employee.birthday}">
                </div>
                <label for="race" class="col-1 col-form-label">民族</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="race" name="race" value="${employee.race}">
                </div>
            </div>
            <div class="form-group form-row">

                <label for="education" class="col-1 col-form-label">文凭</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="education" name="education" value="${employee.education}">
                </div>
                <label for="speciality" class="col-1 col-form-label">专业</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="speciality" name="speciality" value="${employee.speciality}">
                </div>
            </div>
            <div class="form-group form-row">
                <label for="hobby" class="col-1 col-form-label">爱好</label>
                <div class="col-4">
                    <input type="text" class="form-control"  id="hobby" name="hobby" value="${employee.hobby}">
                </div>
                <label for="remark" class="col-1 col-form-label">备注</label>
                <div class="col-4">
                    <input type="text" class="form-control"  id="remark" name="remark" value="${employee.remark}">
                </div>
            </div>
            <#--<div class="form-group form-row">-->
                <#--<label for="createDate" class="col-1 col-form-label">入职时间</label>-->
                <#--<div class="col-4">-->
                    <#--<input type="text" class="form-control" readonly id="createDate" name="createDate" value="${employee.createDate}">-->
                <#--</div>-->
            <#--</div>-->
            <div class="form-group form-row">
                <div class="col-10 text-right">
                    <button type="submit" class="btn btn-primary mb-2">提交修改</button>
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
<script>
    $(function () {
    });
</script>
</html>