package com.aws.util;

import com.amazonaws.services.lambda.runtime.Context;
//import com.amazonaws.services.lambda.runtime.LambdaLogger;

import com.google.gson.Gson;



public class Util {
  //private static final Logger logger = LoggerFactory.getLogger(Util.class);

  public static void logEnvironment(Object event, Context context, Gson gson)
  {
    // log execution details
	  context.getLogger().log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
	  context.getLogger().log("CONTEXT: " + gson.toJson(context));
    // log event details
	  context.getLogger().log("EVENT: " + gson.toJson(event));
	  context.getLogger().log("EVENT TYPE: " + event.getClass().toString());
  }
}