@CRMLYEUG-1448
Feature: Uploads in message feature
  User Story CRMLYEUG-1380:
  As a user, I should be able to upload files and pictures as messages

  @CRMLYEUG-1442
  Scenario Outline: Upload max 3 files at same time
    Given user logs in as "<userType>"
    When user clicks on Upload Files button
    And uploads three files
    Then user is able to upload files

    Examples:
      | userType  |
      | Helpdesk  |
      | Marketing |
      | HR        |

  @CRMLYEUG-1443
  Scenario Outline: Uploaded picture displayed in Activity Stream
    Given user logs in as "<userType>"
    When user uploads picture
    Then user should display uploaded picture

    Examples:
      | userType  |
      | Helpdesk  |
      | Marketing |
      | HR        |

  @CRMLYEUG-1444
  Scenario Outline: Insert files into the text
    Given user logs in as "<userType>"
    When user inserts file into text
    Then user sees In text label on button

    Examples:
      | userType  |
      | Helpdesk  |
      | Marketing |
      | HR        |

  @CRMLYEUG-1445
  Scenario Outline: Allow the recipient to edit document
    Given user logs in as "<userType>"
    When user uploads docx document
    Then recipient should see Edit button

    Examples:
      | userType  |
      | Helpdesk  |
      | Marketing |
      | HR        |

  @CRMLYEUG-1446
  Scenario Outline: User should remove files before sending
    Given user logs in as "<userType>"
    When user uploads any file
    And user clicks on delete upload
    Then user should be able to remove attachment before sending

    Examples:
      | userType  |
      | Helpdesk  |
      | Marketing |
      | HR        |

  @CRMLYEUG-1447
  Scenario Outline: User should be able to rename file before sending
    Given user logs in as "<userType>"
    When user uploads any file to send
    And user click on pen icon to rename
    And user send message with renamed file
    Then recipient should receive renamed file

    Examples:
      | userType  |
      | Helpdesk  |
      | Marketing |
      | HR        |