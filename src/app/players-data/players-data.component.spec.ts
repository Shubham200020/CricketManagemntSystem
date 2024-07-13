import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayersDataComponent } from './players-data.component';

describe('PlayersDataComponent', () => {
  let component: PlayersDataComponent;
  let fixture: ComponentFixture<PlayersDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PlayersDataComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PlayersDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
