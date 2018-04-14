-- create table action
-- assigned this is like (1 - photo, 2 - comments, 3 - user)
-- assigned_id, if assigned = 1, assigned id this is id from photo table

CREATE TABLE socialnetwork.action (
  id INT(255) NOT NULL AUTO_INCREMENT,
  assigned INT(11) NOT NULL,
  author_id INT(255) NOT NULL,
  assigned_id INT(255) NOT NULL,
  status_id INT(255) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

-- create table comments

CREATE TABLE socialnetwork.comments (
  id INT(255) NOT NULL AUTO_INCREMENT,
  data_comment VARCHAR(255) DEFAULT NULL,
  author_id INT(255) DEFAULT NULL,
  photo_id INT(255) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

-- create table photo

CREATE TABLE socialnetwork.photo (
  id INT(255) NOT NULL AUTO_INCREMENT,
  name_id VARCHAR(255) DEFAULT NULL,
  author_id INT(255) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

-- create table user

CREATE TABLE socialnetwork.user (
  id INT(255) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;
