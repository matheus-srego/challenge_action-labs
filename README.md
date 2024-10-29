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

[➜ Leia-me em Português](tools/readme/README.pt-BR.md)

</div>


## Table of Contents

 - [Stack](#stack)
 - [Project tree](#project-tree)
 - [Description](#description)
    - [Calculator logic](#lcalculator-logic)
    - [Classes already created](#classess-already-created)
 - [Solution details](#solution-details)
 - [How to run the project](#how-to-run-the-project)
 - [License](#license)
 - [Acknowledgment](#acknowledgment)

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
    <summary><h2 id="project-tree">Project tree</h2></summary>

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

## Description

Create the backend for a carbon calculator, using Java, Spring Boot and MongoDB.

**➜ [POST] /open/start-calc**

Starts the calculation process. Receives the user basic info and stores a new calculation in the database. Returns the calculation's ID to be used in the following endpoints. For this endpoint, every parameter is mandatory (name, email, phoneNumber and UF).

**➜ [PUT] /open/info**

Receives information needed to calculate the user's carbon emission (energy consumption, transportation and solid waste production) and stores it in the database.

Please consider `recyclePercentage` as a double from 0 to 1.0, representing the percentage of recyclable solid waste.

If this endpoint is called a second time for the same ID, all its parameters must be overwritten.

**➜ [GET] /open/result/{id}**

Returns the carbon footprint for the calculation with the given ID.

All these endpoints are already defined in the class `OpenRestController`. You should implement the methods in this class.

### Calculator logic

There are emission factors already saved in the database for energy consumption (EnergyEmissionFactor.class), transportation (TransportationEmissionFactor.class) and solid waste (SolidWasteEmissionFactor.class). These factors must be used to calculate the full carbon emission for this user, according to the following formulas:

 - Energy consumption

    The class `EnergyEmissionFactor` contains the emission factors for each brazilian state (UF). The emission follows the formula:

    `Carbon emission = energy consumption * emission factor`

 - Transportation

    The class `TransportationEmissionFactor` contains the emission factors for each type of transportation. The emission follows the formula:

    `Carbon emission = distance * transportation type emission factor`

 - Solid waste

    The class `SolidWasteEmissionFactor` contains the emission factors for recyclable and non-recyclable solid waste. The emission follows the formula:

    `Carbon emission = solid waste production * emission factor`

### Classes already created

We created the classes for the `RestController` and the DTOs needed to execute its endpoints. If you want to change them, please keep the same property names - don't break the defined interface.

We also created 3 basic models and their corresponding Repository interfaces for the carbon emission values that you need to use in your implementations. These are the objects pre-populated in the database. Feel free to add more methods to the *Repository interfaces as needed.

You will certainly need to create new classes to implement the logic for the endpoints and new models. Feel free to organize the code as you see fit.

There are a few implemented classes to check the application's health, security and swagger configs and so on. There's probably no need to modify them, but if you think it's necessary, go ahead.

### Solution details

The project’s solution followed a modular approach, with each service encapsulating a specific responsibility. The S.O.L.I.D. principles were applied to promote flexible and maintainable code, while clean code practices ensured that the implementation was clear and readable. The calculation logic was segmented to allow for easy expansion.

*Energy Emission Calculation*

**Logic:** The user-provided energy consumption was multiplied by the specific emission factor for the state (UF). This factor represents the amount of CO₂ emitted.

Used Components
 - **Energy Consumption:** provided by the user.
 - **Energy Emission Factor:** obtained from the database based on the UF.

*Solid Waste Emission Calculation*

**Logic:** The total waste amount was split into recyclable and non-recyclable portions based on the recycling percentage. Different emission factors were applied for each type of waste (recyclable and non-recyclable), and emissions were summed to obtain the total.

Used Components
 - **Total Waste Amount and Recycling Percentage:** provided by the user.
 - **Emission Factors for Recyclable and Non-Recyclable Waste:** obtained from the database.

*Transportation Emission Calculation*

**Logic:** For each type of transportation used by the user, the monthly distance was multiplied by the corresponding emission factor for that transportation type. Emissions for each transport type were summed to get the total.

Used Components
- **Monthly Distance and Transportation Type:** provided by the user in a list.
- **Emission Factor per Transportation Type:** obtained from the database for each transport type.

## How to run the project

**Step 0:** Clone the repository
```bash
git clone https://github.com/matheus-srego/challenge_action-labs.git
```

**Step 1:** Open the project folder
```bash
cd challenge_action-labs
```

Step 3: Run Docker Compose for the database

Run Docker Compose to start the MongoDB database. The database will be populated with the default content defined in the init-mongo.js script the first time it is started – all default emission factors are included here.

> **Note:** These values are for testing only and should not be considered real carbon emission values.

 - Run Docker Compose
    ```bash
    docker-compose up -d
    ```

If you need to reset the database to its initial state, you can run the command below, which will erase the database and repopulate it with the initial values upon the next start.
```bash
docker-compose down -v
```

**Step 4:** Run the API

You can use your preferred IDE to run the application. The main class is CarbonCalculatorApplication. The server will run on port 8085 (http://localhost:8085).

Swagger documentation is available at:
 - http://localhost:8085/swagger-ui.html.

## License
This repository is licensed under the [MIT Licensed](https://github.com/matheus-srego/challenge_action-labs/blob/main/LICENSE).

### Acknowledgment

I used partially ChatGPT to assist me in improving the translation of this README to English.
