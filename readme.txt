----------------------
Project Title
----------------------
GithubRepositoriesSearch 

This project is designed to test Github search repositories API and cover the scenarios that are critical this resource.

----------------------
Getting Started
----------------------

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

----------------------
Prerequisites
----------------------
 java
 Intellij
 TestNG plugin

----------------------
Installing
----------------------

Install Java and Intellij

In Search, search for and then select: System (Control Panel)
Click the Advanced system settings link.
Click Environment Variables. In the section System Variables, find the PATH environment variable and select it. Click Edit. If the PATH environment variable 
does not exist, click New.
In the Edit System Variable (or New System Variable) window, specify the value of the PATH environment variable:  C:\Program Files\Java\{java-version}\bin
Click OK. Close all remaining windows
by clicking OK.
Reopen Command prompt window, and run your java code.

Unzip the project

Start Intellij and choose to open the project, then point to the folder that has the project

Go to Project click on Run / Edit configuration and make sure the project points to TestNG.

----------------------
Running the tests
----------------------

The path to githubsearch.xml: GithubRepositoriesSearch/src/test/resources
Right-click on the file and click run.

----------------------
And coding style tests
----------------------

Each method is a search Github search query
Rest-Assured is used to validate the response of the requests.
com.jayway.restassured.response.Header library is used to get the response header.
com.jayway.restassured.RestAssured.given to use given gherkin.
hamcrest.CoreMatchers library used to validate the string received from the query.
org.testng.annotations used to indentify the methods as test methods.

----------------------
Built With
----------------------

    Maven - Dependency Management    

----------------------
Versioning
----------------------
@version 1.0
----------------------
Authors
----------------------
    Dounia Mdarhri Alaoui


