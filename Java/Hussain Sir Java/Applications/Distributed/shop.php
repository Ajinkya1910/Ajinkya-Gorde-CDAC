<?php
	if(isset($_GET['item'])){
		header('Content-type:text/plain');
		$item = $_GET['item'];
		$items = array('cpu' => 14000, 'hdd' => 4500, 'keyboard' => 1200, 'monitor' => 4000, 'mouse' => 800);
		if (array_key_exists($item, $items)) {
		    $stock = 50 *  rand(2, 12);
		    $price = $items[$item];
		    echo "price=$price&stock=$stock";
		}else{
			http_response_code(404);
			die();
		}
	}
?>


