/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : batch

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2017-07-31 10:52:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS qrtz_blob_triggers;
CREATE TABLE qrtz_blob_triggers (
  SCHED_NAME varchar(120) NOT NULL,
  TRIGGER_NAME varchar(200) NOT NULL,
  TRIGGER_GROUP varchar(200) NOT NULL,
  BLOB_DATA blob,
  PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
  KEY SCHED_NAME (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP) USING BTREE,
  CONSTRAINT qrtz_blob_triggers_ibfk_1 FOREIGN KEY (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP) REFERENCES qrtz_triggers (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS qrtz_cron_triggers;
CREATE TABLE qrtz_cron_triggers (
  SCHED_NAME varchar(120) NOT NULL COMMENT 'scheduler名称',
  TRIGGER_NAME varchar(200) NOT NULL COMMENT 'trigger名称',
  TRIGGER_GROUP varchar(200) NOT NULL COMMENT 'trigger分组',
  CRON_EXPRESSION varchar(120) NOT NULL COMMENT '执行时间表达式',
  TIME_ZONE_ID varchar(80) DEFAULT NULL COMMENT '使用时区',
  PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
  CONSTRAINT qrtz_cron_triggers_ibfk_1 FOREIGN KEY (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP) REFERENCES qrtz_triggers (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS qrtz_fired_triggers;
CREATE TABLE qrtz_fired_triggers (
  SCHED_NAME varchar(120) NOT NULL,
  ENTRY_ID varchar(95) NOT NULL,
  TRIGGER_NAME varchar(200) NOT NULL,
  TRIGGER_GROUP varchar(200) NOT NULL,
  INSTANCE_NAME varchar(200) NOT NULL,
  FIRED_TIME bigint(13) NOT NULL,
  SCHED_TIME bigint(13) NOT NULL,
  PRIORITY int(11) NOT NULL,
  STATE varchar(16) NOT NULL,
  JOB_NAME varchar(200) DEFAULT NULL,
  JOB_GROUP varchar(200) DEFAULT NULL,
  IS_NONCONCURRENT varchar(1) DEFAULT NULL,
  REQUESTS_RECOVERY varchar(1) DEFAULT NULL,
  PRIMARY KEY (SCHED_NAME,ENTRY_ID),
  KEY IDX_QRTZ_FT_TRIG_INST_NAME (SCHED_NAME,INSTANCE_NAME) USING BTREE,
  KEY IDX_QRTZ_FT_INST_JOB_REQ_RCVRY (SCHED_NAME,INSTANCE_NAME,REQUESTS_RECOVERY) USING BTREE,
  KEY IDX_QRTZ_FT_J_G (SCHED_NAME,JOB_NAME,JOB_GROUP) USING BTREE,
  KEY IDX_QRTZ_FT_JG (SCHED_NAME,JOB_GROUP) USING BTREE,
  KEY IDX_QRTZ_FT_T_G (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP) USING BTREE,
  KEY IDX_QRTZ_FT_TG (SCHED_NAME,TRIGGER_GROUP) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS qrtz_job_details;
CREATE TABLE qrtz_job_details (
  SCHED_NAME varchar(120) NOT NULL,
  JOB_NAME varchar(200) NOT NULL,
  JOB_GROUP varchar(200) NOT NULL,
  DESCRIPTION varchar(250) DEFAULT NULL,
  JOB_CLASS_NAME varchar(250) NOT NULL,
  IS_DURABLE varchar(1) NOT NULL,
  IS_NONCONCURRENT varchar(1) NOT NULL,
  IS_UPDATE_DATA varchar(1) NOT NULL,
  REQUESTS_RECOVERY varchar(1) NOT NULL,
  JOB_DATA blob,
  PRIMARY KEY (SCHED_NAME,JOB_NAME,JOB_GROUP),
  KEY IDX_QRTZ_J_REQ_RECOVERY (SCHED_NAME,REQUESTS_RECOVERY) USING BTREE,
  KEY IDX_QRTZ_J_GRP (SCHED_NAME,JOB_GROUP) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS qrtz_locks;
CREATE TABLE qrtz_locks (
  SCHED_NAME varchar(120) NOT NULL,
  LOCK_NAME varchar(40) NOT NULL,
  PRIMARY KEY (SCHED_NAME,LOCK_NAME)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS qrtz_paused_trigger_grps;
CREATE TABLE qrtz_paused_trigger_grps (
  SCHED_NAME varchar(120) NOT NULL,
  TRIGGER_GROUP varchar(200) NOT NULL,
  PRIMARY KEY (SCHED_NAME,TRIGGER_GROUP)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS qrtz_scheduler_state;
CREATE TABLE qrtz_scheduler_state (
  SCHED_NAME varchar(120) NOT NULL,
  INSTANCE_NAME varchar(200) NOT NULL,
  LAST_CHECKIN_TIME bigint(13) NOT NULL,
  CHECKIN_INTERVAL bigint(13) NOT NULL,
  PRIMARY KEY (SCHED_NAME,INSTANCE_NAME)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS qrtz_simple_triggers;
CREATE TABLE qrtz_simple_triggers (
  SCHED_NAME varchar(120) NOT NULL,
  TRIGGER_NAME varchar(200) NOT NULL,
  TRIGGER_GROUP varchar(200) NOT NULL,
  REPEAT_COUNT bigint(7) NOT NULL,
  REPEAT_INTERVAL bigint(12) NOT NULL,
  TIMES_TRIGGERED bigint(10) NOT NULL,
  PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
  CONSTRAINT qrtz_simple_triggers_ibfk_1 FOREIGN KEY (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP) REFERENCES qrtz_triggers (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS qrtz_simprop_triggers;
CREATE TABLE qrtz_simprop_triggers (
  SCHED_NAME varchar(120) NOT NULL,
  TRIGGER_NAME varchar(200) NOT NULL,
  TRIGGER_GROUP varchar(200) NOT NULL,
  STR_PROP_1 varchar(512) DEFAULT NULL,
  STR_PROP_2 varchar(512) DEFAULT NULL,
  STR_PROP_3 varchar(512) DEFAULT NULL,
  INT_PROP_1 int(11) DEFAULT NULL,
  INT_PROP_2 int(11) DEFAULT NULL,
  LONG_PROP_1 bigint(20) DEFAULT NULL,
  LONG_PROP_2 bigint(20) DEFAULT NULL,
  DEC_PROP_1 decimal(13,4) DEFAULT NULL,
  DEC_PROP_2 decimal(13,4) DEFAULT NULL,
  BOOL_PROP_1 varchar(1) DEFAULT NULL,
  BOOL_PROP_2 varchar(1) DEFAULT NULL,
  PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
  CONSTRAINT qrtz_simprop_triggers_ibfk_1 FOREIGN KEY (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP) REFERENCES qrtz_triggers (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS qrtz_triggers;
CREATE TABLE qrtz_triggers (
  SCHED_NAME varchar(120) NOT NULL,
  TRIGGER_NAME varchar(200) NOT NULL,
  TRIGGER_GROUP varchar(200) NOT NULL,
  JOB_NAME varchar(200) NOT NULL,
  JOB_GROUP varchar(200) NOT NULL,
  DESCRIPTION varchar(250) DEFAULT NULL,
  NEXT_FIRE_TIME bigint(13) DEFAULT NULL,
  PREV_FIRE_TIME bigint(13) DEFAULT NULL,
  PRIORITY int(11) DEFAULT NULL,
  TRIGGER_STATE varchar(16) NOT NULL,
  TRIGGER_TYPE varchar(8) NOT NULL,
  START_TIME bigint(13) NOT NULL,
  END_TIME bigint(13) DEFAULT NULL,
  CALENDAR_NAME varchar(200) DEFAULT NULL,
  MISFIRE_INSTR smallint(2) DEFAULT NULL,
  JOB_DATA blob,
  PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
  KEY IDX_QRTZ_T_J (SCHED_NAME,JOB_NAME,JOB_GROUP) USING BTREE,
  KEY IDX_QRTZ_T_JG (SCHED_NAME,JOB_GROUP) USING BTREE,
  KEY IDX_QRTZ_T_C (SCHED_NAME,CALENDAR_NAME) USING BTREE,
  KEY IDX_QRTZ_T_G (SCHED_NAME,TRIGGER_GROUP) USING BTREE,
  KEY IDX_QRTZ_T_STATE (SCHED_NAME,TRIGGER_STATE) USING BTREE,
  KEY IDX_QRTZ_T_N_STATE (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP,TRIGGER_STATE) USING BTREE,
  KEY IDX_QRTZ_T_N_G_STATE (SCHED_NAME,TRIGGER_GROUP,TRIGGER_STATE) USING BTREE,
  KEY IDX_QRTZ_T_NEXT_FIRE_TIME (SCHED_NAME,NEXT_FIRE_TIME) USING BTREE,
  KEY IDX_QRTZ_T_NFT_ST (SCHED_NAME,TRIGGER_STATE,NEXT_FIRE_TIME) USING BTREE,
  KEY IDX_QRTZ_T_NFT_MISFIRE (SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME) USING BTREE,
  KEY IDX_QRTZ_T_NFT_ST_MISFIRE (SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME,TRIGGER_STATE) USING BTREE,
  KEY IDX_QRTZ_T_NFT_ST_MISFIRE_GRP (SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME,TRIGGER_GROUP,TRIGGER_STATE) USING BTREE,
  CONSTRAINT qrtz_triggers_ibfk_1 FOREIGN KEY (SCHED_NAME, JOB_NAME, JOB_GROUP) REFERENCES qrtz_job_details (SCHED_NAME, JOB_NAME, JOB_GROUP)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_batch_group
-- ----------------------------
DROP TABLE IF EXISTS t_batch_group;
CREATE TABLE t_batch_group (
  ID varchar(32) NOT NULL COMMENT '主键',
  NAME varchar(32) NOT NULL COMMENT '任务组名',
  MEMO varchar(255) NOT NULL DEFAULT '' COMMENT '任务组描述',
  FAILABLE tinyint(4) NOT NULL DEFAULT '0' COMMENT '遇到异常，0停止、1忽略、2续跑、3重试',
  FREEZE_TIME int(11) DEFAULT '0',
  TIMEOUT int(11) NOT NULL DEFAULT '180' COMMENT '任务组超时设置',
  CATALOG varchar(16) NOT NULL DEFAULT 'cif' COMMENT '所属系统',
  PARAMS text COMMENT '附加参数',
  FOLLOWER varchar(510) NOT NULL DEFAULT '' COMMENT '后继任务组，格式：GroupID1=delay,GroupID2=delay',
  PRIMARY KEY (ID),
  UNIQUE KEY IDX_T_BATCH_JOB_GROUP_UNIQUE_1 (NAME) USING BTREE,
  UNIQUE KEY PK_BATCH_JOB_GROUP (ID) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_batch_group_execution
-- ----------------------------
DROP TABLE IF EXISTS t_batch_group_execution;
CREATE TABLE t_batch_group_execution (
  ID bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  START_TIME char(23) NOT NULL DEFAULT 'CURRENT_TIMESTAMP',
  END_TIME char(23) NOT NULL DEFAULT '',
  STATUS tinyint(1) NOT NULL DEFAULT '0',
  IP_ADDR varchar(32) NOT NULL DEFAULT '',
  ERR_MSG varchar(255) NOT NULL DEFAULT '',
  PARAMS text NOT NULL,
  EXE_NO int(11) NOT NULL DEFAULT '1',
  EXE_TYPE tinyint(4) NOT NULL DEFAULT '0',
  GROUP_ID varchar(32) NOT NULL,
  GROUP_NAME varchar(64) NOT NULL,
  FOLLOWER varchar(255) NOT NULL DEFAULT '',
  TIMEOUT int(11) NOT NULL,
  FAILABLE tinyint(4) NOT NULL,
  CATALOG varchar(16) NOT NULL,
  PRIMARY KEY (ID),
  KEY IDX_T_BATCH_GROUP_EXECUTION_3 (START_TIME) USING BTREE,
  KEY IDX_T_BATCH_GROUP_EXECUTION_4 (STATUS) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=295 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_batch_job
-- ----------------------------
DROP TABLE IF EXISTS t_batch_job;
CREATE TABLE t_batch_job (
  ID varchar(32) NOT NULL COMMENT '主键ID',
  NAME varchar(32) NOT NULL COMMENT '任务名称',
  MEMO varchar(255) NOT NULL DEFAULT '' COMMENT '任务描述',
  GROUP_ID varchar(32) NOT NULL COMMENT '所属任务组ID',
  PRIORITY int(11) NOT NULL COMMENT '优先级',
  TIMEOUT int(11) NOT NULL DEFAULT '60' COMMENT '超时设置',
  RELY_ON varchar(255) NOT NULL DEFAULT '' COMMENT '依赖哪些JOB，格式: ''jobId1'',''jobId2''',
  FAILABLE tinyint(4) NOT NULL DEFAULT '0' COMMENT '遇到异常，0停止、1忽略、2续跑、3重试',
  PARAMS text,
  PRIMARY KEY (ID),
  UNIQUE KEY IDX_T_BATCH_JOB_UNIQUE_1 (NAME,GROUP_ID) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_batch_job_execution
-- ----------------------------
DROP TABLE IF EXISTS t_batch_job_execution;
CREATE TABLE t_batch_job_execution (
  ID bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  GROUP_EXE_ID bigint(20) NOT NULL,
  IP_ADDR varchar(64) NOT NULL,
  START_TIME char(23) NOT NULL DEFAULT 'CURRENT_TIMESTAMP',
  END_TIME char(23) NOT NULL DEFAULT '',
  STATUS tinyint(4) NOT NULL DEFAULT '0',
  ERR_MSG varchar(255) NOT NULL DEFAULT '',
  STEP_INDEX decimal(8,0) NOT NULL DEFAULT '0',
  PARAMS text NOT NULL,
  EXE_NO int(11) NOT NULL DEFAULT '1',
  EXE_TYPE tinyint(4) NOT NULL DEFAULT '0',
  PERIOD int(11) NOT NULL DEFAULT '1' COMMENT '挂起后的检查间隔，单位分钟',
  JOB_ID varchar(32) NOT NULL,
  JOB_NAME varchar(64) NOT NULL,
  GROUP_ID varchar(32) NOT NULL COMMENT '所属任务组ID',
  PRIORITY int(11) NOT NULL COMMENT '优先级',
  TIMEOUT int(11) NOT NULL DEFAULT '60' COMMENT '超时设置',
  RELY_ON varchar(255) NOT NULL DEFAULT '' COMMENT '依赖哪些JOB，格式: ''jobId1'',''jobId2''',
  FAILABLE tinyint(4) NOT NULL DEFAULT '0' COMMENT '遇到异常，0停止、1忽略、2续跑、3重试',
  PRIMARY KEY (ID),
  UNIQUE KEY PK_BATCH_JOB_EXECUTION (ID) USING BTREE,
  KEY IDX_T_BATCH_JOB_EXECUTION_1 (JOB_ID) USING BTREE,
  KEY IDX_T_BATCH_JOB_EXECUTION_2 (GROUP_EXE_ID) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=338 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_batch_object_execution
-- ----------------------------
DROP TABLE IF EXISTS t_batch_object_execution;
CREATE TABLE t_batch_object_execution (
  STEP_EXE_ID bigint(20) NOT NULL,
  OBJECT_INDEX int(11) NOT NULL DEFAULT '0',
  PAGE_TOTAL int(11) NOT NULL DEFAULT '0',
  PAGE_COUNT int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (STEP_EXE_ID,OBJECT_INDEX),
  KEY IDX_T_BATCH_OBJECT_EXECUTION_1 (STEP_EXE_ID) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_batch_schedule
-- ----------------------------
DROP TABLE IF EXISTS t_batch_schedule;
CREATE TABLE t_batch_schedule (
  ID varchar(32) NOT NULL COMMENT '主键ID',
  GROUP_ID varchar(32) NOT NULL COMMENT '任务组名称',
  CRON_EXPRESSION varchar(64) DEFAULT NULL,
  START_TIME date DEFAULT NULL COMMENT '开始时间',
  STOP_TIME date DEFAULT NULL COMMENT '结束时间',
  IP_ADDR varchar(128) NOT NULL DEFAULT '' COMMENT '废弃（暂时保留）',
  STATUS tinyint(4) NOT NULL DEFAULT '0' COMMENT '0:停用，1:启用',
  QUARTZ_JOB_CLASS varchar(128) NOT NULL DEFAULT '' COMMENT '要定时执行的类，为空时是调起Group',
  PRIMARY KEY (ID),
  UNIQUE KEY PK_BATCH_SCHEDULE (ID) USING BTREE,
  UNIQUE KEY IDX_T_BATCH_SCHEDULE_UNIQUE_1 (GROUP_ID) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_batch_step
-- ----------------------------
DROP TABLE IF EXISTS t_batch_step;
CREATE TABLE t_batch_step (
  ID varchar(32) NOT NULL COMMENT '主键',
  NAME varchar(32) NOT NULL COMMENT '任务步骤名',
  MEMO varchar(64) NOT NULL DEFAULT '' COMMENT '任务步骤描述',
  JOB_ID varchar(32) NOT NULL COMMENT '所属任务ID',
  PRIORITY int(11) NOT NULL DEFAULT '0' COMMENT '优先级，1~10，值越大优先级越高',
  CLAZZ varchar(255) NOT NULL DEFAULT '' COMMENT '步骤处理BEAN',
  TIMEOUT int(11) NOT NULL DEFAULT '20' COMMENT '超时设置，超时后任务步骤会主动停止',
  COMMIT_NUM int(11) NOT NULL DEFAULT '100' COMMENT '多少笔数据提交一次',
  PAGE_SIZE int(11) NOT NULL DEFAULT '50000' COMMENT '分页大小',
  CONCURRENT tinyint(4) NOT NULL DEFAULT '1' COMMENT '并发标识，有效值：0,1,11,12,21,22',
  MAX_THREADS int(11) NOT NULL DEFAULT '200' COMMENT '单节点最大并发数',
  FAILABLE tinyint(4) NOT NULL DEFAULT '0' COMMENT '遇失败 0停止、1忽略、2续跑、3重试',
  PERIOD int(11) DEFAULT '60' COMMENT '挂起后的检查时间间隔，单位秒',
  NO tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (ID),
  UNIQUE KEY PK_BATCH_STEP (ID) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_batch_step_execution
-- ----------------------------
DROP TABLE IF EXISTS t_batch_step_execution;
CREATE TABLE t_batch_step_execution (
  ID bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  JOB_EXE_ID bigint(20) NOT NULL,
  IP_ADDR varchar(64) NOT NULL DEFAULT '',
  START_TIME char(23) NOT NULL DEFAULT 'CURRENT_TIMESTAMP',
  END_TIME char(23) NOT NULL DEFAULT '',
  STATUS tinyint(4) NOT NULL DEFAULT '0',
  ERR_MSG varchar(255) NOT NULL DEFAULT '',
  OBJECT_TOTAL int(11) NOT NULL DEFAULT '1',
  OBJECT_COUNT int(11) NOT NULL DEFAULT '0',
  PARAMS text NOT NULL,
  EXE_NO int(11) NOT NULL DEFAULT '1',
  EXE_TYPE tinyint(4) NOT NULL DEFAULT '0',
  STEP_INDEX int(11) NOT NULL DEFAULT '0',
  STEP_ID varchar(32) NOT NULL,
  STEP_NAME varchar(64) NOT NULL,
  JOB_ID varchar(32) NOT NULL COMMENT '所属任务ID',
  PRIORITY int(11) NOT NULL DEFAULT '0' COMMENT '优先级，1~10，值越大优先级越高',
  CLAZZ varchar(255) NOT NULL DEFAULT '' COMMENT '步骤处理BEAN',
  TIMEOUT int(11) NOT NULL DEFAULT '20' COMMENT '超时设置，超时后任务步骤会主动停止',
  COMMIT_NUM int(11) NOT NULL DEFAULT '100' COMMENT '多少笔数据提交一次',
  PAGE_SIZE int(11) NOT NULL DEFAULT '50000' COMMENT '分页大小',
  CONCURRENT tinyint(4) NOT NULL DEFAULT '1' COMMENT '并发标识，有效值：0,1,11,12,21,22',
  MAX_THREADS int(11) NOT NULL DEFAULT '200' COMMENT '单节点最大并发数',
  FAILABLE tinyint(4) NOT NULL DEFAULT '0' COMMENT '遇失败 0停止、1忽略、2续跑、3重试',
  PERIOD int(11) DEFAULT '60' COMMENT '单位秒',
  PRIMARY KEY (ID),
  UNIQUE KEY PK_BATCH_STEP_EXECUTION (ID) USING BTREE,
  KEY IDX_T_BATCH_STEP_EXECUTION_2 (STATUS) USING BTREE,
  KEY IDX_T_BATCH_STEP_EXECUTION_1 (JOB_EXE_ID) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=368 DEFAULT CHARSET=utf8;
