CREATE DATABASE alevel_shop;

-- создаем таблицу order

CREATE TABLE alevel_shop.`order` (
  id INT(11) NOT NULL AUTO_INCREMENT,
  date DATETIME DEFAULT NULL,
  user_id INT(11) DEFAULT NULL,
  status_id INT(11) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

ALTER TABLE alevel_shop.`order` 
  ADD UNIQUE INDEX UK_order_status_id(status_id);

ALTER TABLE alevel_shop.`order` 
  ADD CONSTRAINT FK_order_id FOREIGN KEY (id)
    REFERENCES alevel_shop.order_position(order_id) ON DELETE NO ACTION;

ALTER TABLE alevel_shop.`order` 
  ADD CONSTRAINT FK_order_user_id FOREIGN KEY (user_id)
    REFERENCES alevel_shop.user(id) ON DELETE NO ACTION;

-- создаем таблицу order_position

CREATE TABLE alevel_shop.order_position (
  order_id INT(11) NOT NULL AUTO_INCREMENT,
  position_id INT(11) DEFAULT NULL,
  quantity SMALLINT(6) DEFAULT NULL,
  PRIMARY KEY (order_id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

ALTER TABLE alevel_shop.order_position 
  ADD CONSTRAINT FK_order_position_position_id FOREIGN KEY (position_id)
    REFERENCES alevel_shop.`position`(id) ON DELETE NO ACTION;

-- создаем таблицу position

CREATE TABLE alevel_shop.`position` (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) DEFAULT NULL,
  price DECIMAL(19, 2) DEFAULT NULL,
  quantity SMALLINT(10) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

-- создаем таблицу status

CREATE TABLE alevel_shop.status (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

ALTER TABLE alevel_shop.status 
  ADD CONSTRAINT FK_status_id FOREIGN KEY (id)
    REFERENCES alevel_shop.`order`(status_id) ON DELETE NO ACTION;

-- создаем таблицу user

CREATE TABLE alevel_shop.user (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) DEFAULT NULL,
  email VARCHAR(50) DEFAULT NULL,
  passhash VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;