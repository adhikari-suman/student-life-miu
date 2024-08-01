import { Component, OnInit } from '@angular/core';
import { Game } from '../games/games.component';
import { CommonModule } from '@angular/common';
import { GamesDataService } from '../games-data.service';
import { ActivatedRoute } from '@angular/router';
import { StarsRatingComponent } from '../stars-rating/stars-rating.component';

@Component({
  selector: 'app-game',
  standalone: true,
  imports: [CommonModule, StarsRatingComponent],
  templateUrl: './game.component.html',
  styleUrl: './game.component.css'
})
export class GameComponent implements OnInit {
  game!: Game;

  constructor(private _gamesService: GamesDataService, private _activatedRoute: ActivatedRoute) {
    console.log("construct");
    
    this.game = new Game("", "", 0);
  }
  ngOnInit(): void {
    console.log(123);
    
    console.log(this._activatedRoute);

    const gameId: string = this._activatedRoute.snapshot.params["gameId"]
    console.log(gameId);
    this._gamesService.getGame(gameId).subscribe(
      game => { this.game = game }
    );
  }
}
