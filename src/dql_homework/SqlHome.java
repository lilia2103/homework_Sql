package dql_homework;

// creating the all tables!

create table Flights (
        flight_number INT PRIMARY KEY,
        origin VARCHAR(50) NOT NULL,
        destination VARCHAR(50) NOT NULL,
        departure_time DATE NOT NULL,
        arrival_time DATE NOT NULL
        );
        insert into Flights (flight_number, origin, destination, departure_time, arrival_time) values (1, 'Cahors-Lalbenque Airport', 'Socotra International Airport', '1/7/2023', '11/17/2022');
        insert into Flights (flight_number, origin, destination, departure_time, arrival_time) values (2, 'Mouyondzi Airport', 'Ürümqi Diwopu International Airport', '5/20/2022', '9/10/2022');
        insert into Flights (flight_number, origin, destination, departure_time, arrival_time) values (3, 'Hiva Oa-Atuona Airport', 'Sara Airport', '3/11/2023', '12/24/2022');
        insert into Flights (flight_number, origin, destination, departure_time, arrival_time) values (4, 'Al Thaurah Airport', 'Crane County Airport', '7/28/2022', '9/6/2022');
        insert into Flights (flight_number, origin, destination, departure_time, arrival_time) values (5, 'Hualien Airport', 'Chicken Airport', '9/30/2022', '6/12/2022');
        insert into Flights (flight_number, origin, destination, departure_time, arrival_time) values (6, 'Sparti Airport', 'Roberval Airport', '4/25/2022', '10/27/2022');
        insert into Flights (flight_number, origin, destination, departure_time, arrival_time) values (7, 'Daytona Beach International Airport', 'Destin Executive Airport', '9/26/2022', '1/28/2023');
        insert into Flights (flight_number, origin, destination, departure_time, arrival_time) values (8, 'Liangping Airport', 'Lidköping-Hovby Airport', '7/11/2022', '12/20/2022');
        insert into Flights (flight_number, origin, destination, departure_time, arrival_time) values (9, 'Salina Cruz Naval Air Station', 'Polokwane International Airport', '8/17/2022', '7/23/2022');
        insert into Flights (flight_number, origin, destination, departure_time, arrival_time) values (10, 'Skukuza Airport', 'Whiteriver Airport', '10/6/2022', '10/6/2022');



//------------------------------------------//


        create table Passengers (
        passenger_id INT PRIMARY KEY,
        name VARCHAR(50) NOT NULL,
        email VARCHAR(50) NOT NULL,
        phone_number VARCHAR(50) NOT NULL
        );
        insert into Passengers (passenger_id, name, email, phone_number) values (22, 'Aryn Cutchey', 'acutchey0@opensource.org', '366-233-4875');
        insert into Passengers (passenger_id, name, email, phone_number) values (39, 'Emmey Fairbrace', 'efairbrace1@goo.gl', '445-920-9642');
        insert into Passengers (passenger_id, name, email, phone_number) values (43, 'Amalia Helbeck', 'ahelbeck2@ibm.com', '222-972-8045');
        insert into Passengers (passenger_id, name, email, phone_number) values (46, 'Diannne Harbottle', 'dharbottle3@shinystat.com', '629-999-5466');
        insert into Passengers (passenger_id, name, email, phone_number) values (9, 'Andriette Volker', 'avolker4@go.com', '636-214-7250');
        insert into Passengers (passenger_id, name, email, phone_number) values (4, 'Gilligan Slorance', 'gslorance5@redcross.org', '995-638-0338');
        insert into Passengers (passenger_id, name, email, phone_number) values (23, 'Kelsi O''Sharry', 'kosharry6@umn.edu', '954-203-9763');
        insert into Passengers (passenger_id, name, email, phone_number) values (41, 'Abraham MacCostigan', 'amaccostigan7@shinystat.com', '591-365-5210');
        insert into Passengers (passenger_id, name, email, phone_number) values (11, 'Shepperd Machel', 'smachel8@illinois.edu', '655-580-1041');
        insert into Passengers (passenger_id, name, email, phone_number) values (17, 'Dal Sweett', 'dsweett9@bizjournals.com', '423-990-8419');



