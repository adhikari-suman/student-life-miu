import {Anime} from "./anime.model";
import {Pagination} from "./pagination.model";

export class PaginatedAnimeResponse {

  constructor(public anime: Anime[], public pagination: Pagination) {
  }
}
