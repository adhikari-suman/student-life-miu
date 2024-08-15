import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {AuthenticationModule} from "./authentication/authentication.module";
import {provideHttpClient, withInterceptors} from "@angular/common/http";
import {authenticationInterceptor} from "./authentication/authentication.interceptor";
import {CoreModule} from "./core/core.module";
import {AnimeModule} from "./anime/anime.module";

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
  ],
  providers: [provideHttpClient(
    withInterceptors([
      authenticationInterceptor
    ])
  )],
  bootstrap: [AppComponent]
})
export class AppModule {
}
