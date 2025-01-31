CREATE TABLE PRODUCT(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  DESC VARCHAR(128),
  VALUE DECIMAL(10, 2) NOT NULL,
  DATE_CREATED DATETIME DEFAULT CURRENT_DATE NOT NULL,
  ACTIVE BOOLEAN DEFAULT TRUE NOT NULL
);

CREATE TABLE USER(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  LOGIN VARCHAR(64) UNIQUE,
  PASSWORD VARCHAR(64)
);

CREATE INDEX IDX_PROD_CODE_ ON PRODUCT(ID);
