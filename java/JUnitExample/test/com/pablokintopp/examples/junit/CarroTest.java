package com.pablokintopp.examples.junit;

import org.junit.Test;

import java.time.LocalDate;

public class CarroTest {

    //Verifica se a exceção de ano de lancamento maior que ano da compra será disparada
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionForInvalidReleaseYear(){
        new Car("Logan","Renault",2200, LocalDate.ofYearDay(2010,100));
    }

}
