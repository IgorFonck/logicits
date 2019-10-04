PGDMP         0            	    w         
   bdlogicits    11.4    11.4 d    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �           1262    24682 
   bdlogicits    DATABASE     �   CREATE DATABASE bdlogicits WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE bdlogicits;
             postgres    false            �            1259    24683    apoioconceito    TABLE     �   CREATE TABLE public.apoioconceito (
    cod_apoio_conceito integer NOT NULL,
    conteudo_apoio_conceito character varying(255),
    fk_conceito_cod_conceito integer
);
 !   DROP TABLE public.apoioconceito;
       public         postgres    false            �            1259    24686 $   apoioconceito_cod_apoio_conceito_seq    SEQUENCE     �   CREATE SEQUENCE public.apoioconceito_cod_apoio_conceito_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ;   DROP SEQUENCE public.apoioconceito_cod_apoio_conceito_seq;
       public       postgres    false    196            �           0    0 $   apoioconceito_cod_apoio_conceito_seq    SEQUENCE OWNED BY     m   ALTER SEQUENCE public.apoioconceito_cod_apoio_conceito_seq OWNED BY public.apoioconceito.cod_apoio_conceito;
            public       postgres    false    197            �            1259    24688    apoiomateria    TABLE     �   CREATE TABLE public.apoiomateria (
    cod_apoio_materia integer NOT NULL,
    conteudo_apoio_materia character varying(255),
    fk_materia_cod_materia integer
);
     DROP TABLE public.apoiomateria;
       public         postgres    false            �            1259    24691 "   apoiomateria_cod_apoio_materia_seq    SEQUENCE     �   CREATE SEQUENCE public.apoiomateria_cod_apoio_materia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public.apoiomateria_cod_apoio_materia_seq;
       public       postgres    false    198            �           0    0 "   apoiomateria_cod_apoio_materia_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE public.apoiomateria_cod_apoio_materia_seq OWNED BY public.apoiomateria.cod_apoio_materia;
            public       postgres    false    199            �            1259    24693 
   apoionocao    TABLE     �   CREATE TABLE public.apoionocao (
    cod_apoio_nocao integer NOT NULL,
    conteudo_apoio_nocao character varying(255),
    fk_nocao_cod_nocao integer
);
    DROP TABLE public.apoionocao;
       public         postgres    false            �            1259    24696    apoionocao_cod_apoio_nocao_seq    SEQUENCE     �   CREATE SEQUENCE public.apoionocao_cod_apoio_nocao_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.apoionocao_cod_apoio_nocao_seq;
       public       postgres    false    200            �           0    0    apoionocao_cod_apoio_nocao_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.apoionocao_cod_apoio_nocao_seq OWNED BY public.apoionocao.cod_apoio_nocao;
            public       postgres    false    201            �            1259    24698 	   atividade    TABLE     �   CREATE TABLE public.atividade (
    cod_atividade integer NOT NULL,
    premissas character varying(255),
    conclusao character varying(50)
);
    DROP TABLE public.atividade;
       public         postgres    false            �            1259    24701    atividade_cod_atividade_seq    SEQUENCE     �   CREATE SEQUENCE public.atividade_cod_atividade_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.atividade_cod_atividade_seq;
       public       postgres    false    202            �           0    0    atividade_cod_atividade_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.atividade_cod_atividade_seq OWNED BY public.atividade.cod_atividade;
            public       postgres    false    203            �            1259    24703 	   avaliacao    TABLE     �   CREATE TABLE public.avaliacao (
    fk_estudante_cod_estudante integer,
    fk_atividade_cod_atividade integer,
    cod_avaliacao integer NOT NULL,
    nota real,
    fg_concluido boolean
);
    DROP TABLE public.avaliacao;
       public         postgres    false            �            1259    24706    avaliacao_cod_avaliacao_seq    SEQUENCE     �   CREATE SEQUENCE public.avaliacao_cod_avaliacao_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.avaliacao_cod_avaliacao_seq;
       public       postgres    false    204            �           0    0    avaliacao_cod_avaliacao_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.avaliacao_cod_avaliacao_seq OWNED BY public.avaliacao.cod_avaliacao;
            public       postgres    false    205            �            1259    24708    complexidade    TABLE     �   CREATE TABLE public.complexidade (
    fk_conceito_cod_conceito integer,
    fk_atividade_cod_atividade integer,
    cod_complexidade integer NOT NULL,
    valor integer
);
     DROP TABLE public.complexidade;
       public         postgres    false            �            1259    24711 !   complexidade_cod_complexidade_seq    SEQUENCE     �   CREATE SEQUENCE public.complexidade_cod_complexidade_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE public.complexidade_cod_complexidade_seq;
       public       postgres    false    206            �           0    0 !   complexidade_cod_complexidade_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE public.complexidade_cod_complexidade_seq OWNED BY public.complexidade.cod_complexidade;
            public       postgres    false    207            �            1259    24713    conceito    TABLE     �   CREATE TABLE public.conceito (
    cod_conceito integer NOT NULL,
    nome_conceito character varying(50),
    lista_ant_conceito character varying(255),
    lista_prox_conceito character varying(255),
    fk_nocao_cod_nocao integer
);
    DROP TABLE public.conceito;
       public         postgres    false            �            1259    24719    conceito_cod_conceito_seq    SEQUENCE     �   CREATE SEQUENCE public.conceito_cod_conceito_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.conceito_cod_conceito_seq;
       public       postgres    false    208            �           0    0    conceito_cod_conceito_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.conceito_cod_conceito_seq OWNED BY public.conceito.cod_conceito;
            public       postgres    false    209            �            1259    24721 	   estudante    TABLE       CREATE TABLE public.estudante (
    cod_estudante integer NOT NULL,
    nome character varying(50),
    idade integer,
    genero character varying(50),
    estado_atual character varying(255),
    caminho_seguido character varying(255),
    tabela_conceitos character varying(255)
);
    DROP TABLE public.estudante;
       public         postgres    false            �            1259    24727    estudante_cod_estudante_seq    SEQUENCE     �   CREATE SEQUENCE public.estudante_cod_estudante_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.estudante_cod_estudante_seq;
       public       postgres    false    210            �           0    0    estudante_cod_estudante_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.estudante_cod_estudante_seq OWNED BY public.estudante.cod_estudante;
            public       postgres    false    211            �            1259    24729 	   interacao    TABLE     �   CREATE TABLE public.interacao (
    cod_interacao integer NOT NULL,
    tipo character varying(50),
    obs character varying(255),
    data timestamp without time zone,
    fk_atividade_cod_atividade integer,
    fk_estudante_cod_estudante integer
);
    DROP TABLE public.interacao;
       public         postgres    false            �            1259    24732    interacao_cod_interacao_seq    SEQUENCE     �   CREATE SEQUENCE public.interacao_cod_interacao_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.interacao_cod_interacao_seq;
       public       postgres    false    212            �           0    0    interacao_cod_interacao_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.interacao_cod_interacao_seq OWNED BY public.interacao.cod_interacao;
            public       postgres    false    213            �            1259    24734    materia    TABLE     �   CREATE TABLE public.materia (
    cod_materia integer NOT NULL,
    nome_materia character varying(50),
    lista_ant_materia character varying(255),
    lista_prox_materia character varying(255)
);
    DROP TABLE public.materia;
       public         postgres    false            �            1259    24740    materia_cod_materia_seq    SEQUENCE     �   CREATE SEQUENCE public.materia_cod_materia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.materia_cod_materia_seq;
       public       postgres    false    214            �           0    0    materia_cod_materia_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.materia_cod_materia_seq OWNED BY public.materia.cod_materia;
            public       postgres    false    215            �            1259    24742    nocao    TABLE     �   CREATE TABLE public.nocao (
    cod_nocao integer NOT NULL,
    nome_nocao character varying(50),
    lista_ant_nocao character varying(255),
    lista_prox_nocao character varying(255),
    fk_materia_cod_materia integer
);
    DROP TABLE public.nocao;
       public         postgres    false            �            1259    24748    nocao_cod_nocao_seq    SEQUENCE     �   CREATE SEQUENCE public.nocao_cod_nocao_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.nocao_cod_nocao_seq;
       public       postgres    false    216            �           0    0    nocao_cod_nocao_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.nocao_cod_nocao_seq OWNED BY public.nocao.cod_nocao;
            public       postgres    false    217            �            1259    24750    solucao    TABLE     �   CREATE TABLE public.solucao (
    cod_solucao integer NOT NULL,
    sequencia character varying(255),
    fk_atividade_cod_atividade integer,
    dificuldade smallint
);
    DROP TABLE public.solucao;
       public         postgres    false            �            1259    24753    solucao_cod_solucao_seq    SEQUENCE     �   CREATE SEQUENCE public.solucao_cod_solucao_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.solucao_cod_solucao_seq;
       public       postgres    false    218            �           0    0    solucao_cod_solucao_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.solucao_cod_solucao_seq OWNED BY public.solucao.cod_solucao;
            public       postgres    false    219            �
           2604    24755     apoioconceito cod_apoio_conceito    DEFAULT     �   ALTER TABLE ONLY public.apoioconceito ALTER COLUMN cod_apoio_conceito SET DEFAULT nextval('public.apoioconceito_cod_apoio_conceito_seq'::regclass);
 O   ALTER TABLE public.apoioconceito ALTER COLUMN cod_apoio_conceito DROP DEFAULT;
       public       postgres    false    197    196            �
           2604    24756    apoiomateria cod_apoio_materia    DEFAULT     �   ALTER TABLE ONLY public.apoiomateria ALTER COLUMN cod_apoio_materia SET DEFAULT nextval('public.apoiomateria_cod_apoio_materia_seq'::regclass);
 M   ALTER TABLE public.apoiomateria ALTER COLUMN cod_apoio_materia DROP DEFAULT;
       public       postgres    false    199    198            �
           2604    24757    apoionocao cod_apoio_nocao    DEFAULT     �   ALTER TABLE ONLY public.apoionocao ALTER COLUMN cod_apoio_nocao SET DEFAULT nextval('public.apoionocao_cod_apoio_nocao_seq'::regclass);
 I   ALTER TABLE public.apoionocao ALTER COLUMN cod_apoio_nocao DROP DEFAULT;
       public       postgres    false    201    200            �
           2604    24758    atividade cod_atividade    DEFAULT     �   ALTER TABLE ONLY public.atividade ALTER COLUMN cod_atividade SET DEFAULT nextval('public.atividade_cod_atividade_seq'::regclass);
 F   ALTER TABLE public.atividade ALTER COLUMN cod_atividade DROP DEFAULT;
       public       postgres    false    203    202            �
           2604    24759    avaliacao cod_avaliacao    DEFAULT     �   ALTER TABLE ONLY public.avaliacao ALTER COLUMN cod_avaliacao SET DEFAULT nextval('public.avaliacao_cod_avaliacao_seq'::regclass);
 F   ALTER TABLE public.avaliacao ALTER COLUMN cod_avaliacao DROP DEFAULT;
       public       postgres    false    205    204            �
           2604    24760    complexidade cod_complexidade    DEFAULT     �   ALTER TABLE ONLY public.complexidade ALTER COLUMN cod_complexidade SET DEFAULT nextval('public.complexidade_cod_complexidade_seq'::regclass);
 L   ALTER TABLE public.complexidade ALTER COLUMN cod_complexidade DROP DEFAULT;
       public       postgres    false    207    206            �
           2604    24761    conceito cod_conceito    DEFAULT     ~   ALTER TABLE ONLY public.conceito ALTER COLUMN cod_conceito SET DEFAULT nextval('public.conceito_cod_conceito_seq'::regclass);
 D   ALTER TABLE public.conceito ALTER COLUMN cod_conceito DROP DEFAULT;
       public       postgres    false    209    208            �
           2604    24762    estudante cod_estudante    DEFAULT     �   ALTER TABLE ONLY public.estudante ALTER COLUMN cod_estudante SET DEFAULT nextval('public.estudante_cod_estudante_seq'::regclass);
 F   ALTER TABLE public.estudante ALTER COLUMN cod_estudante DROP DEFAULT;
       public       postgres    false    211    210            �
           2604    24763    interacao cod_interacao    DEFAULT     �   ALTER TABLE ONLY public.interacao ALTER COLUMN cod_interacao SET DEFAULT nextval('public.interacao_cod_interacao_seq'::regclass);
 F   ALTER TABLE public.interacao ALTER COLUMN cod_interacao DROP DEFAULT;
       public       postgres    false    213    212            �
           2604    24764    materia cod_materia    DEFAULT     z   ALTER TABLE ONLY public.materia ALTER COLUMN cod_materia SET DEFAULT nextval('public.materia_cod_materia_seq'::regclass);
 B   ALTER TABLE public.materia ALTER COLUMN cod_materia DROP DEFAULT;
       public       postgres    false    215    214            �
           2604    24765    nocao cod_nocao    DEFAULT     r   ALTER TABLE ONLY public.nocao ALTER COLUMN cod_nocao SET DEFAULT nextval('public.nocao_cod_nocao_seq'::regclass);
 >   ALTER TABLE public.nocao ALTER COLUMN cod_nocao DROP DEFAULT;
       public       postgres    false    217    216            �
           2604    24766    solucao cod_solucao    DEFAULT     z   ALTER TABLE ONLY public.solucao ALTER COLUMN cod_solucao SET DEFAULT nextval('public.solucao_cod_solucao_seq'::regclass);
 B   ALTER TABLE public.solucao ALTER COLUMN cod_solucao DROP DEFAULT;
       public       postgres    false    219    218            l          0    24683    apoioconceito 
   TABLE DATA               n   COPY public.apoioconceito (cod_apoio_conceito, conteudo_apoio_conceito, fk_conceito_cod_conceito) FROM stdin;
    public       postgres    false    196   9y       n          0    24688    apoiomateria 
   TABLE DATA               i   COPY public.apoiomateria (cod_apoio_materia, conteudo_apoio_materia, fk_materia_cod_materia) FROM stdin;
    public       postgres    false    198   Vy       p          0    24693 
   apoionocao 
   TABLE DATA               _   COPY public.apoionocao (cod_apoio_nocao, conteudo_apoio_nocao, fk_nocao_cod_nocao) FROM stdin;
    public       postgres    false    200   sy       r          0    24698 	   atividade 
   TABLE DATA               H   COPY public.atividade (cod_atividade, premissas, conclusao) FROM stdin;
    public       postgres    false    202   �y       t          0    24703 	   avaliacao 
   TABLE DATA               ~   COPY public.avaliacao (fk_estudante_cod_estudante, fk_atividade_cod_atividade, cod_avaliacao, nota, fg_concluido) FROM stdin;
    public       postgres    false    204   z       v          0    24708    complexidade 
   TABLE DATA               u   COPY public.complexidade (fk_conceito_cod_conceito, fk_atividade_cod_atividade, cod_complexidade, valor) FROM stdin;
    public       postgres    false    206   +z       x          0    24713    conceito 
   TABLE DATA               |   COPY public.conceito (cod_conceito, nome_conceito, lista_ant_conceito, lista_prox_conceito, fk_nocao_cod_nocao) FROM stdin;
    public       postgres    false    208   �z       z          0    24721 	   estudante 
   TABLE DATA               x   COPY public.estudante (cod_estudante, nome, idade, genero, estado_atual, caminho_seguido, tabela_conceitos) FROM stdin;
    public       postgres    false    210   �{       |          0    24729 	   interacao 
   TABLE DATA               {   COPY public.interacao (cod_interacao, tipo, obs, data, fk_atividade_cod_atividade, fk_estudante_cod_estudante) FROM stdin;
    public       postgres    false    212   �{       ~          0    24734    materia 
   TABLE DATA               c   COPY public.materia (cod_materia, nome_materia, lista_ant_materia, lista_prox_materia) FROM stdin;
    public       postgres    false    214   �{       �          0    24742    nocao 
   TABLE DATA               q   COPY public.nocao (cod_nocao, nome_nocao, lista_ant_nocao, lista_prox_nocao, fk_materia_cod_materia) FROM stdin;
    public       postgres    false    216   &|       �          0    24750    solucao 
   TABLE DATA               b   COPY public.solucao (cod_solucao, sequencia, fk_atividade_cod_atividade, dificuldade) FROM stdin;
    public       postgres    false    218   �|       �           0    0 $   apoioconceito_cod_apoio_conceito_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('public.apoioconceito_cod_apoio_conceito_seq', 1, false);
            public       postgres    false    197            �           0    0 "   apoiomateria_cod_apoio_materia_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('public.apoiomateria_cod_apoio_materia_seq', 1, false);
            public       postgres    false    199            �           0    0    apoionocao_cod_apoio_nocao_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.apoionocao_cod_apoio_nocao_seq', 1, false);
            public       postgres    false    201            �           0    0    atividade_cod_atividade_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.atividade_cod_atividade_seq', 7, true);
            public       postgres    false    203            �           0    0    avaliacao_cod_avaliacao_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.avaliacao_cod_avaliacao_seq', 1, false);
            public       postgres    false    205            �           0    0 !   complexidade_cod_complexidade_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.complexidade_cod_complexidade_seq', 17, true);
            public       postgres    false    207            �           0    0    conceito_cod_conceito_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.conceito_cod_conceito_seq', 12, true);
            public       postgres    false    209            �           0    0    estudante_cod_estudante_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.estudante_cod_estudante_seq', 1, true);
            public       postgres    false    211            �           0    0    interacao_cod_interacao_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.interacao_cod_interacao_seq', 1, false);
            public       postgres    false    213            �           0    0    materia_cod_materia_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.materia_cod_materia_seq', 2, true);
            public       postgres    false    215            �           0    0    nocao_cod_nocao_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.nocao_cod_nocao_seq', 6, true);
            public       postgres    false    217            �           0    0    solucao_cod_solucao_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.solucao_cod_solucao_seq', 6, true);
            public       postgres    false    219            �
           2606    24768     apoioconceito apoioconceito_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.apoioconceito
    ADD CONSTRAINT apoioconceito_pkey PRIMARY KEY (cod_apoio_conceito);
 J   ALTER TABLE ONLY public.apoioconceito DROP CONSTRAINT apoioconceito_pkey;
       public         postgres    false    196            �
           2606    24770    apoiomateria apoiomateria_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY public.apoiomateria
    ADD CONSTRAINT apoiomateria_pkey PRIMARY KEY (cod_apoio_materia);
 H   ALTER TABLE ONLY public.apoiomateria DROP CONSTRAINT apoiomateria_pkey;
       public         postgres    false    198            �
           2606    24772    apoionocao apoionocao_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.apoionocao
    ADD CONSTRAINT apoionocao_pkey PRIMARY KEY (cod_apoio_nocao);
 D   ALTER TABLE ONLY public.apoionocao DROP CONSTRAINT apoionocao_pkey;
       public         postgres    false    200            �
           2606    24774    atividade atividade_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.atividade
    ADD CONSTRAINT atividade_pkey PRIMARY KEY (cod_atividade);
 B   ALTER TABLE ONLY public.atividade DROP CONSTRAINT atividade_pkey;
       public         postgres    false    202            �
           2606    24776    avaliacao avaliacao_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.avaliacao
    ADD CONSTRAINT avaliacao_pkey PRIMARY KEY (cod_avaliacao);
 B   ALTER TABLE ONLY public.avaliacao DROP CONSTRAINT avaliacao_pkey;
       public         postgres    false    204            �
           2606    24778    complexidade complexidade_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.complexidade
    ADD CONSTRAINT complexidade_pkey PRIMARY KEY (cod_complexidade);
 H   ALTER TABLE ONLY public.complexidade DROP CONSTRAINT complexidade_pkey;
       public         postgres    false    206            �
           2606    24780    conceito conceito_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.conceito
    ADD CONSTRAINT conceito_pkey PRIMARY KEY (cod_conceito);
 @   ALTER TABLE ONLY public.conceito DROP CONSTRAINT conceito_pkey;
       public         postgres    false    208            �
           2606    24782    estudante estudante_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.estudante
    ADD CONSTRAINT estudante_pkey PRIMARY KEY (cod_estudante);
 B   ALTER TABLE ONLY public.estudante DROP CONSTRAINT estudante_pkey;
       public         postgres    false    210            �
           2606    24784    interacao interacao_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.interacao
    ADD CONSTRAINT interacao_pkey PRIMARY KEY (cod_interacao);
 B   ALTER TABLE ONLY public.interacao DROP CONSTRAINT interacao_pkey;
       public         postgres    false    212            �
           2606    24786    materia materia_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.materia
    ADD CONSTRAINT materia_pkey PRIMARY KEY (cod_materia);
 >   ALTER TABLE ONLY public.materia DROP CONSTRAINT materia_pkey;
       public         postgres    false    214            �
           2606    24788    nocao nocao_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.nocao
    ADD CONSTRAINT nocao_pkey PRIMARY KEY (cod_nocao);
 :   ALTER TABLE ONLY public.nocao DROP CONSTRAINT nocao_pkey;
       public         postgres    false    216            �
           2606    24790    solucao solucao_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.solucao
    ADD CONSTRAINT solucao_pkey PRIMARY KEY (cod_solucao);
 >   ALTER TABLE ONLY public.solucao DROP CONSTRAINT solucao_pkey;
       public         postgres    false    218            �
           2606    24791     apoioconceito fk_apoioconceito_2    FK CONSTRAINT     �   ALTER TABLE ONLY public.apoioconceito
    ADD CONSTRAINT fk_apoioconceito_2 FOREIGN KEY (fk_conceito_cod_conceito) REFERENCES public.conceito(cod_conceito) ON DELETE CASCADE;
 J   ALTER TABLE ONLY public.apoioconceito DROP CONSTRAINT fk_apoioconceito_2;
       public       postgres    false    196    208    2780            �
           2606    24796    apoiomateria fk_apoiomateria_2    FK CONSTRAINT     �   ALTER TABLE ONLY public.apoiomateria
    ADD CONSTRAINT fk_apoiomateria_2 FOREIGN KEY (fk_materia_cod_materia) REFERENCES public.materia(cod_materia) ON DELETE CASCADE;
 H   ALTER TABLE ONLY public.apoiomateria DROP CONSTRAINT fk_apoiomateria_2;
       public       postgres    false    198    2786    214            �
           2606    24801    apoionocao fk_apoionocao_2    FK CONSTRAINT     �   ALTER TABLE ONLY public.apoionocao
    ADD CONSTRAINT fk_apoionocao_2 FOREIGN KEY (fk_nocao_cod_nocao) REFERENCES public.nocao(cod_nocao) ON DELETE CASCADE;
 D   ALTER TABLE ONLY public.apoionocao DROP CONSTRAINT fk_apoionocao_2;
       public       postgres    false    216    200    2788            �
           2606    24806    avaliacao fk_avaliacao_2    FK CONSTRAINT     �   ALTER TABLE ONLY public.avaliacao
    ADD CONSTRAINT fk_avaliacao_2 FOREIGN KEY (fk_estudante_cod_estudante) REFERENCES public.estudante(cod_estudante) ON DELETE SET NULL;
 B   ALTER TABLE ONLY public.avaliacao DROP CONSTRAINT fk_avaliacao_2;
       public       postgres    false    2782    204    210            �
           2606    24811    avaliacao fk_avaliacao_3    FK CONSTRAINT     �   ALTER TABLE ONLY public.avaliacao
    ADD CONSTRAINT fk_avaliacao_3 FOREIGN KEY (fk_atividade_cod_atividade) REFERENCES public.atividade(cod_atividade) ON DELETE SET NULL;
 B   ALTER TABLE ONLY public.avaliacao DROP CONSTRAINT fk_avaliacao_3;
       public       postgres    false    204    202    2774            �
           2606    24816    complexidade fk_complexidade_2    FK CONSTRAINT     �   ALTER TABLE ONLY public.complexidade
    ADD CONSTRAINT fk_complexidade_2 FOREIGN KEY (fk_conceito_cod_conceito) REFERENCES public.conceito(cod_conceito) ON DELETE RESTRICT;
 H   ALTER TABLE ONLY public.complexidade DROP CONSTRAINT fk_complexidade_2;
       public       postgres    false    2780    206    208            �
           2606    24821    complexidade fk_complexidade_3    FK CONSTRAINT     �   ALTER TABLE ONLY public.complexidade
    ADD CONSTRAINT fk_complexidade_3 FOREIGN KEY (fk_atividade_cod_atividade) REFERENCES public.atividade(cod_atividade) ON DELETE SET NULL;
 H   ALTER TABLE ONLY public.complexidade DROP CONSTRAINT fk_complexidade_3;
       public       postgres    false    2774    202    206            �
           2606    24826    conceito fk_conceito_2    FK CONSTRAINT     �   ALTER TABLE ONLY public.conceito
    ADD CONSTRAINT fk_conceito_2 FOREIGN KEY (fk_nocao_cod_nocao) REFERENCES public.nocao(cod_nocao) ON DELETE CASCADE;
 @   ALTER TABLE ONLY public.conceito DROP CONSTRAINT fk_conceito_2;
       public       postgres    false    216    2788    208            �
           2606    24831    interacao fk_interacao_2    FK CONSTRAINT     �   ALTER TABLE ONLY public.interacao
    ADD CONSTRAINT fk_interacao_2 FOREIGN KEY (fk_atividade_cod_atividade) REFERENCES public.atividade(cod_atividade) ON DELETE CASCADE;
 B   ALTER TABLE ONLY public.interacao DROP CONSTRAINT fk_interacao_2;
       public       postgres    false    202    212    2774            �
           2606    24836    interacao fk_interacao_3    FK CONSTRAINT     �   ALTER TABLE ONLY public.interacao
    ADD CONSTRAINT fk_interacao_3 FOREIGN KEY (fk_estudante_cod_estudante) REFERENCES public.estudante(cod_estudante) ON DELETE CASCADE;
 B   ALTER TABLE ONLY public.interacao DROP CONSTRAINT fk_interacao_3;
       public       postgres    false    212    2782    210            �
           2606    24841    nocao fk_nocao_2    FK CONSTRAINT     �   ALTER TABLE ONLY public.nocao
    ADD CONSTRAINT fk_nocao_2 FOREIGN KEY (fk_materia_cod_materia) REFERENCES public.materia(cod_materia) ON DELETE CASCADE;
 :   ALTER TABLE ONLY public.nocao DROP CONSTRAINT fk_nocao_2;
       public       postgres    false    216    214    2786            �
           2606    24846    solucao fk_solucao_2    FK CONSTRAINT     �   ALTER TABLE ONLY public.solucao
    ADD CONSTRAINT fk_solucao_2 FOREIGN KEY (fk_atividade_cod_atividade) REFERENCES public.atividade(cod_atividade) ON DELETE CASCADE;
 >   ALTER TABLE ONLY public.solucao DROP CONSTRAINT fk_solucao_2;
       public       postgres    false    218    202    2774            l      x������ � �      n      x������ � �      p      x������ � �      r   n   x�-�;�0D��S���a�$��������:{dC�Oow4!��bY:I%h��tRrɂ��Tz�A\a��������[H�+��A�'�hC(�a�Z��𝿑���      t      x������ � �      v   U   x���� ���0�!��t�9��x�E���Fr��\�T)}_MDO�9u̥sK�˭�MHN+������e�B)3��~WD�I�Q      x   �   x���Mn�0�מS� V�8�C�E���J�jP�!?����A�X�5!Fbc;����_n�}3�~oW�56���O.~
%s����A�ώ��K#��t�t74,hiiۤ۵?vf��)��`�ǎ�%ΥZ�t9B�,/��O���RV7�	;ղ��j�V��N�u#}so�����0��&ۅ!����g�㓣s��p%��� n�D���a�$K���Yzׅ�l�} �D���      z   %   x�3��L�/�42��M,N.������ �=... ���      |      x������ � �      ~   9   x�3��9�9=39Q��(� �8393?/1�3�����)�@�)@fJ~1T6F��� �s      �   d   x�3�t���*�;����|�?2�2�t�,�5���-��LND6��KMG3�,M�+�L�N�/RH��,.I�K�Ĺ�1�2CSS��Y�ZT��"F��� �i5h      �   ~   x�m�;1Dk�(h���U.�!h� Q�pv��n1.��<�~�st4lt(���	ZnBA�Z��q�[�V8)	�+%<�(�pH�Xz�6���G���g:�E�_Dz�:�|;3���&�     