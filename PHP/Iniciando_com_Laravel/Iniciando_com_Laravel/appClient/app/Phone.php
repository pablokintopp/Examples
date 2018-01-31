<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Phone extends Model
{
    protected $fillable = ['title','phone'];
    
    public function client(){

        return $this->belongsTo('App\Client');
    }

    
}
