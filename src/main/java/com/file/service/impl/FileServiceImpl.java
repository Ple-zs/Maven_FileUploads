package com.file.service.impl;

import com.file.dao.FileDao;
import com.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDao fileDao;

    @Override
    public int addFile(String path) {
        return fileDao.addFile(path);
    }
}
