Feature:  Verify ANZ Home loans Calculators tools

Scenario: Personal home loans calculators tools 
When I launch the ANZ Home loans calculators tools 
Then I verify the a borrowing estimate

Scenario: Clicking the start over button clears the form. 
When I launch the ANZ Home loans calculators tools 
When Click on start over button
Then Verify the form 

Scenario: Entering only $1 for Living expenses
When Entering only $1 for Living expenses
Then Verify the return message