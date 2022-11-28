package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class LoginSteps {

    private Browser browser;
    private LoginPage loginPage;
    private LeiloesPage leiloesPage;

    private String usuario;

    @Dado("o usuario valido")
    public void o_usuario_valido() {
        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
        usuario = "fulano";
    }

    @Quando("realiza login")
    public void realiza_login() {
        leiloesPage = loginPage.realizaLoginComo(usuario, "pass");
    }

    @Entao("é redirecionado para a página de leilões")
    public void redirecionado_para_pagina_leiloes() {
        Assert.assertTrue(leiloesPage.estaNaPaginaDeLeiloes());
    }

    @Dado("o usuario invalido")
    public void o_usuario_invalido() {
        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
        usuario = "cicrano";
    }

    @Entao("continua na página de login")
    public void continua_pagina_login() {
        Assert.assertTrue(loginPage.estaNaPaginaDeLoginComErro());
    }

}
