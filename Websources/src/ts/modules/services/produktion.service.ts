/**
 * Created by boebel on 18.01.2017.
 */


import {Injectable, EventEmitter} from '@angular/core';
import {Http, Headers} from "@angular/http";

import 'rxjs/Rx';
import {Subject} from "rxjs/Subject";
import {Observable} from "rxjs/Observable";

@Injectable()
export class ProduktionService {


    private productlinesSubject = new Subject<any>();
    private machinesSubject = new Subject<any>();
    private warehouseSubject = new Subject<any>();

    constructor(private http: Http) {
        this.http = http;
    }


    produzieren(data) {
        this.http.post('http://localhost:8080/rest/companies/production', data)
            .map(res => res.text())
            .subscribe(data => {
                    if (data.toString().startsWith("ERROR"))
                        this.productlinesSubject.next("ERROR" + 2);
                    else this.productlinesSubject.next("new Product")
                },
                err => console.log(err)
            );
    }

    getProductlinesSubject() {
        return this.productlinesSubject.asObservable();
    }

    getMachinesSubject() {
        return this.machinesSubject;
    }

    getWarehouseSubject() {
        return this.warehouseSubject;
    }


    kaufeMaschine(data) {
        return this.http.post('http://localhost:8080/rest/companies/production/machines', data)
            .map(res => res.text())
            .subscribe(data => {
                if (data.toString().startsWith("ERROR"))
                    this.machinesSubject.next("ERROR" + 1);
                else this.machinesSubject.next("Neue Maschine")
            });
    }

    kaufeLager(size) {
        return this.http.post('http://localhost:8080/rest/companies/production/warehouses', size).map(res => res.text());
    }

    getLagerkapazitaet() {
        return this.http.get('http://localhost:8080/rest/companies/production/warehouses/capacities').map(res => res.json());
    }

    getLagerkapazitaetIntervall() {
        return Observable.interval(5000).flatMap(() => this.http.get('http://localhost:8080/rest/companies/production/warehouses/capacities').map(res => res.json()));
    }

    kaufeProduktionshalle(size) {
        return this.http.post('http://localhost:8080/rest/companies/production/halls', size).map(res => res.text());
    }

    getProduktionshallenkapazitaet() {
        return this.http.get('http://localhost:8080/rest/companies/production/halls/capacities').map(res => res.json());
    }

    getProduktlinien() {
        return this.http.get('http://localhost:8080/rest/companies/production/productlines').map(res => res.json());
    }

    getMachines() {
        return this.http.get('http://localhost:8080/rest/companies/production/machines').map(res => res.json());
    }

    repairMachines(index) {
        return this.http.put('http://localhost:8080/rest/companies/production/machines', index).map(res => res.text());
    }
    getMachinesStatus(no)
    {
        return this.http.get('http://localhost:8080/rest/companies/production/machines/' + no+ '/status').map(res=>res.text());
    }

    sell(index) {
        return this.http.delete('http://localhost:8080/rest/companies/production/machines/' + index).map(res => res.text()).subscribe(
            (data)=> this.machinesSubject.next(data),
            err=>console.log(err)
        );
    }

    getStaticMachinesEnergyCosts()
    {
        return this.http.get('http://localhost:8080/rest/companies/production/machines/energy').map(res => res.text());
    }
}
