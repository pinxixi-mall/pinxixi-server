package com.pinxixi.service.admin.impl;

import cn.hutool.core.date.DateUtil;
import com.pinxixi.common.Constants;
import com.pinxixi.controller.admin.vo.FileVO;
import com.pinxixi.service.admin.AdminUploadService;
import com.pinxixi.utils.PinXiXiUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AdminUploadServiceImpl implements AdminUploadService {

    /**
     * 单文件上传
     * @param file
     * @return
     */
    @Override
    public FileVO uploadFile(MultipartFile file) {
        //文件全名名
        String filename = file.getOriginalFilename();
        Matcher matcher = Pattern.compile("^(.*)\\.([a-zA-Z0-9]+)$").matcher(filename);
        //文件名
        String name = "";
        //文件后缀名
        String suffixName = "";
        if (matcher.find()) {
            name = matcher.group(1);
            suffixName = matcher.group(2);
        }
        //组装新文件名
        String newFilename = name + "_" + DateUtil.format(new Date(), "yyyyMMddHHmmss") + "." + suffixName;
        //文件夹
        File fileDir = getResourcesDir(Constants.UPLOAD_DIR);

        //新文件
        File newFile = new File(fileDir.getAbsolutePath() + File.separator + newFilename);

        try {
            //写入文件
            file.transferTo(newFile);
            String fileUrl = PinXiXiUtils.getHostPort() + "/" + Constants.UPLOAD_DIR + "/" + newFilename;
            FileVO fileVO = new FileVO();
            fileVO.setName(newFilename);
            fileVO.setUrl(fileUrl);
            return fileVO;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成上传路径
     * @param dir
     * @return
     */
    public static File getResourcesDir(String dir) {
        String dirPath = new String("src/main/resources/" + dir);
        File fileDir = new File(dirPath);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        return fileDir;
    }
}
