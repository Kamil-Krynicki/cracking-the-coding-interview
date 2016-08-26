import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.awt.peer.SystemTrayPeer;

import static org.testng.Assert.*;

/**
 * Created by K on 2016-08-26.
 */
public class testJavaClassTest {

    @Test(invocationCount = 100)
    public void method1Test(){
        Assert.assertEquals(1, 1);
    }
}