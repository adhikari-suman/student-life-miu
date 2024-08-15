import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Anime} from "./anime.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AnimeService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Anime[]> {
    const url = `${environment.baseUrl}${environment.getAnimePaginatedEndpoint()}`;

    return this.http.get<Anime[]>(url);

  }

  getOne(id: string): Observable<Anime> {
    const url = `${environment.baseUrl}${environment.animeByIdEndpoint(id)}`;

    return this.http.get<Anime>(url);
  }

  addOne(anime: Anime): Observable<void> {
    const url = `${environment.baseUrl}${environment.animeEndpoint}`;

    return this.http.post<void>(url, anime);
  }

  updateOne(id: string, anime: any): Observable<void> {
    const url = `${environment.baseUrl}${environment.animeByIdEndpoint(id)}`;

    return this.http.put<void>(url, anime);
  }

  deleteOne(id: string): Observable<void> {
    const url = `${environment.baseUrl}${environment.animeByIdEndpoint(id)}`;

    return this.http.delete<void>(url);
  }
}
