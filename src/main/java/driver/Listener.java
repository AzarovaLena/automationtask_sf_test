package driver;

import org.testng.ITestContext;
import org.testng.ITestListener;
import conf.ConfProperties;
import static driver.MainDriver.setDriver;

public class Listener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ConfProperties properties = new ConfProperties();
        properties.setProperties("src/main/resources/conf.properties");
        setDriver();
    }

    @Override
    public void onFinish(ITestContext context) {
        MainDriver.quitDriver();
    }
}