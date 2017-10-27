@REM #!/bin/ksh
@REM #-----------------------------------------------------------------------#
@REM #   Copyright (C) 2002 enSOF Technology INC. Allright reserved          #
@REM #-----------------------------------------------------------------------#
@REM #	Program Name	: enstart											#
@REM #	Documents		: Startup mcCUBE Main Engine						#
@REM #	Author			: saturn											#
@REM #	Framing Date	: 2008.05.30										#
@REM #-----------------------------------------------------------------------#

@set SWord_HOME=F:\git\SWordCounter
@set MCCUBE_WORK=C:\eclipse\workspace\KBIZ_mcCUBE\KBIZ
@set MCCUBE_SVC_NAME=McCUBE

@cd %MCCUBE_WORK%

@setlocal

@set CLASSPATH=.;%SWord_HOME%/out
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/lib
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/lib/ext/mcCUBE1.2.jar
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/lib/ext/bsh-2.0b1.jar
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/lib/ext/ojdbc14.jar
@REM CLASSPATH=%CLASSPATH%;%SWord_HOME%/lib/ext/jconn3.jar
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/lib/ext/jtds-1.2.5.jar
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/lib/ext/com.stc.jmsis.jar
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/lib/ext/jms.jar
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/lib/ext/jta.jar
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/lib/ext/commons-codec-1.3.jar
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/lib/ext/webt50.jar

@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/xmllib/activation.jar
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/xmllib/axis.jar
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/xmllib/commons-discovery-0.2.jar
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/xmllib/commons-httpclient.jar
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/xmllib/jaxm-api.jar
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/xmllib/jaxp-api-1.4.jar
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/xmllib/jaxp-ri-1.4.2.jar
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/xmllib/jdom.jar
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/xmllib/log4j-1.2.15.jar
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/xmllib/saaj-api.jar
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/xmllib/saaj-impl.jar
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/xmllib/soap-2.3.1.jar
@set CLASSPATH=%CLASSPATH%;%SWord_HOME%/xmllib/xercesImpl.jar

@set CLASSPATH=%CLASSPATH%;%MCCUBE_WORK%/bin
@set CLASSPATH=%CLASSPATH%;%MCCUBE_WORK%/XMLSERVER/lib/catalina-optional.jar
@set CLASSPATH=%CLASSPATH%;%MCCUBE_WORK%/XMLSERVER/lib/catalina.jar
@set CLASSPATH=%CLASSPATH%;%MCCUBE_WORK%/XMLSERVER/lib/commons-el.jar
@set CLASSPATH=%CLASSPATH%;%MCCUBE_WORK%/XMLSERVER/lib/commons-logging-api-1.1.1.jar
@set CLASSPATH=%CLASSPATH%;%MCCUBE_WORK%/XMLSERVER/lib/commons-modeler-2.0.1.jar
@set CLASSPATH=%CLASSPATH%;%MCCUBE_WORK%/XMLSERVER/lib/jasper-compiler-jdt.jar
@set CLASSPATH=%CLASSPATH%;%MCCUBE_WORK%/XMLSERVER/lib/jasper-compiler.jar
@set CLASSPATH=%CLASSPATH%;%MCCUBE_WORK%/XMLSERVER/lib/jasper-runtime.jar
@set CLASSPATH=%CLASSPATH%;%MCCUBE_WORK%/XMLSERVER/lib/jsp-api.jar
@set CLASSPATH=%CLASSPATH%;%MCCUBE_WORK%/XMLSERVER/lib/log4j.properties
@set CLASSPATH=%CLASSPATH%;%MCCUBE_WORK%/XMLSERVER/lib/naming-factory.jar
@set CLASSPATH=%CLASSPATH%;%MCCUBE_WORK%/XMLSERVER/lib/naming-resources.jar
@set CLASSPATH=%CLASSPATH%;%MCCUBE_WORK%/XMLSERVER/lib/servlet-api.jar
@set CLASSPATH=%CLASSPATH%;%MCCUBE_WORK%/XMLSERVER/lib/servlets-default.jar
@set CLASSPATH=%CLASSPATH%;%MCCUBE_WORK%/XMLSERVER/lib/tomcat-coyote.jar
@set CLASSPATH=%CLASSPATH%;%MCCUBE_WORK%/XMLSERVER/lib/tomcat-http.jar
@set CLASSPATH=%CLASSPATH%;%MCCUBE_WORK%/XMLSERVER/lib/tomcat-util.jar


@java -DTmcCUBE -Xms1024m -Xmx1024m -Dsystem.name=${MCCUBE_SVC_NAME} mcCUBE.main.enmccube -p ini/system.ini

@endlocal
