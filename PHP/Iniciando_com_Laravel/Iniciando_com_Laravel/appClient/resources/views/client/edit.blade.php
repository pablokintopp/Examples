@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-12 ">
            <div class="panel panel-default">                
                <ol class="breadcrumb panel-heading">
                    <li><a href="{{route('client.index')}}">Clientes</a></li>
                    <li class="active">Editar</li>
                </ol>
                <div class="panel-body">
                    <form action="{{route('client.update', $client->id)}}" method="post">
                        {{ csrf_field() }}
                        <input type="hidden" name="_method" value="put">
                        <div class="form-group">
                          <label for="name">Nome</label>
                          <input type="text"class="form-control" name="name" placeholder="Nome do cliente" value="{{ $client->name }}">                          
                        </div>
                        <div class="form-group">
                          <label for="email">Email</label>
                          <input type="email" class="form-control" name="email"  placeholder="email do cliente" value="{{ $client->email }}">                          
                        </div>
                        <div class="form-group">
                          <label for="address">Endereço</label>
                          <input type="address" class="form-control" name="address"  placeholder="endereço do cliente" value="{{ $client->address }}">                          
                        </div>
                        <button  class="btn btn-primary">Atualizar</button>

                    </form>
                    
                </div>
            </div>
        </div>
    </div>
</div>
@endsection