<?php

use Illuminate\Database\Seeder;

class BooksTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        // DB::table('books')->insert([
        //     'title'=>'Lorem Ipsum',
        //     'desc' => 'Ipsum dollor caps dollem mere'
        // ]);

        factory('App\Book',50)->create();
    }
}
