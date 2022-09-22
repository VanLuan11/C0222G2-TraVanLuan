import {Component, OnInit} from '@angular/core';
import * as Chart from 'chart.js'

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {
  public canvas: any;
  a: number = 222222;
  public ctx: any;
  public labels: any = ['JAN', 'FEB', 'MAR', 'APR', 'MAY', 'JUN', 'JUL', 'AUG', 'SEP', 'OCT', 'NOV', 'DEC'];
  public dataCases: any = {
    chart1: [2000, 10000, 12000, 14000, 6000, 0, 0, 0, this.a, 0, 345340, 345340],
    chart2: [200, 1000, 1200, 1400, 600, 8640, 730, 0, 3450, 4560, 8220, 345340],
    chart3: [200, 1000, 1200, 1400, 600, 8640, 730, 0, 3450, 4560, 8220, 345340]
  };

  constructor() {
  }

  ngOnInit(): void {
    this.createLineChart(this.labels, this.dataCases, 'myChart');
  }

  private createLineChart(labels, dataCases, chartId) {
    this.canvas = document.getElementById(chartId);
    this.ctx = this.canvas.getContext('2d');

    let chart = new Chart(this.ctx, {
      type: 'bar',
      data: {
        labels: labels,
        datasets: [{
          label: "Chart 1",
          data: dataCases.chart1,
          backgroundColor: '#ffbb33',
          borderColor: '#ffbb33',
          fill: false,
          borderWidth: 2
        },
          {
            label: "Chart 2",
            data: dataCases.chart2,
            backgroundColor: '#ff4444',
            borderColor: '#ff4444',
            fill: false,
            borderWidth: 2
          },
          {
            label: "Chart 3",
            data: dataCases.chart3,
            backgroundColor: '#1bff00',
            borderColor: '#1bff00',
            fill: false,
            borderWidth: 2
          }]
      },
      options: {
        title: {
          display: true,
          text: ""
        },
        tooltips: {
          mode: 'index',
          intersect: true
        },
        hover: {
          mode: 'nearest',
          intersect: true
        },

      }
    });
  }

}
