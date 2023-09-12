<img src="singular.svg" height="70" alt="Singular">

# Desafio Hackathon - Bem-vindo(a)!

Olá, desafiante! Este é o nosso desafio final da Hackathon. Estamos ansiosos para ver suas habilidades em ação!

## O que vamos avaliar?

Neste desafio, queremos ver como você lida com novas tecnologias e resolve problemas. Vamos observar:

1. **Habilidade de adaptação e aprendizado**
    - Como você se adapta a novas ferramentas e recursos para criar soluções?

1. **Resolução de problemas**
    - Como você lida com problemas técnicos e encontra soluções eficazes?

1. **Capacidade de comunicação**
    - Como você faz perguntas e tira-dúvidas com o nosso time.

## O Desafio

## Cadastro de fornecedores

Para o nosso desafio, iremos utilizar um aplicativo de cadastro de fornecedores. Este mini sistema possui as seguintes funcionalidades:

- Listagem dos fornecedores
- Inclusão e edição de fornecedores.

Para a construção deste sistema foram utilizadas as seguintes tecnologias:

- Spring Boot
- Spring Data JPA
- Java 11
- Wicket
- Maven

**O Contexto:**

O aplicativo está funcional, estamos buscando melhorias e correções para torná-lo ainda melhor. Queremos que você aplique seu conhecimento e criatividade para enfrentar estes desafios.

## Como começar

1. Faça um fork deste projeto no GitHub.
2. Crie um novo branch com o seu nome.
3. Faça o push da branch para o repositório.

## Regras importantes

1. Fazer commit e push de todas as etapas do desafio. Exemplo: Danilo finalizou o desafio 1, antes de ir para etapa seguinte já faça o push das alterações!
2. Fique atento ao tempo! Teremos pouco tempo para implementar o desafio, então é fundamental que se consiga conciliar o tempo entre desenvolver os desafios e ajudar os colegas.
3. Não fique travado, tire suas dúvidas!

## Desafio 1: Novo campo

Durante a implementação do cadastro de fornecedores, um dos campos não havia sido especificado. Porém, ao apresentar o cadastro para o cliente, sentiu-se falta do campo "Nome do contato".

### O que deve ser feito?

- Incluir o campo "Nome do Contato" no cadastro de fornecedor.

### Como?

- Incluir a coluna na tabela FORNECEDOR, arquivo schema.sql (observe que pode-se alterar o próprio script de criação, não sendo via `alter table`).
- Atualizar script de carga para inclusão de valores ao novo campo, arquivo data.sql.
- Incluir o campo na entidade FornecedorEntity e criar os getters/ setters.
- Incluir o campo na listagem de fornecedores (ListarFornecedorPage).
- Incluir o campo na tela de edição de fornecedores (EditarFornecedorPage).

### Qual o resultado esperado?

Que haja um novo campo na listagem e edição de fornecedores, e que seja possível salvar e alterar o novo campo.

### Bibliografia e links

- [SQL Create Table](https://www.w3schools.com/sql/sql_create_table.asp)
- [SQL Insert](https://www.w3schools.com/sql/sql_insert.asp)
- [Wicket Models and Forms](https://nightlies.apache.org/wicket/guide/9.x/single.html#_wicket_models_and_forms)

## Desafio 2: Integração com VIACEP

Durante o cadastro de um fornecedor, é necessário informar o endereço da empresa. Uma maneira de acelerar o preenchimento e reduzir a entrada de dados inconsistentes é preencher automaticamente os campos a partir do CEP. Um serviço interessante para realizar essa tarefa é o VIACEP (https://viacep.com.br/).

### O que deve ser feito?

- Preencher os dados do endereço utilizando o CEP.

### Como?

- Já deixamos pronto o ponto de criação do serviço, a classe `org.opensingular.hackathon.service.ViaCepIntegracaoService`. Aqui, você deve implementar o método `EnderecoDTO buscar(String cep)`, que atualmente retorna um endereço vazio.
- Para implementar esse método, você deve utilizar alguma biblioteca de chamada HTTP. Recomendamos o uso do `RestTemplate` do Spring Framework.
- No entanto, apenas implementar o método não resolverá 100% do problema. É necessário analisar mais dois pontos:
    - Quem chama o método `org.opensingular.hackathon.service.ViaCepIntegracaoService.buscar`?
    - A tela `org.opensingular.hackathon.view.fornecedor.EditarFornecedorPage` já está preparada para atualizar a página com os novos dados?

### Qual o resultado esperado?

- Caso esteja tudo OK, os dados de endereço devem ser preenchidos automaticamente assim que o usuário preencher e sair do campo "CEP".

### Bibliografia e links

- [VIACEP](https://viacep.com.br/)
- [Consumindo REST com Spring Framework](https://spring.io/guides/gs/consuming-rest/)
- [Trabalhando com AJAX no Apache Wicket](https://nightlies.apache.org/wicket/guide/9.x/single.html#_working_with_ajax)

## Desafio 3: Instalação e configuração de plugin

Durante o cadastro de um fornecedor, é necessário informar o CEP e CNPJ. Uma maneira de reduzir a entrada de dados inconsistentes é aplicar máscaras aos campos.

### O que deve ser feito?

- Instalar e configurar o jQuery Mask Plugin para adicionar máscaras aos campos "CEP" e "CNPJ".

### Como?

- Criar uma nova classe que será um [Behavior](https://nightlies.apache.org/wicket/guide/9.x/single.html#_enriching_components_with_behaviors) do Wicket (`JQueryMaskBehaviour`).
- Instalar a biblioteca [jQuery Mask Plugin](https://github.com/igorescobar/jQuery-Mask-Plugin). Uma dica é sobrescrever o método 'renderHead', e um exemplo de instalação está disponível na classe `SweetAlertFeedbackBehaviour`.
- Incluir o script de inicialização também no `renderHead`.

### Qual o resultado esperado?

- O campo CNPJ deve estar com a máscara aplicada automaticamente.
- Deve ser possível adicionar máscaras de forma fácil a qualquer outro campo. Por exemplo:
    ``` java
    new TextField('cep').add(new JQueryMaskBehaviour('00000-000'));
    new TextField('cpf').add(new JQueryMaskBehaviour('000.000.000-00'));
    ```
  
## Bibliografia e links
- [Formato CNPJ](https://pt.wikipedia.org/wiki/Cadastro_Nacional_da_Pessoa_Jur%C3%ADdica#Formato)
- [Behavior](https://nightlies.apache.org/wicket/guide/9.x/single.html#_enriching_components_with_behaviors)
- [jQuery Mask Plugin](https://github.com/igorescobar/jQuery-Mask-Plugin)
- [jQuery Mask Plugin - Documentação](https://igorescobar.github.io/jQuery-Mask-Plugin/docs.html)

## Entrega
Para enviar seu código, crie um pull-request neste projeto.

# Boa Sorte!
