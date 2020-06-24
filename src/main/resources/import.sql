SET FOREIGN_KEY_CHECKS=0;

INSERT INTO sentiment(stop_name, route_type, route_number, route_direction, departure_time, capacity, vibe) VALUES ("Sunshine Station - City via Dynon Rd", "Bus", "216", "City", "2020-06-23 05:27:24", 50, 10);
INSERT INTO sentiment(stop_name, route_type, route_number, route_direction, departure_time, capacity, vibe) VALUES ("Chelsea", "Bus", "98", "Chelsea", "2020-06-23 05:27:24", 85, 98);

INSERT INTO submitter(device_id) VALUES (8316080933289526961);
INSERT INTO submitter(device_id) VALUES (0987654323289526961);

INSERT INTO submissions(location_lng, location_lat, submitter_id, sentiment_id) VALUES (152.89705690000, -27.50201610000, 1, 1);
INSERT INTO submissions(location_lng, location_lat, submitter_id, sentiment_id) VALUES (100.98124272, -29.29244822, 2, 2);

SET FOREIGN_KEY_CHECKS=1;
