<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css/font-awesome.css">
    <link href="https://cdn.bootcss.com/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker3.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker3.standalone.css"
          rel="stylesheet">
    <style>
        * {
            font-size: 14px;
        }

        .container-fluid {
            background: #f7f7f7;
            padding: 20px 30px;
        }

        h4.page-title {
            padding-bottom: 9px;
            margin: 10px 0 45px;
        }

        .modal-dialog {
            width: 300px;
            margin: 0 auto;
            margin-top: -360px;
        }
    </style>
</head>
<body class="container-fluid">
<div class="row">
    <div class="col-12">
        <h4 class="border-bottom page-title">用户管理</h4>
        <input type="hidden" id="basePath" value="${basePath}">
          <#if commonMessage?exists>
            <p>${commonMessage.message}</p>
          </#if>
        <div class="row">
            <div class="col-3">
                <div class="form-group">
                    <button class="btn btn-sm btn-primary" onclick="addItem();">新增</button>
                    <button class="btn btn-sm btn-danger" onclick="batchDeleteItems();">批量删除</button>
                </div>
            </div>
            <div class="col-9">
                <div class="form-group form-row">
                    <label for="name" class="col-form-label text-right">姓名:</label>
                    <div class="col">
                        <input type="text" class="form-control" id="name" name="name" autocomplete="off">
                    </div>
                    <label for="createDate" class="col-form-label  text-right">创建日期:</label>
                    <div class="col">
                        <input type="text" class="form-control" id="createDate" name="createDate" autocomplete="off">
                    </div>
                    <div class="col">
                        <button class="btn btn-sm btn-primary" onclick="query();">查询</button>
                    </div>
                </div>
            </div>
        </div>
        <table class="table table-bordered">
            <thead class="table-dark">
            <tr>
                <th scope="col">X</th>
                <th scope="col">序号</th>
                <th scope="col">ID</th>
                <th scope="col">部门号</th>
                <th scope="col">工作号</th>
                <th scope="col">姓名</th>
                <th scope="col">身份证号</th>
                <th scope="col">地址</th>
                <th scope="col">邮编号</th>
                <th scope="col">电话号</th>
                <th scope="col">手机号</th>
                <th scope="col">QQ</th>
                <th scope="col">邮箱</th>
                <th scope="col">性别</th>
                <th scope="col">政治面貌</th>
                <th scope="col">出生日期</th>
                <th scope="col">民族</th>
                <th scope="col">文凭</th>
                <th scope="col">专业</th>
                <th scope="col">爱好</th>
                <th scope="col">备注</th>
                <th scope="col">入职时间</th>
                <th scope="col">操作</th>
            </tr>
            </thead>
            <tbody id="listBody">
            </tbody>
        </table>
        <div class="col-12">
            <div class="row">
                <ul class="col-6 pagination">
                    <li class="page-item">
                        <a class="page-link" href="javascript:void(0);" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                            <span class="sr-only">Previous</span>
                        </a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="javascript:void(0);" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                            <span class="sr-only">Next</span>
                        </a>
                    </li>
                </ul>
                <p class="col-6 text-right" id="displaying">Displaying 0 to 0 page 0 items.</p>
            </div>
        </div>
    </div>
    <!-- 模态框 -->
    <div class="modal fade" id="empModalCenter" tabindex="-1" role="dialog" aria-labelledby="empModalCenterTitle"
         aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="empModalLongTitle">标题</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary">保存修改</button>
                </div>
            </div>
        </div>
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
<script src="${basePath}/js/employee/hrms_employee.js"></script>
</html>