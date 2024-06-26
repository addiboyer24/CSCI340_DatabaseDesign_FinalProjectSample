CREATE TABLE UNIVERSITY.HEIGHTRESTRICTION
(
	Id INT CONSTRAINT FK_HEIGHTRESTRICTION_ID FOREIGN KEY(Id) REFERENCES UNIVERSITY.RESTRICTION(Id) CONSTRAINT PK_HEIGHTRESTRICTION_ID PRIMARY KEY,
	MinHeight INTEGER NOT NULL CONSTRAINT CK_HEIGHTRESTRICTION_MINHEIGHT CHECK (MinHeight > 0)
);

-- DROP TABLE UNIVERSITY.HEIGHTRESTRICTION;