import {Component} from '@angular/core';
import {AuthenticationService} from "../../authentication/authentication.service";

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrl: './navigation.component.css'
})
export class NavigationComponent {
  get isLoggedIn(): boolean {
    return this._authenticationService.token === null || this._authenticationService.token.length !== 0;
  }

  constructor(private _authenticationService: AuthenticationService) {
  }

  logout() {
    this._authenticationService.removeToken();
  }
}
