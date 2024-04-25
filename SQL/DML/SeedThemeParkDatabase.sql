-- Inserting values into the EMPLOYEE table with funny names and ages
INSERT INTO UNIVERSITY.EMPLOYEE (Ssn, Name, DateOfBirth)
VALUES 
    ('123456789', 'Bubbles McLaugherson', '2005-03-25'), -- Under 18
    ('234567890', 'Snickerdoodle Von Gigglesworth', '1998-11-10'),
    ('345678901', 'Sir Quacksalot', '1987-07-05'),
    ('456789012', 'Fanny Tickletush', '2003-09-15'),    -- Under 18
    ('567890123', 'Wanda Wonderpants', '1979-02-28'),
    ('678901234', 'Chuck McChuckles', '1982-06-20'),
    ('789012345', 'Dizzy Fizzlepop', '1995-08-12'),
    ('890123456', 'Binky Bumblebee', '2008-04-30'),      -- Under 18
    ('901234567', 'Professor Wafflebottom', '1973-12-07'),
    ('012345678', 'Captain Chuckleberry', '1980-10-03');

GO

-- Inserting data into the ATTRACTION table with attraction names from theme parks
INSERT INTO UNIVERSITY.ATTRACTION ([Name], [Description], BuildDate, Cost, Manager, DateStarted, IsAgeRestricted)
VALUES 
    ('Space Mountain', 'Thrilling indoor roller coaster through space-themed environment', '1977-05-27', 10000000, '234567890', '1977-05-27', 1),
    ('Pirates of the Caribbean', 'Boat ride through pirate-infested waters', '1967-03-18', 8000000, '345678901', '1967-03-18', 0),
    ('Haunted Mansion', 'Dark ride through a spooky haunted house', '1969-08-09', 7000000, '567890123', '1969-08-09', 0),
    ('Splash Mountain', 'Log flume ride based on characters from "Song of the South"', '1989-07-17', 12000000, '678901234', '1989-07-17', 1),
    ('Big Thunder Mountain Railroad', 'Wild west-themed roller coaster through an abandoned mine', '1979-09-02', 9000000, '789012345', '1979-09-02', 1),
    ('The Twilight Zone Tower of Terror', 'Elevator drop ride themed after the TV show "The Twilight Zone"', '1994-07-22', 15000000, '901234567', '1994-07-22', 1),
    ('it''ss a Small World', 'Boat ride featuring animatronic dolls representing various countries', '1966-05-28', 6000000, '012345678', '1966-05-28', 0),
    ('Expedition Everest', 'Thrilling roller coaster through the Himalayas', '2006-04-07', 18000000, '123456789', '2006-04-07', 1),
    ('Toy Story Mania!', 'Interactive 4D shooting gallery game based on the "Toy Story" films', '2008-05-31', 10000000, '456789012', '2008-05-31', 0),
    ('The Simpsons Ride', 'Simulated roller coaster ride through the world of "The Simpsons"', '2008-05-15', 11000000, '234567890', '2008-05-15', 1);

GO

-- Inserting records into ATTRACTIONHISTORY table
INSERT INTO UNIVERSITY.ATTRACTIONHISTORY (AttractionName, HistoryDate, [Description])
VALUES 
    ('Big Thunder Mountain Railroad', '1979-09-02', 'Wild west-themed roller coaster through an abandoned mine'),
    ('Expedition Everest', '2006-04-07', 'Thrilling roller coaster through the Himalayas'),
    ('Haunted Mansion', '1969-08-09', 'Dark ride through a spooky haunted house'),
    ('it''s a Small World', '1966-05-28', 'Boat ride featuring animatronic dolls representing various countries'),
    ('Pirates of the Caribbean', '1967-03-18', 'Boat ride through pirate-infested waters'),
    ('Space Mountain', '1977-05-27', 'Thrilling indoor roller coaster through space-themed environment'),
    ('Splash Mountain', '1989-07-17', 'Log flume ride based on characters from "Song of the South"'),
    ('The Simpsons Ride', '2008-05-15', 'Simulated roller coaster ride through the world of "The Simpsons"'),
    ('The Twilight Zone Tower of Terror', '1994-07-22', 'Elevator drop ride themed after the TV show "The Twilight Zone"'),
    ('Toy Story Mania!', '2008-05-31', 'Interactive 4D shooting gallery game based on the "Toy Story" films');

GO

-- Inserting records into RESTRICTION table
INSERT INTO UNIVERSITY.RESTRICTION (Id, [Name], [Description], AttractionName, StartDate, EndDate)
VALUES 
    (1, 'Height Restriction', 'Guests must be a minimum of 48 inches tall to ride.', 'Big Thunder Mountain Railroad', '2024-01-01', '2024-12-31'),
    (2, 'Age Restriction', 'Guests must be at least 7 years old to ride.', 'Space Mountain', '2024-01-01', '2024-12-31');


GO

-- Inserting records into AGERESTRICTION table
INSERT INTO UNIVERSITY.AGERESTRICTION (Id, MinAge)
VALUES 
    (2, 7);

GO

-- Inserting records into HEIGHTRESTRICTION table
INSERT INTO UNIVERSITY.HEIGHTRESTRICTION (Id, MinHeight)
VALUES 
    (1, 48);

GO

-- Inserting records into RIDER table
INSERT INTO UNIVERSITY.RIDER (Email, [Name], DateOfBirth, Height, Tickets)
VALUES 
    ('professorboyer@example.com', 'Professor Boyer', '1996-04-25', 70, 5),
    ('leonardodicaprio@example.com', 'Leonardo DiCaprio', '1980-11-11', 72, 20),
    ('angelinajolie@example.com', 'Angelina Jolie', '1975-06-04', 66, 15),
    ('bradpitt@example.com', 'Brad Pitt', '1963-12-18', 71, 18),
    ('natalieportman@example.com', 'Natalie Portman', '1981-06-09', 63, 12),
    ('nikolajokic@example.com', 'Nikola Jokic', '1995-02-19', 83, 10),
    ('jamalmurray@example.com', 'Jamal Murray', '1997-02-23', 76, 10),
    ('eminem@example.com', 'Eminem', '1972-10-17', 69, 15),
    ('snoopdogg@example.com', 'Snoop Dogg', '1971-10-20', 75, 15),
    ('drake@example.com', 'Drake', '1986-10-24', 72, 20),
    ('minime@example.com', 'Mini Me', '1978-08-24', 42, 5),
    ('brokebobby@example.com', 'Broke Bobby', '1990-03-15', 68, 3),
    ('youngsterjohnny@example.com', 'Youngster Johnny', '2019-09-01', 60, 5);