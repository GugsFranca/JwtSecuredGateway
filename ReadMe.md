# JwtSecuredGateway

## Descrição
JwtSecuredGateway é um exemplo de configuração de uma API completa baseada em microserviços, com a segurança gerenciada no Gateway utilizando tokens JWT. Este projeto demonstra boas práticas para criar serviços independentes com autenticação e controle de acesso.

## Estrutura do Projeto
O projeto é organizado em cinco serviços principais:

1. **auth-service**: Responsável pela autenticação e registro de usuários.
2. **user-service**: Gerencia operações relacionadas a usuários. Utiliza um banco de dados MySQL para armazenar informações dos usuários.
3. **gateway-service**: Atua como API Gateway e protege os endpoints utilizando JWT.
4. **config-service**: Centraliza as configurações de todos os serviços.
5. **discovery-service**: Gerencia a descoberta e o registro de serviços.

## Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 3.4.1**
- **MySQL**

## Endpoints Disponíveis

### Auth Service

- **POST /auth/register**: Registra um novo usuário e faz um Post em `/user/save` para savar o usuario no banco.
    - **Body**:
      ```json
      {
        "email": "string",
        "password": "string",
        "role": "string"
      }
      ```
    - **Response**:
      ```json
      {
        "token": "string"
      }
      ```

### User Service

- **POST /user/save**: Salva um novo usuário no banco.
    - **Body**:
      ```json
      {
        "email": "string",
        "password": "string",
        "role": "string"
      }
      ```
    - **Response**:
      ```json
      {
        "id": "number",
        "email": "string",
        "password": "string",
        "role": "string"
      }
      ```

- **GET /user/find**: Retorna a lista de todos os usuários.
    - **Response**:
      ```json
      [
        {
         "id": "number",
         "email": "string",
         "password": "string",
         "role": "string"
        }
      ]
      ```

#### Estrutura da Entidade `User`
A entidade `User` do `user-service` possui os seguintes campos:
- **id**: Identificador único do usuário.
- **email**: Email do usuário.
- **password**: Senha do usuário.
- **role**: Papel do usuário no sistema.

### Gateway

O `gateway-service` protege todos os endpoints, exceto:
- `/auth/register`
- `/user/save`

Os demais endpoints exigem um token JWT válido no cabeçalho **Authorization**.

Exemplo de cabeçalho:
```http
 Key: Authorization Value: <seu_token_jwt>
```

### Config Service
O `config-service` centraliza as configurações de todos os serviços e é configurado para buscar essas informações de um repositório git. Certifique-se de configurar corretamente o arquivo `application.yml` no repositório de configuração.

## Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/GugsFranca/JwtSecuredGateway
   ```

2. Certifique-se de que todas as dependências estão instaladas e que você tem o Java 21 configurado no ambiente.

3. Configure um banco de dados MySQL para o `user-service` e ajuste o arquivo `application.yml` com as credenciais do banco.

4. Inicie os serviços na seguinte ordem:
    - **config-service**
     - **discovery-service**
    - **gateway-service**
    - **auth-service**
    - **user-service**

5. Utilize uma ferramenta como Postman ou Insomnia para interagir com os endpoints.

## Contato

Se você tiver alguma dúvida ou é um recrutador interessado, sinta-se à vontade para entrar em contato!

- **E-mail**: [gustavoffonsec4@gmail.com](mailto:gustavoffonsec4@gmail.com)
- **GitHub**: [GugsFranca](https://github.com/GugsFranca)
- **LinkedIn**: [Meu LinkedIn](https://www.linkedin.com/in/gustavo-fonseca-384a91206/)

Fico à disposição para mais informações e para agendar uma conversa.


## Licença
Este projeto é apenas para fins educativos e não possui uma licença específica.
