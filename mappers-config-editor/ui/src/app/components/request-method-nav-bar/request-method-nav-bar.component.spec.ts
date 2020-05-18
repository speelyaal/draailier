import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestMethodNavBarComponent } from './request-method-nav-bar.component';

describe('RequestMethodNavBarComponent', () => {
  let component: RequestMethodNavBarComponent;
  let fixture: ComponentFixture<RequestMethodNavBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestMethodNavBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestMethodNavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
