@extends('layout.main')

@section('title','Home')


@section('navbar')
    @parent
    <p> nova navbar</p>
@endsection
@section('content')
    <p>Aqui é o conteudo da home</p>
    @if(2 === 1)
        É igual 
    @elseif( 2 > 1)
        É maior
    @endif

    <br>
    @for( $i=0; $i < 3 ; $i++)
        Contando com nosso for {{$i}}
    @endfor

    <br>
    @foreach ($users as $user)
        <p>Nome: {{ $user['name'] }}</p>
    @endforeach

    <br>

    @forelse ($books as $book)

        {{$book['title']}}

    @empty
        <p>Sem registros par a livros</p>

    @endforelse

    <br>

    <?php $i = 0; ?>

    @while ($i <= 4)
        Teste while: {{$i++}}
       
    @endwhile


@endsection