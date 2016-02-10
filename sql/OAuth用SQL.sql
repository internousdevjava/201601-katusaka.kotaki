CREATE TABLE struts2.user
(
    user_id                     INT,
    password                    VARCHAR(255),
    user_name                   VARCHAR(50) NOT NULL,
    name_kana                   VARCHAR(50),
    mail_adress                 VARCHAR(100),
    credit_number               VARCHAR(4),
    token                       VARCHAR(255),
    unique_id                   VARCHAR(50),
    oauth_name                  VARCHAR(50),
    registration_date           DATETIME NOT NULL,
    update_date                 DATETIME NOT NULL,
    CONSTRAINT PRIMARY KEY (user_id)
);