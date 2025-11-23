# Getting Started

### How to run the application

* Setup Java 17
* Setup Gradle-9.2.1
* RUN - gradle clean build // this will generate hello-1.0.0-RELEASE.jar
* RUN - java -jar hello-1.0.0-RELEASE.jar // Service will start on port 8080
* curl --location 'http://localhost:8080/hello/hello-world?name=Akas'

### How to run the tests

* gradle clean build // This command will run all tests

### Any assumptions made

* Implementation done only for the described scope