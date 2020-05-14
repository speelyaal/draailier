import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfigMapperComponent } from './config-mapper.component';

describe('ConfigMapperComponent', () => {
  let component: ConfigMapperComponent;
  let fixture: ComponentFixture<ConfigMapperComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConfigMapperComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfigMapperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
