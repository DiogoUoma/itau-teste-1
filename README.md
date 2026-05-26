# API REST de Transações e Estatísticas - Desafio Itaú

API REST desenvolvida como solução para o desafio técnico do Itaú Unibanco utilizando Java + Spring Boot.

O sistema recebe transações financeiras, armazena os dados em memória e retorna estatísticas das transações realizadas nos últimos 60 segundos.

---

# 🚀 Tecnologias utilizadas

- Java
- Spring Boot
- Maven
- Lombok
- Jakarta Validation

---

# 📌 Objetivo do desafio

O desafio consiste em criar uma API REST capaz de:

- Receber transações
- Validar dados
- Armazenar informações apenas em memória
- Limpar transações
- Retornar estatísticas das transações dos últimos 60 segundos

Sem utilizar banco de dados ou cache externo.

---

# 📂 Estrutura da API

## 1️⃣ Receber Transações

### Endpoint

```http
POST /transacao
```

### Exemplo de requisição

```json
{
  "valor": 100.50,
  "dataHora": "2026-05-26T14:30:00.000-03:00"
}
```

### Regras de validação

A transação:

- Deve possuir `valor` e `dataHora`
- Não pode possuir valor negativo
- Não pode acontecer no futuro

### Respostas

| Status | Significado |
|---|---|
| `201 Created` | Transação criada com sucesso |
| `422 Unprocessable Entity` | Dados inválidos |
| `400 Bad Request` | JSON inválido |

---

## 2️⃣ Limpar Transações

### Endpoint

```http
DELETE /transacao
```

### Resposta

| Status | Significado |
|---|---|
| `200 OK` | Todas as transações removidas |

---

## 3️⃣ Estatísticas

### Endpoint

```http
GET /estatistica
```

### Exemplo de resposta

```json
{
  "count": 3,
  "sum": 350.5,
  "avg": 116.83,
  "min": 50.0,
  "max": 200.5
}
```

As estatísticas consideram apenas transações realizadas nos últimos 60 segundos.

---

# 🧠 Conceitos aplicados

Durante o desenvolvimento foram aplicados conceitos como:

- Programação orientada a objetos
- DTOs
- Tratamento global de exceções
- Streams API
- Manipulação de listas
- Boas práticas REST
- Validações
- Separação em camadas (Controller, Service, DTO, Exception)

---

# ▶️ Como executar o projeto

## Pré-requisitos

- Java 21+ instalado
- Maven instalado

---

## Clonar o projeto

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

---

## Entrar na pasta

```bash
cd nome-do-projeto
```

---

## Executar a aplicação

Linux/Mac:

```bash
./mvnw spring-boot:run
```

Windows:

```bash
mvnw spring-boot:run
```

---

# 🧪 Testando a API

A API ficará disponível em:

```http
http://localhost:8080
```

Você pode testar utilizando:

- Postman
- Insomnia

---

# 📖 Aprendizados

Esse projeto foi importante para praticar:

- Desenvolvimento de APIs REST com Spring Boot
- Manipulação de dados em memória
- Estatísticas com Java Streams
- Tratamento de exceções
- Estruturação de projetos backend
