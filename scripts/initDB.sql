DROP TABLE if EXISTS IDs;
DROP TABLE if EXISTS RXLEVEL;

CREATE TABLE IDs(
  bsc VARCHAR(255),
  bts VARCHAR(255),
  bts_id VARCHAR(255),
  bts_name VARCHAR(255),
  bsc_of_trx VARCHAR(255),
  bts_of_trx VARCHAR(255),
  trx VARCHAR(255),
  trx_id VARCHAR(255)
);

CREATE TABLE RXLEVEL(
  period_start_time VARCHAR(255),
  bsc_name VARCHAR(255),
  bcf_name VARCHAR(255),
  bts_name VARCHAR(255),
  trx_name VARCHAR(255),
  trx_id VARCHAR(255),
  ttp_id VARCHAR(255),
  trxfg_id VARCHAR(255),
  rng_id VARCHAR(255),
  period_duration VARCHAR(255),
  freq_ul_qual0 VARCHAR(255),
  freq_ul_qual1 VARCHAR(255),
  freq_ul_qual2 VARCHAR(255),
  freq_ul_qual3 VARCHAR(255),
  freq_ul_qual4 VARCHAR(255),
  freq_ul_qual5 VARCHAR(255),
  freq_ul_qual6 VARCHAR(255),
  freq_ul_qual7 VARCHAR(255),
  freq_dl_qual0 VARCHAR(255),
  freq_dl_qual1 VARCHAR(255),
  freq_dl_qual2 VARCHAR(255),
  freq_dl_qual3 VARCHAR(255),
  freq_dl_qual4 VARCHAR(255),
  freq_dl_qual5 VARCHAR(255),
  freq_dl_qual6 VARCHAR(255),
  freq_dl_qual7 VARCHAR(255)
);

