import {Component, Input, input, ViewEncapsulation} from '@angular/core';
import {UserDetails} from '../user-details-response.model';
import {UserProfileComponent} from './user-profile/user-profile.component';
import {FriendsListComponent} from './friends/friends-list.component';

@Component({
  selector: 'app-user-details',
  imports: [
    UserProfileComponent,
    FriendsListComponent
  ],
  templateUrl: './user-details.component.html',
  styleUrl: './user-details.component.scss',
  standalone: true,
  encapsulation: ViewEncapsulation.Emulated
})
export class UserDetailsComponent {
    @Input({required: true}) userDetails!: UserDetails;
}
