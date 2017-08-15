DROP TABLE if EXISTS IDs;
DROP TABLE if EXISTS RXLEVEL;
DROP TABLE if EXISTS CF;
DROP TABLE if EXISTS DAC;

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

CREATE TABLE CF(
  period_start_time VARCHAR(255),
  bsc_name VARCHAR(255),
  bcf_name VARCHAR(255),
  bts_name VARCHAR(255),
  ncc_id VARCHAR(255),
  bcc_id VARCHAR(255),
  bcch_id VARCHAR(255),
  period_duration VARCHAR(255),
  db_value_low VARCHAR(255),
  db_value_high VARCHAR(255),
  ave_dl_signal_strength VARCHAR(255),
  standart_deviation VARCHAR(255),
  num_of_samples_in_class_1 VARCHAR(255),
  num_of_samples_in_class_2 VARCHAR(255),
  num_of_samples_in_class_3 VARCHAR(255)
);

CREATE TABLE DAC(
  period_start_time VARCHAR(255),
  bsc_name VARCHAR(255),
  bcf_name VARCHAR(255),
  bts_name VARCHAR(255),
  ncc_id VARCHAR(255),
  bcc_id VARCHAR(255),
  bcch_id VARCHAR(255),
  period_duration VARCHAR(255),
  db_value_low VARCHAR(255),
  db_value_high VARCHAR(255),
  ave_dl_sig_str_serv_cell_sum VARCHAR(255),
  ave_dl_sig_str_serv_cell_den VARCHAR(255),
  std_dev_of_serv_cell VARCHAR(255),
  ave_dl_sig_str_adj_cell VARCHAR(255),
  std_dev_of_adj_cell VARCHAR(255),
  nbr_of_samples_in_class1 VARCHAR(255),
  nbr_of_samples_in_class2 VARCHAR(255),
  nbr_of_samples_in_class3 VARCHAR(255)
);

