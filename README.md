# API de Produtos

API REST desenvolvida com Java e Spring Boot para gerenciamento de produtos.

O projeto permite cadastrar, consultar, atualizar e excluir produtos, utilizando MySQL para armazenamento persistente dos dados.

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Bean Validation
- Docker
- Docker Compose
- Maven

## Funcionalidades

- Cadastro de produtos.
- Listagem de produtos.
- Consulta de produto por ID.
- Atualização de produtos.
- Exclusão de produtos.
- Validação dos dados recebidos.
- Tratamento de exceções e respostas HTTP adequadas.

## Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| POST | "/produtos" | Cadastrar produto |
| GET | "/produtos" | Listar produtos |
| GET | "/produtos/{id}" | Consultar produto por ID |
| PUT | "/produtos/{id}" | Atualizar produto |
| DELETE | "/produtos/{id}" | Excluir produto |

## Códigos HTTP

| Código | Descrição |
|---|---|
| 200 | OK |
| 201 | Created |
| 204 | No Content |
| 400 | Bad Request |
| 404 | Not Found |

## Exemplo de cadastro

**Requisição POST — "/produtos"

```json
{
  "nome": "Mesa de escritório",
  "preco": 850.00,
  "descricao": "Mesa de escritório em MDF",
  "quantidade": 10
}
```

## Como executar o projeto com Docker

### Pré-requisitos

- Git
- Docker Desktop

### 1. Clonar o repositório

```bash
git clone URL_DO_REPOSITORIO
```

### 2. Acessar a pasta do projeto

```bash
cd produtos-api
```

### 3. Configurar as variáveis de ambiente

Crie um arquivo `.env` na raiz do projeto, seguindo o modelo abaixo:

```env
DB_URL_LOCAL=jdbc:mysql://localhost:3308/api_produtos
DB_URL_DOCKER=jdbc:mysql://mysql:3306/api_produtos

MYSQL_DATABASE=api_produtos
MYSQL_USER=api_produtos_user
MYSQL_PASSWORD=sua_senha
MYSQL_ROOT_PASSWORD=sua_senha_root
```

Substitua os valores de senha pelos valores definidos na sua configuração local.

**Importante:** o arquivo `.env` contém informações privadas e não deve ser enviado ao GitHub.

### 4. Construir e iniciar os containers

```bash
docker compose up -d --build
```

### 5. Acessar a API

Após a inicialização, a aplicação estará disponível em:

```text
http://localhost:8080
```

### 6. Encerrar os containers

```bash
docker compose down
```

## Estrutura do projeto

```text
produtos-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/com/barbosaDev/produtos_api/
│   │   │       ├── controllers/
│   │   │       ├── dtos/
│   │   │       ├── entities/
│   │   │       ├── exceptions/
│   │   │       ├── repositories/
│   │   │       └── services/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── .env
├── .gitignore
├── compose.yaml
├── Dockerfile
└── pom.xml
```

## Banco de dados

O projeto utiliza MySQL para persistência dos dados.

A comunicação com o banco ocorre de maneira diferente dependendo do ambiente:

- **Execução local:** a aplicação acessa o MySQL pela porta `3308`.
- **Execução com Docker:** a aplicação acessa o serviço MySQL pela porta interna `3306`, utilizando o nome do serviço `mysql`.

