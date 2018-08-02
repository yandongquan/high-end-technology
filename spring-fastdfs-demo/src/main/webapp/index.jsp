<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Fastdfs 上传图片</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <form id= "uploadForm" method="post" enctype="multipart/form-data">
            <h3>上传图片</h3>
            <div class="form-group">
                <input type="file"id="file" class="form-control" id="exampleInputEmail1" placeholder="Email">
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-info" onclick="doUpload()">确定上传</button>
            </div>
        </form>
        <p class="text-danger">图片展示区</p>
        <div id="img-show">
            <img src="https://isujin.com/wp-content/uploads/2017/05/wallhaven-338418.jpg" alt="..." class="img-responsive img-rounded">
        </div>
    </div>
    <div class="col-md-4"></div>
</div>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js" type="text/javascript"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
    function doUpload() {
        var file = $("#file")[0].files[0];
        var formData = new FormData();
        formData.append("fileInfo", file)
        $.ajax({
            url: '/spring-fastdfs-demo/upload.html',
            type: 'POST',
            data: formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (returndata) {
                var data = JSON.parse(returndata);
                var path = data.data;
                console.info(path);
                $("#img-show img").attr('src',path);
            },
            error: function (returndata) {
                alert(returndata);
            }
        });
    }
</script>
</body>
</html>

