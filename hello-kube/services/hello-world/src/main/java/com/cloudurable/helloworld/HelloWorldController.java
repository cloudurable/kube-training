package com.cloudurable.helloworld;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;

@RestController
public class HelloWorldController {

	@RequestMapping(value="/", produces= "text/html")
	public String index() {
		return "<html><body>Hello World</body><html>";
	}

}