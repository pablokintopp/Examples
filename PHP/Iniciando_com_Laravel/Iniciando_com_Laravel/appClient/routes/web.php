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

Route::get('/', function () {

    //array_add()
    $array = ['name' => 'Camila', 'age' => '20'];
    $array = array_add($array,'email','camila@example.com');
    //dd($array);

    //array_collapse()
    $array = [['banana','limao'],['vermelho','azul']];
    $array = array_collapse($array);
    //dd($array);

    //array_divide()
    list($key, $value) = array_divide(['name' => 'Camila', 'age' => '20']);
    //dd($key,$value);

    //array_except()
    $array = ['name' => 'Camila', 'age' => '20'];
    $array = array_except($array,'age');
    //dd($array);

    //base_path()
    $path = base_path();
    //dd($path);

    //database_path()
    $databasepath = database_path();
    //dd($databasepath);

    //public_path()
    $publicPath = public_path();
    //dd($publicPath);

    //storage_path()
    $storagePath = storage_path();
    //dd($storagePath);

    //camel_case();
    //dd(camel_case('Teste de Camel Case'));

    //snake_case();
    //dd(snake_case('Teste de Snake Case'));

    //str_limit()
    //dd(str_limit('Teste de Snake Case',5));

    return view('welcome');
});

Auth::routes();

Route::get('/client', 'ClientController@index')->name('client.index');

Route::get('/client/add', 'ClientController@add')->name('client.add');

Route::post('/client/save', 'ClientController@save')->name('client.save');

Route::get('/client/edit/{id}', 'ClientController@edit')->name('client.edit');

Route::put('/client/update/{id}', 'ClientController@update')->name('client.update');

Route::get('/client/delete/{id}', 'ClientController@delete')->name('client.delete');

Route::get('/client/detail/{id}', 'ClientController@detail')->name('client.detail');

Route::get('/phone/add/{id}', 'PhoneController@add')->name('phone.add');

Route::post('/phone/save/{id}', 'PhoneController@save')->name('phone.save');

Route::get('/phone/edit/{id}', 'PhoneController@edit')->name('phone.edit');
Route::put('/phone/update/{id}', 'PhoneController@update')->name('phone.update');
Route::get('/phone/delete/{id}', 'PhoneController@delete')->name('phone.delete');