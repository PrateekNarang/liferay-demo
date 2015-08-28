create table OH_Element (
	uuid_ VARCHAR(75) null,
	statusId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	statusName VARCHAR(75) null,
	statusValue VARCHAR(75) null
);

create table OH_Reports (
	uuid_ VARCHAR(75) null,
	statusId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	statusName VARCHAR(75) null,
	statusValue VARCHAR(75) null
);