package com.pinxixi.service.admin;

import com.pinxixi.controller.admin.vo.FileVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface AdminUploadService {

    FileVO uploadFile(MultipartFile file, HttpServletRequest httpServletRequest);
}
