# Sauce Demo Automation Testing Project

## Overview

This project contains UI testing for the Sauce Demo website, including automated tests implemented with Selenium WebDriver and a manual test case.

## Website Under Test

https://www.saucedemo.com/

## Technologies Used
* Java
* Selenium WebDriver
* TestNG
* Maven

## Design Pattern
This project follows the Page Object Model (POM) design pattern to improve code maintainability and readability

## Dependencies
* Run on Windows 10 Pro OS
* IDE for this project is IntelliJ Idea Community Edition 2026. 01.
* The mandatory browser is Firefox, but the ones that can also be used are Chrome, Edge and Safari.


## Installation

Open terminal in IDE and git clone the repository

``````
git clone 

``````

* Java version OPENJDK 26
* Apache version 3.9.11.

## Executing Program
1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Run:
``` bash
mvn test
```

## Framework WalkThrough
The project contains the following packages:
* Base - contains the classes which are used for this project
* Pages - contains the classes for the pages that are used for the testing part of the project
* Tests - contains the classes for all the tests that have been created for this project


## Test Cases
The project contains the following test cases:
* successful login with valid credentials
* unsuccessful login with an invalid username and a valid password
* successful addition of one item to the cart
* successful addition of more than one item into the cart
* successful deletion of items from the cart
* successful clicking on the "add to cart" button
* successful clicking on the "Open Menu" button
* successful closing of the Open Menu by clicking the "Close Menu" button
* successful logging out upon clicking on the "logout" button from the Open Menu
* successful clicking on the "About" option from the Open Menu
* successful clicking on the "All Items" option from the Open Menu
* successful clicking on the "order items" arrow icon
* successful ordering items by price: from the lowest to the highest
* successful ordering items alphabetically: from Z to A
* successful visit to the Sauce Demo Twitter page by clicking the Twitter icon
* successful return to the Products page by clicking "Back To Products" button
* verification that the number of items in the cart corresponds to the number of added items
* successful completion of the order 
* unsuccessful completion of the order when the zip code is invalid
* successful redirection of the user to the product's page when clicking on that particular item
* verification that items remain in the cart after logging out
