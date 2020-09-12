package com.joa.myComputer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ShellCmdBase {
    protected Runtime runtime = Runtime.getRuntime();
	
	protected String getCmdResultString(Process p) {
		StringBuffer result = new StringBuffer();
		InputStream is = p.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				result.append(line + "\n");
			}
			p.waitFor();
			is.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return result.toString();
	}
}
