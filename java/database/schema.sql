BEGIN TRANSACTION;


DROP TABLE IF EXISTS meal cascade;
DROP TABLE IF EXISTS user_input cascade;
DROP TABLE IF EXISTS insulin_type cascade;
DROP TABLE IF EXISTS users cascade;


CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE meal (
	meal_id SERIAL,
	user_id int, 
	number_of_carbs int,
	blood_sugar_at_mealtime decimal,
	suggested_dose decimal,
	CONSTRAINT PK_meal PRIMARY KEY (meal_id),
	CONSTRAINT FK_meal_users FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE insulin_type (
	insulin_type_id serial,
	insulin_type_name varchar(60),
	CONSTRAINT PK_insulin_type PRIMARY KEY (insulin_type_id) 

);

CREATE TABLE user_input (
	input_id SERIAL,
	user_id int,
	weight int,
	base_level decimal,
	insulin_type_id int,
	insulin_strength decimal,
	CONSTRAINT PK_user_input PRIMARY KEY (input_id),
	CONSTRAINT FK_user_input_users FOREIGN KEY (user_id) REFERENCES users (user_id),
	CONSTRAINT FK_user_input_insulin_type FOREIGN KEY (insulin_type_id) REFERENCES insulin_type (insulin_type_id)

);

INSERT INTO insulin_type (insulin_type_name) VALUES ('type1');
INSERT INTO insulin_type (insulin_type_name) VALUES ('type2');
INSERT INTO insulin_type (insulin_type_name) VALUES ('type3');
INSERT INTO insulin_type (insulin_type_name) VALUES ('type4');


COMMIT TRANSACTION;

SELECT * FROM user_input



