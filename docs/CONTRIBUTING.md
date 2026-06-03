# Contributing Guide

## Adding a New Module

1. **Create the Step Interface** in `src/main/java/automation/platforms/core/academic/<module>/`
   ```java
   public interface YourModuleSteps {
       boolean navigateToYourModule();
       boolean someAction(YourModuleModel data);
   }
   ```

2. **Create the Locator class** extending `BaseLocator`
   ```java
   public class YourModuleLocator extends BaseLocator {
       public final String SOME_BUTTON = "#some-button-id";
   }
   ```

3. **Create the Model class** extending `BaseModel` with factory methods
   ```java
   public class YourModuleModel extends BaseModel {
       public String fieldA;
       public YourModuleModel generateValidData() { ... }
   }
   ```

4. **Create the Page class** extending `BaseCore<YourModuleLocator>` and implementing your Steps interface

5. **Create the TestCase interface** in `src/test/java/.../<module>/`

6. **Create the Test class** extending `BaseCoreDriverTest` and implementing the TestCase interface

7. **Register the test** in `testng.xml`

## Naming Conventions

| Type | Convention | Example |
|---|---|---|
| Page class | `<Module>Page` | `BankClusterPage` |
| Locator class | `<Module>Locator` | `BankClusterLocator` |
| Model class | `<Module>Model` | `BankClusterModel` |
| Steps interface | `<Module>Steps` | `BankClusterSteps` |
| Test class | `<Module>Test` | `BankClusterTest` |
| TestCase interface | `<Module>TestCase` | `BankClusterTestCase` |
| API client | `<Module>API` | `ClusterAPI` |

## Test Method Naming

Test methods should clearly describe the scenario:
- `successfullyCreateXxxWithValidData()`
- `failedToCreateXxxWhenMandatoryFieldIsEmpty()`
- `successfullySearchXxxByKeyword()`
