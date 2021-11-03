package pe.edu.upc.onewebs.ui;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.edu.upc.onewebs.selenium.support.SeleniumTest;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "server.port=8081", webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@SeleniumTest(driver = FirefoxDriver.class, baseUrl = "http://localhost:8081/onewebs/signup")
public class HomeControllerTest {

   @Autowired
   private WebDriver driver;

   private HomePage homePage;

   @Before
   public void setUp() throws Exception {
       homePage = PageFactory.initElements(driver, HomePage.class);
   }

   @Test
   public void containsActuatorLinks() {
       homePage.assertThat()
               .hasActuatorLink("autoconfig");
   }

   /*@Test
   @Ignore
   public void failingTest() {
       homePage.assertThat()
               .hasNoActuatorLink("autoconfig");
   }*/

}
