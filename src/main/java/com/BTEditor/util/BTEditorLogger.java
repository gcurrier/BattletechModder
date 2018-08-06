package com.BTEditor.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BTEditorLogger {

  public void info(String fileName, String msg, String filePath) {
    Logger logger = Logger.getLogger(fileName);
    FileHandler fh;
    try {
      fh = new FileHandler(filePath);
      logger.addHandler(fh);
      SimpleFormatter formatter = new SimpleFormatter();
      fh.setFormatter(formatter);
    } catch (SecurityException se) {
      se.printStackTrace();
    } catch (IOException ie) {
      ie.printStackTrace();
    }
    logger.info(msg);
  }
}
