
# petfinder-project

![Petfinder Logo](https://github.com/gutierrezlira/petfinder-project/blob/master/doc/dog-adoption-website-petfinder.jpg)

Welcome to the Petfinder project repository! Here you will find automated tests of UI and API parts of the Petfinder website.

The repository structure consists of two main folders: ui_tests and api_tests. The ui_tests folder contains automated UI tests written using Selenium WebDriver and the Java programming language. These tests verify that the user interface of the Petfinder site works as expected and meets user expectations.

The api_tests folder contains automated API tests written using the Rest-Assured library and the Java programming language. These tests verify that the Petfinder API works as expected and returns the expected results.

Each folder contains a set of files with tests, divided into logical groups. Each file contains a set of tests written according to the Page Object pattern. This makes it easier to support tests, since all page elements are placed in a separate class and can be easily changed without changing the tests themselves.

The tests in the repository cover the core functionality of the Petfinder site, such as searching for animals based on various criteria, adding a new animal to the database, and checking whether the required data is present in the API response.

We hope that our repository will help you understand how you can automate testing of UI and API parts of web applications using modern tools and technologies. Feel free to ask questions and make pull requests if you have suggestions for improving the tests or adding new functionality.
