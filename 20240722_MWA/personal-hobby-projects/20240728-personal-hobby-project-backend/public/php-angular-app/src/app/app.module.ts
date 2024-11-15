import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {AuthenticationModule} from "./authentication/authentication.module";
import {provideHttpClient, withInterceptors} from "@angular/common/http";
import {authenticationInterceptor} from "./authentication/authentication.interceptor";
import {CoreModule} from "./core/core.module";
import {AnimeModule} from "./anime/anime.module";
import {provideAnimationsAsync} from '@angular/platform-browser/animations/async';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AuthenticationModule,
    CoreModule,
    AnimeModule,
    BrowserAnimationsModule,
  ],
  providers: [provideHttpClient(
    withInterceptors([
      authenticationInterceptor
    ])
  ), provideAnimationsAsync()],
  bootstrap: [AppComponent]
})
export class AppModule {
}
