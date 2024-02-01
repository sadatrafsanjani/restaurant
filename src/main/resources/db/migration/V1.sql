CREATE TABLE cbzovbff.public.customers (
    ID SERIAL PRIMARY KEY,
    CUSTOMER_NAME VARCHAR(255) NOT NULL
);

CREATE TABLE cbzovbff.public.foods (
    ID SERIAL PRIMARY KEY,
    TITLE VARCHAR(255) NOT NULL,
    PRICE REAL
);

CREATE TABLE cbzovbff.public.orders (
    ID SERIAL PRIMARY KEY,
    CUSTOMER_ID INTEGER,
    ORDERED_ON DATE
);

CREATE TABLE cbzovbff.public.order_details (
    ID SERIAL PRIMARY KEY,
    ORDER_ID INTEGER,
    FOOD_ID INTEGER,
    QUANTITY INTEGER,
    UNIT_PRICE REAL,
    TOTAL REAL
);