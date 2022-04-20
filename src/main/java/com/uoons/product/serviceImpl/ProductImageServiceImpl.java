package com.uoons.product.serviceImpl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.uoons.product.service.ProductImageService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductImageServiceImpl implements ProductImageService{

    @Value("${bucketName}")
    private String bucketName;


    private final AmazonS3 s3;

    public ProductImageServiceImpl(AmazonS3 s3) {
        this.s3 = s3;
    }

    @Override
    public List<URL> saveImage(MultipartFile[] file) {

//        List<String> fileNames = new ArrayList<>();
//        Arrays.asList(file).stream().forEach(files -> {
//            fileNames.add(files.getOriginalFilename());
//        });

        List<URL> convfiles = new ArrayList<>();
        Arrays.asList(file).stream().forEach(file1 -> {
            try {

                PutObjectResult putObjectResult = s3.putObject(bucketName, file1.getOriginalFilename()
                        , convertMultiPartToFile(file1));
                convfiles.add(s3.getUrl(bucketName, file1.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return convfiles;

    }

    @Override
    public URL savethumb(MultipartFile thumb) {
        try {
            File file1 = convertMultiPartToFile(thumb);
            PutObjectResult putObjectResult = s3.putObject(bucketName, thumb.getOriginalFilename(), file1);
            System.out.println(s3.getUrl(bucketName,thumb.getOriginalFilename()));
//            return putObjectResult.getContentMd5();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return s3.getUrl(bucketName,thumb.getOriginalFilename());
    }

    private File convertMultiPartToFile(MultipartFile file1) throws IOException {
        File convFile = new File(file1.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file1.getBytes());
        fos.close();
        return convFile;
    }

}
