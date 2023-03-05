package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports.html",
                    "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun= false,
        tags = "@femaleScientists"

       // tags = "@Regression"
        // or "@librarian"
        // or "@librarian or @student" ==> means run both @librarian and @student
        // or "@Regression and @student" ==> means run only @student one under @Regression heading
        // or "@Regression and not@student" ==> means run all scenarios except student one
)

public class CukesRunner {
}
