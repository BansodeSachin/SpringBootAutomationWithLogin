Feature: Login into Application

Scenario: Positive test Validating Login 1
Given Initialize the browser with your browser option
When User enters "susan" and "fun123" and log in
Then Verify that user successfully Logged In
And Take Screenshot in file "Login_Success" and Close the browser.

Scenario: Negative test Validating Login 2
Given Initialize the browser with your browser option
When User enters "sachin" and "fail123" and log in
Then Verify that user NOT Logged In
And Take Screenshot in file "Login_Failure" and Close the browser.