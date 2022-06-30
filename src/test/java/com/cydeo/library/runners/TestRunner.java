package com.cydeo.library.runners;

        import io.cucumber.java.After;
        import io.cucumber.junit.Cucumber;
        import io.cucumber.junit.CucumberOptions;
        import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features",
        glue = "com/cydeo/library/step_definitions",
        dryRun = false,
        // dryRun = true turns off the running of step_definitions but
        // just checks if any step snippet is missing ; to stop that, just put 'false'
        tags = "@wip",
publish = true
        // "@Smoke" // without tags, it will execute of the step definition classes and scenarios
        //"@Librarian or @Admin" will look for both @Librarian and @Admin and will execute them
//"@Employee and @Admin" will look for scenarios that are @Employee and also @Admin and
// won't execute scenarios that are @Admin only or @Employee and @something else.
// "@Regression and not @Admin" will execute everything because @Regression tag is at top of page
        // except @Admin as 'and not ' is to exclude a scenario.

)

public class TestRunner {
}
