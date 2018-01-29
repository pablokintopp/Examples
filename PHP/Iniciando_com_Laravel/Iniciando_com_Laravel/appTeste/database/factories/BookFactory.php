<?php

use Faker\Generator as Faker;

$factory->define(App\Book::class, function (Faker $faker) {
    return [
        'title'=> $faker->text(40),
        'desc'=> $faker->text(150)
    ];
});
