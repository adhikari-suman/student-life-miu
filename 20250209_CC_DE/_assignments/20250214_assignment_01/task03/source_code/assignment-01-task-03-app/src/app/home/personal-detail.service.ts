import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {UserDetailsResponse} from './user-details-response.model';

@Injectable({
  providedIn: 'root'
})
export class PersonalDetailService {
  protected readonly environment = environment;

  constructor(private _http: HttpClient) {
  }

  getPersonalDetails():Observable<UserDetailsResponse> {
    return this._http.get<UserDetailsResponse>(`${environment.apiUrl}`);
  }
}
