import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';


// TODO: Copy from slides later
class Game {
  constructor(public id:String, public title:String, public price:number){}
}

@Component({
  selector: 'app-games',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './games.component.html',
  styleUrl: './games.component.css'
})
export class GamesComponent {

  games :Game[]= [
    new Game("111", "Dice Forge", 25.00),
    new Game("222", "Catan", 45.00),
    new Game("333", "Dice Throne", 24.99),
  ]

}
