create index IX_4C8A6AF2 on OH_Foo (field2);
create index IX_17DE29EE on OH_Foo (uuid_);
create index IX_697FF97A on OH_Foo (uuid_, companyId);
create unique index IX_63CC967C on OH_Foo (uuid_, groupId);

create index IX_DE850E86 on OH_Patients (field2);
create index IX_A8F6C3DA on OH_Patients (uuid_);
create index IX_FD02340E on OH_Patients (uuid_, companyId);
create unique index IX_A6046610 on OH_Patients (uuid_, groupId);