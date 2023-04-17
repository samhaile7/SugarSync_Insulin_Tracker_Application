BEGIN TRANSACTION;


DROP TABLE IF EXISTS meal cascade;
DROP TABLE IF EXISTS user_input cascade;
DROP TABLE IF EXISTS insulin_type cascade;
DROP TABLE IF EXISTS users cascade;
DROP TABLE IF EXISTS logger cascade;
DROP TABLE IF EXISTS log_type cascade;

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
	date_created date,
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

CREATE TABLE log_type (
	log_type_id serial,
	activity_type varchar(60),
	CONSTRAINT PK_log_type PRIMARY KEY (log_type_id) 

);


CREATE TABLE logger (
	log_id SERIAL,
	user_id int, 
	log_type_id int,
	date_time_logged timestamp without time zone,
	CONSTRAINT PK_logger PRIMARY KEY (log_id),
	CONSTRAINT FK_logger_users FOREIGN KEY (user_id) REFERENCES users (user_id),
	CONSTRAINT FK_logger_log_type FOREIGN KEY (log_type_id) REFERENCES log_type (log_type_id)

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


INSERT INTO log_type (activity_type) VALUES ('Added/Updated Profile');
INSERT INTO log_type (activity_type) VALUES ('Added Meal');
INSERT INTO log_type (activity_type) VALUES ('Blood Sugar Low');
INSERT INTO log_type (activity_type) VALUES ('Blood Sugar High');
INSERT INTO log_type (activity_type) VALUES ('Blood Sugar Critically Low');
INSERT INTO log_type (activity_type) VALUES ('Blood Sugar Critically High');


INSERT INTO insulin_type (insulin_type_name, insulin_brand_name, insulin_strength) VALUES ('U100','NovaLog',100);
INSERT INTO insulin_type (insulin_type_name, insulin_brand_name, insulin_strength) VALUES ('U200','NovaLog',200);
INSERT INTO insulin_type (insulin_type_name, insulin_brand_name, insulin_strength) VALUES ('U300','NovaLog',300);
INSERT INTO insulin_type (insulin_type_name, insulin_brand_name, insulin_strength) VALUES ('U400','NovaLog',400);
INSERT INTO insulin_type (insulin_type_name, insulin_brand_name, insulin_strength) VALUES ('U500','NovaLog',500);


COMMIT TRANSACTION;








