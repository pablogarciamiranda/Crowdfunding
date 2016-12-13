INSERT INTO Categories (id, name, description, picture)
VALUES
	(1, 'Smartphones', '', ''),
	(2, 'Music', '', '');

INSERT INTO Tags (id, name)
VALUES
	(1, 'Virtual Reality'),
	(2, 'Trap'),
	(3, 'Design'),
	(4, 'Entrepreneurship'),
	(5, 'Android');

INSERT INTO Projects (id, id_category, name, location, description, fundingAmount, currentAmount, numberOfDays) 
VALUES
	(1, 1, 'OnePlus 4', 'Cork', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel lorem at justo sodales pulvinar nec nec eros. Proin eget nunc lacus. Nullam vulputate felis eget nibh pellentesque, et pulvinar justo dictum. Morbi imperdiet vestibulum leo et semper.', 5000, 1678.53, 50),
	(2, 1, 'OnePlus 4T', 'Dublin', 'Testing', 6000, 0, 45);
	
INSERT INTO Users (id, username, password, location, biography, email, creditLimit, enabled)
VALUES
	(1, 'pablogarciamir', '123456', 'Grao', 'Test', 'pablo.garcia-miranda@mycit.ie', 100, True),
	(2, 'dodo', 'dodo', 'Cork', 'Test', 'dodo@mycit.ie', 100, True);
	
INSERT INTO Authorities (username, authority)
VALUES
	('pablogarciamir', 'ROLE_ADMIN'),
	('dodo', 'ROLE_USER');
	
INSERT INTO projects_owners (id_user, id_project)
VALUES
	(1, 1),
	(2, 2);
	
INSERT INTO projects_tags (id_tag, id_project)
VALUES
	(4, 1),
	(5, 1),
	(5, 2);

INSERT INTO Rewards (id, id_project, name, amount, description, estimatedDelivery, limitAvailability)
VALUES
	(1, 1, 'Basic', 50, 'Basic features', CURRENT_TIMESTAMP, 0),
	(2, 1, 'Premium', 350, 'Advanced features', CURRENT_TIMESTAMP, 1);

INSERT INTO Pledges (id, id_user, id_reward)
VALUES
	(1, 1, 1),
	(2, 1, 2);