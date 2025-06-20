# Magento Automation Tests

This project contains Selenium automation tests for Magento e-commerce website.

## How to Run
1. Clone this repository
2. Run: `mvn test`
3. Run: 'allure serve' --> for reports

## Test Cases
- Search functionality
- Add to cart
- Checkout process  
- Security testing

## Tech Stack
- Java 17
- Selenium WebDriver
- TestNG
- Maven
src/
├── main/java/
│   ├── Base/
│   │   └── BaseTest.java
│   ├── Pages/
│   │   ├── HomePage.java
│   │   ├── SearchResultsPage.java
│   │   ├── ProductPage.java
│   │   ├── CartPage.java
│   │   └── CheckoutPage.java
│   └── Utils/
│       ├── ElementActions.java
│       ├── ScrollUtils.java
│       └── Waits.java
└── test/java/
└── Tests/
├── TC_01_SearchTests.java
├── TC_02_CartTests.java
├── TC_03_CheckoutTests.java
└── TC04_SQL_Injection_Security_Test.java

## Setup Instructions

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Chrome browser

### Installation
1. Clone the repository:
```bash
git clone https://github.com/hossameldeeb07/Magento-Ecommerce-Testing