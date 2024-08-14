import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {LoginResponse} from "./models/login-response.model";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private _http: HttpClient) {
  }

  login(username: string, password: string): Observable<LoginResponse> {
    const loginUrl = `${environment.baseUrl}${environment.loginEndpoint}`;

    const loginDetail = {
      username: username,
      password: password
    }

    return this._http.post<LoginResponse>(loginUrl, loginDetail);
  }

  register(username: string, password: string, email: string, fullName: string): Observable<void> {
    const registerUrl = `${environment.baseUrl}${environment.registerEndpoint}`;

    const registerDetail = {
      username: username,
      password: password,
      email: email,
      fullName: fullName,
    }

    return this._http.post<void>(registerUrl, registerDetail);
  }


}
