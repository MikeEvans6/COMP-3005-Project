//Sample data used for testing application

insert into customer values ('jimbob@gmail.com', 'Jim Bob', '42 Sim st Ottawa K0A1K0 Ontario', '4169235654', 'jim123');
insert into customer values ('tylerblair@gmail.com', 'Tyler Blair', '25 Oak st Fenelon Falls K0M1N0 Ontario', '4165343412', 'tyler345');
insert into customer values ('jonnymartin@gmail.com', 'Jonny Martin', '12 Second st Kitchener N0B2E0 Ontario', '7058392234', 'jonny213');

insert into publisher values ('Disney-Hyperion', '42 Disney dr', '7983102930', 'disney_hyperion@gmail.com', '0.00');
insert into publisher values ('HarperCollins Publishers', '33 Harper st', '7053224478', 'harper_collins@gmail.com', '0.00');
insert into publisher values ('Scholastic Inc', '34 Fourth st', '4162783493', 'scholastic_inc@gmail.com', '0.00');
insert into publisher values ('Little Simon', '34 Fake st', '4162712312', 'little_simon@gmail.com', '0.00');
insert into publisher values ('Ocra Book Publishers', '123 Fake st', '4162710821', 'orca_book@gmail.com', '0.00');

insert into book values ('9780261102217', 'The Hobbit', 'Fantasy', '2012', '10.99', '400', 'HarperCollins Publishers');
insert into book values ('9780261102354', 'The Lord of The Rings: The Fellowship Of The Ring', 'Fantasy', '2007', '10.99', '448', 'HarperCollins Publishers');
insert into book values ('9780261102361', 'The Lord of The Rings: The Two Towers', 'Fantasy', '2007', '10.99', '464', 'HarperCollins Publishers');
insert into book values ('9780261102378', 'The Lord of The Rings: The Return Of The King', 'Fantasy', '2007', '10.99', '464', 'HarperCollins Publishers');
insert into book values ('9780786838653', 'Percy Jackson And The Olympians: The Lightning Thief', 'Fantasy', '2006', '8.99', '416', 'Disney-Hyperion');
insert into book values ('9781423103349', 'Percy Jackson And The Olympians: The Sea Of Monsters', 'Fantasy', '2007', '8.99', '320', 'Disney-Hyperion');
insert into book values ('9781423101482', 'Percy Jackson And The Olympians: The Titans Curse', 'Fantasy', '2008', '8.99', '352', 'Disney-Hyperion');
insert into book values ('9781423101499', 'Percy Jackson And The Olympians: The Battle of The Labyrinth', 'Fantasy', '2009', '8.99', '400', 'Disney-Hyperion');
insert into book values ('9781423101505', 'Percy Jackson And The Olympians: The Last Olympian', 'Fantasy', '2011', '8.99', '432', 'Disney-Hyperion');
insert into book values ('9780545075527', 'You Are My Sunshine', 'Children', '2011', '7.99', '12', 'Scholastic Inc');
insert into book values ('9780545688864', 'I am a big brother', 'Children', '2015', '7.99', '24', 'Scholastic Inc');
insert into book values ('9780671493172', 'A to Z', 'Children', '1984', '6.99', '8', 'Little Simon');
insert into book values ('9780545518062', 'Twinkle Twinkle Little Star', 'Children', '2014', '7.99', '12', 'Scholastic Inc');
insert into book values ('9780008267124', 'Why I love my brother', 'Children', '2018', '12.99', '30', 'HarperCollins Publishers');
insert into book values ('9781459805798', 'Honeycomb', 'Teen', '2014', '9.95', '152', 'Ocra Book Publishers');
insert into book values ('9780062918055', 'The Upside of Halling', 'Teen', '2020', '16.49', '288', 'HarperCollins Publishers');

insert into author values ('Rick Riordan', '63 First st', '4167583123');
insert into author values ('J.R.R. Tolkien', '43 Tolkien st', '4167585321');
insert into author values ('Jimmie Davis', '34 Ten st', '4167581232');
insert into author values ('Caroline Jayne Church', '52 Dam st', '4167581232');
insert into author values ('Sandra Boynton', '43 Fake st', '4167523233');
insert into author values ('Daniel Howarth', '412 Fake st', '4167527893');
insert into author values ('Patricia Mccowen', '76 Fake st', '4167521282');
insert into author values ('Alex Light', '503 Fake st', '4167528198');

insert into written_by values ('9780786838653', 'Rick Riordan');
insert into written_by values ('9781423103349', 'Rick Riordan');
insert into written_by values ('9781423101482', 'Rick Riordan');
insert into written_by values ('9781423101499', 'Rick Riordan');
insert into written_by values ('9781423101505', 'Rick Riordan');
insert into written_by values ('9780261102217', 'J.R.R. Tolkien');
insert into written_by values ('9780261102354', 'J.R.R. Tolkien');
insert into written_by values ('9780261102361', 'J.R.R. Tolkien');
insert into written_by values ('9780261102378', 'J.R.R. Tolkien');
insert into written_by values ('9780545075527', 'Jimmie Davis');
insert into written_by values ('9780545688864', 'Caroline Jayne Church');
insert into written_by values ('9780671493172', 'Caroline Jayne Church');
insert into written_by values ('9780545518062', 'Caroline Jayne Church');
insert into written_by values ('9780008267124', 'Daniel Howarth');
insert into written_by values ('9781459805798', 'Patricia Mccowen');
insert into written_by values ('9780062918055', 'Alex Light');

insert into warehouse values ('4', '53 Centre dr K0A1V0 Ottawa Ontario', '4166134532');

insert into storage values ('4', '9780261102354', '30');
insert into storage values ('4', '9780261102361', '23');
insert into storage values ('4', '9780261102378', '37');
insert into storage values ('4', '9780261102217', '40');
insert into storage values ('4', '9780786838653', '15');
insert into storage values ('4', '9781423103349', '12');
insert into storage values ('4', '9781423101482', '19');
insert into storage values ('4', '9781423101499', '21');
insert into storage values ('4', '9781423101505', '29');
insert into storage values ('4', '9780545075527', '12');
insert into storage values ('4', '9780545688864', '67');
insert into storage values ('4', '9780671493172', '54');
insert into storage values ('4', '9780545518062', '36');
insert into storage values ('4', '9780008267124', '98');
insert into storage values ('4', '9781459805798', '29');
insert into storage values ('4', '9780062918055', '25');


