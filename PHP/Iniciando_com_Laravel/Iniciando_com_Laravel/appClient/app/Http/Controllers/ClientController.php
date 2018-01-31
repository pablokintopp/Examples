<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;

class ClientController extends Controller
{
    public function __construct()
    {
        $this->middleware('auth');
    }

    public function index()
    {
        $clients = \App\Client::paginate(15);

       // dd($clients);

        return view('client.index',compact('clients'));
    }

    public function add()
    {
               
        return view('client.add');
    }

    public function save(\App\Http\Requests\ClientRequest $request)
    {
        \App\Client::create($request->all());
        
        \Session::flash('flash_message', [
            'msg' => 'Cliente adicionado com sucesso!',
            'class' => 'alert-success'
        ]);
        
        return redirect()->route('client.add');
    }

    public function edit($id)
    {
        
        $client = \App\Client::find($id);

        if($client){

            return view('client.edit', compact('client'));

        }else{
            \Session::flash('flash_message', [
                'msg' => 'Cliente não encontrado!',
                'class' => 'alert-danger'
            ]);

            return redirect()->route('client.add');
        }

        
    }

    public function update(Request $request,$id)
    {
        
       \App\Client::find($id)->update($request->all());

        
        \Session::flash('flash_message', [
            'msg' => 'Cliente atualizado com sucesso',
            'class' => 'alert-success'
        ]);

        return redirect()->route('client.index');       

        
    }

    public function delete($id)
    {
        
       $client =  \App\Client::find($id);



       if($client->deletePhones()){

            $client->delete();
            \Session::flash('flash_message', [
                'msg' => 'Cliente deletado com sucesso',
                'class' => 'alert-success'
            ]);
            return redirect()->route('client.index'); 

       }else{

            \Session::flash('flash_message', [
                'msg' => 'Registro não pode ser deletado!',
                'class' => 'alert-danger'
            ]);

            return redirect()->route('client.index');

       }      

        
    }

    public function detail($id)
    {
        
       $client = \App\Client::find($id);

        if(!$client){
            \Session::flash('flash_message', [
                'msg' => 'Cliente não encontrado!',
                'class' => 'alert-danger'
            ]);
            return redirect()->route('client.index'); 
        }else{
            return view('client.detail',compact('client')); 
        }

              

        
    }

}
