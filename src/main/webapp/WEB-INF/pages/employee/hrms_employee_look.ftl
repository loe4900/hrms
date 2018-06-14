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
        <h6 class="border-bottom page-title">信息查看</h6>
        <form>
            <div class="form-group form-row">
                <label for="id" class="col-1 col-form-label">ID</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="id" name="id" value="${employee.id}">
                </div>
                <label for="jobId" class="col-1 col-form-label">姓名</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="jobId" name="jobId" value="${employee.name}">
                </div>

            </div>
            <div class="form-group form-row">
                <label for="deptId" class="col-1 col-form-label">部门号</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="deptId" value="${employee.dept.id}">
                </div>
                <label for="name" class="col-1 col-form-label">姓名</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="name" value="${employee.name}">
                </div>

            </div>
            <div class="form-group form-row">
                <label for="cardId" class="col-1 col-form-label">身份证</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="cardId" value="${employee.cardId}">
                </div>
                <label for="address" class="col-1 col-form-label">住址</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="address" value="${employee.address}">
                </div>
            </div>
            <div class="form-group form-row">

                <label for="tel" class="col-1 col-form-label">电话</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="tel" value="${employee.tel}">
                </div>
                <label for="phone" class="col-1 col-form-label">手机号</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="phone" value="${employee.phone}">
                </div>
            </div>
            <div class="form-group form-row">
                <label for="qqNum" class="col-1 col-form-label">QQ</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="qqNum" value="${employee.qqNum}">
                </div>
                <label for="email" class="col-1 col-form-label">Email</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="email" value="${employee.email}">
                </div>
            </div>
            <div class="form-group form-row">
                <label for="sex" class="col-1 col-form-label">性别</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="sex" value="${employee.sex}">
                </div>
                <label for="createDate" class="col-1 col-form-label">入职时间</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="createDate" value="${employee.createDate}">
                </div>
            </div>
            <div class="form-group form-row">
                <label for="party" class="col-1 col-form-label">政治面貌</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="party" value="${employee.party}">
                </div>
                <label for="education" class="col-1 col-form-label">文凭</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="education" value="${employee.education}">
                </div>
            </div>
            <div class="form-group form-row">

                <label for="speciality" class="col-1 col-form-label">专业</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="speciality" value="${employee.speciality}">
                </div>
                <label for="hobby" class="col-1 col-form-label">爱好</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="hobby" value="${employee.hobby}">
                </div>
            </div>
            <div class="form-group form-row">
                <label for="birthday" class="col-1 col-form-label">出生日期</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="birthday" value="${employee.birthday}">
                </div>
                <label for="race" class="col-1 col-form-label">民族</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="race" value="${employee.race}">
                </div>
            </div>
            <div class="form-group form-row">
                <label for="remark" class="col-1 col-form-label">备注</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="remark" value="${employee.remark}">
                </div>
                <label for="createDate" class="col-1 col-form-label">入职时间</label>
                <div class="col-4">
                    <input type="text" class="form-control" readonly id="createDate" value="${employee.createDate}">
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