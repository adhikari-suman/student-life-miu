import {Component} from '@angular/core';
import {NgForm} from "@angular/forms";
import {RegisterRequest} from "../models/register-request.model";
import {AuthenticationService} from "../authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  constructor(private _router: Router, private _authenticationService: AuthenticationService) {
  }

  registerPressed(registrationForm: NgForm) {
    const registerRequest = new RegisterRequest(
      registrationForm.form.value.username,
      registrationForm.form.value.email,
      registrationForm.form.value.password,
      registrationForm.form.value.fullName,
    );

    this._authenticationService.register(registerRequest).subscribe(
      () => {
        this._router.navigate(['']);
      }
    );
  }
}
