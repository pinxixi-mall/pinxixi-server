package com.pinxixi.service.admin;

import com.pinxixi.controller.admin.vo.FileVO;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    FileVO uploadFile(MultipartFile file);
}
