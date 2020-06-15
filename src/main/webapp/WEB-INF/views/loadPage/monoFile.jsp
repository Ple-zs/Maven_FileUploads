<%--
  Created by IntelliJ IDEA.
  User: 86135
  Date: 2020/6/5
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="" method="post" class="monoFile_form" target="nm_iframe" enctype="multipart/form-data">
    <div class="multiFile_uploading">
        <div class="more_mu_title-V">
            <h3 class="more_mu_title">单文件上传</h3>
        </div>
        <div class="more_mu_images-V">
            <div id="more_mu_images"></div>
            <div class="more_mu_browse-V">
                <button type="button" class="more_mu_browse_btn">浏览</button>
            </div>
        </div>
        <div class="more_mu_footer-V">
            <input type="submit" value="上传" class="more_mu_submit_btn"/>
            <button type="button" class="more_mu_reset_btn">重置</button>
        </div>
    </div>
    <input type="file" name="file" id="more_mu_file" class="dis_none" />
</form>
<script src="${ initParam.webUrl }/static/js/monoFile.js"></script>
