import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ParentComponent } from './parent/parent.component';
import { ReactiveComponent } from './reactive/reactive.component';
import { TemplateWithTwoWayBindingComponent } from './template-with-two-way-binding/template-with-two-way-binding.component';
import { TemplateWithTemplateReferenceComponent } from './template-with-template-reference/template-with-template-reference.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, TemplateWithTwoWayBindingComponent, TemplateWithTemplateReferenceComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'angular-app';
}
