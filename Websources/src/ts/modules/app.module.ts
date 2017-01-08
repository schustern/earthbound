import {NgModule}      from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {StartComponent} from "./components/start.component";
import {LoginFormComponent} from "./components/login-formular.component";
import {RegisterFormularComponent} from "./components/register-formular.component";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule
    ],
    declarations: [
        StartComponent,
        LoginFormComponent,
        RegisterFormularComponent],

    bootstrap:    [StartComponent]
})
export class AppModule {
}

