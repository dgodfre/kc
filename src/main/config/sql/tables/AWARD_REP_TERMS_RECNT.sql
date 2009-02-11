/* Table Script */ 
CREATE TABLE AWARD_REP_TERMS_RECNT (
    AWARD_REP_TERMS_RECNT_ID NUMBER(12,0) NOT NULL,
	AWARD_REPORT_TERMS_ID NUMBER(12,0) NOT NULL,
	CONTACT_ID NUMBER(12,0), 
	CONTACT_TYPE_CODE VARCHAR2(3) NOT NULL, 
	ROLODEX_ID NUMBER(6,0) NOT NULL,
	NUMBER_OF_COPIES NUMBER(2,0),
	VER_NBR NUMBER(8,0) DEFAULT 1 NOT NULL, 
	OBJ_ID VARCHAR2(36) DEFAULT SYS_GUID() NOT NULL, 
	UPDATE_TIMESTAMP DATE NOT NULL, 
	UPDATE_USER VARCHAR2(60) NOT NULL);
/* Primary Key Constraint */ 
ALTER TABLE AWARD_REP_TERMS_RECNT 
ADD CONSTRAINT PK_AWARD_REP_TERMS_RECNT
PRIMARY KEY (AWARD_REP_TERMS_RECNT_ID);
/* Foreign Key Constraint(s) */ 
ALTER TABLE AWARD_REP_TERMS_RECNT 
ADD CONSTRAINT FK1_AWARD_REP_TERMS_RECNT
FOREIGN KEY (AWARD_REPORT_TERMS_ID) 
REFERENCES AWARD_REPORT_TERMS (AWARD_REPORT_TERMS_ID);
ALTER TABLE AWARD_REP_TERMS_RECNT 
ADD CONSTRAINT FK2_AWARD_REP_TERMS_RECNT
FOREIGN KEY (CONTACT_TYPE_CODE) 
REFERENCES CONTACT_TYPE (CONTACT_TYPE_CODE);
ALTER TABLE AWARD_REP_TERMS_RECNT 
ADD CONSTRAINT FK3_AWARD_REP_TERMS_RECNT
FOREIGN KEY (ROLODEX_ID) 
REFERENCES ROLODEX (ROLODEX_ID);