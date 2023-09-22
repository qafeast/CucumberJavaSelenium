Feature: BankManager

  Scenario: Adding new customer to the bank
    Given Login to bank manager account
    Then navigate to add customer section
    Then enter firstname as "John" lastname as "Wick" and postal code as "123456"
    When click add customer button
    Then customer "John" "Wick" should be added to the customer list

  Scenario Outline: Adding new customer to the bank
    Given Login to bank manager account
    Then navigate to add customer section
    Then enter firstname as "<firstName>" lastname as "<lastName>" and postal code as "<postalCode>"
    When click add customer button
    Then customer "<firstName>" "<lastName>" should be added to the customer list

    Examples:
    |firstName|lastName|postalCode|
    |Mick     |Tyson   |111111    |
    |Peter    |Parker  |222222    |
    |Steve    |Roger   |333333    |
