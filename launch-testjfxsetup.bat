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
