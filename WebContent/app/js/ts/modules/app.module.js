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
const platform_browser_1 = require("@angular/platform-browser");
const forms_1 = require("@angular/forms");
const http_1 = require("@angular/http");
const start_component_1 = require("./components/start.component");
const login_formular_component_1 = require("./components/login-formular.component");
const register_formular_component_1 = require("./components/register-formular.component");
const player_component_1 = require("./components/player.component");
const faq_component_1 = require("./components/faq.component");
const impressum_component_1 = require("./components/impressum.component");
const datenschutz_component_1 = require("./components/datenschutz.component");
const map_pipe_1 = require("./pipes/map.pipe");
const highscore_component_1 = require("./components/highscore.component");
let AppModule = class AppModule {
};
AppModule = __decorate([
    core_1.NgModule({
        imports: [
            platform_browser_1.BrowserModule,
            forms_1.FormsModule,
            http_1.HttpModule
        ],
        declarations: [
            start_component_1.StartComponent,
            login_formular_component_1.LoginFormComponent,
            register_formular_component_1.RegisterFormularComponent,
            player_component_1.PlayerComponent,
            faq_component_1.FAQComponent,
            impressum_component_1.ImpressumComponent,
            datenschutz_component_1.DatenschutzComponent,
            map_pipe_1.MapToIterable,
            highscore_component_1.HighscoreComponent
        ],
        bootstrap: [start_component_1.StartComponent]
    }),
    __metadata("design:paramtypes", [])
], AppModule);
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map