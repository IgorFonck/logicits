--
-- PostgreSQL database dump
--

-- Dumped from database version 11.4
-- Dumped by pg_dump version 11.4

-- Started on 2019-10-02 22:20:54

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 203 (class 1259 OID 16426)
-- Name: apoioconceito; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.apoioconceito (
    cod_apoio_conceito integer NOT NULL,
    conteudo_apoio_conceito character varying(255),
    fk_conceito_cod_conceito integer
);


ALTER TABLE public.apoioconceito OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16424)
-- Name: apoioconceito_cod_apoio_conceito_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.apoioconceito_cod_apoio_conceito_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.apoioconceito_cod_apoio_conceito_seq OWNER TO postgres;

--
-- TOC entry 2953 (class 0 OID 0)
-- Dependencies: 202
-- Name: apoioconceito_cod_apoio_conceito_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.apoioconceito_cod_apoio_conceito_seq OWNED BY public.apoioconceito.cod_apoio_conceito;


--
-- TOC entry 211 (class 1259 OID 16464)
-- Name: apoiomateria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.apoiomateria (
    cod_apoio_materia integer NOT NULL,
    conteudo_apoio_materia character varying(255),
    fk_materia_cod_materia integer
);


ALTER TABLE public.apoiomateria OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16462)
-- Name: apoiomateria_cod_apoio_materia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.apoiomateria_cod_apoio_materia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.apoiomateria_cod_apoio_materia_seq OWNER TO postgres;

--
-- TOC entry 2954 (class 0 OID 0)
-- Dependencies: 210
-- Name: apoiomateria_cod_apoio_materia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.apoiomateria_cod_apoio_materia_seq OWNED BY public.apoiomateria.cod_apoio_materia;


--
-- TOC entry 209 (class 1259 OID 16456)
-- Name: apoionocao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.apoionocao (
    cod_apoio_nocao integer NOT NULL,
    conteudo_apoio_nocao character varying(255),
    fk_nocao_cod_nocao integer
);


ALTER TABLE public.apoionocao OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16454)
-- Name: apoionocao_cod_apoio_nocao_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.apoionocao_cod_apoio_nocao_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.apoionocao_cod_apoio_nocao_seq OWNER TO postgres;

--
-- TOC entry 2955 (class 0 OID 0)
-- Dependencies: 208
-- Name: apoionocao_cod_apoio_nocao_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.apoionocao_cod_apoio_nocao_seq OWNED BY public.apoionocao.cod_apoio_nocao;


--
-- TOC entry 201 (class 1259 OID 16418)
-- Name: atividade; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.atividade (
    cod_atividade integer NOT NULL,
    premissas character varying(255),
    conclusao character varying(50)
);


ALTER TABLE public.atividade OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16416)
-- Name: atividade_cod_atividade_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.atividade_cod_atividade_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.atividade_cod_atividade_seq OWNER TO postgres;

--
-- TOC entry 2956 (class 0 OID 0)
-- Dependencies: 200
-- Name: atividade_cod_atividade_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.atividade_cod_atividade_seq OWNED BY public.atividade.cod_atividade;


--
-- TOC entry 219 (class 1259 OID 16496)
-- Name: avaliacao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.avaliacao (
    fk_estudante_cod_estudante integer,
    fk_atividade_cod_atividade integer,
    cod_avaliacao integer NOT NULL,
    nota real,
    fg_concluido boolean
);


ALTER TABLE public.avaliacao OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16494)
-- Name: avaliacao_cod_avaliacao_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.avaliacao_cod_avaliacao_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.avaliacao_cod_avaliacao_seq OWNER TO postgres;

--
-- TOC entry 2957 (class 0 OID 0)
-- Dependencies: 218
-- Name: avaliacao_cod_avaliacao_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.avaliacao_cod_avaliacao_seq OWNED BY public.avaliacao.cod_avaliacao;


--
-- TOC entry 217 (class 1259 OID 16488)
-- Name: complexidade; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.complexidade (
    fk_conceito_cod_conceito integer,
    fk_atividade_cod_atividade integer,
    cod_complexidade integer NOT NULL,
    valor integer
);


