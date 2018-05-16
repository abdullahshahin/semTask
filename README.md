About Analyzer
=========================

This is a Spring boot app that prompt the user to upload a csv file that has (Search keyword, Impressions, CTR, Cost, Position, Company, Revenue) properties and analyze them accordingly.

Prerequisites
=============

* Java 1.8
* Maven 3.1.1+

Metrics
=============

There is 3 main Metrics to define company performance:
* Profit vs Revenue vs Cost.
* Mean CPC per ad posistion.
* Impressions vs CTR.

Profit vs Revenue vs Cost
-----

This is the main criteria that we can define the best performance company, it represents the overall success or failure, the higher the number the better the company is among different companies, also, this is an indication of how much healthy page ranks and quality are among peers in overall assessment.

Mean CPC per ad posistion
-----

For every keyword group, this metric shows how much the company has paid in average for every keyword in a certain position, if the trend of this metric shows a relativly high number on low position, that probably mean a low page rank or quality, which requires more attention on the SEO standards used for targeted keyword group.


Impressions vs CTR
-----

Despite of the two properties speak the same language, but, knowing the number of impressions related with actual click ratio per total impressions gives an insight into how useful the SEM is doing well for the company, if the ad was shown to the user but did not lead to an actual click might gives insight into the audience awareness of the company and its services, maybe a better social media campians might paid off for this particulare item.

Building
========

From IDE (Eclipse, Intellij)
----------------------------

Open as a Maven project and compile.

From Command Line
-----------------

    mvn clean package

Running the Application
======================

you may use either of the following Maven targets to run the application from either the command line or 
your IDE:

    mvn spring-boot:run

or:

    mvn exec:exec

Open a browser and visit [http://localhost:8080/](http://localhost:8080/)


Spring Boot Configuration Properties
====================================

Please see [here](http://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html) 
for details.
