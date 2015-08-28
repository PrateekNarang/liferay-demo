create index IX_EC73B78D on OH_Element (statusName);
create index IX_8206E178 on OH_Element (uuid_);
create index IX_B95207B0 on OH_Element (uuid_, companyId);
create unique index IX_1618BA32 on OH_Element (uuid_, groupId);

create index IX_A2715910 on OH_Reports (statusName);
create index IX_151A15 on OH_Reports (uuid_);
create index IX_1AA33AF3 on OH_Reports (uuid_, companyId);
create unique index IX_6993E235 on OH_Reports (uuid_, groupId);