ALTER TABLE public.complexidade OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16486)
-- Name: complexidade_cod_complexidade_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.complexidade_cod_complexidade_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.complexidade_cod_complexidade_seq OWNER TO postgres;

--
-- TOC entry 2958 (class 0 OID 0)
-- Dependencies: 216
-- Name: complexidade_cod_complexidade_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.complexidade_cod_complexidade_seq OWNED BY public.complexidade.cod_complexidade;


--
-- TOC entry 199 (class 1259 OID 16407)
-- Name: conceito; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.conceito (
    cod_conceito integer NOT NULL,
    nome_conceito character varying(50),
    lista_ant_conceito character varying(255),
    lista_prox_conceito character varying(255),
    fk_nocao_cod_nocao integer
);


ALTER TABLE public.conceito OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16405)
-- Name: conceito_cod_conceito_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.conceito_cod_conceito_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.conceito_cod_conceito_seq OWNER TO postgres;

--
-- TOC entry 2959 (class 0 OID 0)
-- Dependencies: 198
-- Name: conceito_cod_conceito_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.conceito_cod_conceito_seq OWNED BY public.conceito.cod_conceito;


--
-- TOC entry 207 (class 1259 OID 16445)
-- Name: estudante; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estudante (
    cod_estudante integer NOT NULL,
    nome character varying(50),
    idade integer,
    genero character varying(50),
    estado_atual character varying(255),
    caminho_seguido character varying(255),
    tabela_conceitos character varying(255)
);


ALTER TABLE public.estudante OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16443)
-- Name: estudante_cod_estudante_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.estudante_cod_estudante_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estudante_cod_estudante_seq OWNER TO postgres;

--
-- TOC entry 2960 (class 0 OID 0)
-- Dependencies: 206
-- Name: estudante_cod_estudante_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estudante_cod_estudante_seq OWNED BY public.estudante.cod_estudante;


--
-- TOC entry 215 (class 1259 OID 16480)
-- Name: interacao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.interacao (
    cod_interacao integer NOT NULL,
    tipo character varying(50),
    obs character varying(255),
    data timestamp without time zone,
    fk_atividade_cod_atividade integer,
    fk_estudante_cod_estudante integer
);


ALTER TABLE public.interacao OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16478)
-- Name: interacao_cod_interacao_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.interacao_cod_interacao_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.interacao_cod_interacao_seq OWNER TO postgres;

--
-- TOC entry 2961 (class 0 OID 0)
-- Dependencies: 214
-- Name: interacao_cod_interacao_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.interacao_cod_interacao_seq OWNED BY public.interacao.cod_interacao;


--
-- TOC entry 205 (class 1259 OID 16434)
-- Name: materia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.materia (
    cod_materia integer NOT NULL,
    nome_materia character varying(50),
    lista_ant_materia character varying(255),
    lista_prox_materia character varying(255)
);


ALTER TABLE public.materia OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16432)
-- Name: materia_cod_materia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.materia_cod_materia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.materia_cod_materia_seq OWNER TO postgres;

--
-- TOC entry 2962 (class 0 OID 0)
-- Dependencies: 204
-- Name: materia_cod_materia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.materia_cod_materia_seq OWNED BY public.materia.cod_materia;


--
-- TOC entry 197 (class 1259 OID 16396)
-- Name: nocao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nocao (
    cod_nocao integer NOT NULL,
    nome_nocao character varying(50),
    lista_ant_nocao character varying(255),
    lista_prox_nocao character varying(255),
    fk_materia_cod_materia integer
);


ALTER TABLE public.nocao OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16394)
-- Name: nocao_cod_nocao_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.nocao_cod_nocao_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nocao_cod_nocao_seq OWNER TO postgres;

--
-- TOC entry 2963 (class 0 OID 0)
-- Dependencies: 196
-- Name: nocao_cod_nocao_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.nocao_cod_nocao_seq OWNED BY public.nocao.cod_nocao;


--
-- TOC entry 213 (class 1259 OID 16472)
-- Name: solucao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.solucao (
    cod_solucao integer NOT NULL,
    sequencia character varying(255),
    fk_atividade_cod_atividade integer
);


