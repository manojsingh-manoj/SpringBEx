package com.boot.hello.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	int j=1;
	@RequestMapping("/hello")
	public String greetings3() {	
		
		return "Hello there! How are you?.....   " + System.getenv("HOSTNAME");
		
	}

	@RequestMapping("/sec")
	public String readSecret1() {
		   StringBuffer sb = new StringBuffer();
        try (InputStream input = new FileInputStream("/opt/app-root/myapp.sec")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
         
            sb.append(prop.getProperty("db.url")).append("--------").append(prop.getProperty("db.user")).append("------").append(prop.getProperty("db.password"));
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb.toString();
    }
	
	@RequestMapping("/cm")
	public String readConfig(){
		   StringBuffer sb = new StringBuffer();
        
         
            sb.append(System.getenv("welcome.message")).append("--------").append(System.getenv("current.environment")).append("------");
            
        return sb.toString();
    }
}
