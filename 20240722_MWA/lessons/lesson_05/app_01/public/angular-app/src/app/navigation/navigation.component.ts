import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navigation',
  standalone: true,
  imports: [],
  templateUrl: './navigation.component.html',
  styleUrl: './navigation.component.css'
})
export class NavigationComponent {

  constructor(private _router: Router){}

  goToHomePage() {
    console.log("Go to home");
    this._router.navigate(["home"]);
    
  }

  goToGamesPage() {
    console.log("Go to games");
    this._router.navigate(["games"]);
  }
}
