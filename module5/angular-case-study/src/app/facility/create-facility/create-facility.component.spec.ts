import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateFacilityComponent } from './create-facility.component';

describe('CreateFacilityComponent', () => {
  let component: CreateFacilityComponent;
  let fixture: ComponentFixture<CreateFacilityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateFacilityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateFacilityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
