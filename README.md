All the test cases included in testcases.txt file are automated in this project.
Maven project is built and it is based on java and selenium.


Tools installed:
Java,
Maven

Added dependencies in the POM.XML .
Junit
Cucumber
Selenium


Drivers (Exist in the project)
Chrome Driver for Mac,
Gecko Driver for Mac


IDE: Intellij/Eclipse
Plugins: Cucumber for Java, Gherkin


-- Automation framework

Page object model -- created separate pages and included actions and elements inside them.
Cucumber -- Used for writing scenarios in Feature file in Behaviour Driven Development style.

compiling the project:
mvn clean install

How to Run Scripts:

Navigate to 
Src/test/java/com/runner/RunUITests class
Right click on it and click RunUITests option

or

Right click on any scenario in Feature file and execute the script

or

we can execute the scripts using command line

mvn test -Dcucumber.options="--tags '@login'"



We can update the browser in which tests should be run in the SelectDriver class.


Reports would be generated under :
/target/cucumber-html-report

Let me know if you have any questions regarding this assesment please contact me on sohelmohammed.qa@gmail.com
