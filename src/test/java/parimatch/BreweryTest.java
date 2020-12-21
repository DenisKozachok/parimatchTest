package parimatch;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import parimatch.steps.BreweriesApiSteps;


public class BreweryTest {
    BreweriesApiSteps breweriesApiSteps = new BreweriesApiSteps();

    @DataProvider(name = "data")
    public Object[][] provideTestData() {
        return new Object[][] {
                {"oxford", 9},
                {"diving dog", 1},
                {"oklahoma", 43}
        };
    }

    @Test(dataProvider = "data")
    public void brewerySearchTest(String query, int resultsCount) {
        breweriesApiSteps
                .searchBreweries(query)
                .verifyGetResponse()
                .verifyStructure()
                .verifyHasSize(resultsCount)
                .verifyHaveQuery(query);
    }
}
