package com.joa.myComputer;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class ShellCmdExec extends ShellCmdBase{
	
	String pcinfo() {
		String computerInfo="";

		try {
			computerInfo = getCmdResultString(runtime.exec("uname -a"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return computerInfo;
	}
	
	String reset() {
		try {
			runtime.exec("reboot");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "reset OK";
	}
	
	String shutdown() {	
        try {
            runtime.exec("shutdown now");
        } catch (IOException e) {
            e.printStackTrace();
        }
		return "Shutdownning...";
	}
}