ALTER TABLE public.solucao OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16470)
-- Name: solucao_cod_solucao_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.solucao_cod_solucao_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.solucao_cod_solucao_seq OWNER TO postgres;

--
-- TOC entry 2964 (class 0 OID 0)
-- Dependencies: 212
-- Name: solucao_cod_solucao_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.solucao_cod_solucao_seq OWNED BY public.solucao.cod_solucao;


--
-- TOC entry 2758 (class 2604 OID 16429)
-- Name: apoioconceito cod_apoio_conceito; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.apoioconceito ALTER COLUMN cod_apoio_conceito SET DEFAULT nextval('public.apoioconceito_cod_apoio_conceito_seq'::regclass);


--
-- TOC entry 2762 (class 2604 OID 16467)
-- Name: apoiomateria cod_apoio_materia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.apoiomateria ALTER COLUMN cod_apoio_materia SET DEFAULT nextval('public.apoiomateria_cod_apoio_materia_seq'::regclass);


--
-- TOC entry 2761 (class 2604 OID 16459)
-- Name: apoionocao cod_apoio_nocao; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.apoionocao ALTER COLUMN cod_apoio_nocao SET DEFAULT nextval('public.apoionocao_cod_apoio_nocao_seq'::regclass);


--
-- TOC entry 2757 (class 2604 OID 16421)
-- Name: atividade cod_atividade; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atividade ALTER COLUMN cod_atividade SET DEFAULT nextval('public.atividade_cod_atividade_seq'::regclass);


--
-- TOC entry 2766 (class 2604 OID 16499)
-- Name: avaliacao cod_avaliacao; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.avaliacao ALTER COLUMN cod_avaliacao SET DEFAULT nextval('public.avaliacao_cod_avaliacao_seq'::regclass);


--
-- TOC entry 2765 (class 2604 OID 16491)
-- Name: complexidade cod_complexidade; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.complexidade ALTER COLUMN cod_complexidade SET DEFAULT nextval('public.complexidade_cod_complexidade_seq'::regclass);


--
-- TOC entry 2756 (class 2604 OID 16410)
-- Name: conceito cod_conceito; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.conceito ALTER COLUMN cod_conceito SET DEFAULT nextval('public.conceito_cod_conceito_seq'::regclass);


--
-- TOC entry 2760 (class 2604 OID 16448)
-- Name: estudante cod_estudante; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estudante ALTER COLUMN cod_estudante SET DEFAULT nextval('public.estudante_cod_estudante_seq'::regclass);


--
-- TOC entry 2764 (class 2604 OID 16483)
-- Name: interacao cod_interacao; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.interacao ALTER COLUMN cod_interacao SET DEFAULT nextval('public.interacao_cod_interacao_seq'::regclass);


--
-- TOC entry 2759 (class 2604 OID 16437)
-- Name: materia cod_materia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.materia ALTER COLUMN cod_materia SET DEFAULT nextval('public.materia_cod_materia_seq'::regclass);


--
-- TOC entry 2755 (class 2604 OID 16399)
-- Name: nocao cod_nocao; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nocao ALTER COLUMN cod_nocao SET DEFAULT nextval('public.nocao_cod_nocao_seq'::regclass);


--
-- TOC entry 2763 (class 2604 OID 16475)
-- Name: solucao cod_solucao; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solucao ALTER COLUMN cod_solucao SET DEFAULT nextval('public.solucao_cod_solucao_seq'::regclass);


--
-- TOC entry 2931 (class 0 OID 16426)
-- Dependencies: 203
-- Data for Name: apoioconceito; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.apoioconceito (cod_apoio_conceito, conteudo_apoio_conceito, fk_conceito_cod_conceito) FROM stdin;
\.


--
-- TOC entry 2939 (class 0 OID 16464)
-- Dependencies: 211
-- Data for Name: apoiomateria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.apoiomateria (cod_apoio_materia, conteudo_apoio_materia, fk_materia_cod_materia) FROM stdin;
\.


--
-- TOC entry 2937 (class 0 OID 16456)
-- Dependencies: 209
-- Data for Name: apoionocao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.apoionocao (cod_apoio_nocao, conteudo_apoio_nocao, fk_nocao_cod_nocao) FROM stdin;
\.


