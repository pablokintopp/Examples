@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-12 ">
            <div class="panel panel-default">
                <div class="panel-heading">Detalhes do cliente</div>

                <div class="panel-body">
                    <ol class="breadcrumb panel-heading">
                            <li><a href="{{route('client.index')}}">Clientes</a></li>
                            <li class="active">Detalhe</li>
                    </ol>
                              
                    <p><b>Cliente:</b> {{ $client->name }}</p>
                    <p><b>Email:</b> {{ $client->email }}</p>
                    <p><b>Endereço:</b> {{ $client->address }}</p>                    

                    
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Titulo</th>                                
                                <th>Número</th>
                                <th>Ação</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                            @foreach( $client->phones as $phone )                        
                                <tr>
                                    <th scope="row">{{$phone->id}}</th>
                                    <td>{{$phone->title}}</td>
                                    <td>{{$phone->phone}}</td>                                    
                                    <td>
                                        <a href="{{ route('phone.edit',$phone->id ) }}" class="btn btn-default">Editar</a>
                                        <a href="javascript:(confirm('Deletar este registro?') ? window.location.href= '{{route('phone.delete', $phone->id)}} ' : console.log('cancelar') )" class="btn btn-danger">Deletar</a>
                                    </td>
                                </tr>
                            @endforeach
                               
                            
                        </tbody>
                        
                    </table>
                    <p>
                        <a href="{{ route('phone.add',$client->id) }}" class="btn btn-info">Adicionar</a>                       
                    </p>

                    
                </div>
            </div>
        </div>
    </div>
</div>
@endsection