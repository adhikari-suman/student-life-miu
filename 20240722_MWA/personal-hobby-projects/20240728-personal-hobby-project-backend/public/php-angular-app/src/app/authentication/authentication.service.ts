import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {LoginResponse} from "./models/login-response.model";
import {RegisterRequest} from "./models/register-request.model";

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

  register(registerRequest: RegisterRequest): Observable<void> {
    const registerUrl = `${environment.baseUrl}${environment.registerEndpoint}`;

    return this._http.post<void>(registerUrl, registerRequest);
  }


}
