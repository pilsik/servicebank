BEGIN
TRANSACTION;

/*Drop all table if exists*/
DROP TABLE IF EXISTS "cities" CASCADE;
DROP TABLE IF EXISTS "citizenships" CASCADE;
DROP TABLE IF EXISTS "disability" CASCADE;
DROP TABLE IF EXISTS "marital_status" CASCADE;
DROP TABLE IF EXISTS "clients" CASCADE;
DROP TABLE IF EXISTS "passports" CASCADE;
DROP TABLE IF EXISTS "contacts" CASCADE;

/*Drop all sequences if exists*/
DROP
SEQUENCE
IF
EXISTS
"cities_seq"
CASCADE;
DROP
SEQUENCE
IF
EXISTS
"citizenships_seq"
CASCADE;
DROP
SEQUENCE
IF
EXISTS
"disability_seq"
CASCADE;
DROP
SEQUENCE
IF
EXISTS
"marital_status_seq"
CASCADE;
DROP
SEQUENCE
IF
EXISTS
"clients_seq"
CASCADE;

/*Create all sequences for iterate*/
CREATE
SEQUENCE
"cities_seq"
START
1
INCREMENT
BY
1;
CREATE
SEQUENCE
"citizenships_seq"
START
1
INCREMENT
BY
1;
CREATE
SEQUENCE
"disability_seq"
START
1
INCREMENT
BY
1;
CREATE
SEQUENCE
"marital_status_seq"
START
1
INCREMENT
BY
1;
CREATE
SEQUENCE
"clients_seq"
START
1
INCREMENT
BY
1;

CREATE TABLE "cities"
(
  "id"   BIGINT PRIMARY KEY DEFAULT "nextval"('"cities_seq"'),
  "name" VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE "citizenships"
(
  "id"   BIGINT PRIMARY KEY DEFAULT "nextval"('"citizenships_seq"'),
  "name" VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE "disability"
(
  "id"   BIGINT PRIMARY KEY DEFAULT "nextval"('"disability_seq"'),
  "name" VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE "marital_status"
(
  "id"   BIGINT PRIMARY KEY DEFAULT "nextval"('"marital_status_seq"'),
  "name" VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE "clients"
(
  "id"                      BIGINT PRIMARY KEY DEFAULT "nextval"('"clients_seq"'),
  "surname"                 VARCHAR(100) NOT NULL,
  "name"                    VARCHAR(100) NOT NULL,
  "patronymic"              VARCHAR(100) NOT NULL,
  "dob"                     TIMESTAMP    NOT NULL,
  "sex"                     BOOLEAN      NOT NULL,
  "pensioner"               BOOLEAN      NOT NULL,
  "monthly_income"          NUMERIC, /* MONEY https://stackoverflow.com/questions/12724634/postgresql-money-type-how-to-map-it-to-hibernate-jpa*/
  "bpl"                     VARCHAR(100) NOT NULL,
  "city_of_residence_id"    BIGINT       NOT NULL,
  "city_of_registration_id" BIGINT       NOT NULL,
  "marital_status_id"       BIGINT       NOT NULL,
  "citizenship_id"          BIGINT       NOT NULL,
  "disability_id"           BIGINT       NOT NULL,
  FOREIGN KEY ("city_of_residence_id") REFERENCES "cities" ("id") ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY ("city_of_registration_id") REFERENCES "cities" ("id") ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY ("marital_status_id") REFERENCES "marital_status" ("id") ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY ("citizenship_id") REFERENCES "citizenships" ("id") ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY ("disability_id") REFERENCES "disability" ("id") ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE "passports"
(
  "id"                             BIGINT PRIMARY KEY,
  "passport_series"                VARCHAR(100) NOT NULL,
  "passport_number"                VARCHAR(100) NOT NULL,
  "passport_authority"             VARCHAR(100) NOT NULL,
  "passport_date_of_issue"         TIMESTAMP    NOT NULL,
  "passport_identification_number" VARCHAR(100) NOT NULL,
  FOREIGN KEY ("id") REFERENCES "clients" ("id") ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE "contacts"
(
  "id"           BIGINT PRIMARY KEY,
  "address"      VARCHAR(200) NOT NULL,
  "phone_home"   VARCHAR(100) NOT NULL,
  "phone_mobile" VARCHAR(100) NOT NULL,
  "email"        VARCHAR(100),
  FOREIGN KEY ("id") REFERENCES "clients" ("id") ON DELETE CASCADE ON UPDATE CASCADE
);

-- CHECK indexes
ALTER TABLE "passports"
  ADD CONSTRAINT "passport_number_regexp" CHECK ("passport_number" ~ $$^\d{7}$$);
ALTER TABLE "passports"
  ADD CONSTRAINT "passport_identification_number_regexp" CHECK ("passport_identification_number" ~ $$^\d{7}[A-z]\d{3}[A-z]{2}\d$$);
ALTER TABLE "contacts"
  ADD CONSTRAINT "phone_home_regexp" CHECK ("phone_home" ~ $$^\d{6}$$);
ALTER TABLE "contacts"
  ADD CONSTRAINT "phone_mobile_regexp" CHECK ("phone_mobile" ~ $$^\+\d{1,3}\(\d{2}\)\d{7}$$);
ALTER TABLE "contacts"
  ADD CONSTRAINT "email_regexp" CHECK ("email" ~ $$^[a-zA-Z0-9_\-]+@([a-zA-Z0-9_\-]+\.)\w{2,4}$$);

END
TRANSACTION;