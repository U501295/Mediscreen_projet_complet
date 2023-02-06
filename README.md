# Mediscreen_projet_complet

Mediscreen is an application dedicated to help doctors finding warnings about their patient's probability to develop diabetes.

Given informations about the patient like his age and various key words, the app can generates an indicator concerning his health.

This application is splited into different microservices, the first 2 gather informations and interact with databases. Third one is the rapport generation, based on information transmited by the first 2. The last one is for the front end.

# How to launch the App
First of all you'll have to install the services by running "mvn install" in the 4 folders.

Then you'll have to build each one of the MS. For this go to each Folder and enter the command "docker build -t 'imageName'" with respectively patientapi, patientnoteapi, patientassessapi and patientfrontapi as 'imageName' When the 4 containers are up and running enter the command "docker-compose up -d" in the root folder.

You can now go to localhost:8080 and check the functionality provided by the application or launch the tests or go to localhost:8081, 8082 and 8083 for testing back end alone.
