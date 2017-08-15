DROP TABLE if EXISTS IDs;

CREATE TABLE IDs(
  id SERIAL PRIMARY KEY,
  bsc INT,
  bts INT,
  bts_id INT,
  bts_name VARCHAR(255) NOT NULL,
  bsc_of_trx INT,
  bts_of_trx INT,
  trx_id INT
);

