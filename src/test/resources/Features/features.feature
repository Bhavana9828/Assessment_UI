Feature: Validate Automation Practice website SDET assessment

@test1
Scenario: Validate whether the search suggestion is not given to the user until 3 characters are populated.
When Click on search button and enter three characters
And Validate whether the search suggestion is given after entering three characters 
And User gives only two or one characters on search suggestion
And Validate no search suggestion is given after entering two characters 


@test2
Scenario Outline: Validate results are displayed according to the search made by the user.
When Click on search button and enter "<dressname>" dress name 
And  Validate results are displayed according to the search made by the user.
Examples:
|dressname			 |
|Printed Summer Dress|

@test3
Scenario: Validate whether the user is able to apply the large size catalog filter for the T-shirt section.
When Click on T-shirt section on the page
And  Validate whether the user is able to apply the large size on the page


@test4
Scenario: Validate whether the user is able to upload a file on the contact us page.
When Click on contact us button on the page
And Validate whether the user is able to upload a file on the contact us page


@test5
Scenario: Add 5 products in the cart, validate total cart amount and individual product price both with and without discount.
When Add five products in the cart on the page
And validate total cart amount and individual product price both with and without discount