--
-- TOC entry 2929 (class 0 OID 16418)
-- Dependencies: 201
-- Data for Name: atividade; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.atividade (cod_atividade, premissas, conclusao) FROM stdin;
2	a | b, ~a	b
3	a ^ b	a
4	a, b, ~~a, ~b, a > b, a * b, a + b	~a
1	(a > b) * (c > d)	(a * c) > (b * d)
\.


--
-- TOC entry 2947 (class 0 OID 16496)
-- Dependencies: 219
-- Data for Name: avaliacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.avaliacao (fk_estudante_cod_estudante, fk_atividade_cod_atividade, cod_avaliacao, nota, fg_concluido) FROM stdin;
\.


--
-- TOC entry 2945 (class 0 OID 16488)
-- Dependencies: 217
-- Data for Name: complexidade; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.complexidade (fk_conceito_cod_conceito, fk_atividade_cod_atividade, cod_complexidade, valor) FROM stdin;
\.


--
-- TOC entry 2927 (class 0 OID 16407)
-- Dependencies: 199
-- Data for Name: conceito; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.conceito (cod_conceito, nome_conceito, lista_ant_conceito, lista_prox_conceito, fk_nocao_cod_nocao) FROM stdin;
1	Introdução da conjunção	2,3,8	2,3,6,8	1
2	Eliminação da conjunção	1,3,8	1,3,6,8	1
3	Introdução da disjunção	1,2,8	1,2,6,8	2
8	Eliminação da negação	1,2,3	1,2,3,6	4
6	Eliminação da implicação	1,2,3,8	4	3
4	Eliminação da disjunção	6	5,7	2
5	Introdução da implicação	4,7	7,9,12	3
7	Introdução da negação	4,5	5,9,12	4
9	Introdução do quantificador existencial	5,7,12	10,11,12	5
12	Eliminação do quantificador universal	5,7,9	9,10,11	6
10	Eliminação do quantificador existencial	9,11,12	11	5
11	Introdução do quantificador universal	9,10,12	10	6
\.


--
-- TOC entry 2935 (class 0 OID 16445)
-- Dependencies: 207
-- Data for Name: estudante; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estudante (cod_estudante, nome, idade, genero, estado_atual, caminho_seguido, tabela_conceitos) FROM stdin;
1	Igor	24	Masculino	\N	\N	\N
\.


--
-- TOC entry 2943 (class 0 OID 16480)
-- Dependencies: 215
-- Data for Name: interacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.interacao (cod_interacao, tipo, obs, data, fk_atividade_cod_atividade, fk_estudante_cod_estudante) FROM stdin;
\.


--
-- TOC entry 2933 (class 0 OID 16434)
-- Dependencies: 205
-- Data for Name: materia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.materia (cod_materia, nome_materia, lista_ant_materia, lista_prox_materia) FROM stdin;
1	Lógica proposicional	\N	\N
2	Lógica de predicados	\N	\N
\.


--
-- TOC entry 2925 (class 0 OID 16396)
-- Dependencies: 197
-- Data for Name: nocao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.nocao (cod_nocao, nome_nocao, lista_ant_nocao, lista_prox_nocao, fk_materia_cod_materia) FROM stdin;
1	Conjunção	\N	\N	1
2	Disjunção	\N	\N	1
3	Implicação	\N	\N	1
4	Negação	\N	\N	1
5	Quantificador existencial	\N	\N	2
6	Quantificador universal	\N	\N	2
\.


--
-- TOC entry 2941 (class 0 OID 16472)
-- Dependencies: 213
-- Data for Name: solucao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.solucao (cod_solucao, sequencia, fk_atividade_cod_atividade) FROM stdin;
\.


--
-- TOC entry 2965 (class 0 OID 0)
-- Dependencies: 202
-- Name: apoioconceito_cod_apoio_conceito_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.apoioconceito_cod_apoio_conceito_seq', 1, false);


--
-- TOC entry 2966 (class 0 OID 0)
-- Dependencies: 210
-- Name: apoiomateria_cod_apoio_materia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.apoiomateria_cod_apoio_materia_seq', 1, false);


