"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
/**
 * Created by boebel on 04.01.2017.
 */
var core_1 = require("@angular/core");
var RegisterFormularComponent = (function () {
    function RegisterFormularComponent() {
    }
    return RegisterFormularComponent;
}());
RegisterFormularComponent = __decorate([
    core_1.Component({
        selector: 'register-formular',
        templateUrl: '../../../../templates/components/register-formular.component.html'
    })
], RegisterFormularComponent);
exports.RegisterFormularComponent = RegisterFormularComponent;
