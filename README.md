# QC to TAE_PageFactory

We have created Hybrid driven framework using Selenium, TestNG, Maven, Java, Extent Report. This project is useful for UI Automation. For testing we have used TestNG, Maven as project management tool, programming language as **Java**, for reporting tool we have used Extent Report.


Java, Selenium and TestNG Automation Framework is powerful and versatile platform to automate test cases. It helps to significantly reduce time involved in setting up Test Automation in new Projects. It is integrated with TestNG framework to cover a wide range of testing groups like unit, functional, integration, etc.

## Prerequisite Setup for framework

1. Please make sure Java 1.8 or higher is installed.
2. Please make sure you have maven installed don your machine.
3. If you don't have IDE installed on your machine, please install an IDE([Eclipse](https://www.eclipse.org/downloads/) or [IntelliJ](https://www.jetbrains.com/idea/download/#section=mac))


## Installation

 - Open the project in Intellij IDE & down the there is option called Terminal.
 - Open the Terminal & hit below command to install require dependency

Install required dependecy with mvn

```bash
  mvn install
```
- it will fail due we haven't pass xml file, but this is oky.



## Run Locally

Clone the project

```bash
  git clone git@github.corp.globant.com:harsh-vegada/QCtoTAE_PageFactory.git
```

Go to the project directory

```bash
  cd QCtoTAE_PageFactory
```

Install dependencies

```bash
  mvn install
```

Start the server

```bash
  mvn clean test -DxmlFile=testng -DbrowserName=chrome
```


## Tech Stack

**Technology:** Java, Selenium, TestNG, Extent Report, Maven


## Authors

- [@harsh-vegada](https://github-vpn.globant.com/harsh-vegada)


![Logo](https://statics.globant.com/production/public/2022-08/globant-logo.jpg)
