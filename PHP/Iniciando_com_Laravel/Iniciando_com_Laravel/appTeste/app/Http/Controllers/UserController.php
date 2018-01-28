<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use App\User;

class UserController extends Controller
{
    public function index(){

      //  $userObject = new App\User;
      $userObject = new User;

      $user = $userObject->getUser();

      $list = User::listUser();

        return view('user.index',compact('user','list'));
    }
}
