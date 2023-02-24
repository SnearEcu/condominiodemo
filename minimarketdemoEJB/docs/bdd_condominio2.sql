/*==============================================================*/
/* DBMS name:      PostgreSQL 7.3                               */
/* Created on:     14/2/2023 8:21:11                            */
/*==============================================================*/


drop index ALICUOTA_PK;

drop table ALICUOTA;

drop index AUD_BITACORA_PK;

drop table AUD_BITACORA;

drop index BIEN_PK;

drop table BIEN;

drop index RELATIONSHIP_11_FK;

drop index RELATIONSHIP_2_FK;

drop index RELATIONSHIP_3_FK;

drop index DETALLE_PAGOS_PK;

drop table DETALLE_PAGOS;

drop index MULTAS_PK;

drop table MULTAS;

drop index PAGOS_PK;

drop table PAGOS;

drop index RELATIONSHIP_7_FK;

drop index RELATIONSHIP_6_FK;

drop index RESERVAS_PK;

drop table RESERVAS;

drop table SEG_ASIGNACION;

drop index SEG_MODULO_PK;

drop table SEG_MODULO;

drop index REFERENCE_4_FK;

drop index SEG_PERFIL_PK;

drop table SEG_PERFIL;

drop index CONDOMINOS_PK;

drop table SEG_USUARIO;

drop index RELATIONSHIP_14_FK;

drop index SERVICIOS_PK;

drop table SERVICIOS;

drop index TIPO_SERVICIOS_PK;

drop table TIPO_SERVICIOS;

drop index RELATIONSHIP_10_FK;

drop index VEHICULO_PK;

drop table VEHICULO;

drop index RELATIONSHIP_5_FK;

drop index VIVIENDA_PK;

drop table VIVIENDA;

/*==============================================================*/
/* Table: ALICUOTA                                              */
/*==============================================================*/
create table ALICUOTA (
ALI_ID               SERIAL not null,
VALOR_ALICUOTA       FLOAT                null,
PERIODO              NUMERIC              null,
constraint PK_ALICUOTA primary key (ALI_ID)
);

/*==============================================================*/
/* Index: ALICUOTA_PK                                           */
/*==============================================================*/
create unique index ALICUOTA_PK on ALICUOTA (
ALI_ID
);

/*==============================================================*/
/* Table: AUD_BITACORA                                          */
/*==============================================================*/
create table AUD_BITACORA (
ID_AUD_BITACORA      SERIAL not null,
FECHA_EVENTO         DATE                 not null,
NOMBRE_CLASE         character varying(100) not null,
NOMBRE_METODO        character varying(100) not null,
DESCRIPCION_EVENTO   character varying(300) not null,
ID_USUARIO           character varying(100) not null,
DIRECCION_IP         character varying(100) not null,
constraint PK_AUD_BITACORA primary key (ID_AUD_BITACORA)
);

/*==============================================================*/
/* Index: AUD_BITACORA_PK                                       */
/*==============================================================*/
create unique index AUD_BITACORA_PK on AUD_BITACORA (
ID_AUD_BITACORA
);

/*==============================================================*/
/* Table: BIEN                                                  */
/*==============================================================*/
create table BIEN (
BIEN_ID              SERIAL not null,
NOMBRE_BIEN          TEXT                 null,
DIRECCION_BIEN       TEXT                 null,
constraint PK_BIEN primary key (BIEN_ID)
);

/*==============================================================*/
/* Index: BIEN_PK                                               */
/*==============================================================*/
create unique index BIEN_PK on BIEN (
BIEN_ID
);

/*==============================================================*/
/* Table: DETALLE_PAGOS                                         */
/*==============================================================*/
create table DETALLE_PAGOS (
DET_ID               SERIAL not null,
SERV_ID              INT4                 null,
MULT_ID              INT4                 null,
ALI_ID               INT4                 null,
SUBTOTAL_PAGO        FLOAT                null,
constraint PK_DETALLE_PAGOS primary key (DET_ID)
);

/*==============================================================*/
/* Index: DETALLE_PAGOS_PK                                      */
/*==============================================================*/
create unique index DETALLE_PAGOS_PK on DETALLE_PAGOS (
DET_ID
);

/*==============================================================*/
/* Index: RELATIONSHIP_3_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_3_FK on DETALLE_PAGOS (
ALI_ID
);

/*==============================================================*/
/* Index: RELATIONSHIP_2_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_2_FK on DETALLE_PAGOS (
MULT_ID
);

/*==============================================================*/
/* Index: RELATIONSHIP_11_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_11_FK on DETALLE_PAGOS (
SERV_ID
);

/*==============================================================*/
/* Table: MULTAS                                                */
/*==============================================================*/
create table MULTAS (
MULT_ID              SERIAL not null,
VALOR_MULTA          FLOAT                null,
TIPO_MULTA           CHAR(10)             null,
constraint PK_MULTAS primary key (MULT_ID)
);

