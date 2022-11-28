package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.e2e.pages.*;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class LeilaoSteps {

    private LoginPage loginPage;
    private LeiloesPage leiloesPage;
    private NovoLeilaoPage novoLeilaoPage;
    private Browser browser;
    private AlterarLeilaoPage alterarLeilaoPage;

    @Dado("o usuario logado")
    public void o_usuario_logado() {
        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
        leiloesPage = loginPage.realizaLoginComoFulano();
    }

    @Quando("acessa a pagina de novo leilao")
    public void acessa_a_pagina_de_novo_leilao() {
        novoLeilaoPage = this.leiloesPage.visitaPaginaParaCriarUmNovoLeilao();
    }
    @Quando("preenche o formulario com dados validos")
    public void preenche_o_formulario_com_dados_validos() {
        leiloesPage = novoLeilaoPage.preencheForm("PC novo", "1500", "01/11/2020");
    }
    @Entao("volta para a pagina de leiloes")
    public void volta_para_a_pagina_de_leiloes() {
        Assert.assertTrue(leiloesPage.estaNaPaginaDeLeiloes());
    }
    @Entao("o novo leilao aparece na tabela")
    public void o_novo_leilao_aparece_na_tabela() {
        Assert.assertTrue(leiloesPage.existe("PC novo", "1500", "01/11/2020", "fulano"));
        browser.clean();
    }

    @Quando("acessa a pagina de edicao de um leilao")
    public void acessa_a_pagina_de_edicao_de_um_leilao() throws Exception {
        alterarLeilaoPage = leiloesPage.visitaPaginaParaAlterarLeilao();
    }

    @Quando("altera os dados do leilao")
    public void altera_os_dados_do_leilao() {
        alterarLeilaoPage.preencheForm("Novo item", "2000", "02/11/2020");
    }
    @Entao("o leilao aparece com novos dados na tabela")
    public void o_leilao_aparece_com_novos_dados_na_tabela() {
        Assert.assertTrue(leiloesPage.existe("Novo item", "2000", "02/11/2020", "fulano") );
    }


}
