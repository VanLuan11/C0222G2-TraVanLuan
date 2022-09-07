import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LapTopVanPhongComponent } from './lap-top-van-phong.component';

describe('LapTopVanPhongComponent', () => {
  let component: LapTopVanPhongComponent;
  let fixture: ComponentFixture<LapTopVanPhongComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LapTopVanPhongComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LapTopVanPhongComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
