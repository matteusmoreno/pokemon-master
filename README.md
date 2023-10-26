# Pokemon Master - Aplicação de Gerenciamento de Pokémons

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.5-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8.0-orange)
![Flyway](https://img.shields.io/badge/Flyway-7.0.4-yellow)
![Lombok](https://img.shields.io/badge/Lombok-1.18.22-green)

Bem-vindo ao Pokemon Master, uma aplicação de gerenciamento de Pokémons onde você pode criar e controlar treinadores de Pokémon e seus Pokémon. Esta aplicação é construída com Java, Spring Boot, MySQL, Flyway e Lombok.

![Pikachu](https://seeklogo.com/images/P/Pikachu-logo-D0AAA93F17-seeklogo.com.png)

## Funcionalidades

- Crie, atualize, desative e ative Pokémon.
- Associe Pokémon a treinadores (PokemonMaster).
- Crie, atualize, desative e ative treinadores de Pokémon.
- Consulte detalhes de Pokémon por ID ou nome.
- Consulte detalhes de treinadores de Pokémon por ID.
- E muito mais!

## Configuração

1. Certifique-se de ter o Java 17 e o MySQL 8.0 instalados em seu sistema.
2. Clone este repositório.
3. Configure as propriedades do banco de dados no arquivo `src/main/resources/application.properties`.
4. Certifique-se de que o MySQL esteja em execução.
5. Execute o aplicativo usando o Spring Boot.

## Uso

Após configurar e executar o aplicativo, você pode interagir com ele por meio de uma API REST. Aqui estão alguns exemplos de endpoints:

- `POST /pokemons/create`: Crie um novo Pokémon.
- `GET /pokemons/detailsbyid/{id}`: Obtenha detalhes de um Pokémon por ID.
- `PUT /pokemons/update`: Atualize um Pokémon.
- `PUT /pokemons/disable/{id}`: Desative um Pokémon.
- `PUT /pokemons/active/{id}`: Ative um Pokémon.
- `POST /pokemon-master/create`: Crie um novo treinador de Pokémon.
- `GET /pokemon-master/details/{id}`: Obtenha detalhes de um treinador de Pokémon por ID.
- `PUT /pokemon-master/update`: Atualize um treinador de Pokémon.
- `PUT /pokemon-master/disable/{id}`: Desative um treinador de Pokémon.
- `PUT /pokemon-master/active/{id}`: Ative um treinador de Pokémon.
- `PUT /pokemon-master/add-pokemon`: Associe um Pokémon a um treinador de Pokémon.

Certifique-se de verificar a documentação da API para obter mais detalhes sobre os endpoints disponíveis.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir problemas e solicitações pull.


---

Desenvolvido por [Matteus Moreno](https://github.com/matteusmoreno)


