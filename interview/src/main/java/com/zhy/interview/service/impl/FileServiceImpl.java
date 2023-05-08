package com.zhy.interview.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.zhy.interview.service.FileService;
import com.zhy.interview.utils.OssProperties;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author zhy
 * @Title:
 * @Package
 * @Description:
 * @date 2021/9/1118:48
 */
@Service
public class FileServiceImpl implements FileService {


    @Override
    public String upload(InputStream inputStream, String module, String fileName) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(OssProperties.ENDPOINT, OssProperties.KEY_ID, OssProperties.KEY_SECRET);
        boolean exist = ossClient.doesBucketExist(OssProperties.BUCKET_NAME);
        if (!exist) {
            // 创建存储空间。
            ossClient.createBucket(OssProperties.BUCKET_NAME);
            //https://srbtest1.oss-cn-beijing.aliyuncs.com/srbfile/222.jpg
            ossClient.setBucketAcl(OssProperties.BUCKET_NAME, CannedAccessControlList.PublicRead);
        }
        String dateTime = new DateTime().toString("yyyy/MM/dd");
        fileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
        // 依次填写Bucket名称（例如examplebucket）和Object完整路径（例如exampledir/exampleobject.txt）。Object完整路径中不能包含Bucket名称。
        String key = module + "/" + dateTime + "/" + fileName;
        ossClient.putObject(OssProperties.BUCKET_NAME, key, inputStream);
        // 关闭OSSClient。
        ossClient.shutdown();
        return "https://" + OssProperties.BUCKET_NAME + "." + OssProperties.ENDPOINT + "/" + key;
    }

    @Override
    public void removeFile(String url) {
        //https://srbtest1.oss-cn-beijing.aliyuncs.com/srbfile/2021/09/11/12c8b400-d90e-4155-b9d9-5b7600646278.png
        String host = "https://" + OssProperties.BUCKET_NAME + "." + OssProperties.ENDPOINT + "/";
        String fileName = url.substring(host.length());
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(OssProperties.ENDPOINT, OssProperties.KEY_ID, OssProperties.KEY_SECRET);

        // 删除存储空间。
        // ossClient.deleteBucket(OssProperties.BUCKET_NAME,fileName);
        ossClient.deleteObject(OssProperties.BUCKET_NAME, fileName);

        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
