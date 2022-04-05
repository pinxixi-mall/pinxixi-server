package com.pinxixi.service.admin.impl;

import cn.hutool.core.date.DateUtil;
import com.pinxixi.common.Constants;
import com.pinxixi.config.PinXiXiException;
import com.pinxixi.controller.admin.vo.FileVO;
import com.pinxixi.service.admin.AdminUploadService;
import com.pinxixi.utils.PinXiXiUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
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
    public FileVO uploadFile(MultipartFile file, HttpServletRequest httpServletRequest) {
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
        //新文件
        File newFile = new File(getUploadPath() + File.separator + newFilename);

        try {
            //写入文件
            file.transferTo(newFile);
            //upload对应WebMvcConfig里配置的addResourceHandler
            String fileUrl = PinXiXiUtils.getServerAddress() + "/upload/" + newFilename;
            FileVO fileVO = new FileVO();
            fileVO.setName(newFilename);
            fileVO.setUrl(fileUrl);
            return fileVO;
        } catch (IOException e) {
            e.printStackTrace();
            PinXiXiException.error(500, e.getMessage());
            return null;
        }
    }

    /**
     * 生成上传路径
     * @return
     */
    private String getUploadPath() {
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (!path.exists()) path = new File("");
        File upload = new File(path.getAbsolutePath(), Constants.UPLOAD_DIR);
        if (!upload.exists()) upload.mkdirs();
        return upload.getAbsolutePath();
    }
}
