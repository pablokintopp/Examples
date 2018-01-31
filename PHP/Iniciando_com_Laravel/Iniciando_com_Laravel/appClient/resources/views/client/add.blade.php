@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-12 ">
            <div class="panel panel-default">                
                <ol class="breadcrumb panel-heading">
                    <li><a href="{{route('client.index')}}">Clientes</a></li>
                    <li class="active">Adicionar</li>
                </ol>
                <div class="panel-body">
                    <form action="{{route('client.save')}}" method="post">
                        {{ csrf_field() }}

                        <div class="form-group {{ $errors->has('name') ? 'has-error': ' ' }}" > 
                          <label for="name">Nome</label>
                          <input type="text"class="form-control" name="name" placeholder="Nome do cliente">  
                          @if ($errors->has('name') )
                              <span class="help-block">
                                  <strong>{{ $errors->first('name')}} </strong>
                              </span>
                          @endif                        
                        </div>
                        <div class="form-group {{ $errors->has('email') ? 'has-error': ' ' }}">
                          <label for="email">Email</label>
                          <input type="email" class="form-control" name="email"  placeholder="email do cliente">     
                          @if ($errors->has('email') )
                              <span class="help-block">
                                  <strong>{{ $errors->first('email')}} </strong>
                              </span>
                          @endif                       
                        </div>
                        <div class="form-group {{ $errors->has('address') ? 'has-error': ' ' }}">
                          <label for="address">Endereço</label>
                          <input type="address" class="form-control" name="address"  placeholder="endereço do cliente">    
                          @if ($errors->has('address') )
                              <span class="help-block">
                                  <strong>{{ $errors->first('address')}} </strong>
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