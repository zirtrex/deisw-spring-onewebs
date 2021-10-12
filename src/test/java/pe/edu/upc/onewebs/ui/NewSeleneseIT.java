package pe.edu.upc.onewebs.ui;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@RunWith(JUnit4.class)
public class NewSeleneseIT {

    private WebDriver driver = null;
    //private WebDriver driver = null;
    private String browser = null;
    private String baseUrl = null;
    private String os = null;
    private String node = null;

    @BeforeClass
    public void inicializarDriver() throws MalformedURLException{
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\usuario_devops\\Downloads\\deisw-spring-onewebs\\geckodriver.exe");
        driver = new FirefoxDriver();
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

    /*@Test
    public void testEditarEquipo() {

        driver.get("http://localhost:8282/KoreanoSpringMVCMaven/editar-equipo.htm?codEquipo=1");


        WebDriverWait wait = new WebDriverWait(driver, 5);

        ExpectedCondition<Boolean> pageLoadCondition = new
            ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                }
            };

        wait.until(pageLoadCondition);

        WebElement nombre = driver.findElement(By.id("nombre"));
        nombre.sendKeys(" - Editado");
        WebElement marca = driver.findElement(By.id("marca"));
        marca.sendKeys(" - Editado");
        WebElement modelo = driver.findElement(By.id("modelo"));
        modelo.sendKeys(" - Editado");

        WebElement btnSubmit = driver.findElement(By.id("submit"));
        btnSubmit.click();

        WebElement mensaje = driver.findElement(By.className("uk-alert-danger"));
        wait.until(ExpectedConditions.visibilityOf(mensaje));

        Assert.assertEquals("Se ha editado el equipo correctamente", mensaje.getText());

    }*/

    /*@Test
    public void testEliminarEquipo() {


        driver.get("http://localhost:8282/KoreanoSpringMVCMaven/eliminar-equipo.htm?codEquipo=2");


        WebDriverWait wait = new WebDriverWait(driver, 10);

        ExpectedCondition<Boolean> pageLoadCondition = new
            ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                }
            };

        wait.until(pageLoadCondition);

        WebElement btnSubmit = driver.findElement(By.id("submit"));
        btnSubmit.click();

        WebElement mensaje = driver.findElement(By.className("uk-alert-danger"));
        wait.until(ExpectedConditions.visibilityOf(mensaje));

        Assert.assertEquals("Se ha eliminado el equipo correctamente", mensaje.getText());

    }*/

    @AfterClass
    public void liquidarDriver() {
        driver.quit();
    }

}
