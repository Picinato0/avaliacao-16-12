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

//    @InjectMocks
//    private ProdutoController produtoController;
//
//    @Mock
//    private ProdutoService produtoService;
//
//    @Mock
//    private ProdutoRepository produtoRepository;
//
//    @BeforeEach
//    public void setup() {
//        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//    }
//
//    @BeforeEach
//    void setUp() throws Exception {
//
//        when(produtoService.insert(ArgumentMatchers.any()))
//                .thenReturn(ProdutoCreator.createNewProduto());
//    }


    @Test
    @DisplayName("Retornar status code 404 quando buscar nomeProduto inexistente")
    public void shouldReturnStatusCode404_WhenSearchUnexistingNomeProduto() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/produto/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

//    @Test
//    @DisplayName("Verifica se tem algum nome de produto duplicado")
//    public void verifyCreate() {
//        when(ProdutoRepository.findByNomeProduto(ArgumentMatchers.anyString())).thenReturn(Optional.of(ProdutoCreator.createNewProduto()));
//        assertThatExceptionOfType(Exception.class).isThrownBy(() -> produtoService.insert(ProdutoCreator.createNewProduto()));
//    }

}