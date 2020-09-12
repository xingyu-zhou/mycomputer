package com.joa.myComputer;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class PcStratup extends ShellCmdBase{
	
	void run(){
		googleDriveOcamlfuse();
	}
	
	void googleDriveOcamlfuse(){		
		try {
			runtime.exec("google-drive-ocamlfuse ~/mygoogledrive");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
