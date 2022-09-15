Pre-Condition :
1. Ensure you have set up Java 8 and Maven on your PC
2. Ensure you have set up Cucumber plugin on your IDE (Eclipse/VSCode)

Tools :
1. Eclipse IDE
2. Java & Maven
3. Selenium Webdriver
4. Cucumber framework

Step to Run Automation on terminal:
mvn test

Step to Run Automation on IDE:

Eclipse :
1. Import the project.
File > Import > Existing Mavern Project > {add your project directory} > Finish.
2. Define your running test case by tag on Runner.java file, You can see the available tagging on /ui-automation-selenium/src/test/resources/Features.
3. Run the project.
Right click on the project > Run as > Maven test.

VSCode :
1. Open the project folder.
File > Open Folder.
2. Define your running test case by tag on Runner.java file, You can see the available tagging on /ui-automation-selenium/src/test/resources/Features.
3. Run the project.
Click Testing Menu on the right tool bar > Click Run Test.
