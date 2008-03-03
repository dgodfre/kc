
CREATE TABLE SH_PARM_DTL_TYP_T(
        SH_PARM_NMSPC_CD               VARCHAR2(20),
        SH_PARM_DTL_TYP_CD             VARCHAR2(100),
        OBJ_ID                         VARCHAR2(36) DEFAULT SYS_GUID() CONSTRAINT SH_PARM_ADDL_DTL_TYP_TN1 NOT NULL,
        VER_NBR                        NUMBER(8) DEFAULT 1 CONSTRAINT SH_PARM_ADDL_DTL_TYP_TN2 NOT NULL,
        SH_PARM_DTL_TYP_NM             VARCHAR2(255),
        ACTIVE_IND                     CHAR(1) DEFAULT 'Y' CONSTRAINT SH_PARM_ADDL_DTL_TYP_TN3 NOT NULL,
     CONSTRAINT SH_PARM_DTL_TYP_TP1 PRIMARY KEY (SH_PARM_NMSPC_CD,SH_PARM_DTL_TYP_CD),
     CONSTRAINT SH_PARM_DTL_TYP_TC0 UNIQUE (OBJ_ID)
)
/
