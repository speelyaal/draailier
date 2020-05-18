import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestMethodMapperComponent } from './request-method-mapper.component';

describe('RequestMethodMapperComponent', () => {
  let component: RequestMethodMapperComponent;
  let fixture: ComponentFixture<RequestMethodMapperComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestMethodMapperComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestMethodMapperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
