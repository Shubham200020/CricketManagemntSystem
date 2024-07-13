import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [FooterComponent],
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.css'
})
export class FooterComponent {
  gmail:string="shubhammisra800@gmail.com"
 copyrite:string="@copyright cricket Club by Shubham"

}
