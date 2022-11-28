package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class LoginSteps {

    private Browser browser;
    private LoginPage loginPage;
    private LeiloesPage leiloesPage;
    private String usuario;
    private String password;

    @Before
    public void setUp() throws Exception {
        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
    }

    @Dado("o usuario valido")
    public void o_usuario_valido() {
        usuario = "fulano";
        password = "pass";
    }

    @Quando("realiza login")
    public void realiza_login() {
        leiloesPage = loginPage.realizaLoginComo(usuario, password);
    }

    @Entao("é redirecionado para a página de leilões")
    public void redirecionado_para_pagina_leiloes() {
        Assert.assertTrue(leiloesPage.estaNaPaginaDeLeiloes());
    }

    @Dado("o usuario invalido")
    public void o_usuario_invalido() {
        usuario = "fulano";
        password = "wrongPass";
    }

    @Entao("continua na página de login")
    public void continua_pagina_login() {
        Assert.assertTrue(loginPage.estaNaPaginaDeLoginComErro());
    }

}
