package pe.edu.upc.onewebs.integration;

import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pe.edu.upc.onewebs.DeiswSpringOnewebsApplication;

import java.io.File;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;

@RunWith(SpringRunner.class)
@SpringBootTest(
		classes = DeiswSpringOnewebsApplication.class
)
public class StarterControllerTests {

	@Autowired
	private WebApplicationContext wac; //Llamamos al contexto

	private MockMvc mockMvc; //Creamos un mock

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build(); //Configuramos que el mocl use nuetro contexto web
	}

	@Test
	@DisplayName(value = "testStarter -> Probar la carga inicial de la web")
	public void testStarterEndpointIsOK() throws Exception {

		File index = new ClassPathResource("templates/index.html").getFile();
		String html = new String(Files.readAllBytes(index.toPath())); //Esto puede ser usado si quieres comprobar la carga entera de una web html

		this.mockMvc.perform(get("/onewebs")) //llamamos al mock y le pasamos el endpoint
				.andDo(print()) //Imprimos el resultado po consola
				.andExpect(status().isOk()) //Verificamos decuelva un 200
				.andExpect(view().name("index2")) //Nos aseguramos que cargue la vista correcta
				.andExpect(content().string(containsString("Detenidos"))) //Y nos aseguramos que la web contnega la palabra detenidos
				.andDo(print());
	}

}
