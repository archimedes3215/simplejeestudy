package com.yuqiaotech.simplejee.javase.io;

import java.io.File;
import java.io.FilenameFilter;

import org.junit.Test;

public class IOTest {

	@Test
	public void testIteratorDirectory() {
		String user_home = System.getProperty("user.home");
		System.out.println("user_home" + user_home);
		File f = new File(user_home
				+ "\\AppData\\Local\\Microsoft\\Windows\\Temporary Internet Files");
		iterator(f, "");
	}

	public static void iterator(File f, String indent) {
		// TODO Auto-generated method stub
		System.out.println(indent + f.getName());
		if (f.isDirectory()) {
			File[] fss = f.listFiles(new FilenameFilterImp());
			for (int j = 0; j < fss.length; j++) {
				iterator(fss[j], indent + " ");
			}
		}
	}

	static class FilenameFilterImp implements FilenameFilter {

		@Override
		public boolean accept(File dir, String name) {
			// TODO Auto-generated method stub
			File f = new File(dir, name);
			if (f.isDirectory()) {
				return true;
			}
			String lowerCaseStr = name.toLowerCase();
			return (lowerCaseStr.endsWith(".gif") || lowerCaseStr
					.endsWith(".jpg"));
		}

	}
}
