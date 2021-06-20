package com.sample.coffeemachine.exceptions;

import com.sample.coffeemachine.beverages.BeverageType;
import com.sample.coffeemachine.config.IngredientsType;

public class RequiredQuantityNotAvailableException extends RuntimeException {

    public RequiredQuantityNotAvailableException(BeverageType beverageType, IngredientsType ingredientsType) {
        super(beverageType + " cannot be prepared because " + ingredientsType + " is not available");
    }
}
