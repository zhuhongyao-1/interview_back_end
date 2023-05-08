package com.zhy.interview.service;

import java.io.InputStream;

/**
 * @author zhy
 * @Title:
 * @Package
 * @Description:
 * @date 2021/9/1118:47
 */
public interface FileService {
    /**
     * 文件上传至阿里云
     */
    String upload(InputStream inputStream, String module, String fileName);

    void removeFile(String url);
}
