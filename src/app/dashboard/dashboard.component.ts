import { Component } from '@angular/core';
import { TurnamentComponent } from '../turnament/turnament.component';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [TurnamentComponent],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {

}
