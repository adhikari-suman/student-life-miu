import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {environment} from '../../environments/environment';
import {PersonalDetailService} from './personal-detail.service';
import {UserDetailsResponse} from './user-details-response.model';
import {CommonModule, NgSwitch, NgSwitchCase} from '@angular/common';
import {UserDetailsComponent} from './user-details/user-details.component';
import {CircularLoaderComponent} from '../core/loaders/circular-loader/circular-loader.component';


export enum AppState {
  INIT = 'initialized',
  LOADING = 'loading',
  FAILED = 'failed',
  SUCCESS = 'success',
}


export class HomeComponentState {
  state: AppState = AppState.INIT;
  response: UserDetailsResponse | null = null;
}

@Component({
  selector: 'app-home',
  imports: [
    NgSwitch,
    NgSwitchCase,
    CommonModule,
    UserDetailsComponent,
    CircularLoaderComponent,
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
  standalone: true,
  encapsulation: ViewEncapsulation.Emulated
})
export class HomeComponent implements OnInit {
  protected readonly environment = environment;

  protected componentState: HomeComponentState = new HomeComponentState();

  constructor(private _personalDetailService: PersonalDetailService) {}

  ngOnInit(): void {
    this.fetchUserDetails();
  }

  fetchUserDetails(): void {
    this.componentState = {
      state: AppState.LOADING,
      response: null,
    }

    this._personalDetailService.getPersonalDetails().subscribe({
      next: (response) => {
        this.componentState = {
          state: AppState.SUCCESS,
          response: response,
        }

        console.log(`Success`);
        console.dir(response);
      },
      error: (error) => {
        this.componentState = {
          state: AppState.FAILED,
          response: null,
        }

        console.log(`Failed`);
        console.dir(error);
      }
    });
  }

  protected readonly AppState = AppState;
}
