## Steps com Lambda

O Cucumber oferece uma alternativa ao uso das anotações como @Dado ou @Quando. Podemos implementar todos os steps de um cenários usando as famosas expressões lambda do Java8!

Para tal, devemos definir uma dependência extra dentro do nosso pom.xml:

```xml
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java8</artifactId>
    <version>${cucumber.version}</version>
    <scope>test</scope>
</dependency>
```

Uma vez feita, podemos rescrever a classe com os steps. Importante é implementar a interface io.cucumber.java8.Pt que possui para cada anotacao um método. Todos os métodos devem ser definidos dentro do construtor da classe. Vejo o exemplo:

```java
public class LeilaoSteps implements io.cucumber.java8.Pt {

    private LoginPage loginPage;
    private LeiloesPage leiloesPage;
    private NovoLeilaoPage novoLeilaoPage;
    private Browser browser;

    public LeilaoSteps() {
        Dado("um usuario logado", () -> {
            this.browser = new Browser();
            browser.seed();
            loginPage = browser.getLoginPage();
            leiloesPage = loginPage.realizaLoginComoFulano();
        });

        Quando("acessa a pagina de novo leilao", () -> {
            novoLeilaoPage = this.leiloesPage.visitaPaginaParaCriarUmNovoLeilao();
        });

        //resto omitido
    }
}
```
