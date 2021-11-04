package pe.edu.upc.onewebs.ui;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.edu.upc.onewebs.ui.selenium.support.SeleniumTest;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = DeiswSpringOnewebsApplication.class)
//@SpringApplicationConfiguration(classes = DeiswSpringOnewebsApplication.class)
//@WebIntegrationTest(value = "server.port=8081")
//@SeleniumTest(driver = FirefoxDriver.class, baseUrl = "http://localhost:8081")
//@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(properties = "server.port=8081", webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@SeleniumTest(driver = FirefoxDriver.class, baseUrl = "http://localhost:8081/onewebs/signup")
public class CrearUsuarioTest {
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
    public void testCrearUsuario() {

        //Aquí obtenemos la url que queremos probar
        driver.get("http://localhost:8081/onewebs/signup");
        //Esta condicion espera que la pagina cargue correctamente antes de hacer algo
        ExpectedCondition<Boolean> pageLoadCondition = new
            ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                }
            };
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(pageLoadCondition);

        //Obtenemos la referencia al campo usuario
        WebElement username = driver.findElement(By.id("username"));
        //Seteamos valores
        username.sendKeys("zirtrex");
        //Obtenemos la referencia al campo password
        WebElement password = driver.findElement(By.id("password"));
        //Seteamos valores
        password.sendKeys("123456");

        //Hacemos click en el boton registrar
        WebElement btnRegistrar = driver.findElement(By.id("registrar"));
        btnRegistrar.click();

        //Tenemos que volver a esperar que cargue bien la página
        WebDriverWait wait2 = new WebDriverWait(driver, 5);
        wait2.until(pageLoadCondition);

        WebElement mensaje = driver.findElement(By.id("inputUsername"));
        wait2.until(ExpectedConditions.visibilityOf(mensaje));

        //Agregamos un Assert
        Assert.assertEquals("", mensaje.getText());
    }

    @After
    public void liquidarDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}
