import {Component, OnInit} from '@angular/core';
import {Contract} from "../contract";
import {Customer} from "../../customer/customer";

@Component({
  selector: 'app-list-contract',
  templateUrl: './list-contract.component.html',
  styleUrls: ['./list-contract.component.css']
})
export class ListContractComponent implements OnInit {
  contract: Contract[] = [];

  constructor() {
    this.contract.push({id:1, startDate:'2022-04-07', endDate: '2022-04-07', deposit: 1000000, totalMoney: 2000000,
      customer:'tài ngu', service:'chuồng ngựa'})
    this.contract.push({id:2, startDate:'2022-04-07', endDate: '2022-04-07', deposit: 1000000, totalMoney: 2000000,
      customer:'tài ngu', service:'chuồng ngựa'})
    this.contract.push({id:3, startDate:'2022-04-07', endDate: '2022-04-07', deposit: 1000000, totalMoney: 2000000,
      customer:'tài ngu', service:'chuồng ngựa'})
  }

  ngOnInit(): void {
  }

}
