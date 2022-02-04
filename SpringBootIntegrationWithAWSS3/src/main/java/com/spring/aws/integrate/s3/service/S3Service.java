package com.spring.aws.integrate.s3.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

@Service
public class S3Service {
	
	@Autowired
	private Environment environment;
	
	public List<Bucket> getListOfS3Buckets(){
		
		AWSCredentials credentials = new BasicAWSCredentials
				(environment.getProperty("aws.access.key"), environment.getProperty("aws.secret.key"));
		AmazonS3 s3client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.US_EAST_1)
				  .build();
		
		List<Bucket> buckets = s3client.listBuckets();
		for(Bucket bucket : buckets) {
		    System.out.println(bucket.getName());
		}
		
		return buckets;
		
	}

	public void deleteBucketName(String bucketName) {
		AWSCredentials credentials = new BasicAWSCredentials
				(environment.getProperty("aws.access.key"), environment.getProperty("aws.secret.key"));
		AmazonS3 s3client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.US_EAST_1)
				  .build();
		try {
			s3client.deleteBucket(bucketName);
		}catch(AmazonServiceException ex) {
			System.err.println("Error occured while deleting the bucket"+ex.getErrorMessage());
		}
	}

	public String createS3Bucket(String bucketName) {
		AWSCredentials credentials = new BasicAWSCredentials
				(environment.getProperty("aws.access.key"), environment.getProperty("aws.secret.key"));
		AmazonS3 s3client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.US_EAST_1)
				  .build();
		
		if(s3client.doesBucketExist(bucketName)) {
		    System.out.println("Bucket name is not available."
		      + " Try again with a different Bucket name.");
		    return "Bucket already exists";
		}

		s3client.createBucket(bucketName);	
		return "Bucket is successfully created"+bucketName;		
	}

	public void uploadFileToS3Bucket(String bucketName) {
		AWSCredentials credentials = new BasicAWSCredentials
				(environment.getProperty("aws.access.key"), environment.getProperty("aws.secret.key"));
		AmazonS3 s3client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.US_EAST_1)
				  .build();
		
		s3client.putObject(bucketName,"Document/hello.txt",new File("C:\\Users\\swhs\\Desktop\\ThingsToUpdateR.txt"));
		
	}

}
