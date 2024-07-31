import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Suman Adhikari';

  people = ["Jacky", "Jim", "Jane"]

  today = Date.now()
  
  students= [
    {name: 'Jack', course: 'MWA', gpa: 3.0},
    {name: 'Jill', course: 'EA', gpa: 3.5},
    {name: 'John', course: 'MPP', gpa: 4.2},
  ]


  clickButtonPressed(){
    console.log("Button Clicked");
    this.title = "Button Clicked";
  }
}
