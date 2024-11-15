import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';

@Component({
  selector: 'app-template-1',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './template-with-two-way-binding.component.html',
  styleUrl: './template-with-two-way-binding.component.css'
})
export class TemplateWithTwoWayBindingComponent {

  // name: string = "Jack";
  // username: string = "jack123";
  // password: string = "123";
  // repeatPassword: string = "123";

  user = {
    name: "Jack",
    username: "jack123",
    password: "123",
    repeatPassword: "123",
  };

  register(form: NgForm) {
    console.log("Register clicked");
    console.log(form.value);
  }

}
