CREATE TABLE NEGOTIATION_AGREEMENT_TYPE  ( 
        "NEGOTIATION_AGRMNT_TYPE_ID"	NUMBER(22) NOT NULL,
	"NEGOTIATION_AGRMNT_TYPE_CODE"	VARCHAR2(3) NOT NULL,
	"DESCRIPTION"          	VARCHAR2(30) NOT NULL,
	"UPDATE_TIMESTAMP"     	DATE NOT NULL,
	"UPDATE_USER"          	VARCHAR2(60) NOT NULL,
	"VER_NBR"              	NUMBER(8,0) NOT NULL,
	"OBJ_ID"               	VARCHAR2(36) NOT NULL,
        "ACTV_IND"		VARCHAR2(1) NOT NULL,
	CONSTRAINT "NEGOTIATION_AGREEMENT_TYPE_PK1" PRIMARY KEY("NEGOTIATION_AGRMNT_TYPE_ID"),
	CONSTRAINT "NEGOTIATION_AGREEMENT_TYPE_UK1" UNIQUE ("NEGOTIATION_AGRMNT_TYPE_CODE")	
)
/
