#language: pt

Funcionalidade: Rastrear objeto por código

  @sucesso
  Cenário: Rastrear objeto com sucesso
    Dado que acesso o sistema do correios
    Quando insiro o código "CODIGO-DE-RASTREIO"
    E clico no botão Buscar
    Então é exibida a página com o status do objeto

  @validar
  Esquema do Cenario: Validar campo de busca
    Dado que acesso o sistema do correios
    Quando insiro o código "<codigo>"
    E clico no botão Buscar
    Então recebo a "<mensagem>"

    Exemplos:
      | codigo  |               mensagem                                                 |
      | LB15131 | O(s) código(s) ou CPF/CNPJ estão inválidos                             |
      |         | Por favor, digite de um a 50 códigos de objetos, ou um CPF/CNPJ válido |
