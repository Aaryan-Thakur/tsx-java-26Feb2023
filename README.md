﻿# tsx-java-26Feb2023
This is a project made for as an assignment for TechStax internship 
It enables the tracking of events of a particular github repository by setting up a webhook endpoint whitc the github repo can send event inforamtion to
It also has a feature to retrive the list of all commits of a repo

Install java,gradle,ngrock and an IDE that can run spring boot
Clone this repo using git clone (or just download)

Webhook Demo
1. cd into the using an IDE or CMD
2. run the command "./gradlew clean build" OR "gradlew clean build" depeneding upon what interface you are using then
3. Let the above process finish
4. run the command "./gradlew bootRun" OR "gradlew bootRun" This will execute the project and the website will be up and running(visit localhost:8080) to verify
5. open ngrok.exe, use command "ngrok.exe http 8080" 
6. now copy the link in front of "forwarding" in my case it is...Visit the link to make sure it is working
7. Now go the repo which you want to track a click on settings-> webhook->add/edit a webhook
8. In payload URL add the link we copied above and add "/webhook" at the end of it, so in my case it will be
9. Now select/edit the event you would like to log and add/save
10.You are done, now make changes to the commit and the events you have selected will be logged in the logs/eventlogger.log file


