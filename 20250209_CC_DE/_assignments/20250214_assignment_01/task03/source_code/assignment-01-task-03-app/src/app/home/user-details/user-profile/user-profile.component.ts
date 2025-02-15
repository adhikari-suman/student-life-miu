import {Component, Input} from '@angular/core';
import {UserDetails, UserProfile} from '../../user-details-response.model';
import {RouterOutlet} from '@angular/router';
import {CommonModule, NgForOf} from '@angular/common';
import {UserDetailCardComponent} from '../user-detail-card/user-detail-card.component';

@Component({
  selector: 'app-user-profile',
  imports: [
    CommonModule,
    UserDetailCardComponent
  ],
  templateUrl: './user-profile.component.html',
  standalone: true,
  styleUrl: './user-profile.component.scss'
})
export class UserProfileComponent {
  @Input({required: true}) profile!: UserProfile;
  protected readonly JSON = JSON;
}
