<!--<h1 align="center">
  <br>
  <a href="https://github.com/gcurrier/BattletechModder/blob/master/resources/Battletech-Mercs-Logo.png">
    <img src="https://github.com/gcurrier/BattletechModder/blob/master/resources/Battletech-Mercs-Logo.png" alt="BattletechModder" width="200">
  </a>
  <br>
  BattletechModder
  <br>
</h1>-->
# BattletechModder
![logo](https://github.com/gcurrier/BattletechModder/blob/master/resources/Battletech-Mercs-Logo.png)


A Desktop tool written in Java, using JavaFX, to make modifying Battletech configuration files easier and more controlled, thereby preventing accidental breaking of the Mulitplayer mode with a "bad" config.

## Current Version
- 0.2.1a

## Supported Platforms

Windows 7,10 

## Overview
- [BattletechModder Wiki page](https://github.com/gcurrier/BattletechModder/wiki)
    Details on how to download, install and run the app.

- [BattletechModder webpage](https://gcurrier.github.io/BattletechModder/)
    Shows this README file, but as a webpage with its own address

## Project

### Download

The BattletechModder repository maybe either be downloaded by clicking [here](https://github.com/gcurrier/BattletechModder/archive/master.zip) or by cloning the repository like so:
```
cd <whatever directory you choose>
git clone https://github.com/gcurrier/BattletechModder.git
cd BattletechModder
git status
```

### Build

- This project was built using Eclipse (Oxygen.3), JavaFX, SceneBuilder and uses InnoSetup 5 as the Install package tool. 
- I also chose to build it as a Native app, so that everything required is packaged with it.
    The JavaX library in Java10 currently has some issues with SceneBuilder
    
_Note: you will need to have the latest version of InnoSetup (or some other installer build tool) installed on your system, recognizable by Ant, for packaging into .exe format._
1. Open Eclipse into a new workspace (or create one) then Copy the __entire__ BattletechModder directory into the workspace.
2. Restart eclipse, switch to that workspace and the project "should" be available.
3. Navigate to the **build** folder, right click on **build.xml** and hover over the context option **Run As...**.
4. Select the **Ant Build** option associated with the workspace
5. Build times may vary, but the build usually completes within a minute.

## Author

- Glen Currier (sole contributor)

## License

This project is licensed under the GNU License - see the [LICENSE](LICENSE) file for details

## Acknowledgments

* Acknowledgement to the imagery used from the  Steam Community
* Harebrained schemes (for the game)
* Users on Reddit for the discovery/explanation of how to manipulate the files
* me (for thinking up my own "hare-brained" scheme to do this...)
