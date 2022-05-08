Feature: Add Books to UserCollection
 
   @login
   Scenario: Add Books to UserCollection and verify the number of books in User Profile
    Given User is on demoQA page
    When User enters the credentials and be able to login successfully
    When User deletes available books in collection
    When User clicks on goToBookStore
    When User clicks on bookname and adds to collection
   |Understanding ECMAScript 6|
   |You Don't Know JS|
   |Learning JavaScript Design Patterns|
   
    When User searches for the book "Git" in book store
    When User clicks on the Add to Collection button
    Then User verifies the collection list
    #Then Delete User Collection
    When User logsout
   