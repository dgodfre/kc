drop table UNIT_FORMULATED_COST
/
CREATE TABLE UNIT_FORMULATED_COST (
	UNIT_FORMULATED_COST_ID NUMBER(12,0),
    FORMULATED_TYPE_CODE VARCHAR2(3) NOT NULL, 
    UNIT_NUMBER VARCHAR2(8) NOT NULL, 
    UNIT_COST NUMBER(12,2) NOT NULL, 
    UPDATE_TIMESTAMP DATE NOT NULL, 
    UPDATE_USER VARCHAR2(60) NOT NULL, 
    VER_NBR NUMBER(8,0) DEFAULT 1 NOT NULL, 
    OBJ_ID VARCHAR2(36) NOT NULL
)
/
ALTER TABLE UNIT_FORMULATED_COST 
ADD CONSTRAINT  PK_UNIT_FORMULATED_COST
PRIMARY KEY (UNIT_FORMULATED_COST_ID)
/
