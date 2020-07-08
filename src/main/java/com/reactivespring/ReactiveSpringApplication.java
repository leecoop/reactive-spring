package com.reactivespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class ReactiveSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveSpringApplication.class, args);
	}

//	@EventListener({ApplicationReadyEvent.class})
//	public void applicationReadyEvent() {
//		System.out.println("Application started ... launching browser now");
//		browse("http://localhost:8080/v1/items");
//	}
//
//	public static void browse(String url) {
//		if(Desktop.isDesktopSupported()){
//			Desktop desktop = Desktop.getDesktop();
//			try {
//				desktop.browse(new URI(url));
//			} catch (IOException | URISyntaxException e) {
//				e.printStackTrace();
//			}
//		}else{
//			Runtime runtime = Runtime.getRuntime();
//			try {
//				runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
}
