## Projeto Leilao com a ALURA - BDD e Java

> Projeto para acompanhamento do curso de BDD e Java da Alura usando recursos do Cucumber e Selenium.
 
### Rodando o projeto.

Necessário ter o Java 8 SDK instalado.

Caso utilize o Intellij, adicionar a variável de ambiente para definir o profile como test.

```bash
SPRING_PROFILES_ACTIVE=test
```

Ou utilizando as opções VM das configurações (Edit Configurations > Run Configurations).

Também é possível rodar utilizando o comando maven no terminal:

```bash
$ ./mvnw spring-boot:run -Dspring-boot.run.profiles=test
```

Ao rodar em modo test é possível acessar a rota /db/seed para alimentar o banco com dados iniciais.

Caso rode os testes do selenium em chrome ou firefox, necessário verificar as versões do driver na pasta /drivers.

### Tecnologias utilizadas:

>Cucumber

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)

![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)

![Selenium](https://img.shields.io/badge/-selenium-%43B02A?style=for-the-badge&logo=selenium&logoColor=white)

