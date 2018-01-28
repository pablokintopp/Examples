<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

// Exemplos do uso das rotas

Route::get('/', function () {
    return view('welcome');
});

Route::get('testcontact',function(){

    return "Página de contato";
});


Route::post('testcontact',function(){

    return "Realizando um Post";
});

Route::put('testcontact',function(){

    return "Realizando um Put";
});

Route::delete('testcontact',function(){

    return "Realizando um Delete";
});

//Uso de match(), aceita qualquer requisicao dentro de [...]
Route::match(['get','post'],'testabout',function(){

    return "Trabalhando com Match!";

});

//aceta qualquer requisicao
Route::any('all',function(){

    return "Trabalhando com Any";

});

//Uso de url()
Route::any('all2',function(){
    $url = url('new');

    return "Todos! ".$url;

});

//Uso de parametro 
Route::get('article/{id}',function($id){

    return "Artigo id: {$id}";
});

//Passando parametros opcional
Route::get('testproduct/{id?}',function($id = null){

    return "Produto id: {$id}";
});

//multiplos parametros opcionais
Route::get('model/{id?}/{color?}',function($id = null, $color = "white"){

    return "Model id: {$id} cor = {$color}";
});


//criando o apelido para rota
Route::get('changed/detail',['as'=>'detail',function(){

    return "teste";
}]);

//usando o apelido da rota
Route::get('link',['as'=>'link',function(){

    return 'Link <a href="'.route('detail').'">Detalhe</a>';
}]);


//multiplas rotas para um mesmo prefixo
Route::group(['prefix' => 'admin'], function() {

    Route::get('contact',function(){
        return "Página admin contato!";
    });

    Route::get('about',function(){
        return "Página admin sobre!";
    });

    Route::get('config',function(){
        return "Página admin configuração!";
    });

    Route::get('etc',function(){
        return "Página admin etc!";
    });
});


//Associar rota com controller
Route::get('student','Student\StudentController@index' );

//Associar rota com controller usando apelido
Route::get('book', ['uses' => 'BookController@index', 'as' => 'book.index']);

//Definir Controller implicito
Route::resource('product', 'ProductController');

//Rota para view home
Route::get('home', function(){

    $users = array(
        ['name'=>'Pablo'],
        ['name'=>'Tiburcio'],
        ['name'=>'Fulano'],
        ['name'=>'Ciclano'],
        ['name'=>'Juca']        
        );

        $books = [];

    return view('home', compact('users','books'));
});


Route::get("user",['uses' => 'UserController@index', 'as' => 'user']);