# tsx-java-26Feb2023
As an assignment assigned by TechStax internship, I have created a tool that allows for tracking events of a specific GitHub repository. The tool sets up a webhook endpoint that can receive event information from the GitHub repository. Additionally, the tool includes a feature for retrieving a list of all commits associated with the repository.
-----------------------------------------------------------------------------
Installed prerequsites-

java, gradle, ngrock and an IDE that can run spring boot

Clone this repo using git clone (or just download)

---------------------------------Webhook Demo---------------------------------
1. cd into the cloned folder using an IDE or CMD
2. run the command "./gradlew clean build" OR "gradlew clean build" depending upon the interface you are using
3. Let the above process finish
![image](https://user-images.githubusercontent.com/49814390/221400924-2972ec44-8980-432b-a983-f044f89585ce.png)<br>
(you can also try running "./gradlew clean build --refresh-dependencies" if the above one doesn't work)


4. run the command "./gradlew bootRun" OR "gradlew bootRun" This will execute the project and the website will be up and running(visit localhost:8080) to verify
![image](https://user-images.githubusercontent.com/49814390/221399185-ce5647ec-fd1b-438e-8465-7678d14e14c9.png)
![image](https://user-images.githubusercontent.com/49814390/221401324-8c91f786-8ec5-411a-98d7-a920feed3a99.png)

5. open ngrok.exe, use command "ngrok.exe http 8080" <br>
![image](https://user-images.githubusercontent.com/49814390/221399202-dc22c709-c2fd-4fea-8f09-2dae5e2c6b96.png)

6. now copy the link in front of "forwarding" in my case it is "https://f30c-2409-40c0-101f-99fc-b419-6b82-b9f0-e4eb.in.ngrok.io" Visit YOUR link to make sure it is working
![image](https://user-images.githubusercontent.com/49814390/221399213-e5a7086b-e5f9-4d30-a8be-b8edbb7655f1.png)
![image](https://user-images.githubusercontent.com/49814390/221401433-d65ac2db-19ff-403d-a2c7-11fa1f0308bc.png)


7. Now go to the repo which you want to track a click on settings-> webhook->add/edit a webhook
![image](https://user-images.githubusercontent.com/49814390/221400107-7ce31dc8-fa9e-4114-bd2d-adfcf9830a33.png)


8. In payload URL add the link we copied above and add "/webhook" at the end of it, so in my case it will be "https://f30c-2409-40c0-101f-99fc-b419-6b82-b9f0-e4eb.in.ngrok.io/webhook" 
![image](https://user-images.githubusercontent.com/49814390/221400116-3e0dbf82-d18a-4008-8bee-5b6b30fa434b.png)


9. Now select/edit the event you would like to log and add/save
10. You are done, now make changes to the commit and the events you have selected will be logged in the logs/eventlogger.log file<br>
![image](https://user-images.githubusercontent.com/49814390/221400253-de80d007-0f5f-459e-bf72-0e23d78a10e4.png)
![image](https://user-images.githubusercontent.com/49814390/221400257-9fe70297-efa1-415b-9606-00446e9d792d.png)




---------------------------------Commit List Demo---------------------------------

Follow the same steps from 1 to 3 from webhook instructoins

1. You can change the repo you want to retrive the commit list from my visiting \src\main\java\com\example\techstax\data\repodata.java 
![image](https://user-images.githubusercontent.com/49814390/221400282-8998548c-7daa-4d1b-9624-79ec3bef3ea8.png)


2. Make appropriate changes and save
3. run the command "./gradlew bootRun" OR "gradlew bootRun" This will execute the project and the website will be up and running(visit localhost:8080) to verify
![image](https://user-images.githubusercontent.com/49814390/221400338-1f272928-14cf-404b-afd2-b801e4f94710.png)
4. now just visit localhost:8080/commit and the list of commits will be logged to logs/commitlist.log
![image](https://user-images.githubusercontent.com/49814390/221400361-c4ce4291-99bf-4eb7-819a-639294902c3c.png)
![image](https://user-images.githubusercontent.com/49814390/221400363-ec50b626-9118-4f95-99d3-3e4339c7c8f7.png)





NOTE-

1.8080 is the port number which can vary make sure you use port number you want appropirately 

2.All errors will be logged to log/erros.log
