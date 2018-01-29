<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Book extends Model
{
    
    protected $fillable = ['title','desc'];
    
    public function listBooks(){
        
        return $this->all();

    }

    public function tags(){

        return $this->belongsToMany('App\Tag','books_tags','books_id','tags_id');
    }

    public function addTag(Tag $tag){

        return $this->tags()->save($tag);


    }
}
