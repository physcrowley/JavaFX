# Using `launch-<app>` batch files instead of argsfiles with `javac` and `java`

Instead of operating with the following compile / run structure :
```
javac @compile-argsfile
java @run-argsfile
```
with a typical `compile-argsfile` containing:
```
-d bin

--module-path "C:/Program Files/JavaFX/javafx-sdk-11.0.2/lib" 
--add-modules javafx.controls

edu/djc/<subpackage>/<App>.java
```

and a typical `run-argsfile` containing:
```
-cp bin

--module-path "C:/Program Files/JavaFX/javafx-sdk-11.0.2/lib" 
--add-modules javafx.controls

edu.djc.<subpackage>.<App>
```

it is more plug-in/IDE-like to use a **"launch"** paradigm. So batch files have been created to replace both the compile and run commands with a single command: `launch-<app>.bat` which can be simply written `launch-<app>` on the Windows command line (or `./launch-<app>` in PowerShell).

The contents of a simple launch file are:
```
javac -d bin ^
--module-path "C:/Program Files/JavaFX/javafx-sdk-11.0.2/lib" ^
--add-modules javafx.controls ^
edu/djc/<subpackage>/<App>.java

java -cp bin ^
--module-path "C:/Program Files/JavaFX/javafx-sdk-11.0.2/lib" ^
--add-modules javafx.controls ^
edu.djc.<subpackage>.<App>
```

To not see these commands echoed to the command line, you can add the `@` symbol before `javac` and before `java`.

## Really getting into it
For a more complete (non-modular) JavaFX batch file, see [launch-testjfxsetup.cmd](launch-testjfxsetup.cmd). It includes setting project variables and copying project resources, like `fxml` and `css` files, into the classpath.

Here is a copy of the file as of 2020-10-23:
```bat
@echo off
rem ====================MANUAL=========================

rem Set source directory / package
set source-dir=edu/djc/testjfxsetup

rem Set output directory
set output=bin

rem Set module dependencies: separate paths with ; and modules with ,
set module-path="C:/Program Files/JavaFX/javafx-sdk-11.0.2/lib"
set modules=javafx.controls,javafx.fxml

rem Set sources: include all .java files in the sources variable as a space-separated list
set main-class=App
set sources=%source-dir%/%main-class%.java

rem =================AUTOMATIC==========================

set source-dir-win=%source-dir:/=\%
set package=%source-dir:/=.%

rem Compile
javac -d %output% ^
--module-path %module-path% ^
--add-modules %modules% ^
%sources%

rem Copy project resources to classpath
copy %source-dir-win%\resources\*.fxml %output%\%source-dir-win%
copy %source-dir-win%\resources\*.css  %output%\%source-dir-win%

rem Run
@echo on
java -cp %output% ^
--module-path %module-path% ^
--add-modules %modules% ^
%package%.%main-class%

```