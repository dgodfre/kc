CREATE TABLE CARRIER_TYPE
(
   CARRIER_TYPE_CODE NUMBER(3) CONSTRAINT CARRIER_TYPE_N1 not null,
   DESCRIPTION VARCHAR2(200) CONSTRAINT CARRIER_TYPE_N2 not null,
   UPDATE_TIMESTAMP DATE CONSTRAINT CARRIER_TYPE_N3 not null,
   UPDATE_USER VARCHAR2(8) CONSTRAINT CARRIER_TYPE_N4 not null,
   VER_NBR NUMBER(8,0) DEFAULT 1 CONSTRAINT CARRIER_TYPE_N5 NOT NULL,
   OBJ_ID VARCHAR2(36) DEFAULT SYS_GUID() CONSTRAINT CARRIER_TYPE_N6 NOT NULL,
   CONSTRAINT CARRIER_TYPE_TP1 PRIMARY KEY (CARRIER_TYPE_CODE),
   CONSTRAINT CARRIER_TYPE_TC0 UNIQUE (OBJ_ID)
);