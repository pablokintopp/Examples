Feature: ShoppingBasket
	A simple shopping basket that we can add and remove items from

@mytag
Scenario: A new basket no contents	
	When I create a new basket
	Then The basket has no contents

Scenario: Adding an item to the basket
	Given I create a new basket
	When I add an item to the basket
	Then the basket contains the added item

Scenario: Removing an item to the basket
	Given I create a new basket
	And I add an item to the basket
	When I remove an item from the basket
	Then the basket does not contain the item
