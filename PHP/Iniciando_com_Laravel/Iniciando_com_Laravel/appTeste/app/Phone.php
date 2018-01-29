<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Phone extends Model
{
    protected $fillable = ['client_id','desc','phone'];

    public function client(){

        return $this->belongsTo('App\Client');
    }
}
