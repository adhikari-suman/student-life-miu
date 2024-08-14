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

  displayErrorMessage: boolean = false;
  displaySuccessMessage: boolean = false;
  successMessage: string | null = null;
  errorMessage: string | null = null;


  constructor(private _router: Router, private _authenticationService: AuthenticationService) {
  }

  registerPressed(registrationForm: NgForm) {
    const registerRequest = new RegisterRequest(
      registrationForm.form.value.username,
      registrationForm.form.value.email,
      registrationForm.form.value.password,
      registrationForm.form.value.fullName,
    );

    this._authenticationService.register(registerRequest).subscribe({
        next: () => {
          this.successMessage = 'User registered successfully';
          this.displaySuccessMessage = true;
          this.displayErrorMessage = false;
        },
        error: error => {
          this.errorMessage = 'User registration failed.';
          this.displaySuccessMessage = false;
          this.displayErrorMessage = true;
          console.log(error);
        },
        complete: () => {
          this._router.navigate(['login']);
        }
      }
    );
  }
}