/*==============================================================*/
/* Index: MULTAS_PK                                             */
/*==============================================================*/
create unique index MULTAS_PK on MULTAS (
MULT_ID
);

/*==============================================================*/
/* Table: PAGOS                                                 */
/*==============================================================*/
create table PAGOS (
PAG_ID               SERIAL not null,
ID_SEG_USUARIO       INT4                 null,
DET_ID               INT4                 null,
FECHA_PAGO           DATE                 null,
TOTAL_PAGO           FLOAT                null,
constraint PK_PAGOS primary key (PAG_ID)
);

/*==============================================================*/
/* Index: PAGOS_PK                                              */
/*==============================================================*/
create unique index PAGOS_PK on PAGOS (
PAG_ID
);

/*==============================================================*/
/* Table: RESERVAS                                              */
/*==============================================================*/
create table RESERVAS (
RESV_ID              SERIAL not null,
COND_ID              INT4                 null,
BIEN_ID              INT4                 null,
FECHA_RESERVA        DATE                 null,
FECHA_INICIO         DATE                 null,
FECHA_FIN            DATE                 null,
constraint PK_RESERVAS primary key (RESV_ID)
);

/*==============================================================*/
/* Index: RESERVAS_PK                                           */
/*==============================================================*/
create unique index RESERVAS_PK on RESERVAS (
RESV_ID
);

/*==============================================================*/
/* Index: RELATIONSHIP_6_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_6_FK on RESERVAS (
COND_ID
);

/*==============================================================*/
/* Index: RELATIONSHIP_7_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_7_FK on RESERVAS (
BIEN_ID
);

/*==============================================================*/
/* Table: SEG_ASIGNACION                                        */
/*==============================================================*/
create table SEG_ASIGNACION (
ID_SEG_PERFIL        INT4                 null,
ID_SEG_USUARIO       INT4                 null,
ID_SEG_ASIGNACION    SERIAL not null,
constraint PK_SEG_ASIGNACION primary key (ID_SEG_ASIGNACION)
);

/*==============================================================*/
/* Table: SEG_MODULO                                            */
/*==============================================================*/
create table SEG_MODULO (
ID_SEG_MODULO        SERIAL not null,
NOMBRE_MODULO        character varying(50) not null,
ICONO                character varying(100) null,
constraint PK_SEG_MODULO primary key (ID_SEG_MODULO),
constraint AK_UK_NOMBRE_MODULO_SEG_MODU unique (NOMBRE_MODULO)
);

/*==============================================================*/
/* Index: SEG_MODULO_PK                                         */
/*==============================================================*/
create unique index SEG_MODULO_PK on SEG_MODULO (
ID_SEG_MODULO
);

/*==============================================================*/
/* Table: SEG_PERFIL                                            */
/*==============================================================*/
create table SEG_PERFIL (
ID_SEG_PERFIL        SERIAL not null,
ID_SEG_MODULO        integer              not null,
NOMBRE_PERFIL        character varying(50) not null,
RUTA_ACCESO          character varying(100) not null,
constraint PK_SEG_PERFIL primary key (ID_SEG_PERFIL)
);

/*==============================================================*/
/* Index: SEG_PERFIL_PK                                         */
/*==============================================================*/
create unique index SEG_PERFIL_PK on SEG_PERFIL (
ID_SEG_PERFIL
);

/*==============================================================*/
/* Index: REFERENCE_4_FK                                        */
/*==============================================================*/
create  index REFERENCE_4_FK on SEG_PERFIL (
ID_SEG_MODULO
);

/*==============================================================*/
/* Table: SEG_USUARIO                                           */
/*==============================================================*/
create table SEG_USUARIO (
ID_SEG_USUARIO       SERIAL not null,
CODIGO               TEXT                 null,
APELLIDOS            TEXT                 null,
NOMBRES              TEXT                 null,
CORREO               TEXT                 null,
CLAVE                TEXT                 null,
ACTIVO               BOOL                 null,
constraint PK_CONDOMINOS primary key (ID_SEG_USUARIO)
);

/*==============================================================*/
/* Index: CONDOMINOS_PK                                         */
/*==============================================================*/
create unique index CONDOMINOS_PK on SEG_USUARIO (
ID_SEG_USUARIO
);

/*==============================================================*/
/* Table: SERVICIOS                                             */
/*==============================================================*/
create table SERVICIOS (
SERV_ID              SERIAL not null,
TIP_SER_ID           INT4                 null,
VALOR_SERVICIO       FLOAT                null,
constraint PK_SERVICIOS primary key (SERV_ID)
);

/*==============================================================*/
/* Index: SERVICIOS_PK                                          */
/*==============================================================*/
create unique index SERVICIOS_PK on SERVICIOS (
SERV_ID
);

