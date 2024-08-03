import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-reactive',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './reactive.component.html',
  styleUrl: './reactive.component.css'
})
export class ReactiveComponent implements OnInit {
  registrationForm!: FormGroup;

  constructor(private _formBuilder: FormBuilder){}

  ngOnInit(): void {
    this.registrationForm = new FormGroup({
      name: new FormControl("jack"),
      // name: new FormControl("jack"), () for empty
      username: new FormControl("jack123"),
      password: new FormControl("123"),
      repeatPassword: new FormControl("123"),
    });

    // this.registrationForm = this._formBuilder.group({
    //     name: "jack", // null for empty
    //   username:"jack123",
    //   password: "123",
    //   repeatPassword: "123",
    // });
  }

  register() { 
    console.log("register clicked");
    console.log(this.registrationForm.value);
    
  }

  // using form as input
  register1(form:FormGroup) { 
    console.log("register clicked");
    console.log(this.registrationForm.value);
    
  }
}
