import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-child',
  standalone: true,
  imports: [],
  templateUrl: './child.component.html',
  styleUrl: './child.component.css'
})
export class ChildComponent {
  @Input() x: number = 1;
  @Input() y: number = 2;

  z: number = 0;

  @Output()
  addEvent:EventEmitter<number> = new EventEmitter();

  add() {
    this.z = this.x + this.y;

    this.addEvent.emit(this.z);
  }
}
