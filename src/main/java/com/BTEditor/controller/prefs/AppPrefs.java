package com.BTEditor.controller.prefs;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class AppPrefs {
  private Preferences preferences;

  /**
   * Sets application level preferences by entering a key in registry
   * (HKEY_CURRENT_USER): HKCU\Software\JavaSoft\Prefs\
   */
  public AppPrefs() {
    preferences = Preferences.userRoot().node(this.getClass().getName());
  }

  /**
   * @return
   */
  public String getGameHomeDir() {

    return preferences.get("gameHomeDir", "C://");
  }

  /**
   * @return
   */
  public String getWorkingDir() {

    return preferences.get("workingDir", "C:\\");
  }

  /**
   * @return
   */
  public String getBackupDir() {

    return preferences.get("backupDir", "C:\\");
  }

  /**
   * @param path
   */
  public void setGameHomeDir(String path) {

    preferences.put("gameHomeDir", path);
  }

  /**
   * @param path
   */
  public void setWorkingDir(String path) {

    preferences.put("workingDir", path);
  }

  /**
   * @param path
   */
  public void setBackupDir(String path) {

    preferences.put("backupDir", path);
  }

  /**
   * @throws BackingStoreException
   */
  public void clear() throws BackingStoreException {
    preferences.clear();
  }
}
