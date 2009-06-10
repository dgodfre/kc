delete  from protocol;

delete  from protocol_document;

commit;

insert into protocol_document (document_number, UPDATE_TIMESTAMP,UPDATE_USER) values
(1, sysdate,'kp');

insert into protocol (PROTOCOL_ID, DOCUMENT_NUMBER, PROTOCOL_NUMBER, SEQUENCE_NUMBER, PROTOCOL_STATUS_CODE, PROTOCOL_TYPE_CODE, TITLE, UPDATE_TIMESTAMP,UPDATE_USER)	values
(1000, 1, '001', 1, 101, 1, 'title', sysdate,'kp');

insert into protocol (PROTOCOL_ID, DOCUMENT_NUMBER, PROTOCOL_NUMBER, SEQUENCE_NUMBER, PROTOCOL_STATUS_CODE, PROTOCOL_TYPE_CODE, TITLE, UPDATE_TIMESTAMP,UPDATE_USER)	values
(1001, 1, '001', 2, 102, 1, 'title', sysdate,'kp');

insert into protocol (PROTOCOL_ID, DOCUMENT_NUMBER, PROTOCOL_NUMBER, SEQUENCE_NUMBER, PROTOCOL_STATUS_CODE, PROTOCOL_TYPE_CODE, TITLE, UPDATE_TIMESTAMP,UPDATE_USER)	values
(1002, 1, '001', 3, 103, 1, 'title', sysdate,'kp');

insert into protocol (PROTOCOL_ID, DOCUMENT_NUMBER, PROTOCOL_NUMBER, SEQUENCE_NUMBER, PROTOCOL_STATUS_CODE, PROTOCOL_TYPE_CODE, TITLE, UPDATE_TIMESTAMP,UPDATE_USER)	values
(1003, 1, '0012', 3, 104, 1, 'title', sysdate,'kp');

insert into protocol (PROTOCOL_ID, DOCUMENT_NUMBER, PROTOCOL_NUMBER, SEQUENCE_NUMBER, PROTOCOL_STATUS_CODE, PROTOCOL_TYPE_CODE, TITLE, UPDATE_TIMESTAMP,UPDATE_USER)	values
(1004, 1, '0012R', 3, 105, 1, 'title', sysdate,'kp');

commit;