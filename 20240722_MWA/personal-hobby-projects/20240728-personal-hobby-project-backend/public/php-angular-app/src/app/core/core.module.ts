import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HeaderComponent} from "./header/header.component";
import {FooterComponent} from "./footer/footer.component";
import {NavigationComponent} from "./navigation/navigation.component";
import {ErrorComponent} from './error/error.component';
import {RouterLink} from "@angular/router";
import {AuthenticationModule} from "../authentication/authentication.module";


@NgModule({
    declarations: [
        HeaderComponent,
        FooterComponent,
        NavigationComponent,
        ErrorComponent,
    ],
    imports: [
        CommonModule,
        RouterLink,
        AuthenticationModule,
    ],
    exports: [
        HeaderComponent,
        FooterComponent,
        NavigationComponent,
        FooterComponent,
        ErrorComponent,
    ]
})
export class CoreModule {
}
