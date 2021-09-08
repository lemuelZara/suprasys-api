#!/bin/bash

set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
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
EOSQL