<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class PhoneRequest extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     *
     * @return bool
     */
    public function authorize()
    {
        return true;
    }

    public function messages(){

        return [
            'title.required' => 'Preencha um titulo',
            'title.max' => 'Titulo deve ter no máximo 255 caracteres',
            'phone.required' => 'Preencha um numero de telefone'
        ];
    }
    /**
     * Get the validation rules that apply to the request.
     *
     * @return array
     */
    public function rules()
    {
        return [
            'title' => 'required|max:255',
            'phone' => 'required'
        ];
    }
}
