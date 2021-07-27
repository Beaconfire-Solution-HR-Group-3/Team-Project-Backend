package com.example.hrteamproject.Server;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//public static
//public static String bucketName = System.getenv("S3_IMAGE_BUCKET_NAME");
//public static String awsAccessKeyId = System.getenv("AWS_ACCESS_KEY_ID");
//public static String awsSecretAccessKey = System.getenv("AWS_SECRET_ACCESS_KEY");
@Service
public class UploadS3Service {
    @Value("${aws.region}")
    String region;

    @Value("${aws.bucketName}")
    String bucketName;

    @Value("${aws.accessKey}")
    String awsAccessKeyId;

    @Value("${aws.secretyAccessKey}")
    String awsSecretAccessKey;




    public String uploadToS3(MultipartFile file, String name) {
        Regions clientRegion = Regions.fromName(region);
        try {
            AWSCredentials creds = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withRegion(clientRegion).withCredentials(new AWSStaticCredentialsProvider(creds))
                    .build();
            ObjectMetadata data = new ObjectMetadata();
            data.setContentType("pdf");
            data.setContentLength(file.getSize());
            s3Client.putObject(bucketName, name , file.getInputStream(),data);
            String url = s3Client.getUrl(bucketName, name).toString();
            return url;
        } catch (AmazonServiceException e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
