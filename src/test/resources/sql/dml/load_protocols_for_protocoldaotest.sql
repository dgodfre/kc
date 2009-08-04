delete from PROTOCOL_PERSONS where PROTOCOL_id=201;
delete from PROTOCOL_RESEARCH_AREAS where PROTOCOL_id=201;
delete from PROTOCOL_FUNDING_SOURCE where PROTOCOL_id=201;
delete from PROTOCOL_LOCATION where PROTOCOL_id=201;
delete from PROTOCOL where PROTOCOL_id=201;
delete from PROTOCOL_DOCUMENT where DOCUMENT_NUMBER=9999;

insert into protocol_document(DOCUMENT_NUMBER,VER_NBR, OBJ_ID,UPDATE_TIMESTAMP,UPDATE_USER)    
   values (9999,1,2,sysdate,user);     

insert into protocol (PROTOCOL_ID ,DOCUMENT_NUMBER , PROTOCOL_NUMBER,SEQUENCE_NUMBER,PROTOCOL_TYPE_CODE, PROTOCOL_STATUS_CODE ,
                              TITLE, UPDATE_TIMESTAMP,UPDATE_USER,VER_NBR,OBJ_ID  )
  values ( 201,9999, 202,201,1,100, 'test', sysdate,user,1,1)     ;         


insert into protocol_research_areas (id, PROTOCOL_ID, PROTOCOL_NUMBER ,SEQUENCE_NUMBER,RESEARCH_AREA_CODE,UPDATE_TIMESTAMP,      UPDATE_USER,VER_NBR,OBJ_ID )                              
 values (1,201,202, 201,'01.02',sysdate,user, 1 ,1);
insert into protocol_research_areas(id, PROTOCOL_ID, PROTOCOL_NUMBER ,SEQUENCE_NUMBER,RESEARCH_AREA_CODE,UPDATE_TIMESTAMP,      UPDATE_USER,VER_NBR,OBJ_ID )                              
 values (2,201,202, 201,'01.01',sysdate,user, 1 ,1);

insert into protocol_persons ( PROTOCOL_PERSON_ID,PROTOCOL_ID,PROTOCOL_NUMBER,SEQUENCE_NUMBER,PERSON_ID,PERSON_NAME ,    PROTOCOL_PERSON_ROLE_ID,ROLODEX_ID, UPDATE_TIMESTAMP,UPDATE_USER ,VER_NBR,OBJ_ID  )                             
values( 212,201, 0 , 0,'000000001','Terry Durkin','PI','',sysdate,user, 1,1);

 insert into protocol_persons ( PROTOCOL_PERSON_ID,PROTOCOL_ID,PROTOCOL_NUMBER,SEQUENCE_NUMBER,PERSON_ID,PERSON_NAME ,    PROTOCOL_PERSON_ROLE_ID,ROLODEX_ID, UPDATE_TIMESTAMP,UPDATE_USER ,VER_NBR,OBJ_ID  )                             
values( 208,201, 0 , 0,'000000003','Geoff McGregor','COI','',sysdate,user, 1,1);

 insert into protocol_persons ( PROTOCOL_PERSON_ID,PROTOCOL_ID,PROTOCOL_NUMBER,SEQUENCE_NUMBER,PERSON_ID,PERSON_NAME ,    PROTOCOL_PERSON_ROLE_ID,ROLODEX_ID, UPDATE_TIMESTAMP,UPDATE_USER ,VER_NBR,OBJ_ID  )                             
values( 211,201, 0 , 0,'000000006','Andrew Slusar','CA','',sysdate,user, 1,1);


insert into protocol_location (PROTOCOL_LOCATION_ID,PROTOCOL_ID,PROTOCOL_NUMBER,SEQUENCE_NUMBER,PROTOCOL_ORG_TYPE_CODE,     ORGANIZATION_ID,ROLODEX_ID, UPDATE_TIMESTAMP,UPDATE_USER ,VER_NBR,OBJ_ID )                             
 values (203, 201, 0 , 0,1, '000001',1,sysdate,user,1,1);


insert into PROTOCOL_FUNDING_SOURCE(PROTOCOL_FUNDING_SOURCE_ID, PROTOCOL_ID,PROTOCOL_NUMBER,SEQUENCE_NUMBER ,    FUNDING_SOURCE_TYPE_CODE,FUNDING_SOURCE ,UPDATE_TIMESTAMP, UPDATE_USER ,VER_NBR,OBJ_ID ,                            FUNDING_SOURCE_NAME   )             
 values( 241, 201,0,0,1,'000610',sysdate,user,1,1,'U.S. Department of Commerce - NOAA'); 
 insert into PROTOCOL_FUNDING_SOURCE(PROTOCOL_FUNDING_SOURCE_ID, PROTOCOL_ID,PROTOCOL_NUMBER,SEQUENCE_NUMBER ,    FUNDING_SOURCE_TYPE_CODE,FUNDING_SOURCE ,UPDATE_TIMESTAMP, UPDATE_USER ,VER_NBR,OBJ_ID ,                            FUNDING_SOURCE_NAME   )             
 values( 242, 201,0,0,2,'000001',sysdate,user,1,1,'University');
commit;