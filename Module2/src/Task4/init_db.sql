-- create table action
-- assigned this is like (1 - photo, 2 - comments, 3 - user)
-- assigned_id, if assigned = 1, assigned id this is id from photo table
-- status_id (1 - like, 0 - hide like) 

CREATE TABLE socialnetwork.action (
  id INT(255) NOT NULL AUTO_INCREMENT,
  assigned INT(11) NOT NULL,
  status_id INT(11) NOT NULL,
  author_id INT(255) NOT NULL,
  assigned_id INT(255) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

ALTER TABLE socialnetwork.action 
  ADD CONSTRAINT FK_action_author_id FOREIGN KEY (author_id)
    REFERENCES socialnetwork.user(id) ON DELETE NO ACTION;

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

ALTER TABLE socialnetwork.comments 
  ADD CONSTRAINT FK_comments_author_id FOREIGN KEY (author_id)
    REFERENCES socialnetwork.user(id) ON DELETE NO ACTION;

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

ALTER TABLE socialnetwork.photo 
  ADD UNIQUE INDEX UK_photo_author_id(author_id);

-- create table user

CREATE TABLE socialnetwork.user (
  id INT(255) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

ALTER TABLE socialnetwork.user 
  ADD CONSTRAINT FK_user_id FOREIGN KEY (id)
    REFERENCES socialnetwork.photo(author_id) ON DELETE NO ACTION;