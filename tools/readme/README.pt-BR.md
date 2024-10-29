# challenge_action-labs

</br>

<div align="center">

![Java Version](https://img.shields.io/badge/Java-v17-important)
![Spring Boot](https://img.shields.io/badge/spring_boot-%236DB33F)
![Hibernate](https://img.shields.io/badge/hibernate-%2359666C)
![Maven](https://img.shields.io/badge/gradlew-%2302303A)

</div>

<div align="center">

![MySQL](https://img.shields.io/badge/mongodb-%47A248)
![Docker Compose](https://img.shields.io/badge/docker--compose-%230055A4)

</div>

<div align="center">

[➜ Read me in English](https://github.com/matheus-srego/challenge_action-labs/blob/main/README.md)

</div>


## Índice

 - [Stack](#stack)
 - [Árvore do Projeto](#árvore-do-projeto)
 - [Descrição](#descrição)
    - [Lógica da calculadora](#lógica-da-calculadora)
    - [Classes já criadas](#classes-já-criadas)
 - [Detalhes da solução](#detalhes-da-solução)
 - [Como executar o projeto](#como-executar-o-projeto)
 - [Licença](#licença)

## Stack
  - `Java 17`
  - `Spring Boot`
  - `Gradlew`
  - `Hibernate Validator`
  - `MongoDB`
  - `Lombok`
  - `Docker Compose`
  - `Postman`

<details>
    <summary><h2 id="arvore-do-projeto">Árvore do projeto</h2></summary>

```bash
.
├── LICENSE
├── README.md
│   ├── build.gradle
│   ├── gradle
│   │   └── wrapper
│   │       └── gradle-wrapper.properties
│   ├── gradlew
│   ├── gradlew.bat
│   ├── settings.gradle
│   └── src
│       ├── main
│       │   ├── java
│       │   │   └── br
│       │   │       └── com
│       │   │           └── actionlabs
│       │   │               └── carboncalc
│       │   │                   ├── CarbonCalculatorApplication.java
│       │   │                   ├── annotation
│       │   │                   │   ├── UniqueEmail.java
│       │   │                   │   └── UniquePhoneNumber.java
│       │   │                   ├── config
│       │   │                   │   ├── AppConfig.java
│       │   │                   │   └── OpenApiSwaggerConfig.java
│       │   │                   ├── dto
│       │   │                   │   ├── CarbonCalculationResultDTO.java
│       │   │                   │   ├── EnergyDTO.java
│       │   │                   │   ├── ServerStatusDTO.java
│       │   │                   │   ├── SolidWasteDTO.java
│       │   │                   │   ├── StartCalcRequestDTO.java
│       │   │                   │   ├── StartCalcResponseDTO.java
│       │   │                   │   ├── TransportationDTO.java
│       │   │                   │   ├── UpdateCalcInfoRequestDTO.java
│       │   │                   │   ├── UpdateCalcInfoResponseDTO.java
│       │   │                   │   └── exception
│       │   │                   │       ├── ErrorResponseDTO.java
│       │   │                   │       └── FieldErrorsResponseDTO.java
│       │   │                   ├── enums
│       │   │                   │   └── TransportationType.java
│       │   │                   ├── exception
│       │   │                   │   └── GlobalExceptionHandler.java
│       │   │                   ├── mapper
│       │   │                   │   ├── CarbonCalculationInfoMapper.java
│       │   │                   │   ├── CarbonCalculationResultMapper.java
│       │   │                   │   ├── EnergyEmissionFactorMapper.java
│       │   │                   │   ├── SolidWasteEmissionFactorMapper.java
│       │   │                   │   ├── TransportationEmissionFactorMapper.java
│       │   │                   │   └── UserMapper.java
│       │   │                   ├── model
│       │   │                   │   ├── CarbonCalculationInfo.java
│       │   │                   │   ├── EnergyEmissionFactor.java
│       │   │                   │   ├── SolidWasteEmissionFactor.java
│       │   │                   │   ├── TransportationEmissionFactor.java
│       │   │                   │   └── UserEmissionFactor.java
│       │   │                   ├── repository
│       │   │                   │   ├── CarbonCalculationInfoRepository.java
│       │   │                   │   ├── EnergyEmissionFactorRepository.java
│       │   │                   │   ├── SolidWasteEmissionFactorRepository.java
│       │   │                   │   ├── TransportationEmissionFactorRepository.java
│       │   │                   │   └── UserEmissionFactorRepository.java
│       │   │                   ├── rest
│       │   │                   │   ├── OpenRestController.java
│       │   │                   │   └── StatusRestController.java
│       │   │                   ├── service
│       │   │                   │   ├── CarbonCalculationInfoService.java
│       │   │                   │   ├── CarbonCalculationProcessManager.java
│       │   │                   │   ├── EnergyEmissionFactorService.java
│       │   │                   │   ├── SolidWasteEmissionFactorService.java
│       │   │                   │   ├── TransportationEmissionFactorService.java
│       │   │                   │   ├── UserEmissionFactorService.java
│       │   │                   │   └── impls
│       │   │                   │       ├── CarbonCalculationInfoServiceImpl.java
│       │   │                   │       ├── CarbonCalculationProcessManagerImpl.java
│       │   │                   │       ├── EnergyEmissionFactorServiceImpl.java
│       │   │                   │       ├── SolidWasteEmissionFactorServiceImpl.java
│       │   │                   │       ├── TransportationEmissionFactorServiceImpl.java
│       │   │                   │       └── UserEmissionFactorServiceImpl.java
│       │   │                   ├── utils
│       │   │                   │   └── CONSTANTS.java
│       │   │                   └── validator
│       │   │                       ├── UniqueEmailValidator.java
│       │   │                       └── UniquePhoneNumberValidator.java
│       │   └── resources
│       │       └── application.yml
│       └── test
│           └── java
│               └── br
│                   └── com
│                       └── actionlabs
│                           └── carboncalc
│                               └── CarbonCalculatorApplicationTests.java
├── docker-compose.yml
└── tools
    ├── db
    │   ├── data
    │   └── init-mongo.js
    └── readme
        └── README.pt-BR.md
```
</details>

## Descrição

Crie o backend para uma calculadora de carbono usando Java, Spring Boot e MongoDB.

**➜ [POST] /open/start-calc**

Inicia o processo de cálculo. Recebe as informações básicas do usuário e armazena um novo cálculo no banco de dados. Retorna o ID do cálculo para ser usado nos endpoints seguintes. Para este endpoint, todos os parâmetros são obrigatórios (nome, email, número de telefone e UF).

**➜ [PUT] /open/info**

Recebe as informações necessárias para calcular a emissão de carbono do usuário (consumo de energia, transporte e produção de resíduos sólidos) e as armazena no banco de dados.

Considere `recyclePercentage` como um valor decimal de 0 a 1.0, representando a porcentagem de resíduos sólidos recicláveis.

Se este endpoint for chamado uma segunda vez para o mesmo ID, todos os seus parâmetros devem ser sobrescritos.

**➜ [GET] /open/result/{id}**

Retorna a pegada de carbono para o cálculo com o ID fornecido.

Todos esses endpoints já estão definidos na classe `OpenRestController`. Você deve implementar os métodos nessa classe.

### Lógica da calculadora

Existem fatores de emissão já salvos no banco de dados para consumo de energia (`EnergyEmissionFactor.class`), transporte (`TransportationEmissionFactor.class`) e resíduos sólidos (`SolidWasteEmissionFactor.class`). Esses fatores devem ser usados para calcular a emissão total de carbono para este usuário, de acordo com as seguintes fórmulas:

 - Consumo de Energia

    A classe `EnergyEmissionFactor` contém os fatores de emissão para cada estado brasileiro (UF). A emissão segue a fórmula:

    `Emissão de carbono = consumo de energia * fator de emissão`

 - Transporte

    A classe `TransportationEmissionFactor` contém os fatores de emissão para cada tipo de transporte. A emissão segue a fórmula:

    `Emissão de carbono = distância * fator de emissão do tipo de transporte`

 - Resíduos Sólidos

    A classe `SolidWasteEmissionFactor` contém os fatores de emissão para resíduos sólidos recicláveis e não recicláveis. A emissão segue a fórmula:

    `Emissão de carbono = produção de resíduos sólidos * fator de emissão`

### Classes já criadas

Criamos as classes para o `RestController` e os DTOs necessários para executar os endpoints. Se quiser alterá-las, por favor, mantenha os mesmos nomes de propriedades – não quebre a interface definida.

Também criamos 3 modelos básicos e suas interfaces de Repository correspondentes para os valores de emissão de carbono que você precisa usar nas implementações. Esses objetos estão pré-populados no banco de dados. Fique à vontade para adicionar mais métodos às interfaces de Repository conforme necessário.

Você provavelmente precisará criar novas classes para implementar a lógica dos endpoints e novos modelos. Organize o código como achar melhor.

## Detalhes da solução
A solução para o projeto seguiu uma abordagem modular, com cada serviço encapsulando uma responsabilidade específica. Foi aplicado os princípios S.O.L.I.D. para promover um código mais flexível e fácil de manter, enquanto o clean code garantiu que a implementação fosse clara e legível. A lógica de cálculo foi segmentada para permitir fácil expansão.

*Cálculo de Emissão de Energia*

**Lógica:** Foi multiplicado o consumo de energia informado pelo usuário com o fator de emissão específico do estado (UF). Esse fator representa a quantidade de CO₂ emitida.

Componentes Utilizados
 - **Consumo de Energia:** fornecido pelo usuário.
 - **Fator de Emissão de Energia:** obtido do banco de dados com base na UF.

*Cálculo de Emissão de Resíduos Sólidos*

**Lógica:** Foi dividida a quantidade total de resíduos em recicláveis e não recicláveis com base no percentual de reciclagem. Aplicamos fatores de emissão diferentes para cada tipo de resíduo (reciclável e não reciclável) e somamos as emissões para obter o total.

Componentes Utilizados
 - **Quantidade Total de Resíduos e Percentual de Reciclagem:** fornecidos pelo usuário.
 - **Fatores de Emissão para Resíduos Recicláveis e Não Recicláveis:** obtidos do banco de dados.

*Cálculo de Emissão de Transporte*

**Lógica:** Para cada tipo de transporte utilizado pelo usuário, é multiplicada a distância percorrida mensal pelo fator de emissão correspondente ao tipo de transporte. Somamos as emissões de cada transporte para obter o total.

Componentes Utilizados
 - **Distância Mensal e Tipo de Transporte:** fornecidos pelo usuário em uma lista.
 - **Fator de Emissão por Tipo de Transporte:** obtido do banco de dados para cada tipo de transporte.

## Como executar o projeto

**Passo 0:** Clonando o repositório
```bash
git clone https://github.com/matheus-srego/challenge_action-labs.git
```

**Passo 1:** Abrir a pasta do projeto
```bash
cd challenge_action-labs
```

**Passo 3:** Execute o Docker Compose do banco de dados

Execute docker-compose para iniciar o banco de dados MongoDB. O banco será populado com o conteúdo padrão definido no script init-mongo.js na primeira vez que for iniciado – todos os fatores de emissão padrão estão aqui. 

> **Observação:** Esses valores são apenas para este teste e não devem ser considerados valores reais de emissões de carbono.

 - **Executar o Docker Compose**
    ```bash
    docker-compose up -d
    ```

Se precisar resetar o banco de dados para o estado inicial, você pode rodar o comando abaixo que apagará o banco e repopulará os valores iniciais no próximo início.
```bash
docker-compose down -v
```

**Passo 4:** Executar a API

Você pode usar a IDE de sua preferência para executar a aplicação. A classe principal é CarbonCalculatorApplication. O servidor rodará na porta 8085 (http://localhost:8085).

Há uma documentação Swagger disponível em:
 - http://localhost:8085/swagger-ui.html.

## Licença
Este repositório é licenciado sob a [MIT Licensed](https://github.com/matheus-srego/challenge_action-labs/blob/main/LICENSE).