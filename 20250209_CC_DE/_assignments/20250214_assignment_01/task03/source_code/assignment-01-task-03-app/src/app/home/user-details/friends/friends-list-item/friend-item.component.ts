import {Component, Input} from '@angular/core';
import {UserProfile} from '../../../user-details-response.model';
import {NgForOf} from '@angular/common';
import {UserDetailCardComponent} from '../../user-detail-card/user-detail-card.component';

@Component({
  selector: 'app-friends-list-item',
  imports: [
    UserDetailCardComponent
  ],
  templateUrl: './friend-item.component.html',
  styleUrl: './friend-item.component.scss',
  standalone: true,
})
export class FriendItemComponent {
  @Input({required: true}) friend!: UserProfile;
}
