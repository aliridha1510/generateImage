package org.fhb.image;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;

@org.springframework.web.bind.annotation.RestController

public class RestController {
  // Upload File with BucketName 
	@RequestMapping("/Mandelbrot/generateToS3")
	@ResponseBody          // antwort JSON type Response
	public Response bild(@RequestParam("bucketname") String bucketname) throws IOException {
		AWSCredentials Credentials = new BasicAWSCredentials("AKIAI6D65YVGCS22CG6A",
				"Hbydaugd6ORiHbWMWBTi6D0riYhIQjkQ76gWHcyG");
		UploadFile s3client = new UploadFile(bucketname);
		Image img = new Image();
		File f = img.generateimage();
		s3client.uploadfile(Credentials, f);
		/// s3client.deletefile(Credentials);
		// s3client.downloadfile(Credentials);
		return new Response("OK  Generate  Form to S3");

	}

	@RequestMapping("/Mandelbrot/deleteFromS3")
	@ResponseBody
	public Response delete(@RequestParam("bucketname") String bucketname) throws IOException {
		AWSCredentials Credentials = new BasicAWSCredentials("AKIAI6D65YVGCS22CG6A",
				"Hbydaugd6ORiHbWMWBTi6D0riYhIQjkQ76gWHcyG");
		UploadFile s3client = new UploadFile(bucketname);
		Image img = new Image();
		File f = img.generateimage();
		System.out.println(bucketname);
		// s3client.uploadfile(Credentials, f);
		s3client.deletefile(Credentials);
		// s3client.downloadfile(Credentials);
		return new Response("Oki Mandelbort Delete Form S3 AWS  !!");
	}

}
