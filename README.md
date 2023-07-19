# JupiterToys:-
This repository contains the test automation code to test the JupitertToys web application. 

## About Project:-
JupitertToys UI Test

Using the JupiterToys web site write automation code which does the following:
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

Project built with Cucumber BDD framework using Selenium and Java.

## Tools used:-
	1.IntelliJ Commnuity Edition
	2.Cucumber
	3.JDK 18
	4.Apache Maven 3.8.5

## Installation
Clone the repo:
**https://github.com/vipinmisra/JupiterToys**

## Instructions:-

Open a command-prompt:- 
Navigate to project directory where you would find src , pom.xml etc.

Run the below  execution command:-

mvn clean test
Above command will trigger execution in Edge browser which is default browser.

For execution in Edge please use following command:-

**mvn clean test  -Dbrowser=edge**

For execution in Chrome please use following command:-

**mvn clean test  -Dbrowser=chrome**

For execution in FireFox please use following command:-

**mvn clean test  -Dbrowser=firefox**

## Test Results:-
Execution reports are generated under ./target directory under project root directory.
