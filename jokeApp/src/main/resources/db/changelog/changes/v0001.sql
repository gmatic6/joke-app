CREATE TABLE "category"
(
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    CONSTRAINT category_pkey PRIMARY KEY (id)
)


CREATE TABLE "joke"
(
    id integer NOT NULL,
    category character varying(255) NOT NULL references category (name),
    content character varying(255) NOT NULL,
    dislikes integer NOT NULL,
    likes integer NOT NULL,
    CONSTRAINT joke_pkey PRIMARY KEY (id)
)
