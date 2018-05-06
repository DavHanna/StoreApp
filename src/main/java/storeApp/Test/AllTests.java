package storeApp.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ActionTests.class, BrandTests.class, LoginTests.class, OrderTests.class, ProductTests.class,
		RegisterTests.class, StoreTests.class })
public class AllTests {

}