--
-- TOC entry 2967 (class 0 OID 0)
-- Dependencies: 208
-- Name: apoionocao_cod_apoio_nocao_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.apoionocao_cod_apoio_nocao_seq', 1, false);


--
-- TOC entry 2968 (class 0 OID 0)
-- Dependencies: 200
-- Name: atividade_cod_atividade_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.atividade_cod_atividade_seq', 4, true);


--
-- TOC entry 2969 (class 0 OID 0)
-- Dependencies: 218
-- Name: avaliacao_cod_avaliacao_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.avaliacao_cod_avaliacao_seq', 1, false);


--
-- TOC entry 2970 (class 0 OID 0)
-- Dependencies: 216
-- Name: complexidade_cod_complexidade_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.complexidade_cod_complexidade_seq', 1, false);


--
-- TOC entry 2971 (class 0 OID 0)
-- Dependencies: 198
-- Name: conceito_cod_conceito_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.conceito_cod_conceito_seq', 12, true);


--
-- TOC entry 2972 (class 0 OID 0)
-- Dependencies: 206
-- Name: estudante_cod_estudante_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.estudante_cod_estudante_seq', 1, true);


--
-- TOC entry 2973 (class 0 OID 0)
-- Dependencies: 214
-- Name: interacao_cod_interacao_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.interacao_cod_interacao_seq', 1, false);


--
-- TOC entry 2974 (class 0 OID 0)
-- Dependencies: 204
-- Name: materia_cod_materia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.materia_cod_materia_seq', 2, true);


--
-- TOC entry 2975 (class 0 OID 0)
-- Dependencies: 196
-- Name: nocao_cod_nocao_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.nocao_cod_nocao_seq', 6, true);


--
-- TOC entry 2976 (class 0 OID 0)
-- Dependencies: 212
-- Name: solucao_cod_solucao_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.solucao_cod_solucao_seq', 1, false);


--
-- TOC entry 2774 (class 2606 OID 16431)
-- Name: apoioconceito apoioconceito_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.apoioconceito
    ADD CONSTRAINT apoioconceito_pkey PRIMARY KEY (cod_apoio_conceito);


--
-- TOC entry 2782 (class 2606 OID 16469)
-- Name: apoiomateria apoiomateria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.apoiomateria
    ADD CONSTRAINT apoiomateria_pkey PRIMARY KEY (cod_apoio_materia);


--
-- TOC entry 2780 (class 2606 OID 16461)
-- Name: apoionocao apoionocao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.apoionocao
    ADD CONSTRAINT apoionocao_pkey PRIMARY KEY (cod_apoio_nocao);


--
-- TOC entry 2772 (class 2606 OID 16423)
-- Name: atividade atividade_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atividade
    ADD CONSTRAINT atividade_pkey PRIMARY KEY (cod_atividade);


--
-- TOC entry 2790 (class 2606 OID 16501)
-- Name: avaliacao avaliacao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.avaliacao
    ADD CONSTRAINT avaliacao_pkey PRIMARY KEY (cod_avaliacao);


--
-- TOC entry 2788 (class 2606 OID 16493)
-- Name: complexidade complexidade_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.complexidade
    ADD CONSTRAINT complexidade_pkey PRIMARY KEY (cod_complexidade);


--
-- TOC entry 2770 (class 2606 OID 16415)
-- Name: conceito conceito_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.conceito
    ADD CONSTRAINT conceito_pkey PRIMARY KEY (cod_conceito);


--
-- TOC entry 2778 (class 2606 OID 16453)
-- Name: estudante estudante_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estudante
    ADD CONSTRAINT estudante_pkey PRIMARY KEY (cod_estudante);


--
-- TOC entry 2786 (class 2606 OID 16485)
-- Name: interacao interacao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.interacao
    ADD CONSTRAINT interacao_pkey PRIMARY KEY (cod_interacao);


--
-- TOC entry 2776 (class 2606 OID 16442)
-- Name: materia materia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.materia
    ADD CONSTRAINT materia_pkey PRIMARY KEY (cod_materia);


--
-- TOC entry 2768 (class 2606 OID 16404)
-- Name: nocao nocao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nocao
    ADD CONSTRAINT nocao_pkey PRIMARY KEY (cod_nocao);


