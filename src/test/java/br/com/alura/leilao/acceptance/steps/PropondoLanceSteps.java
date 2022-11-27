package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;

public class PropondoLanceSteps {

    private Leilao leilao;
    private ArrayList<Lance> lista;
    private Lance lance;

    @Before
    public void setUp() throws Exception {
        lista = new ArrayList<Lance>();
        leilao = new Leilao("Tablet XPTO");
    }

    @Dado("um lance valido")
    public void dado_um_lance_valido() {
        Usuario usuario = new Usuario("fulano");
        lance = new Lance(usuario, BigDecimal.TEN);
    }

    @Quando("propoe um lance ao leilao")
    public void quando_propoe_o_lance() {
        this.leilao.propoe(lance);
    }

    @Entao("o lance eh aceito")
    public void entao_o_lanche_eh_aceito() {
        Assert.assertEquals(1, leilao.getLances().size());
        Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
    }

    @Dado("um lance de {double} reais do usuario {string}")
    public void um_lance_de_reais_do_usuario_fulado(Double valor, String nomeUsuario) {
        Lance lance = new Lance(new Usuario(nomeUsuario), new BigDecimal(valor));
        lista.add(lance);
    }

    @Quando("propoe varios lances ao leilao")
    public void propoe_varios_lances_ao_leilao() {
        this.lista.forEach(lance -> leilao.propoe(lance));
    }

    @Entao("os lances sao aceitos")
    public void os_lances_sao_aceitos() {
        Assert.assertEquals(this.lista.size(), leilao.getLances().size());
        Assert.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
        Assert.assertEquals(this.lista.get(1).getValor(), leilao.getLances().get(1).getValor());
    }

    @Dado("um lance invalido de {double} reais")
    public void um_lance_invalido_de_reais(Double valor) {
        lance =  new Lance(new BigDecimal(valor));
    }

    @Entao("o lance nao eh aceito")
    public void o_lance_nao_eh_aceito() {
        Assert.assertEquals(0, leilao.getLances().size());
    }

}
