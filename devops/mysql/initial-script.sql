CREATE SCHEMA IF NOT EXISTS shoppingList DEFAULT CHARACTER SET utf8 ;
USE shoppingList;

CREATE TABLE IF NOT EXISTS products (
                                        id BIGINT NOT NULL AUTO_INCREMENT,
                                        name VARCHAR(100) NOT NULL,
                                        description VARCHAR(100) NULL,
                                        price DECIMAL NOT NULL,
                                        category VARCHAR(100) NOT NULL,
                                        discount DECIMAL NOT NULL,
                                        user_id BIGINT NULL,
                                        created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                        PRIMARY KEY (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1002;

CREATE TABLE IF NOT EXISTS shoppingCarts (
                                             id BIGINT NOT NULL AUTO_INCREMENT,
                                             login VARCHAR(100) NOT NULL,
                                             password VARCHAR(100) NOT NULL,
                                             created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                             PRIMARY KEY (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1002;

ALTER TABLE products ADD CONSTRAINT shoppingCarts_products_fk FOREIGN KEY (shoppingCart_id) REFERENCES shoppingCarts(id)