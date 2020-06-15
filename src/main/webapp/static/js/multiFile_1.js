var input = document.getElementById("more_mu_file");
var result;
if (typeof FileReader === 'undefined') {
    alert("抱歉，你的浏览器不支持 FileReader");
    input.setAttribute('disabled', 'disabled');
} else {
    input.addEventListener('change', readFile, false);
}

function readFile() {

    var iLen = this.files.length;
    for (var i = 0; i < iLen; i++) {
        if (!input['value'].match(/.jpg|.gif|.png|.jpeg|.bmp/i)) {　　//判断上传文件格式
            return alert("上传的图片格式不正确，请重新选择");
        }
        var reader = new FileReader();
        reader.readAsDataURL(this.files[i]);  //转成base64
        reader.fileName = this.files[i].name;
        reader.onload = function (e) {
            result = '<div class="result"><img class="subPic" src="' + this.result + '" alt="' + this.fileName + '"/></div>';
            var div = document.createElement('div');
            div.innerHTML = result;
            div['className'] = 'float';
            document.getElementById('more_mu_images').appendChild(div);  　　//插入dom树
            var img = div.getElementsByTagName('img')[0];
            img.onload = function () {
                var nowHeight = ReSizePic(this); //设置图片大小
                this.parentNode.style.display = 'block';
                var oParent = this.parentNode;
                if (nowHeight) {
                    oParent.style.paddingTop = (oParent.offsetHeight - nowHeight) / 2 + 'px';
                }
            }
        }
    }
}

//浏览
$(".more_mu_browse_btn").click(function () {
    $("#more_mu_file").trigger("click");
    clear();
});

//重置
$(".more_mu_reset_btn").click(function () {
    clear();
});

//清除数据
function clear(){
    $('.float').remove();
    $("#more_mu_file").val("");
}

//不给表单跳转
$(".form1").submit(function () {
    return false;
});

//上传
$(".more_mu_submit_btn").click(function () {
    if ($("#more_mu_file").val() != null && $("#more_mu_file").val().trim() != "") {
        var form = new FormData();
        var fileObj = $("#more_mu_file").get(0).files;
        var length = fileObj.length;
        for (var i = 0; i < length; i++) {
            form.append("file", fileObj[i]);
            console.log(fileObj[i]);
        }
        $.ajax({
            url: "multiFileUploading",
            type: "POST",
            data: form,  //FormData()对象
            contentType: false, //必须false才会自动加上正确的Content-Type
            processData: false, //必须false才会避开jQuery对 formdata 的默认处理     , XMLHttpRequest会对 formdata 进行正确的处理
            success: function (data) {
                if(data == "true"){
                    clear();
                    alert("上传成功！");
                } else alert("上传失败！");
            }
        });
        return false;
    } else {
        alert("请选择要上传的文件！");
    }
    return false;
});

function ReSizePic(ThisPic) {
    var RePicWidth = 200; //这里修改为您想显示的宽度值

    var TrueWidth = ThisPic.width; //图片实际宽度
    var TrueHeight = ThisPic.height; //图片实际高度

    if (TrueWidth > TrueHeight) {
        //宽大于高
        var reWidth = RePicWidth;
        ThisPic.width = reWidth;
        //垂直居中
        var nowHeight = TrueHeight * (reWidth / TrueWidth);
        return nowHeight;  //将图片修改后的高度返回，供垂直居中用
    } else {
        //宽小于高
        var reHeight = RePicWidth;
        ThisPic.height = reHeight;
    }
}