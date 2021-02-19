create database QuanLyKhachSan
go
use QuanLyKhachSan
go

create table tblCategoryRoom(
	id int identity(1,1) primary key not null,
	name nvarchar(255) not null,
	price float not null
)
go

INSERT INTO tblCategoryRoom(name, price) VALUES('Phòng đơn', 370000)
INSERT INTO tblCategoryRoom(name, price) VALUES('Phòng đôi', 400000)


-----------
-----------
create table tblRoom(
	roomId int identity(1,1) primary key not null,
	typeId int foreign key references tblCategoryRoom(id) not null,
	image nvarchar(255) null,
	descript text null,
	status tinyint default(0)
)
go

ALTER TABLE tblRoom
ADD UNIQUE (roomId);
go




-----------
-----------


create table tblLevel(
	id int identity(1,1) primary key not null,
	name nvarchar(255) not null
)
go

INSERT INTO tblLevel(name) VALUES('Admin')
INSERT INTO tblLevel(name) VALUES('Nhân viên')


-----------
-----------
create table tblUser(
	id int primary key identity(1,1) not null,
	username nvarchar(255) not null,
	password nvarchar(255) not null,
	levelId int foreign key references tblLevel(id) not null,
	fullname nvarchar(255) not null,
	phone nvarchar(255) null,
	address nvarchar(255) null,
	image nvarchar(255) null,
	gender bit null,
	birthday date null,
	descript text null,
	status tinyint default(0),
	startDate date not null,
	endDate date null,
	isLogin bit default(0) 
)
go


INSERT INTO tblUser(username, password, levelId, fullname, startDate, endDate) VALUES('congTua', '123456', 1, 'Công Chúa', GETDATE(), GETDATE())
INSERT INTO tblUser(username, password, levelId, fullname, startDate, endDate) VALUES('hoangTu', '123456', 1, 'Hoàng Tử', GETDATE(), GETDATE())



-----------
-----------
create table tblCustomer(
	id int identity(1,1) not null,
	phone nvarchar(255) primary key not null,
	fullname nvarchar(255) not null,
	email nvarchar(255) null,
	address nvarchar(255) null,
	gender bit null,
	numIdentityCard nvarchar(13) not null,
	descript text null,
	createdAt date not null,
	updatedAt date not null
)
go


ALTER TABLE tblCustomer
ADD UNIQUE (phone);

INSERT INTO tblCustomer(phone, fullname, numIdentityCard, createdAt, updatedAt) VALUES('0354422847', 'Kang Daniel', '12789546', GETDATE(), GETDATE())
INSERT INTO tblCustomer(phone, fullname, numIdentityCard, createdAt, updatedAt) VALUES('0156452205', 'Donal Trump', '56015500', GETDATE(), GETDATE())



-----------
-----------
create table tblCupon(
	id int primary key identity(1,1) not null,
	name nvarchar(255) not null,
	discount float not null,
	maxQuantity int null,
	descript text null,
	status tinyint default(0) not null,
	startDate date null,
	endDate date null,
	createdAt date not null,
	updatedAt date not null
)
go

INSERT INTO tblCupon(name, discount, maxQuantity, startDate, endDate, createdAt, updatedAt) VALUES('Tri ân khách hàng', 25, 50, null, null, GETDATE(), GETDATE())



-----------
-----------
create table tblCheckin(
	id int identity(1,1) primary key not null,
	cusPhone nvarchar(255) foreign key references tblCustomer(phone) not null,
	totalPeople int not null,
	cuponId int foreign key references tblCupon(id) not null,
	pricePaymentAdvance float not null,
	totalMoney float not null,
	totalServicePrice float not null,
	descript text null,
)
go



-----------
-----------
create table tblCheckinDetails(
	detailId int identity(1,1) primary key not null,
	checkinId int foreign key references tblCheckin(id),
	roomId int foreign key references tblRoom(roomId) not null,
	totalServicePrice float default(0) not null,
	price float not null,
	exPrice float null,
	subPrice float null,
	startDate date not null,
	endDate date not null,
	status tinyint default(1) not null
)
go


create table tblCategoryService(
	id int primary key identity(1,1) not null,
	name nvarchar(255) not null
)
go

create table tblUnit(
	id int primary key identity(1,1) not null,
	name nvarchar(255) not null
)
go


create table tblService(
	id int primary key identity(1,1) not null,
	name nvarchar(255) not null,
	inputPrice float null,
	price float not null,
	unit int foreign key references tblUnit(id) not null,
	catService int foreign key references tblCategoryService(id) not null
)
go


create table tblCheckinServiceDetails(
	idServicee int foreign key references tblService(id) not null,
	idCheckinDetails int foreign key references tblCheckinDetails(detailId),
	quantity int not null,
	price float not null
)
go


