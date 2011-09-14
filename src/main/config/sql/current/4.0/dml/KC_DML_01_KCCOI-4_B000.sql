INSERT INTO FIN_INT_ENTITY_STATUS ( STATUS_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 1, 'Active', sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_INT_ENTITY_STATUS ( STATUS_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 2, 'Inactive', sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_INT_ENTITY_REL_TYPE ( RELATIONSHIP_TYPE_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 1, 'Self', sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_INT_ENTITY_REL_TYPE ( RELATIONSHIP_TYPE_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 2, 'Spouse', sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_INT_ENTITY_REL_TYPE ( RELATIONSHIP_TYPE_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 3, 'Children', sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_INT_ENTITY_REL_TYPE ( RELATIONSHIP_TYPE_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 4, 'Student', sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_INT_ENTITY_REL_TYPE ( RELATIONSHIP_TYPE_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 5, 'Other', sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_GROUPS ( DATA_GROUP_ID, DATA_GROUP_NAME, DATA_GROUP_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 1, 'Ownership Interests', 1, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_GROUPS ( DATA_GROUP_ID, DATA_GROUP_NAME, DATA_GROUP_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 2, 'Remunerative Activities', 3, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_GROUPS ( DATA_GROUP_ID, DATA_GROUP_NAME, DATA_GROUP_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 3, 'Outside Employment of Students', 4, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_GROUPS ( DATA_GROUP_ID, DATA_GROUP_NAME, DATA_GROUP_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 4, 'Creator of Intellectual prop.', 5, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_GROUPS ( DATA_GROUP_ID, DATA_GROUP_NAME, DATA_GROUP_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 5, 'Other Transactions or Facts', 6, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_GROUPS ( DATA_GROUP_ID, DATA_GROUP_NAME, DATA_GROUP_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 6, 'Offices & Positions', 2, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_MATRIX ( COLUMN_NAME, COLUMN_LABEL, GUI_TYPE, LOOKUP_ARGUMENT, DATA_GROUP_ID, STATUS_FLAG, COLUMN_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 'OWNERSHIP_INTEREST', 'Ownership Interests', 'DROPDOWN', 'ownership_interest', 1, 'A', 1, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_MATRIX ( COLUMN_NAME, COLUMN_LABEL, GUI_TYPE, LOOKUP_ARGUMENT, DATA_GROUP_ID, STATUS_FLAG, COLUMN_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 'CONSULTANT', 'Consulting Service', 'DROPDOWN', 'age_range', 6, 'I', 6, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_MATRIX ( COLUMN_NAME, COLUMN_LABEL, GUI_TYPE, LOOKUP_ARGUMENT, DATA_GROUP_ID, STATUS_FLAG, COLUMN_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 'DIRECTOR', 'Director', 'CHECKBOX', NULL, 6, 'I', 1, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_MATRIX ( COLUMN_NAME, COLUMN_LABEL, GUI_TYPE, LOOKUP_ARGUMENT, DATA_GROUP_ID, STATUS_FLAG, COLUMN_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 'PARTNER', 'Partner', 'CHECKBOX', NULL, 6, 'A', 2, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_MATRIX ( COLUMN_NAME, COLUMN_LABEL, GUI_TYPE, LOOKUP_ARGUMENT, DATA_GROUP_ID, STATUS_FLAG, COLUMN_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 'EMPLOYEE', 'Employee', 'CHECKBOX', NULL, 6, 'A', 3, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_MATRIX ( COLUMN_NAME, COLUMN_LABEL, GUI_TYPE, LOOKUP_ARGUMENT, DATA_GROUP_ID, STATUS_FLAG, COLUMN_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 'AGENT', 'Agent', 'CHECKBOX', NULL, 6, 'A', 4, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_MATRIX ( COLUMN_NAME, COLUMN_LABEL, GUI_TYPE, LOOKUP_ARGUMENT, DATA_GROUP_ID, STATUS_FLAG, COLUMN_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 'OTHER_MNG_POSITION', 'Other Managerial Positions', 'CHECKBOX', NULL, 6, 'A', 5, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_MATRIX ( COLUMN_NAME, COLUMN_LABEL, GUI_TYPE, LOOKUP_ARGUMENT, DATA_GROUP_ID, STATUS_FLAG, COLUMN_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 'COMPENSATION_SERVICES', 'Compensation for Services', 'DROPDOWN', 'remuneration_range', 2, 'A', 1, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_MATRIX ( COLUMN_NAME, COLUMN_LABEL, GUI_TYPE, LOOKUP_ARGUMENT, DATA_GROUP_ID, STATUS_FLAG, COLUMN_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 'IN_KIND_PAYMENTS', 'In Kind Payments', 'DROPDOWN', 'remuneration_range', 2, 'I', 2, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_MATRIX ( COLUMN_NAME, COLUMN_LABEL, GUI_TYPE, LOOKUP_ARGUMENT, DATA_GROUP_ID, STATUS_FLAG, COLUMN_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 'OUTSIDE_EMP_STUDENTS_STAFF', 'Outside Employment of Students', 'CHECKBOX', NULL, 3, 'A', 1, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_MATRIX ( COLUMN_NAME, COLUMN_LABEL, GUI_TYPE, LOOKUP_ARGUMENT, DATA_GROUP_ID, STATUS_FLAG, COLUMN_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 'ROYALTY', 'Royalty Income', 'DROPDOWN', 'remuneration_range', 4, 'A', 1, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_MATRIX ( COLUMN_NAME, COLUMN_LABEL, GUI_TYPE, LOOKUP_ARGUMENT, DATA_GROUP_ID, STATUS_FLAG, COLUMN_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 'FUTURE_INCOME', 'Right to Recieve Future Income', 'CHECKBOX', NULL, 4, 'A', 2, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_MATRIX ( COLUMN_NAME, COLUMN_LABEL, GUI_TYPE, LOOKUP_ARGUMENT, DATA_GROUP_ID, STATUS_FLAG, COLUMN_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 'INTELLECTUAL_PROPERTY', 'Intellectual Property Rights', 'DROPDOWN', 'remuneration_range', 4, 'A', 3, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_MATRIX ( COLUMN_NAME, COLUMN_LABEL, GUI_TYPE, LOOKUP_ARGUMENT, DATA_GROUP_ID, STATUS_FLAG, COLUMN_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 'CONTRACT', 'Contract', 'DROPDOWN', 'remuneration_range', 5, 'A', 1, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_MATRIX ( COLUMN_NAME, COLUMN_LABEL, GUI_TYPE, LOOKUP_ARGUMENT, DATA_GROUP_ID, STATUS_FLAG, COLUMN_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 'SALE', 'Sale', 'DROPDOWN', 'remuneration_range', 5, 'A', 2, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_MATRIX ( COLUMN_NAME, COLUMN_LABEL, GUI_TYPE, LOOKUP_ARGUMENT, DATA_GROUP_ID, STATUS_FLAG, COLUMN_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 'OTHER_TRANSACTION', 'Other Transactions', 'DROPDOWN', 'remuneration_range', 5, 'A', 3, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_MATRIX ( COLUMN_NAME, COLUMN_LABEL, GUI_TYPE, LOOKUP_ARGUMENT, DATA_GROUP_ID, STATUS_FLAG, COLUMN_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 'OTHER_COI', 'Other Conflict Of Interests', 'DROPDOWN', 'remuneration_range', 5, 'A', 4, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO FIN_ENTITIES_DATA_MATRIX ( COLUMN_NAME, COLUMN_LABEL, GUI_TYPE, LOOKUP_ARGUMENT, DATA_GROUP_ID, STATUS_FLAG, COLUMN_SORT_ID, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES ( 'GIFTS_FUNDS', 'Gift/Funds available to the Re', 'DROPDOWN', 'remuneration_range', 5, 'A', 5, sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO ARG_VALUE_LOOKUP ( ARG_VALUE_LOOKUP_ID, ARGUMENT_NAME, VALUE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES (524, 'ownership_interest', '1', '5 - 25%', sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO ARG_VALUE_LOOKUP ( ARG_VALUE_LOOKUP_ID, ARGUMENT_NAME, VALUE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES (525, 'ownership_interest', '2', '26 - 50%', sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO ARG_VALUE_LOOKUP ( ARG_VALUE_LOOKUP_ID, ARGUMENT_NAME, VALUE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES (526, 'ownership_interest', '3', '51 - 75%', sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO ARG_VALUE_LOOKUP ( ARG_VALUE_LOOKUP_ID, ARGUMENT_NAME, VALUE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES (527, 'ownership_interest', '4', '76 - 100%', sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO ARG_VALUE_LOOKUP ( ARG_VALUE_LOOKUP_ID, ARGUMENT_NAME, VALUE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES (528, 'remuneration_range', '1', '10 - 50K', sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO ARG_VALUE_LOOKUP ( ARG_VALUE_LOOKUP_ID, ARGUMENT_NAME, VALUE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES (529, 'remuneration_range', '2', '51 - 100K', sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO ARG_VALUE_LOOKUP ( ARG_VALUE_LOOKUP_ID, ARGUMENT_NAME, VALUE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES (530, 'remuneration_range', '3', 'Over 100K', sysdate, 'admin',  SYS_GUID() )
/
INSERT INTO ARG_VALUE_LOOKUP ( ARG_VALUE_LOOKUP_ID, ARGUMENT_NAME, VALUE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID ) 
VALUES (531, 'remuneration_range', '4', '100 - 200K', sysdate, 'admin',  SYS_GUID() )
/
