import {Component, OnInit} from '@angular/core';
import {AnimeService} from "../anime.service";
import {Anime} from "../anime.model";
import {Pagination} from "../pagination.model";

@Component({
  selector: 'app-anime-list',
  templateUrl: './anime-list.component.html',
  styleUrl: './anime-list.component.css'
})
export class AnimeListComponent implements OnInit {
  #anime: Anime[] = [];
  #pagination: Pagination = new Pagination();

  get anime(): Anime[] {
    return this.#anime;
  }

  set anime(value: Anime[]) {
    this.#anime = value;
  }

  get pagination() {
    return this.#pagination;
  }

  constructor(private _animeService: AnimeService) {
  }

  ngOnInit() {
    this._animeService.getPaginated().subscribe(paginatedResponse => {
      this.#anime = paginatedResponse.anime;
      this.#pagination = paginatedResponse.pagination;
    })
  }

  getAnimeData(page: number = 1, size: number = 10) {
    this._animeService.getPaginated(page, size).subscribe(paginatedResponse => {
      this.#anime = paginatedResponse.anime;
      this.#pagination = paginatedResponse.pagination;
    });
  }


  goToNextPage() {
    this.getAnimeData(this.#pagination.page + 1, this.#pagination.size);
  }

  goToPreviousPage() {
    this.getAnimeData(this.#pagination.page - 1, this.#pagination.size);
  }
}
