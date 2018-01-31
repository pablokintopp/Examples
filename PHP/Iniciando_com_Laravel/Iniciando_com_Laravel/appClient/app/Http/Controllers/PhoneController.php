<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;

class PhoneController extends Controller
{
    public function __construct(){

        $this->middleware('auth');
    }

    public function add($id){

        $client = \App\Client::find($id);

        return view('phone.add',compact('client'));

    }

    public function save(\App\Http\Requests\PhoneRequest $req,$id){

        $phone = new \App\Phone;

        $phone->title = $req->input('title');
        $phone->phone = $req->input('phone');

        $client = \App\Client::find($id);
        $client->addPhone($phone);

        \Session::flash('flash_message', [
            'msg' => 'Telefone adicionado com sucesso!',
            'class' => 'alert-success'
        ]);
        
        return redirect()->route('client.detail',$id);
        
    }

    public function edit($id)
    {
        
        $phone = \App\Phone::find($id);

        if($phone){

            return view('phone.edit', compact('phone'));

        }else{
            \Session::flash('flash_message', [
                'msg' => 'Telefone não encontrado!',
                'class' => 'alert-danger'
            ]);

            return redirect()->route('client.detail',$phone->client()->id);
        }

        
    }

    public function update(Request $request,$id)
    {
        
       \App\Phone::find($id)->update($request->all());

       $phone = \App\Phone::find($id);

        \Session::flash('flash_message', [
            'msg' => 'Telefone atualizado com sucesso',
            'class' => 'alert-success'
        ]);

        return redirect()->route('client.detail',$phone->client->id);       

        
    }

    public function delete($id)
    {
        
       $phone =  \App\Phone::find($id);



       $phone->delete();    

       \Session::flash('flash_message', [
        'msg' => 'Telefone deletado com sucesso',
        'class' => 'alert-success'
    ]);
    return redirect()->route('client.detail',$phone->client->id);  

        
    }
}
