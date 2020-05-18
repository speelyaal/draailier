import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResponseMapperComponent } from './response-mapper.component';

describe('ResponseMapperComponent', () => {
  let component: ResponseMapperComponent;
  let fixture: ComponentFixture<ResponseMapperComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResponseMapperComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResponseMapperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