create table tblProduct(
	id int primary key identity(1,1) not null,
	name nvarchar(255) not null,
	quantity int not null
)
go


create table tblCheckoutProductDetails(
	model nvarchar(255) primary key not null,
	proId int foreign key references tblProduct(id) not null,
	roomId int foreign key references tblRoom(roomId) not null,
	descript text null,
	status tinyint default(0)
)
go

--------------------------------
-- CREATE PROCEDURE 
--------------------------------



-- PROC tblCategoryService

create proc categoryService_findAll
as
begin
	select * from tblCategoryService
end
go

create proc categoryService_insert(@name nvarchar(255))
as
begin
	insert into tblCategoryService(name) values(@name)
end
go

create proc categoryService_delete(@id int)
as
begin
	delete from tblCategoryService where id = @id
end
go

create proc categoryService_update(@id int, @name nvarchar(255))
as
begin
	update tblCategoryService set name=@name where id = @id
end
go

create proc categoryService_findByName(@name nvarchar(255))
as
begin
	select * from tblCategoryService where name like '%' + @name + '%'
end
go 



-- PROC tblUser

create proc user_insert(@username nvarchar(255),
						@password nvarchar(255),
						@fullname nvarchar(255),
						@levelId int,
						@phone nvarchar(255),
						@address nvarchar(255),
						@image nvarchar(255),
						@gender bit,
						@birthday date,
						@descript text,
						@startDate date,
						@endDate date,
						@status tinyint)
as
begin
	insert into tblUser(username, password, fullname, levelId, phone, address, image, gender, birthday, descript, startDate, endDate, status)
	values(@username, @password, @fullname, @levelId, @phone, @address, @image, @gender, @birthday, @descript, @startDate, @endDate, @status)
end
go


create proc user_update(@id int,
						@username nvarchar(255),
						@password nvarchar(255),
						@fullname nvarchar(255),
						@levelId int,
						@phone nvarchar(255),
						@address nvarchar(255),
						@image nvarchar(255),
						@gender bit,
						@birthday date,
						@descript text,
						@startDate date,
						@endDate date,
						@status tinyint)
as
begin
	update tblUser set username=@username, password=@password, fullname=@fullname, levelId=@levelId, phone=@phone, address=@address, image=@image, 
	gender=@gender, birthday=@birthday, descript=@descript, startDate=@startDate, endDate=@endDate, status=@status
	where id=@id
end
go


create proc user_delete(@id int)
as
begin
	delete from tblUser where id=@id
end
go


create proc user_findAll
as
begin
	select * from tblUser
end
go



create proc user_findByUsername(@username nvarchar(255))
as
begin
	select * from tblUser where username like '%' + @username + '%'
end
go


create proc user_findByFullname(@fullname nvarchar(255))
as
begin
	select * from tblUser where fullname like '%' + @fullname + '%'
end
go


create proc user_findByPhone(@phone nvarchar(255))
as
begin
	select * from tblUser where username like '%' + @phone + '%'
end
go


create proc user_updateAccount(@id int,
								@fullname nvarchar(255),
								@phone nvarchar(255),
								@username nvarchar(255),
								@image nvarchar(255),
								@password nvarchar(255),
								@address nvarchar(255),
								@gender bit,
								@birthday date)
as
begin
	update tblUser set fullname=@fullname, username=@username, image=@image, phone=@phone, password=@password, address=@address, gender=@gender, birthday=@birthday
	where id=@id
end
go
					



-- PROC tblRoom

create proc room_delete(@roomId int)
as
begin
	delete from tblRoom where roomId=@roomId
end
go

create proc room_update(@roomId int,
						@typeId int,
						@image nvarchar(255),
						@descript text,
						@status tinyint)
as
begin
	update tblRoom set typeId=@typeId, image=@image, descript=@descript, status=@status
	where roomId=@roomId
end
go

create proc room_ChangeStatus(@roomId int,
						@status tinyint)
as
begin
	update tblRoom set status=@status
	where roomId=@roomId
end
go

create proc room_findAll
as
begin
	select * from tblRoom
end
go


create proc room_findByRoomId(@roomId int)
as
begin
	select * from tblRoom where roomId=@roomId
end
go


create proc room_findByStatus(@status int)
as
begin
	select * from tblRoom where status=@status
end
go



-- PROC tblProduct

create proc product_insert(	@name nvarchar(255),
							@quantity int)
as
begin
	insert into tblProduct(name, quantity) values(@name, @quantity)
end
go


create proc product_delete(@id int)
as
begin
	delete from tblProduct where id=@id
end
go

create proc product_update(@id int,
							@name nvarchar(255),
							@quantity int)
as
begin
	update tblProduct set name=@name, quantity=@quantity where id=@id
end
go

create proc product_findAll
as
begin
	select * from tblProduct
end
go


create proc product_findByName(@name nvarchar(255))
as
begin
	select * from tblProduct where name like '%' + @name + '%'
