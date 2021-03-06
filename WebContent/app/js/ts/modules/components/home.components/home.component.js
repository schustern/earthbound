/**
 * Created by boebel on 04.01.2017.
 */
"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
const core_1 = require("@angular/core");
const home_service_1 = require("../../services/home.service");
let HomeComponent = class HomeComponent {
    constructor(_homeService) {
        this._homeService = _homeService;
        this._homeService.getTime().subscribe(() => this.askForZuschlag());
    }
    askForZuschlag() {
        this._homeService.getNoZuschlagError().subscribe(data => {
            if (+data > 0)
                this.openNoZuschlagModal();
        });
    }
    openNoZuschlagModal() {
        $('#noZuschlagModal').modal('show');
    }
};
HomeComponent = __decorate([
    core_1.Component({
        selector: 'home-component',
        templateUrl: '../../../../templates/components/home.components/home.component.html',
    }),
    __metadata("design:paramtypes", [home_service_1.HomeService])
], HomeComponent);
exports.HomeComponent = HomeComponent;
//# sourceMappingURL=home.component.js.map