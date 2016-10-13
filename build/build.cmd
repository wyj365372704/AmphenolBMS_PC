set RELEASE_HOME=./..

rem Tomcat的安装路径(必须修改)
set TOMCAT_HOME=D:/Apache Software Foundation/apache-tomcat-6.0.32

rem ant的安装路径(必须修改)
set ANT_HOME=D:/MyEclipse6.5/eclipse/plugins/org.apache.ant_1.7.0.v200706080842

rem JAVA JDK的安装路径(必须修改)
set JDK_HOME=C:/Program Files/Java/jdk1.6.0_20
  
set PATH=%PATH%;%ANT_HOME%\bin;%JDK_HOME%\bin

rem 调用编译脚本进行编译
ant -f build.xml clean