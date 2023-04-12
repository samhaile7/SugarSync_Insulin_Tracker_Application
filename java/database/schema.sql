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
	insulin_brand_name varchar(60),
	insulin_strength decimal,
	CONSTRAINT PK_insulin_type PRIMARY KEY (insulin_type_id) 

);

CREATE TABLE user_input (
	input_id SERIAL,
	user_id int,
	weight int,
	base_level decimal,
	target_range_min decimal,
	target_range_max decimal,
	critical_high decimal,
	critical_low decimal,
	insulin_type_id int,

	CONSTRAINT PK_user_input PRIMARY KEY (input_id),
	CONSTRAINT FK_user_input_users FOREIGN KEY (user_id) REFERENCES users (user_id),
	CONSTRAINT FK_user_input_insulin_type FOREIGN KEY (insulin_type_id) REFERENCES insulin_type (insulin_type_id)

);

INSERT INTO insulin_type (insulin_type_name, insulin_brand_name, insulin_strength) VALUES ('U100','NovaLog',100);
INSERT INTO insulin_type (insulin_type_name, insulin_brand_name, insulin_strength) VALUES ('U200','NovaLog',200);
INSERT INTO insulin_type (insulin_type_name, insulin_brand_name, insulin_strength) VALUES ('U300','NovaLog',300);
INSERT INTO insulin_type (insulin_type_name, insulin_brand_name, insulin_strength) VALUES ('U400','NovaLog',400);
INSERT INTO insulin_type (insulin_type_name, insulin_brand_name, insulin_strength) VALUES ('U500','NovaLog',500);


COMMIT TRANSACTION;

SELECT * FROM user_input



