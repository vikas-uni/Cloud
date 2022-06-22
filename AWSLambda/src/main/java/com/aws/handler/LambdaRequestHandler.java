package com.aws.handler;

import java.util.logging.Handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.event.S3EventNotification.S3EventNotificationRecord;
import com.aws.util.Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LambdaRequestHandler
implements RequestHandler<S3Event , String> {
  /*public String handleRequest(String input, Context context) {
      context.getLogger().log("Input: " + input);
      return "Hello World from java lambda - " + input;
  }*/
	
	//private static final Logger logger = LoggerFactory.getLogger(Handler.class);
	  Gson gson = new GsonBuilder().setPrettyPrinting().create();
	  
	  public String handleRequest(S3Event event, Context context)
	  {
	    String response = new String("****200 OK****");
	    S3EventNotificationRecord record = event.getRecords().get(0);
	    String srcBucket = record.getS3().getBucket().getName();
	    // Object key may have spaces or unicode non-ASCII characters.
	    String srcKey = record.getS3().getObject().getUrlDecodedKey();
	    context.getLogger().log("RECORD: " + record);
	    context.getLogger().log("SOURCE BUCKET: " + srcBucket);
	    context.getLogger().log("SOURCE KEY: " + srcKey);
	    context.getLogger().log(":::lambda logger:::");
	    // log execution details
	    Util.logEnvironment(event, context, gson);
	    return response;
	  }
}