//---------------------------//


        create table Bookings (
        booking_id INT PRIMARY KEY,
        flight_number INT NOT NULL,
        passenger_id INT NOT NULL,
        booking_date DATE NOT NULL,
        cost DECIMAL(10,2) NOT NULL,
        FOREIGN KEY (flight_number) REFERENCES Flights(flight_number),
        FOREIGN KEY (passenger_id) REFERENCES Passengers(passenger_id)
        );

        insert into Bookings(booking_id, flight_number, passenger_id, booking_date, cost ) values (1, 1, 22, '1/7/2023', 250.00);
        insert into Bookings(booking_id, flight_number, passenger_id, booking_date, cost ) values (10, 2, 39, '2/11/2022', 300.00);
        insert into Bookings(booking_id, flight_number, passenger_id, booking_date, cost ) values (12, 3, 43, '7/4/2023', 1000.00);
        insert into Bookings(booking_id, flight_number, passenger_id, booking_date, cost ) values (3, 4, 46, '8/4/2022', 275.00);
        insert into Bookings(booking_id, flight_number, passenger_id, booking_date, cost ) values (4, 5, 9, '11/7/2023', 300.00);
        insert into Bookings(booking_id, flight_number, passenger_id, booking_date, cost ) values (99, 6, 4, '12/7/2023', 1400.00);
        insert into Bookings(booking_id, flight_number, passenger_id, booking_date, cost ) values (77, 7, 23, '8/6/2022', 270.00);
        insert into Bookings(booking_id, flight_number, passenger_id, booking_date, cost ) values (69, 8, 41, '2/7/2022', 150.00);
        insert into Bookings(booking_id, flight_number, passenger_id, booking_date, cost ) values (96, 9, 11, '11/17/2022', 250.00);
        insert into Bookings(booking_id, flight_number, passenger_id, booking_date, cost ) values (47, 10, 17, '6/6/2023', 250.00);



// 1.Retrieve the average cost of all bookings made on the airline.

        select AVG(cost) as average_cost
        from Bookings;


// 2.Retrieve the total number of flights that have departed from each origin airport.


        select origin, COUNT(*) as count
        from Flights
        group by origin;

// 3.Retrieve the total number of flights that have arrived at each destination airport.

        select destination, COUNT(*) as count
        from Flights
        group by destination;

// 4.Retrieve the total number of passengers who have booked flights departing from each origin airport.

        select Flights.origin, COUNT(Bookings.passenger_id) as passenger_number
        from Flights
        join Bookings  on Flights.flight_number = Bookings.flight_number
        group by Flights.origin;


// 5.Retrieve the average cost of flights departing from each origin airport.

        select origin, AVG(Bookings.cost) as average_cost
        from Flights
        join Bookings on Flights.flight_number = Bookings.flight_number
        group by origin

// 6.Retrieve the total number of passengers who have booked flights departing from each origin airport, but only for airports
        with an average cost per passenger of less than $200.

        select Flights.origin, COUNT(Bookings.passenger_id) as passenger_number
        from Flights
        join Bookings on Flights.flight_number = Bookings.flight_number
        group by Flights.origin
        having AVG(Bookings.cost) < 250

// 7. Retrieve the total revenue generated by the airline, grouped by month.

        select DATE_TRUNC('month', booking_date) as month, SUM(cost) as total_of_revenue
        from Bookings
        group by month;

// 8. Retrieve the average number of passengers per flight for each origin airport, but only for airports that have more than 5
        departures.

        select Flights.origin, count(CAST(Bookings.passenger_id is not null as integer)) as passenger_avg_per_flight
        from Flights
        left join Bookings on Flights.flight_number = Bookings.flight_number
        group by Flights.origin
        having COUNT(*) > 1;

// 9.Retrieve the top 10 most popular destination airports, based on the total number of passengers who have booked flights to each
        destination.

        select Flights.destination, COUNT(Bookings.passenger_id) as total_passengers
        from Flights
        inner join Bookings on Flights.flight_number = Bookings.flight_number
        group by Flights.destination
        order by total_passengers desc
        limit 2;