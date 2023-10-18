-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: src/main/resources/master.xml
-- Ran at: 17.10.2023, 19:01
-- Against: postgres@jdbc:postgresql://localhost:5433/postgres
-- Liquibase version: 4.9.1
-- *********************************************************************

-- Lock Database
UPDATE databasechangeloglock SET LOCKED = TRUE, LOCKEDBY = 'LAPTOP-CU5COF0B (192.168.0.48)', LOCKGRANTED = NOW() WHERE ID = 1 AND LOCKED = FALSE;

-- Release Database Lock
UPDATE databasechangeloglock SET LOCKED = FALSE, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

