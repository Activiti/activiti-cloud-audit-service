create table audit_event
(
    type                       varchar(31) not null,
    id                         bigint      not null,
    app_name                   varchar(255),
    app_version                varchar(255),
    business_key               varchar(255),
    entity_id                  varchar(255),
    event_id                   varchar(255),
    event_type                 varchar(255),
    message_id                 varchar(255),
    parent_process_instance_id varchar(255),
    process_definition_id      varchar(255),
    process_definition_key     varchar(255),
    process_instance_id        varchar(255),
    sequence_number            integer     not null,
    service_full_name          varchar(255),
    service_name               varchar(255),
    service_type               varchar(255),
    service_version            varchar(255),
    timestamp                  bigint,
    bpmn_activity              text,
    cause                      varchar(255),
    error                      text,
    flow_node_id               varchar(255),
    integration_context_id     varchar(255),
    message                    text,
    process_instance           text,
    process_definition         text,
    sequence_flow              text,
    signal                     text,
    task                       text,
    task_id                    varchar(255),
    task_name                  varchar(255),
    candidate_group            text,
    candidate_user             text,
    timer                      text,
    variable_instance          text,
    variable_name              varchar(255),
    variable_type              varchar(255),
    primary key (id)
) engine=MyISAM;
create table audit_sequence
(
    next_val bigint
) engine=MyISAM;
insert into audit_sequence
values (1);