--
-- TOC entry 2784 (class 2606 OID 16477)
-- Name: solucao solucao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solucao
    ADD CONSTRAINT solucao_pkey PRIMARY KEY (cod_solucao);


--
-- TOC entry 2793 (class 2606 OID 16512)
-- Name: apoioconceito fk_apoioconceito_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.apoioconceito
    ADD CONSTRAINT fk_apoioconceito_2 FOREIGN KEY (fk_conceito_cod_conceito) REFERENCES public.conceito(cod_conceito) ON DELETE CASCADE;


--
-- TOC entry 2795 (class 2606 OID 16522)
-- Name: apoiomateria fk_apoiomateria_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.apoiomateria
    ADD CONSTRAINT fk_apoiomateria_2 FOREIGN KEY (fk_materia_cod_materia) REFERENCES public.materia(cod_materia) ON DELETE CASCADE;


--
-- TOC entry 2794 (class 2606 OID 16517)
-- Name: apoionocao fk_apoionocao_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.apoionocao
    ADD CONSTRAINT fk_apoionocao_2 FOREIGN KEY (fk_nocao_cod_nocao) REFERENCES public.nocao(cod_nocao) ON DELETE CASCADE;


--
-- TOC entry 2801 (class 2606 OID 16552)
-- Name: avaliacao fk_avaliacao_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.avaliacao
    ADD CONSTRAINT fk_avaliacao_2 FOREIGN KEY (fk_estudante_cod_estudante) REFERENCES public.estudante(cod_estudante) ON DELETE SET NULL;


--
-- TOC entry 2802 (class 2606 OID 16557)
-- Name: avaliacao fk_avaliacao_3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.avaliacao
    ADD CONSTRAINT fk_avaliacao_3 FOREIGN KEY (fk_atividade_cod_atividade) REFERENCES public.atividade(cod_atividade) ON DELETE SET NULL;


--
-- TOC entry 2799 (class 2606 OID 16542)
-- Name: complexidade fk_complexidade_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.complexidade
    ADD CONSTRAINT fk_complexidade_2 FOREIGN KEY (fk_conceito_cod_conceito) REFERENCES public.conceito(cod_conceito) ON DELETE RESTRICT;


--
-- TOC entry 2800 (class 2606 OID 16547)
-- Name: complexidade fk_complexidade_3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.complexidade
    ADD CONSTRAINT fk_complexidade_3 FOREIGN KEY (fk_atividade_cod_atividade) REFERENCES public.atividade(cod_atividade) ON DELETE SET NULL;


--
-- TOC entry 2792 (class 2606 OID 16507)
-- Name: conceito fk_conceito_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.conceito
    ADD CONSTRAINT fk_conceito_2 FOREIGN KEY (fk_nocao_cod_nocao) REFERENCES public.nocao(cod_nocao) ON DELETE CASCADE;


--
-- TOC entry 2797 (class 2606 OID 16532)
-- Name: interacao fk_interacao_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.interacao
    ADD CONSTRAINT fk_interacao_2 FOREIGN KEY (fk_atividade_cod_atividade) REFERENCES public.atividade(cod_atividade) ON DELETE CASCADE;


--
-- TOC entry 2798 (class 2606 OID 16537)
-- Name: interacao fk_interacao_3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.interacao
    ADD CONSTRAINT fk_interacao_3 FOREIGN KEY (fk_estudante_cod_estudante) REFERENCES public.estudante(cod_estudante) ON DELETE CASCADE;


--
-- TOC entry 2791 (class 2606 OID 16502)
-- Name: nocao fk_nocao_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nocao
    ADD CONSTRAINT fk_nocao_2 FOREIGN KEY (fk_materia_cod_materia) REFERENCES public.materia(cod_materia) ON DELETE CASCADE;


--
-- TOC entry 2796 (class 2606 OID 16527)
-- Name: solucao fk_solucao_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solucao
    ADD CONSTRAINT fk_solucao_2 FOREIGN KEY (fk_atividade_cod_atividade) REFERENCES public.atividade(cod_atividade) ON DELETE CASCADE;


-- Completed on 2019-10-02 22:20:59

--
-- PostgreSQL database dump complete
--

