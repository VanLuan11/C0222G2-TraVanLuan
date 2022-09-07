import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LapTopGamingComponent } from './lap-top-gaming.component';

describe('LapTopGamingComponent', () => {
  let component: LapTopGamingComponent;
  let fixture: ComponentFixture<LapTopGamingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LapTopGamingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LapTopGamingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
