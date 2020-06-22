SET FOREIGN_KEY_CHECKS=0;

INSERT INTO sentiment(stop_name, route_type, route_number, route_direction, capacity, vibe) VALUES ("Sunshine Station - City via Dynon Rd", "Bus", "216", "City", 50, "chilled");
INSERT INTO sentiment(stop_name, route_type, route_number, route_direction, capacity, vibe) VALUES ("Chelsea", "Bus", "98", "Chelsea", 85, "noisy");

INSERT INTO submitter(device_id, birth_year, gender) VALUES (8316080933289526961, 1900, "F");
INSERT INTO submitter(device_id, birth_year, gender) VALUES (0987654323289526961, 1900, "F");

INSERT INTO submissions(fever_status, fever_temp, location_country_code, location_postal_code, location_lng, location_lat, symptom_difficult_to_breath, symptom_cough, symptom_sore_throat, symptom_muscle_pain, diagnosed_covid19, new_device_id, submitter_id, sentiment_id) VALUES (0, 60, "AU", 4069, 152.89705690000, -27.50201610000, "0", "0", "0", "0", "0", "0", 1, 1);
INSERT INTO submissions(fever_status, fever_temp, location_country_code, location_postal_code, location_lng, location_lat, symptom_difficult_to_breath, symptom_cough, symptom_sore_throat, symptom_muscle_pain, diagnosed_covid19, new_device_id, submitter_id, sentiment_id) VALUES (0, 10, "FR", 1002, 100.98124272, -29.29244822, "0", "0", "0", "0", "0", "0", 2, 2);

SET FOREIGN_KEY_CHECKS=1;