end
go



-- PROC tblCustomer

create proc customer_insert(@phone nvarchar(255),
							@fullname nvarchar(255),
							@email nvarchar(255),
							@address nvarchar(255),
							@gender bit,
							@numIdentityCard nvarchar(13),
							@descript text,
							@createdAt date,
							@updatedAt date)
as
begin
	insert into tblCustomer(phone, fullname, email, address, gender, numIdentityCard, descript, createdAt, updatedAt)
	values(@phone, @fullname, @email, @address, @gender, @numIdentityCard, @descript, @createdAt, @updatedAt)
end
go


create proc customer_delete(@phone nvarchar(255))
as
begin
	delete from tblCustomer where phone=@phone
end
go


create proc customer_update(@phone nvarchar(255),
							@fullname nvarchar(255),
							@email nvarchar(255),
							@address nvarchar(255),
							@gender bit,
							@numIdentityCard nvarchar(13),
							@descript text,
							@createdAt date,
							@updatedAt date)
as
begin
	update tblCustomer set fullname=@fullname, email=@email, address=@address, gender=@gender, numIdentityCard=@numIdentityCard,
							descript=@descript, createdAt=@createdAt, updatedAt=@updatedAt
	where phone=@phone
end
go


create proc customer_findAll
as
begin
	select * from tblCustomer
end
go


create proc customer_findByPhone(@phone nvarchar(255))
as
begin
	select * from tblCustomer where phone like '%' + @phone + '%'
end
go


create proc customer_findByNumIdentityCard(@numIdentityCard nvarchar(255))
as
begin
	select * from tblCustomer where numIdentityCard like '%' + @numIdentityCard + ''
end
go



-- PROC tblCupon

create proc cupon_insert(@name nvarchar(255),
						@discount float,
						@maxQuantity int,
						@status bit,
						@descript nvarchar(255),
						@startDate date,
						@endDate date,
						@createdAt date,
						@updatedAt date)
as
begin
	insert into tblCupon(name, discount, maxQuantity, status. descript, startDate, endDate, createdAt, updatedAt)
	values(@name, @discount, @maxQuantity, @status, @descript, @startDate, @endDate, @createdAt, @updatedAt)
end
go


create proc cupon_update(@id int,
						@name nvarchar(255),
						@discount float,
						@maxQuantity int,
						@status bit,
						@descript nvarchar(255),
						@startDate date,
						@endDate date,
						@createdAt date,
						@updatedAt date)
as
begin
	update tblCupon set name=@name, discount=@discount, maxQuantity=@maxQuantity, status=@status, descript=@descript, 
						startDate=@startDate, endDate=@endDate, createdAt=@createdAt, updatedAt=@updatedAt
	where id=@id
end
go


create proc cupon_delete(@id int)
as
begin
	delete from tblCupon where id=@id
end
go


create proc cupon_findAll
as
begin
	select * from tblCupon
end
go


create proc cupon_findByName(@name nvarchar(255))
as
begin
	select * from tblCupon where name like '%' + @name + '%'
end
go


create proc cupon_findByStatus(@status int)
as
begin
	select * from tblCupon where status=@status
end
go

create proc cupon_findByNameAndStatus(@name nvarchar(255), @status int)
as
begin
	select * from tblCupon where name=@name and status=@status
end
go


create proc cupon_updateStatus(@id int, @status int)
as	
begin
	update tblCupon set status=@status where id=@id
end
go


-- PROC tblCheckin


create proc checkin_delete(@id int)
as
begin
	delete from tblCheckin where id=@id
end
go

create proc checkin_findAll
as
begin
	select * from tblCheckin
end
go

create proc checkin_findById(@id int)
as
begin
	select * from tblCheckin
	where id = @id
end
go



-- PROC tblService

create proc service_insert(@name nvarchar(255),
							@inputPrice float,
							@price float,
							@unit int,
							@catService int)
as
begin
	insert into tblService(name, inputPrice, price, unit, catService) values(@name, @inputPrice, @price, @unit, @catService)
end
go


create proc service_delete(@id int)
as
begin
	delete from tblService where id=@id
end
go


create proc service_update(@id int,
							@name nvarchar(255),
							@inputPrice float,
							@price float,
							@unit int,
							@catService int)
as
begin
	update tblService 
	set name=@name, inputPrice=@inputPrice, price=@price, unit=@unit, catService=@catService 
	where id=@id
end
go


create proc service_findAll
as
begin
	select * from tblService
end
go


create proc service_findByName(@name nvarchar(255))
as
begin
	select * from tblService where name like '%' + @name + '%'
end
go

create proc service_findByServiceId(@id int)
as
begin
	select * from tblService where id=@id
end
go




-- PROC tblCheckinDetails



