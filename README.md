# EndToEndTestingFramework

# Tools and Tech Stack

- Java
- Selenium
- WebDriverManager
- TestNG
- Maven
- AssertJ
- PageObjectModel and Factory Design patterns
- By, String
- ThreadLocal - ThreadSafety
- ExtentReports
- Excel sheet for test data maintenance(data provider)
- Property as a config file.
- Use TestNG listeners like Annotation Transformer, ITestListener, ISuiteListener
- Running tests in dockerized selenium grid
- Parallel cross-browser testing
- Log4j

# Advanced features

- Using SonarLint to write clean code

# Rules to be followed while creating a framework

- Never hardcode.
- Keep the right things in the right place.
- Religiously practice the Reuse culture.
- Make the framework easy for manual testers or others to contribute.
- Make the framework robust

# RUNNING TESTCASES ON DOCKER ( Dockerised automation framework)
1) Launch docker and start the framework container 
(or)
Open terminal at docker-compose.yml location and run 'docker compose up', hit enter
2) Wait for node to be created added
3) In config.properties files set remote = yes
4) Run the testng.xml file
5) Launch http://localhost:4444/ in browser for observing available machines


# TO RUN TESTS IN LOCAL MACHINE
mvn clean test -isRemote=no

##install mvn using brew in IDE terminal
##mvn clean --> deletes target folder and runs pom.xml file
