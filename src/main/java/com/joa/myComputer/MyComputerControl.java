package com.joa.myComputer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MyComputerControl {
	@Autowired
	ShellCmdExec shell;
	
	@RequestMapping("/")
	String hello() {
		return shell.pcinfo();
	}
	
	@RequestMapping(value = "/C/reset")
	String reset() {
		return shell.reset();
	}
	
	@RequestMapping(value = "/C/Powerdown")
	String shutdown() {	
		return shell.shutdown();
	}

	public static void main(String[] args) {
		// PC Startup Execute
		new PcStratup().run();
		
		// Start Web 
		SpringApplication.run(MyComputerControl.class, args);
	}

}
