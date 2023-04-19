BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (username,password_hash,role) VALUES ('claire','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('sam','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('mohamed','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('kelly','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');

--inserts into other users for Admin Summary

INSERT INTO user_input (user_id, weight, base_level, target_range_min, target_range_max, critical_low, critical_high, insulin_type_id)
	VALUES (3, 190, 90, 100, 140, 60, 180, 3);
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (3, 30, 135, 3.3, '2023-04-14');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (3, 25, 158, 2.76, '2023-04-17');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (3, 40, 38, 2.36, '2023-04-20');
	
INSERT INTO user_input (user_id, weight, base_level, target_range_min, target_range_max, critical_low, critical_high, insulin_type_id)
	VALUES (4, 180, 50, 90, 130, 50, 170, 4);
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (4, 15, 100, 0.8, '2023-04-14');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (4, 21, 157, 2.94, '2023-04-17');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (4, 40, 210, 6.0, '2023-04-20');
	
INSERT INTO user_input (user_id, weight, base_level, target_range_min, target_range_max, critical_low, critical_high, insulin_type_id)
	VALUES (5, 250, 90, 80, 130, 40, 170, 2);
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (5, 27, 60, 1.1, '2023-04-14');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (5, 38, 135, 3.6, '2023-04-17');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (5, 42, 150, 4.9, '2023-04-20');
	
INSERT INTO user_input (user_id, weight, base_level, target_range_min, target_range_max, critical_low, critical_high, insulin_type_id)
	VALUES (6, 120, 60, 80, 120, 40, 160, 5);
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (6, 35, 97, 2.94, '2023-04-14');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (6, 67, 138, 6.76, '2023-04-17');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (6, 39, 170, 4.4, '2023-04-20');

--massive insert into 'user'

INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (1, 30, 115, 3.8, '2023-03-21');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (1, 50, 10, 3.7, '2023-03-25');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (1, 25, 80, 2.1, '2023-03-28');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (1, 15, 150, 2.5, '2023-03-30');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (1, 45, 120, 4.9, '2023-03-31');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (1, 35, 200, 5.5, '2023-04-01');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (1, 20, 35, 1.2, '2023-04-04');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (1, 15, 160, 2.7, '2023-04-10');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (1, 38, 19, 1.88, '2023-04-12');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (1, 23, 183, 4.16, '2023-04-14');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (1, 25, 130, 3.1, '2023-04-15');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (1, 33, 145, 4.4, '2023-04-17');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (1, 31, 7, 1.64, '2023-04-19');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (1, 17, 98, 1.46, '2023-04-20');
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created)
	VALUES (1, 45, 123, 4.96, '2023-04-21');


--inserts for logger table

INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 2, '2023-03-21 09:18:02.123173');
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 4, '2023-03-21 09:18:02.123173');


INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 2, '2023-03-25 10:20:02.123173');
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 5, '2023-03-25 10:20:02.123173');

INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 2, '2023-03-28 10:20:02.123173');

INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 2, '2023-03-30 09:25:02.123173');
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 6, '2023-03-30 09:25:02.123173');
	
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 2, '2023-03-31 09:18:02.123173');
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 4, '2023-03-31 09:18:02.123173');

INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 2, '2023-04-01 15:18:02.123173');
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 6, '2023-04-01 15:18:02.123173');
	
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 2, '2023-04-04 15:15:02.123173');
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 3, '2023-04-04 15:15:02.123173');
	
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 2, '2023-04-10 15:30:02.123173');
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 6, '2023-04-10 15:30:02.123173');
	
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 2, '2023-04-14 15:15:02.123173');
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 6, '2023-04-14 15:15:02.123173');
	
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 2, '2023-04-15 15:22:02.123173');
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 4, '2023-04-15 15:22:02.123173');
	
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 2, '2023-04-17 15:28:02.123173');
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 6, '2023-04-17 15:28:02.123173');
	
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 2, '2023-04-19 15:18:02.123173');
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 5, '2023-04-19 15:18:02.123173');
	
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 2, '2023-04-20 15:40:02.123173');

INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 2, '2023-04-19 15:02:02.123173');
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (1, 4, '2023-04-19 15:02:02.123173');
	

-- user 3

INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (3, 2, '2023-04-14 10:20:02.123173');

INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (3, 2, '2023-04-17 10:30:02.123173');
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (3, 4, '2023-04-17 10:30:02.123173');

INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (3, 2, '2023-04-20 10:40:02.123173');
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (3, 5, '2023-04-20 10:40:02.123173');
	
-- user 4

INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (4, 2, '2023-04-14 10:20:02.123173');

INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (4, 2, '2023-04-17 10:30:02.123173');
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (4, 4, '2023-04-17 10:30:02.123173');
	
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (4, 2, '2023-04-20 10:40:02.123173');
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (4, 6, '2023-04-20 10:40:02.123173');
	
-- user 5

INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (5, 2, '2023-04-14 10:20:02.123173');
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (5, 3, '2023-04-14 10:20:02.123173');

INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (5, 2, '2023-04-17 10:30:02.123173');
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (5, 4, '2023-04-17 10:30:02.123173');
	
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (5, 2, '2023-04-20 10:40:02.123173');
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (5, 4, '2023-04-20 10:40:02.123173');
	
-- user 6

INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (6, 2, '2023-04-14 10:20:02.123173');

INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (6, 2, '2023-04-17 10:30:02.123173');
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (6, 4, '2023-04-17 10:30:02.123173');
	
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (6, 2, '2023-04-20 10:40:02.123173');
INSERT INTO logger (user_id, log_type_id, date_time_logged)
	VALUES (6, 6, '2023-04-20 10:40:02.123173');


COMMIT TRANSACTION;
