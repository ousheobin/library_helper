CREATE TABLE tb_user (
    f_id VARCHAR(32) PRIMARY KEY,
    f_yzj_user_id VARCHAR(255) NOT NULL,
    f_user_number VARCHAR(255),
    f_member_name VARCHAR(255)
);

CREATE TABLE tb_book_list (
    f_id VARCHAR(32) PRIMARY KEY,
    f_user_id VARCHAR(32) NOT NULL,
    f_book_name VARCHAR(255),
    f_book_numer VARCHAR(255),
    f_mark_time DATETIME,
    f_is_delete INT,
    f_delete_time DATETIME,
    f_is_back INT,
    CONSTRAINT fk_book_list_user FOREIGN KEY (f_user_id) REFERENCES tb_user(f_id)
);

CREATE TABLE tb_search_record(
    f_id VARCHAR(32) PRIMARY KEY,
    f_user_id VARCHAR(32) NOT NULL,
    f_key_word VARCHAR(255),
    f_search_time DATETIME,
    f_user_agent LONGTEXT,
    CONSTRAINT fk_record_user FOREIGN KEY (f_user_id) REFERENCES tb_user(f_id)
);

alter table tb_book_list add f_book_source longtext;