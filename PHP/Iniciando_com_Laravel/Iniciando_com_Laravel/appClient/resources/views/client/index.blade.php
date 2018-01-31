@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-12 ">
            <div class="panel panel-default">
                <div class="panel-heading">Lista de clientes</div>

                <div class="panel-body">
                    <ol class="breadcrumb panel-heading">
                        <li class="active" >Clientes</li>
                        <li><a href="{{route('client.add')}}" class="btn btn-info">Adicionar</a></li>
                    </ol>                   

                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Nome</th>
                                <th>E-mail</th>
                                <th>Endereço</th>
                                <th>Ação</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                                <?php 
                                    $count = count($clients);
                                ?>
                                @for ($i = 0; $i < $count; $i++)
                                    <tr>
                                        <th scope="row">{{$clients[$i]->id}}</th>
                                        <td>{{$clients[$i]->name}}</td>
                                        <td>{{$clients[$i]->email}}</td>
                                        <td>{{$clients[$i]->address}}</td>
                                        <td>
                                          <a href="{{ route('client.detail', $clients[$i]->id ) }}" class="btn btn-primary">Detalhe</a>
                                            <a href="{{ route('client.edit', $clients[$i]->id ) }}" class="btn btn-default">Editar</a>
                                            <a href="javascript:(confirm('Deletar este registro?') ? window.location.href= '{{route('client.delete', $clients[$i]->id)}} ' : console.log('cancelar') )" class="btn btn-danger">Deletar</a>
                                        </td>
                                    </tr>
                                @endfor
                               
                            
                        </tbody>

                    </table>

                    <div align="center">
                        {!! $clients->links() !!}
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
@endsection