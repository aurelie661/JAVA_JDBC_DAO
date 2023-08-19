CREATE TABLE customer(
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(255) NOT null,
	last_name VARCHAR(255) NOT null,
	phone_number VARCHAR(20) NOT null
);

CREATE TABLE bank_account(
	id SERIAL PRIMARY KEY,
	balance DECIMAL(15,2)  NOT null,
	customer_id int,
	operation_id int,
	CONSTRAINT fk_customerId FOREIGN KEY(customer_id) REFERENCES customer(id)
);

CREATE TABLE operation(
	account_number SERIAL PRIMARY KEY,
	amount DECIMAL(15,2) NOT null,
	operation_status BOOLEAN,
	bank_accountId int,
	CONSTRAINT fk_bank_accountId FOREIGN KEY(bank_accountId) REFERENCES bank_account(id)
);