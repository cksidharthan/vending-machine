DROP TABLE IF EXISTS TRANSACTION;

CREATE TABLE TRANSACTION (
	ID INT AUTO_INCREMENT  PRIMARY KEY,
  	PRODUCT_ID INT NOT NULL,
  	QUANTITY INT NOT NULL,
  	MONEY_IN DECIMAL NOT NULL,
  	MONEY_OUT DECIMAL NOT NULL,
  	OPERATION_TIME TIMESTAMP NOT NULL,
  	VENDING_STATUS BOOLEAN NOT NULL
);

DROP TABLE IF EXISTS PRODUCT;

CREATE TABLE PRODUCT (
	ID INT AUTO_INCREMENT  PRIMARY KEY,
  	NAME VARCHAR(250) NOT NULL,
  	DESCRIPTION VARCHAR(300) NOT NULL,
  	PRICE DECIMAL NOT NULL,
  	CREATED_TIME TIMESTAMP NOT NULL,
  	UPDATED_TIME TIMESTAMP NOT NULL,
  	REMAINING_QTY INT NOT NULL,
  	SOLD_QTY INT NOT NULL
);


-- Dummy Values in Product Table
INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, PRICE, CREATED_TIME, UPDATED_TIME, REMAINING_QTY, SOLD_QTY) VALUES (1, 'Frooti', 'Frooti Drink', 25, {ts '2012-09-17 18:47:52.069'}, {ts '2012-09-17 18:47:52.069'}, 50, 45);
INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, PRICE, CREATED_TIME, UPDATED_TIME, REMAINING_QTY, SOLD_QTY) VALUES (2, 'Fanta', 'Fanta Drink', 25, {ts '2012-09-17 18:47:52.069'}, {ts '2012-09-17 18:47:52.069'}, 70, 45);
INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, PRICE, CREATED_TIME, UPDATED_TIME, REMAINING_QTY, SOLD_QTY) VALUES (3, 'Pepsi', 'Pepsi Drink', 25, {ts '2012-09-17 18:47:52.069'}, {ts '2012-09-17 18:47:52.069'}, 80, 45);
INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, PRICE, CREATED_TIME, UPDATED_TIME, REMAINING_QTY, SOLD_QTY) VALUES (4, 'Coke', 'Coke Drink', 25, {ts '2012-09-17 18:47:52.069'}, {ts '2012-09-17 18:47:52.069'}, 90, 45);

DROP TABLE IF EXISTS ADMIN_OPERATION;

CREATE TABLE ADMIN_OPERATION (
	ID INT AUTO_INCREMENT  PRIMARY KEY,
  	NAME VARCHAR(250) NOT NULL,
  	CODE VARCHAR(200) NOT NULL,
  	OPERATION_TIME TIMESTAMP NOT NULL
);