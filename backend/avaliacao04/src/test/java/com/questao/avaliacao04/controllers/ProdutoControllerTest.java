package com.questao.avaliacao04.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.questao.avaliacao04.models.FornecedorModel;
import com.questao.avaliacao04.models.ProdutoModel;
import com.questao.avaliacao04.repositories.ProdutoRepository;
import com.questao.avaliacao04.services.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ProdutoControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ProdutoController controller;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Retornar status code 404 quando buscar nomeProduto inexistente")
    public void shouldReturnStatusCode404_WhenSearchUnexistingNomeProduto() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/produto/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Deve retornar 422 quando criar contato com email existente")
    public void deveRetornar422_QuandoCriarProdutoExistente() throws Exception {
        ProdutoModel produtoExistente = new ProdutoModel(1L, "nomeTest1", "estoqueTest", "vendaTest", "compraTeste", null , null);
        ProdutoModel produto = new ProdutoModel(1L, "nomeTest1", "estoqueTest2", "vendaTest2", "compraTeste2", null , null);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(produtoExistente);
        String json2 = mapper.writeValueAsString(produto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/produtos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/produtos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());
    }

}