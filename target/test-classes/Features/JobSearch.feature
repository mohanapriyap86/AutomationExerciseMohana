Feature: Job Search

  
  Background: User is on the homepage
  Given User is on the homepage
  
  @regression
  Scenario Outline: Verify job search results
    When User clicks on About Us link
    And User clicks on Careers link
    And User Navigates to Careers page
    And User clicks on Search all jobs button
    And User enters a text <searchText> in search box
    And clicks search button
    Then User should see at least one job result

    Examples: 
      | searchText        |
      | Automation Tester |
