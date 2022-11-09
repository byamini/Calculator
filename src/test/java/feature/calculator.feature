Feature: to calculate calories based on values given

Scenario: Launch Calculator url
Given calculator url is launched
When user clicked on BMI calculator
Then check title of the page

Scenario: calculate calories
Given age height and weight 
When calculate the calories
Then capture the BMI Result value & Print it