-- ============================================================
--   SGBD      		  :  PostgreSql                     
-- ============================================================




-- ============================================================
--   Sequences                                      
-- ============================================================
create sequence SEQ_APPLICATION_USER
	start with 1000 cache 20; 

create sequence SEQ_PROFIL
	start with 1000 cache 20; 

create sequence SEQ_SECURITY_ROLE
	start with 1000 cache 20; 

create sequence SEQ_USER_AUTHENTIFICATION
	start with 1000 cache 20; 


-- ============================================================
--   Table : APPLICATION_USER                                        
-- ============================================================
create table APPLICATION_USER
(
    USR_ID      	 NUMERIC     	not null,
    LAST_NAME   	 VARCHAR(50) 	,
    FIRST_NAME  	 VARCHAR(50) 	,
    EMAIL       	 VARCHAR(150)	,
    PRO_ID      	 NUMERIC     	,
    constraint PK_APPLICATION_USER primary key (USR_ID)
);

comment on column APPLICATION_USER.USR_ID is
'USR_ID';

comment on column APPLICATION_USER.LAST_NAME is
'Last Name';

comment on column APPLICATION_USER.FIRST_NAME is
'First Name';

comment on column APPLICATION_USER.EMAIL is
'email';

comment on column APPLICATION_USER.PRO_ID is
'Profil';

-- ============================================================
--   Table : PROFIL                                        
-- ============================================================
create table PROFIL
(
    PRO_ID      	 NUMERIC     	not null,
    LABEL       	 VARCHAR(100)	,
    constraint PK_PROFIL primary key (PRO_ID)
);

comment on column PROFIL.PRO_ID is
'PRO_ID';

comment on column PROFIL.LABEL is
'Label';

-- ============================================================
--   Table : SECURITY_ROLE                                        
-- ============================================================
create table SECURITY_ROLE
(
    SRO_CD      	 VARCHAR(100)	not null,
    LABEL       	 VARCHAR(100)	,
    constraint PK_SECURITY_ROLE primary key (SRO_CD)
);

comment on column SECURITY_ROLE.SRO_CD is
'SRO_CD';

comment on column SECURITY_ROLE.LABEL is
'Label';

-- ============================================================
--   Table : USER_AUTHENTIFICATION                                        
-- ============================================================
create table USER_AUTHENTIFICATION
(
    AUTH_ID     	 NUMERIC     	not null,
    LOGIN       	 VARCHAR(50) 	,
    PASSWORD    	 VARCHAR(32) 	,
    USR_ID      	 NUMERIC     	not null,
    constraint PK_USER_AUTHENTIFICATION primary key (AUTH_ID)
);

comment on column USER_AUTHENTIFICATION.AUTH_ID is
'AUTH_ID';

comment on column USER_AUTHENTIFICATION.LOGIN is
'Login';

comment on column USER_AUTHENTIFICATION.PASSWORD is
'Password';

comment on column USER_AUTHENTIFICATION.USR_ID is
'Application user';



alter table USER_AUTHENTIFICATION
	add constraint FK_AUTH_USR_APPLICATION_USER foreign key (USR_ID)
	references APPLICATION_USER (USR_ID);

create index AUTH_USR_APPLICATION_USER_FK on USER_AUTHENTIFICATION (USR_ID asc);

alter table APPLICATION_USER
	add constraint FK_USR_PRO_PROFIL foreign key (PRO_ID)
	references PROFIL (PRO_ID);

create index USR_PRO_PROFIL_FK on APPLICATION_USER (PRO_ID asc);


create table PRO_SRO
(
	PRO_ID      	 NUMERIC     	 not null,
	SRO_CD      	 VARCHAR(100)	 not null,
	constraint PK_PRO_SRO primary key (PRO_ID, SRO_CD),
	constraint FK_PRO_SRO_PROFIL 
		foreign key(PRO_ID)
		references PROFIL (PRO_ID),
	constraint FK_PRO_SRO_SECURITY_ROLE 
		foreign key(SRO_CD)
		references SECURITY_ROLE (SRO_CD)
);

create index PRO_SRO_PROFIL_FK on PRO_SRO (PRO_ID asc);

create index PRO_SRO_SECURITY_ROLE_FK on PRO_SRO (SRO_CD asc);

