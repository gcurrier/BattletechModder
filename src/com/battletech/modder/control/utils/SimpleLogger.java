package com.battletech.modder.control.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleLogger {
	
	public SimpleLogger() {}
	
	public DateFormat dateFormat;

	/**
	 * @return the dateFormat
	 */
	public DateFormat getDateFormat() {
		return dateFormat;
	}

	/**
	 * @param dateFormat the dateFormat to set
	 */
	public void setDateFormat(DateFormat dateFormat) {
		this.dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	}

	public void logDebug(String msg) {
		Date dte = new Date();
		System.out.println("[" + dateFormat.format(dte) + "]" + " [DEBUG]: " + msg);
	}

	public void logError(String msg) {
		Date dte = new Date();
		System.out.println("[" + dateFormat.format(dte) + "]" + " [ERROR]: " + msg);
	}

	public void logWarning(String msg) {
		Date dte = new Date();
		System.out.println("[" + dateFormat.format(dte) + "]" + " [WARN]: " + msg);
	}

	public void logInfo(String msg) {
		Date dte = new Date();
		System.out.println("[" + dateFormat.format(dte) + "]" + " [INFO]: " + msg);
	}

}
