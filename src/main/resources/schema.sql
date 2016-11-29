CREATE TABLE project ( 
  id int(11) NOT NULL AUTO_INCREMENT,
  id_category int(11) NOT NULL,
  name varchar(32) NOT NULL, 
  location varchar(32) NOT NULL, 
  description varchar(240), 
  fundingAmount float NOT NULL,
  numberOfDays int(4) NOT NULL,
  FOREIGN KEY (id_category) REFERENCES category(id),
  PRIMARY KEY (id) 
);

CREATE TABLE user ( 
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(16) NOT NULL, 
  password varchar(16) NOT NULL, 
  location varchar(32) NOT NULL, 
  biography varchar(240),
  email varchar(32) NOT NULL,
  creditLimit float NOT NULL,
  PRIMARY KEY (id) 
);

CREATE TABLE projects_owned (
  id_user int(11) NOT NULL,
  id_project int(11) NOT NULL,
  FOREIGN KEY (id_user) REFERENCES user(id),
  FOREIGN KEY (id_project) REFERENCES project(id),
  PRIMARY KEY (id_user,id_project)
);

CREATE TABLE tag (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(32) NOT NULL, 
  PRIMARY KEY (id) 
);

CREATE TABLE projects_tags (
  id_tag int(11) NOT NULL,
  id_project int(11) NOT NULL,
  FOREIGN KEY (id_tag) REFERENCES tag(id),
  FOREIGN KEY (id_project) REFERENCES project(id),
  PRIMARY KEY (id_tag,id_project)
);

CREATE TABLE category (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(32) NOT NULL, 
  description varchar(240), 
  picture varchar(32), 
  PRIMARY KEY (id) 
);

CREATE TABLE pledge (
  id int(11) NOT NULL AUTO_INCREMENT,
  id_user int(11) NOT NULL,
  id_reward int(11) NOT NULL,
  FOREIGN KEY (id_user) REFERENCES user(id),
  FOREIGN KEY (id_reward) REFERENCES reward(id),
  PRIMARY KEY(id,id_user,id_reward),
);

CREATE TABLE reward (
  id int(11) NOT NULL AUTO_INCREMENT,
  id_project id(11) NOT NULL,
  name varchar(16) NOT NULL, 
  amount double NOT NULL, 
  description varchar(240),
  estimatedDelivery Date NOT NULL,
  limitAvailability bool NOT NULL DEFAULT '0',
  FOREIGN KEY (id_project) REFERENCES project(id),
  PRIMARY KEY (id) 
);

