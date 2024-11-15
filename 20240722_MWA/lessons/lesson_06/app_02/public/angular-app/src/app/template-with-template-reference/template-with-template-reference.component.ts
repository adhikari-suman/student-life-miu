import { AfterContentInit, AfterViewChecked, AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';

@Component({
  selector: 'app-template-2',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './template-with-template-reference.component.html',
  styleUrl: './template-with-template-reference.component.css'
})
export class TemplateWithTemplateReferenceComponent implements OnInit {
  ngOnInit(): void {

    setTimeout(
      () => {
        this.registrationForm.setValue({
          name: "Jack",
          username: "jack123",
          password: "123",
          passwordRepeat: "123",
        });
      }, 0);


  }

  @ViewChild("registrationForm")
  registrationForm!: NgForm;

  register(form: NgForm) {

    console.log("Registration form", this.registrationForm);
    console.log("Register clicked");
    console.log(form.value);
  }
}
