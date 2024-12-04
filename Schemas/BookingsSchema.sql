create table Bookings(
bookingid int primary key,
userid int not null,
slotid int not null,
isdeleted int not null
);