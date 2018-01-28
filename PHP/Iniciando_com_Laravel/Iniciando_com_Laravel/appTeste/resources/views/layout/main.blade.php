<html>
<head>
<title>App Test - @yield('title') </title>
</head>
<body>
<header>
    @section('navbar')
    @include('layout._includes._navbar')
        <p>Aqui vamos ter nosso navbar</p>

    @show
    <hr>

</header>
<main>
    <div>
        @yield('content')
    </div>
</main>
<footer>
    <hr>
    @section('footer')
        @include('layout._includes._footer')
    @show
</footer>
</body>
</html>