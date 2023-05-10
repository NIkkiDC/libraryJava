Feature: Rest API functionalities

  Scenario: User able to add and remove book
    Given A list of books are available
    When I add a book to my reading list
    Then The book is added
    When I remove book from my reading list
    Then The book is removed