@echo off
javac -classpath ".\melissadata\globalemail\org.apache.sling.commons.json-2.0.20.jar;" .\melissadata\globalemail\*.java .\melissadata\globalemail\view\*.java ./melissadata\globalemail\model\*.java
java -classpath ".\melissadata\globalemail\org.apache.sling.commons.json-2.0.20.jar;"; melissadata.globalemail.Main melissadata.globalemail.view.GlobalEmailController melissadata.globalemail.view.GlobalEmailTransactionController melissadata.globalemail.view.RootLayoutController melissadata.globalemail.model.GlobalEmailOption
del .\melissadata\globalemail\*.class 
del .\melissadata\globalemail\view\*.class 
del .\melissadata\globalemail\model\*.class