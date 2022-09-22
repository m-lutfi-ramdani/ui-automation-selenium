@select-menu
Feature: Select Menu
	
	Scenario Outline: User should be able to fills value on Select Menu page
		Given User access Select Menu page on Demo QA web apps
		When User in Select Menu page "<titlePage>"
		And User choose select value "<selectValue>"
		And User choose select one "<selectOne>"
		And User choose old style select menu "<oldStyleSelect>"
		And User choose multi select drop down all color "<multiSelect>"
		Then User success input all select menu "<selectValue>" "<selectOne>" "<oldStyleSelect>" "<multiSelect>"

		
	Examples:
	|titlePage	|selectValue		 |selectOne	|oldStyleSelect	|multiSelect|
	|Select Menu|Another root option |Other		|Aqua			|Green,Blue,Black,Red|