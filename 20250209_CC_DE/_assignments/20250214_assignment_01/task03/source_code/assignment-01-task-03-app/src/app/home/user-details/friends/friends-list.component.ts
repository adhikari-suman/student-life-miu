import {Component, Input} from '@angular/core';
import {UserProfile} from '../../user-details-response.model';
import {FriendItemComponent} from './friends-list-item/friend-item.component';
import {NgForOf} from '@angular/common';

@Component({
  selector: 'app-friends',
  imports: [
    FriendItemComponent,
    NgForOf
  ],
  templateUrl: './friends-list.component.html',
  styleUrl: './friends-list.component.scss',
  standalone: true,
})
export class FriendsListComponent {
    @Input({required: true}) friends!: [UserProfile];
}
