import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestMapperComponent } from './request-mapper.component';

describe('RequestMapperComponent', () => {
  let component: RequestMapperComponent;
  let fixture: ComponentFixture<RequestMapperComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestMapperComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestMapperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
