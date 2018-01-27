<?php
//Model

class UserModel{
	
	public function listAll(){
		return Array(
			["name" => "Pablo"],
			["name" => "Tiburcio"],
			["name" => "Ciclano"],
			["name" => "Fulano"],
			["name" => "Regina"]			
		);		
	}	
}

//Controller

class MainController{
	public function home(){
		$user = new UserModel();
		$list = $user->listAll();
		return $list;
	}
}

//View

$mainController = new MainController();
$list = $mainController->home();

?>

<html>
	<header>
		<title>Exemplo siples MVC em PHP</title>
	</header>
	<body>
		<h1>Lista de usuários</h1>
		<ul>
			<?php foreach ($list as $user) : ?>
				<li> <?php echo $user['name'] ?></li>
			<?php endforeach; ?>
		</ul>
	</body>
</html>