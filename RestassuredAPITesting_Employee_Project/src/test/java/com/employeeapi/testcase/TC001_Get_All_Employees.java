package com.employeeapi.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_Get_All_Employees extends TestBase{
	
	
	@BeforeClass
	void getAllEmployees() throws InterruptedException {
		
		logger.info("********** Started TC001_Get_All_Employees****************");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/employees");
		Thread.sleep(5000);
	}
	
	@Test(priority=1)
	void checkResponsebody() {
		logger.info("**************checking response Body**********************");
		String responseBody =response.getBody().asString();
		logger.info("Response Body ==>"+responseBody);
		Assert.assertTrue(responseBody!=null);
	}
	
	@Test
	void checkStatusCode() {
		
		logger.info("****************Checking status code**********************");
		int statuscode=response.getStatusCode();
		logger.info("Status code is  "+statuscode); //200
		Assert.assertEquals(statuscode,200);
	}
	
	@Test
	void checkResponseTime() {
		logger.info("****************Checking Response Time********************");

		long responseTime=response.getTime();
		logger.info("Response time is "+responseTime);
		if(responseTime>2000)
			logger.warn("Response time is greater than 2000");
		Assert.assertTrue(responseTime<10000);
	}
	
	@Test
	void checkStatusLine() {
		logger.info("*************Checking Status Line ****************");
		String statusLine=response.getStatusLine();
		logger.info("status Line  "+statusLine);
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
	}

	
	@Test
	void checkContentType() {
		logger.info("*************Checking Content type********************");
		String contentType=response.header("Content-Type");
		logger.info("Content type is  "+contentType);
		Assert.assertEquals(contentType,"text/html; charset=UTF-8");
	}
	
	
	@Test
	void checkserverType() {
		logger.info("***************Checking server type*****************");
		String servertype=response.header("Server");
		logger.info("server Type is "+servertype);
		//Assert.assertEquals(servertype,"nginx/1.14.1"); //Apache-->Found
		
	}
	
    @Test
    void checkContentLength() {
    	logger.info("***************Checking conetent length****************");
    	String contentLength=response.header("Content-Length");
    	logger.info("Content length is "+contentLength);
    	
    	if(Integer.parseInt(contentLength)<100)
    		logger.warn("Content length is less than 100");
    		Assert.assertTrue(Integer.parseInt(contentLength)>100);
    	
    }
    
    @Test
    void checkCookies() {
    	logger.info("***************Checking Cookie************************");
    	String cookie=response.header("PHPSESSID");
    	
    }
    @AfterClass
    void tearDown() {
    	logger.info("********Finished TC001_Get+All_Employees **************");
    }

}
