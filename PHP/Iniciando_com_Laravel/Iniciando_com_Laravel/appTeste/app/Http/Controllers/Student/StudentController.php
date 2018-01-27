<?php

namespace App\Http\Controllers\Student;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;

class StudentController extends Controller
{
    public function index(){
        return "Index de Aluno ".'<a href="'.route('book.index').'">Ver Livro</a>';
    }
}
