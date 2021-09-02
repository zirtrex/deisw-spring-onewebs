package pe.edu.upc.onewebs.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StarterControllerTest {

    /*@BeforeClass
    public void setUp() throws Exception {
    }*/

    @Test
    @DisplayName(value = "testStarter -> Probar la carga inicial de la web")
    public void testStarter() {
        // Give [ExplainYourInput] Arrange
        StarterController starterController = new StarterController();
        String[] paramArray = null;
        String resultActual = "index"; //Index es lo que devuelve el controlador
        // When [WhatIsDone] Act
        String resultReal = starterController.starter();
        // Then [ExpectedResult] Assert
        assertEquals(resultActual, resultReal); // Param1. Expected, Param2 Actual
    }

    @Test
    @DisplayName(value = "testLogin -> Probar la carga del login")
    public void testLogin() {
        // Give [ExplainYourInput] Arrange
        StarterController starterController = new StarterController(); //Controlador el mismo
        String[] paramArray = null;
        String resultActual = "login"; //Login es lo que devuelve el controlador
        // When [WhatIsDone] Act
        String resultReal = starterController.login(); //Aqui va el nombre del mtodo que queremos probar
        // Then [ExpectedResult] Assert
        assertEquals(resultActual, resultReal); // Param1. Expected, Param2 Actual
    }


}