create proc checkinDetails_delete(@detailId int)
as
begin
	delete from tblCheckinDetails where detailId=@detailId
end
go


create proc checkinDetails_findByDetailId(@detailId int)
as
begin
	select * from tblCheckinDetails where detailId=@detailId
end
go

create proc checkinDetails_findAllByStatus(@status int)
as
begin
	select * from tblCheckinDetails where "status" = @status
end
go

create proc findIdCheckinDetailByIdRoom(@idR int, @status tinyint)
as
begin
	select * from tblCheckinDetails where roomId = @idR and "status" = @status
end
go

create proc checkinDetails_ChangeStatus(@id int, @status tinyint)
as
begin
	update tblCheckinDetails
	set status = @status
	where detailId = @id
end
go


create proc checkinDetails_findAll
as
begin
	select * from tblCheckinDetails
end
go



-- PROC tblLevel

create proc level_findAll
as
begin
	select * from tblLevel
end
go

create proc level_findByName(@name nvarchar(255))
as
begin
	select * from tblLevel where name like '%' + @name + '%'
end
go


create proc level_insert(@name nvarchar(255))
as
begin
	insert into tblLevel(name) values(@name)
end
go


create proc level_update(@id int, @name nvarchar(255))
as
begin
	update tblLevel set name=@name where id=@id
end
go


create proc level_delete(@id int)
as
begin
	delete from tblLevel where id=@id
end
go



-- PROC tblUnit

create proc unit_findAll
as
begin
	select * from tblUnit
end
go


create proc unit_insert(@name nvarchar(255))
as
begin
	insert into tblUnit(name) values(@name)
end
go

create proc unit_delete(@id int)
as
begin
	delete from tblUnit where id = @id
end
go

create proc unit_update(@id int, @name nvarchar(255))
as
begin
	update tblUnit set name=@name where id = @id
end
go


create proc unit_findByName(@name nvarchar(255))
as
begin
	select * from tblUnit where name like '%' + @name + '%'
end
go


-- PROC tblCategoryRoom
create proc categoryRoom_findAll
as
begin
	select * from tblCategoryRoom
end
go


create proc categoryRoom_insert(@name nvarchar(255), 
								@price float)
as
begin
	insert into tblCategoryRoom(name, price) values(@name, @price)
end
go


create proc categoryRoom_delete(@id int)
as
begin
	delete from tblCategoryRoom where id=@id
end
go


create proc categoryRoom_update(@id int,
								@name nvarchar(255), 
								@price float)
as
begin
	update tblCategoryRoom set name=@name, price=@price 
	where id=@id
end
go

create proc category_findByCateRoomId(@id int)
as
begin
	select * from tblCategoryRoom where id=@id
end
go


-- Login/ Logout
create proc login(@username nvarchar(255), @password nvarchar(255))
as
begin 
	select * from tblUser
	where username = @username and password = @password
end
go

create proc isLogin(@username nvarchar(255), @status bit)
as
begin
	update tblUser
	set islogin = @status
	where username = @username
end
go



-- PROC tblCheckoutProductDetails

create proc checkoutProductDetails_add(@model nvarchar(255),
										@proId int,
										@roomId int,
										@descript text,
										@status tinyint)
as
begin
	insert into tblCheckoutProductDetails(model, proId, roomId, descript, status)
	values(@model, @proId, @roomId, @descript, @status)
end
go


create proc checkoutProductDetails_findByRoomId(@roomId int)
as
begin
	select * from tblCheckoutProductDetails where roomId=@roomId
end
go


create proc checkoutProductDetails_delete(@roomId int)
as
begin
	delete from tblCheckoutProductDetails where roomId = @roomId
end
go


create proc checkoutProductDetails_findByModel(@model nvarchar(255), @roomId int)
as
begin
	select * from tblCheckoutProductDetails where model like '%' + @model + '%' and roomId=@roomId
end
go



-- PROC tblCheckoutSeriviceDetails

create proc checkinServiceDetail_insert(@idService int,
										@idCheckinDetails int,
										@quantity int,
										@price float)
as
begin
	insert into tblCheckinServiceDetails(idServicee, idCheckinDetails, quantity, price)
	values(@idService, @idCheckinDetails, @quantity, @price)
end
go


create proc checkinServiceDetail_delete(@idService int)
as
begin
	delete from tblCheckinServiceDetails where idServicee=@idService
end
go

create proc checkinServiceDetail_update(@idService int,
										@quantity int)
as
begin
	update tblCheckinServiceDetails set  quantity=@quantity where idServicee=@idService
end
go

create proc checkinServiceDetail_findAll
as
begin
	select * from tblCheckinServiceDetails
end
go

create proc checkinServiceDetail_findObjByIdCheckinDetail(@idCheckinDetail int)
as
begin
	select * from tblCheckinServiceDetails
	where idCheckinDetails = @idCheckinDetail
end
go

