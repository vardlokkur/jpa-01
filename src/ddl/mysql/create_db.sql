CREATE TABLE EMPLOYEE (
    EMPLOYEE_ID   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    EMPLOYEE_NAME VARCHAR(256) NOT NULL,
    DATE_OF_BIRTH DATE         NOT NULL,
    CONSTRAINT EMPLOYEE_PK PRIMARY KEY (EMPLOYEE_ID)
) ENGINE = InnoDB;