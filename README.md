#### ICANJ Website Registration Test
This project tests the "my.icanj.org" website by:
* Logging onto the website
* Clicking on the "Covid-19 Service Registration" link
* Registering you or someone else for the service for the coming Sunday
* Reserving your seat
* Logging out and terminating the browser

#### How To Use
* Go to the TestNG.xml file
* In the corresponding parameter tags, enter your valid email and password
* For "user_name", enter your email
```
 <parameter name="user_name" value="abc@gmail.com"/>
        <parameter name="pass_word" value="abc1234"/>
```
* Run the FirstTest.java program

#### Expectations
* When the credentials have been verified, program will run as intended and browser terminates after logout
* If incorrect credentials, browser will not terminate and return 2 exceptions
* NoSuchElementException will show due to certain web elements expected to be accessed but failed due to incorrect credentials

