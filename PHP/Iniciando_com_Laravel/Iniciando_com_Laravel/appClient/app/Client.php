<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Client extends Model
{
    protected $fillable = [ 'name', 'email', 'address' ];
    
    public function phones(){

        return $this->hasMany('App\Phone');
    }

    public function addPhone(Phone $phone){

        return $this->phones()->save($phone);
    }

    public function deletePhones(){

        foreach ($this->phones as $phone) {
            $phone->delete();
        }

        return true;
    }
}
