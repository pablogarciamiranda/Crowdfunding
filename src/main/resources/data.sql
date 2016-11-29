INSERT INTO project (id, id_category, name, location, description, fundingAmount, numberOfDays) 
VALUES 
	(1, 1, 'OnePlus 4', 'Cork', 'Test', 5000, 50);
	
INSERT INTO user (id, username, password, location, biography, email, creditLimit)
VALUES
	(1, 'pablogarciamir', '123456', 'Grao', 'Test', 'pablo.garcia-miranda@mycit.ie', 100);
	
INSERT INTO projects_owned (id_user, id_project)
VALUES
	(1, 1);

INSERT INTO tag (id, name)
VALUES
	(1, 'Virtual Reality'),
	(2, 'Trap'),
	(3, 'Design'),
	(4, 'Entrepreneurship'),
	(5, 'Android');
	
INSERT INTO projects_tags (id_tag, id_project)
VALUES
	(4, 1),
	(5, 1);

INSERT INTO category (id, name, description, picture)
VALUES
	(1, 'Smartphones', '', ''),
	(2, 'Music', '', '');

INSERT INTO pledge (id, id_user, id_reward)
VALUES
	(1, 1, 1),
	(2, 1, 2);
	
INSERT INTO reward (id, id_project, name, amount, description, estimatedDelivery, limitAvailability)
VALUES
	(1, 1, 'Basic', 50, 'Basic features', 25, 0),
	(2, 1, 'Premium', 350, 'Advanced features', 30, 1);
	
	