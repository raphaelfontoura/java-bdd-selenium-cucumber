# language: pt

Funcionalidade: Propondo lances ao leilao

Cenario: Propondo um unico lance valido
    Dado um lance valido
    Quando propoe um lance ao leilao
    Entao o lanche eh aceito

Cenario: Propondo varios lances validos
    Dado varios lances validos
    Quando propoe varios lances ao leilao
    Entao os lances sao aceitos