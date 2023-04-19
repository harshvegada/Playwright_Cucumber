@HomePage
@severity=blocker
Feature: Amazon Home Features

  @search
  Scenario Outline: verify amazon search product name dsiplayed in tabs
    When User search for product "<productName>" in search bar
    Then User validate product name "<productName>" displayed in title tab
    And User applied filter on "Internal Memory" select the value "4 GB!8 GB!32 GB!128 GB"
    And User applied filter on "Operating System" select the value "Android 7.1"

    Examples:
      | productName    |
      | Mobile         |

  @scroll
  Scenario: verify without scroll code playwright able to find lcaotor at the bottom
    And User scroll till text "Back to top" on page

