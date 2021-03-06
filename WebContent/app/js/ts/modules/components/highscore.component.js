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
const home_service_1 = require("../services/home.service");
let HighscoreComponent = class HighscoreComponent {
    constructor(_homeService) {
        this._homeService = _homeService;
        this._homeService.getHighscore().subscribe(data => this.highscore = data);
    }
};
HighscoreComponent = __decorate([
    core_1.Component({
        selector: 'highscore-component',
        templateUrl: '../../../../templates/components/highscore.component.html',
        providers: [home_service_1.HomeService]
    }),
    __metadata("design:paramtypes", [home_service_1.HomeService])
], HighscoreComponent);
exports.HighscoreComponent = HighscoreComponent;
//# sourceMappingURL=highscore.component.js.map