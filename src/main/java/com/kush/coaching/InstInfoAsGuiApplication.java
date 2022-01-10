package com.kush.coaching;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.kush.coaching.gui.LoginFrame;

@SpringBootApplication
public class InstInfoAsGuiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(InstInfoAsGuiApplication.class)
				.headless(false)
				.run(args);
		
		LoginFrame.login();
	}
}