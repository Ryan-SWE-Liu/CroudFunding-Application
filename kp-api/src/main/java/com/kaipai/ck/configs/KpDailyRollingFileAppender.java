package com.kaipai.ck.configs;

import java.io.File;

import org.apache.log4j.DailyRollingFileAppender;

public class KpDailyRollingFileAppender extends DailyRollingFileAppender{
	public void setFile(String file) {
		System.out.println("===============");
        String filePath = file;
        File fileCheck = new File(filePath);
        if (!fileCheck.exists())
            fileCheck.getParentFile().mkdirs();
        super.setFile(filePath);
    }
}
