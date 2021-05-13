package com.capgemini.lms.ui;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.capgemini.lms.utils.MainUtils;

public class MyApplication {
	public static void main(String[] args) throws IOException {
		Logger logger = LogManager.getLogger("MyApplication.class");
		MainUtils mainUtils = new MainUtils();
		logger.info("Instantiated MyApplication.");
		try {
			mainUtils.start();
		} catch (Exception e) {
			System.out.println("Book Not found");
			e.printStackTrace();
		}
	}
}
