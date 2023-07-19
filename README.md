# JupiterToys:-
This repository contains the test automation code to test the Jupiter Toys web application. 

## About Project:-
Jupiter Toys UI Test: This code repository contains code that automates the following test cases.
Test case 1:
	1. From the home page go to contact page
	2. Click submit button
	3. Verify error messages
	4. Populate mandatory fields
	5. Validate errors are gone

Test case 2:
	1. From the home page go to contact page
	2. Populate mandatory fields
	3. Click submit button
	4. Validate successful submission message
	Note: Run this test 5 times to ensure 100% pass rate

Test case 3:
	1.	Buy 2 Stuffed Frog,5 Fluffy Bunny, 3 Valentine Bear
	2.	Go to the cart page
	3.	Verify the subtotal for each product is correct
	4.	Verify the price for each product
	5.	Verify that total = sum(sub totals)


## Code Structure:-

As Jupiter Toys is a Web application, I have used Selenium to automate the test cases.

This is a maven project that is a BDD based framework, that uses Page Object Model architecture, and Selenium Page Factory.

The feature files are present under */src/test/java/nz/co/planit/features* directory
The step definition files are present under *src/test/java/nz/co/planit/steps* directory
The page object model files are present under *src/test/java/nz/co/planit/pages* directory

The framework related files are present under the *src/main/framework/lib* directory

The execution reports can be found under */target/cucumber-report* directory

## Tools/Libraries used:-

	1.IntelliJ Commnuity Edition - v2021.3.3
	2.JDK 17
	3.Apache Maven 3.8.5

## Installation:-
Clone the code from the following GitHub repository: **https://github.com/vipinmisra/JupiterToys**

## Instructions:-

Open a command-prompt and navigate to project directory where you would find the pom.xml file.

Here are the commands to run the test cases:

1. To run all the test cases:
'''
	mvn clean test
'''

2. To run the tests using a specific tag: 
If we wish to run just the Cart feature test cases, we can specify the tag as follows:
'''
	mvn verify -Dcucumber.filter.tags="@Cart"
'''

3. To run the tests using multiple tags: 
If we wish to run the tests that match either tag @Contact and tag @Testcase_1, use the following command: 
'''
	mvn verify -Dcucumber.filter.tags="@Cart or @Testcase_1"
'''


## Test Results:-
Execution reports are generated under ./target directory under project directory.