# AlmaShines SDET Take-Home Assignment

## Overview

This project contains automated test scripts for the AlmaShines Sign Up flow using:

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)

The objective was to automate high-impact and repeatable scenarios while documenting scenarios that are better suited for manual testing.

---

## Automated Scenarios

### Signup Page

- Verify email field is displayed
- Verify next button is displayed
- Verify valid email entry
- Verify blank email validation
- Verify invalid email formats
- Verify existing user flow

### User Details Page

- Verify valid user details
- Verify weak password validation
- Verify password mismatch validation

### OTP Page

- Verify OTP page is displayed
- Verify blank OTP validation
- Verify invalid OTP formats
- Verify resend OTP functionality

### Hybrid End-to-End Flow

Automated:

- Email submission
- User details submission
- OTP page verification

Manual:

- Enter valid OTP
- Verify role details page
- Complete role selection
- Accept terms and consent
- Join network

---

## Manual Test Coverage

The following scenarios were intentionally kept under manual testing:

- Role selection validation
- Joining year validation
- Graduation year validation
- Terms & Conditions acceptance
- Consent acceptance
- Join Network functionality
- Association-specific business rule validation

Reason:

OTP verification requires a real OTP sent to email. Since the OTP is dynamic and requires human intervention, the final part of the flow was tested using a hybrid approach (automation + manual verification).

---

## Framework Design

src/test/java

- base
  - BaseTest.java

- pages
  - SignupPage.java
  - UserDetailsPage.java
  - OTPPage.java
  - RoleDetailsPage.java

- tests
  - SignupPageTests.java
  - UserDetailsTests.java
  - OTPTests.java
  - ExistingUserTests.java
  - HybridSignupTests.java

- utils
  - ConfigReader.java
  - WaitUtils.java
  - TestDataGenerator.java
  - DataProviders.java
  - ExistingUserDataProvider.java
  - UserDetailsDataProvider.java
  - RoleDataProvider.java

---

## Prerequisites

- Java 17+
- Maven 3.8+
- Google Chrome

---

## Setup

1. Clone repository

git clone <repository-url>

2. Navigate to project

cd AlmaShinesAutomation

3. Update config.properties

Example:

base.url=https://www.almashines.com/dtc/account

existing.user.email=[existinguser@gmail.com](mailto:existinguser@gmail.com)

signup.user.email=[validsignupuser@gmail.com](mailto:validsignupuser@gmail.com)

4. Install dependencies

mvn clean install

---

## Running Tests

Run all tests:

mvn test

Run specific suite:

mvn test -Dtest=SignupPageTests

mvn test -Dtest=OTPTests

mvn test -Dtest=UserDetailsTests

mvn test -Dtest=ExistingUserTests

mvn test -Dtest=HybridSignupTests

---

## Known Limitations

- Dynamic OTP cannot be fully automated because OTP is sent to a real email account.
- HybridSignupTests requires manual OTP entry before continuing.
- Role Details validations are documented under manual testing.

---

## Author

Yashwin Adkar
