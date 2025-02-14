# Spring Boot User API

## Descrição
Este é um projeto de API RESTful desenvolvido com Spring Boot, destinado ao gerenciamento de usuários. A API permite a criação, leitura, atualização e remoção de usuários em um banco de dados.

## Tecnologias Utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Banco de Dados H2 
- Spring Security
- Swagger

## Instalação e Execução
1. Clone o repositório:
   ```bash
   git clone https://github.com/pcfmello/springboot-user-api.git
   ```
2. Acesse o diretório do projeto:
   ```bash
   cd springboot-user-api
   ```
3. Configure o banco de dados no arquivo `application.properties`.
4. Execute o projeto com o Maven:
   ```bash
   mvn spring-boot:run
   ```

## Endpoints
A API disponibiliza os seguintes endpoints:

### Usuários
- `GET /users` - Retorna todos os usuários cadastrados.
- `GET /users/{id}` - Retorna um usuário específico por ID.
- `POST /users` - Cria um novo usuário.
- `PUT /users/{id}` - Atualiza os dados de um usuário existente.
- `DELETE /users/{id}` - Remove um usuário do sistema.

## Documentação da API
A documentação da API pode ser acessada através do Swagger:
```
http://localhost:8080/swagger-ui.html
```

## Testes
Para executar os testes automatizados, utilize:
```bash
mvn test
```

## Licença
Este projeto está sob a licença MIT.

