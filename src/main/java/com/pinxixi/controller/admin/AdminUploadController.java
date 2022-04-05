package com.pinxixi.controller.admin;

import com.pinxixi.common.Result;
import com.pinxixi.controller.admin.vo.FileVO;
import com.pinxixi.service.admin.AdminUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


@RestController
@Api(tags = "公共上传")
@RequestMapping("/admin/upload")
public class AdminUploadController {

    @Autowired
    private AdminUploadService adminUploadService;

    /**
     * 单文件上传
     * @param file
     * @return
     */
    @ApiOperation("单文件上传")
    @PostMapping("/file")
    public Result<FileVO> upload(@RequestParam("file") MultipartFile file, HttpServletRequest httpServletRequest) {
        if (file.isEmpty()) {
            return Result.fail("文件为空");
        }
        FileVO fileVO = adminUploadService.uploadFile(file, httpServletRequest);
        if (fileVO != null){
            return Result.success(fileVO);
        }
        return Result.fail();
    }
}
