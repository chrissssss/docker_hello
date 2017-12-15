CREATE TABLE tutorials_tbl(
  tutorial_id INT NOT NULL AUTO_INCREMENT,
  tutorial_title VARCHAR(100) NOT NULL,
  PRIMARY KEY ( tutorial_id )
);

INSERT INTO tutorials_tbl VALUES (null,'first'),(null, 'second');