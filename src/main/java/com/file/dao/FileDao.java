package com.file.dao;

import org.apache.ibatis.annotations.Param;

public interface FileDao {
    //添加文件
    int addFile(@Param("path") String path);
}
