import { Injectable } from '@angular/core';
import { Game } from './games/games.component';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GamesDataService {

  private _baseUrl = 'http://localhost:3000';

  constructor(private _httpClient: HttpClient) { }


  getGames(): Observable<Game[]> {
    return this._httpClient.get<Game[]>(this._baseUrl+"/games")
  }

  getGame(gameId:string): Observable<Game> {
    return this._httpClient.get<Game>(this._baseUrl+"/games/"+gameId)
  }
}
