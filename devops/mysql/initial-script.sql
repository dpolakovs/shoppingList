CREATE SCHEMA IF NOT EXISTS shoppingList DEFAULT CHARACTER SET utf8 ;
USE shoppingList;

CREATE TABLE IF NOT EXISTS products (
                                     id BIGINT NOT NULL AUTO_INCREMENT,
                                     name VARCHAR(100) NOT NULL,
                                     description VARCHAR(100) NULL,
                                     price DECIMAL NOT NULL,
                                     category VARCHAR(100) NOT NULL,
                                     discount DECIMAL NOT NULL,

                                     created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                     PRIMARY KEY (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1002;