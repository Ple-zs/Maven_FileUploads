package com.file.service;

import org.apache.ibatis.annotations.Param;

public interface FileService {
    //添加文件
    int addFile(@Param("path") String path);
}
