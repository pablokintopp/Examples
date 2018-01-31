<?php

use Faker\Generator as Faker;

$factory->define(App\Phone::class, function (Faker $faker) {
    return [
        'title' => $faker->name,
        'phone' => $faker->phoneNumber,
    ];
});
