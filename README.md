<h1 align="center">SupraSys REST API</h1>

<p align="center">
  <img alt="Java Logo" src="https://img.shields.io/badge/Java-11-00143c?logo=java&labelColor=fff&logoColor=red">&nbsp;&nbsp;
  <img alt="Java Logo" src="https://img.shields.io/badge/Spring%20Boot-2.5.4-00143c?logo=spring&labelColor=fff&logoColor=green">&nbsp;&nbsp;
  <img alt="Docker Logo" src="https://img.shields.io/badge/Docker & Docker Compose-🛠-00143c?logo=docker&labelColor=fff">&nbsp;&nbsp;
</p>

<p align="center">Construção de uma API REST feita com Java Spring Boot, PostgreSQL e Docker para processo de recrutamento para a empresa SupraSys.</p>

<br>

## Banco de dados

A implementação do banco de dados foi feita da seguinte forma (arquivo `postgres-init.sh`):
```sql
  CREATE TABLE clients(
    id SERIAL NOT NULL,
    name VARCHAR(100) NOT NULL,
    login VARCHAR(20) NOT NULL,
    password VARCHAR(100) NOT NULL,
    state INTEGER NOT NULL,
        
    CONSTRAINT pk_users PRIMARY KEY(id)
  );

  CREATE TABLE products(
    id SERIAL NOT NULL,
    name VARCHAR(100) NOT NULL,
    stock INTEGER NOT NULL,
    value NUMERIC(10,2) NOT NULL,
    discount NUMERIC(10,2) NOT NULL,

    CONSTRAINT pk_products PRIMARY KEY(id)
  );

  CREATE TABLE sales(
    id SERIAL NOT NULL,
    date DATE NOT NULL,
    value NUMERIC(10,2) NOT NULL,
    discount NUMERIC(10,2) NOT NULL,
    total NUMERIC(10,2) NOT NULL,
    client_id INTEGER NOT NULL,

    CONSTRAINT pk_sales PRIMARY KEY(id),
    CONSTRAINT fk_sales_clients FOREIGN KEY(client_id) REFERENCES clients(id)
  );

  CREATE TABLE sales_products(
    id SERIAL NOT NULL,
    amount INTEGER NOT NULL,
    value NUMERIC(10,2) NOT NULL,
    discount NUMERIC(10,2) NOT NULL,
    total NUMERIC(10,2) NOT NULL,
    sale_id INTEGER NOT NULL,
    product_id INTEGER NOT NULL,

    CONSTRAINT pk_sales_products PRIMARY KEY(id),
    CONSTRAINT fk_sp_sales FOREIGN KEY(sale_id) REFERENCES sales(id),
    CONSTRAINT fk_sp_products FOREIGN KEY(product_id) REFERENCES products(id)
  );
```

<br>

## Rotas da aplicação

### Clients 👨‍👧‍👧

#### Create client

`POST http://localhost:8080/api/v1/clients HTTP/1.1`
```json
// Request

{
	"name": "Lemuel",
	"login": "lemuel",
	"password": "abc123",
	"state": 1
}
```

#### Get all clients

`GET http://localhost:8080/api/v1/clients HTTP/1.1`
```json
// Response

[
  {
    "id": 1,
    "name": "Lemuel",
    "login": "lemuel",
    "state": 1
  },
  {
    "id": 2,
    "name": "João",
    "login": "joao",
    "state": 2
  }
]
```

#### Get client by id

`GET http://localhost:8080/api/v1/clients/{id} HTTP/1.1`
```json
// Response

{
  "id": 1,
  "name": "Lemuel",
  "login": "lemuel",
  "state": 1
}
```

#### Update client

`PUT http://localhost:8080/api/v1/clients/{id} HTTP/1.1`
```json
// Request

{
	"name": "Lemuel Coelho Zara",
	"login": "lemuelczara",
	"password": "hhjs293",
	"state": 2
}
```

#### Delete client

`DELETE http://localhost:8080/api/v1/clients/{id} HTTP/1.1`

<br>

### Products 🧴

#### Create product

`POST http://localhost:8080/api/v1/products HTTP/1.1`
```json
// Request

{
	"name": "Arroz",
	"stock": 10,
	"value": 17.80,
	"discount": 1.20
}
```

#### Get all products

`GET http://localhost:8080/api/v1/products HTTP/1.1`
```json
// Response

[
  {
    "name": "Arroz",
    "stock": 10,
    "value": 17.80,
    "discount": 1.20
  },
  {
    "name": "Sabonete",
    "stock": 13,
    "value": 1.35,
    "discount": 0
  }
]
```

#### Get product by id

`GET http://localhost:8080/api/v1/products/{id} HTTP/1.1`
```json
// Response

{
  "name": "Arroz",
  "stock": 10,
  "value": 17.80,
  "discount": 1.20
}
```

#### Update product

`PUT http://localhost:8080/api/v1/products/{id} HTTP/1.1`
```json
// Request

{
  "name": "Arroz",
  "stock": 100,
  "value": 19.20,
  "discount": 1
}
```

#### Delete product

`DELETE http://localhost:8080/api/v1/products/{id} HTTP/1.1`

<br>

### Sales 💱

#### Create sale

`POST http://localhost:8080/api/v1/sales HTTP/1.1`

Obs: adicionar no Header da requisição a propriedade `clientId` para vincular a venda a um cliente.
```json
// Request

{
	"date": "2021-09-17",
	"value": 999,
	"discount": 999,
	"total": 999,
	"itens": [
		{
			"amount": 5,
			"value": 5,
			"discount": 5,
			"total": 5,
			"product": {
				"id": 1
			}
		},
		{
			"amount": 6,
			"value": 6,
			"discount": 6,
			"total": 6,
			"product": {
				"id": 2
			}
		}
	]
}
```

#### Get all sales

`GET http://localhost:8080/api/v1/sales HTTP/1.1`
```json
// Response

[
  {
    "id": 1,
    "date": "2021-09-17",
    "value": 999.0,
    "discount": 999.0,
    "total": 999.0,
    "itens": [
      {
        "id": 1,
        "amount": 5,
        "value": 5.0,
        "discount": 5.0,
        "total": 5.0,
        "product": {
          "id": 1,
          "name": "Arroz",
          "stock": 10,
          "value": 5.5,
          "discount": 0.0
        }
      },
      {
        "id": 2,
        "amount": 6,
        "value": 6.0,
        "discount": 6.0,
        "total": 6.0,
        "product": {
          "id": 2,
          "name": "Sabonete",
          "stock": 10,
          "value": 5.5,
          "discount": 0.0
        }
      }
    ]
  }
]
```

#### Get sale by id

`GET http://localhost:8080/api/v1/sales/{id} HTTP/1.1`
```json
// Response

{
  "id": 1,
  "date": "2021-09-17",
  "value": 999.0,
  "discount": 999.0,
  "total": 999.0,
  "itens": [
    {
      "id": 1,
      "amount": 5,
      "value": 5.0,
      "discount": 5.0,
      "total": 5.0,
      "product": {
        "id": 1,
        "name": "Arroz",
        "stock": 10,
        "value": 5.5,
        "discount": 0.0
      }
    },
    {
      "id": 2,
      "amount": 6,
      "value": 6.0,
      "discount": 6.0,
      "total": 6.0,
      "product": {
        "id": 2,
        "name": "Sabonete",
        "stock": 10,
        "value": 5.5,
        "discount": 0.0
      }
    }
  ]
}
```

#### Delete sale

`DELETE http://localhost:8080/api/v1/sales/{id} HTTP/1.1`