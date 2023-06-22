create table accounting_specialist
(
    id         bigint not null
        primary key,
    first_name varchar(255),
    last_name  varchar(255)
);

alter table accounting_specialist
    owner to postgres;

create table email
(
    id            bigint not null
        primary key,
    specialist_id bigint not null
        constraint fkbfcui8mgplr25tpcqo3806ne8
            references accounting_specialist,
    email_address varchar(255)
);

alter table email
    owner to postgres;

create table accounting_specialist_emails
(
    accounting_specialist_id bigint not null
        constraint fkk440sqmroa2bol5tk044o403l
            references accounting_specialist,
    emails_id                bigint not null
        unique
        constraint fk7xfvnn5nevmnbv6j32c2eluib
            references email
);

alter table accounting_specialist_emails
    owner to postgres;

create table invoice
(
    amount        double precision,
    id            bigint not null
        primary key,
    specialist_id bigint not null
        constraint fk9aupa05nmafagrj3gxvn3uog0
            references accounting_specialist,
    bill_no       varchar(255),
    product_name  varchar(255)
);

alter table invoice
    owner to postgres;

