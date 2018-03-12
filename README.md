

REST WEb service URLS and the requests should be made with basic authentication set in the headers.

http://localhost:8080/SpringUnicoAssignment/rest/unico/push?param1=1&param2=2

http://localhost:8080/SpringUnicoAssignment/rest/unico/list

-------------------------------------------------------------------------------

Below tables have been created in the database as mentioned in the hibernate.cfg.xml

CREATE  TABLE Users (
  UserId INTEGER not null,
  UserName VARCHAR(45) NOT NULL ,
  Password VARCHAR(45) NOT NULL ,  
  PRIMARY KEY (UserId));
  
  INSERT INTO Users VALUES ('user1','123456');
INSERT INTO Users VALUES ('user2','123456');


CREATE TABLE InputNumbers
(
InputNumberId INTEGER not null,
InputNumber INTEGER not null,
PRIMARY KEY (InputNumberId));
)


CREATE TABLE Gcd
(
GcdId INTEGER not null,
Gcd INTEGER not null,
PRIMARY KEY (GcdId));
)

---------------------------------------------------------------------------------------------------

AciveMQ has been used for publishing and receiving messages:
QUEUE name : INPUT.QUEUE
Connection URL :tcp://localhost:4457
