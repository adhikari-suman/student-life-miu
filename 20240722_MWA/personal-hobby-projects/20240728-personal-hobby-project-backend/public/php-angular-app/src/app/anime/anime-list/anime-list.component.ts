import {Component, OnInit} from '@angular/core';
import {AnimeService} from "../anime.service";
import {Anime} from "../anime.model";

@Component({
  selector: 'app-anime-list',
  templateUrl: './anime-list.component.html',
  styleUrl: './anime-list.component.css'
})
export class AnimeListComponent implements OnInit {
  #anime: Anime[] = [];

  get anime(): Anime[] {
    return this.#anime;
  }

  set anime(value: Anime[]) {
    this.#anime = value;
  }

  constructor(private _animeService: AnimeService) {
  }

  ngOnInit() {
    this._animeService.getAll().subscribe(animeList => {
      this.#anime = animeList;
    })
  }
}
