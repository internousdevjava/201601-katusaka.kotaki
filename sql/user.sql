CREATE TABLE struts2.user
(
    user_id                     INT auto_increment,
    password                    VARCHAR(255),
    user_name                   VARCHAR(50) NOT NULL,
    name_kana                   VARCHAR(50),
    mail_adress                 VARCHAR(100) unique,
    credit_number               VARCHAR(4),
    token                       VARCHAR(255),
    unique_id                   VARCHAR(50),
    oauth_name                  VARCHAR(50),
    registration_date           DATETIME NOT NULL,
    update_date                 DATETIME NOT NULL,
    CONSTRAINT PRIMARY KEY (user_id)
);

INSERT INTO user(password, user_name, name_kana, mail_adress, registration_date, update_date)
			values('12345','田中太郎','タナカタロウ','internous@gmail.com', '20491004152507', '09521004152507')