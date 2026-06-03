# Academic Platform — Automation Testing Suite

![Java](https://img.shields.io/badge/Java-11-orange?logo=java)
![Playwright](https://img.shields.io/badge/Playwright-1.44.0-2EAD33?logo=playwright)
![TestNG](https://img.shields.io/badge/TestNG-7.9.0-FF6C37)
![Allure](https://img.shields.io/badge/Allure-2.27.0-blue)
![CI](https://github.com/your-username/academic-automation/actions/workflows/regression-test.yml/badge.svg)

End-to-end automation test suite for the **Academic Platform** — covering UI functional testing and API integration testing across all major Academic modules.

---

## Table of Contents

- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Architecture](#architecture)
- [Project Structure](#project-structure)
- [Modules Covered](#modules-covered)
- [Getting Started](#getting-started)
- [Running Tests](#running-tests)
- [Test Reports](#test-reports)
- [CI/CD](#cicd)

---

## Overview

This project automates regression testing for the Academic Platform's core module. It combines:

- **UI Testing** — end-to-end browser automation using Playwright Java with the Page Object Model pattern
- **API Testing** — REST API validation using Playwright's `APIRequestContext`, integrated within the same test lifecycle

Test cases cover positive and negative scenarios including form validation, CRUD operations, search/filter flows, status toggles, and navigation guards (e.g. "leave page" confirmation popups).

---

## Tech Stack

| Layer | Tool | Version |
|---|---|---|
| Browser Automation | Microsoft Playwright | 1.44.0 |
| Test Framework | TestNG | 7.9.0 |
| Reporting | Allure Report | 2.27.0 |
| Build Tool | Maven | 3.x |
| Language | Java | 11 |
| Serialization | Jackson | 2.17.1 |
| Logging | SLF4J + Logback | 2.0.13 |
| Test Data | JavaFaker + Custom Helpers | — |

---

## Architecture

This project uses the **Page Object Model (POM)** pattern with a **Step Interface** layer:

```
┌─────────────────────────────────┐
│         Test Class              │  ← @Test methods, uses Step interface
├─────────────────────────────────┤
│      Step Interface             │  ← Defines test actions as contracts
├─────────────────────────────────┤
│         Page Class              │  ← Implements interface, calls ElementActions
├─────────────────────────────────┤
│    Locator  │   Model           │  ← CSS/XPath selectors │ Test data builders
├─────────────────────────────────┤
│        ElementActions           │  ← Playwright wrapper (click, fill, verify)
├─────────────────────────────────┤
│      BaseCore / BaseLocator     │  ← Shared base classes
└─────────────────────────────────┘
```

### Key Design Principles

**Step Interface Pattern** — Each module defines a Java interface (e.g. `BankClusterSteps`) that acts as a contract between tests and page implementations. This allows tests to be decoupled from Playwright-specific code.

**Model-driven Test Data** — Each module has a `Model` class with factory methods (`generateValidData()`, `generateInvalidData()`, `searchByKeyword()`) for consistent, reusable test data.

**API + UI in One Suite** — API calls (e.g. seeding test data via `ClusterAPI`) use Playwright's native HTTP client within the same browser session, avoiding external HTTP libraries.

---

## Project Structure

```
academic-automation/
├── src/
│   ├── main/java/automation/
│   │   ├── config/
│   │   │   ├── GeneralConfiguration.java   # Playwright browser lifecycle (Singleton)
│   │   │   └── GlobalVariable.java         # Shared constants & runtime vars
│   │   ├── platforms/
│   │   │   ├── base/
│   │   │   │   ├── BaseCore.java           # Abstract base for all Page classes
│   │   │   │   ├── BaseLocator.java        # Common selectors
│   │   │   │   └── BaseModel.java          # Base for test data models
│   │   │   ├── core/
│   │   │   │   ├── ElementActions.java     # Playwright interaction wrapper
│   │   │   │   └── academic/
│   │   │   │       ├── bankcluster/        # UI Page + Locator + Model + Steps
│   │   │   │       │   └── remote/        # API client for Bank Cluster
│   │   │   │       ├── bankdimension/
│   │   │   │       ├── bankcontent/
│   │   │   │       │   ├── create/
│   │   │   │       │   ├── edit/
│   │   │   │       │   └── list/
│   │   │   │       └── ... (10 modules total)
│   │   ├── helper/
│   │   │   ├── StringHelper.java           # Random string generator
│   │   │   └── RandomNumber.java           # Random number generator
│   │   └── utils/
│   │       └── StepLogger.java             # Allure step logger + TestNG assertion
│   └── test/java/automation/testcase/
│       └── platforms/core/
│           ├── BaseCoreDriverTest.java     # Base test: browser setup/teardown
│           └── academic/
│               ├── bankcluster/            # Test class + TestCase interface
│               ├── bankdimension/
│               └── ... (10 modules total)
├── .github/
│   └── workflows/
│       └── regression-test.yml            # GitHub Actions CI pipeline
├── testng.xml                             # Full regression suite definition
├── .env.example                           # Environment variable template
└── pom.xml                               # Maven dependencies & plugins
```

---

## Modules Covered

| Module | UI Tests | API Integration | CRUD | Search/Filter |
|---|:---:|:---:|:---:|:---:|
| Bank Behavioral Objective | ✅ | — | ✅ | ✅ |
| Bank Cluster | ✅ | ✅ | ✅ | ✅ |
| Bank Content | ✅ | — | ✅ | ✅ |
| Bank Dimension | ✅ | ✅ | ✅ | ✅ |
| Bank Element | ✅ | ✅ | ✅ | ✅ |
| Bank Framework | ✅ | ✅ | ✅ | — |
| Bank Type Activity | ✅ | — | ✅ | ✅ |
| Category Interpretation Score | ✅ | — | ✅ | ✅ |
| Manage Activity | ✅ | — | ✅ | ✅ |
| Manage Program | ✅ | — | — | ✅ |

---

## Getting Started

### Prerequisites

- Java 11+
- Maven 3.8+
- Git

### Installation

```bash
# 1. Clone the repository
git clone https://github.com/your-username/academic-automation.git
cd academic-automation

# 2. Install Playwright browsers
mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install chromium"

# 3. Configure environment
cp .env.example .env
# Edit .env with your actual credentials and URLs
```

### Configuration

All settings are controlled via environment variables. Copy `.env.example` to `.env` and fill in:

| Variable | Description | Default |
|---|---|---|
| `BASE_URL` | Application base URL | `http://localhost:3000` |
| `API_BASE_URL` | API base URL | `http://localhost:8080` |
| `USER_EMAIL` | Test user email | — |
| `USER_PASSWORD` | Test user password | — |
| `HEADLESS` | Run browser headless | `true` |
| `SLOW_MO` | Slow down actions (ms) | `0` |

---

## Running Tests

### Run full regression suite
```bash
mvn test -DsuiteFile=testng.xml
```

### Run a specific module
```bash
mvn test -DsuiteFile=testng.xml -Dgroups="Bank Cluster"
```

### Run in headed mode (visible browser)
```bash
HEADLESS=false mvn test -DsuiteFile=testng.xml
```

### Run with slow-motion (useful for debugging)
```bash
HEADLESS=false SLOW_MO=500 mvn test -DsuiteFile=testng.xml
```

---

## Test Reports

This project uses **Allure Report** for rich test reporting with step-by-step details.

### Generate and open report locally
```bash
# After running tests:
mvn allure:serve
```

The report shows:
- Test pass/fail status per module
- Step-by-step execution log with pass/fail per step
- Epic → Feature → Test Case hierarchy (via `@Epic` and `@Feature` annotations)
- Failure screenshots (when configured)

---

## CI/CD

The GitHub Actions pipeline (`.github/workflows/regression-test.yml`) runs automatically on:

- **Push** to `main` or `develop`
- **Pull Request** to `main`
- **Daily schedule** at 07:00 WIB (00:00 UTC)
- **Manual trigger** via `workflow_dispatch`

Artifacts uploaded after each run:
- `allure-results` — raw results for 7 days
- `allure-report` — generated HTML report for 7 days

### Required GitHub Secrets

Set these in your repository's **Settings → Secrets and variables → Actions**:

| Secret | Description |
|---|---|
| `BASE_URL` | Application URL |
| `API_BASE_URL` | API base URL |
| `USER_EMAIL` | Test account email |
| `USER_PASSWORD` | Test account password |