/*==============================================================*/
/* Index: RELATIONSHIP_14_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_14_FK on SERVICIOS (
TIP_SER_ID
);

/*==============================================================*/
/* Table: TIPO_SERVICIOS                                        */
/*==============================================================*/
create table TIPO_SERVICIOS (
TIP_SER_ID           SERIAL not null,
NOMBRE_SERVICIO      TEXT                 null,
constraint PK_TIPO_SERVICIOS primary key (TIP_SER_ID)
);

/*==============================================================*/
/* Index: TIPO_SERVICIOS_PK                                     */
/*==============================================================*/
create unique index TIPO_SERVICIOS_PK on TIPO_SERVICIOS (
TIP_SER_ID
);

/*==============================================================*/
/* Table: VEHICULO                                              */
/*==============================================================*/
create table VEHICULO (
VEH_ID               SERIAL not null,
COND_ID              INT4                 null,
PLACA_VEHICULO       TEXT                 null,
constraint PK_VEHICULO primary key (VEH_ID)
);

/*==============================================================*/
/* Index: VEHICULO_PK                                           */
/*==============================================================*/
create unique index VEHICULO_PK on VEHICULO (
VEH_ID
);

/*==============================================================*/
/* Index: RELATIONSHIP_10_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_10_FK on VEHICULO (
COND_ID
);

/*==============================================================*/
/* Table: VIVIENDA                                              */
/*==============================================================*/
create table VIVIENDA (
VIV_ID               SERIAL not null,
COND_ID              INT4                 null,
NUMERO_VIVIENDA      NUMERIC              null,
DIRECCION_VIVIENDA   TEXT                 null,
constraint PK_VIVIENDA primary key (VIV_ID)
);

/*==============================================================*/
/* Index: VIVIENDA_PK                                           */
/*==============================================================*/
create unique index VIVIENDA_PK on VIVIENDA (
VIV_ID
);

/*==============================================================*/
/* Index: RELATIONSHIP_5_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_5_FK on VIVIENDA (
COND_ID
);

alter table DETALLE_PAGOS
   add constraint FK_DETALLE__RELATIONS_ALICUOTA foreign key (ALI_ID)
      references ALICUOTA (ALI_ID)
      on delete restrict on update restrict;

alter table DETALLE_PAGOS
   add constraint FK_DETALLE__RELATIONS_MULTAS foreign key (MULT_ID)
      references MULTAS (MULT_ID)
      on delete restrict on update restrict;

alter table DETALLE_PAGOS
   add constraint FK_DETALLE__RELATIONS_SERVICIO foreign key (SERV_ID)
      references SERVICIOS (SERV_ID)
      on delete restrict on update restrict;

alter table PAGOS
   add constraint FK_CONDOMIN_RELATIONS_PAGOS foreign key (ID_SEG_USUARIO)
      references SEG_USUARIO (ID_SEG_USUARIO)
      on delete restrict on update restrict;

alter table PAGOS
   add constraint FK_PAGOS_REFERENCE_DETALLE_ foreign key (DET_ID)
      references DETALLE_PAGOS (DET_ID)
      on delete restrict on update restrict;

alter table RESERVAS
   add constraint FK_RESERVAS_RELATIONS_BIEN foreign key (BIEN_ID)
      references BIEN (BIEN_ID)
      on delete restrict on update restrict;

alter table RESERVAS
   add constraint FK_RESERVAS_RELATIONS_CONDOMIN foreign key (COND_ID)
      references SEG_USUARIO (ID_SEG_USUARIO)
      on delete restrict on update restrict;

alter table SEG_ASIGNACION
   add constraint FK_SEG_ASIG_FK_SEG_AS_SEG_PERF foreign key (ID_SEG_PERFIL)
      references SEG_PERFIL (ID_SEG_PERFIL)
      on delete restrict on update restrict;

alter table SEG_ASIGNACION
   add constraint FK_SEG_ASIG_FK_SEG_AS_SEG_USUA foreign key (ID_SEG_USUARIO)
      references SEG_USUARIO (ID_SEG_USUARIO)
      on delete restrict on update restrict;

alter table SEG_PERFIL
   add constraint FK_SEG_PERF_REFERENCE_SEG_MODU foreign key (ID_SEG_MODULO)
      references SEG_MODULO (ID_SEG_MODULO)
      on delete restrict on update restrict;

alter table SERVICIOS
   add constraint FK_SERVICIO_RELATIONS_TIPO_SER foreign key (TIP_SER_ID)
      references TIPO_SERVICIOS (TIP_SER_ID)
      on delete restrict on update restrict;

alter table VEHICULO
   add constraint FK_VEHICULO_RELATIONS_CONDOMIN foreign key (COND_ID)
      references SEG_USUARIO (ID_SEG_USUARIO)
      on delete restrict on update restrict;

alter table VIVIENDA
   add constraint FK_VIVIENDA_RELATIONS_CONDOMIN foreign key (COND_ID)
      references SEG_USUARIO (ID_SEG_USUARIO)
      on delete restrict on update restrict;

