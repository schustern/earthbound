/**
 * Created by boebel on 04.01.2017.
 */

import {Component, OnInit} from '@angular/core';
import {HomeService} from "../services/home.service";

@Component({
    selector: 'start-component',
    templateUrl: '../../../../templates/components/start.component.html',
    providers : [HomeService]
})

export class StartComponent{

    homeService;

    constructor(homeService:HomeService){
        this.homeService = homeService;
        var validateToken = this.homeService.validateToken();

        if(validateToken)
        {
            validateToken.subscribe(data=> {
                    if (data.trim() == "true") {
                        window.location.href = "home.html";
                    }
                }
            ),err =>{console.log("Error")};
        }


    }

}
