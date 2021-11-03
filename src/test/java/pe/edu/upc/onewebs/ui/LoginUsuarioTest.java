package pe.edu.upc.onewebs.ui;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pe.edu.upc.onewebs.DeiswSpringOnewebsApplication;
import io.github.bonigarcia.wdm.WebDriverManager;
import pe.edu.upc.onewebs.selenium.support.SeleniumTest;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = DeiswSpringOnewebsApplication.class)
//@SpringApplicationConfiguration(classes = DeiswSpringOnewebsApplication.class)
//@WebIntegrationTest(value = "server.port=8081")
//@SeleniumTest(driver = FirefoxDriver.class, baseUrl = "http://localhost:8081")
//@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(properties = "server.port=8081", webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@SeleniumTest(driver = FirefoxDriver.class, baseUrl = "http://localhost:8081/onewebs/login")
public class LoginUsuarioTest {
    @Autowired
    private WebDriver driver;
    private HomePage homePage;
    private String browser = null;
    private String baseUrl = null;
    private String os = null;
    private String node = null;

    @Before
    public void setUp() throws Exception {
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    @Ignore
    public void testLoginUsuario() {
        //Obtener url
        driver.get("http://localhost:8081/onewebs/login");

        WebDriverWait wait = new WebDriverWait(driver, 5);

        ExpectedCondition<Boolean> pageLoadCondition = new
            ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                }
            };

        wait.until(pageLoadCondition);

        WebElement usuario = driver.findElement(By.id("inputUsername"));
        usuario.sendKeys("zirtrex");
        WebElement clave = driver.findElement(By.id("inputPassword"));
        clave.sendKeys("123456");

        WebElement btnSubmit = driver.findElement(By.id("loginButton"));
        btnSubmit.click();

        //Tenemos que volver a esperar que cargue bien la página
        WebDriverWait wait2 = new WebDriverWait(driver, 5);
        wait2.until(pageLoadCondition);

        WebElement mensaje = driver.findElement(By.id("logoutButton"));
        wait2.until(ExpectedConditions.visibilityOf(mensaje));

        Assert.assertEquals("Cerrar Sesión: zirtrex", mensaje. getText());
    }

    @After
    public void liquidarDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}
