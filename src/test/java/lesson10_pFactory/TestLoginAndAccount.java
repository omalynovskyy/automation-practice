package lesson10_pFactory;

import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class TestLoginAndAccount {
    static WebDriver driver;

    LoginPage chainedLoginPage;
    AccountPage chainedAccountPage;


    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

//    @Test
    //этот тест содержит все три теста в одном методе - он проходит успешно
//    public void allInOne(){
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.openLoginPage();
//        Assert.assertThat(driver.getTitle(), CoreMatchers.containsString("Login"));
//        chainedAccountPage = loginPage.login("email4test@gmail.com", "passwd4test");
//        Assert.assertThat(driver.getTitle(), CoreMatchers.containsString("My account"));
//        chainedLoginPage = chainedAccountPage.signOut();
//        Assert.assertThat(driver.getTitle(), CoreMatchers.containsString("Login"));
//        chainedLoginPage.enterUserName("email4test@gmail.com");
//        chainedLoginPage.enterPassword("passwd4test");
//        chainedLoginPage.clickSignInBtn();
//        Assert.assertThat(driver.getTitle(), CoreMatchers.containsString("My account"));

//    }

    @Test
    //Этот тест выполняется успешно
    public void loginByOneMthd(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        Assert.assertThat(driver.getTitle(), CoreMatchers.containsString("Login"));
        chainedAccountPage = loginPage.login("email4test@gmail.com", "passwd4test");
        Assert.assertThat(driver.getTitle(), CoreMatchers.containsString("My account"));

    }

    @Test
    //Этот тест валится (даже если начать его с того чем успешно заканчивается предідущие) и как следствие следующий тест тоже валится
    /*
    java.lang.NullPointerException
	at lesson10_pFactory.TestLoginAndAccount.signOutTest(TestLoginAndAccount.java:63)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:567)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)
	at org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:33)
	at com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:230)
	at com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:58)

     */
    public void signOutTest(){
        //Assert.assertThat(driver.getTitle(), CoreMatchers.containsString("My account"));
        chainedLoginPage = chainedAccountPage.signOut();
        Assert.assertThat(driver.getTitle(), CoreMatchers.containsString("Login"));

    }

    @Test
    //
    public void loginByThreeMthd(){
        Assert.assertThat(driver.getTitle(), CoreMatchers.containsString("Login"));
        chainedLoginPage.enterUserName("email4test@gmail.com");
        chainedLoginPage.enterPassword("passwd4test");
        chainedLoginPage.clickSignInBtn();
        Assert.assertThat(driver.getTitle(), CoreMatchers.containsString("My account"));
    }

}
