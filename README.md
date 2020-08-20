# CDE-CaseStudy

Banking management System

•	Developed a Banking management system application for CDE case study.
•	The application consists of 3 micro-services.
o	Customer-Registration  - to register a new customer and let the customer to login to the application.
o	Customer LoanRegistration - to apply for loan.
o	CustomerUpdation – to update customer details.
•	The applications would store the data in local mysql database or AWS RDS.
•	The application are deployed to 3 AWS lambda with java handlers.
•	Three API gateways are configured to hit the applications deployed in AWS lambdas.
•	When the apps are moved to AWS, the local databases are changed to AWS RDS-mysql.
•	The codes are maintained in Github.
•	The code is also maintained in AWS code commit.
•	Configured AWS codepipeline to handled CICD.
•	Configured code commit,code deploy,code build.
•	Configured so that my local eclipse commit would trigger AWS pipeline and deploy the application to AWS elastic beanstalk.
•	Deployed apps to AWS beanstalk too.
•	Configured a SQS queue to handle incoming ad outgoing messages.
•	Configured AWS event bride to keep my lambda functions warm, to avoid cold start up issues.
•	Configured Redis cache to reduce hits to database.
•	Added 5 to 6 java 8 features in code.
•	Configured a separate IAM role to acces lambda/beanstalk/API gateway/SQS/pipeline/event bridge.
•	Configured a free tier RDS in AWS – mysql.
•	The logs of the applications are logged in AWS cloudwatch.
•	Sonar is configured to inspect the code qualities.
 Added Swagger in all the applciations.

