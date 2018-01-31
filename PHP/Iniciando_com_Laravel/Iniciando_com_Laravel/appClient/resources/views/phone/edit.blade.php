@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-12 ">
            <div class="panel panel-default">                
                <ol class="breadcrumb panel-heading">
                    <li><a href="{{route('client.index')}}">Clientes</a></li>
                    <li><a href="{{ route('client.detail',$phone->client->id) }}">Detalhe</a></li>
                    <li class="active">Editar</li>
                </ol>
                <div class="panel-body">
                    <form action="{{route('phone.update', $phone->id)}}" method="post">
                        {{ csrf_field() }}
                        <input type="hidden" name="_method" value="put">
                        <div class="form-group">
                          <label for="title">Titulo</label>
                          <input type="text"class="form-control" name="title" placeholder="Titulo do telefone" value="{{ $phone->title }}">                          
                        </div>
                        <div class="form-group">
                          <label for="phone">Telefone</label>
                          <input type="telephone" class="form-control" name="phone"  placeholder="Numero do telefone" value="{{ $phone->phone }}">                          
                        </div>
                        
                        <button  class="btn btn-primary">Atualizar</button>

                    </form>
                    
                </div>
            </div>
        </div>
    </div>
</div>
@endsection