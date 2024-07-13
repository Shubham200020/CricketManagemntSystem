import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CitylocComponent } from './CitylocComponent.1';

describe('CitylocComponent', () => {
  let component: CitylocComponent;
  let fixture: ComponentFixture<CitylocComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CitylocComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CitylocComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
