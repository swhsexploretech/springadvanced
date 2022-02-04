package com.spring.aws.integrate.s3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.s3.model.Bucket;
import com.spring.aws.integrate.s3.service.S3Service;

@RestController
@RequestMapping("/aws/s3")
public class S3Controller {
	
	@Autowired
	private S3Service s3Service;
	
	@GetMapping("/getListOfBuckets")
	public List<Bucket> getListOfS3Buckets(){
		return s3Service.getListOfS3Buckets();
	}
	
	@PostMapping("/create-s3-bucket")
	public void createS3Bucket(@RequestParam(name = "bucketName")String bucketName) {
		s3Service.createS3Bucket(bucketName);
	}
	
	@DeleteMapping("/delete-s3-bucket")
	public void deleteS3Bucket(@RequestParam(name = "bucketName") String bucketName) {
		s3Service.deleteBucketName(bucketName);
	}
	
	@PostMapping("/upload-s3-object")
	public void uploadObjectToS3Bucket(@RequestParam(name = "bucketName") String bucketName) {
		s3Service.uploadFileToS3Bucket(bucketName);
	}

}
