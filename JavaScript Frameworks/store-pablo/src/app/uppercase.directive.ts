import { Directive } from '@angular/core';
import { HostListener } from '@angular/core/src/metadata/directives';
import { ElementRef } from '@angular/core/src/linker/element_ref';

@Directive({ selector: '[upperCase]' })
export class UppercaseDirective {
    constructor(
        private el: ElementRef
    ) { }

    @HostListener("keyup") keyup(){
        this.el.nativeElement.value =    this.el.nativeElement.value.toUpperCase();
    }
}