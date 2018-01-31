<?php

use Illuminate\Database\Seeder;

class ClientsTableSeed extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        factory('App\Client',10)->create()->each(function( $u ){

            $u->phones()->save(factory('App\Phone')->make());
        });
    }
}
