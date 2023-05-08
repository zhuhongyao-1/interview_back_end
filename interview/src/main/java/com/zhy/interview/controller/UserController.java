package com.zhy.interview.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zhy.interview.entity.CollectionInfo;
import com.zhy.interview.entity.Title;
import com.zhy.interview.entity.User;
import com.zhy.interview.exception.BusinessException;
import com.zhy.interview.service.CollectionInfoService;
import com.zhy.interview.service.FileService;
import com.zhy.interview.service.TitleService;
import com.zhy.interview.service.UserService;
import com.zhy.interview.utils.R;
import com.zhy.interview.utils.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @date: 223/4/22 16:32
 * @description:
 */
@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private FileService fileService;

    @Resource
    private TitleService titleService;

    @Resource
    private CollectionInfoService collectionInfoService;



    @GetMapping("/incrCollection")
    @Transactional(rollbackFor = Exception.class)
    public R incrCollection(String userId, String titleId) {
        CollectionInfo collectionInfo = new CollectionInfo();
        collectionInfo.setUserid(Integer.valueOf(userId));
        collectionInfo.setTitleid(Integer.valueOf(titleId));
        int collectionCount = collectionInfoService.count(new QueryWrapper<CollectionInfo>().eq("userId", userId).eq("titleId", titleId));
        if (collectionCount == 0) {
            collectionInfoService.save(collectionInfo);
        }

        User user = userService.getById(userId);
        int userIdCount = collectionInfoService.count(new QueryWrapper<CollectionInfo>().eq("userId", userId));
        user.setCollectionCount(userIdCount + user.getCollectionCount());
        userService.update(user, new QueryWrapper<User>().eq("id", userId));

        Title title = titleService.getById(titleId);
        int titleCount = collectionInfoService.count(new QueryWrapper<CollectionInfo>().eq("titleId", titleId));
        title.setCollectionNumber(titleCount +title.getCollectionNumber());
        titleService.update(title, new QueryWrapper<Title>().eq("id", titleId));

        return R.ok().setData(title);
    }


    @GetMapping("/decrCollection")
    @Transactional(rollbackFor = Exception.class)
    public R decrCollection(String userId, String titleId) {



        User user = userService.getById(userId);
        int userIdCount = collectionInfoService.count(new QueryWrapper<CollectionInfo>().eq("userId", userId));
        user.setCollectionCount(user.getCollectionCount() - userIdCount);
        userService.update(user, new QueryWrapper<User>().eq("id", userId));

        Title title = titleService.getById(titleId);
        int titleCount = collectionInfoService.count(new QueryWrapper<CollectionInfo>().eq("titleId", titleId));
        title.setCollectionNumber(title.getCollectionNumber() - titleCount);
        titleService.update(title, new QueryWrapper<Title>().eq("id", titleId));

        int collectionCount = collectionInfoService.count(new QueryWrapper<CollectionInfo>().eq("userId", userId).eq("titleId", titleId));
        if (collectionCount > 0) {
            collectionInfoService.remove(new QueryWrapper<CollectionInfo>().eq("userId", userId).eq("titleId", titleId));
        }

        return R.ok().setData(title);
    }

    @GetMapping("/register")
    public R register(String username, String password) {
        User userByMySQL = userService.getOne(new QueryWrapper<User>().eq("username", username));
        if (userByMySQL != null) {
            return R.error("当前用户已经存在");
        } else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setCreateTime(DateUtil.date());
            user.setIntroduction("这个人很懒，没有留下介绍");
            user.setHeadUrl("https://srbtest1.oss-cn-beijing.aliyuncs.com/interview/head/WechatIMG37.jpeg");
            userService.save(user);
            return R.ok();
        }
    }

    @GetMapping("/checksearchuser")
    public R login(String username, String pass) {
        User user = userService.getOne(new QueryWrapper<User>().eq("username", username));
        if (user == null) {
            return R.error("当前用户不存在");
        } else {
            if (!pass.equals(user.getPassword())) {
                return R.error("密码错误");
            } else {
                return R.ok().setData(user);
            }
        }
    }

    @GetMapping("/baseInfo")
    public R baseInfo(String username) {
        User user = userService.getOne(new QueryWrapper<User>().eq("username", username));
        if (user == null) {
            return R.error("当前用户不存在");
        } else {
            return R.ok().setData(user);
        }
    }

    @PostMapping("/update")
    public R saveInfo(@RequestBody User user) {
        log.info("user{}", user);
        userService.updateById(user);
        return R.ok().setData(user);
    }

    @PostMapping("/pictureUpload")
    public R pictureUploadDo(MultipartFile file,
                             String module) {
        try {
            InputStream inputStream = file.getInputStream();
            String originalFilename = file.getOriginalFilename();
            String upload = fileService.upload(inputStream, module, originalFilename);
            return R.ok().setData(upload);
        } catch (IOException e) {
            throw new BusinessException(ResponseEnum.UPLOAD_ERROR, e);
        }
    }

    @GetMapping("/searchuser")
    public R searchUser(String username) {
        User user = userService.getOne(new QueryWrapper<User>().eq("username", username));
        if (user == null) {
            return R.error("当前用户不存在");
        } else {
            return R.ok().setData(user);
        }
    }


}
