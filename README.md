# EndToEndTestingFramework

RUNNING TESTCASES ON DOCKER ( Dockerised automation framework)
1) Launch docker and start the framework container 
(or)
Open terminal at docker-compose.yml location and run 'docker compose up', hit enter
2) Wait for node to be created added
3) In config.properties files set remote = yes
4) Run the testng.xml file
5) Launch http://localhost:4444/ in browser for observing available machines


#TO RUN TESTS IN LOCAL MACHINE
mvn clean test -isRemote=no

##install mvn using brew in IDE terminal
##mvn clean --> deletes target folder and runs pom.xml file
