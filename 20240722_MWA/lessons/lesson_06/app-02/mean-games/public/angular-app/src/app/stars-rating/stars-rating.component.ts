import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'stars-rating',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './stars-rating.component.html',
  styleUrl: './stars-rating.component.css'
})
export class StarsRatingComponent {
  _rating: number = 5;
  stars:number[] = [];

  @Input()
  set rating(rating:number){
    this._rating = rating;
    this.stars = new Array<number>(rating);
  }
}
