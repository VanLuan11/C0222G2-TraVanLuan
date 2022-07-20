import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CountdownTimerAppComponent } from './countdown-timer-app.component';

describe('CountdownTimerAppComponent', () => {
  let component: CountdownTimerAppComponent;
  let fixture: ComponentFixture<CountdownTimerAppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CountdownTimerAppComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CountdownTimerAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
