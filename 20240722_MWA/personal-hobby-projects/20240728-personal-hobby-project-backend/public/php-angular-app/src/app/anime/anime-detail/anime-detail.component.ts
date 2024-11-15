import {Component, OnInit} from '@angular/core';
import {Anime} from "../anime.model";
import {AnimeService} from "../anime.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthenticationService} from "../../authentication/authentication.service";

@Component({
  selector: 'app-anime-detail',
  templateUrl: './anime-detail.component.html',
  styleUrl: './anime-detail.component.css'
})
export class AnimeDetailComponent implements OnInit {

  animeDetail: Anime | null = null;

  constructor(
    private _animeService: AnimeService,
    private _activatedRoute: ActivatedRoute,
    private _authenticationService: AuthenticationService,
    private _router: Router,
  ) {
  }

  get isLoggedIn(): boolean {
    return this._authenticationService.isUserLoggedIn;
  }


  ngOnInit() {
    const animeId = this._activatedRoute.snapshot.params['id'];

    this._animeService.getOne(animeId).subscribe(anime => {
      this.animeDetail = anime;
    })
  }

  deletePressed(animeId: string) {
    this._animeService.deleteOne(animeId).subscribe(anime => {
      this._router.navigate(["anime"]);
    });
  }
}
