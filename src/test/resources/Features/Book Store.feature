@search-book
Feature: Search Book
	
	Scenario Outline: User should be able to see No rows found text when search unavailable book
		Given User access Select Books page on Demo QA web apps
		When User in Book Store page "<titlePage>"
		And User search book "<searchKey>"
		Then User see No rows found text

	Examples:
	|titlePage	|searchKey		 |
	|Book Store	|QA Engineer	 |
	
	Scenario Outline: User should be able to verify the selected books on Book Store
		Given User access Select Books page on Demo QA web apps
		When User in Book Store page "<titlePage>"
		And User search book "<searchKey>"
		And User click the selected book
		Then User see the details of book

	Examples:
	|titlePage	|searchKey			 |
	|Book Store	|Git Pocket Guide	 |