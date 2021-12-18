package com.questao.avaliacao04.selenium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    private WebDriver nav;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.operadriver().setup();
    }

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver","/Faculdade/WebDrivers/bin/ChromeDriver.exe");
        nav = new ChromeDriver();
    }

    @Test
    void criaUmNovo() {
        nav.get("http://localhost:3000/");
        nav.manage().window().maximize();
        nav.findElement(By.id("botao-produto")).click();
        nav.findElement(By.id("botao-create")).click();
        nav.findElement(By.name("nome-input")).sendKeys("joaozinho");
        nav.findElement(By.name("estoque-input")).sendKeys("teste");
        nav.findElement(By.name("venda-input")).sendKeys("teste");
        nav.findElement(By.name("compra-input")).sendKeys("teste");
        nav.findElement(By.name("criaProduto-submit")).click();

    }
}