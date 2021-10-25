package com.mindtree.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.FileAppender;

public class Log extends FileAppender {

	@Override
	public void setFile(String fileName) {
		if (fileName.indexOf("%timestamp") >= 0) {
			Date d = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss");
			fileName = fileName.replaceAll("%timestamp", format.format(d));
		}
		super.setFile(fileName);
	}
}
