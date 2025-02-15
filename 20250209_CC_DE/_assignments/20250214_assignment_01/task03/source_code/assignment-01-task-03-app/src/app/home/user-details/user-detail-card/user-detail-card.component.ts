import {Component, Input} from '@angular/core';
import {UserProfile} from '../../user-details-response.model';
import {CommonModule, NgForOf} from '@angular/common';

@Component({
  selector: 'app-user-detail-card',
  imports: [
    CommonModule,
    NgForOf,
  ],
  templateUrl: './user-detail-card.component.html',
  styleUrl: './user-detail-card.component.scss',
  standalone: true,
})
export class UserDetailCardComponent {
  @Input({required: true}) profile!: UserProfile;
}
