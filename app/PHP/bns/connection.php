<?php 
/* define('host', 'localhost');
define('user', 'root');
define('pass', 'root');
define('db', 'users');

$conn = mysqli_connect(host, user, pass, db) or die('Unable to Connect'); */

class Constants
{
  //DATABASE DETAILS
    static $DB_SERVER="localhost";
    static $DB_NAME="u331875177_db2";
    static $USERNAME="u331875177_db2";
    static $PASSWORD="Bancusoft2020";

   /*  static $DB_SERVER="localhost";
    static $DB_NAME="id10149418_staffbns";
    static $USERNAME="id10149418_oracle";
    static $PASSWORD="oracle"; */

    //STATEMENTS
    static $SQL_SELECT_ALL="SELECT * FROM start3v2 WHERE statut = 'xxxxx'   ORDER BY ID";
	
	static $SQL_SELECT_ALL1="SELECT * FROM start3v2  ORDER BY ID";
	
	static $SQL_SELECT_ALL_VIEW ="SELECT * FROM reg_03_28_22_vw  ORDER BY id_vw";
	
	static $SQL_SELECT_ALL_2 ="SELECT * FROM reg_cuatm_06_21  ORDER BY id_cu";
	
	static $SQL_SELECT_ALL_3 ="SELECT * FROM reg_caem_06_21  ORDER BY id";
	
	static $SQL_SELECT_ALL_4 ="SELECT * FROM reg_cfp_06_21  ORDER BY id";
	
	static $SQL_SELECT_ALL_5 ="SELECT * FROM cl_cuatm_all  ORDER BY id";
	
	static $SQL_SELECT_ALL_6 ="SELECT * FROM cl_caem2  ORDER BY id";
	
	static $SQL_SELECT_ALL_7 ="SELECT * FROM cl_caem  ORDER BY id";
	
	static $SQL_SELECT_ALL_8 ="SELECT * FROM cl_cfoj  ORDER BY id";
	
	static $SQL_SELECT_ALL_9 ="SELECT * FROM cl_cocm  ORDER BY id";
	
	static $SQL_SELECT_ALL_10 ="SELECT * FROM cl_cfp  ORDER BY id";
	
	static $SQL_SELECT_ALL_11 ="SELECT * FROM cl_servicii  ORDER BY id";
	
	static $SQL_SELECT_ALL_12 ="SELECT * FROM cl_tari  ORDER BY id";
	
	static $SQL_SELECT_ALL_14 ="SELECT * FROM cl_prodmold  ORDER BY id";
	
	static $SQL_SELECT_ALL_15 ="SELECT * FROM cl_med_10_07_19  ORDER BY id";
}
?>