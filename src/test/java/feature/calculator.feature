Feature: to calculate calories based on values given

Background: Launch Calculator url
Given calculator url is launched
When user clicked on BMI calculator
Then check title of the page

@Regression
Scenario Outline: calculate calories
Given user enter age "<age>" and height "<height>" and weight "<weight>"
When calculate the calories
Then capture the BMI Result value & Print it

Examples:
|age|height|weight|
|10|127|40|
|30|156|70|
|25|152|55|
|20|160|45|
|35|160|70|