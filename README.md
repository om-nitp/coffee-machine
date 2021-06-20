# coffee-machine

* We have exposed 2 public method from `CoffeeMachineApplication.java`, which is mainly responsible to interact with the users.
* Have configured number of outlet as `TOTAL_OUTLETS` and preparation time for beverages as `PREPARATION_TIME` into `Constant.java`.

* We have method `public void brewBeverage(int outletId, BeverageType beverageType)` into `CoffeeMachineApplication.java`, which is responsible to brew the beverages.
* We have method `public void addQuantity(IngredientsType type, double quantity)` into `CoffeeMachineApplication.java` to refill the ingredients.

* `AvailableResources.java` keeps the current status for each of the ingredients.

* `Brewer.java` is the class, which is brewing the selected **Beverages** from the selected **Outlet**, it is a shared object which will be used by all outlets parallely so methods are synchronized.

## config (package)

* `InitialResources.java` it has the initialy available quantity for each **Ingredients**
* `MinimumRequiredIngredients.java` it is used to set the minimum required quantity for each **Ingredients**, if the available quantity for any **Ingredients** is less the the minimum required quantity for the respective **Ingredients** then will give alert.
* `RequiredIngredients.java` it stores the reuired ingredients and there respective quantity for each **Beverages**

