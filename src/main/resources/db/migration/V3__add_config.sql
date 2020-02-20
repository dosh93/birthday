create table public.config
(
    key text not null
        constraint config_pk
            primary key,
    value text not null
);

INSERT INTO public.config (key, value) VALUES ('dayTo', '14');
INSERT INTO public.config (key, value) VALUES ('dayAfter', '3');

