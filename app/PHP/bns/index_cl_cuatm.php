<?php

require_once 'connection.php'; 
/**
 * This class will contain methods to receive our http requests, manipulate the
 *  database and send
 * resultcu back to the client
 */
class Cl_cuatm_all{
    /**
     * 1. CONNECT TO DATABASE.
     * 2. RETURN CONNECTION OBJECT
     * 3. IF NO CONNECTION THEN RETURN NULL.
     */
    public function connectvw()
    {
        $con=new mysqli(Constants::$DB_SERVER,Constants::$USERNAME,Constants::$PASSWORD,
        Constants::$DB_NAME);
        if($con->connect_error) {
            return null;
        }else{
            return $con;
        }
    }

    
    
   
    /**
     * This method will:
     * 1. Connect to MySQL.
     * 2. Select all data from database.
     * 3. Return those data as a response.
     */
    public function selectvw()
    {
        $con=$this->connectvw();
        if($con != null)
        {
            $resultcu=$con->query(Constants::$SQL_SELECT_ALL_5);
            if($resultcu->num_rows > 0)
            {
                $cl_cuatm_all = array();
                while($row=$resultcu->fetch_array())
                {
                    array_push($cl_cuatm_all, array("id"=>$row['id'],"CODUL"=>$row['CODUL'],
					"GRUPA"=>$row['GRUPA'],"DENUMIRE"=>$row['DENUMIRE'],"full_code"=>$row['full_code'],"prgs"=>$row['prgs']));
					
                }
                print(json_encode(array("codecu" => 1,"messagecu"=>"Success", "resultcu"=>$cl_cuatm_all)));
            }else{
                print(json_encode(array("codecu" => 0, "messagecu"=>"Data Not Found")));
            }
            $con->close();

        }else{
            print(json_encode(array('codecu' =>3,
            'messagecu' => 'ERROR: PHP WAS UNABLE TO CONNECT TO MYSQL DUE TO NULL CONNECTION.')));
        }
    }
    
	
	
	
	
	public function search_cl_cuatm_all()
    {
		$querycu=$_POST['querycu'];
		$limitcu=$_POST['limitcu'];
        $startcu=$_POST['startcu'];

		$sql="SELECT * FROM cl_cuatm_all	
		
		
		WHERE 
		 
		 CODUL LIKE '%$querycu%' 
		 OR 
		 DENUMIRE LIKE '%$querycu%' 
		 OR 
		 full_code LIKE CONCAT('%','%$querycu%',';%')

         ORDER BY id
	     LIMIT
         $limitcu OFFSET $startcu
		 ";

        $con=$this->connectvw();
        if($con != null)
        {
            $resultcu=$con->query($sql);
            if($resultcu->num_rows>0)
            {
                $cl_cuatm_all=array();
                while($row=$resultcu->fetch_array())
                {
                   
					
					 array_push($cl_cuatm_all, array("id"=>$row['id'],"CODUL"=>$row['CODUL'],
					"GRUPA"=>$row['GRUPA'],"DENUMIRE"=>$row['DENUMIRE'],"full_code"=>$row['full_code'],"prgs"=>$row['prgs']));
					
					
					
					
                }
                print(json_encode(array("codecu" => 1, "messagecu"=>"Success", "resultcu"=>$cl_cuatm_all)));
            }else{
                print(json_encode(array("codecu" => 0, "messagecu"=>"Data Not Found")));
            }
            $con->close();

        }else{
            print(json_encode(array('codecu' =>3,
            'messagecu' => 'ERROR: PHP WAS UNABLE TO CONNECT TO MYSQL DUE TO NULL CONNECTION.')));
        }
    }
	
	
	
    /**
     * This method will handle our HTTP Requests.
     * Basically it checks the request type and then determines the method that needs to be
     * executed. It's kind of a controller.
     */
    public function handleRequest() {

        if($_SERVER['REQUEST_METHOD'] == 'POST')
        {
            if (isset($_POST['actioncu'])) {

                $actioncu=$_POST['actioncu'];

                if($actioncu == 'INSERT'){
                    $this->insert();
                }else if($actioncu == 'UPDATE'){
                    $this->update();
                }else if($actioncu == 'DELETE'){
                    $this->delete();
				}else if($actioncu == 'GET_PAGINATEDCUATM'){
                    $this->search_cl_cuatm_all();
				}else if($actioncu == 'GET_PAGINATED_SEARCHCUATM'){
                    $this->search_cl_cuatm_all();
                }else{
					print(json_encode(array('codecu' =>4, 'messagecu' => 'INVALID REQUEST.')));
				}
            } else{
				print(json_encode(array('codecu' =>5, 'messagecu' => 'POST TYPE UNKNOWN.')));
            }

        }else{
            $this->selectvw();
        }
    }
}

//Outside the class. Instantiate Scientist then invoke the handleRequest() to listen to our requests.
$s=new Cl_cuatm_all();
$s->handleRequest();

//end




