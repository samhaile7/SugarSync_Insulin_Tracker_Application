BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose) VALUES (2, 50, 85, 4);
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose) VALUES (2, 60, 105, 5);
INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose) VALUES (3, 65, 100, 4);

INSERT INTO user_input (user_id, weight, base_level, insulin_type_id) VALUES (2, 150, 65, 1);
INSERT INTO user_input (user_id, weight, base_level, insulin_type_id) VALUES (2, 175, 70, 3);
INSERT INTO user_input (user_id, weight, base_level, insulin_type_id) VALUES (3, 200, 75, 2);

INSERT INTO insulin_type (insulin_type_name, insulin_brand_name, insulin_strength) VALUES ('U100','NovaLog',100);
INSERT INTO insulin_type (insulin_type_name, insulin_brand_name, insulin_strength) VALUES ('U200','NovaLog',200);
INSERT INTO insulin_type (insulin_type_name, insulin_brand_name, insulin_strength) VALUES ('U300','NovaLog',300);
INSERT INTO insulin_type (insulin_type_name, insulin_brand_name, insulin_strength) VALUES ('U400','NovaLog',400);
INSERT INTO insulin_type (insulin_type_name, insulin_brand_name, insulin_strength) VALUES ('U500','NovaLog',500);


COMMIT TRANSACTION;

SELECT * FROM users

INSERT INTO user_input (weight, base_level, insulin_type_id, insulin_strength) VALUES (160, 70, 3, 80) 
RETURNING input_id


