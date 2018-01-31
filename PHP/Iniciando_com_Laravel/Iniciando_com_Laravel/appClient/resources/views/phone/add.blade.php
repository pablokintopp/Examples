@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-12 ">
            <div class="panel panel-default">                
                <ol class="breadcrumb panel-heading">
                    <li><a href="{{route('client.index')}}">Clientes</a></li>
                    <li><a href="{{route('client.detail',$client->id)}}">Detalhe</a></li>
                    <li class="active">Adicionar</li>
                </ol>
                <div class="panel-body">
                    <form action="{{route('phone.save', $client->id)}}" method="post">
                        {{ csrf_field() }}
                        <div class="form-group {{ $errors->has('title') ? 'has-error': ' ' }}">
                          <label for="title">Titulo</label>
                          <input type="text"class="form-control" name="title" placeholder="Titulo do telefone">     
                          @if ($errors->has('title') )
                              <span class="help-block">
                                  <strong>{{ $errors->first('title')}} </strong>
                              </span>
                          @endif                      
                        </div>
                        <div class="form-group {{ $errors->has('phone') ? 'has-error': ' ' }}">
                          <label for="phone">Telefone</label>
                          <input type="telephone" class="form-control" name="phone"  placeholder="Numero do telefone">
                          @if ($errors->has('phone') )
                              <span class="help-block">
                                  <strong>{{ $errors->first('phone')}} </strong>
                              </span>
                          @endif                           
                        </div>
                        
                        <button  class="btn btn-primary">Adicionar</button>

                    </form>
                    
                </div>
            </div>
        </div>
    </div>
</div>
@endsection