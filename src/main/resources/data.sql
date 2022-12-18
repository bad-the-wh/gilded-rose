DROP TABLE IF EXISTS ITEMS;

CREATE TABLE ITEMS (
                       ID VARCHAR(250) NOT NULL,
                       NAME VARCHAR(250) NOT NULL ,
                       SELLIN INTEGER NOT NULL,
                       QUALITY INTEGER NOT NULL,
                       BASE_PRICE INTEGER NOT NULL,
                       CONSTRAINT PK_ITEMS PRIMARY KEY (ID)
);

/*INSERT INTO ITEMS (NAME, SELLIN, QUALITY, BASE_PRICE) VALUES
                                                          ('Generic', 5, 8, 10),
                                                          ('Generic', 0, 8, 10),
                                                          ('Generic', 5, 0, 10);*/