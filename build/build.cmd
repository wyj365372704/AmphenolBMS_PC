set RELEASE_HOME=./..

rem Tomcat�İ�װ·��(�����޸�)
set TOMCAT_HOME=D:/Apache Software Foundation/apache-tomcat-6.0.32

rem ant�İ�װ·��(�����޸�)
set ANT_HOME=D:/MyEclipse6.5/eclipse/plugins/org.apache.ant_1.7.0.v200706080842

rem JAVA JDK�İ�װ·��(�����޸�)
set JDK_HOME=C:/Program Files/Java/jdk1.6.0_20
  
set PATH=%PATH%;%ANT_HOME%\bin;%JDK_HOME%\bin

rem ���ñ���ű����б���
ant -f build.xml clean