import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeLapTopComponent } from './home-lap-top.component';

describe('HomeLapTopComponent', () => {
  let component: HomeLapTopComponent;
  let fixture: ComponentFixture<HomeLapTopComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeLapTopComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeLapTopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
