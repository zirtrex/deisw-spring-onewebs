package pe.edu.upc.onewebs.unit.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import pe.edu.upc.onewebs.controller.ComisariaController;

public class ComisariaControllerTest {

    @Mock
    Model model;

    @Test
    @DisplayName(value = "testListAll -> Probar testListAll")
    public void testListAll() {
        // Give [ExplainYourInput] Arrange
        ComisariaController comisariaController = new ComisariaController();
        String[] paramArray = null;
        String resultActual = "/comisaria/listall"; //Index es lo que devuelve el controlador
        // When [WhatIsDone] Act
        String resultReal = comisariaController.listAll(model);
        // Then [ExpectedResult] Assert
        assertEquals(resultActual, resultReal); // Param1. Expected, Param2 Actual
    }

}
