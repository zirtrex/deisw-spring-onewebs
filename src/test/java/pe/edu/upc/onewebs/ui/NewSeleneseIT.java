package pe.edu.upc.onewebs.ui;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewSeleneseIT {

    private WebDriver driver = null;
    //private WebDriver driver = null;
    private String browser = null;
    private String baseUrl = null;
    private String os = null;
    private String node = null;

    @Before
    public void inicializarDriver() throws MalformedURLException{
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\usuario_devops\\Downloads\\deisw-spring-onewebs\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    @DisplayName(value = "testCrearUsuario -> testCrearUsuario")
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

    @Test
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
        wait.until(ExpectedConditions.visibilityOf(mensaje));

        Assert.assertEquals("Cerrar Sesión: zirtrex", mensaje. getText());
    }

    @After
    public void liquidarDriver() {
        driver.quit();
    }

}
