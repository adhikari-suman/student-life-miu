import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {AuthenticationService} from "../authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private authenticationService: AuthenticationService,
              private router: Router
  ) {
  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: new FormControl(null),
      password: new FormControl(null),
    });

  }

  loginPressed() {
    this.authenticationService.login(
      this.loginForm.value.username,
      this.loginForm.value.password,
    ).subscribe((detail) => {
      this.loginForm.reset();

      this.authenticationService.token = detail.token;

      this.router.navigate(['home']);
    });
  }
}
