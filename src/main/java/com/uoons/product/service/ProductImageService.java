package com.uoons.product.service;

import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.util.List;

public interface ProductImageService {

    List<URL> saveImage(MultipartFile[] file);

    URL savethumb(MultipartFile thumb);
}
