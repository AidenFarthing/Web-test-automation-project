package com.sparta.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Inventory.feature",
        glue = "com.sparta.steps",
        plugin = {"pretty"}
)
public class TestRunnerInventory {
}