ID 账号 密码 邮箱 手机号 关联合作账号 提示问题/答案 用途 使用频率 账号状态 功能分类 出厂公司 网址 账号所属人 创建人 创建时间 备注 
drop table t_acc_info;
create table t_acc_info(
tai_id int(10),
tai_user_id int(10),
tai_username varchar(50),
tai_password varchar(50),
tai_email varchar(50),
tai_phone varchar(20),
tai_rel_id varchar(100),
tai_prompt_question varchar(1000),
tai_purpose varchar(500),
tai_time_level varchar(20),
tai_acc_status varchar(20),
tai_work_type varchar(20),
tai_company varchar(200),
tai_url varchar(200),
tai_create_user varchar(50),
tai_create_time timestamp,
tai_remark varchar(500),
PRIMARY KEY (tai_id)
);

drop table t_user_info;
create table t_user_info(
tui_id int(10),
tui_name varchar(50),
tui_username varchar(50),
tui_alias varchar(50),
tui_email varchar(50),
tui_phone varchar(20),
tui_password varchar(50),
tui_photo varchar(200),
tui_create_time timestamp,
tui_remark varchar(500),
PRIMARY KEY (tui_id)
)